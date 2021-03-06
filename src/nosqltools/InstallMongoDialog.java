/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nosqltools;

import java.awt.Color;
import java.io.File;
import java.util.List;
import javax.swing.JDialog;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.filechooser.FileNameExtensionFilter;

/**
 *
 * @author mgalea
 */
public class InstallMongoDialog extends javax.swing.JDialog {

    /**
     * Creates new form InstallMongoDialog
     */
    public InstallMongoDialog(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        
        /**
         * Had to add a custom DocumentListener to the path TextAreas
         * Since NetBeans won't let you 'alter' its auto-generated code,
         * and the windows builder doesn't have this event in-built...
         */
        setInstallerLocationTextFieldDocumentListener();
        setInstallerQuiteLocationTextFieldDocumentListener();
    }

    /**
     * This method is called from within the constructor to initialize the form. WARNING: Do NOT modify this code. The content of this method is always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        msiFileChooser = new javax.swing.JFileChooser();
        locationFileChooser = new javax.swing.JFileChooser();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        msiLabel = new javax.swing.JLabel();
        installerLocationTextField = new javax.swing.JTextField();
        browseToPathButton = new javax.swing.JButton();
        installButton = new javax.swing.JButton();
        cancelInstalButton = new javax.swing.JButton();
        statusLabel = new javax.swing.JLabel();
        quiteModeSelector = new javax.swing.JCheckBox();
        installLocationLabel = new javax.swing.JLabel();
        browseToInstallPathButton = new javax.swing.JButton();
        installerLocationQuiteTextField = new javax.swing.JTextField();
        mongoComponentSetLabel = new javax.swing.JLabel();
        allTB = new javax.swing.JCheckBox();
        customTB = new javax.swing.JCheckBox();
        componentSetScrollBar = new javax.swing.JScrollPane();
        componentSetList = new javax.swing.JList();

        msiFileChooser.setApproveButtonText("Select");
        msiFileChooser.setCurrentDirectory(new File(System.getProperty("user.dir")));
        msiFileChooser.setDialogTitle("Browse to *.MSI");
        msiFileChooser.setFileFilter(new FileNameExtensionFilter("MSI", "msi")
        );

        locationFileChooser.setApproveButtonToolTipText("");
        locationFileChooser.setCurrentDirectory(new File(System.getProperty("user.dir")));
        locationFileChooser.setFileSelectionMode(javax.swing.JFileChooser.DIRECTORIES_ONLY);

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Install MongoDB");
        setBackground(new java.awt.Color(214, 217, 223));
        setResizable(false);

        jScrollPane1.setBorder(null);
        jScrollPane1.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        jScrollPane1.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);
        jScrollPane1.setEnabled(false);
        jScrollPane1.setFocusable(false);

        jTextArea1.setEditable(false);
        jTextArea1.setBackground(new java.awt.Color(214, 217, 223));
        jTextArea1.setColumns(20);
        jTextArea1.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jTextArea1.setLineWrap(true);
        jTextArea1.setRows(5);
        jTextArea1.setText(Initializations.INSTALLERNOTE);
        jTextArea1.setWrapStyleWord(true);
        jTextArea1.setBorder(null);
        jTextArea1.setFocusable(false);
        jScrollPane1.setViewportView(jTextArea1);

        msiLabel.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        msiLabel.setText("Select The MSI installer location: ");
        msiLabel.setFocusable(false);

        browseToPathButton.setText("Browse to Path");
        browseToPathButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                browseToPathButtonActionPerformed(evt);
            }
        });

        installButton.setText("Start Install");
        installButton.setEnabled(false);
        installButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                installButtonActionPerformed(evt);
            }
        });

        cancelInstalButton.setText("Cancel");
        cancelInstalButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelInstalButtonActionPerformed(evt);
            }
        });

        statusLabel.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        statusLabel.setText("                                                   ");
        statusLabel.setFocusable(false);

        quiteModeSelector.setText("Install in Quiet Mode ");
        quiteModeSelector.setToolTipText(Initializations.QUITEMODETOOLTIP);
        quiteModeSelector.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                quiteModeSelectorActionPerformed(evt);
            }
        });

        installLocationLabel.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        installLocationLabel.setText("Install in the following location: ");
        installLocationLabel.setEnabled(false);
        installLocationLabel.setFocusable(false);

        browseToInstallPathButton.setText("Browse to Path");
        browseToInstallPathButton.setEnabled(false);
        browseToInstallPathButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                browseToInstallPathButtonActionPerformed(evt);
            }
        });

        installerLocationQuiteTextField.setEnabled(false);

        mongoComponentSetLabel.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        mongoComponentSetLabel.setText("Mongo Component Set to Install:");
        mongoComponentSetLabel.setEnabled(false);
        mongoComponentSetLabel.setFocusable(false);

        allTB.setSelected(true);
        allTB.setText("All");
        allTB.setToolTipText("Install the full component set");
        allTB.setEnabled(false);
        allTB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                checkBoxActionPerformed(evt);
            }
        });

        customTB.setText("Custom");
        customTB.setToolTipText("Select components to be installed");
        customTB.setEnabled(false);
        customTB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                checkBoxActionPerformed(evt);
            }
        });

        componentSetScrollBar.setToolTipText("");
        componentSetScrollBar.setEnabled(false);

        componentSetList.setModel(new javax.swing.AbstractListModel() {
            String[] strings = { "Server (mongod.exe)", "Router (mongos.exe)", "Client (mongo.exe)", "Monitoring Tools (mongostat.exe, mongotop.exe)", "Import-Export Tools (mongodump.exe, mongorestore.exe, mongoexport.exe, mongoimport.exe)", "Miscellaneous Tools (bsondump.exe, mongofiles.exe, mongooplog.exe, mongoperf.exe)" };
            public int getSize() { return strings.length; }
            public Object getElementAt(int i) { return strings[i]; }
        });
        componentSetList.setToolTipText("");
        componentSetList.setEnabled(false);
        componentSetScrollBar.setViewportView(componentSetList);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(statusLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(mongoComponentSetLabel)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(allTB)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(customTB))
                            .addComponent(installerLocationTextField)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(msiLabel)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(browseToPathButton))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(quiteModeSelector)
                                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 295, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(installLocationLabel)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(41, 41, 41)
                                        .addComponent(cancelInstalButton, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(browseToInstallPathButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(installButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                            .addComponent(installerLocationQuiteTextField)
                            .addComponent(componentSetScrollBar, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(msiLabel)
                    .addComponent(browseToPathButton, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(installerLocationTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(quiteModeSelector)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(installLocationLabel)
                    .addComponent(browseToInstallPathButton, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(installerLocationQuiteTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(mongoComponentSetLabel)
                    .addComponent(allTB)
                    .addComponent(customTB))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(componentSetScrollBar, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(installButton, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cancelInstalButton, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(statusLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void browseToPathButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_browseToPathButtonActionPerformed
        int selectResult = msiFileChooser.showOpenDialog(this);
        
        switch(selectResult)
        {
            case JFileChooser.APPROVE_OPTION:
            {
                installerLocationTextField.setText(msiFileChooser.getSelectedFile().getPath());
                break;
            }
            
            default:
                break;
        }
    }//GEN-LAST:event_browseToPathButtonActionPerformed

    private void installButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_installButtonActionPerformed
        /**
         * Disabling components so the user has to wait for the install process to continue,
         * or else if he chooses to close the install process...
         * The InstallMsi() is set to wait for the process to terminate, 
         * hence the main thread will be locked.
         * After the process has terminated i re-enable all the components...
         */
        installerLocationTextField.setEnabled(false);
        browseToPathButton.setEnabled(false);
        installButton.setEnabled(false);
        cancelInstalButton.setEnabled(false);
        String msiPath = installerLocationTextField.getText();
        statusLabel.setText(Initializations.PLEASEWAIT);
        InstallerController mongoInstaller = null;
        String pathToInstallation = Initializations.DEFAULT_INSTALL_PATH;
        
