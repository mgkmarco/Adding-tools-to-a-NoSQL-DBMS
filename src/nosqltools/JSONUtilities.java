/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nosqltools;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import static org.json.JSONObject.getNames;

/**
 *
 * @author RebeccaKai
 */
public class JSONUtilities {
    
    public JSONArray test = null;
    public JSONObject test1 = null;
    
    public boolean isValid(String json_data)
    {
        try 
        {
            test1 = new JSONObject (json_data);
        } 
        catch (JSONException e) 
        {
            try 
            {
               test = new JSONArray(json_data);
                
            } 
            catch (JSONException ex1) 
            {
                return false;
            }
        }
        return true;
    }
    
    public String [] getFields (String json_data)
    {
        String [] names = null;
        
        
        if (test != null)
        {
            for (int i = 0; i < test.length(); i++)
            {
                //JSONObject jobj = new JSONObject();
                JSONObject jobj = (JSONObject) test.get(i);
                names = getNames(jobj);
            }
        }
        
        
//        if (test1 != null)
//        {
//            names = getNames(test1);
//        }
               
        
        return names;
    }
    
}
