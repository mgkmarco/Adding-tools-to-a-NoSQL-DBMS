/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nosqltools;

import java.io.BufferedReader;
import java.io.File;
import java.io.InputStreamReader;
import java.io.PrintWriter;

/**
 *
 * @author mgalea
 */
public class ServerController 
{
    
    private static enum Arguments
    {
        DB_PATH_OPTION(" --dbpath "),
        LOG_PATH_OPTION(" --logpath "),
        MONGOD_EXE("\\mongod.exe"),
        CMD("cmd.exe "),
        CMD_RUN_FLAG("/c "),
        TASKKILL("taskkill"),
        TERMINATE_CHILD_PROCESSES_SWITCH("/t"),
        FORCE_TERMINATE_SWITCH("/f"),
        IMAGE_NAME_SWITCH("/im");
        
        private final String argument;
        
        Arguments(String argument)
        {
            this.argument = argument;
        }
        
        public String getArgument()
        {
            return argument;
        }      
    }
    
    private PropertiesController PropsCntrl;
    protected String ExceptionMessage;
    
    public ServerController()
    { 
        PropsCntrl = new PropertiesController();
    }
    
    protected int startServer(String bin_path, String db_path, String log_path)
    {
        try 
        {
            // Check if the file dirs exists or not //
            if(!fileExists(bin_path))
            {
                return 999;
            }
            
            if(!fileExists(db_path))
            {
                return 888;
            }
            
            if(!fileExists(log_path))
            {
                return 777;
            }
            
            ProcessBuilder builder = new ProcessBuilder(
                    Arguments.CMD.getArgument(),
                    Arguments.CMD_RUN_FLAG.getArgument(),
                    getExecCommand(bin_path, db_path, log_path)
            );
            Process p = builder.start();
            return p.exitValue();
        } 
        catch(Exception exp) 
        {
            /**
             * Process has been started with success...
             * This is handled as an exception since i test p.exitValue() 
             * and if it is started successfully then p will not have exited 
             * since the process is still running as we would like to....
             */
            if(exp.getMessage().equalsIgnoreCase(MongoReserved.PROCESSNOTEXITED))
            {
                return 0;
            }
            
            else
            {
                ExceptionMessage = exp.getMessage();
                exp.printStackTrace();
                return -1;
            } 
        } 
    }
    
    protected int stopServer()
    {
        try
        {
            ProcessBuilder builder = new ProcessBuilder(
                    Arguments.CMD.getArgument(),
                    Arguments.CMD_RUN_FLAG.getArgument(),
                    Arguments.TASKKILL.getArgument(),
                    Arguments.TERMINATE_CHILD_PROCESSES_SWITCH.getArgument(), 
                    Arguments.FORCE_TERMINATE_SWITCH.getArgument(), 
                    Arguments.IMAGE_NAME_SWITCH.getArgument(), 
                    MongoReserved.MONGODEXE
            );
            Process p = builder.start();
            return p.waitFor();
        }
        catch(Exception exp)
        {
            this.ExceptionMessage = exp.getMessage();
            exp.printStackTrace();
            return -1;
        }
    }
    
    protected boolean isServiceRunning(String serviceName) 
    {
        String line;
        String pidInfo = "";
        
        try
        {
            Process p = Runtime.getRuntime().exec(System.getenv("windir") + "\\system32\\" + "tasklist.exe");

            BufferedReader input = new BufferedReader(new InputStreamReader(p.getInputStream()));

            while ((line = input.readLine()) != null) {
                pidInfo += line;
            }

            input.close();

            if (pidInfo.contains(serviceName)) 
            {
                return true;
            }  
            else
            {
                return false; 
            }
        }
        catch(Exception exp)
        {
            return false;
        }
    }
    
    private boolean fileExists(String path)
    {
        File file = new File(path);
       
        return file.exists();
    }
    
    private String getExecCommand(String bin_path, String db_path, String log_path)
    {
        return  "\"" + bin_path + Arguments.MONGOD_EXE.getArgument() + "\""
                + Arguments.LOG_PATH_OPTION.getArgument() + "\"" + log_path + "\""
                + Arguments.DB_PATH_OPTION.getArgument() + "\"" + db_path + "\"";
    }
}