        if(quiteModeSelector.isSelected()) //Quite Mode...
        {
            List<String> selectedComponents = null;
            pathToInstallation = installerLocationQuiteTextField.getText();
            
            if(customTB.isSelected())
            {
                selectedComponents = componentSetList.getSelectedValuesList();
                mongoInstaller = new InstallerController(msiPath, pathToInstallation, selectedComponents);
            }
            
            else
            {
                mongoInstaller = new InstallerController(msiPath, pathToInstallation);
            }
            
        }
        
        else //Normal Mode...
        {
            mongoInstaller = new InstallerController(msiPath);   
        }
        
        //Start installing the MSI and wait for return value to act accordingly...
        int returnValue = mongoInstaller.InstallMsi();
        
        switch(returnValue)
        {
            case 0: //Therefore successfully installation...
            {
                statusLabel.setText(Initializations.SUCCESSFULLYINSTALLED);
                statusLabel.setForeground(new Color(0,102,0));
                JOptionPane.showMessageDialog(this, Initializations.SUCCESSFULLYINSTALLED, Initializations.SUCCESS, JOptionPane.INFORMATION_MESSAGE);
                
                /**
                 * Write installation location into the app.properties file
                 */
                PropertiesController propCntrl = new PropertiesController();
                propCntrl.writeConfigFile(Initializations.MONGO_BIN_PATH, pathToInstallation + Initializations.BIN_FOLDER);
                break;
            }
            case 1602: //Terminated by the user...
            {
                statusLabel.setText(Initializations.TERMINATEDBYUSER);
                statusLabel.setForeground(new Color(255,153,0));
                JOptionPane.showMessageDialog(this, Initializations.TERMINATEDBYUSER, Initializations.TERMINATEDBYUSERTITLE, JOptionPane.WARNING_MESSAGE);
                break;
            }
            
            case 1603: //Not enough privilages to install...
            {
                statusLabel.setText(Initializations.INSTALLERFAILEDTITLE);
                statusLabel.setForeground(Color.RED);
                JOptionPane.showMessageDialog(this, Initializations.NOTENOUGHRIGHTTOINSTALL, Initializations.INSTALLERFAILEDTITLE, JOptionPane.WARNING_MESSAGE);
                break;
            }
            
            case -1:
            {
                statusLabel.setText(Initializations.INSTALLERFAILEDTITLE);
                statusLabel.setForeground(Color.RED);
                JOptionPane.showMessageDialog(this, Initializations.INSTALLERFAILEDTITLE, Initializations.INSTALLERFAILEDTITLE, JOptionPane.WARNING_MESSAGE);
                break;
            }
            
            case 1639:
            {
                statusLabel.setText(Initializations.INSTALLERFAILEDTITLE);
                statusLabel.setForeground(Color.RED);
                JOptionPane.showMessageDialog(this, Initializations.INSTALLERFAILEDTITLE, Initializations.INSTALLERFAILEDTITLE, JOptionPane.WARNING_MESSAGE);
                break;
            }
        }

