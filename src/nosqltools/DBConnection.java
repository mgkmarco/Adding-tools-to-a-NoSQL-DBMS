/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nosqltools;

import com.jsontocsv.parser.JsonFlattener;
import com.jsontocsv.writer.CSVWriter;
import com.mongodb.BasicDBList;
import com.mongodb.BasicDBObject;
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

/**
 * This class is used to connect to the MongoDB 3.0 server 
 */
public class DBConnection 
{
    private MongoClient mongoClient = null;
    private boolean success = false;
    DB db;
    DBCollection collection;
    JSONUtilities json_util = new JSONUtilities();
    
    /**
     * Passed parameters are used to connect to the MongoDB 3.0 server
     * @param username
     * @param password
     * @param database
     * @param serveraddr The IP Address of the MongoDB Server
     * @param port The port on which the MongoDB Server is running
     * @return True if the connection to the MongoDB server is a success, else false
     */
    public boolean connect(String username, String password, String database, String serveraddr, int port) 
    {
        try
        {
            //If any of the parameters (username, password or DB name are empty, connection will not be attempted)
            if ("".equals(username.trim()) || "".equals(password.trim()) || "".equals(database.trim()))
                return false;
            
            //A mongocredential object is constructed using the username, password and DB name
            MongoCredential credential = MongoCredential.createCredential(username, database, password.toCharArray());
          
            //if no server address has been specified, use localhost
            if ("".equals(serveraddr) || serveraddr == null)
                mongoClient = new MongoClient(new ServerAddress(), Arrays.asList(credential));
            else
                mongoClient = new MongoClient(new ServerAddress(serveraddr, port), Arrays.asList(credential));
                    
            //The DB instance is stored
            db = mongoClient.getDB(database);
           
            //Authentication to the  DB is done below using the username and password supplied by the user
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
    
    /**
     * Checks if the DB connection is still alive.
     * @return true if a ping operation to the DB succeeds, else false.
     */
    public boolean checkDatabaseConnection()
    {
        DBObject ping = new BasicDBObject("ping", "1");
        try {
              db.command(ping);
              return true;
        } catch (MongoException e) {
            return false;
        }
    }
    
    /**
     * This method builds the JTree Default Tree Model using the collection names in the DB
     * so as to return it. This Default Tree Model is then added to the JTree in the 
     * Connections Panel to show the structure of the DB.
     * @return The Default Tree Model built using the collection names and DB name as root
     */
    public DefaultTreeModel buildDBTree () 
    {
        DefaultTreeModel dt = null;
        try 
        {
            //Set the root of the Tree as the DB name 
            DefaultMutableTreeNode root = new DefaultMutableTreeNode("DB " + db.getName());
            DefaultMutableTreeNode child_dbcollection;
            dt = new DefaultTreeModel(root);

            //Get the names of all collections in the DB as a list
            List<String> collectionNames = getAllCollections();
            
            //Iterate over the list of DB Collection names
            for (final String s : collectionNames)
            {
                //Create a new tree node using the name of the collection 
                //Insert this node into the tree by appending it to the root
                child_dbcollection = new DefaultMutableTreeNode(s);
                dt.insertNodeInto(child_dbcollection, root, collectionNames.indexOf(s));
            }
            success = true;
        }
        catch (MongoTimeoutException e)
        {
            success = false;
        }
        
        //Return the Default Tree Model
        return dt;
    }
    
    /**
     * Closes the connection to MongoDB server
     */
    public void closeConnection()
    {
        success = false;
        mongoClient.close();
    }
    
    /**
     * Imports a CSV file and converts it to JSON
     * @param import_to_coll The DB collection in which the file will be imported/appended to
     * @param import_type The type of file to import
     * @param import_location The location from local storage to import from
     * @return A string of JSON
     */
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
    
    /**
     * Exports a CSV/JSON file
     * @param coll The name of the DB Collection to be exported
     * @param type The type to export to
     * @param location The location on local store to export the file to
     * @return Returns true if the export to CSV was successful, false if the export to
     * CSV was unsuccessful, JSON string if export to JSON was successful or null if
     * unsuccessful
     */
    public String export(String coll, String type, String location)
    {
        StringBuilder sb = new StringBuilder();
        sb = getCollectionData(coll);
        
        switch (type)
        {
            //Export to CSV  
            case "CSV":
        
            JsonFlattener parser = new JsonFlattener();
            CSVWriter writer = new CSVWriter();

            List<Map<String, String>> flatJson;
            try {
                flatJson = parser.parseJson(sb.toString());
                 writer.writeAsCSV(flatJson, location);
                 //JSON export success to location specified
                 return "true";
            }
            catch (FileNotFoundException ex) {
                    Logger.getLogger(DBConnection.class.getName()).log(Level.SEVERE, null, ex);
                }
            catch (Exception ex)
            {
                Logger.getLogger(DBConnection.class.getName()).log(Level.SEVERE, null, ex);
            }
       
            //Export to CSV failed 
            return "false";
            
            //Export to JSON
            case "JSON":
                return sb.toString();
               
        }
        
        return null;
    }
    
    /**
     * This method returns JSON data found in the collection to be loaded in Panel_Text
     * 
     */
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
    
    /**
     * @return list of collections for the current DB
     */
    public List<String> getAllCollections()
    {
        Set<String> setNames = db.getCollectionNames();
        List<String> collectionNames = new ArrayList<>(setNames);
        
        return collectionNames;
    }
    
    /**
     * Checks if a collection name starts with "system." (a default Mongo System  collection)
     * @param coll The name of the collection to check
     * @return true if the collection does not start with "system.", else false
     */
    public boolean checkSystemColl(String coll)
    {
        if (!coll.startsWith("system."))
            return true;
        
        else
            return false;
    }
    /**
     * Combination of getAllCollections() and checkSystemColl()
     * @return A list of  DB collection names less the system collections
     */
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
    
    /**
     * Saves a collection to the DB
     * @param JSON string 
     */
    public void saveColl(String json)
    {                                                                                                                        
        BasicDBList objList = null;
        List<Object> documents = new ArrayList<>();
        
        //Get the string from text area and typecast to basic db list and dbobjects respectively
        objList = (BasicDBList)JSON.parse(json);
        
        //Add objects to array list
        for (int i = 0; i<objList.size(); i++)
        {
            documents.add(objList.get(i));
        }
        
        //Save each document to collection
        for (int i=0; i < documents.size(); i++)
        {
            DBObject object = (DBObject) documents.get(i);
            collection.save(object);
        }     
    }
    
    /**
     * Inserts a JSON objects into the collection
     * @param JSON object as a string
     * @return true if insert operation was unsuccessful, else false
     */
    public boolean insertInDatabase(String obj)
    {
        boolean flag = true;
        try{
            //If the object passed as a parameter is a JSON array, it is rejected
            if(json_util.isArray(obj))
            {
                JOptionPane.showMessageDialog(null, "JSON Arrays are not allowed - Insert only one JSON object!", "Error", JOptionPane.ERROR_MESSAGE);
            }
            else //If the object passed as a parameter is a JSON object
            {
                //If the object is not empty
                if(!obj.isEmpty())
                {
                    //Parse the object and insert into the collection
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
    
    /**
     * 
     * @param obj1
     * @param obj2
     * @return 
     */
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
    
    /**
     * Deletes a JSON object from the collection
     * @param obj JSON Objects to delete
     * @return True if unsuccessful operation, else false
     */
    public boolean deleteFromDatabase(String obj)
    {
        boolean flag = false;
         try{
            //If the object passed as a parameter is a JSON array, it is rejected
            if(json_util.isArray(obj))
            {
                JOptionPane.showMessageDialog(null, "JSON Arrays are not allowed - Change details for only one JSON object!", "Error", JOptionPane.ERROR_MESSAGE);
            }
            else //If the object passed as a parameter is a JSON object
            {
                //Parse the object and find it the collection. The results are stored in a cursor.
                DBObject dbobj = (DBObject)JSON.parse(obj);
                DBCursor cursor = collection.find(dbobj);
                int count = cursor.count();
                
                //If no  objects were found
                if(cursor.count() == 0)
                {
                    flag = true;
                    JOptionPane.showMessageDialog(null, "JSON object " + dbobj + " does not exist in collection!", "Error", JOptionPane.ERROR_MESSAGE);
                }
                else //if objects were found for deletion
                {
                    //Loop on the curser until it is equal to 0
                    while(count != 0)
                    {
                        while(cursor.hasNext()) {
                            cursor.next();
                        }

                        //Delete the object from the collection
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
