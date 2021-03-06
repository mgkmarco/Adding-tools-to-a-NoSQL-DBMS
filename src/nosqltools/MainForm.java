/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nosqltools;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.mongodb.DB;
import com.mongodb.MongoClient;
import com.mongodb.ServerAddress;
import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;
import javax.swing.tree.TreePath;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.net.UnknownHostException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPopupMenu;
import javax.swing.JProgressBar;
import javax.swing.SwingUtilities;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.BadLocationException;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeCellRenderer;
import javax.swing.tree.DefaultTreeModel;
import org.fife.ui.rtextarea.*;
import org.fife.ui.rsyntaxtextarea.*;
import org.json.simple.parser.JSONParser;


public class MainForm extends javax.swing.JFrame {

    private final JSONUtilities json_util = new JSONUtilities();
    private final Utilities util = new Utilities();
    StringBuilder sb = new StringBuilder();
    private File file = null;   
    RSyntaxTextArea textArea;
    RSyntaxTextArea textArea1Comp;
    RSyntaxTextArea textArea2Comp;
    JSONParser parser = new JSONParser();
    ObjectMapper mapper = new ObjectMapper();
    protected DBConnection dbcon = new DBConnection();
    protected static JProgressBar progBar;
    protected TreePath tp;
    protected int indexOfCurrentCollection;
    
