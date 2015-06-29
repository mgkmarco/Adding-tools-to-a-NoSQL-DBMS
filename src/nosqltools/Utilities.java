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
 * This class offers a number of different utility methods which are used throughout the application
 */
public class Utilities {
    
    /**
     * Given an array of extentions (as strings), they are formated into one CSV string
     * @param ext_array an array of extentions as strings
     * @return CSV formatted string of extentions
     */
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
    
    /**
     * Given a file, the method will open an input stream and read from the file
     * @param file The file to read from
     * @return The contents of the file
     */
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
                
                //While the end of the file is not met, add every character to a string builder
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
                //Close the stream
                try 
                {
                    is.close();
                } 
                catch (IOException ex) 
                {
                    Logger.getLogger(MainForm.class.getName()).log(Level.SEVERE, null, ex);
                }
            }  
            
            //Return the contents of the String Builder
            return sb.toString();
        } 
    
    /**
     * This method will change text area theme colours in view text and compare screens
     */
    public void changeTextAreaTheme(RSyntaxTextArea textArea)
    {
        try
        {
            InputStream is = this.getClass().getResourceAsStream("eclipse.xml");
            Theme theme = Theme.load(is);
            theme.apply(textArea);
        } 
        catch (IOException ioe) 
        {
            System.err.println("Default Theme Applied");
        } 
    }
    
    /**
     * Given a location on local storage and the data to write to the file,
     * the method will open an output stream and write to the file at the location 
     * @param locToExport The location to write to
     * @param dataToExport The data to write to file
     * @return 
     */
    public boolean writeToFile(String locToExport, String dataToExport)
    {
        FileOutputStream fop = null;
        File file;
 
        try {
                file = new File(locToExport);
                fop = new FileOutputStream(file);

                // if file doesn't exist, then create it
                if (!file.exists()) {
                        file.createNewFile();
                }

                // get the content in bytes
                byte[] contentInBytes = dataToExport.getBytes();

                //Write to file
                fop.write(contentInBytes);
                fop.flush();
                fop.close();
                
                return true;

        } 
        catch (FileNotFoundException e)
        {
            e.printStackTrace();
            return false;
        }
        catch (IOException e ) {
                e.printStackTrace();
                return false;
        }
        
    }
}
