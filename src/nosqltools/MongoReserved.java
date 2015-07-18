/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nosqltools;

/**
 *
 * @author mgalea
 * Class to be used for MongoDB reserved keywords... 
 */
public class MongoReserved {
    
    /**
     * Properties
     */
    public static String NAME_PROP = "name";
    public static String CAPPED_PROP = "capped";
    public static String AUTOINDEXID_PROP = "autoIndexID";
    public static String SIZE_PROP = "size";
    public static String MAX_PROP = "max";
    public static String STORAGEENGINE_PROP = "storageEngine";
    
    /**
     * Commands
     */
    public static String CREATECOLLECTIONCOMMAND = "db.createcollection";
    
    /**
     * Variables
     */
    public static String TRUE_VAR = "true";
    public static String FALSE_VAR = "false";
    public static String CAPPED_VAR = "capped:";
    public static String AUTOINDEXID_VAR = "autoIndexId:";
    public static String SIZE_VAR = "size:";
    public static String MAX_VAR = "max:";
    public static String STORAGEENGINE_VAR = "storageEngine:";
}
