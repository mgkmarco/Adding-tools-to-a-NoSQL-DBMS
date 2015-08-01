/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nosqltools;

/**
 *
 * @author mgalea
 */
public class ConditionalPanel extends javax.swing.JPanel {

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
        ValueTextArea = new javax.swing.JTextField();
        FieldTextArea = new javax.swing.JTextField();
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
        betweenRB = new javax.swing.JRadioButton();
        orField1 = new javax.swing.JTextField();
        orValue1 = new javax.swing.JTextField();

        setMaximumSize(new java.awt.Dimension(471, 135));
        setMinimumSize(new java.awt.Dimension(471, 135));

        matchPanel.setMaximumSize(new java.awt.Dimension(471, 135));
        matchPanel.setMinimumSize(new java.awt.Dimension(471, 135));
        matchPanel.setPreferredSize(new java.awt.Dimension(471, 135));

        FieldTextArea.setMaximumSize(new java.awt.Dimension(6, 20));

        whereValueFieldLabel.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        whereValueFieldLabel.setText("Has Value = ");
        whereValueFieldLabel.setFocusable(false);

        whereFieldLabel.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        whereFieldLabel.setText("Where Field:");

        andField.setEnabled(false);

        andValue.setEnabled(false);

        andRB.setSelected(true);
        andRB.setText("AND");

        whereValueFieldLabel1.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        whereValueFieldLabel1.setText("Has Value = ");
        whereValueFieldLabel1.setFocusable(false);

        orRB.setSelected(true);
        orRB.setText("OR");

        whereValueFieldLabel2.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        whereValueFieldLabel2.setText("Has Value = ");
        whereValueFieldLabel2.setFocusable(false);

        orField.setEnabled(false);

        orValue.setEnabled(false);

        betweenRB.setText("RANGE");

        orField1.setEnabled(false);
        orField1.setMaximumSize(new java.awt.Dimension(6, 20));

        orValue1.setEnabled(false);

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
                            .addComponent(FieldTextArea, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(andField)
                            .addComponent(orField, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addGap(18, 18, 18)
                        .addGroup(matchPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(matchPanelLayout.createSequentialGroup()
                                .addComponent(whereValueFieldLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(orValue, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, matchPanelLayout.createSequentialGroup()
                                .addComponent(whereValueFieldLabel)
                                .addGap(29, 29, 29)
                                .addComponent(ValueTextArea, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, matchPanelLayout.createSequentialGroup()
                                .addComponent(whereValueFieldLabel1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(andValue, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(matchPanelLayout.createSequentialGroup()
                        .addComponent(betweenRB)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(orField1, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(119, 119, 119)
                        .addComponent(orValue1, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE))))
        );
        matchPanelLayout.setVerticalGroup(
            matchPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(matchPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(matchPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(ValueTextArea, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(FieldTextArea, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
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
                        .addComponent(betweenRB)
                        .addComponent(orField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(orValue1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 32, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(matchPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(matchPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    protected javax.swing.JTextField FieldTextArea;
    protected javax.swing.JTextField ValueTextArea;
    protected javax.swing.JTextField andField;
    private javax.swing.JRadioButton andRB;
    protected javax.swing.JTextField andValue;
    private javax.swing.JRadioButton betweenRB;
    private javax.swing.JPanel matchPanel;
    protected javax.swing.JTextField orField;
    protected javax.swing.JTextField orField1;
    private javax.swing.JRadioButton orRB;
    protected javax.swing.JTextField orValue;
    protected javax.swing.JTextField orValue1;
    private javax.swing.JLabel whereFieldLabel;
    private javax.swing.JLabel whereValueFieldLabel;
    private javax.swing.JLabel whereValueFieldLabel1;
    private javax.swing.JLabel whereValueFieldLabel2;
    // End of variables declaration//GEN-END:variables
}
