/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nosqltools;

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
import com.mongodb.util.JSON;
import java.io.FileNotFoundException;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;

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
        collection = db.getCollection(coll);
        DBCursor cursor = collection.find();
        //Reference: http://www.codeconfuse.com/2014/03/mongodb-convert-data-getting-from.html
        JSON json = new JSON();
        String serialize = json.serialize(cursor);
        System.out.println(serialize);
        res.append(serialize);
            
        return res;
    }
    
    //create method to get list of collections for the current db
    public List<String> getAllCollections()
    {
        Set<String> setNames = db.getCollectionNames();
        List<String> collectionNames = new ArrayList<>(setNames);
        
        return collectionNames;
    }
    
    //saving a collection
    public void saveColl(String json)
    {
        BasicDBList objList = null;
        DBObject obj = null;
        List<DBObject> documents = new ArrayList<>();
        //while ()
        //{
        //    obj = (DBObject)JSON.parse(json);
        //    documents.add(obj);
            
            //create basicDB objects
            // add them to basicDBList
        //}
        
        //DBObject obj = (DBObject)JSON.parse(json);
        
        
        //System.out.println(obj);
        //System.out.println(json);
        //collection.save(obj);
        
        for (int i=0; i < documents.size(); i++)
        {
            System.out.println(documents.get(i));
            collection.save(documents.get(i));
        }
        
    }
}
