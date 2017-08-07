package DataBase;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 *
 * @author Roxven89
 */
public class DataBaseCenter {
    
    private final String zeroRate = "0%";
    private final String fiveRate = "5%";
    private final String eightRate = "8%";
    private final String twentyThreeRate = "23%";
    private final String reverseChargeRate = "RC (Reverse Charge)";
    private final String millimeter = "millimeter (mm)";
    private final String centimeter = "centimeter (cm)";
    private final String meter = "meter (m)";
    private final String kilometer = "kilometer (km)";
    private final String gram = "gram (g)";
    private final String kilogram = "kilogram (kg)";
    private final String ton = "ton (t)";
    private final String piece = "piece (pc)";
    private final String pair = "pair (par)";	
    
    DataBaseConnector dataBaseConnector;
    private final ObservableList vateRatesList;
    private final ObservableList unitOfMeasureList;
    
    public DataBaseCenter(){
        
        vateRatesList = FXCollections.observableArrayList(zeroRate, fiveRate, 
                        eightRate, twentyThreeRate, reverseChargeRate);  
        
        unitOfMeasureList = FXCollections.observableArrayList(millimeter, 
                        centimeter, meter, kilometer, gram, kilogram, ton,
                        piece, pair);
    }
    
    public ObservableList getVatRateList(){
        
        return vateRatesList;
    }
    
    public ObservableList getUnitOfMeasureList(){
        
        return unitOfMeasureList;
    }
}
