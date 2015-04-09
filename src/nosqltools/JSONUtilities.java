/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nosqltools;

import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import static org.json.JSONObject.getNames;

/**
 *
 * @author RebeccaKai
 */
public class JSONUtilities 
{
    
    public JSONArray json_array = null;
    public JSONObject json_obj = null;
    
    public boolean isValid(String json_data)
    {
        try 
        {
            json_obj = new JSONObject (json_data);
            json_array = null;
        } 
        catch (JSONException e) 
        {
            try 
            {
               json_array = new JSONArray(json_data);
               json_obj = null;
            } 
            catch (JSONException ex1) 
            {
                return false;
            }
        }
        return true;
    }
    
    public String [] getFields ()
    {
        ArrayList <String> names = new ArrayList <> ();
        
        if (json_array != null)
        {
            for (int i = 0; i < json_array.length(); i++)
            {
                JSONObject jobj = json_array.getJSONObject(i);
                String [] temp_names = getNames(jobj);
                
                for (String temp_name : temp_names) 
                {
                    if (!names.contains(temp_name))
                        names.add(temp_name);
                }
            }
            
            return names.toArray(new String[names.size()]);
        }
        else if (json_obj != null)
        {
            return getNames (json_obj);
        }
        else 
        {
            return new String [0];
        }
            
    }
    
}
