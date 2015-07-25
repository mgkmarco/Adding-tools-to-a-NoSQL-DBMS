/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nosqltools;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

/**
 *
 * @author mgalea
 */
public class PropertiesController 
{
    private File ConfigFile;
    private Properties ApplicationProperties;
    private HashMap propertyMap;
    
    public PropertiesController() 
    {
        setPropertiesHashMap();
    }
    
    private void setPropertiesHashMap()
    {
        propertyMap = new HashMap();
        ClassLoader classLoader = getClass().getClassLoader();
        this.ConfigFile = new File("resources/app.properties");
        
        try(FileReader fileReader = new FileReader(this.ConfigFile);) 
        {
            this.ApplicationProperties = new Properties();
            this.ApplicationProperties.load(fileReader);           
            
            /**
             * Get Key-Value pairs so as not to overwrite properties
             */
            Enumeration<?> enumer = this.ApplicationProperties.propertyNames();            
            String key = null;
            
            while(enumer.hasMoreElements())
            {
                key = (String)enumer.nextElement();
                propertyMap.put(key, this.ApplicationProperties.getProperty(key));
            }
        } 
        catch (Exception exp) 
        {
            exp.getMessage();
            exp.printStackTrace();
        }
    }
    
    private void setProperties(String key, String value)
    {
        Set set = this.propertyMap.entrySet();
        Iterator iter = set.iterator();
        
        while(iter.hasNext())
        {
            Map.Entry me = (Map.Entry)iter.next();
            String meCurrKey = (String)me.getKey();
                    
            if(meCurrKey.equals(key))
            {
                this.propertyMap.put(meCurrKey, value);
            }
        }
    }
    
    public String getProperties(String key)
    {
        Set set = this.propertyMap.entrySet();
        Iterator iter = set.iterator();
        String value = null;
        
        while(iter.hasNext())
        {
            Map.Entry me = (Map.Entry)iter.next();
            String meCurrKey = (String)me.getKey();
                    
            if(meCurrKey.equals(key))
            {
                value = (String)this.propertyMap.get(key);
                break;
            }
        }
        
        return value;
    }
    
    public String writeConfigFile(String key, String value)
    {
        setProperties(key, value);
        
        try(FileWriter writer = new FileWriter(this.ConfigFile);)
        {
            Set set = this.propertyMap.entrySet();
            Iterator iter = set.iterator();
            
            while(iter.hasNext())
            {
                Map.Entry me = (Map.Entry)iter.next();
                this.ApplicationProperties.setProperty((String)me.getKey(), (String)me.getValue());
            }
            
            this.ApplicationProperties.store(writer, Initializations.DONT_ALTER_WARNING);
        }
        catch(Exception ex)
        {
            ex.getMessage();
            ex.printStackTrace();
        }
        
        return null;
    }
}
