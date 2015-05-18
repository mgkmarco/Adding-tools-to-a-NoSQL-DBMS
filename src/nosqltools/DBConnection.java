/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nosqltools;

import com.fasterxml.jackson.databind.MappingIterator;
import com.jsontocsv.parser.JsonFlattener;
import com.jsontocsv.writer.CSVWriter;
import com.mongodb.BasicDBList;
import com.mongodb.DB;
import com.mongodb.MongoClient;
import com.mongodb.MongoCommandException;
import com.mongodb.MongoCredential;
import com.mongodb.MongoTimeoutException;
import com.mongodb.ServerAddress;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;
import com.mongodb.MongoException;
import com.mongodb.util.JSON;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.UnknownHostException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;
import net.sf.json.CDL;
import net.sf.json.JSONArray;
import net.sf.json.JSONException;
import net.sf.json.JSONObject;
import net.sf.json.JSONTokener;
import org.json.simple.JSONValue;

/**
 *
 * @author RebeccaKai
 */
public class DBConnection 
{
    private MongoClient mongoClient = null;
    private boolean success = false;
    DB db;
    DBCollection collection;
    JSONUtilities json_util = new JSONUtilities();
    
    public boolean connect(String username, String password, String database, String serveraddr, int port) 
    {
        try
        {
            MongoCredential credential = MongoCredential.createCredential(username, database, password.toCharArray());
          
            //if no server address has been specified, use localhost
            if ("".equals(serveraddr) || serveraddr == null)
                mongoClient = new MongoClient(new ServerAddress(), Arrays.asList(credential));
            else
                mongoClient = new MongoClient(new ServerAddress(serveraddr, port), Arrays.asList(credential));
                        
            db = mongoClient.getDB(database);
           
            boolean auth;
            try {
                auth = db.authenticate(username, password.toCharArray());
            }
            catch (Exception e)
            {
                auth = false;
            }
            return auth;
      
        }
        catch (UnknownHostException | MongoCommandException e)
        {
            return false;
        }
        
    }
    
    public boolean isConnectionSuccess()
    {
        return success;
    }
    
    public DefaultTreeModel buildDBTree () 
    {
        DefaultTreeModel dt = null;
        try 
        {
            DefaultMutableTreeNode root = new DefaultMutableTreeNode("DB " + db.getName());
            DefaultMutableTreeNode child_dbcollection;
            dt = new DefaultTreeModel(root);

            List<String> collectionNames = getAllCollections();
            for (final String s : collectionNames)
            {
                child_dbcollection = new DefaultMutableTreeNode(s);
                dt.insertNodeInto(child_dbcollection, root, collectionNames.indexOf(s));
            }
            success = true;
        }
        catch (MongoTimeoutException e)
        {
            success = false;
        }
        
        return dt;
    }
    
    public void closeConnection()
    {
        success = false;
        mongoClient.close();
    }
    
    public String import_CSV(String import_to_coll, String import_type, String import_location)
    {
        //StringBuilder sb = new StringBuilder();
        CDL cdl = new CDL();
               
        switch (import_type)
        {
            case "CSV":                
                try
                {
                    String content = new String(Files.readAllBytes(Paths.get(import_location)));
                    try
                    {
 
                        JSONArray array = cdl.toJSONArray(content);

                        return array.toString();
              
                    }
                    catch (JSONException e)
                    {
                        e.printStackTrace();
                    }
                }
                catch (IOException e)
                {
                    e.printStackTrace();
                }            
        }   
        return null;
    }
    
    public String export(String coll, String type, String location)
    {
        StringBuilder sb = new StringBuilder();
        sb = getCollectionData(coll);
        
        switch (type)
        {
            case "CSV":
        
            JsonFlattener parser = new JsonFlattener();
            CSVWriter writer = new CSVWriter();

            List<Map<String, String>> flatJson;
            try {
                flatJson = parser.parseJson(sb.toString());
                 writer.writeAsCSV(flatJson, location);
                 return "true";
            }
            catch (FileNotFoundException ex) {
                    Logger.getLogger(DBConnection.class.getName()).log(Level.SEVERE, null, ex);
                }
            catch (Exception ex)
            {
                Logger.getLogger(DBConnection.class.getName()).log(Level.SEVERE, null, ex);
            }
       
             return "false";
            
            case "TSV":
          
             return "false";
                
            case "JSON":
                return sb.toString();
               
        }
        
        return null;
    }
    
    //this method return json data found in the collection to be loaded in Panel_Text
    public StringBuilder getCollectionData(String coll)
    {
        StringBuilder res = new StringBuilder();
        if (checkSystemColl(coll))
        {
            collection = db.getCollection(coll);
            DBCursor cursor = collection.find();
            //Reference: http://www.codeconfuse.com/2014/03/mongodb-convert-data-getting-from.html
            JSON json = new JSON();
            String serialize = json.serialize(cursor);
            System.out.println(serialize);
            res.append(serialize);
        }
        else 
        {
            res = null;
        }
        
            
        return res;
    }
    
    //create method to get list of collections for the current db
    public List<String> getAllCollections()
    {
        Set<String> setNames = db.getCollectionNames();
        List<String> collectionNames = new ArrayList<>(setNames);
        
        return collectionNames;
    }
    
    public boolean checkSystemColl(String coll)
    {
        if (!coll.startsWith("system."))
            return true;
        
        else
            return false;
    }
    
    //Combination of getAllCollections() and checkSystemColl()
    public List<String> getAllCollectionsLessSystem()
    {
        Set<String> setNames = db.getCollectionNames();
        List<String> collectionNames = new ArrayList<>(setNames);
        List<String> collectionNamesLessSystem = new ArrayList<>();
        
        for (int i = 0; i < collectionNames.size(); i++)
        {
            if (checkSystemColl(collectionNames.get(i)))
            {
                collectionNamesLessSystem.add(collectionNames.get(i));
            }
        }
        
        return collectionNamesLessSystem;
    }
    
