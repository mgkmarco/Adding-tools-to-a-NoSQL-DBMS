/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nosqltools;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.github.fge.jsonpatch.JsonDiff;
import java.util.List;
import java.io.IOException;
import java.util.Iterator;
import java.util.Map.Entry;
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
    public JsonNode JSONParsedData;

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
    
    private DefaultMutableTreeNode makeJtree(String name, JsonNode node) 
    {
       DefaultMutableTreeNode treeNode = new DefaultMutableTreeNode(name);
       Iterator <Entry <String,JsonNode>> iterator = node.fields();

       while (iterator.hasNext()) 
       {
           Entry <String, JsonNode> entry = iterator.next();
           treeNode.add(makeJtree(entry.getKey() + " : " + entry.getValue(), entry.getValue()));   
           //treeNode.add(traverse(entry.getKey(), entry.getValue()));
       }

       if (node.isArray()) 
       {
           for (int i = 0; i < node.size(); i++)
           {
               JsonNode child = node.get(i);

               if (child.isValueNode())
                   treeNode.add(new DefaultMutableTreeNode(child.asText()));
               else
                   treeNode.add(makeJtree(String.format("Node %d", i), child));
           }
       } 

       return treeNode;
   }
    
    public DefaultTreeModel makeJtreeModel(String filename) 
    {
        DefaultMutableTreeNode root = makeJtree(filename, JSONParsedData);
        DefaultTreeModel dt = new DefaultTreeModel(root);
        
        return dt;
    }
     
    public boolean isDataParsed(String json_data) 
    {
        ObjectMapper mapper = new ObjectMapper();
        try 
        {
            //use the object mapper to read the json string and create a tree
            JSONParsedData = mapper.readTree(json_data);
            return true;
        } 
        catch (JsonParseException | JsonGenerationException | JsonMappingException e) 
        {
            e.printStackTrace();
        } 
        catch (IOException e)
        {
            e.printStackTrace();
        }
           
        return false;
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

    /*
    public DefaultTreeModel jsonTree(String filename) 
    {
        DefaultMutableTreeNode root = new DefaultMutableTreeNode(filename);
        DefaultMutableTreeNode child = null;
        DefaultTreeModel dt = new DefaultTreeModel(root);
        String childNode = "";
        String[][] objectNodes = null;
        String[] fields;

        /*
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
             
        
         for (int i = 0; i < JSONParsedData.size(); i++)
        {
            newNode(JSONParsedData.get(i));
        }
                
        return dt; 
    }
    */ 
    
    public int getLineNumber(int pos, String x)
    {
        char character = ' '; 
        int  lineCounter = 1;
        
        System.out.println(pos);
        System.out.println(x.length());
        
        for (int i = 0; i < pos; i++)
        {
            character = x.charAt(i);
            if(((int) character) == 10 || ((int) character) == 13)
            {
                lineCounter++;
            }
        }
        
        return lineCounter;
    }
    
    //this method will be used to compare two json nodes
    public JsonNode compareResult(JsonNode jNode1, JsonNode jNode2)
    {
        JsonNode jNodeRes = null;
        //check that the comparison will be performed between two objects or two arrays
        if ((jNode1.isObject() && jNode2.isObject())||(jNode1.isArray()&&jNode2.isArray()))
        {
            //get result and store it in Json node
            jNodeRes = JsonDiff.asJson(jNode1, jNode2);
        }        
        
        return jNodeRes;
    }
    //this method will print the differences from the left text area and right text area.
    public String printDiff(JsonNode resCompNode)
    {
        String opType = "";
        String path = "";
        String value = "";
        Iterator<JsonNode> elements = null;
        
        ArrayNode opNodes = (ArrayNode) resCompNode;
        List<String> res = new ArrayList<String>();
        elements = opNodes.elements();
        while (elements.hasNext())
        {
                JsonNode opNode = elements.next();	
                opType = opNode.get("op").textValue();
                path = opNode.get("path").textValue().substring(1);
                if (!opType.equals("remove")){
                    //the value is not shown the the operation is removed because of null pointer exception 
                    value = ": " + opNode.get("value").textValue();
                }
                
                res.add(opType + " operation -> "+ path + value);
        }

        return res.toString();
    }
}