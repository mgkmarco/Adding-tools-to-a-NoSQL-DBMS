/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nosqltools;

import java.awt.BorderLayout;
import javax.swing.JPanel;
import javax.swing.ScrollPaneLayout;
import org.fife.ui.rsyntaxtextarea.RSyntaxTextArea;
import org.fife.ui.rsyntaxtextarea.SyntaxConstants;
import org.fife.ui.rtextarea.RTextScrollPane;

/**
 *
 * @author mgalea
 * This class sole purpose is to use it as a module for future Script to DB funcs
 * The goal is to have something similar of MS SQL Management Studio "Script To" func. 
 * 
 */
public class SyntaxEditor extends JPanel {
    
    private final Utilities util = new Utilities();
    protected RSyntaxTextArea textArea;
    
    public SyntaxEditor(){
        //set super-parent layout
        this.setLayout(new BorderLayout());
        
        //Instantiate a RSyntaxTextArea(RSTA) and set its props accordingly... Remember RSTA is a sub-class of JTextArea
        //Therefore all methods of JTA apply to it... Additionally set Eclipse style. 
        textArea = new RSyntaxTextArea();
        textArea.setSyntaxEditingStyle(SyntaxConstants.SYNTAX_STYLE_JSON);
        textArea.setCodeFoldingEnabled(true);
        textArea.setAntiAliasingEnabled(true);
        textArea.setWrapStyleWord(true);
        textArea.setLineWrap(true);     
        util.changeTextAreaTheme(textArea);
        
        RTextScrollPane textScrollPane = new RTextScrollPane(textArea);
        textScrollPane.setLayout(new ScrollPaneLayout());
        textScrollPane.setFoldIndicatorEnabled(true);
        
        this.add(textScrollPane);
    }
}
