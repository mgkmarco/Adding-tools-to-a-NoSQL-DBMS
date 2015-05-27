/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nosqltools;

import java.awt.BorderLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.table.JTableHeader;
import org.jdesktop.swingx.JXTable;

/**
 * The frame which is used when a need to display nested JSON arrays in separate 
 * windows arises.
 */
public class TableForm extends JFrame{
   JSONUtilities json_util = new JSONUtilities();
   
    public TableForm(String x)
    {
        setTitle("Nested JSON Array");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        panel pan= new panel(x);
        add(pan.panel);
        pack();
        setVisible(true);
        
    }
    
     class panel {

      //The components to be used for this panel
      private final JButton btn1 = new JButton("Back");
      private JTextArea txt1 = new JTextArea();
      private JXTable jxTable = null;
      private String text;
      JPanel panel;
      
      public panel(String text) {
           panel = new JPanel(new BorderLayout());
           this.text = text;
           txt1.setText("JSON Array:" + text + "\n\n Table: ");
           panel.add(txt1, BorderLayout.NORTH);
           txt1.setEditable(false);
           createJXTable();
           
           /**
            * An on-click listener for the table which brings up a message dialog
            * with the value of the cell clicked (highly useful for nested JSON arrays)
            * and brings up a confirmation dialog if the user wants to view the nested JSON
            * in a separate table 
            */
            jxTable.addMouseListener(new java.awt.event.MouseAdapter(){
                @Override
                public void mouseClicked(java.awt.event.MouseEvent evt) {
                     int row = jxTable.rowAtPoint(evt.getPoint());
                     int col = jxTable.columnAtPoint(evt.getPoint());

                     JOptionPane.showMessageDialog(null,"Value in the cell clicked :" + " "+ jxTable.getValueAt(row,col).toString());

                     System.out.println("Value in the cell clicked :  "+ jxTable.getValueAt(row,col).toString());
                     if(json_util.isArray(jxTable.getValueAt(row,col).toString()))
                     {
                        if(JOptionPane.showConfirmDialog( null, "View the array as a table:",
                                 "VIEW", JOptionPane.OK_CANCEL_OPTION) == JOptionPane.YES_OPTION)
                        {
                            if (row >= 0 && col >= 0) {
                               System.out.print("Val" + jxTable.getValueAt(row,col).toString());
                               TableForm anotherTableForm = new TableForm(jxTable.getValueAt(row,col).toString());
                               anotherTableForm.setVisible(true);
                            }
                            else
                                JOptionPane.showMessageDialog(null,"Value in the cell clicked :" + " "+ jxTable.getValueAt(row,col).toString() + " is not a JSON Array!");
                        }
                     }
                }
               });
           JTableHeader header = jxTable.getTableHeader();
           panel.add(new JScrollPane(jxTable), BorderLayout.CENTER);
           btn1.addMouseListener(new java.awt.event.MouseAdapter(){
                @Override
                public void mouseClicked(java.awt.event.MouseEvent evt) {
                    dispose();
                }
           });
                   
           
           panel.add(btn1, BorderLayout.PAGE_END);
        }
  
      /**
       * Creates the initial table and populates it with the data from the text field obtained
       * in the methods getFields() and getRows()
       */ 
      private void createJXTable()
      {
          String[] json_field_names = null;
          
          System.out.println((text));
          if(json_util.isArray(text))
          {
              json_field_names = json_util.getFields();
              String[][] json_row_data = json_util.getRows(json_field_names);
              jxTable = new JXTable(json_row_data, json_field_names);
           
          }
        }
     }
   
}