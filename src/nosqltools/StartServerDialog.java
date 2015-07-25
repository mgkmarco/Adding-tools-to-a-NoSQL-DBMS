/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nosqltools;

import java.awt.Color;
import java.awt.Font;
import java.io.File;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

/**
 *
 * @author mgalea
 */
public class StartServerDialog extends javax.swing.JDialog {

    /**
     * Creates new form StartServerDialog
     */
    
    MainForm parent;
    
    public StartServerDialog(MainForm parent, boolean modal) {
        super(parent, modal);
        this.parent = parent;
        initComponents();
        setMongoDirectoryTextFieldDocumentListener();
        setDataDirectoryTextFieldDocumentListener();
        setLogDirectoryTextFieldDocumentListener();
        
        /**
         * Load any default properties from the app.config file...
         */
        setDefaultProperties();
    }

    /**
     * This method is called from within the constructor to initialize the form. WARNING: Do NOT modify this code. The content of this method is always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        locationFileChooser = new javax.swing.JFileChooser();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        dataDirectoryTF = new javax.swing.JTextField();
        logDirectoryTF = new javax.swing.JTextField();
        selectDataDirButton = new javax.swing.JButton();
        selectLogDirButton = new javax.swing.JButton();
        cancelButton = new javax.swing.JButton();
        startButton = new javax.swing.JButton();
        saveDefaultDBPath = new javax.swing.JCheckBox();
        saveDefaultLogPath = new javax.swing.JCheckBox();
        saveDefaultMongoPath = new javax.swing.JCheckBox();
        selectMongoDirButton = new javax.swing.JButton();
        mongoDirectoryTF = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        messageLabel = new javax.swing.JLabel();

        locationFileChooser.setCurrentDirectory(new File(System.getProperty("user.dir")));
        locationFileChooser.setFileSelectionMode(javax.swing.JFileChooser.DIRECTORIES_ONLY);

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Start MongoDB Server");
        setResizable(false);

        jScrollPane1.setBackground(new java.awt.Color(214, 217, 223));
        jScrollPane1.setBorder(null);
        jScrollPane1.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        jScrollPane1.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);

        jTextArea1.setBackground(new java.awt.Color(214, 217, 223));
        jTextArea1.setColumns(20);
        jTextArea1.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jTextArea1.setLineWrap(true);
        jTextArea1.setRows(5);
        jTextArea1.setText("MongoDB requires a data directory to store all data and a log directory to store log files. \n\nTherefore if this is the FIRST TIME that the Server is going to be started, please do create the following dirs before attempting to switch on:\n\t\t~\\data\\db\n\t\t~\\data\\log\\<*.log> (ex:~data\\log\\mongod.log)\n\nYou may make use of the below File Explorers so as to either create or select the respective directories mentioned above:\n ");
        jTextArea1.setWrapStyleWord(true);
        jTextArea1.setBorder(null);
        jTextArea1.setFocusable(false);
        jScrollPane1.setViewportView(jTextArea1);

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel1.setText("Select the data directory location:");
        jLabel1.setFocusable(false);

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel2.setText("Select the logs directory location:");
        jLabel2.setFocusable(false);

        selectDataDirButton.setText("Select");
        selectDataDirButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                selectDataDirButtonActionPerformed(evt);
            }
        });

        selectLogDirButton.setText("Select");
        selectLogDirButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                selectLogDirButtonActionPerformed(evt);
            }
        });

        cancelButton.setText("Cancel");
        cancelButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelButtonActionPerformed(evt);
            }
        });

        startButton.setText("Start");
        startButton.setEnabled(false);
        startButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                startButtonActionPerformed(evt);
            }
        });

        saveDefaultDBPath.setSelected(true);
        saveDefaultDBPath.setText("Save as default");

        saveDefaultLogPath.setSelected(true);
        saveDefaultLogPath.setText("Save as defaiult");

        saveDefaultMongoPath.setSelected(true);
        saveDefaultMongoPath.setText("Save as default");

        selectMongoDirButton.setText("Select");
        selectMongoDirButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                selectMongoDirButtonActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel3.setText("Select the MongoDB bin location:");
        jLabel3.setFocusable(false);

        messageLabel.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        messageLabel.setForeground(new java.awt.Color(0, 204, 0));
        messageLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        messageLabel.setFocusable(false);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 196, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1)
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 188, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cancelButton, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(mongoDirectoryTF, javax.swing.GroupLayout.DEFAULT_SIZE, 249, Short.MAX_VALUE)
                            .addComponent(logDirectoryTF, javax.swing.GroupLayout.DEFAULT_SIZE, 249, Short.MAX_VALUE)
                            .addComponent(dataDirectoryTF, javax.swing.GroupLayout.DEFAULT_SIZE, 249, Short.MAX_VALUE)
                            .addComponent(messageLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(selectMongoDirButton, javax.swing.GroupLayout.DEFAULT_SIZE, 76, Short.MAX_VALUE)
                            .addComponent(selectDataDirButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(selectLogDirButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(saveDefaultDBPath)
                            .addComponent(saveDefaultLogPath, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(saveDefaultMongoPath)
                            .addComponent(startButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 154, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(saveDefaultMongoPath)
                    .addComponent(selectMongoDirButton)
                    .addComponent(mongoDirectoryTF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel1)
                        .addComponent(dataDirectoryTF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(saveDefaultDBPath))
                    .addComponent(selectDataDirButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(selectLogDirButton)
                    .addComponent(logDirectoryTF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2)
                    .addComponent(saveDefaultLogPath))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(startButton, javax.swing.GroupLayout.DEFAULT_SIZE, 36, Short.MAX_VALUE)
                            .addComponent(cancelButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addContainerGap())
                    .addComponent(messageLabel, javax.swing.GroupLayout.Alignment.TRAILING)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cancelButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelButtonActionPerformed
        this.dispose();
    }//GEN-LAST:event_cancelButtonActionPerformed

    private void selectMongoDirButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_selectMongoDirButtonActionPerformed
        locationFileChooser.setFileSelectionMode(javax.swing.JFileChooser.DIRECTORIES_ONLY);
        int selectResult = locationFileChooser.showOpenDialog(this);
        
        switch(selectResult)
        {
            case JFileChooser.APPROVE_OPTION:
            {
                mongoDirectoryTF.setText(locationFileChooser.getSelectedFile().getPath());
                break;
            }
            
            default:
                break;
        }
    }//GEN-LAST:event_selectMongoDirButtonActionPerformed

    private void selectDataDirButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_selectDataDirButtonActionPerformed
        locationFileChooser.setFileSelectionMode(javax.swing.JFileChooser.DIRECTORIES_ONLY);
        int selectResult = locationFileChooser.showOpenDialog(this);
        
        switch(selectResult)
        {
            case JFileChooser.APPROVE_OPTION:
            {
                dataDirectoryTF.setText(locationFileChooser.getSelectedFile().getPath());
                break;
            }
            
            default:
                break;
        }
    }//GEN-LAST:event_selectDataDirButtonActionPerformed

    private void selectLogDirButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_selectLogDirButtonActionPerformed
        locationFileChooser.setFileSelectionMode(javax.swing.JFileChooser.FILES_ONLY);
        int selectResult = locationFileChooser.showOpenDialog(this);
        
        switch(selectResult)
        {
            case JFileChooser.APPROVE_OPTION:
            {
                logDirectoryTF.setText(locationFileChooser.getSelectedFile().getPath());
                break;
            }
            
            default:
                break;
        }
    }//GEN-LAST:event_selectLogDirButtonActionPerformed

    private void startButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_startButtonActionPerformed
        /**
         * To use to save properites to app.config if any save default is selected...
         */
        PropertiesController propCntrl = new PropertiesController();        
        