        installerLocationTextField.setEnabled(true);
        browseToPathButton.setEnabled(true);
        installButton.setEnabled(true);
        cancelInstalButton.setEnabled(true);
    }//GEN-LAST:event_installButtonActionPerformed

    private void browseToInstallPathButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_browseToInstallPathButtonActionPerformed
        int selectResult = locationFileChooser.showOpenDialog(this);
        
        switch(selectResult)
        {
            case JFileChooser.APPROVE_OPTION:
            {
                installerLocationQuiteTextField.setText(locationFileChooser.getSelectedFile().getPath());
                break;
            }
            
            default:
                break;
        }
    }//GEN-LAST:event_browseToInstallPathButtonActionPerformed

    private void quiteModeSelectorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_quiteModeSelectorActionPerformed
        if(quiteModeSelector.isSelected())
        { 
            if(installerLocationQuiteTextField.getText().length() > 0)
            {
                installButton.setEnabled(true);
            }
            else
            {
                installButton.setEnabled(false);
            }
            
            installLocationLabel.setEnabled(true);
            browseToInstallPathButton.setEnabled(true);
            installerLocationQuiteTextField.setEnabled(true);
            mongoComponentSetLabel.setEnabled(true);
            allTB.setEnabled(true);
            customTB.setEnabled(true);
        }
        else
        { 
            if(installerLocationTextField.getText().length() > 0)
            {
                installButton.setEnabled(true);
            }
            else
            {
                installButton.setEnabled(false);
            }
            
            installLocationLabel.setEnabled(false);
            browseToInstallPathButton.setEnabled(false);
            installerLocationQuiteTextField.setEnabled(false);
            mongoComponentSetLabel.setEnabled(false);
            allTB.setEnabled(false);
            customTB.setEnabled(false);
            componentSetList.setEnabled(false);
            componentSetScrollBar.setEnabled(true);
        }
    }//GEN-LAST:event_quiteModeSelectorActionPerformed

    private void checkBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_checkBoxActionPerformed
        if(evt.getSource() == allTB)
        {
            if(!allTB.isSelected())
            {
                customTB.setSelected(true);
                componentSetList.setEnabled(true);
                componentSetScrollBar.setEnabled(true);
            }
            
            else
            {
                customTB.setSelected(false);
                componentSetList.setEnabled(false);
                componentSetScrollBar.setEnabled(false);   
            }
        }
        else
        {
            if(!customTB.isSelected())
            {
                allTB.setSelected(true);
                customTB.setSelected(false);
                componentSetList.setEnabled(false);
                componentSetScrollBar.setEnabled(false);  
            }
            
            else
            {
                allTB.setSelected(false);
                componentSetList.setEnabled(true);
                componentSetScrollBar.setEnabled(true);
            }
        }
    }//GEN-LAST:event_checkBoxActionPerformed

    private void cancelInstalButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelInstalButtonActionPerformed
        this.dispose();
    }//GEN-LAST:event_cancelInstalButtonActionPerformed

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
            java.util.logging.Logger.getLogger(InstallMongoDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(InstallMongoDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(InstallMongoDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(InstallMongoDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                InstallMongoDialog dialog = new InstallMongoDialog(new javax.swing.JFrame(), true);
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

    private void setInstallerLocationTextFieldDocumentListener()
    {
        installerLocationTextField.getDocument().addDocumentListener(new DocumentListener() 
        {
            public void changedUpdate(DocumentEvent e) 
            {
                if(installerLocationTextField.getText().length() > 0 && !quiteModeSelector.isSelected())
                {
                    installButton.setEnabled(true);
                    
                    if(quiteModeSelector.isSelected() && installerLocationQuiteTextField.getText().length() > 0)
                    {
                        installButton.setEnabled(true);
                    }
                }
                else
                {
                    installButton.setEnabled(false);
                }
            }
            
            public void removeUpdate(DocumentEvent e) 
            {
                if(installerLocationTextField.getText().length() > 0 && !quiteModeSelector.isSelected())
                {
                    installButton.setEnabled(true);
                    
                    if(quiteModeSelector.isSelected() && installerLocationQuiteTextField.getText().length() > 0)
                    {
                        installButton.setEnabled(true);
                    }
                }
                else
                {
                    installButton.setEnabled(false);
                }
            }
            
            public void insertUpdate(DocumentEvent e) 
            {
                if(installerLocationTextField.getText().length() > 0 && !quiteModeSelector.isSelected())
                {
                    installButton.setEnabled(true);
                    
                    if(quiteModeSelector.isSelected() && installerLocationQuiteTextField.getText().length() > 0)
                    {
                        installButton.setEnabled(true);
                    }
                }
                else
                {
                    installButton.setEnabled(false);
                }
            }
        });
    }
    
    private void setInstallerQuiteLocationTextFieldDocumentListener()
    {
        installerLocationQuiteTextField.getDocument().addDocumentListener(new DocumentListener() 
        {
            public void changedUpdate(DocumentEvent e) 
            {
                if(installerLocationQuiteTextField.getText().length() > 0 && quiteModeSelector.isSelected())
                {
                    if(installerLocationTextField.getText().length() > 0)
                    {
                        installButton.setEnabled(true);
                    }
                }
                else
                {
                    installButton.setEnabled(false);
                }
            }
            
            public void removeUpdate(DocumentEvent e) 
            {
                if(installerLocationQuiteTextField.getText().length() > 0 && quiteModeSelector.isSelected())
                {
                    if(installerLocationTextField.getText().length() > 0)
                    {
                        installButton.setEnabled(true);
                    };
                }
                else
                {
                    installButton.setEnabled(false);
                }
            }
            
            public void insertUpdate(DocumentEvent e) 
            {
                if(installerLocationQuiteTextField.getText().length() > 0 && quiteModeSelector.isSelected())
                {
                    if(installerLocationTextField.getText().length() > 0)
                    {
                        installButton.setEnabled(true);
                    }
                }
                else
                {
                    installButton.setEnabled(false);
                }
            }
        });
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JCheckBox allTB;
    private javax.swing.JButton browseToInstallPathButton;
    private javax.swing.JButton browseToPathButton;
    private javax.swing.JButton cancelInstalButton;
    private javax.swing.JList componentSetList;
    private javax.swing.JScrollPane componentSetScrollBar;
    private javax.swing.JCheckBox customTB;
    private javax.swing.JButton installButton;
    private javax.swing.JLabel installLocationLabel;
    private javax.swing.JTextField installerLocationQuiteTextField;
    private javax.swing.JTextField installerLocationTextField;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JFileChooser locationFileChooser;
    private javax.swing.JLabel mongoComponentSetLabel;
    private javax.swing.JFileChooser msiFileChooser;
    private javax.swing.JLabel msiLabel;
    private javax.swing.JCheckBox quiteModeSelector;
    private javax.swing.JLabel statusLabel;
    // End of variables declaration//GEN-END:variables
}