    final JFileChooser fc = new JFileChooser();
    String[] ext_array = new String[]{Initializations.TXT, Initializations.JSON};
    String ext = util.formatExtentsions(ext_array);
    FileNameExtensionFilter filter = new FileNameExtensionFilter("Text Files (" + ext + ")", ext_array);

    
    /**
     * Creates new form MainForm and sets the necessary properties for the main
     * form
     */
    public MainForm() {  
        Image img = null;
        try {
            img = ImageIO.read(new File("resources/mongoicon.png"));
        } catch (IOException e) {
        }
        this.setIconImage(img);
        initComponents();
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        fc.setFileFilter(filter);
         
        textArea = new RSyntaxTextArea(20, 60);
        textArea.setSyntaxEditingStyle(SyntaxConstants.SYNTAX_STYLE_JSON);
        textArea.setCodeFoldingEnabled(true);
        textArea.setAntiAliasingEnabled(true);
         Table_JSON.addMouseListener(new java.awt.event.MouseAdapter() {
        @Override
        public void mouseClicked(java.awt.event.MouseEvent evt) {
            int row = Table_JSON.rowAtPoint(evt.getPoint());
            int col = Table_JSON.columnAtPoint(evt.getPoint());
            
            
            JOptionPane.showMessageDialog(null,"Value in the cell clicked :" + " "+ Table_JSON.getValueAt(row,col).toString());

            if(json_util.isArray(Table_JSON.getValueAt(row,col).toString()))
            {
                if(JOptionPane.showConfirmDialog( null, "View the array as a table:",
                                 "VIEW", JOptionPane.OK_CANCEL_OPTION) == JOptionPane.YES_OPTION)
                {
                    Panel_Views.setEnabled(false);
                    Panel_Connections.setEnabled(false);
                    jMenuBar1.setEnabled(false);


                    if (row >= 0 && col >= 0) {

                        TableForm tableForm = new TableForm(Table_JSON.getValueAt(row,col).toString());
                    }
                }
            }
        }
        });
        RTextScrollPane sp = new RTextScrollPane(textArea);
        sp.setFoldIndicatorEnabled(true);
        Panel_Text.add(sp);
        Save_File.setEnabled(false);
        

        Panel_Text.setVisible(false);
        Panel_Table.setVisible(false);
        Panel_Hierarchical.setVisible(false);
        Panel_Compare.setVisible(false);
        Panel_Compare_Upper.setVisible(false);
        Panel_Connect.setVisible(false);
        
        util.changeTextAreaTheme(textArea);

        this.setVisible(true);
        btStartLoginDialog.setVisible(false);
        btStartLoginDialog.doClick();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        rootPopupMenu = new javax.swing.JPopupMenu();
        addCollectionMenuItem = new javax.swing.JMenuItem();
        deleteCollectionMenuItem = new javax.swing.JMenuItem();
        collectionPopupMenu = new javax.swing.JPopupMenu();
        queryCollectionMenuItem = new javax.swing.JMenuItem();
        jSplitPane1 = new javax.swing.JSplitPane();
        Panel_Connections = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTree1 = new javax.swing.JTree();
        UsersScrollPane = new javax.swing.JScrollPane();
        jList2 = new javax.swing.JList();
        DBScrollPane = new javax.swing.JScrollPane();
        DBList = new javax.swing.JList();
        Panel_Views = new javax.swing.JPanel();
        Panel_Text = new javax.swing.JPanel();
        Panel_Hierarchical = new javax.swing.JPanel();
        jScrollPane4 = new javax.swing.JScrollPane();
        jTreeHierarchicalJson = new javax.swing.JTree();
        Panel_Table = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        Table_JSON = new javax.swing.JTable();
        Panel_Compare = new javax.swing.JPanel();
        ComparePane = new javax.swing.JSplitPane();
        jScrollPane6 = new javax.swing.JScrollPane();
        Compare_ResultText = new javax.swing.JTextArea();
        Panel_Compare_Upper = new javax.swing.JPanel();
        left_label = new javax.swing.JLabel();
        left_obj_to_array = new javax.swing.JCheckBox();
        Compare_Button = new javax.swing.JButton();
        right_obj_to_array = new javax.swing.JCheckBox();
        right_label = new javax.swing.JLabel();
        Panel_Connect = new javax.swing.JPanel();
        Text_MessageBar = new javax.swing.JTextField();
        btStartLoginDialog = new javax.swing.JButton();
        jMenuBar1 = new javax.swing.JMenuBar();
        Menu_File = new javax.swing.JMenu();
        Import_JSON = new javax.swing.JMenuItem();
        Save_File = new javax.swing.JMenuItem();
        Save_Mongo = new javax.swing.JMenuItem();
        addUserMenuItem = new javax.swing.JMenuItem();
        viewUsersMenuItem = new javax.swing.JMenuItem();
        viewDBMenuItem = new javax.swing.JMenuItem();
        viewAllDBsMenuItem = new javax.swing.JMenuItem();
        connect_DB = new javax.swing.JMenuItem();
        file_close = new javax.swing.JMenuItem();
        Menu_Views = new javax.swing.JMenu();
        View_Text = new javax.swing.JMenuItem();
        View_Hierarchical = new javax.swing.JMenuItem();
        View_Table = new javax.swing.JMenuItem();
        Menu_Operations = new javax.swing.JMenu();
        Op_Compare = new javax.swing.JMenuItem();
        Op_Validate = new javax.swing.JMenuItem();
        Op_Refresh = new javax.swing.JMenuItem();
        Op_DBActions = new javax.swing.JMenuItem();
        Menu_Collections = new javax.swing.JMenu();
        jSeparator5 = new javax.swing.JPopupMenu.Separator();
        Import_File = new javax.swing.JMenuItem();
        Export_File = new javax.swing.JMenuItem();
        jSeparator3 = new javax.swing.JPopupMenu.Separator();
        addCollection = new javax.swing.JMenuItem();
        dropCollectionMenuItem = new javax.swing.JMenuItem();
        jSeparator4 = new javax.swing.JPopupMenu.Separator();
        QueryCollectionMenuItem = new javax.swing.JMenuItem();
        toolsMenu = new javax.swing.JMenu();
        installMongoDB = new javax.swing.JMenuItem();
        uninstallMongoDBMenuItem = new javax.swing.JMenuItem();
        jSeparator1 = new javax.swing.JPopupMenu.Separator();
        startServerMenuItem = new javax.swing.JMenuItem();
        stopServerMenuItem = new javax.swing.JMenuItem();
        jSeparator2 = new javax.swing.JPopupMenu.Separator();
        startClientMenuItem = new javax.swing.JMenuItem();
        stopClientMenuItem = new javax.swing.JMenuItem();

        addCollectionMenuItem.setText("Add Collection");
        addCollectionMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addCollectionMenuItemActionPerformed(evt);
            }
        });
        rootPopupMenu.add(addCollectionMenuItem);

        deleteCollectionMenuItem.setText("Drop Collection");
        deleteCollectionMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteCollectionMenuItemActionPerformed(evt);
            }
        });
        rootPopupMenu.add(deleteCollectionMenuItem);

        queryCollectionMenuItem.setText("Query Collection");
        queryCollectionMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                QueryCollectionActionPerformed(evt);
            }
        });
        collectionPopupMenu.add(queryCollectionMenuItem);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Mongo View");

        jSplitPane1.setDividerLocation(200);
        jSplitPane1.setPreferredSize(new java.awt.Dimension(568, 453));

        Panel_Connections.setMaximumSize(new java.awt.Dimension(23, 535));
        Panel_Connections.setMinimumSize(new java.awt.Dimension(23, 535));

        jScrollPane2.setViewportView(jTree1);
        jTree1.setModel(null);

        jList2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jList2MouseClicked(evt);
            }
        });
        UsersScrollPane.setViewportView(jList2);

        DBList.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                DBListMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                DBListMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                DBListMouseExited(evt);
            }
        });
        DBScrollPane.setViewportView(DBList);

        javax.swing.GroupLayout Panel_ConnectionsLayout = new javax.swing.GroupLayout(Panel_Connections);
        Panel_Connections.setLayout(Panel_ConnectionsLayout);
        Panel_ConnectionsLayout.setHorizontalGroup(
            Panel_ConnectionsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 23, Short.MAX_VALUE)
            .addGroup(Panel_ConnectionsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(UsersScrollPane, javax.swing.GroupLayout.DEFAULT_SIZE, 23, Short.MAX_VALUE))
            .addGroup(Panel_ConnectionsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(DBScrollPane, javax.swing.GroupLayout.DEFAULT_SIZE, 23, Short.MAX_VALUE))
        );
        Panel_ConnectionsLayout.setVerticalGroup(
            Panel_ConnectionsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 535, Short.MAX_VALUE)
            .addGroup(Panel_ConnectionsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(UsersScrollPane, javax.swing.GroupLayout.DEFAULT_SIZE, 535, Short.MAX_VALUE))
            .addGroup(Panel_ConnectionsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(DBScrollPane, javax.swing.GroupLayout.DEFAULT_SIZE, 535, Short.MAX_VALUE))
        );

        jSplitPane1.setLeftComponent(Panel_Connections);

        Panel_Text.setLayout(new java.awt.BorderLayout());

        Panel_Hierarchical.setLayout(new java.awt.BorderLayout());

        jScrollPane4.setViewportView(jTreeHierarchicalJson);

        Panel_Hierarchical.add(jScrollPane4, java.awt.BorderLayout.CENTER);

        Panel_Table.setLayout(new java.awt.BorderLayout());

        jScrollPane3.setSize(Panel_Table.getSize());

        Table_JSON.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane3.setViewportView(Table_JSON);
        Table_JSON.setSize(Panel_Table.getSize());

        Panel_Table.add(jScrollPane3, java.awt.BorderLayout.CENTER);

        Panel_Compare.setPreferredSize(new java.awt.Dimension(1203, 511));
        Panel_Compare.setLayout(new java.awt.BorderLayout(2, 2));

        ComparePane.setResizeWeight(0.5);
        ComparePane.setToolTipText("");
        Panel_Compare.add(ComparePane, java.awt.BorderLayout.CENTER);

        Compare_ResultText.setColumns(20);
        Compare_ResultText.setRows(5);
        Compare_ResultText.setDisabledTextColor(new java.awt.Color(0, 51, 0));
        Compare_ResultText.setEnabled(false);
        jScrollPane6.setViewportView(Compare_ResultText);

        Panel_Compare.add(jScrollPane6, java.awt.BorderLayout.PAGE_END);

        Panel_Compare_Upper.setPreferredSize(new java.awt.Dimension(75, 23));

        left_label.setText("Document 1");
        Panel_Compare_Upper.add(left_label);
        Font font = new Font("Courier", Font.BOLD,12);
        left_label.setFont(font);

        left_obj_to_array.setText("Convert Document 1 to Array");
        left_obj_to_array.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                left_obj_to_arrayActionPerformed(evt);
            }
        });
        Panel_Compare_Upper.add(left_obj_to_array);

        Compare_Button.setText("Compare");
        Compare_Button.setPreferredSize(new java.awt.Dimension(100, 20));
        Compare_Button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Compare_ButtonActionPerformed(evt);
            }
        });
        Panel_Compare_Upper.add(Compare_Button);

        right_obj_to_array.setText("Convert Document 2 to Array");
        right_obj_to_array.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                right_obj_to_arrayActionPerformed(evt);
            }
        });
        Panel_Compare_Upper.add(right_obj_to_array);

        right_label.setText("Document 2");
        Panel_Compare_Upper.add(right_label);
        right_label.setFont(font);

        Panel_Compare.add(Panel_Compare_Upper, java.awt.BorderLayout.NORTH);

        Panel_Connect.setLayout(new java.awt.BorderLayout());

        javax.swing.GroupLayout Panel_ViewsLayout = new javax.swing.GroupLayout(Panel_Views);
        Panel_Views.setLayout(Panel_ViewsLayout);
        Panel_ViewsLayout.setHorizontalGroup(
            Panel_ViewsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Panel_Text, javax.swing.GroupLayout.DEFAULT_SIZE, 1450, Short.MAX_VALUE)
            .addGroup(Panel_ViewsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(Panel_Hierarchical, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(Panel_ViewsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(Panel_Table, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(Panel_ViewsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(Panel_ViewsLayout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(Panel_Compare, javax.swing.GroupLayout.DEFAULT_SIZE, 1331, Short.MAX_VALUE)
                    .addGap(0, 0, Short.MAX_VALUE)))
            .addGroup(Panel_ViewsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(Panel_ViewsLayout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(Panel_Connect, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        Panel_ViewsLayout.setVerticalGroup(
            Panel_ViewsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Panel_Text, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 535, Short.MAX_VALUE)
            .addGroup(Panel_ViewsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(Panel_Hierarchical, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(Panel_ViewsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(Panel_Table, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(Panel_ViewsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(Panel_ViewsLayout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(Panel_Compare, javax.swing.GroupLayout.DEFAULT_SIZE, 533, Short.MAX_VALUE)
                    .addGap(0, 0, Short.MAX_VALUE)))
            .addGroup(Panel_ViewsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(Panel_ViewsLayout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(Panel_Connect, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );

        Panel_Hierarchical.setSize(Panel_Views.getSize());
        Panel_Table.setSize(Panel_Views.getSize());

        jSplitPane1.setRightComponent(Panel_Views);

        Text_MessageBar.setEditable(false);
        Text_MessageBar.setForeground(new java.awt.Color(255, 0, 0));

        btStartLoginDialog.setText("jButton1");
        btStartLoginDialog.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btStartLoginDialogActionPerformed(evt);
            }
        });

        Menu_File.setText("File");
        Menu_File.setName(""); // NOI18N

        Import_JSON.setText("Open JSON file");
        Import_JSON.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Import_JSONActionPerformed(evt);
            }
        });
        Menu_File.add(Import_JSON);

        Save_File.setText("Save File");
        Save_File.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Save_FileActionPerformed(evt);
            }
        });
        Menu_File.add(Save_File);

        Save_Mongo.setText("Save to MongoDB");
        Save_Mongo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Save_MongoActionPerformed(evt);
            }
        });
        Menu_File.add(Save_Mongo);

        addUserMenuItem.setText("Add User");
        addUserMenuItem.setEnabled(false);
        addUserMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addUserMenuItemActionPerformed(evt);
            }
        });
        Menu_File.add(addUserMenuItem);

        viewUsersMenuItem.setText("View Users");
        viewUsersMenuItem.setEnabled(false);
        viewUsersMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                viewUsersMenuItemActionPerformed(evt);
            }
        });
        Menu_File.add(viewUsersMenuItem);

        viewDBMenuItem.setText("View DB");
        viewDBMenuItem.setEnabled(false);
        viewDBMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                viewDBMenuItemActionPerformed(evt);
            }
        });
        Menu_File.add(viewDBMenuItem);

        viewAllDBsMenuItem.setText("Show Databases");
        viewAllDBsMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                viewAllDBsMenuItemActionPerformed(evt);
            }
        });
        Menu_File.add(viewAllDBsMenuItem);

        connect_DB.setText("Connect");
        connect_DB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                connect_DBActionPerformed(evt);
            }
        });
        Menu_File.add(connect_DB);

        file_close.setText("Close");
        file_close.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                file_closeActionPerformed(evt);
            }
        });
        Menu_File.add(file_close);

        jMenuBar1.add(Menu_File);

        Menu_Views.setText("Views");

        View_Text.setText("Text");
        View_Text.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                View_TextActionPerformed(evt);
            }
        });
        Menu_Views.add(View_Text);

        View_Hierarchical.setText("Hierarchical");
        View_Hierarchical.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                View_HierarchicalActionPerformed(evt);
            }
        });
        Menu_Views.add(View_Hierarchical);

        View_Table.setText("Table");
        View_Table.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                View_TableActionPerformed(evt);
            }
        });
        Menu_Views.add(View_Table);

        jMenuBar1.add(Menu_Views);

        Menu_Operations.setText("Operations");

        Op_Compare.setText("Compare");
        Op_Compare.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Op_CompareActionPerformed(evt);
            }
        });
        Menu_Operations.add(Op_Compare);

        Op_Validate.setText("Validate");
        Op_Validate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Op_ValidateActionPerformed(evt);
            }
        });
        Menu_Operations.add(Op_Validate);

        Op_Refresh.setText("Refresh");
        Op_Refresh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Op_RefreshActionPerformed(evt);
            }
        });
        Menu_Operations.add(Op_Refresh);

        Op_DBActions.setText("Database Actions");
        Op_DBActions.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Op_DBActionsActionPerformed(evt);
            }
        });
        Menu_Operations.add(Op_DBActions);

        jMenuBar1.add(Menu_Operations);

        Menu_Collections.setText("Collections");
        Menu_Collections.add(jSeparator5);

        Import_File.setText("Import File");
        Import_File.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Import_FileActionPerformed(evt);
            }
        });
        Menu_Collections.add(Import_File);

        Export_File.setText("Export File");
        Export_File.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Export_FileActionPerformed(evt);
            }
        });
        Menu_Collections.add(Export_File);
        Menu_Collections.add(jSeparator3);

        addCollection.setText("Add Collection");
        addCollection.setEnabled(false);
        addCollection.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addCollectionMenuItemActionPerformed(evt);
            }
        });
        Menu_Collections.add(addCollection);

        dropCollectionMenuItem.setText("Drop Collection");
        dropCollectionMenuItem.setEnabled(false);
        dropCollectionMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteCollectionMenuItemActionPerformed(evt);
            }
        });
        Menu_Collections.add(dropCollectionMenuItem);
        Menu_Collections.add(jSeparator4);

        QueryCollectionMenuItem.setText("Query Collection");
        QueryCollectionMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                QueryCollectionActionPerformed(evt);
            }
        });
        Menu_Collections.add(QueryCollectionMenuItem);

        jMenuBar1.add(Menu_Collections);

        toolsMenu.setText("Tools");
        toolsMenu.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                toolsMenuMouseClicked(evt);
            }
        });

        installMongoDB.setText("Install MongoDB");
        installMongoDB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                installMongoDBActionPerformed(evt);
            }
        });
        toolsMenu.add(installMongoDB);

        uninstallMongoDBMenuItem.setText("Uninstall MongoDB");
        uninstallMongoDBMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                uninstallMongoDBMenuItemActionPerformed(evt);
            }
        });
        toolsMenu.add(uninstallMongoDBMenuItem);
        toolsMenu.add(jSeparator1);

        startServerMenuItem.setText("Start Server (mongod.exe)");
        startServerMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                startServerMenuItemActionPerformed(evt);
            }
        });
        toolsMenu.add(startServerMenuItem);

        stopServerMenuItem.setText("Stop Server (mongod.exe)");
        stopServerMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                stopServerMenuItemActionPerformed(evt);
            }
        });
        toolsMenu.add(stopServerMenuItem);
        toolsMenu.add(jSeparator2);

        startClientMenuItem.setText("Start Client (mongo.exe)");
        startClientMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                startClientMenuItemActionPerformed(evt);
            }
        });
        toolsMenu.add(startClientMenuItem);

        stopClientMenuItem.setText("Stop Client (mongo.exe)");
        stopClientMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                stopClientMenuItemActionPerformed(evt);
            }
        });
        toolsMenu.add(stopClientMenuItem);

        jMenuBar1.add(toolsMenu);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(btStartLoginDialog)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Text_MessageBar, javax.swing.GroupLayout.DEFAULT_SIZE, 1421, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jSplitPane1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jSplitPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 537, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Text_MessageBar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btStartLoginDialog)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * This method is an event listener which sets the UI necessary when the 
     * View Text option is done 
     * @param evt 
     */
    private void View_TextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_View_TextActionPerformed
        Panel_Text.setVisible(true);
        Text_MessageBar.setText(Initializations.INITSTRING);
        Panel_Hierarchical.setVisible(false);
        Panel_Table.setVisible(false);
        Panel_Compare.setVisible(false);
        Panel_Compare_Upper.setVisible(false);
        Panel_Connect.setVisible(false);
    }//GEN-LAST:event_View_TextActionPerformed

    /**
     *  The View_HierarchicalActionPerformed method is an event handler which
     * sets the UI for the Hierarchical if the Text View is not empty   
     * @param evt 
     */
    private void View_HierarchicalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_View_HierarchicalActionPerformed
        if(!textArea.getText().isEmpty())        
        {
            Panel_Text.setVisible(false);
            Panel_Hierarchical.setVisible(true);
            Panel_Table.setVisible(false);
            Panel_Compare.setVisible(false);
            Panel_Compare_Upper.setVisible(false);
            Panel_Connect.setVisible(false);

            jTreeHierarchicalJson.setVisible(true);
            jTreeHierarchicalJson.setModel(null);
            
            //parse the text within the text view and set model if JSON object is correct
            if (!textArea.getText().trim().equals("") && json_util.isDataParsed(textArea.getText()))
            {
                jTreeHierarchicalJson.setModel(json_util.makeJtreeModel("Collection"));
            }
            else //parsing error
            {
                Text_MessageBar.setText(Initializations.JSONINCORRECTFORMAT);
                Text_MessageBar.setForeground(Color.RED);
                JOptionPane.showMessageDialog(null, Initializations.JSONINCORRECTFORMAT, "Error", JOptionPane.ERROR_MESSAGE);
            }
        }else //case when no text is found
        {
            Text_MessageBar.setText(Initializations.NOTEXT);
            Text_MessageBar.setForeground(Color.RED);
            JOptionPane.showMessageDialog(null, Initializations.NOTEXT, "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_View_HierarchicalActionPerformed

    /**
     * The View_TableActionPerformed is an event handler which sets the Table View
     * if text is found within the Text View and if correct JSON objects are found
     * @param evt 
     */
    private void View_TableActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_View_TableActionPerformed
        if(!textArea.getText().isEmpty())        
        {
            Panel_Text.setVisible(false);
        
            Panel_Hierarchical.setVisible(false);
        
            Panel_Compare.setVisible(false);
            Panel_Compare_Upper.setVisible(false);
            Panel_Connect.setVisible(false);

            //parsing
            if (json_util.isDataParsed(textArea.getText()))
            {
                Panel_Table.setVisible(true);
                String[] json_field_names = json_util.getFields();
                String[][] json_row_data = json_util.getRows(json_field_names);
                DefaultTableModel model = (DefaultTableModel) Table_JSON.getModel();
                Table_JSON.setModel(new DefaultTableModel(json_row_data, json_field_names));
            }
            else //case for incorrect JSON format
            {
                Text_MessageBar.setText(Initializations.JSONINCORRECTFORMAT);
                Text_MessageBar.setForeground(Color.RED);
                JOptionPane.showMessageDialog(null, Initializations.JSONINCORRECTFORMAT, "Error", JOptionPane.ERROR_MESSAGE);
            }
        }else //case for no JSON objects found
        {
            Text_MessageBar.setText(Initializations.NOTEXT);
            Text_MessageBar.setForeground(Color.RED);
            JOptionPane.showMessageDialog(null, Initializations.NOTEXT, "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_View_TableActionPerformed

    /**
     * This method is an event handler which is used to import a JSON or text file
     * chosen by the user and determines its correctness
     * @param evt 
     */
    private void Import_JSONActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Import_JSONActionPerformed
        file = null;
        sb.setLength(0);

        int returnVal = fc.showOpenDialog(this);
        if (returnVal == JFileChooser.APPROVE_OPTION) 
        {
            Save_File.setEnabled(true);
            file = fc.getSelectedFile();
            sb.append(util.readFromFile(file));
                        
            Panel_Text.setVisible(true);
            Panel_Hierarchical.setVisible(false);
            Panel_Table.setVisible(false);
            Panel_Compare.setVisible(false);
            Panel_Compare_Upper.setVisible(false);
            Panel_Connect.setVisible(false);

            textArea.setText(Initializations.INITSTRING);
            textArea.setText(sb.toString());
            //validation
            validateDataPanel_text(sb);
        }
    }//GEN-LAST:event_Import_JSONActionPerformed

    /**
     * This event handler is used to save the JSON objects to the file chosen
     * @param evt 
     */
    private void Save_FileActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Save_FileActionPerformed
        try 
        {
            file = null;
            sb.setLength(0);

            //choosable file extensions 
            FileNameExtensionFilter filter = new FileNameExtensionFilter("Text Files (" + ext + ")", ext_array);
            fc.setFileFilter(filter);

            //save is OK
            int returnVal = fc.showSaveDialog(this);
            if (returnVal == JFileChooser.APPROVE_OPTION) 
            {
                Save_File.setEnabled(true);
                file = fc.getSelectedFile();
               
                parser.parse(textArea.getText());
                //parse data
                if(json_util.isDataParsed(textArea.getText()))
                {
                    try
                    {
                        BufferedWriter writer = new BufferedWriter(new FileWriter(fc.getSelectedFile()));
                        writer.write(textArea.getText());
                        writer.close();
                        Text_MessageBar.setText(Initializations.JSONSAVESUCCESS);
                        Text_MessageBar.setForeground(Color.GREEN);
                    } catch (FileNotFoundException ex) {
                        Logger.getLogger(MainForm.class.getName()).log(Level.SEVERE, null, ex);
                    } catch (IOException ex) {
                        Logger.getLogger(MainForm.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }else //case for saving error
                {
                    Text_MessageBar.setForeground(Color.RED);
                    Text_MessageBar.setText(Initializations.VALIDATIONERROR);
                    JOptionPane.showMessageDialog(null, Initializations.JSONSAVEERROR + Initializations.VALIDATIONERROR, "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        }
        catch(org.json.simple.parser.ParseException pe) //case for incorrect JSON object
        {
           Text_MessageBar.setForeground(Color.RED);
           Text_MessageBar.setText(Initializations.JSONSAVEERROR + Initializations.ERRORLINE + json_util.getLineNumber(pe.getPosition(), textArea.getText()) + " - " + pe);
        }
    }//GEN-LAST:event_Save_FileActionPerformed

    /**
     * This event handler is used to load the Compare operation and prepare for 
     * the necessary UI
     * @param evt 
     */
    private void Op_CompareActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Op_CompareActionPerformed
        Text_MessageBar.setText(Initializations.COMPARELOADED);
        Text_MessageBar.setForeground(Color.GREEN);
        //create a rsyntaxTextArea
        textArea1Comp = new RSyntaxTextArea();
        textArea1Comp.setSyntaxEditingStyle(SyntaxConstants.SYNTAX_STYLE_JSON);
        textArea1Comp.setCodeFoldingEnabled(true);
        textArea1Comp.setAntiAliasingEnabled(true);
        RTextScrollPane spComp1 = new RTextScrollPane(textArea1Comp);
        spComp1.setFoldIndicatorEnabled(true);
        util.changeTextAreaTheme(textArea1Comp);
        
        textArea2Comp = new RSyntaxTextArea();
        textArea2Comp.setSyntaxEditingStyle(SyntaxConstants.SYNTAX_STYLE_JSON);
        textArea2Comp.setCodeFoldingEnabled(true);
        textArea2Comp.setAntiAliasingEnabled(true);
        RTextScrollPane spComp2 = new RTextScrollPane(textArea2Comp);
        spComp2.setFoldIndicatorEnabled(true);
        util.changeTextAreaTheme(textArea2Comp);
        
        ComparePane.add(spComp1, ComparePane.LEFT, 60);
        ComparePane.add(spComp2, ComparePane.RIGHT, 60);
        
        Panel_Text.setVisible(false);
        Panel_Hierarchical.setVisible(false);
        Panel_Table.setVisible(false);
        Panel_Compare.setVisible(true);
        Panel_Compare_Upper.setVisible(true);
        Panel_Connect.setVisible(false);
        
        Compare_ResultText.setEditable(false);

    }//GEN-LAST:event_Op_CompareActionPerformed

    /**
     * This event handler will do comparison between the two JSON objects or JSON
     * Arrays inserted into the text.
     * @param evt 
     */
    private void Compare_ButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Compare_ButtonActionPerformed
        //check if empty
        if(!(textArea1Comp.getText().isEmpty() || textArea2Comp.getText().isEmpty()))
        {   Compare_ResultText.setText("");  
            //validate both text areas 
            if (json_util.isDataParsed(textArea1Comp.getText()) && json_util.isDataParsed(textArea2Comp.getText())) 
            {
                Text_MessageBar.setForeground(Color.GREEN);
                Text_MessageBar.setText(Initializations.JSONFILESUCCESS + Initializations.COMPARESTART);
                //call compare_result method found in JSONUtilitites
                try
                {
                    //Json Node created from document 1
                    JsonNode jNode1 = mapper.readTree(textArea1Comp.getText());
                    textArea1Comp.setText(mapper.writerWithDefaultPrettyPrinter().writeValueAsString(jNode1));
                    
                    //JsonNode created for document 2
                    JsonNode jNode2 = mapper.readTree(textArea2Comp.getText()); 
                    textArea2Comp.setText(mapper.writerWithDefaultPrettyPrinter().writeValueAsString(jNode2));

                    //compares the two Json Nodes and outputs the results
                    JsonNode jNodeCompRes = json_util.compareResult(jNode1, jNode2);

                    if (jNodeCompRes == null)
                    {
                        Text_MessageBar.setForeground(Color.RED);
                        Text_MessageBar.setText(Initializations.COMPAREFAIL); 
                        Compare_ResultText.setText(Initializations.COMPOBJARRERR);
                    }
                    else
                    {
                        Text_MessageBar.setForeground(Color.GREEN);
                        //Compare_ResultText.setText(jNodeCompRes.toString());
                        Compare_ResultText.setText(Initializations.SUMMARY + json_util.printDiff(jNodeCompRes));           
                        Text_MessageBar.setText(Initializations.COMPARESUCCESS); 
                    }        
                }
                catch (IOException e)
                {
                    e.printStackTrace();
                }
                // may need to cater for json processing exception

            } 
            else 
            {
                Text_MessageBar.setForeground(Color.RED);
                JOptionPane.showMessageDialog(this, Initializations.JSONINCORRECTFORMAT, Initializations.VALIDATIONERROR, JOptionPane.ERROR_MESSAGE);
                Text_MessageBar.setText(Initializations.COMPAREFAIL);
            }
        }
        else
        {
            Compare_ResultText.setText(Initializations.COMPAREEMPTY);
            Text_MessageBar.setText(Initializations.COMPAREEMPTY);
            Text_MessageBar.setForeground(Color.ORANGE);
            
        }
    }//GEN-LAST:event_Compare_ButtonActionPerformed

    private void left_obj_to_arrayActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_left_obj_to_arrayActionPerformed
        if (left_obj_to_array.isSelected()&& (json_util.isDataParsed(textArea1Comp.getText())))
        {
            try
            {
                if (textArea1Comp.getText().isEmpty())
                {
                    JOptionPane.showMessageDialog(this, Initializations.CONVERRDOC1, Initializations.CONVERR, JOptionPane.ERROR_MESSAGE);
                    Text_MessageBar.setText(Initializations.DOC1EMPTY);
                    Text_MessageBar.setForeground(Color.ORANGE);
                    left_obj_to_array.setSelected(false);
                }
                else
                {
                    JsonNode jNode1 = mapper.readTree(textArea1Comp.getText()); 
                    if (jNode1.isObject())
                    {
                        jNode1 = json_util.convertJArr(jNode1);
                        textArea1Comp.setText(mapper.writerWithDefaultPrettyPrinter().writeValueAsString(jNode1));
                    }
                    else
                    {
                        Text_MessageBar.setForeground(Color.ORANGE);
                        Text_MessageBar.setText(Initializations.OBJCONVERTED);
                    }
                    
                }
            }
            catch (IOException e)
            {
                e.printStackTrace();
            }
            
        }
    }//GEN-LAST:event_left_obj_to_arrayActionPerformed

    //method is used to validate data in Panel_text when a file is imported from file or when connected to the database to view collection data
    private void validateDataPanel_text(StringBuilder sb)
    {
        if (json_util.isValid(sb.toString())) 
            {
              //  json_util.isDataParsed(textArea.getText());
                if(json_util.isDataParsed(sb.toString()))
                {
                    Text_MessageBar.setText(Initializations.JSONFILESUCCESS);
                    Text_MessageBar.setForeground(Color.GREEN);
                }
                else
                {
                    Text_MessageBar.setText(Initializations.JSONINCORRECTFORMAT);
                    Text_MessageBar.setForeground(Color.ORANGE);
                    JOptionPane.showMessageDialog(null, Initializations.JSONINCORRECTFORMAT, "Error", JOptionPane.ERROR_MESSAGE);
                }
            } 
            else 
            {
                sb.setLength(0);
                JOptionPane.showMessageDialog(this, Initializations.JSONINCORRECTFORMAT , Initializations.VALIDATIONERROR , JOptionPane.ERROR_MESSAGE);
           
                try
                {
                    Object obj = parser.parse(sb.toString());
                }
                catch(org.json.simple.parser.ParseException pe)
                {
                   Text_MessageBar.setText(Initializations.ERRORLINE + json_util.getLineNumber(pe.getPosition(), textArea.getText()) + " - " + pe);
                   Text_MessageBar.setForeground(Color.ORANGE);
                }
            }
    }
    
    private void right_obj_to_arrayActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_right_obj_to_arrayActionPerformed
        if (right_obj_to_array.isSelected()&& (json_util.isDataParsed(textArea1Comp.getText())))
        {
            try
            {
                if (textArea2Comp.getText().isEmpty())
                {
                    JOptionPane.showMessageDialog(this, Initializations.CONVERRDOC2, Initializations.CONVERR, JOptionPane.ERROR_MESSAGE);
                    Text_MessageBar.setText("Document 2 is empty!");
                    Text_MessageBar.setForeground(Color.RED);
                    right_obj_to_array.setSelected(false);
                }
                else
                {
                    JsonNode jNode2 = mapper.readTree(textArea2Comp.getText()); 
                    if (jNode2.isObject())
                    {
                        jNode2 = json_util.convertJArr(jNode2);
                        textArea2Comp.setText(mapper.writerWithDefaultPrettyPrinter().writeValueAsString(jNode2));
                    }
                    else
                    {
                        Text_MessageBar.setText("Object is already converted to array!");
                        Text_MessageBar.setForeground(Color.ORANGE);
                    }
                    
                }
            }
            catch (IOException e)
            {
                e.printStackTrace();
            }
            
        }
    }//GEN-LAST:event_right_obj_to_arrayActionPerformed

    private void connect_DBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_connect_DBActionPerformed

        Panel_Text.setVisible(false);
        Panel_Hierarchical.setVisible(false);
        Panel_Table.setVisible(false);
        Panel_Compare.setVisible(false);
        Panel_Compare_Upper.setVisible(false);
        Panel_Connect.setVisible(true);
        
        Text_MessageBar.setText(Initializations.WAITINGFORCONNECTION);
        Text_MessageBar.setForeground(Color.ORANGE);
        if (dbcon.isConnectionSuccess())
        {
            if(dbcon.checkDatabaseConnection())
            {
                int result = JOptionPane.showConfirmDialog(null,"A connection to MongoDB"
                        + "already exists. Are you sure you want to disconnect and open "
                        + "a different connection?", "Confirm", JOptionPane.YES_NO_OPTION);

                if (result == JOptionPane.YES_OPTION)
                {
                    addCollection.setEnabled(false);
                    dropCollectionMenuItem.setEnabled(false);
                    dbcon.closeConnection();
                    connect();
                }
            }else
            {
                Text_MessageBar.setText(Initializations.MONGOSERVERERROR);
                Text_MessageBar.setForeground(Color.RED);
                JOptionPane.showMessageDialog(null, Initializations.MONGOSERVERERROR, "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
        else
        {
            connect();
        }            
    }//GEN-LAST:event_connect_DBActionPerformed

    private void Import_FileActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Import_FileActionPerformed
        Text_MessageBar.setText(Initializations.WAITINGFORCONNECTION);
        Text_MessageBar.setForeground(Color.ORANGE);
        if(dbcon.isConnectionSuccess())
        { 
            if(dbcon.checkDatabaseConnection())
            {
                List <String> connectionStrings = dbcon.getAllCollectionsLessSystem();
                connectionStrings.add(0, "none");
                ImportFileDialog dlg_import = new ImportFileDialog(null, connectionStrings);
                dlg_import.setVisible(true);
                
                if (dlg_import.isToImport())
                {
                    String collectionToImport = dlg_import.collectionToImport();
                    String typeToImport= dlg_import.typeToImport();
                    String locToImport = dlg_import.locToImport();

                    StringBuilder sb = new StringBuilder();

                    if(locToImport != null && !locToImport.isEmpty())
                    {
                       //Converting JSON to CSV and export it to file is done in the dbcon.export method
                        //Exporting JSON on the other hand, is done here
                        if ("CSV".equals(typeToImport))
                        {    
                            try {
                                if ("none".equals(collectionToImport))
                                {
                                    textArea.setText("");
                                    Panel_Text.setVisible(true);
                                    JsonNode jNode = mapper.readTree(dbcon.import_CSV(collectionToImport, typeToImport, locToImport));
                                    textArea.append(mapper.writerWithDefaultPrettyPrinter().writeValueAsString(jNode));
                                    Text_MessageBar.setForeground(Color.GREEN);
                                    Text_MessageBar.setText("Import to " + typeToImport + " has been successful.");
                                }     
                                else if (connectionStrings.contains(collectionToImport))
                                {
                                    sb = dbcon.getCollectionData(collectionToImport);

                                    if(sb != null)
                                    {
                                        Panel_Text.setVisible(true);

                                        JsonNode jNode1;
                                        try
                                        {
                                            jNode1 = mapper.readTree(sb.toString());
                                            textArea.setText(mapper.writerWithDefaultPrettyPrinter().writeValueAsString(jNode1));
                                            JsonNode jNode = mapper.readTree(dbcon.import_CSV(collectionToImport, typeToImport, locToImport));
                                            textArea.append(mapper.writerWithDefaultPrettyPrinter().writeValueAsString(jNode));
                                        } catch (IOException ex) 
                                        {
                                            Logger.getLogger(MainForm.class.getName()).log(Level.SEVERE, null, ex);
                                        } 


                                        Text_MessageBar.setText(Initializations.INITSTRING);
                                       // textArea.setText(sb.toString());
                                        validateDataPanel_text(sb);
                                    }
                                    else
                                    {
                                        Panel_Text.setVisible(false);
                                        Text_MessageBar.setText(Initializations.SYSTEMCOLL);
                                        Text_MessageBar.setForeground(Color.RED);
                                    }    

                                }

                                } 
                                catch (IOException ex) 
                                {
                                    Logger.getLogger(MainForm.class.getName()).log(Level.SEVERE, null, ex);
                                }
                            }
                        else
                        {
                                Text_MessageBar.setForeground(Color.RED);
                                Text_MessageBar.setText("Import to " + typeToImport + " has been unsuccessful."); 
                        } 
                  }
                    else
                        {
                            JOptionPane.showMessageDialog(this, Initializations.FILENOTFOUND , Initializations.IMPORTERROR , JOptionPane.ERROR_MESSAGE);
                            Text_MessageBar.setForeground(Color.RED);
                            Text_MessageBar.setText("Import to " + typeToImport + " has been unsuccessful.");
                        }
                            
                        }
                        
                
                else
                {
                    Text_MessageBar.setForeground(Color.ORANGE);
                    Text_MessageBar.setText("Export action has been aborted");
                } 
            }
            else
            {
                JOptionPane.showMessageDialog(null, Initializations.MONGOSERVERERROR, "Error", JOptionPane.ERROR_MESSAGE);
                Text_MessageBar.setText(Initializations.MONGOSERVERERROR);
                Text_MessageBar.setForeground(Color.RED);
            }
                
            
        }else
        {

           // JOptionPane.showMessageDialog(this, Initializations.FILENOTFOUND , Initializations.IMPORTERROR , JOptionPane.ERROR_MESSAGE);

            JOptionPane.showMessageDialog(null, Initializations.NODBCONNECTION, "Error", JOptionPane.ERROR_MESSAGE);
            Text_MessageBar.setText(Initializations.NODBCONNECTION);

            Text_MessageBar.setForeground(Color.RED);
        }
    }//GEN-LAST:event_Import_FileActionPerformed

    private void Save_MongoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Save_MongoActionPerformed
       // Text_MessageBar.setText(Initializations.WAITINGFORCONNECTION);
      //  Text_MessageBar.setForeground(Color.ORANGE);
        if(dbcon.isConnectionSuccess())
        {              
            if(dbcon.checkDatabaseConnection()){
            
                if(indexOfCurrentCollection != 0)
                {
                    try 
                    {
                        file = null;
                        sb.setLength(0);

                        if (dbcon.isConnectionSuccess() && textArea.getText()!=null) 
                        {
                            Save_Mongo.setEnabled(true);

                            parser.parse(textArea.getText());

                            String json = textArea.getText();
                            
                            if (dbcon.saveColl(json))
                            {
                                Text_MessageBar.setText(Initializations.JSONSAVESUCCESS);
                                Text_MessageBar.setForeground(Color.GREEN);       
                            }
                            else
                            {
                                Text_MessageBar.setText(Initializations.VALIDATIONERROR);
                                Text_MessageBar.setForeground(Color.RED); 
                            }

                              
                        }
                    }
                    catch(org.json.simple.parser.ParseException pe)
                    {
                       Text_MessageBar.setForeground(Color.RED);
                       Text_MessageBar.setText(Initializations.ERRORLINE + json_util.getLineNumber(pe.getPosition(), textArea.getText()) + " - " + pe);
                    }
                }else
                {
                    Text_MessageBar.setText(Initializations.DBACTIONNOCOLLECTION);
                    Text_MessageBar.setForeground(Color.RED);
                    JOptionPane.showMessageDialog(null, Initializations.DBACTIONNOCOLLECTION, "Error", JOptionPane.ERROR_MESSAGE);
                } 
            }else
            {
                JOptionPane.showMessageDialog(null, Initializations.MONGOSERVERERROR, "Error", JOptionPane.ERROR_MESSAGE);
                Text_MessageBar.setText(Initializations.MONGOSERVERERROR);
                Text_MessageBar.setForeground(Color.RED);
            }
        }else{
            JOptionPane.showMessageDialog(null, Initializations.NODBCONNECTION, "Error", JOptionPane.ERROR_MESSAGE);
            Text_MessageBar.setText(Initializations.NODBCONNECTION);
            Text_MessageBar.setForeground(Color.RED);
        }
    }//GEN-LAST:event_Save_MongoActionPerformed

    private void Export_FileActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Export_FileActionPerformed
    Text_MessageBar.setText(Initializations.WAITINGFORCONNECTION);
    Text_MessageBar.setForeground(Color.ORANGE);
    if(dbcon.isConnectionSuccess())
    {  
        if(dbcon.checkDatabaseConnection())
        {
            List <String> connectionStrings = dbcon.getAllCollectionsLessSystem();
            ExportFileDialog dlg_export = new ExportFileDialog(null, connectionStrings);
            dlg_export.setVisible(true);

            if (dlg_export.isToExport())
            {
                String collectionToExport = dlg_export.collectionToExport();
                String typeToExport = dlg_export.typeToExport();
                String locToExport = dlg_export.locToExport();

                if(locToExport != null && !locToExport.trim().equals(""))
                {
                   //Converting JSON to CSV and export it to file is done in the dbcon.export method
                    //Exporting JSON on the other hand, is done here
                    if (typeToExport.equals("CSV") || typeToExport.equals("TSV"))
                    {
                       if (dbcon.export(collectionToExport, typeToExport, locToExport).equals("true"))
                        { 
                            Text_MessageBar.setForeground(Color.GREEN);
                            Text_MessageBar.setText("Export to " + typeToExport + " has been successful.");
                        }
                        else
                        {
                            Text_MessageBar.setForeground(Color.RED);
                            Text_MessageBar.setText("Export to " + typeToExport + " has been unsuccessful.");
                        }
                    }
                    else
                    {
                        String dataToExport = dbcon.export(collectionToExport, typeToExport, locToExport);
                        if(util.writeToFile(locToExport, dataToExport))
                        {
                            Text_MessageBar.setForeground(Color.GREEN);
                            Text_MessageBar.setText("Export to " + typeToExport + " has been successful.");
                        }
                        else
                        {
                            Text_MessageBar.setForeground(Color.RED);
                            Text_MessageBar.setText("Export to " + typeToExport + " has been unsuccessful.");
                        }
                    } 
                }
                else
                {
                    JOptionPane.showMessageDialog(this, Initializations.FILENOTFOUND , Initializations.EXPORTERROR , JOptionPane.ERROR_MESSAGE);
                    Text_MessageBar.setForeground(Color.RED);
                    Text_MessageBar.setText("Export to " + typeToExport + " has been unsuccessful.");
                }
            }
            else
            {
                Text_MessageBar.setForeground(Color.ORANGE);
                Text_MessageBar.setText("Export action has been aborted");
            }
        }else
        {
            JOptionPane.showMessageDialog(null, Initializations.MONGOSERVERERROR, "Error", JOptionPane.ERROR_MESSAGE);
            Text_MessageBar.setText(Initializations.MONGOSERVERERROR);
            Text_MessageBar.setForeground(Color.RED);
        }
    }else
    {
        JOptionPane.showMessageDialog(null, Initializations.NODBCONNECTION, "Error", JOptionPane.ERROR_MESSAGE);
        Text_MessageBar.setText(Initializations.NODBCONNECTION);
        Text_MessageBar.setForeground(Color.RED);
    }
    }//GEN-LAST:event_Export_FileActionPerformed

    private void Op_RefreshActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Op_RefreshActionPerformed
        Text_MessageBar.setText(Initializations.WAITINGFORCONNECTION);
        Text_MessageBar.setForeground(Color.ORANGE);
        if (dbcon.isConnectionSuccess())
        {
            if(dbcon.checkDatabaseConnection())
            {
                if(indexOfCurrentCollection != 0)
                {

                    String loc = tp.getPathComponent(indexOfCurrentCollection).toString();

                    if (dbcon.checkSystemColl(loc))
                    {
                        String new_data = dbcon.getCollectionData(loc).toString();
                        JsonNode jNode1;
                        try
                        {
                            jNode1 = mapper.readTree(new_data);
                            textArea.setText(mapper.writerWithDefaultPrettyPrinter().writeValueAsString(jNode1));
                        } catch (IOException ex) 
                        {
                            Logger.getLogger(MainForm.class.getName()).log(Level.SEVERE, null, ex);
                        } 
                    }
                }else
                    {
                        Text_MessageBar.setText(Initializations.DBACTIONNOCOLLECTION);
                        Text_MessageBar.setForeground(Color.RED);
                        JOptionPane.showMessageDialog(null, Initializations.DBACTIONNOCOLLECTION, "Error", JOptionPane.ERROR_MESSAGE);
                    } 
            }else
            {
                JOptionPane.showMessageDialog(null, Initializations.MONGOSERVERERROR, "Error", JOptionPane.ERROR_MESSAGE);
                Text_MessageBar.setText(Initializations.MONGOSERVERERROR);
                Text_MessageBar.setForeground(Color.RED);
            }
        }else
            {
                Text_MessageBar.setText(Initializations.SYSTEMCOLLNOREFRESH);
                Text_MessageBar.setForeground(Color.RED);
            }
       
    }//GEN-LAST:event_Op_RefreshActionPerformed

    private void file_closeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_file_closeActionPerformed
        if(JOptionPane.showConfirmDialog(null, "Are you sure you want to exit?", "Confirm", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE) == JOptionPane.OK_OPTION)
            dispose();
    }//GEN-LAST:event_file_closeActionPerformed

    private void Op_DBActionsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Op_DBActionsActionPerformed
        Text_MessageBar.setText(Initializations.WAITINGFORCONNECTION);
        Text_MessageBar.setForeground(Color.ORANGE);
        if(dbcon.isConnectionSuccess())
        {
            if(dbcon.checkDatabaseConnection())
            {
                if(indexOfCurrentCollection != 0)
                {
                    ActionOnDB dbAction = new ActionOnDB(dbcon);
                    Text_MessageBar.setText(Initializations.DBACTIONSSUCCESS);
                    Text_MessageBar.setForeground(Color.GREEN);
                    dbAction.setVisible(true);
                }
                else
                {
                    Text_MessageBar.setText(Initializations.DBACTIONNOCOLLECTION);
                    Text_MessageBar.setForeground(Color.RED);
                    JOptionPane.showMessageDialog(null, Initializations.DBACTIONNOCOLLECTION, "Error", JOptionPane.ERROR_MESSAGE);
                }  
            }else
            {
                JOptionPane.showMessageDialog(null, Initializations.MONGOSERVERERROR, "Error", JOptionPane.ERROR_MESSAGE);
                Text_MessageBar.setText(Initializations.MONGOSERVERERROR);
                Text_MessageBar.setForeground(Color.RED);
            }
        }else{
            JOptionPane.showMessageDialog(null, Initializations.NODBCONNECTION, "Error", JOptionPane.ERROR_MESSAGE);
            Text_MessageBar.setText(Initializations.NODBCONNECTION);
            Text_MessageBar.setForeground(Color.RED);
        }
    }//GEN-LAST:event_Op_DBActionsActionPerformed

    private void Op_ValidateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Op_ValidateActionPerformed
        JSONParser parser = new JSONParser();
        String text = null;
        String object = "";
        int retVal = 0;
        textArea.removeAllLineHighlights();
        try
        {
            if(!Panel_Text.isVisible() && !Panel_Compare.isVisible())
            {
                Text_MessageBar.setText(Initializations.VALIDATEEMPTY);
                Text_MessageBar.setForeground(Color.ORANGE);
            }else
            if(Panel_Text.isVisible())
            {
                text = textArea.getText();
                if(textArea.getText().isEmpty()){
                    Text_MessageBar.setText(Initializations.VALIDATEEMPTY);
                    Text_MessageBar.setForeground(Color.ORANGE);
                }else
                    parser.parse(textArea.getText());
            }
            else if(Panel_Compare.isVisible())
            {
                if(textArea1Comp.getText().isEmpty() && textArea1Comp.getText().isEmpty()){
                    Text_MessageBar.setText(Initializations.VALIDATEEMPTY);
                    Text_MessageBar.setForeground(Color.ORANGE);
                }
                else{
                    if(textArea1Comp.getText().isEmpty()){
                        Text_MessageBar.setText(Initializations.VALIDATEEMPTY + Initializations.VALIDATIONTEXTAREA1);
                        Text_MessageBar.setForeground(Color.ORANGE);
                    }
                    else{
                        text = textArea1Comp.getText(); 
                        object = "" + Initializations.VALIDATIONTEXTAREA1;
                        text = textArea1Comp.getText();
                        parser.parse(textArea1Comp.getText());
                    }

                    if(textArea2Comp.getText().isEmpty()){
                        Text_MessageBar.setText(Initializations.VALIDATEEMPTY + Initializations.VALIDATIONTEXTAREA2);
                        Text_MessageBar.setForeground(Color.ORANGE);
                    }
                    else
                    {
                        text = textArea2Comp.getText();
                        object = "" + Initializations.VALIDATIONTEXTAREA2;
                        text = textArea2Comp.getText();
                        parser.parse(textArea2Comp.getText());
                    }
                }    
            }
        }catch(org.json.simple.parser.ParseException pe)
        {
            Text_MessageBar.setText(Initializations.VALIDATIONERROR + object + " - " + Initializations.ERRORLINE + json_util.getLineNumber(pe.getPosition(), text) + " - " + pe );
            Text_MessageBar.setForeground(Color.RED); 
        }
        
        if(json_util.isDataParsed(text)){
            Text_MessageBar.setText(Initializations.VALIDATIONSUCCESS);
            Text_MessageBar.setForeground(Color.GREEN);
            textArea.removeAllLineHighlights();
            JOptionPane.showMessageDialog(null, Initializations.VALIDATIONSUCCESS, "Success", JOptionPane.INFORMATION_MESSAGE);
        }
        else
        {
            retVal = json_util.LineNumber;
            Text_MessageBar.setText(Initializations.VALIDATIONERROR + " at line " + retVal + ".");
            Text_MessageBar.setForeground(Color.RED);
            
            try 
            {
                textArea.addLineHighlight(retVal-1, Color.red);
            } 
            catch (BadLocationException ex) 
            {
                Logger.getLogger(MainForm.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            JOptionPane.showMessageDialog(null, Initializations.VALIDATIONERROR + " at line " + retVal + ".", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_Op_ValidateActionPerformed

    private void addCollectionMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addCollectionMenuItemActionPerformed
        AddCollectionDialog addCollection = new AddCollectionDialog(this, rootPaneCheckingEnabled);
        addCollection.setLocationRelativeTo(null);
        addCollection.setVisible(rootPaneCheckingEnabled);
    }//GEN-LAST:event_addCollectionMenuItemActionPerformed

    private void deleteCollectionMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteCollectionMenuItemActionPerformed
        DeleteCollectionDialog deleteCollection = new DeleteCollectionDialog(this, rootPaneCheckingEnabled);
        deleteCollection.setLocationRelativeTo(null);
        deleteCollection.setVisible(rootPaneCheckingEnabled);
    }//GEN-LAST:event_deleteCollectionMenuItemActionPerformed

    private void toolsMenuMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_toolsMenuMouseClicked
        /**
        * To Determine how to show the menu items...
        */
        ServerController sc = new ServerController();

        if(sc.isServiceRunning(MongoReserved.MONGODEXE))
        {
            startServerMenuItem.setEnabled(false);
            stopServerMenuItem.setEnabled(true);
        }
        else
        {
            startServerMenuItem.setEnabled(true);
            stopServerMenuItem.setEnabled(false);
        }

        ClientController cc = new ClientController();

        if(cc.isServiceRunning(MongoReserved.MONGOEXE))
        {
            startClientMenuItem.setEnabled(false);
            stopClientMenuItem.setEnabled(true);
        }
        else
        {
            startClientMenuItem.setEnabled(true);
            stopClientMenuItem.setEnabled(false);
        }
    }//GEN-LAST:event_toolsMenuMouseClicked

    private void stopServerMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_stopServerMenuItemActionPerformed
        ServerController sc = new ServerController();
        int retVal = sc.stopServer();

        switch(retVal)
        {
            case 0: //success
            {
                JOptionPane.showMessageDialog(this, Initializations.SERVERSTOPPED, Initializations.SUCCESS, JOptionPane.INFORMATION_MESSAGE);
                break;
            }

            case -1: //Exception
            {
                JOptionPane.showMessageDialog(this, Initializations.SERVERSTOPPEDERROREXCEPTION + sc.ExceptionMessage, Initializations.ERROR, JOptionPane.WARNING_MESSAGE);
                break;
            }

            case 1: //Something went wrong like incorrect function or something else which does not generate an exception but an error...
            {
                JOptionPane.showMessageDialog(this, Initializations.SERVERSTOPPEDERROR, Initializations.ERROR, JOptionPane.WARNING_MESSAGE);
                break;
            }
        }
    }//GEN-LAST:event_stopServerMenuItemActionPerformed

    private void startServerMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_startServerMenuItemActionPerformed
        StartServerDialog startServerDialog = new StartServerDialog(this, true);
        startServerDialog.setLocationRelativeTo(null);
        startServerDialog.setVisible(true);
    }//GEN-LAST:event_startServerMenuItemActionPerformed

    private void installMongoDBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_installMongoDBActionPerformed
        InstallMongoDialog installMongoDialog = new InstallMongoDialog(this, true);
        installMongoDialog.setLocationRelativeTo(null);
        installMongoDialog.setVisible(true);
    }//GEN-LAST:event_installMongoDBActionPerformed

    private void startClientMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_startClientMenuItemActionPerformed
        StartClientDialog startClientDialog = new StartClientDialog(this, true);
        startClientDialog.setLocationRelativeTo(null);
        startClientDialog.setVisible(true);
    }//GEN-LAST:event_startClientMenuItemActionPerformed

    private void stopClientMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_stopClientMenuItemActionPerformed
        ClientController cc = new ClientController();
        int retVal = cc.stopClient();

        switch(retVal)
        {
            case 0: //success
            {
                JOptionPane.showMessageDialog(this, Initializations.CLIENTSTOPPED, Initializations.SUCCESS, JOptionPane.INFORMATION_MESSAGE);
                break;
            }

            case -1: //Exception
            {
                JOptionPane.showMessageDialog(this, Initializations.CLIENTSTOPPEDERROREXCEPTION + cc.ExceptionMessage, Initializations.ERROR, JOptionPane.WARNING_MESSAGE);
                break;
            }

            case 1: //Something went wrong like incorrect function or something else which does not generate an exception but an error...
            {
                JOptionPane.showMessageDialog(this, Initializations.CLIENTSTOPPEDERROR, Initializations.ERROR, JOptionPane.WARNING_MESSAGE);
                break;
            }
        }
    }//GEN-LAST:event_stopClientMenuItemActionPerformed

    private void addUserMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addUserMenuItemActionPerformed
        AddUsersDialog dlg_addusers = null;
        dlg_addusers = new AddUsersDialog(this);
        dlg_addusers.setVisible(true);
        
        //Information messages.
        if(dlg_addusers.isSucceeded())
        {
            Text_MessageBar.setText(Initializations.YOU_HAVE_SUCCESSFULLY_ADDED + dlg_addusers.getUsername() + Initializations.TO_DATABASE + dlg_addusers.getDatabase() + Initializations.FULL_STOP);
            Text_MessageBar.setForeground(Color.BLUE);
        }else{
            Text_MessageBar.setText(Initializations.CREATE_USER_ABORTED);
            Text_MessageBar.setForeground(Color.RED);
        }
    }//GEN-LAST:event_addUserMenuItemActionPerformed

    private void viewUsersMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_viewUsersMenuItemActionPerformed

            GetUsersFromDB gufdb = new GetUsersFromDB();
            if(DBList.isSelectionEmpty())
            {
                JOptionPane.showMessageDialog(this, Initializations.NO_DB_SELECTED_MESSAGE, Initializations.NO_DB_SELECTED_ERROR, JOptionPane.ERROR_MESSAGE);                 
            }
            else
            {
                DefaultListModel listModel = gufdb.get_users(DBList.getSelectedValue().toString());
                jList2.setModel(listModel);
                jScrollPane2.setVisible(false);
                DBScrollPane.setVisible(false);
                UsersScrollPane.setVisible(true);
                viewDBMenuItem.setEnabled(true);
                viewAllDBsMenuItem.setEnabled(true);
                viewUsersMenuItem.setEnabled(false);
                Panel_Connections.revalidate();
            }            
    }//GEN-LAST:event_viewUsersMenuItemActionPerformed

    private void jList2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jList2MouseClicked
        final AddUsersDialog dlg_addusers = new AddUsersDialog(this);
        ActionListener al3 = new ActionListener() {
      public void actionPerformed(ActionEvent e) {
            dlg_addusers.setVisible(true);
            viewUsersMenuItem.doClick();
            Text_MessageBar.setText(jList2.getSelectedValue().toString());
      }};
      
            
      ActionListener al1 = new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        try {
            Text_MessageBar.setText(jList2.getSelectedValue().toString());
            MongoClient mongoClient = new MongoClient(new ServerAddress("localhost", 27017)); 
            DB db = mongoClient.getDB(DBList.getSelectedValue().toString()); //To arrange to be the database which is connected to.
            db.removeUser(jList2.getSelectedValue().toString());
            viewUsersMenuItem.setEnabled(true);
            viewUsersMenuItem.doClick();
            viewUsersMenuItem.setEnabled(false);
        } catch (Exception ex) {
            Logger.getLogger(MainForm.class.getName()).log(Level.SEVERE, null, ex);
        }
      }}; 
          
      //Create the JPopupMenu with three options.
      final JPopupMenu popupMenu = new JPopupMenu();
      JMenuItem item1 = new JMenuItem("Delete");
      item1.addActionListener(al1);
      popupMenu.add(item1);  
      popupMenu.add(new JPopupMenu.Separator());
      JMenuItem item3 = new JMenuItem("Add");
      item3.addActionListener(al3);
      popupMenu.add(item3);
      
      
      jList2.addMouseListener(new MouseAdapter() {
         public void mouseClicked(MouseEvent me) {
            if (SwingUtilities.isRightMouseButton(me)      // if right mouse button clicked
                  && !jList2.isSelectionEmpty()            // and list selection is not empty
                  && jList2.locationToIndex(me.getPoint()) // and clicked point is
                  == jList2.getSelectedIndex()) {          // inside selected item bounds
                  //Text_MessageBar.setText(jList2.getSelectedValue().toString() + " RIGHT");
                  Text_MessageBar.setForeground(Color.blue);
                  popupMenu.show(jList2, me.getX(), me.getY());
            }else
            {
                  //Text_MessageBar.setText(jList2.getSelectedValue().toString() + " LEFT");
                  Text_MessageBar.setForeground(Color.MAGENTA);  
            }
         }
      }); 
    }//GEN-LAST:event_jList2MouseClicked

    private void viewDBMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_viewDBMenuItemActionPerformed
        UsersScrollPane.setVisible(false);
        DBScrollPane.setVisible(false);
        jScrollPane2.setVisible(true);
        viewDBMenuItem.setEnabled(false);
        viewUsersMenuItem.setEnabled(true);
        viewAllDBsMenuItem.setEnabled(true);
        Panel_Connections.revalidate();
    }//GEN-LAST:event_viewDBMenuItemActionPerformed

    private void uninstallMongoDBMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_uninstallMongoDBMenuItemActionPerformed
        UninstallMongoDialog uninstallMongoDialog = new UninstallMongoDialog(this, true);
        uninstallMongoDialog.setLocationRelativeTo(null);
        uninstallMongoDialog.setVisible(true);
    }//GEN-LAST:event_uninstallMongoDBMenuItemActionPerformed

    private void QueryCollectionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_QueryCollectionActionPerformed
        Component source = (Component)evt.getSource();
        Container parentContainer = source.getParent();
        QueryCollectionDialog queryCollectionDialog = null;
        
        /**
         * To handle when different behaviour of MenuItem click and direct node click
         * Since the collection on direct node click will be explicit 
         * but on MenuItem the user can select the collection to query manually...
         */
        if(parentContainer.equals(this.collectionPopupMenu))
        {
            queryCollectionDialog = new QueryCollectionDialog(this, true, true);
        }
        else
        {
            queryCollectionDialog = new QueryCollectionDialog(this, true, false);
        }
        
        queryCollectionDialog.setLocationRelativeTo(null);
        queryCollectionDialog.setVisible(true);
    }//GEN-LAST:event_QueryCollectionActionPerformed

    private void viewAllDBsMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_viewAllDBsMenuItemActionPerformed
            DBScrollPane.setVisible(true);
            UsersScrollPane.setVisible(false);
            jScrollPane2.setVisible(false);
            ShowDatabases sd = new ShowDatabases();
            DefaultListModel listModel = sd.show_dbs();
            DBList.setModel(listModel);
            Text_MessageBar.setForeground(Color.GREEN); 
            Text_MessageBar.setText(Initializations.DATABASES);
            
            viewAllDBsMenuItem.setEnabled(false);
            viewDBMenuItem.setEnabled(true);
            viewUsersMenuItem.setEnabled(true);
            Panel_Connections.revalidate();
    }//GEN-LAST:event_viewAllDBsMenuItemActionPerformed

    
    private void DBListMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_DBListMouseClicked
  
        //Event for the View Users DB Menu Item.
      ActionListener al_viewUsers = new ActionListener(){
          public void actionPerformed(ActionEvent e){
                jScrollPane2.setVisible(false);
                DBScrollPane.setVisible(false);
                UsersScrollPane.setVisible(true);
                GetUsersFromDB gufdb = new GetUsersFromDB();
                DefaultListModel listModel = gufdb.get_users(DBList.getSelectedValue().toString());
                jList2.setModel(listModel);
                
                viewAllDBsMenuItem.setEnabled(true);
                viewDBMenuItem.setEnabled(false);
                viewUsersMenuItem.setEnabled(false);
                Panel_Connections.revalidate();
          }
      };
              
      //Event for the Add DB Menu Item.
      ActionListener al_add = new ActionListener() {
      public void actionPerformed(ActionEvent e) {
          CreateDBDialog createDBDialog = new CreateDBDialog();
          Text_MessageBar.setForeground(Color.GREEN);
          Text_MessageBar.setText("You have successfully created " + createDBDialog.getName()+ "database.");
          viewAllDBsMenuItem.doClick();        
      }};
      
      //Event for the Drop DB Menu Item.
      ActionListener al_drop = new ActionListener() {
      public void actionPerformed(ActionEvent e) {
          DropDBDialog dropDBDialog = new DropDBDialog();
          dropDBDialog.DropDB(DBList.getSelectedValue().toString());
          Text_MessageBar.setForeground(Color.GREEN);
          viewAllDBsMenuItem.setEnabled(true);
          viewAllDBsMenuItem.doClick();
          viewAllDBsMenuItem.setEnabled(false);
      }};
      
      //Event for the Connect Menu Item.
      ActionListener al_connect = new ActionListener() {
      public void actionPerformed(ActionEvent e) {

        Panel_Text.setVisible(false);
        Panel_Hierarchical.setVisible(false);
        Panel_Table.setVisible(false);
        Panel_Compare.setVisible(false);
        Panel_Compare_Upper.setVisible(false);
        Panel_Connect.setVisible(true);
        
        Text_MessageBar.setText(Initializations.WAITINGFORCONNECTION);
        Text_MessageBar.setForeground(Color.ORANGE);
        if (dbcon.isConnectionSuccess())
        {
            if(dbcon.checkDatabaseConnection())
            {
                int result = JOptionPane.showConfirmDialog(null,"A connection to MongoDB"
                        + "already exists. Are you sure you want to disconnect and open "
                        + "a different connection?", "Confirm", JOptionPane.YES_NO_OPTION);

                if (result == JOptionPane.YES_OPTION)
                {
                    addCollection.setEnabled(false);
                    dropCollectionMenuItem.setEnabled(false);
                    dbcon.closeConnection();
                    connect();
                }
            }else
            {
                Text_MessageBar.setText(Initializations.MONGOSERVERERROR);
                Text_MessageBar.setForeground(Color.RED);
                JOptionPane.showMessageDialog(null, Initializations.MONGOSERVERERROR, "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
        else
        {
            connect();
        }
      }};
      
      //Create the JPopupMenu with two options. (Add DB and Drop DB)
      final JPopupMenu popupMenu = new JPopupMenu();
      JMenuItem item0 = new JMenuItem("View Users");
      item0.addActionListener(al_viewUsers);
      popupMenu.add(item0);
      popupMenu.add(new JPopupMenu.Separator());     
      JMenuItem item1 = new JMenuItem("Add DB");
      item1.addActionListener(al_add);
      popupMenu.add(item1);  
      JMenuItem item2 = new JMenuItem("Drop DB");
      item2.addActionListener(al_drop);
      popupMenu.add(item2);
      popupMenu.add(new JPopupMenu.Separator());
      JMenuItem item3 = new JMenuItem("Connect");
      item3.setFont(new Font("Helvetica", Font.BOLD, 14));
      popupMenu.add(item3);
      item3.addActionListener(al_connect);
      
DBList.addMouseListener(new MouseAdapter() {
         public void mouseClicked(MouseEvent me) {
            if (SwingUtilities.isRightMouseButton(me)      // if right mouse button clicked
                  && !DBList.isSelectionEmpty()            // and list selection is not empty
                  && DBList.locationToIndex(me.getPoint()) // and clicked point is
                  == DBList.getSelectedIndex()) {          // inside selected item bounds
                  popupMenu.show(DBList, me.getX(), me.getY());
            }else
            {
                  Text_MessageBar.setForeground(Color.MAGENTA);  
            }
         }
      });
    }//GEN-LAST:event_DBListMouseClicked

    private void DBListMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_DBListMouseEntered
        Text_MessageBar.setForeground(Color.BLUE);
        Text_MessageBar.setText(Initializations.DBS_POP_UP_MENU_MESSAGE);
        
    }//GEN-LAST:event_DBListMouseEntered

    private void DBListMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_DBListMouseExited
        Text_MessageBar.setText(null);
    }//GEN-LAST:event_DBListMouseExited

    private void btStartLoginDialogActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btStartLoginDialogActionPerformed
        
        MainAppLoginDialog mald = new MainAppLoginDialog(this, true);
        mald.setLocationRelativeTo(null);
        mald.setVisible(true);        // TODO add your handling code here:
    }//GEN-LAST:event_btStartLoginDialogActionPerformed

    private void jList2MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jList2MouseEntered
        Text_MessageBar.setForeground(Color.BLUE);
        Text_MessageBar.setText(Initializations.USERS_POP_UP_MENU_MESSAGE);
    }//GEN-LAST:event_jList2MouseEntered

    private void jList2MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jList2MouseExited
        Text_MessageBar.setText(null);
    }//GEN-LAST:event_jList2MouseExited
   
    // TO BE REMOVED -----------------------------------------------------------------------------------------------------------------------------
    public void connectAutomatically(String user, String pass, String dbname)
    {
        String serveradd;
        int port;
            
        //If user chose login and not cancel option on dialog box
        if (true)
        {
            if (dbcon.connect(user, pass, dbname, "", 27017))
            {
                DefaultTreeModel defTableMod = dbcon.buildDBTree();
                if (defTableMod != null && dbcon.isConnectionSuccess())
                {
                    jTree1.setModel(defTableMod);
                    Text_MessageBar.setText(Initializations.DBCONNSUCCESS);
                    Text_MessageBar.setForeground(Color.GREEN);
                    Menu_Collections.setEnabled(true);
                    addCollection.setEnabled(true);
                    dropCollectionMenuItem.setEnabled(true);
                
                    //load the data of collection in panel_text on double click
                    jTree1.addMouseListener(new MouseAdapter() 
                    {
                        @Override
                        public void mouseClicked(MouseEvent me) 
                        {
                            if (me.getButton() == MouseEvent.BUTTON1)
                            {
                                if (me.getClickCount()==2)
                                {
                                    //get the path of the mouse click ex:[localhost,test,testData] 
                                    Op_Refresh.setEnabled(true);
                                    tp = jTree1.getPathForLocation(me.getX(), me.getY());
                                    
                                    if (tp != null)
                                    {
                                        List<String> coll_db = dbcon.getAllCollections();
                                        int cnt = tp.getPathCount();
                                        for (int i = 0; i<cnt;i++)
                                        {
                                            //if one of the collection matches the coll that was clicked by the user load data
                                            if(coll_db.contains(tp.getPathComponent(i).toString()))
                                            {
                                                indexOfCurrentCollection = i;
                                                sb = dbcon.getCollectionData(tp.getPathComponent(i).toString());
                                            
                                                if(sb != null)
                                                {
                                                    Panel_Text.setVisible(true);

                                                    JsonNode jNode1;
                                                    try
                                                    {
                                                        jNode1 = mapper.readTree(sb.toString());
                                                        textArea.setText(mapper.writerWithDefaultPrettyPrinter().writeValueAsString(jNode1));
                                                    } 
                                                    catch (IOException ex) 
                                                    {
                                                        Logger.getLogger(MainForm.class.getName()).log(Level.SEVERE, null, ex);
                                                    } 

                                                    Text_MessageBar.setText(Initializations.INITSTRING);
                                                    validateDataPanel_text(sb);
                                                }
                                                else
                                                {
                                                    Panel_Text.setVisible(false);
                                                    Text_MessageBar.setText(Initializations.SYSTEMCOLL);
                                                    Text_MessageBar.setForeground(Color.RED);
                                                }    
                                            }
                                        }
                                    }
                                } 
                            }
                            /** -- MG -----------------------------------------------------------
                             * This has been added to add a feature of "On Right-Click" on nodes |
                             * Such as add collections, delete collections for the Root node...  |
                             * ------------------------------------------------------------------
                             */ 
                            else if(me.getButton() == MouseEvent.BUTTON3)
                            {
                                int selRow = jTree1.getRowForLocation(me.getX(), me.getY());
                                TreePath selPath = jTree1.getPathForLocation(me.getX(), me.getY());
                                jTree1.setSelectionPath(selPath); 
                                
                                if (selRow>-1)
                                {
                                    jTree1.setSelectionRow(selRow); 
                                }
                                
                                DefaultMutableTreeNode rootNode = (DefaultMutableTreeNode)jTree1.getModel().getRoot();
                                DefaultMutableTreeNode currNode = (DefaultMutableTreeNode)jTree1.getLastSelectedPathComponent();
                                
                                if(currNode == rootNode)
                                {
                                    collectionPopupMenu.setVisible(false);
                                    rootPopupMenu.setVisible(true);
                                    rootPopupMenu.show(jTree1, me.getX(), me.getY());
                                }
                                else
                                {
                                    if(selRow > -1)
                                    {
                                        rootPopupMenu.setVisible(false);
                                        collectionPopupMenu.setVisible(true);
                                        collectionPopupMenu.show(jTree1, me.getX(), me.getY());
                                    }
                                }
                            }
                        } 
                    });
                }
                else
                {
                    jTree1.setModel(null);
                    Text_MessageBar.setText(Initializations.DBCONNFAIL);
                    Text_MessageBar.setForeground(Color.RED);
                }      
            }
            else
            {
                jTree1.setModel(null);
                Text_MessageBar.setText(Initializations.DBCONNFAIL);
                Text_MessageBar.setForeground(Color.RED);
            }
        }
        else
        {
            jTree1.setModel(null);
            Text_MessageBar.setText(Initializations.DBCONNFAIL);
            Text_MessageBar.setForeground(Color.RED);
        }
           
    }
    //--------------------------------------------------------------------------------------------------------------------------------------------
    
    public void connect()
    {
        String user;
        String pass;
        String dbname;
        String serveradd;
        int port;
        
        LoginDialog dlg_login = new LoginDialog(null);
        dlg_login.setVisible(true);
            
        //If user chose login and not cancel option on dialog box
        if (dlg_login.isToLogin())
        {
            Text_MessageBar.setText(Initializations.DBATTEMPTING);
            Text_MessageBar.setForeground(Color.ORANGE);
            user = dlg_login.getUsername();
            pass = dlg_login.getPassword();
            dbname = dlg_login.getDatabase();
            serveradd = dlg_login.getServerAddr();
            port = dlg_login.getPort();

            if (dbcon.connect(user, pass, dbname, serveradd, port))
            {
                DefaultTreeModel defTableMod = dbcon.buildDBTree();
                if (defTableMod != null && dbcon.isConnectionSuccess())
                {
                    jTree1.setModel(defTableMod);
                    Text_MessageBar.setText(Initializations.DBCONNSUCCESS);
                    Text_MessageBar.setForeground(Color.GREEN);
                    Menu_Collections.setEnabled(true);
                    addCollection.setEnabled(true);
                    dropCollectionMenuItem.setEnabled(true);
                    DBScrollPane.setVisible(false);
                    UsersScrollPane.setVisible(false);
                    jScrollPane2.setVisible(true);
                    Panel_Connections.revalidate();
                    
                    //load the data of collection in panel_text on double click
                    jTree1.addMouseListener(new MouseAdapter() 
                    {
                        @Override
                        public void mouseClicked(MouseEvent me) 
                        {
                            if (me.getButton() == MouseEvent.BUTTON1)
                            {
                                if (me.getClickCount()==2)
                                {
                                    //get the path of the mouse click ex:[localhost,test,testData] 
                                    Op_Refresh.setEnabled(true);
                                    tp = jTree1.getPathForLocation(me.getX(), me.getY());
                                    
                                    if (tp != null)
                                    {
                                        List<String> coll_db = dbcon.getAllCollections();
                                        int cnt = tp.getPathCount();
                                        for (int i = 0; i<cnt;i++)
                                        {
                                            //if one of the collection matches the coll that was clicked by the user load data
                                            if(coll_db.contains(tp.getPathComponent(i).toString()))
                                            {
                                                indexOfCurrentCollection = i;
                                                sb = dbcon.getCollectionData(tp.getPathComponent(i).toString());
                                            
                                                if(sb != null)
                                                {
                                                    Panel_Text.setVisible(true);

                                                    JsonNode jNode1;
                                                    try
                                                    {
                                                        jNode1 = mapper.readTree(sb.toString());
                                                        textArea.setText(mapper.writerWithDefaultPrettyPrinter().writeValueAsString(jNode1));
                                                    } 
                                                    catch (IOException ex) 
                                                    {
                                                        Logger.getLogger(MainForm.class.getName()).log(Level.SEVERE, null, ex);
                                                    } 

                                                    Text_MessageBar.setText(Initializations.INITSTRING);
                                                    validateDataPanel_text(sb);
                                                }
                                                else
                                                {
                                                    Panel_Text.setVisible(false);
                                                    Text_MessageBar.setText(Initializations.SYSTEMCOLL);
                                                    Text_MessageBar.setForeground(Color.RED);
                                                }    
                                            }
                                        }
                                    }
                                } 
                            }
                            /** -- MG -----------------------------------------------------------
                             * This has been added to add a feature of "On Right-Click" on nodes |
                             * Such as add collections, delete collections for the Root node...  |
                             * ------------------------------------------------------------------
                             */ 
                            else if(me.getButton() == MouseEvent.BUTTON3)
                            {
                                int selRow = jTree1.getRowForLocation(me.getX(), me.getY());
                                TreePath selPath = jTree1.getPathForLocation(me.getX(), me.getY());
                                jTree1.setSelectionPath(selPath); 
                                
                                if (selRow>-1)
                                {
                                    jTree1.setSelectionRow(selRow); 
                                }
                                
                                DefaultMutableTreeNode rootNode = (DefaultMutableTreeNode)jTree1.getModel().getRoot();
                                DefaultMutableTreeNode currNode = (DefaultMutableTreeNode)jTree1.getLastSelectedPathComponent();
                                
                                if(currNode == rootNode)
                                {
                                    collectionPopupMenu.setVisible(false);
                                    rootPopupMenu.setVisible(true);
                                    rootPopupMenu.show(jTree1, me.getX(), me.getY());
                                }
                                else
                                {
                                    rootPopupMenu.setVisible(false);
                                    collectionPopupMenu.setVisible(true);
                                    collectionPopupMenu.show(jTree1, me.getX(), me.getY());
                                }
                            }
                        } 
                    });
                }
                else
                {
                    jTree1.setModel(null);
                    Text_MessageBar.setText(Initializations.DBCONNFAIL);
                    Text_MessageBar.setForeground(Color.RED);
                }      
            }
            else
            {
                jTree1.setModel(null);
                Text_MessageBar.setText(Initializations.DBCONNFAIL);
                Text_MessageBar.setForeground(Color.RED);
            }
        }
        else
        {
            jTree1.setModel(null);
            Text_MessageBar.setText(Initializations.DBCONNFAIL);
            Text_MessageBar.setForeground(Color.RED);
        }
           
    }
    
    public void setImageIcon() {
        ImageIcon leafIcon = createImageIcon("/resources/json_node.png");

        if (leafIcon != null) {
            DefaultTreeCellRenderer renderer = new DefaultTreeCellRenderer();
            renderer.setLeafIcon(leafIcon);
            jTreeHierarchicalJson.setCellRenderer(renderer);
        }
    }

    private ImageIcon createImageIcon(String path) {
        java.net.URL imgUrl = getClass().getResource(path);
        if (imgUrl != null) {
            return new ImageIcon(imgUrl);
        } else {
            Text_MessageBar.setText(Initializations.LEAFICON);
            return null;
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
            java.util.logging.Logger.getLogger(MainForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MainForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MainForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MainForm().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JSplitPane ComparePane;
    private javax.swing.JButton Compare_Button;
    private javax.swing.JTextArea Compare_ResultText;
    private javax.swing.JList DBList;
    private javax.swing.JScrollPane DBScrollPane;
    private javax.swing.JMenuItem Export_File;
    private javax.swing.JMenuItem Import_File;
    private javax.swing.JMenuItem Import_JSON;
    protected javax.swing.JMenu Menu_Collections;
    private javax.swing.JMenu Menu_File;
    private javax.swing.JMenu Menu_Operations;
    private javax.swing.JMenu Menu_Views;
    private javax.swing.JMenuItem Op_Compare;
    private javax.swing.JMenuItem Op_DBActions;
    private javax.swing.JMenuItem Op_Refresh;
    private javax.swing.JMenuItem Op_Validate;
    private javax.swing.JPanel Panel_Compare;
    private javax.swing.JPanel Panel_Compare_Upper;
    private javax.swing.JPanel Panel_Connect;
    private javax.swing.JPanel Panel_Connections;
    private javax.swing.JPanel Panel_Hierarchical;
    private javax.swing.JPanel Panel_Table;
    protected javax.swing.JPanel Panel_Text;
    private javax.swing.JPanel Panel_Views;
    private javax.swing.JMenuItem QueryCollectionMenuItem;
    private javax.swing.JMenuItem Save_File;
    private javax.swing.JMenuItem Save_Mongo;
    private javax.swing.JTable Table_JSON;
    protected javax.swing.JTextField Text_MessageBar;
    protected javax.swing.JScrollPane UsersScrollPane;
    private javax.swing.JMenuItem View_Hierarchical;
    private javax.swing.JMenuItem View_Table;
    private javax.swing.JMenuItem View_Text;
    protected javax.swing.JMenuItem addCollection;
    private javax.swing.JMenuItem addCollectionMenuItem;
    protected javax.swing.JMenuItem addUserMenuItem;
    private javax.swing.JButton btStartLoginDialog;
    private javax.swing.JPopupMenu collectionPopupMenu;
    private javax.swing.JMenuItem connect_DB;
    private javax.swing.JMenuItem deleteCollectionMenuItem;
    private javax.swing.JMenuItem dropCollectionMenuItem;
    private javax.swing.JMenuItem file_close;
    private javax.swing.JMenuItem installMongoDB;
    private javax.swing.JList jList2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JPopupMenu.Separator jSeparator1;
    private javax.swing.JPopupMenu.Separator jSeparator2;
    private javax.swing.JPopupMenu.Separator jSeparator3;
    private javax.swing.JPopupMenu.Separator jSeparator4;
    private javax.swing.JPopupMenu.Separator jSeparator5;
    private javax.swing.JSplitPane jSplitPane1;
    protected javax.swing.JTree jTree1;
    public javax.swing.JTree jTreeHierarchicalJson;
    private javax.swing.JLabel left_label;
    private javax.swing.JCheckBox left_obj_to_array;
    private javax.swing.JMenuItem queryCollectionMenuItem;
    private javax.swing.JLabel right_label;
    private javax.swing.JCheckBox right_obj_to_array;
    private javax.swing.JPopupMenu rootPopupMenu;
    protected javax.swing.JMenuItem startClientMenuItem;
    protected javax.swing.JMenuItem startServerMenuItem;
    protected javax.swing.JMenuItem stopClientMenuItem;
    protected javax.swing.JMenuItem stopServerMenuItem;
    protected javax.swing.JMenu toolsMenu;
    private javax.swing.JMenuItem uninstallMongoDBMenuItem;
    protected javax.swing.JMenuItem viewAllDBsMenuItem;
    private javax.swing.JMenuItem viewDBMenuItem;
    protected javax.swing.JMenuItem viewUsersMenuItem;
    // End of variables declaration//GEN-END:variables
}
