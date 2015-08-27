/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nosqltools;

import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.MongoClient;
import java.net.UnknownHostException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 *
 * @author Ronald
 */
public class DropDBDialog {
    
        final JFrame parent = new JFrame();
        MongoClient mongoClient;
        DB db;
        
        public DropDBDialog(){
    
            parent.pack();
            parent.setVisible(false);
        }
        
        protected void DropDB(String databaseName)
        {
            JOptionPane.showConfirmDialog(null, "Do you really want to delete " + databaseName + "!", "Drop Database",JOptionPane.YES_NO_OPTION);
            try {
                mongoClient = new MongoClient();
                mongoClient.dropDatabase(databaseName);
            } catch (UnknownHostException ex) {
                Logger.getLogger(CreateDBDialog.class.getName()).log(Level.SEVERE, null, ex);
            }  
        }  
}
