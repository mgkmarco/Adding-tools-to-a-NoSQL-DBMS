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
import javax.swing.filechooser.FileNameExtensionFilter;

/**
 *
 * @author mgalea
 */
public class UninstallMongoDialog extends javax.swing.JDialog {

    /**
     * Creates new form UninstallMongoDialog
     */
    
    MainForm parent;
    
    public UninstallMongoDialog(MainForm parent, boolean modal) {
        super(parent, modal);
        initComponents();
        setMSILocationTextFieldDocumentListener();
    }

    /**
     * This method is called from within the constructor to initialize the form. WARNING: Do NOT modify this code. The content of this method is always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        msiFileChooser = new javax.swing.JFileChooser();
        jScrollPane1 = new javax.swing.JScrollPane();
        descriptionArea = new javax.swing.JTextArea();
        msiLocationLabel = new javax.swing.JLabel();
        msiLocationTextField = new javax.swing.JTextField();
        selectMSIButton = new javax.swing.JButton();
        uninstallButton = new javax.swing.JButton();
        cancelButton = new javax.swing.JButton();
        messageLabel = new javax.swing.JLabel();

        msiFileChooser.setCurrentDirectory(new File(System.getProperty("user.dir")));
        msiFileChooser.setDialogTitle("Browse to *.MSI");
        msiFileChooser.setFileFilter(new FileNameExtensionFilter("MSI", "msi")
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Uninstall MongoDB");
        setResizable(false);

        jScrollPane1.setBorder(null);
        jScrollPane1.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        jScrollPane1.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);

        descriptionArea.setBackground(new java.awt.Color(214, 217, 223));
        descriptionArea.setColumns(20);
        descriptionArea.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        descriptionArea.setLineWrap(true);
        descriptionArea.setRows(5);
        descriptionArea.setText("To uninstall MongoDB, please select the installed *.MSI and click on Uninstall. \nPress Cancel to Exit. ");
        descriptionArea.setWrapStyleWord(true);
        descriptionArea.setBorder(null);
        descriptionArea.setFocusable(false);
        jScrollPane1.setViewportView(descriptionArea);

        msiLocationLabel.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        msiLocationLabel.setText("MSI Location to Uninstall:");
        msiLocationLabel.setFocusable(false);

        selectMSIButton.setText("Select");
        selectMSIButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                selectMSIButtonActionPerformed(evt);
            }
        });

        uninstallButton.setText("Uninstall");
        uninstallButton.setEnabled(false);
        uninstallButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                uninstallButtonActionPerformed(evt);
            }
        });

        cancelButton.setText("Cancel");
        cancelButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelButtonActionPerformed(evt);
            }
        });

        messageLabel.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        messageLabel.setText(" ");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(messageLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane1)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(msiLocationLabel)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(msiLocationTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 229, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(cancelButton))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(uninstallButton, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(selectMSIButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(msiLocationLabel)
                    .addComponent(msiLocationTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(selectMSIButton))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(uninstallButton)
                    .addComponent(cancelButton))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(messageLabel))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cancelButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelButtonActionPerformed
        this.dispose();
    }//GEN-LAST:event_cancelButtonActionPerformed

    private void selectMSIButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_selectMSIButtonActionPerformed
        int selectResult = msiFileChooser.showOpenDialog(this);
        
        switch(selectResult)
        {
            case JFileChooser.APPROVE_OPTION:
            {
                msiLocationTextField.setText(msiFileChooser.getSelectedFile().getPath());
                break;
            }
            
            default:
                break;
        }
    }//GEN-LAST:event_selectMSIButtonActionPerformed

    private void uninstallButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_uninstallButtonActionPerformed
        messageLabel.setForeground(Color.ORANGE);
        messageLabel.setFont(new Font("Tahoma", Font.BOLD, 12));
        messageLabel.setText(Initializations.PLEASEWAITUNINSTALL);
        
        int resultVal = JOptionPane.showConfirmDialog(this, Initializations.UNINSTALLMONGO, Initializations.UNINSTALLMONGOTITLE, JOptionPane.OK_CANCEL_OPTION);
        
        switch(resultVal)
        {
            case 0: //OK... commence uninstallation
            {
                InstallerController ic = new InstallerController(msiLocationTextField.getText());
                int retVal = ic.uninstallMSI();
                
                switch(retVal)
                {
                    case 0: //success
                    {
                        messageLabel.setForeground(new Color(0,204,0));
                        messageLabel.setFont(new Font("Tahoma", Font.BOLD, 12));
                        messageLabel.setText(Initializations.UNINSTALLATIONSUCCESSMESSAGE);
                        break;
                    }  
                    
                    case 1605: //success or nothing found...
                    {
                        messageLabel.setForeground(new Color(0,204,0));
                        messageLabel.setFont(new Font("Tahoma", Font.BOLD, 12));
                        messageLabel.setText(Initializations.UNINSTALLATIONSUCCESSMESSAGE);
                        break;
                    }
                    
                    case 999: //File does not exist
                    {
                        messageLabel.setForeground(Color.RED);
                        messageLabel.setFont(new Font("Tahoma", Font.BOLD, 12));
                        messageLabel.setText(Initializations.FILEDOESNOTEXIST);  
                        break;
                    }
                    
                    default:
                    {
                        JOptionPane.showMessageDialog(this, Initializations.ERRORUNINSTALLEXCEPTION + ic.ExceptionMessage, Initializations.ERRORUNINSTALLEXCEPTIONTITLE, JOptionPane.WARNING_MESSAGE);
                        messageLabel.setForeground(Color.RED);
                        messageLabel.setFont(new Font("Tahoma", Font.BOLD, 12));
                        messageLabel.setText(Initializations.ERRORUNINSTALL);  
                        break;
                    }
                }
                
                break;
            }
            
            case 2: //User pressed cancel and hence aborted uninstallation...
            {
                messageLabel.setForeground(Color.RED);
                messageLabel.setFont(new Font("Tahoma", Font.BOLD, 12));
                messageLabel.setText(Initializations.UNINSTALLABORTEDMESSAGE);
            }
        }
    }//GEN-LAST:event_uninstallButtonActionPerformed

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
            java.util.logging.Logger.getLogger(UninstallMongoDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(UninstallMongoDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(UninstallMongoDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(UninstallMongoDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                UninstallMongoDialog dialog = new UninstallMongoDialog(new MainForm(), true);
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
    
    private void setMSILocationTextFieldDocumentListener()
    {
        msiLocationTextField.getDocument().addDocumentListener(new DocumentListener() 
        {
            public void changedUpdate(DocumentEvent e) 
            {
                if(msiLocationTextField.getText().length() > 0)
                {
                    uninstallButton.setEnabled(true);
                }
                else
                {
                    uninstallButton.setEnabled(false);
                }
            }
            
            public void removeUpdate(DocumentEvent e) 
            {
                if(msiLocationTextField.getText().length() > 0)
                {
                    uninstallButton.setEnabled(true);
                }
                else
                {
                    uninstallButton.setEnabled(false);
                }
            }
            
            public void insertUpdate(DocumentEvent e) 
            {
                if(msiLocationTextField.getText().length() > 0)
                {
                    uninstallButton.setEnabled(true);
                }
                else
                {
                    uninstallButton.setEnabled(false);
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton cancelButton;
    private javax.swing.JTextArea descriptionArea;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel messageLabel;
    private javax.swing.JFileChooser msiFileChooser;
    private javax.swing.JLabel msiLocationLabel;
    private javax.swing.JTextField msiLocationTextField;
    private javax.swing.JButton selectMSIButton;
    private javax.swing.JButton uninstallButton;
    // End of variables declaration//GEN-END:variables
}