/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nosqltools;

import java.util.List;

/**
 *
 * @author mgalea
 * This class will aid so as to install the MongoDB for Windows MSI installers
 * http://docs.mongodb.org/manual/tutorial/install-mongodb-on-windows/
 */
public class InstallerController {
    
    private String MsiPath;
    private boolean QuiteModeFlag;
    private String InstallLocation;
    private String AddLocal;
    
    private static enum Arguments
    {
        MSIEXEC_CMD("msiexec.exe"),
        INSTALL_SWITCH("/i"),
        QUITE_MODE_SWITCH("/qn"),
        ADMINISTRATOR_SWITCH("/a"),
        SERVER("Server"),
        ROUTER("Router"),
        CLIENT("Client"),
        MONITORING_TOOLS("MonitoringTools"),
        IMPORT_EXPORT_TOOLS("ImportExportTools"),
        MISCELLENOUS_TOOLS("MiscellaneousTools"),
        INSTALL_LOCATION("INSTALLLOCATION="),
        ADD_LOCAL("ADDLOCAL="),
        CONCATENATION_SWITCH(" ^ "),
        COMMA_SEPARATOR(","),
        ADD_LOCAL_ALL("all"),
        CMD("cmd.exe"),
        CMD_RUN_FLAG("/c");
        
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
    
    //Three constructors overloaded on purposes for 3 combinations, Auto-install/Quite-Custom/Quite-AllComponentSet 
    public InstallerController(String msiPath)
    {
        setPath(msiPath);
        setquiteModeFlag(false);
    }
    
    public InstallerController(String msiPath, String installLocation, List<String> componentSet)
    {
        setPath(msiPath);
        setquiteModeFlag(true);
        setInstallLocation(installLocation);
        
        String components = ""; 
        String arguments = "";
        
        for(int x = 0; x < componentSet.size(); x++)
        {
            components = componentSet.get(x);
            
            arguments += getComponentSet(components);
            
            if(!(x == componentSet.size() -1))
            {
                arguments += Arguments.COMMA_SEPARATOR.getArgument();
            }
        }
        
        setAddLocal(arguments);
    }
    
    public InstallerController(String msiPath, String installLocation, boolean allTB)
    {
        setPath(msiPath);
        setquiteModeFlag(true);
        setInstallLocation(installLocation);
        setAddLocal(Arguments.ADD_LOCAL_ALL.getArgument());
    }
    
    private void setPath(String msiPath)
    {
        this.MsiPath = "\"" + msiPath + "\"";
    }
    
    private String getPath()
    {
        return this.MsiPath;
    }
    
    private void setquiteModeFlag(boolean quiteModeFlag)
    {
        this.QuiteModeFlag = quiteModeFlag;
    }
    
    private boolean getQuiteModeFlag()
    {
        return this.QuiteModeFlag;
    }
    
    private void setInstallLocation(String installLocation)
    {
        this.InstallLocation =  "\"" + installLocation + "\"";
    }
    
    private String getInstallLocation()
    {
        return this.InstallLocation; 
    }
    
    private void setAddLocal(String addLocal)
    {
        this.AddLocal = addLocal;
    }
    
    private String getAddLocal()
    {
        return this.AddLocal;
    }
    
    private String getComponentSet(String components) 
    {
        if (components.contains(MongoReserved.SERVER)) 
        {
            return Arguments.SERVER.getArgument();
        }
        
        if (components.contains(MongoReserved.CLIENT)) 
        {
            return Arguments.CLIENT.getArgument();
        }

        if (components.contains(MongoReserved.ROUTER)) 
        {
            return Arguments.ROUTER.getArgument();
        }

        if (components.contains(MongoReserved.MONITORING_TOOLS)) 
        {
            return Arguments.MONITORING_TOOLS.getArgument();
        }

        if (components.contains(MongoReserved.IMPORT_EXPORT_TOOLS)) 
        {
            return Arguments.IMPORT_EXPORT_TOOLS.getArgument();
        }
        
        if (components.contains(MongoReserved.MISC_TOOLS)) 
        {
            return Arguments.MISCELLENOUS_TOOLS.getArgument();
        }
        
        return null;
    }
    
    protected int InstallMsi()
    {
        try 
        {
            ProcessBuilder builder = new ProcessBuilder(
                    Arguments.CMD.getArgument(), 
                    Arguments.CMD_RUN_FLAG.getArgument(), 
                    getExecCommand()
            );
            Process p = builder.start();
            return p.waitFor();
        } 
        catch(Exception e) 
        {
            e.getMessage();
            e.printStackTrace();
        } 
        
        return -1;
    }
    
    private String getExecCommand()
    {
        if(getQuiteModeFlag())
        {
            return Arguments.MSIEXEC_CMD.getArgument()
                    + " " + Arguments.QUITE_MODE_SWITCH.getArgument()
                    + " " + Arguments.INSTALL_SWITCH.getArgument()
                    + " " + getPath()
                    + Arguments.CONCATENATION_SWITCH.getArgument()
                    + Arguments.INSTALL_LOCATION.getArgument() + this.InstallLocation + Arguments.CONCATENATION_SWITCH.getArgument()
                    + Arguments.ADD_LOCAL.getArgument() + "\"" + this.AddLocal + "\"";
        }
        
        else
        {
            return Arguments.MSIEXEC_CMD.getArgument()
                    + " " + Arguments.INSTALL_SWITCH.getArgument()
                    + " " + getPath();
        }
    }
}
