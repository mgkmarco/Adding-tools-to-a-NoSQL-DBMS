/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nosqltools;

import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.MongoClient;
import com.mongodb.ServerAddress;
import java.awt.BorderLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.UnknownHostException;
import java.util.List;
import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.InputMap;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JRootPane;
import javax.swing.JTextField;
import javax.swing.KeyStroke;

public class AddUsersDialog extends JDialog {
    
    MongoClient mongoClient;
    DBCollection collection;
    DB db;
    
    private final JTextField tfUsername;
    private final JTextField tfPassword; 
    private final JComboBox<String> cbRoles;
    private final JComboBox<String> cbDatabases;

    private final JLabel lbUsername;
    private final JLabel lbPassword;
    private final JLabel lbDatabase;
    private final JLabel lbRole;

    private final JButton btnAdd;
    private final JButton btnCancel;
    private boolean succeeded;
    private boolean choice = false;
    private MainForm parent;
    
    public AddUsersDialog(MainForm parent) {
        this.parent = parent; 
        JPanel panel = new JPanel(new GridBagLayout());
        GridBagConstraints cs = new GridBagConstraints();
        
        try
        {
           mongoClient = new MongoClient(new ServerAddress("localhost", 27017)); 
        }
        catch(UnknownHostException ex)
        {
            ex.printStackTrace();
        }
  
        cs.fill = GridBagConstraints.HORIZONTAL;

        //The components used in the dialog box
        lbUsername = new JLabel("Username: ");
        cs.gridx = 0;
        cs.gridy = 0;
        cs.gridwidth = 1;
        panel.add(lbUsername, cs);

        tfUsername = new JTextField(20);
        cs.gridx = 1;
        cs.gridy = 0;
        cs.gridwidth = 2;
        panel.add(tfUsername, cs);      

        lbPassword = new JLabel("Password: ");
        cs.gridx = 0;
        cs.gridy = 1;
        cs.gridwidth = 1;
        panel.add(lbPassword, cs);

        tfPassword = new JPasswordField(20);
        cs.gridx = 1;
        cs.gridy = 1;
        cs.gridwidth = 2;
        panel.add(tfPassword, cs);
        
        lbDatabase = new JLabel("Database: ");
        cs.gridx = 0;
        cs.gridy = 2;
        cs.gridwidth = 1;
        panel.add(lbDatabase, cs);
        
        
        cbDatabases = new JComboBox<>();
        cbDatabases.setEditable(true);
        cs.gridx = 1;
        cs.gridy = 2;
        cs.gridwidth = 1;
        panel.add(cbDatabases, cs);  
        List<String> dbs = mongoClient.getDatabaseNames();
        for (String d : dbs) {
            cbDatabases.addItem(d);
        }     
        
        lbRole = new JLabel("Role: ");
        cs.gridx = 0;
        cs.gridy = 3;
        cs.gridwidth = 1;
        panel.add(lbRole, cs);

        cbRoles = new JComboBox<>();
        cbRoles.addItem("read");
        cbRoles.addItem("readWrite");
        cs.gridx = 1;
        cs.gridy = 3;
        cs.gridwidth = 1;
        panel.add(cbRoles, cs);   
               
        btnAdd = new JButton("Add");
        this.getRootPane().setDefaultButton(btnAdd);
        
        btnAdd.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ostja();
            }
        });
        
        btnCancel = new JButton("Cancel");
        btnCancel.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                choice = false;
                succeeded = false;
                dispose();
            }
        });

        JPanel bp = new JPanel();
        //Add the buttons to the panel
        bp.add(btnAdd);
        bp.add(btnCancel);

        getContentPane().add(panel, BorderLayout.CENTER);
        getContentPane().add(bp, BorderLayout.PAGE_END);

        pack();
        setResizable(false);
        setLocationRelativeTo(parent);
    }

    private void ostja()
        {
            if(getUsername().equals("") || getPassword().equals(""))
            {
                JOptionPane.showMessageDialog(null, Initializations.BLANK_USERNAME_AND_PASSWORD, Initializations.UNABLE_TO_CREATE_USER, JOptionPane.WARNING_MESSAGE);
            }
            else if(getUsername().equals(getPassword()))
            {
                JOptionPane.showMessageDialog(null, Initializations.SAME_USER_NAME_AND_PASSWORD, Initializations.UNABLE_TO_CREATE_USER, JOptionPane.WARNING_MESSAGE);
            }
            else{
                db = mongoClient.getDB(cbDatabases.getSelectedItem().toString());
                if(db.collectionExists("Default")){
                    boolean flag = false;
                    if(getRole().equals("read")){
                        flag = true;
                    }
                    db.addUser(getUsername(), getPassword().toCharArray() ,flag);
                    choice = false;
                }
                else{
                    db.createCollection("Default", new BasicDBObject());
                    boolean flag = false;
                    if(getRole().equals("read")){
                        flag = true;
                    }
                    db.addUser(getUsername(), getPassword().toCharArray() ,flag);
                    choice = false;
                }
                succeeded = true;
                
                if(parent.UsersScrollPane.isVisible())
                {
                    parent.viewUsersMenuItem.setEnabled(true);
                    parent.viewUsersMenuItem.doClick();
                    parent.viewUsersMenuItem.setEnabled(false);
                }
                
                dispose();
                }
        }
    
    /**
     * @return The text in the Username text field
     */
    public String getUsername() {
        return tfUsername.getText().trim();
    }
    
    /**
     * @return The text in the Database name text field
     */
     public String getRole() {
        return cbRoles.getSelectedItem().toString();
     }

    /**
    * @return The text in the Password text field
    */
    public String getPassword() {
        return tfPassword.getText().trim();
    }
    
    public String getDatabase(){
        return cbDatabases.getSelectedItem().toString();
    }

     /**
      * @return if the connection should be attempted or not
      */
     public boolean isToLogin() {
        return choice;
    }
     
    public boolean isSucceeded() {
        return succeeded;
    }
    
     protected JRootPane createRootPane() { 
        JRootPane rootPane = new JRootPane();
        KeyStroke stroke = KeyStroke.getKeyStroke("ESCAPE");
       
        Action actionListener = new AbstractAction() { 
          public void actionPerformed(ActionEvent actionEvent) { 
            setVisible(false);
          } 
        };
        
        //When the 'Esc' key is pressed on the keyboard, the window is destroyed
        InputMap inputMap = rootPane.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW);
        inputMap.put(stroke, "ESCAPE");
        rootPane.getActionMap().put("ESCAPE", actionListener);

        return rootPane;
  } 
}
