/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nosqltools;

import java.awt.BorderLayout;
import java.awt.Frame;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.InputMap;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JRootPane;
import javax.swing.JTextField;
import javax.swing.KeyStroke;

/**
 * This class is used to bring up the dialog box which is used to receive the login parameters
 * when attempting to connect to the Mongo DB server.
 */
public class LoginDialog extends JDialog {
    private final JTextField tfUsername;
    private final JPasswordField pfPassword;
    private final JTextField tfDatabase;
    private JTextField tfServerAddress;
    private JTextField tfPort;
    private final JLabel lbUsername;
    private final JLabel lbPassword;
    private final JLabel lbDatabase;
    private final JLabel lbServerAddress;
    private final JLabel lbPort;
    private final JButton btnLogin;
    private final JButton btnCancel;
    private boolean succeeded;
    private boolean choice = false;

    /**
     * Login Dialog Constructor
     * @param parent The Frame to which the JDialog will attach to
     */
    public LoginDialog(Frame parent) {
        super(parent, Initializations.DBCONNECT2MONGO, true);
       
        JPanel panel = new JPanel(new GridBagLayout());
        GridBagConstraints cs = new GridBagConstraints();

        cs.fill = GridBagConstraints.HORIZONTAL;

        //The components used in the dialog box
        lbUsername = new JLabel("Username: *");
        cs.gridx = 0;
        cs.gridy = 0;
        cs.gridwidth = 1;
        panel.add(lbUsername, cs);

        tfUsername = new JTextField(20);
        cs.gridx = 1;
        cs.gridy = 0;
        cs.gridwidth = 2;
        panel.add(tfUsername, cs);
      

        lbPassword = new JLabel("Password: *");
        cs.gridx = 0;
        cs.gridy = 1;
        cs.gridwidth = 1;
        panel.add(lbPassword, cs);

        pfPassword = new JPasswordField(20);
        cs.gridx = 1;
        cs.gridy = 1;
        cs.gridwidth = 2;
        panel.add(pfPassword, cs);
        
        lbDatabase = new JLabel("Database Name: *");
        cs.gridx = 0;
        cs.gridy = 2;
        cs.gridwidth = 1;
        panel.add(lbDatabase, cs);

        tfDatabase = new JTextField();
        cs.gridx = 1;
        cs.gridy = 2;
        cs.gridwidth = 2;
        panel.add(tfDatabase, cs);     
        
           
        lbServerAddress = new JLabel("Server Address: ");
        cs.gridx = 0;
        cs.gridy = 3;
        cs.gridwidth = 1;
        panel.add(lbServerAddress, cs);

        tfServerAddress = new JTextField();
        cs.gridx = 1;
        cs.gridy = 3;
        cs.gridwidth = 2;
        panel.add(tfServerAddress, cs);      
         
        lbPort = new JLabel("Port: ");
        cs.gridx = 0;
        cs.gridy = 4;
        cs.gridwidth = 1;
        panel.add(lbPort, cs);

        tfPort = new JTextField();
        cs.gridx = 1;
        cs.gridy = 4;
        cs.gridwidth = 2;
        panel.add(tfPort, cs);      


        btnLogin = new JButton("Login");
        
        btnLogin.addActionListener(new ActionListener() {

            /**
             * An event handler for the Login Button
             * @param e the on-click event
             */
            public void actionPerformed(ActionEvent e) { 
                
                //XOR: if both server IP address and port are not empty or one of them is empty
                if ((tfServerAddress.getText().trim().equals("") || tfPort.getText().trim().equals(""))  && !
                        ( tfServerAddress.getText().equals("") && tfPort.getText().trim().equals("")))
                {
                    //Login cannot go on; incorrect params
                    choice = false;
                    dispose();
                }
                else
                {
                    //Login can go on
                    choice = true;
                    dispose();
                }
            }
        });
               
        btnCancel = new JButton("Cancel");
        btnCancel.addActionListener(new ActionListener() {

            /**
             * When the cancel  button is clicked, dispose the window and do nothing
             * @param e The on-click event
             */
            public void actionPerformed(ActionEvent e) {
                choice = false;
                dispose();
            }
        });
     
        JPanel bp = new JPanel();
        //Adds the buttons to the panel
        bp.add(btnLogin);
        bp.add(btnCancel);

        getContentPane().add(panel, BorderLayout.CENTER);
        getContentPane().add(bp, BorderLayout.PAGE_END);

        pack();
        setResizable(false);
        setLocationRelativeTo(parent);
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
     public String getDatabase() {
        return tfDatabase.getText().trim();
    }

    /**
    * @return The text in the Password text field
    */
    public String getPassword() {
        return new String(pfPassword.getPassword());
    }
    
    /**
     * @return The text in the Server Address text field
     */
     public String getServerAddr() {
        return tfServerAddress.getText().trim();
    }
     
     /**
     * @return The port number entered by the user
     */
     public int getPort() {
         
        try 
        {
            return Integer.parseInt(tfPort.getText().trim());
        
        }
        catch (NumberFormatException e)
        {
            return -1;
        }
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
        } ;
        
        //When the 'Esc' key is pressed on the keyboard, the window is destroyed
        InputMap inputMap = rootPane.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW);
        inputMap.put(stroke, "ESCAPE");
        rootPane.getActionMap().put("ESCAPE", actionListener);

        return rootPane;
  } 
}
