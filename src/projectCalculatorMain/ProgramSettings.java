package projectCalculatorMain;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Properties;

/**
 *
 * @author Roxven89
 */
public class ProgramSettings {
    private final String configPath = "C:\\Users\\Public\\DataBasesPC\\config.properties";
    Properties prop = new Properties();
    OutputStream os = null;
    
    public void createProperties(){
        File configFile = new File(configPath);
        if(configFile.exists()){
        } else{
            prop.setProperty("path", configPath);
                try {
                    os = new FileOutputStream(configPath);
                        try {
                            prop.store(os, null);
                            os.close();
                        } catch (IOException ex) {
                          }
                } catch (FileNotFoundException e) {
                }
                }
    }
    
    public String getPath(){
        return configPath;
    }
}