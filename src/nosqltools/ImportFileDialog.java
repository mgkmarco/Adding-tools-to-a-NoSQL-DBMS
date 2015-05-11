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
 *
 * @author natasha nikolic
 */
public class ImportFileDialog extends JDialog {
    
    private JLabel lbFile;
    private JTextField fcFile;
    private JFileChooser fc_Import;
    private JButton btnBrowse;
    
    private JLabel lbCollection;
    private JComboBox dropColl;
    private DBConnection db_conn = null;
    private ArrayList<String> coll;
    
    private JButton btnOk;
    private JButton btnCancel;
    private boolean choice = false;
    
    public ImportFileDialog(Frame parent) {
        super(parent, Initializations.IMPFILE, true);
        
        JPanel panel = new JPanel(new GridBagLayout());
        GridBagConstraints cs = new GridBagConstraints();

        cs.fill = GridBagConstraints.HORIZONTAL;

        lbFile = new JLabel("Input File: ");
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
                    fcFile.setText(fc_Import.getSelectedFile().getPath());
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

        lbCollection = new JLabel("Collection: ");
        cs.gridx = 0;
        cs.gridy = 1;
        cs.gridwidth = 1;
        panel.add(lbCollection, cs);

        dropColl = fillCollCombo();
        cs.gridx = 1;
        cs.gridy = 1;
        cs.gridwidth = 2;
        panel.add(dropColl, cs);    
        
        dropColl.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
//                ArrayList<String> coll = db_conn.getAllCollections();
//                for (int i = 0; i< coll.size(); i++)
//                {
//                    dropColl.addItem(coll.get(i));        
//                }
            }
        });

        btnOk = new JButton("Import");

        btnOk.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {         
            choice = true;
            dispose();
            }
        });
               
        btnCancel = new JButton("Cancel");
        btnCancel.addActionListener(new ActionListener() {

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
    
    public boolean isToImport() {
        return choice;
    }
    
    public JComboBox fillCollCombo()
    {
        dropColl = new JComboBox();
        dropColl.addItem("none");
        //for (int i = 0; i< coll.size(); i++)
        //{
        //    dropColl.addItem(coll.get(i));        
        //}
        return dropColl;
    }
    
}