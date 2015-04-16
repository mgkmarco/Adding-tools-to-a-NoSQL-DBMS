/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nosqltools;

import java.util.ArrayList;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;
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
            json_obj = new JSONObject(json_data);
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

    public String[] getFields() 
    {
        ArrayList<String> names = new ArrayList<>();

        if (json_array != null) 
        {
            for (int i = 0; i < json_array.length(); i++) 
            {
                JSONObject jobj = json_array.getJSONObject(i);
                String[] temp_names = getNames(jobj);

                for (String temp_name : temp_names) 
                {
                    if (!names.contains(temp_name)) 
                    {
                        names.add(temp_name);
                    }
                }
            }

            return names.toArray(new String[names.size()]);
        } 
        else if (json_obj != null)
        {
            return getNames(json_obj);
        }
        else
        {
            return new String[0];
        }

    }

    public String[][] getRows(String[] fields)
    {
        String[][] row_data = null;
        String[][] row_dataArr = null;
        String s = "";

        if (json_array != null)
        {
            row_dataArr = new String[json_array.length()][fields.length];
            for (int row = 0; row < json_array.length(); row++) 
            {
                JSONObject jobj = json_array.getJSONObject(row);
                for (int col = 0; col < fields.length; col++)
                {
                    s = jobj.optString(fields[col]);
                    row_dataArr[row][col] = s;
                }

            }
            return row_dataArr;

        } 
        else if (json_obj != null) 
        {
            row_data = new String[1][fields.length];

            for (int col = 0; col < fields.length; col++) 
            {
                s = json_obj.optString(fields[col]);
                row_data[0][col] = s;
            }

            return row_data;
        } 
        else 
        {
            return new String[0][0];
        }

    }

    public DefaultTreeModel jsonTree(String filename) 
    {
        DefaultMutableTreeNode root = new DefaultMutableTreeNode(filename);
        DefaultMutableTreeNode child = null;
        DefaultTreeModel dt = new DefaultTreeModel(root);
        String childNode = "";
        String[][] objectNodes = null;
        String[] fields;

        if (json_array != null) 
        {
            objectNodes = new String[json_array.length()][getFields().length];
            for (int obj = 0; obj < json_array.length(); obj++) 
            {
                JSONObject jobj = json_array.getJSONObject(obj);
                fields = getFields();
                child = new DefaultMutableTreeNode("Node: " + obj);
                dt.insertNodeInto(child, root, obj);
                
                for (int val = 0; val < getFields().length; val++)
                {
                    childNode = jobj.optString(fields[val]);
                    DefaultMutableTreeNode child2 = new DefaultMutableTreeNode(fields[val] + ": " + childNode);
                 
                    dt.insertNodeInto(child2, child, val);
                }
            }
        } 
        else if (json_obj != null) 
        {
            String[] fieldNames = getNames(json_obj);
            ArrayList<String> output = new ArrayList<>();
            for (int i = 0; i < fieldNames.length; i++) 
            {
                output.add(fieldNames[i] + " : " + json_obj.optString(fieldNames[i]));
                child = new DefaultMutableTreeNode(output.get(i));
                dt.insertNodeInto(child, root, i);
            }
        }
        return dt;
    }
}
