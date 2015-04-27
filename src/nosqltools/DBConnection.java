/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nosqltools;

import com.mongodb.DB;
import com.mongodb.MongoClient;
import com.mongodb.MongoTimeoutException;
import java.net.UnknownHostException;
import java.util.ArrayList;
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
    
    public boolean connect() 
    {
        try
        {
            mongoClient = new MongoClient();
        }
        catch (UnknownHostException e)
        {
            return false;
        }
        
        return true;
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
        mongoClient.close();
    }
}
