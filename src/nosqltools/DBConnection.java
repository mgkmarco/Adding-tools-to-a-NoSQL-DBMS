/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nosqltools;

import com.mongodb.DB;
import com.mongodb.MongoClient;
import com.mongodb.MongoCommandException;
import com.mongodb.MongoCredential;
import com.mongodb.MongoTimeoutException;
import com.mongodb.ServerAddress;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;
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
    
    public boolean connect(String username, String password, String database) 
    {
        try
        {
            MongoCredential credential = MongoCredential.createCredential(username, database, password.toCharArray());
            mongoClient = new MongoClient(new ServerAddress(), Arrays.asList(credential));
            db = mongoClient.getDB(database);
            
            boolean auth = db.authenticate(username, password.toCharArray());
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
            DefaultMutableTreeNode root = new DefaultMutableTreeNode("localhost");
            DefaultMutableTreeNode child_dbname;
            DefaultMutableTreeNode child_dbcollection;
            dt = new DefaultTreeModel(root);

            List<String> dbList = mongoClient.getDatabaseNames();
            for (String dbname : dbList)
            {
                child_dbname = new DefaultMutableTreeNode(dbname);

                DB db = mongoClient.getDB(dbname);
                Set<String> setNames = db.getCollectionNames();
                List<String> collectionNames = new ArrayList<>(setNames);
                for (final String s : collectionNames)
                {
                    child_dbcollection = new DefaultMutableTreeNode(s);

                    dt.insertNodeInto(child_dbcollection, child_dbname, collectionNames.indexOf(s));
                }
                dt.insertNodeInto(child_dbname, root, dbList.indexOf(dbname));
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
    
    //this method return json data found in the collection to be loaded in Panel_Text
    public StringBuilder getCollectionData(String coll)
    {
        StringBuilder res = new StringBuilder();
        DBCollection collection = db.getCollection(coll);
        DBCursor cursor = collection.find();
	while(cursor.hasNext()) {
            DBObject obj = cursor.next();
            res.append(obj);
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
}
