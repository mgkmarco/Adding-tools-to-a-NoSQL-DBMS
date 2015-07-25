/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package nosqltools;

/**
 * This class used for internationalisation (i18n) of strings.
 */
public class Initializations {
    
    public static String DBCONNSUCCESS = "Connection to MongoDB has been successful ";
    public static String DBCONNFAIL = "Connection to MongoDB has failed. Please try again.";
    public static String DBATTEMPTING = "Attempting to connect, please wait!";
    public static String DBCONNECT2MONGO = "Connect to MongoDB";
    public static String DBACTIONSSUCCESS = "Database Actions have been successfully loaded!";
    public static String DBACTIONNOCOLLECTION = "No collection has been selected!";
    public static String NODBCONNECTION = "There is no Database Connection yet!";
    public static String MONGOSERVERERROR = "Mongo Server is down!";
    public static String WAITINGFORCONNECTION = "Waiting for connection...";
    
    public static String NOFILECHOSEN = "No file was chosen";
    public static String ERROR = "Error";
    public static String TXT = "txt";
    public static String JSON = "json";
    public static String SUCCESS = "Ok";
    
    public static String JSONFILESUCCESS = "File has been loaded successfully";
    public static String JSONSAVESUCCESS = "File has been saved successfully";
    public static String JSONSAVEERROR = "JSON File has not been saved -";
    public static String JSONINCORRECTFORMAT = "Incorrect JSON format";
    public static String NOTEXT = "Nothing to display!";
    public static String VALIDATIONERROR = "Validation Error";

    public static String VALIDATIONSUCCESS = "Validation Successful";
    public static String VALIDATIONTEXTAREA1 = " in first object";
    public static String VALIDATIONTEXTAREA2 = " in second object";
    public static String VALIDATEEMPTY = "Empty object";
    public static String NOVALIDATIONPOSSIBLE = "No objects are visible for Validation!";

    public static String ERRORLINE = "Error in line: ";
    public static String COMPARESTART = "...compare is starting";
    public static String COMPARELOADED = "Compare loaded!";
    public static String COMPAREFAIL = "Compare failed";
    public static String COMPARESUCCESS = "Compare successful";
    public static String COMPOBJARRERR = "Compare between an object and an array is not possible!";
    public static String COMPAREEMPTY = "Compare not possible on empty objects!";
    public static String SUMMARY = "Summary: ";
    public static String LEAFICON = "Leaf icon file specified does not exist";
    public static String CONVERRDOC1 = "Object cannot be converted to array because Document 1 is empty!";
    public static String CONVERRDOC2 = "Object cannot be converted to array because Document 2 is empty!";
    public static String CONVERR = "Conversion Error";
    public static String DOC1EMPTY = "Document 1 is empty!";
    public static String OBJCONVERTED = "Object is already converted to array!";
    
    public static String IMPFILE = "Import File";
    public static String EXPFILE = "Export File";
    public static String FILENOTFOUND = "No File was chosen!";
    public static String FILECSVIMPORT = "Wrong file type!";
    public static String FILEERROR = "File Error";
    public static String EXPORTERROR = "Export Error";
    public static String IMPORTERROR = "Import Error";
    
    public static String SYSTEMCOLL = "System collections are not shown!";
    public static String SYSTEMCOLLNOREFRESH = "System collections cannot be refreshed!";
    
    public static final String INITSTRING = "";
    
