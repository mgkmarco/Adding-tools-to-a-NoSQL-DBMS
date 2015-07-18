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
    
    public static String INITSTRING = "";
    
    public static String CREATECOMMANDNOTVALID = "Not a valid Create Collection command";
    public static String CREATECOMMANDDECLAREERROR = "The create collection signature is not correct. (db.createCollection())";
    public static String CHECKSYNTAXERROR = "Check Syntax";
    public static String NAMECOLLECTION = "No valid Collection Name present in command!";
    public static String ADDCOLLECTIONNAME = "Include Collection Name";
    public static String CREATECOMMANDOPTIONSNOTVALID = "Some option/s are not of the valid type";
    public static String MAXDOCUMENTSINVALID = "Max Documents should be an integer!";
    public static String INVALIDPROPERTYENTRY = "Invalid property type."; 
}
