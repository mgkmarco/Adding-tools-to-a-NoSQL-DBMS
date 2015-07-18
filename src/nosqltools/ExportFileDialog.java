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
import java.util.ArrayList;
import java.util.List;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 * This class contains the design of the Export JDialog and is used to
 * contain data related to the user's export operations and choices
 */
public class ExportFileDialog extends JDialog {
    
    //Creating the components
    private final JLabel lbFile;
    private JTextField fcFile;
    private JFileChooser fc_Export;
    private JButton btnBrowse;
    
    private final JLabel lbCollection;
    private final JLabel lbFileType;
    private final JComboBox dropColl;
    private final JComboBox dropType;
    private final List<String> coll;
    
    private final JButton btnOk;
    private final JButton btnCancel;
    private boolean choice = false;
    private String collectionToExport = null;
    private String locationToExport = null;
    private String typeToExport = null;
    
    /**
     * Constructor for the export file dialog
     * @param parent The JFrame it is attached to
     * @param collections The list of collection names available in the DB
     */
    public ExportFileDialog(Frame parent, List<String> collections) {
        super(parent, Initializations.EXPFILE, true);
        
        JPanel panel = new JPanel(new GridBagLayout());
        GridBagConstraints cs = new GridBagConstraints();
        this.coll = collections;

        cs.fill = GridBagConstraints.HORIZONTAL;

        lbFile = new JLabel("Output File: ");
        cs.gridx = 0;
        cs.gridy = 0;
        cs.gridwidth = 1;
        panel.add(lbFile, cs);

        fcFile = new JTextField(20);
        cs.gridx = 1;
        cs.gridy = 0;
        cs.gridwidth = 2;
        panel.add(fcFile, cs);
        
        btnBrowse = new JButton("Browse");
        panel.add(btnBrowse);
        
        btnBrowse.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {       
                /* reference: http://cyounes.com/blog/tutorials/how-to-use-jfilechooser-properly/*/
                if (fc_Export == null) 
                {
                    fc_Export = new JFileChooser("$HOME");
                }
                // Show the file chooser and get the value returned.
                int returnVal = fc_Export.showOpenDialog(btnBrowse);

                // Process the results.
                // Case 1: the user selects file and clicks on open button
                if (returnVal == JFileChooser.APPROVE_OPTION) 
                {
                    fcFile.setText(fc_Export.getSelectedFile().getPath());
                } 
                // Case 2: the user clicks on cancel
                else 
                {
                    fcFile.setText("");
                }
                // Reset the file chooser for the next time it's shown.
                fc_Export.setSelectedFile(null);
            }
        });

        lbCollection = new JLabel("Collection: ");
        cs.gridx = 0;
        cs.gridy = 1;
        cs.gridwidth = 1;
        panel.add(lbCollection, cs);

        dropColl = new JComboBox(coll.toArray());
        cs.gridx = 1;
        cs.gridy = 1;
        cs.gridwidth = 2;
        panel.add(dropColl, cs);   
        
        lbFileType = new JLabel("Export to: ");
        cs.gridx = 0;
        cs.gridy = 2;
        cs.gridwidth = 1;
        panel.add(lbFileType, cs);

        dropType = new JComboBox(populateFileTypes().toArray());
        cs.gridx = 1;
        cs.gridy = 2;
        cs.gridwidth = 2;
        panel.add(dropType, cs);  

        btnOk = new JButton("Export");

        btnOk.addActionListener(new ActionListener() {

            /**
             * Actions to be carried out when the user clicks OK on the dialog box
             * @param e The event
             */
            @Override
            public void actionPerformed(ActionEvent e) {   
            
            //Store all data specified by user on the dialog box
            locationToExport = fcFile.getText();
            typeToExport = dropType.getSelectedItem().toString();
            collectionToExport = dropColl.getSelectedItem().toString();
            
           // if (locationToExport == null || locationToExport.trim().equals(""))
             //   choice = false;
           // else 
            
            //Dispose the window and set choice to true
            choice = true;
            dispose();
            }
        });
               
        btnCancel = new JButton("Cancel");
        btnCancel.addActionListener(new ActionListener() {

            /**
             * Actions to carry out when the user clicks cancel
             * @param e The event
             */
            @Override
            public void actionPerformed(ActionEvent e) {
                //Dispose the window and set choice to false
                choice = false;
                dispose();
            }
        });
        
        JPanel bp = new JPanel();
        bp.add(btnOk);
        bp.add(btnCancel);

        getContentPane().add(panel, BorderLayout.CENTER);
        getContentPane().add(bp, BorderLayout.PAGE_END);

        pack();
        setResizable(false);
        setLocationRelativeTo(parent);
    }
    
    /**
     * @return The name of the chosen collection to export
     */
    public String collectionToExport()
    {
        return collectionToExport;
    }
    
    /** 
     * @return The file location to export to on local storage
     */
    public String locToExport()
    {
        return locationToExport;
    }
    
    /**
     * @return The type to export the collection to (JSON or CSV)
     */
    public String typeToExport()
    {
        return typeToExport;
    }
    
    /**
     * @return The user's choice, whether export will proceed or was cancelled
     */
    public boolean isToExport() {
        return choice;
    }

    /**
     * Populates and returns array list with the types to format to
     */
    private List<String> populateFileTypes() {
       List <String> types = new ArrayList <String>();
       types.add("JSON");
       types.add("CSV");
   
       return types;
    }
      
}