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
    private final String millimeter = "mm (millimeter)";
    private final String centimeter = "cm (centimeter)";
    private final String meter = "m (meter)";
    private final String kilometer = "km (kilometer)";
    private final String gram = "g (gram)";
    private final String kilogram = "kg (kilogram)";
    private final String ton = "t (ton)";
    private final String piece = "pc (piece)";
    private final String pair = "par (pair)";
    
    private final String insertNewMaterial = "INSERT INTO MATERIALS " + "(MATERIAL_NAME, MATERIAL_UNIT,"
                        + " MATERIAL_PRICE, MATERIAL_VAT_RATE, MATERIAL_VENDOR, MATERIAL_DATE_OF_ENTRY)" + 
                        " VALUES('";
    
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
    
    public void checkAndCreateDatabase(){
        dataBaseConnector = new DataBaseConnector();
    }
    
    public void makeConnection(){
        dataBaseConnector.connectToDataBase();
    }
    
    public void addNewCost(String newCost){
        dataBaseConnector.addToDataBase(newCost);
    }
    
    public String getInsertNewMaterial(){
        return insertNewMaterial;
    }
}