        if(saveDefaultMongoPath.isSelected())
        {
            propCntrl.writeConfigFile(Initializations.MONGO_BIN_PATH, mongoDirectoryTF.getText());
        }
        
        if(saveDefaultDBPath.isSelected())
        {
            propCntrl.writeConfigFile(Initializations.DB_STORAGE_PATH, dataDirectoryTF.getText());
        }
        
        if(saveDefaultLogPath.isSelected())
        {
            propCntrl.writeConfigFile(Initializations.LOG_STORAGE_PATH, logDirectoryTF.getText());
        }
        
        ServerController sc = new ServerController();
        int retVal = sc.startServer(mongoDirectoryTF.getText(), dataDirectoryTF.getText(), logDirectoryTF.getText());
        
        switch(retVal)
        {
            case 999: //location for the bin could not be resolved...
            {
                JOptionPane.showMessageDialog(this, Initializations.BINLOCATIONERROR, Initializations.LOCATIONERROR, JOptionPane.WARNING_MESSAGE);
                messageLabel.setForeground(Color.RED);
                messageLabel.setFont(new Font("Tahoma", Font.BOLD, 12));
                messageLabel.setText(Initializations.ERRORMESSAGE);
                break;
            }
            
            case 888: //location for the dbpath does not exist...
            {
                JOptionPane.showMessageDialog(this, Initializations.DBPATHERROR, Initializations.LOCATIONERROR, JOptionPane.WARNING_MESSAGE);
                messageLabel.setForeground(Color.RED);
                messageLabel.setFont(new Font("Tahoma", Font.BOLD, 12));
                messageLabel.setText(Initializations.ERRORMESSAGE);
                break;
            }
            
            case 777: //location for the log does not exist...
            {
                JOptionPane.showMessageDialog(this, Initializations.LOGLOCATIONERROR, Initializations.LOCATIONERROR, JOptionPane.WARNING_MESSAGE);
                messageLabel.setForeground(Color.RED);
                messageLabel.setFont(new Font("Tahoma", Font.BOLD, 12));
                messageLabel.setText(Initializations.ERRORMESSAGE);
                break;
            }
            
            case 0: //Success
            {
                JOptionPane.showMessageDialog(this, Initializations.SERVICEMONGODSTARTED, Initializations.SUCCESS, JOptionPane.INFORMATION_MESSAGE);
                messageLabel.setForeground(new Color(0,204,0));
                messageLabel.setFont(new Font("Tahoma", Font.BOLD, 12));
                messageLabel.setText(Initializations.SUCCESSMESSAGELABEL);
                this.parent.startServerMenuItem.setEnabled(false);
                break;
            }
            
            case -1: //Caught exception...
            {
                JOptionPane.showMessageDialog(this, Initializations.EXCEPTIONMESSAGE + sc.ExceptionMessage, Initializations.ERROR, JOptionPane.WARNING_MESSAGE);
                messageLabel.setForeground(Color.RED);
                messageLabel.setFont(new Font("Tahoma", Font.BOLD, 12));
                messageLabel.setText(Initializations.ERRORMESSAGE);
                break;
            }
            
            default:
            {
                JOptionPane.showMessageDialog(this, Initializations.EXCEPTIONMESSAGE + sc.ExceptionMessage, Initializations.ERROR, JOptionPane.WARNING_MESSAGE);
                messageLabel.setForeground(Color.RED);
                messageLabel.setFont(new Font("Tahoma", Font.BOLD, 12));
                messageLabel.setText(Initializations.ERRORMESSAGE);
                break;
            }
        }
    }//GEN-LAST:event_startButtonActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(StartServerDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(StartServerDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(StartServerDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(StartServerDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                StartServerDialog dialog = new StartServerDialog(new MainForm(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }
    
    private void setDefaultProperties()
    {
        PropertiesController propsCntrl = new PropertiesController();
        String mongoBinDefault = propsCntrl.getProperties(Initializations.MONGO_BIN_PATH);
        String dbDirectoryDefault = propsCntrl.getProperties(Initializations.DB_STORAGE_PATH);
        String logDirectoryDefault = propsCntrl.getProperties(Initializations.LOG_STORAGE_PATH);
        
        if(mongoBinDefault != null)
        {
            mongoDirectoryTF.setText(mongoBinDefault);
        }
        
        if(dbDirectoryDefault != null)
        {
            dataDirectoryTF.setText(dbDirectoryDefault);
        }
        
        if(logDirectoryDefault != null)
        {
            logDirectoryTF.setText(logDirectoryDefault);
        }
    }
    
    private void setMongoDirectoryTextFieldDocumentListener()
    {
        mongoDirectoryTF.getDocument().addDocumentListener(new DocumentListener() 
        {
            public void changedUpdate(DocumentEvent e) 
            {
                if(dataDirectoryTF.getText().length() > 0 && logDirectoryTF.getText().length() > 0)
                {
                    if(mongoDirectoryTF.getText().length() > 0)
                    {
                        startButton.setEnabled(true);
                    }
                    else
                    {
                        startButton.setEnabled(false);
                    }
                }
                else
                {
                    startButton.setEnabled(false);
                }
            }
            
            public void removeUpdate(DocumentEvent e) 
            {
                if(dataDirectoryTF.getText().length() > 0 && logDirectoryTF.getText().length() > 0)
                {
                    if(mongoDirectoryTF.getText().length() > 0)
                    {
                        startButton.setEnabled(true);
                    }
                    else
                    {
                        startButton.setEnabled(false);
                    }
                }
                else
                {
                    startButton.setEnabled(false);
                }
            }
            
            public void insertUpdate(DocumentEvent e) 
            {
                if(dataDirectoryTF.getText().length() > 0 && logDirectoryTF.getText().length() > 0)
                {
                    if(mongoDirectoryTF.getText().length() > 0)
                    {
                        startButton.setEnabled(true);
                    }
                    else
                    {
                        startButton.setEnabled(false);
                    }
                }
                else
                {
                    startButton.setEnabled(false);
                }
            }
        });
    }
    
    private void setDataDirectoryTextFieldDocumentListener()
    {
        dataDirectoryTF.getDocument().addDocumentListener(new DocumentListener() 
        {
            public void changedUpdate(DocumentEvent e) 
            {
                if(mongoDirectoryTF.getText().length() > 0 && logDirectoryTF.getText().length() > 0)
                {
                    if(dataDirectoryTF.getText().length() > 0)
                    {
                        startButton.setEnabled(true);
                    }
                    else
                    {
                        startButton.setEnabled(false);
                    }
                }
                else
                {
                    startButton.setEnabled(false);
                }
            }
            
            public void removeUpdate(DocumentEvent e) 
            {
                if(mongoDirectoryTF.getText().length() > 0 && logDirectoryTF.getText().length() > 0)
                {
                    if(dataDirectoryTF.getText().length() > 0)
                    {
                        startButton.setEnabled(true);
                    }
                    else
                    {
                        startButton.setEnabled(false);
                    }
                }
                else
                {
                    startButton.setEnabled(false);
                }
            }
            
            public void insertUpdate(DocumentEvent e) 
            {
                if(mongoDirectoryTF.getText().length() > 0 && logDirectoryTF.getText().length() > 0)
                {
                    if(dataDirectoryTF.getText().length() > 0)
                    {
                        startButton.setEnabled(true);
                    }
                    else
                    {
                        startButton.setEnabled(false);
                    }
                }
                else
                {
                    startButton.setEnabled(false);
                }
            }
        });
    }
    
    private void setLogDirectoryTextFieldDocumentListener()
    {
        logDirectoryTF.getDocument().addDocumentListener(new DocumentListener() 
        {
            public void changedUpdate(DocumentEvent e) 
            {
                if(mongoDirectoryTF.getText().length() > 0 && dataDirectoryTF.getText().length() > 0)
                {
                    if(logDirectoryTF.getText().length() > 0)
                    {
                        startButton.setEnabled(true);
                    }
                    else
                    {
                        startButton.setEnabled(false);
                    }
                }
                else
                {
                    startButton.setEnabled(false);
                }
            }
            
            public void removeUpdate(DocumentEvent e) 
            {
                if(mongoDirectoryTF.getText().length() > 0 && dataDirectoryTF.getText().length() > 0)
                {
                    if(logDirectoryTF.getText().length() > 0)
                    {
                        startButton.setEnabled(true);
                    }
                    else
                    {
                        startButton.setEnabled(false);
                    }
                }
                else
                {
                    startButton.setEnabled(false);
                }
            }
            
            public void insertUpdate(DocumentEvent e) 
            {
                if(mongoDirectoryTF.getText().length() > 0 && dataDirectoryTF.getText().length() > 0)
                {
                    if(logDirectoryTF.getText().length() > 0)
                    {
                        startButton.setEnabled(true);
                    }
                    else
                    {
                        startButton.setEnabled(false);
                    }
                }
                else
                {
                    startButton.setEnabled(false);
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton cancelButton;
    private javax.swing.JTextField dataDirectoryTF;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JFileChooser locationFileChooser;
    private javax.swing.JTextField logDirectoryTF;
    private javax.swing.JLabel messageLabel;
    private javax.swing.JTextField mongoDirectoryTF;
    private javax.swing.JCheckBox saveDefaultDBPath;
    private javax.swing.JCheckBox saveDefaultLogPath;
    private javax.swing.JCheckBox saveDefaultMongoPath;
    private javax.swing.JButton selectDataDirButton;
    private javax.swing.JButton selectLogDirButton;
    private javax.swing.JButton selectMongoDirButton;
    private javax.swing.JButton startButton;
    // End of variables declaration//GEN-END:variables
}
