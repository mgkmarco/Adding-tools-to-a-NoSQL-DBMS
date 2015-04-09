/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nosqltools;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.logging.Level;
import java.util.logging.Logger;

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
                                            
}
