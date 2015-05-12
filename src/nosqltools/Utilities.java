/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nosqltools;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.fife.ui.rsyntaxtextarea.RSyntaxTextArea;
import org.fife.ui.rsyntaxtextarea.Theme;

/**
 *
 * @author RebeccaKai
 */
public class Utilities {
    
    public String formatExtentsions(String [] ext_array)
    {
        String extensions = "";
        for (int i = 0; i < ext_array.length; i++)
        {
            extensions += "*." + ext_array[i];
            if (i != ext_array.length - 1)
                extensions += ", ";      
        }
        
         return extensions;
    }
    
    public String readFromFile (File file)
    {
        FileInputStream is = null;
        StringBuilder sb = new StringBuilder();
        
            try 
            {
                is = new FileInputStream(file);
                InputStreamReader isr = new InputStreamReader(is);
                
                int i;
                char c;
                
                while((i = isr.read()) != -1)
                {
                    c = (char) i;
                    sb.append(c);
                }     
            }
            catch (FileNotFoundException ex) 
            {
                Logger.getLogger(MainForm.class.getName()).log(Level.SEVERE, null, ex);
            } 
            catch (IOException ex)
            {
                Logger.getLogger(MainForm.class.getName()).log(Level.SEVERE, null, ex);
            } 
            finally 
            {
                try 
                {
                    is.close();
                } 
                catch (IOException ex) 
                {
                    Logger.getLogger(MainForm.class.getName()).log(Level.SEVERE, null, ex);
                }
            }  
            
            return sb.toString();
        } 
    
    //this method will change text area in view text and compare screens
    public void changeTextAreaTheme(RSyntaxTextArea textArea)
    {
        try
        {
            InputStream is = new FileInputStream("Themes/eclipse.xml");
            Theme theme = Theme.load(is);
            theme.apply(textArea);
        } 
        catch (IOException ioe) 
        {
            ioe.printStackTrace();
        } 
    }
      
    public boolean writeToFile(String locToExport, String dataToExport)
    {
        FileOutputStream fop = null;
        File file;
 
        try {
                file = new File(locToExport);
                fop = new FileOutputStream(file);

                // if file doesnt exists, then create it
                if (!file.exists()) {
                        file.createNewFile();
                }

                // get the content in bytes
                byte[] contentInBytes = dataToExport.getBytes();

                fop.write(contentInBytes);
                fop.flush();
                fop.close();
                
                return true;

        } catch (IOException e) {
                e.printStackTrace();
                return false;
        }
    }
}
