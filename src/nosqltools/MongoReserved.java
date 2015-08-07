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
    public static final String NAME_PROP = "name";
    public static final String CAPPED_PROP = "capped";
    public static final String AUTOINDEXID_PROP = "autoIndexID";
    public static final String SIZE_PROP = "size";
    public static final String MAX_PROP = "max";
    public static final String STORAGEENGINE_PROP = "storageEngine";
    public static final String SYSTEMCOLLECTIONSPREFIX = "system.";
    
    /**
     * Commands
     */
    public static final String CREATECOLLECTIONCOMMAND = "db.createcollection";
    
    /**
     * Variables
     */
    public static final String TRUE_VAR = "true";
    public static final String FALSE_VAR = "false";
    public static final String CAPPED_VAR = "capped:";
    public static final String AUTOINDEXID_VAR = "autoIndexId:";
    public static final String SIZE_VAR = "size:";
    public static final String MAX_VAR = "max:";
    public static final String STORAGEENGINE_VAR = "storageEngine:";
    
    /**
     * Component Set
     */
    public static final String SERVER = "Server";
    public static final String CLIENT = "Client";
    public static final String ROUTER = "Router";
    public static final String MONITORING_TOOLS = "Monitoring Tools";
    public static final String IMPORT_EXPORT_TOOLS = "Import-Export Tools";
    public static final String MISC_TOOLS = "Miscellaneous Tools";
    public static final String MONGODEXE = "mongod.exe";
    public static final String MONGOEXE = "mongo.exe";
    
    /**
     * Exception message when service has started and not yet finished
     */
    public static final String PROCESSNOTEXITED = "process has not exited";
    
    /**
     * Queries and Querying keywords...
     */
    
}
