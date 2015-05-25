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
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

//this class is used for displaying the dialog window for the import file from csv
public class ImportFileDialog extends JDialog {
    
    //these attributes are used for the file chooser
    private JLabel lbFile;
    private JTextField fcFile;
    private JFileChooser fc_Import;
    private JButton btnBrowse;
    
    //these attributes are used for the collection, and file type drop down
    private JLabel lbCollection;
    private JLabel lbFileType;
    private JComboBox dropColl;
    private final JComboBox dropType;
    private List<String> coll;
    
    //additional attributes that will be used for the dialog box
    private JButton btnOk;
    private JButton btnCancel;
    private boolean choice = false;
    
    //strings that are used by the main form to indicate which collection, location it will be imported.
    private String collectionToImport = null;
    private String locationToImport = null;
    private String typeToImport = null;
    
    public ImportFileDialog(Frame parent, List<String> collections) {
        super(parent, Initializations.IMPFILE, true);
        
        JPanel panel = new JPanel(new GridBagLayout());
        GridBagConstraints cs = new GridBagConstraints();
        this.coll = collections;

        cs.fill = GridBagConstraints.HORIZONTAL;

        //Label for the input file
        lbFile = new JLabel("Input File: ");
        cs.gridx = 0;
        cs.gridy = 0;
        cs.gridwidth = 1;
        panel.add(lbFile, cs);

        //the text field which holds the file location as a string
        fcFile = new JTextField(20);
        cs.gridx = 1;
        cs.gridy = 0;
        cs.gridwidth = 2;
        panel.add(fcFile, cs);
        
        //the browse button that loads the JFileChooser
        btnBrowse = new JButton("Browse");
        panel.add(btnBrowse);
        
        btnBrowse.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {       
                /* reference: http://cyounes.com/blog/tutorials/how-to-use-jfilechooser-properly/*/
                if (fc_Import == null) 
                {
                    fc_Import = new JFileChooser("$HOME");
                }
                // Show the file chooser and get the value returned.
                int returnVal = fc_Import.showOpenDialog(btnBrowse);

                // Process the results.
                // Case 1: the user selects file and clicks on open button
                if (returnVal == JFileChooser.APPROVE_OPTION) 
                {
                    String filename = fc_Import.getSelectedFile().getName();
                    if ((filename.substring(filename.lastIndexOf("."), filename.length())).equals(".csv"))
                    {
                        fcFile.setText(fc_Import.getSelectedFile().getPath());
                    }
                    else
                    {
                        JOptionPane.showMessageDialog(fc_Import, Initializations.FILECSVIMPORT , Initializations.FILEERROR , JOptionPane.ERROR_MESSAGE);
                    }
                } 
                // Case 2: the user clicks on cancel
                else 
                {
                    fcFile.setText("");
                }
                // Reset the file chooser for the next time it's shown.
                fc_Import.setSelectedFile(null);
            }
        });

        //the collection label
        lbCollection = new JLabel("Collection: ");
        cs.gridx = 0;
        cs.gridy = 1;
        cs.gridwidth = 1;
        panel.add(lbCollection, cs);

        //the drop down that loads the collections list
        dropColl = new JComboBox(coll.toArray());
        cs.gridx = 1;
        cs.gridy = 1;
        cs.gridwidth = 2;
        panel.add(dropColl, cs);  
        
        //import file label
        lbFileType = new JLabel("Import from: ");
        cs.gridx = 0;
        cs.gridy = 2;
        cs.gridwidth = 1;
        panel.add(lbFileType, cs);
        
        //the frop down that shows the types of files that can be imported.
        //Note: currently we only allow CSV files to be imported.
        dropType = new JComboBox(populateFileTypes().toArray());
        cs.gridx = 1;
        cs.gridy = 2;
        cs.gridwidth = 2;
        panel.add(dropType, cs); 

        //the button import
        btnOk = new JButton("Import");

        btnOk.addActionListener(new ActionListener() {

            //the action listener will set the location, type and collection upon clicking the import button
            @Override
            public void actionPerformed(ActionEvent e) {   
            locationToImport = fcFile.getText();
            typeToImport = dropType.getSelectedItem().toString();
            collectionToImport = dropColl.getSelectedItem().toString();
            choice = true;
            dispose();
            }
        });
               
        btnCancel = new JButton("Cancel");
        btnCancel.addActionListener(new ActionListener() {

            //the action listener that will be performed when the cancel button is clicked. 
            @Override
            public void actionPerformed(ActionEvent e) {
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
    
    //method that will return the name of the collection that the data will be loaded to
    public String collectionToImport()
    {
        return collectionToImport;
    }
    
    //method that will return the name of the location that the CSV file is stored.
    public String locToImport()
    {
        return locationToImport;
    }
     
    //method that will return the type of file that is going to be imported.
    public String typeToImport()
    {
        return typeToImport;
    }
    
    //method that will return false if the user closes the dialog box
    public boolean isToImport() {
        return choice;
    }
    
    //this method populare the drop down list and retruns the list of strings.
    private List<String> populateFileTypes() {
       List <String> types = new ArrayList <String>();
       types.add("CSV");
    
       return types;
    }
    
}