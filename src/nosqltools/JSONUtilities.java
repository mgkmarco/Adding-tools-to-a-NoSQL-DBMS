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

public class JSONUtilities 
{
    public JSONArray json_array = null;
    public JSONObject json_obj = null;
    public JsonNode JSONParsedData;
    public int LineNumber = -1;

    //this method checks whether a string is a JSON array
    public boolean isArray(String json_data)
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
         
        return true;
    }
    
    //this method checks whether the string is a JSONobject or a JSONArray
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
    
    //this method returns default mutable tree node that will be used in the main form to load the hierarchical view
    private DefaultMutableTreeNode makeJtree(String name, JsonNode node) 
    {
       //instance of default mutable tree node with the root name of that object
        DefaultMutableTreeNode treeNode = new DefaultMutableTreeNode(name);
        //iterator that stores the fields of the JSON documents in the collection.
       Iterator <Entry <String,JsonNode>> iterator = node.fields();

       while (iterator.hasNext()) 
       {
           //the iterator returns the next entry 
           Entry <String, JsonNode> entry = iterator.next();
           //the entry will be added to the tree node and formatted as key:value
           treeNode.add(makeJtree(entry.getKey() + " : " + entry.getValue(), entry.getValue()));   
       }

       //if an array is found within an object
       if (node.isArray()) 
       {
           for (int i = 0; i < node.size(); i++)
           {
               //create a child and get the information
               JsonNode child = node.get(i);

               //the isValueNode returns valid String representation of the container value, if the node is a value node else null
               if (child.isValueNode())
                   treeNode.add(new DefaultMutableTreeNode(child.asText()));
               else
                   treeNode.add(makeJtree(String.format("Node %d", i), child));
           }
       } 

       return treeNode;
   }
    
    //this method will create the tree with the root of all named as collection 
    public DefaultTreeModel makeJtreeModel(String filename) 
    {
        DefaultMutableTreeNode root = makeJtree(filename, JSONParsedData);
        DefaultTreeModel dt = new DefaultTreeModel(root);
        
        return dt;
    }
     
    //this method accepts a string and returns whether the json is valid or not.
    public boolean isDataParsed(String json_data) 
    {
        ObjectMapper mapper = new ObjectMapper();
        try 
        {
            //if there is some data start parsing
            if (json_data != null && !json_data.isEmpty())
            {
                //use the object mapper to read the json string and create a tree
                JSONParsedData = mapper.readTree(json_data);
                return true;
            }
            else
            {
                return false;
            }
            
        } 
        catch (JsonParseException | JsonGenerationException | JsonMappingException e) 
        {
            
            String eMessage = e.getMessage();
            
            if(eMessage.contains(Initializations.UNEXPECTED_CHARACTER_CODE_34) || eMessage.contains(Initializations.UNEXPECTED_CHARACTER_CODE_44))
            {
                LineNumber = (e.getLocation().getLineNr()) - 1;
            }
            else
                if(eMessage.contains(Initializations.UNEXPECTED_CHARACTER_CODE_57) 
                        || eMessage.contains(Initializations.UNEXPECTED_CHARACTER_CODE_123)
                        || eMessage.contains(Initializations.UNEXPECTED_CHARACTER_CODE_58))
                {
                    LineNumber = (e.getLocation().getLineNr());
                }
            
            return false;
        } 
        catch (IOException e)
        {
            return false;
        }

    }
    
    //this method is used to return an array of strings in the table view
    public String[] getFields() 
    {
        //this array list will store the list of keys
        ArrayList<String> names = new ArrayList<>();

        if (json_array != null) 
        {
            for (int i = 0; i < json_array.length(); i++) 
            {
                //get the json object from the json array
                JSONObject jobj = json_array.getJSONObject(i);
                //store the array of field names from the json object. 
                String[] temp_names = getNames(jobj);

                //iterate over field names
                for (String temp_name : temp_names) 
                {
                    //if not already found in names add it 
                    if (!names.contains(temp_name)) 
                    {
                        names.add(temp_name);
                    }
                }
            }

            return names.toArray(new String[names.size()]);
        } 
        //if json_obj return the field names from json_obj
        else if (json_obj != null)
        {
            return getNames(json_obj);
        }
        else
        {
            return new String[0];
        }

    }

    //this method is used to return the values corresponding to the fiels
    public String[][] getRows(String[] fields)
    {
        String[][] row_data = null;
        String[][] row_dataArr = null;
        String s = "";

        //if the json array is not null
        if (json_array != null)
        {
            //initialize the size of the array
            row_dataArr = new String[json_array.length()][fields.length];
            //iterate over the array 
            for (int row = 0; row < json_array.length(); row++) 
            {
                //store the json object found at the row index
                JSONObject jobj = json_array.getJSONObject(row);
                //iterate over the fields.length
                for (int col = 0; col < fields.length; col++)
                {
                    //store the optional string associate with the key
                    s = jobj.optString(fields[col]);
                    //fill the 2d array with value s
                    row_dataArr[row][col] = s;
                }

            }
            return row_dataArr;

        } 
        //if json obj is not null
        else if (json_obj != null) 
        {
            //initialize row data
            row_data = new String[1][fields.length];

            //iterate over the number of fields
            for (int col = 0; col < fields.length; col++) 
            {
                //store the optional string associated with the key
                s = json_obj.optString(fields[col]);
                //fill the 2d array with value s
                row_data[0][col] = s;
            }

            return row_data;
        } 
        else 
        {
            //return empty
            return new String[0][0];
        }

    }
    
    //this method gets the line number from the character position
    public int getLineNumber(int pos, String x)
    {
        char character = ' '; 
        int  lineCounter = 1;
        
        System.out.println(pos);
        System.out.println(x.length());
        
        //iterate until position reached
        for (int i = 0; i < pos; i++)
        {
            character = x.charAt(i);
            //condition to increment line counter
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
    
    //this method will accept an array and converts it to an objects so it can be compared
    public JsonNode convertJArr(JsonNode jNode)
    {
        ObjectMapper mapper = new ObjectMapper();
        JsonNode convertedNode = null;          
        try 
        {
            String nodeText = jNode.toString();
            //convert to array by simply adding square bracket before and after the json object
            convertedNode = mapper.readTree("[" + nodeText + "]");
        } 
        catch (JsonParseException | JsonGenerationException | JsonMappingException e) 
        {
            e.printStackTrace();
        } 
        catch (IOException e)
        {
            e.printStackTrace();
        }      
        return convertedNode;
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
                //stores the type of operation performed
                opType = opNode.get("op").textValue();
                //stores the path of the nodes visited
                path = opNode.get("path").textValue().substring(1);
                
                if (!opType.equals("remove")){
                    //the value is not shown the the operation is removed because of null pointer exception 
                    //stores the value of the operation
                    value = ": " + opNode.get("value").toString();
                }
                else
                {
                    value = " ";
                }
                
                res.add(opType + " operation -> "+ path + value);
        }

        return res.toString();
    }
    
   
}