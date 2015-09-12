package nosqltools;

import com.mongodb.BasicDBList;
import com.mongodb.BasicDBObject;
import com.mongodb.CommandResult;
import com.mongodb.DB;
import com.mongodb.MongoClient;
import java.net.UnknownHostException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultListModel;

public class GetUsersFromDB {
    
private MongoClient mongoClient;
private DB db;
    
    public GetUsersFromDB(){        
    }
    
   //This method returns a DefaultListModel with all the users from a database. 
   public DefaultListModel get_users(String dbName) {
       
       DefaultListModel listModel = new DefaultListModel();
         try {
                String username = "";
                mongoClient = new MongoClient();
                db = mongoClient.getDB(dbName);
                BasicDBObject dbStats = new BasicDBObject("usersInfo", 1);
                CommandResult command = db.command(dbStats);

                BasicDBList users = (BasicDBList) command.get("users");
                if (users.size() == 0) {
                    System.out.println("No users have yet been added to this database.");
                }
                else{
                    for (Object u : users) {
                         username = (String) ((BasicDBObject) u).get("user");
                         listModel.addElement(username);
                         }  
                }
        
    } catch (UnknownHostException ex) {
        Logger.getLogger(GetUsersFromDB.class.getName()).log(Level.SEVERE, null, ex);
    }
            
            
   return listModel;
   }
}
