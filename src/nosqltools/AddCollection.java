/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nosqltools;

import com.fasterxml.jackson.databind.JsonNode;
import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.JOptionPane;
import javax.swing.tree.DefaultTreeModel;

/**
 *
 * @author mgalea
 */
public class AddCollection extends javax.swing.JDialog {

    /**
     * Creates new form AddCollection
     */
    private final MainForm mainForm;

    public AddCollection(MainForm parent, boolean modal) {
        super(parent, modal);
        mainForm = parent;
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form. WARNING: Do NOT modify this code. The content of this method is always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        clearButton = new javax.swing.JButton();
        executeButton = new javax.swing.JButton();
        parentTabContainer = new javax.swing.JTabbedPane();
        designTab = new javax.swing.JPanel();
        collectionNameLabel = new javax.swing.JLabel();
        collectionNameTextArea = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        cappedEnabled = new javax.swing.JCheckBox();
        sizeLabel = new javax.swing.JLabel();
        sizeComboBox = new javax.swing.JComboBox();
        maxLabel = new javax.swing.JLabel();
        maxTextField = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        autoIndexIDEnabled = new javax.swing.JCheckBox();
        scriptTab = new javax.swing.JPanel();
        syntaxEditorTextArea = new nosqltools.SyntaxEditor();
        messageLabel = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Add Collection");
        setResizable(false);

        clearButton.setText("Clear");
        clearButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                clearButtonActionPerformed(evt);
            }
        });

        executeButton.setLabel("Execute");
        executeButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                executeButtonActionPerformed(evt);
            }
        });

        parentTabContainer.setTabPlacement(javax.swing.JTabbedPane.BOTTOM);

        designTab.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N

        collectionNameLabel.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        collectionNameLabel.setText("Collection Name:");
        collectionNameLabel.setFocusable(false);

        jLabel1.setForeground(new java.awt.Color(255, 0, 0));
        jLabel1.setText("*");

        cappedEnabled.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        cappedEnabled.setText("Capped Enabled (2GB Max)");
        cappedEnabled.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cappedEnabledActionPerformed(evt);
            }
        });

        sizeLabel.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        sizeLabel.setText("Size (In Bytes): ");
        sizeLabel.setEnabled(false);
        sizeLabel.setFocusable(false);

        sizeComboBox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "2", "4", "8", "16", "32", "64", "128", "256", "512", "1024", "2048", "4096", "8192", "16384", "32768", "65536", "131072", "262144", "524288", "1048576", "2097152", "4194304", "8388608", "16777216", "33554432", "67108864", "134217728", "268435456", "536870912", "1073741824", "2147483648" }));
        sizeComboBox.setEnabled(false);

        maxLabel.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        maxLabel.setText("Max (Documents):");
        maxLabel.setFocusable(false);

        jScrollPane1.setBorder(null);
        jScrollPane1.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        jScrollPane1.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);
        jScrollPane1.setEnabled(false);
        jScrollPane1.setFocusable(false);

        jTextArea1.setEditable(false);
        jTextArea1.setBackground(new java.awt.Color(214, 217, 223));
        jTextArea1.setColumns(20);
        jTextArea1.setFont(new java.awt.Font("Tahoma", 0, 11)); // NOI18N
        jTextArea1.setLineWrap(true);
        jTextArea1.setRows(5);
        jTextArea1.setText("Use the Design tab so as to create Collections. If additional or more specific Collections are required to be created, use the Script Tab.");
        jTextArea1.setWrapStyleWord(true);
        jTextArea1.setBorder(null);
        jTextArea1.setFocusable(false);
        jTextArea1.setOpaque(false);
        jTextArea1.setRequestFocusEnabled(false);
        jTextArea1.setSelectedTextColor(new java.awt.Color(240, 240, 240));
        jScrollPane1.setViewportView(jTextArea1);

        autoIndexIDEnabled.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        autoIndexIDEnabled.setText("Auto Index ID:");

        javax.swing.GroupLayout designTabLayout = new javax.swing.GroupLayout(designTab);
        designTab.setLayout(designTabLayout);
        designTabLayout.setHorizontalGroup(
            designTabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(designTabLayout.createSequentialGroup()
                .addGap(41, 41, 41)
                .addGroup(designTabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(autoIndexIDEnabled)
                    .addGroup(designTabLayout.createSequentialGroup()
                        .addGroup(designTabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, designTabLayout.createSequentialGroup()
                                .addComponent(sizeLabel)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 31, Short.MAX_VALUE)
                                .addComponent(sizeComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 181, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, designTabLayout.createSequentialGroup()
                                .addGroup(designTabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(maxLabel)
                                    .addComponent(collectionNameLabel))
                                .addGap(18, 18, 18)
                                .addGroup(designTabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(collectionNameTextArea)
                                    .addComponent(maxTextField))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel1))
                    .addComponent(cappedEnabled))
                .addContainerGap(59, Short.MAX_VALUE))
            .addGroup(designTabLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1)
                .addContainerGap())
        );
        designTabLayout.setVerticalGroup(
            designTabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(designTabLayout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(12, 12, 12)
                .addGroup(designTabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addGroup(designTabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(collectionNameLabel)
                        .addComponent(collectionNameTextArea, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 40, Short.MAX_VALUE)
                .addGroup(designTabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(maxLabel)
                    .addComponent(maxTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(32, 32, 32)
                .addComponent(autoIndexIDEnabled)
                .addGap(31, 31, 31)
                .addComponent(cappedEnabled)
                .addGap(37, 37, 37)
                .addGroup(designTabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(sizeLabel)
                    .addComponent(sizeComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(27, 27, 27))
        );

        parentTabContainer.addTab("Design", designTab);

        javax.swing.GroupLayout scriptTabLayout = new javax.swing.GroupLayout(scriptTab);
        scriptTab.setLayout(scriptTabLayout);
        scriptTabLayout.setHorizontalGroup(
            scriptTabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(syntaxEditorTextArea, javax.swing.GroupLayout.DEFAULT_SIZE, 416, Short.MAX_VALUE)
        );
        scriptTabLayout.setVerticalGroup(
            scriptTabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(syntaxEditorTextArea, javax.swing.GroupLayout.DEFAULT_SIZE, 339, Short.MAX_VALUE)
        );

        parentTabContainer.addTab("Script", scriptTab);

        messageLabel.setFocusable(false);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(messageLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(clearButton)
                .addGap(18, 18, 18)
                .addComponent(executeButton)
                .addGap(17, 17, 17))
            .addComponent(parentTabContainer)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(parentTabContainer)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(executeButton, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(clearButton, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap())
                    .addComponent(messageLabel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );

        parentTabContainer.getAccessibleContext().setAccessibleName("Design");
        parentTabContainer.getAccessibleContext().setAccessibleDescription("");

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     *
     * This method is called when the add collection is pressed via the MenuBar command option
     */
    private void executeButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_executeButtonActionPerformed
        messageLabel.setText(null);
        
        if (mainForm.dbcon.isConnectionSuccess()) 
        {
            if (mainForm.dbcon.checkDatabaseConnection()) 
            {
                HashMap propertyMap = new HashMap();
                /**
                * Check whether we are executing for the Design Tab or Script tab...
                */
                if(parentTabContainer.getSelectedIndex() == 0) //Design Tab
                {
                    this.designAddCollection(propertyMap);
                }
        
                else //Script Tab
                {
                    this.scriptAddCollection(propertyMap);
                }
            }
            else 
            {
                JOptionPane.showMessageDialog(null, Initializations.MONGOSERVERERROR, Initializations.ERROR, JOptionPane.ERROR_MESSAGE);
                mainForm.Text_MessageBar.setText(Initializations.MONGOSERVERERROR);
                mainForm.Text_MessageBar.setForeground(Color.RED);
            }
        }        
        else 
        {
            JOptionPane.showMessageDialog(null, Initializations.NODBCONNECTION, Initializations.ERROR, JOptionPane.ERROR_MESSAGE);
            mainForm.Text_MessageBar.setText(Initializations.NODBCONNECTION);
            mainForm.Text_MessageBar.setForeground(Color.RED);
        }
    }//GEN-LAST:event_executeButtonActionPerformed

    private void clearButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_clearButtonActionPerformed
        
        if(parentTabContainer.getSelectedIndex() == 0) //Desgin Tab
        {
            messageLabel.setText(null);
            collectionNameTextArea.setText(null);
            maxTextField.setText(null);
            autoIndexIDEnabled.setSelected(false);
            sizeComboBox.setSelectedIndex(0);
            sizeComboBox.setEnabled(false);
            sizeLabel.setEnabled(false);
            cappedEnabled.setSelected(false);
        }
        else //Script Tab
        {
            this.syntaxEditorTextArea.textArea.setText(null);
            this.messageLabel.setText(null);   
        }
    }//GEN-LAST:event_clearButtonActionPerformed

    private void cappedEnabledActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cappedEnabledActionPerformed
        
        if(cappedEnabled.isSelected())
        {
            sizeLabel.setEnabled(true);
            sizeComboBox.setEnabled(true);
        }
        
        else
        {
            sizeLabel.setEnabled(false);
            sizeComboBox.setEnabled(false);
        }
    }//GEN-LAST:event_cappedEnabledActionPerformed

    private void refreshTreeView()
    {
        DefaultTreeModel defTableMod = mainForm.dbcon.buildDBTree();
        if (defTableMod != null && mainForm.dbcon.isConnectionSuccess()) 
        {
            mainForm.jTree1.setModel(defTableMod);
            mainForm.Text_MessageBar.setText(Initializations.DBCONNSUCCESS);
            mainForm.Text_MessageBar.setForeground(Color.GREEN);
            mainForm.Menu_Collections.setEnabled(true);
            mainForm.addCollection.setEnabled(true);
        } 
        else 
        {
            mainForm.jTree1.setModel(null);
            mainForm.Text_MessageBar.setText(Initializations.DBCONNFAIL);
            mainForm.Text_MessageBar.setForeground(Color.RED);
        }
    }
    
    private void refreshDBViewPanel() {
        if (mainForm.dbcon.isConnectionSuccess()) {
            if (mainForm.dbcon.checkDatabaseConnection()) {
                if (mainForm.indexOfCurrentCollection != 0) {

                    String loc = mainForm.tp.getPathComponent(mainForm.indexOfCurrentCollection).toString();

                    if (mainForm.dbcon.checkSystemColl(loc)) {
                        String new_data = mainForm.dbcon.getCollectionData(loc).toString();
                        JsonNode jNode1;
                        try {
                            jNode1 = mainForm.mapper.readTree(new_data);
                            mainForm.textArea.setText(mainForm.mapper.writerWithDefaultPrettyPrinter().writeValueAsString(jNode1));
                        } catch (IOException ex) {
                            Logger.getLogger(MainForm.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    }
                } else {
                    mainForm.Text_MessageBar.setText(Initializations.DBACTIONNOCOLLECTION);
                    mainForm.Text_MessageBar.setForeground(Color.RED);
                    JOptionPane.showMessageDialog(null, Initializations.DBACTIONNOCOLLECTION, "Error", JOptionPane.ERROR_MESSAGE);
                }
            } else {
                JOptionPane.showMessageDialog(null, Initializations.MONGOSERVERERROR, "Error", JOptionPane.ERROR_MESSAGE);
                mainForm.Text_MessageBar.setText(Initializations.MONGOSERVERERROR);
                mainForm.Text_MessageBar.setForeground(Color.RED);
            }
        } else {
            mainForm.Text_MessageBar.setText(Initializations.SYSTEMCOLLNOREFRESH);
            mainForm.Text_MessageBar.setForeground(Color.RED);
        }
    }

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
            java.util.logging.Logger.getLogger(AddCollection.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AddCollection.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AddCollection.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AddCollection.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                AddCollection dialog = new AddCollection(new MainForm(), true);
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

    private String getCollectionName(String inputCMD) {
        String collectionName = null;
        Pattern namePattern = Pattern.compile("\"(.*?)\"");
        Matcher m = namePattern.matcher(inputCMD);

        while (m.find()) {
            collectionName = m.group(1);
        }

        return collectionName;
    }

    private String getOptionalProperty(String inputCMD, String optionalProp) {
        String property = null;
        //to remove whitespace
        inputCMD = inputCMD.replaceAll("\\s", "");

        Pattern namePattern = Pattern.compile(optionalProp + "(.*?),", Pattern.CASE_INSENSITIVE);
        Matcher m = namePattern.matcher(inputCMD);

        while (m.find()) {
            property = m.group(1);
        }

        //Since maybe only one property or the last property in the group...
        if (property == null) 
        {
            namePattern = Pattern.compile(optionalProp + "(.*?)}", Pattern.CASE_INSENSITIVE);
            m = namePattern.matcher(inputCMD);

            while (m.find()) {
                property = m.group(1);
            }

            return property;
        } 
        else 
        {
            return property;
        }
    }
    
    private void scriptAddCollection(HashMap propertyMap) 
    {
        //Start to parse the command input of the user accordingly;
        String inputCMD = this.syntaxEditorTextArea.textArea.getText();

        if (inputCMD.length() > 0 && inputCMD.toLowerCase().contains(MongoReserved.CREATECOLLECTIONCOMMAND)) 
        {
            String name = getCollectionName(inputCMD);

            if (name.length() < 1) 
            {
                messageLabel.setText(Initializations.ADDCOLLECTIONNAME);
                messageLabel.setForeground(Color.RED);
                JOptionPane.showMessageDialog(null, Initializations.NAMECOLLECTION, Initializations.CREATECOMMANDNOTVALID, JOptionPane.WARNING_MESSAGE);
            } 
            else 
            {
                try 
                {
                    propertyMap.put(MongoReserved.NAME_PROP, name);
                    String capped = getOptionalProperty(inputCMD, MongoReserved.CAPPED_VAR);

                    if (capped != null) 
                    {
                        if (!capped.equalsIgnoreCase(MongoReserved.TRUE_VAR) && !capped.equalsIgnoreCase(MongoReserved.FALSE_VAR)) 
                        {
                            throw new Exception();
                        } 
                        else 
                        {
                            propertyMap.put(MongoReserved.CAPPED_PROP, Boolean.valueOf(capped));
                        }
                    }

                    String autoIndexId = getOptionalProperty(inputCMD, MongoReserved.AUTOINDEXID_VAR);

                    if (autoIndexId != null) 
                    {
                        if (!autoIndexId.equalsIgnoreCase(MongoReserved.TRUE_VAR) && !autoIndexId.equalsIgnoreCase(MongoReserved.FALSE_VAR)) 
                        {
                            throw new Exception();
                        } 
                        else 
                        {
                            propertyMap.put(MongoReserved.AUTOINDEXID_PROP, Boolean.valueOf(autoIndexId));
                        }
                    }

                    String size = getOptionalProperty(inputCMD, MongoReserved.SIZE_VAR);

                    if (size != null) 
                    {
                        propertyMap.put(MongoReserved.SIZE_PROP, Integer.parseInt(size));
                    }

                    String max = getOptionalProperty(inputCMD, MongoReserved.MAX_VAR);

                    if (max != null) 
                    {
                        propertyMap.put((MongoReserved.MAX_PROP), Integer.parseInt(max));
                    }

                    String storageEngine = getOptionalProperty(inputCMD, MongoReserved.STORAGEENGINE_VAR);
                    propertyMap.put(MongoReserved.STORAGEENGINE_PROP, storageEngine);

                    //Call the method to create the actual collection...
                    String returnVal = mainForm.dbcon.createCollection(propertyMap);
                    
                    if (returnVal.equals(Initializations.SUCCESS)) 
                    {
                        messageLabel.setText(returnVal);
                        messageLabel.setForeground(Color.GREEN);
                        JOptionPane.showMessageDialog(this, Initializations.COLLECTIONCREATEDSUCCESSFULLY, Initializations.COLLECTIONCREATED, JOptionPane.YES_OPTION);
                        refreshTreeView();
                    } 
                    else 
                    {
                        messageLabel.setText(Initializations.CHECKSYNTAXERROR);
                        messageLabel.setForeground(Color.RED);
                        JOptionPane.showMessageDialog(null, returnVal, Initializations.CHECKSYNTAXERROR, JOptionPane.ERROR_MESSAGE);
                    }
                } 
                catch (Exception exp) 
                {
                    messageLabel.setText(Initializations.CHECKSYNTAXERROR);
                    messageLabel.setForeground(Color.RED);
                    JOptionPane.showMessageDialog(null, Initializations.CREATECOMMANDOPTIONSNOTVALID, Initializations.CHECKSYNTAXERROR, JOptionPane.WARNING_MESSAGE);
                }
            }
        } 
        else 
        {
            messageLabel.setText(Initializations.CHECKSYNTAXERROR);
            messageLabel.setForeground(Color.RED);
            JOptionPane.showMessageDialog(null, Initializations.CREATECOMMANDDECLAREERROR, Initializations.CREATECOMMANDNOTVALID, JOptionPane.WARNING_MESSAGE);
        }
    }
    
    private void designAddCollection(HashMap propertyMap)
    {
        String collectionName = collectionNameTextArea.getText();
        Boolean valid = true;
        
        if(collectionName.length() < 1 || collectionName.equals(""))
        {
            messageLabel.setText(Initializations.ADDCOLLECTIONNAME);
            messageLabel.setForeground(Color.RED);
            JOptionPane.showMessageDialog(null, Initializations.NAMECOLLECTION, Initializations.CREATECOMMANDNOTVALID, JOptionPane.WARNING_MESSAGE);
        }
        else
        {
            propertyMap.put(MongoReserved.NAME_PROP, collectionName);
            String max = maxTextField.getText();
        
            if(max.length() > 0)
            {
                try
                {
                    propertyMap.put((MongoReserved.MAX_PROP), Integer.parseInt(max));
                }
                catch (Exception exp)
                {      
                    valid = false;
                    messageLabel.setText(Initializations.INVALIDPROPERTYENTRY);
                    messageLabel.setForeground(Color.RED);
                    JOptionPane.showMessageDialog(null, Initializations.MAXDOCUMENTSINVALID, Initializations.INVALIDPROPERTYENTRY, JOptionPane.WARNING_MESSAGE);
                }
            }
        
            if(valid)
            {
                propertyMap.put(MongoReserved.AUTOINDEXID_PROP, autoIndexIDEnabled.isSelected());
                Boolean capped = cappedEnabled.isSelected();
                propertyMap.put(MongoReserved.CAPPED_PROP, capped);
        
                if(capped)
                {
                    propertyMap.put(MongoReserved.SIZE_PROP, Integer.parseInt(String.valueOf(sizeComboBox.getSelectedItem())));
                }
            
                //Call the method to create the actual collection...
                String returnVal = mainForm.dbcon.createCollection(propertyMap);
                    
                if (returnVal.equals(Initializations.SUCCESS)) 
                {
                    messageLabel.setText(returnVal);
                    messageLabel.setForeground(Color.GREEN);
                    JOptionPane.showMessageDialog(this, Initializations.COLLECTIONCREATEDSUCCESSFULLY, Initializations.COLLECTIONCREATED, JOptionPane.YES_OPTION);
                    refreshTreeView();
                } 
                else 
                {
                    messageLabel.setText(Initializations.CHECKSYNTAXERROR);
                    messageLabel.setForeground(Color.RED);
                    JOptionPane.showMessageDialog(null, returnVal, Initializations.CHECKSYNTAXERROR, JOptionPane.ERROR_MESSAGE);
                }   
            }
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JCheckBox autoIndexIDEnabled;
    private javax.swing.JCheckBox cappedEnabled;
    private javax.swing.JButton clearButton;
    private javax.swing.JLabel collectionNameLabel;
    private javax.swing.JTextField collectionNameTextArea;
    private javax.swing.JPanel designTab;
    private javax.swing.JButton executeButton;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JLabel maxLabel;
    private javax.swing.JTextField maxTextField;
    private javax.swing.JLabel messageLabel;
    private javax.swing.JTabbedPane parentTabContainer;
    private javax.swing.JPanel scriptTab;
    private javax.swing.JComboBox sizeComboBox;
    private javax.swing.JLabel sizeLabel;
    private nosqltools.SyntaxEditor syntaxEditorTextArea;
    // End of variables declaration//GEN-END:variables
}
