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
public class CreateDBDialog {
    
        final JFrame parent = new JFrame();
        MongoClient mongoClient;
        DB db;
        public CreateDBDialog(){
    
            parent.pack();
            parent.setVisible(false);

            CreateDB();
        }
        
        private void CreateDB()
        {
            String name = JOptionPane.showInputDialog(parent, "Enter database name:", "Create Database",3);
            
            try {
                mongoClient = new MongoClient();
                db = mongoClient.getDB(name);
                db.createCollection("Default", new BasicDBObject());
            } catch (UnknownHostException ex) {
                Logger.getLogger(CreateDBDialog.class.getName()).log(Level.SEVERE, null, ex);
            }  
        }  
        
        public String getName()
        {
            String name = db.getName();
            return name;
        }
}