    //saving a collection
    public void saveColl(String json)
    {
        BasicDBList objList = null;
        List<Object> documents = new ArrayList<>();
        
        //get the string from text area and typecast to basic db list and dbobjects respectively
        objList = (BasicDBList)JSON.parse(json);
        
        //add objects to array list
        for (int i = 0; i<objList.size(); i++)
        {
            documents.add(objList.get(i));
            System.out.println(documents);
        }
        
        //save each document to collection
        for (int i=0; i < documents.size(); i++)
        {
            DBObject object = (DBObject) documents.get(i);
            collection.save(object);
        }     
    }
    
    public boolean insertInDatabase(String obj)
    {
        boolean flag = true;
        try{
            if(json_util.isArray(obj))
            {
                JOptionPane.showMessageDialog(null, "JSON Arrays are not allowed - Insert only one JSON object!", "Error", JOptionPane.ERROR_MESSAGE);
            }else{
                if(!obj.isEmpty())
                {
                    flag = false;
                    DBObject dbobj = (DBObject)JSON.parse(obj);
                    collection.insert(dbobj);
                    JOptionPane.showMessageDialog(null, "JSON Object " + dbobj +" has been added to Collection!", "Inserted Successfully", JOptionPane.INFORMATION_MESSAGE);
                }
            }
        }
        catch(MongoException me)
        {
             JOptionPane.showMessageDialog(null, me.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
        return flag;
    }
    
    public boolean updateDatabase(String obj1, String obj2)
    {
        boolean flag = false;
        try{
            if(json_util.isArray(obj1) || json_util.isArray(obj2))
            {
                JOptionPane.showMessageDialog(null, "JSON Arrays are not allowed - Change details for only one JSON object!", "Error", JOptionPane.ERROR_MESSAGE);
            }else{
                
                DBObject dbobj1 = (DBObject)JSON.parse(obj1);
                DBObject dbobj2 = (DBObject)JSON.parse(obj2);
                
                DBCursor cursor = collection.find(dbobj1);
                int count = cursor.count();
                
                if(cursor.count() == 0)
                {
                    flag = true;
                    JOptionPane.showMessageDialog(null, "JSON object " + dbobj1 + " does not exist in collection!", "Error", JOptionPane.ERROR_MESSAGE);
                }
                else{
                    while(count != 0)
                    {
                        while(cursor.hasNext()) {
                            System.out.println(cursor.next());
                        }

                        if(count != 0)
                            collection.update(dbobj1, dbobj2, true, false);
                        count-- ;
                    }
                    JOptionPane.showMessageDialog(null, "JSON Object " + dbobj2 +" has been updated to Collection!", "Updated Successfully", JOptionPane.INFORMATION_MESSAGE);
                }
            }
        }
        catch(MongoException me)
        {
             JOptionPane.showMessageDialog(null, me.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
        
        return flag;
    }
    
    public boolean deleteFromDatabase(String obj)
    {
        boolean flag = false;
         try{
            if(json_util.isArray(obj))
            {
                JOptionPane.showMessageDialog(null, "JSON Arrays are not allowed - Change details for only one JSON object!", "Error", JOptionPane.ERROR_MESSAGE);
            }else{
                
                DBObject dbobj = (DBObject)JSON.parse(obj);
                
                DBCursor cursor = collection.find(dbobj);
                int count = cursor.count();
                if(cursor.count() == 0)
                {
                    flag = true;
                    JOptionPane.showMessageDialog(null, "JSON object " + dbobj + " does not exist in collection!", "Error", JOptionPane.ERROR_MESSAGE);
                }
                else
                {
                    while(count != 0)
                    {
                        while(cursor.hasNext()) {
                            System.out.println(cursor.next());
                        }

                        if(count != 0)
                            collection.remove(dbobj);
                        count-- ;
                    }
                    JOptionPane.showMessageDialog(null, "JSON Object " + dbobj +" has been removed from Collection!", "Deleted Successfully", JOptionPane.INFORMATION_MESSAGE);
                }
            }
        }
        catch(MongoException me)
        {
             JOptionPane.showMessageDialog(null, me.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
        
         return flag;
    }
    
    public boolean findFromDatabase(String obj)
    {
        boolean flag = false;
        String result = "";
         try{
            if(json_util.isArray(obj))
            {
                JOptionPane.showMessageDialog(null, "JSON Arrays are not allowed - Change details for only one JSON object!", "Error", JOptionPane.ERROR_MESSAGE);
            }else{
                
                DBObject dbobj = (DBObject)JSON.parse(obj);
                
                DBCursor cursor = collection.find(dbobj);
                int count = cursor.count();
                if(cursor.count() == 0)
                {
                    flag = true;
                    JOptionPane.showMessageDialog(null, "JSON object " + dbobj + " does not exist in collection!", "Error", JOptionPane.ERROR_MESSAGE);
                }
                else
                {
                    while(count != 0)
                    {
                        while(cursor.hasNext()) {
                            System.out.println(cursor.next());
                        }

                        if(count != 0)
                        {
                            result += dbobj + "\n";
                        }
                        count-- ;
                    }
                    ResultForm results = new ResultForm(result, cursor.count());
                    results.setVisible(true);
                }
            }
        }
        catch(MongoException me)
        {
             JOptionPane.showMessageDialog(null, me.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
        
         return flag;
    }
    
    public boolean checkIfEmpty(String x)
    {
        return x.isEmpty();
    }
}
