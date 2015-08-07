/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nosqltools;

import com.mongodb.BasicDBObject;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author mgalea
 */
public class ConditionalPanel extends javax.swing.JPanel {

    private QueryCollectionDialog parent;
    protected String QueryString = "";
    
    /**
     * Creates new form ConditionalPanel
     */
    public ConditionalPanel() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form. WARNING: Do NOT modify this code. The content of this method is always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        matchPanel = new javax.swing.JPanel();
        valueTextArea = new javax.swing.JTextField();
        fieldTextArea = new javax.swing.JTextField();
        whereValueFieldLabel = new javax.swing.JLabel();
        whereFieldLabel = new javax.swing.JLabel();
        andField = new javax.swing.JTextField();
        andValue = new javax.swing.JTextField();
        andRB = new javax.swing.JRadioButton();
        whereValueFieldLabel1 = new javax.swing.JLabel();
        orRB = new javax.swing.JRadioButton();
        whereValueFieldLabel2 = new javax.swing.JLabel();
        orField = new javax.swing.JTextField();
        orValue = new javax.swing.JTextField();
        rangeRB = new javax.swing.JRadioButton();
        rangeFromVal = new javax.swing.JTextField();
        rangeToVal = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();

        setMaximumSize(new java.awt.Dimension(471, 135));
        setMinimumSize(new java.awt.Dimension(471, 135));

        matchPanel.setMaximumSize(new java.awt.Dimension(471, 135));
        matchPanel.setMinimumSize(new java.awt.Dimension(471, 135));
        matchPanel.setPreferredSize(new java.awt.Dimension(471, 135));

        fieldTextArea.setMaximumSize(new java.awt.Dimension(6, 20));

        whereValueFieldLabel.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        whereValueFieldLabel.setText("Has Value = ");
        whereValueFieldLabel.setFocusable(false);

        whereFieldLabel.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        whereFieldLabel.setText("Where Field:");

        andField.setEnabled(false);

        andValue.setEnabled(false);

