package nosqltools;

import com.mongodb.DB;
import com.mongodb.MongoClient;
import java.net.UnknownHostException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;

public class ShowDatabases {
    
private MongoClient mongoClient;
  
    public ShowDatabases(){        
    }
    
   //This method returns a DefaultListModel with all the users from a database. 
   public DefaultListModel show_dbs(String currentDBName) {
       
       DefaultListModel listModel = new DefaultListModel();
         try {
              mongoClient = new MongoClient();
              List<String> dbs = mongoClient.getDatabaseNames();
               
              if (dbs.isEmpty())
              {
                  JOptionPane.showMessageDialog(null, Initializations.NODATABASESFOUND + " " + Initializations.CREATEDATABASE, Initializations.NODATABASESFOUNDERROR, JOptionPane.WARNING_MESSAGE);
              }
              else
              {
                    for (String name : dbs) {
                        
                        if(name.equals(currentDBName))
                        {
                            listModel.addElement(name + Initializations.CONNECTED_DB);
                        }
                        else
                        {
                            listModel.addElement(name);
                        }
                    }
              }
    } catch (UnknownHostException ex) {
        Logger.getLogger(GetUsersFromDB.class.getName()).log(Level.SEVERE, null, ex);
    }
            
            
   return listModel;
   } 
}