    /**
     * Dialog messages...
     */
    public static final String CREATECOMMANDNOTVALID = "Not a valid Create Collection command";
    public static final String CREATECOMMANDDECLAREERROR = "The create collection signature is not correct. (db.createCollection())";
    public static final String CHECKSYNTAXERROR = "Check Syntax";
    public static final String NAMECOLLECTION = "No valid Collection Name present in command!";
    public static final String ADDCOLLECTIONNAME = "Include Collection Name";
    public static final String CREATECOMMANDOPTIONSNOTVALID = "Some option/s are not of the valid type";
    public static final String MAXDOCUMENTSINVALID = "Max Documents should be an integer!";
    public static final String INVALIDPROPERTYENTRY = "Invalid property type.";
    public static final String DROPCOLLETIONSMESSAGE = "Are you sure you want to delete the selected collections? "
            + "\nBe aware that any data and indices will be deleted, and you can't undo this operation!"
            + "\nThe following will be dropped: ";
    public static final String DROPPEDCOLLECTIONSSUCCESSFULLY = "Below is the output of the Drop Command: ";                
    public static final String DROPCOLLECTIONTITLE = "Confirm Drop Command";
    public static final String COLLECTIONCREATEDSUCCESSFULLY = "The Collection was successfully created.";
    public static final String COLLECTIONCREATED = "Collection Created";
    public static final String ADDCOLLECTION = "Add Collection";
    public static final String DELETECOLLECTION = "Delete Collection";
    public static final String DROPCOLLECTIONSCOMMANDOUTPUT = "Dropped Selected Collection/s Output";
    public static final String SUCCESSFULLYINSTALLED = "MongoDB has been successfully installed";
    public static final String TERMINATEDBYUSER = "The installer has been stopped by the user";
    public static final String TERMINATEDBYUSERTITLE = "Installation Aborted";
    public static final String INSTALLERFAILED = "The installer has failed with the following errors: \n";
    public static final String INSTALLERFAILEDTITLE = "Installer has Failed";
    public static final String QUITEMODETOOLTIP = "MongoDB will be installed un-attended, just like a Ninja";
    public static final String PLEASEWAIT = "Please be patient... MongoDB will soon be installed";
    public static final String PLEASEWAITUNINSTALL = "Please be patient... MongoDB will soon be uninstalled";
    public static final String INSTALLERNOTE = "The following dialog will let you install MongoDB. Please note that this feature is currently only available for Windows Operating Systems. "; 
    public static final String BINLOCATIONERROR = "Location for the 'mongod.exe' could not be resolved!";
    public static final String LOCATIONERROR = "Location Error";
    public static final String DBPATHERROR = "Location for the db storage path could not be resolved!";
    public static final String LOGLOCATIONERROR =  "Location for the log storage path could not be resolved!";
    public static final String SERVICEMONGODSTARTED = "Mongod Server Service has been successfully started!";
    public static final String SERVICEMONGOSTARTED = "Mongo Client Service has been successfully started!";
    public static final String EXCEPTIONMESSAGE = "Process failed with the following exception thrown: ";
    public static final String SUCCESSMESSAGELABEL = "Service Started";
    public static final String ERRORMESSAGE = "Server Service has not been started";
    public static final String SERVERSTOPPED = "Server has been successfully stopped";
    public static final String CLIENTSTOPPED = "Client has been successfully stopped";
    public static final String SERVERSTOPPEDERROR = "We were unable to switch off the server";
    public static final String CLIENTSTOPPEDERROR = "We were unable to switch off the server";
    public static final String SERVERSTOPPEDERROREXCEPTION = "The command has failed with the following exception: ";
    public static final String CLIENTSTOPPEDERROREXCEPTION = "The command has failed with the following exception: ";
    public static final String UNINSTALLMONGO = "Are you sure you want to uninstall MongoDB?";
    public static final String UNINSTALLMONGOTITLE = "Uninstaller";
    public static final String UNINSTALLABORTEDMESSAGE = "Uninstallation has been aborted";
    public static final String UNINSTALLATIONSUCCESSMESSAGE = "Uninstalled successfully";
    public static final String FILEDOESNOTEXIST = "Not a valid *.MSI file selected";
    public static final String CLIENTBINLOCATIONERROR = "Location for the 'mongod.exe' could not be resolved!";
    public static final String ERRORUNINSTALL = "Errors occured during the uninstallation";
    public static final String ERRORUNINSTALLEXCEPTION = "The command has failed with the following exception: ";
    public static final String ERRORUNINSTALLEXCEPTIONTITLE = "Exception";
    public static final String UNABLETOCONNECTTOSERVER = "Unable to connect to server. Make sure it's started";
    
    /**
     * app.properties File property KEYS
     */
    public static final String DEFAULT_INSTALL_PATH = "C:\\MongoDB\\Server\\3.0";
    public static final String BIN_FOLDER = "\\bin";
    public static final String MONGO_BIN_PATH = "mongo_bin_path";
    public static final String DB_STORAGE_PATH = "db_storage_path";
    public static final String LOG_STORAGE_PATH = "log_storage_path";
    public static final String DONT_ALTER_WARNING = "DON'T ALTER THIS FILE SINCE THE PROGRAM MAY WORK ERRENOUSLY";
}