        andRB.setText("AND");
        andRB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RBActionPerformed(evt);
            }
        });

        whereValueFieldLabel1.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        whereValueFieldLabel1.setText("Has Value = ");
        whereValueFieldLabel1.setFocusable(false);

        orRB.setText("OR");
        orRB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RBActionPerformed(evt);
            }
        });

        whereValueFieldLabel2.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        whereValueFieldLabel2.setText("Has Value = ");
        whereValueFieldLabel2.setFocusable(false);

        orField.setEnabled(false);

        orValue.setEnabled(false);

        rangeRB.setText("Range >=");
        rangeRB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RBActionPerformed(evt);
            }
        });

        rangeFromVal.setEnabled(false);
        rangeFromVal.setMaximumSize(new java.awt.Dimension(6, 20));

        rangeToVal.setEnabled(false);

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel1.setText("To Value <=");

        javax.swing.GroupLayout matchPanelLayout = new javax.swing.GroupLayout(matchPanel);
        matchPanel.setLayout(matchPanelLayout);
        matchPanelLayout.setHorizontalGroup(
            matchPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(matchPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(matchPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(matchPanelLayout.createSequentialGroup()
                        .addGroup(matchPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(whereFieldLabel)
                            .addComponent(andRB)
                            .addComponent(orRB))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(matchPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(fieldTextArea, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(andField)
                            .addComponent(orField, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addGap(18, 18, 18)
                        .addGroup(matchPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(matchPanelLayout.createSequentialGroup()
                                .addComponent(whereValueFieldLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 29, Short.MAX_VALUE)
                                .addComponent(orValue, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(matchPanelLayout.createSequentialGroup()
                                .addComponent(whereValueFieldLabel)
                                .addGap(29, 29, 29)
                                .addComponent(valueTextArea))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, matchPanelLayout.createSequentialGroup()
                                .addComponent(whereValueFieldLabel1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(andValue, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(matchPanelLayout.createSequentialGroup()
                        .addComponent(rangeRB)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(rangeFromVal, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(30, 30, 30)
                        .addComponent(rangeToVal, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE))))
        );
        matchPanelLayout.setVerticalGroup(
            matchPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(matchPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(matchPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(valueTextArea, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(fieldTextArea, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(whereValueFieldLabel)
                    .addComponent(whereFieldLabel))
                .addGap(10, 10, 10)
                .addGroup(matchPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(andRB)
                    .addComponent(andField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(whereValueFieldLabel1)
                    .addComponent(andValue, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(10, 10, 10)
                .addGroup(matchPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(orRB)
                    .addComponent(whereValueFieldLabel2)
                    .addComponent(orField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(orValue, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(matchPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(matchPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(rangeRB)
                        .addComponent(rangeFromVal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel1))
                    .addComponent(rangeToVal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 32, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(matchPanel, javax.swing.GroupLayout.DEFAULT_SIZE, 488, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(matchPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void RBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RBActionPerformed
        if(evt.getSource().equals(andRB))
        {
            if(andRB.isSelected())
            {
                andField.setEnabled(true);
                andValue.setEnabled(true);
                orRB.setSelected(false);
                orField.setEnabled(false);
                orValue.setEnabled(false);
                rangeRB.setSelected(false);
                rangeFromVal.setEnabled(false);
                rangeToVal.setEnabled(false);
                valueTextArea.setEnabled(true);
            }
            else
            {
                andField.setEnabled(false);
                andValue.setEnabled(false);
                valueTextArea.setEnabled(true);
            }
        }
            
        if(evt.getSource().equals(orRB))
        {
            if(orRB.isSelected())
            {
                orField.setEnabled(true);
                orValue.setEnabled(true);
                andRB.setSelected(false);
                andField.setEnabled(false);
                andValue.setEnabled(false);
                rangeRB.setSelected(false);
                rangeFromVal.setEnabled(false);
                rangeToVal.setEnabled(false);
                valueTextArea.setEnabled(true);
            }
            else
            {
                orField.setEnabled(false);
                orValue.setEnabled(false);
                valueTextArea.setEnabled(true);
            }
        }
        else
        {
            if(rangeRB.isSelected())
            {
                rangeFromVal.setEnabled(true);
                rangeToVal.setEnabled(true);
                andRB.setSelected(false);
                andField.setEnabled(false);
                andValue.setEnabled(false);
                orRB.setSelected(false);
                orField.setEnabled(false);
                orValue.setEnabled(false);
                valueTextArea.setEnabled(false);
            }
            else
            {
                rangeFromVal.setEnabled(false);
                rangeToVal.setEnabled(false);
                valueTextArea.setEnabled(true);
            }
        }
    }//GEN-LAST:event_RBActionPerformed

    protected String executeConditionalQuery(DBCollection collection, QueryCollectionDialog parent)
    {
        this.parent = parent;
        BasicDBObject query = null;
        DBCursor cursor = null;
        String result = "";
        this.QueryString = "";
        
        /**
         * First and foremost determine which condition was selected and jump to respective method accordingly...
         */
        
        if(andRB.isSelected())
        {
            QueryString += Initializations.WHERE_SYNTAX + fieldTextArea.getText() + Initializations.EQUALS_SYNTAX + valueTextArea.getText() + "\n";
            QueryString += Initializations.AND_SYNTAX + andField.getText() + Initializations.EQUALS_SYNTAX + andValue.getText() + "\n";
            query = getAndQueryDBObject(fieldTextArea.getText(), valueTextArea.getText(), andField.getText(), andValue.getText());
        }
        
        else if(orRB.isSelected())
        {
            QueryString += Initializations.WHERE_SYNTAX + fieldTextArea.getText() + Initializations.EQUALS_SYNTAX + valueTextArea.getText() + "\n";
            QueryString += Initializations.OR_SYNTAX + orField.getText() + Initializations.EQUALS_SYNTAX + orValue.getText() + "\n";
            query = getOrQueryDBObject(fieldTextArea.getText(), valueTextArea.getText(), orField.getText(), orValue.getText());
        }
        
        else if(rangeRB.isSelected())
        {
            int fromVal = -1; 
            int toVal = -1; 
            
            try
            {
                fromVal = Integer.parseInt(rangeFromVal.getText());
                toVal = Integer.parseInt(rangeToVal.getText());
            }
            catch(Exception ex)
            {
                return Initializations.INTEGERPARSEERROR;
            }
            
            QueryString += Initializations.WHERE_SYNTAX + fieldTextArea.getText() + Initializations.BETWEEN_SYNTAX + fromVal + " " + Initializations.AND_SYNTAX + toVal + "\n";
            query = getRangeQueryDBObject(fieldTextArea.getText(), fromVal, toVal);
        }
        else //just a normal select * from where x = y
        {
            QueryString += Initializations.WHERE_SYNTAX + fieldTextArea.getText() + Initializations.EQUALS_SYNTAX + valueTextArea.getText() + "\n";
            query = new BasicDBObject(fieldTextArea.getText(), valueTextArea.getText());
        }
        
        try
        {
            if(this.parent.orderByRB.isSelected())
            {
                if(this.parent.descendingRB.isSelected())
                {
                    QueryString += Initializations.ORDER_BY_SYNTAX + this.parent.orderByTF.getText() + Initializations.DESCENDING_SYNTAX + "\n";
                    cursor = collection.find(query).sort(new BasicDBObject(this.parent.orderByTF.getText(), -1));
                }
                else
                {
                    QueryString += Initializations.ORDER_BY_SYNTAX + this.parent.orderByTF.getText() + Initializations.ASCENDING_SYNTAX + "\n";
                    cursor = collection.find(query).sort(new BasicDBObject(this.parent.orderByTF.getText(), 1));
                }
            }
            else
            {
                cursor = collection.find(query);
            }
            
            while(cursor.hasNext())
            {
                result += cursor.next().toString() + "\n\n";
            }
        }
        catch(Exception exp)
        {
            return Initializations.QUERYGENERALERROR;
        }        
     
        return result;
    }
    
    private BasicDBObject getAndQueryDBObject(String whereField, String whereVal, String andField, String andVal)
    {
        BasicDBObject andQuery = new BasicDBObject();
        List<BasicDBObject> objList = new ArrayList<BasicDBObject>();
        objList.add(new BasicDBObject(whereField, whereVal));
        objList.add(new BasicDBObject(andField, andVal));
        andQuery.put("$and", objList);
        
        return andQuery;
    }
    
    private BasicDBObject getOrQueryDBObject(String whereField, String whereVal, String orField, String orVal)
    {
        BasicDBObject orQuery = new BasicDBObject();
        List<BasicDBObject> objList = new ArrayList<BasicDBObject>();
        objList.add(new BasicDBObject(whereField, whereVal));
        objList.add(new BasicDBObject(orField, orVal));
        orQuery.put("$or", objList);
        
        return orQuery;
    }
    
    private BasicDBObject getRangeQueryDBObject(String rangeField, int fromValue, int toValue)
    {
        BasicDBObject rangedQuery = new BasicDBObject();
        rangedQuery.put(rangeField, new BasicDBObject("$gte", fromValue).append("$lte", toValue));
        return rangedQuery;
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    protected javax.swing.JTextField andField;
    private javax.swing.JRadioButton andRB;
    protected javax.swing.JTextField andValue;
    protected javax.swing.JTextField fieldTextArea;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel matchPanel;
    protected javax.swing.JTextField orField;
    private javax.swing.JRadioButton orRB;
    protected javax.swing.JTextField orValue;
    protected javax.swing.JTextField rangeFromVal;
    private javax.swing.JRadioButton rangeRB;
    protected javax.swing.JTextField rangeToVal;
    protected javax.swing.JTextField valueTextArea;
    private javax.swing.JLabel whereFieldLabel;
    private javax.swing.JLabel whereValueFieldLabel;
    private javax.swing.JLabel whereValueFieldLabel1;
    private javax.swing.JLabel whereValueFieldLabel2;
    // End of variables declaration//GEN-END:variables
}
