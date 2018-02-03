package DataBase;

import java.math.BigDecimal;
import java.sql.Date;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

/**
 *
 * @author Roxven89
 */
public class DataBaseCenter {

    private final String zeroRate = "0%";
    private final String fiveRate = "5%";
    private final String eightRate = "8%";
    private final String twentyThreeRate = "23%";
    private final String reverseChargeRate = "RC";
    private final String millimeter = "mm";
    private final String centimeter = "cm";
    private final String meter = "m";
    private final String kilometer = "km";
    private final String gram = "g";
    private final String kilogram = "kg";
    private final String ton = "t";
    private final String piece = "pc";
    private final String pair = "par";
    private final String hour = "h";
    private final String day = "d";
    private final String m2 = "m2";
    private final String m3 = "m3";

    private final String insertNewMaterial = "INSERT INTO MATERIALS "
            + "(MATERIAL_NAME, MATERIAL_UNIT, MATERIAL_PRICE, "
            + "MATERIAL_VAT_RATE, MATERIAL_VENDOR, MATERIAL_DATE_OF_ENTRY)"
            + " VALUES('";

    private final String selectFromMaterial = "SELECT ID, MATERIAL_NAME, MATERIAL_UNIT,"
            + " MATERIAL_PRICE, MATERIAL_VAT_RATE, MATERIAL_VENDOR, MATERIAL_DATE_OF_ENTRY"
            + " FROM MATERIALS WHERE UPPER(MATERIAL_NAME) LIKE UPPER";

    private final String selectFromMaterialByID = "SELECT MATERIAL_NAME, MATERIAL_UNIT, "
            + "MATERIAL_PRICE, MATERIAL_VAT_RATE, MATERIAL_VENDOR, "
            + "MATERIAL_DATE_OF_ENTRY FROM MATERIALS WHERE ID = ";

    private final String removeFromMaterial = "DELETE FROM MATERIALS WHERE ID = ";

    private final String selectAllFromMaterial = "SELECT * FROM MATERIALS ";

    DataBaseConnector dataBaseConnector = new DataBaseConnector();
    private final ObservableList vateRatesList;
    private final ObservableList unitOfMeasureList;

    public DataBaseCenter() {

        vateRatesList = FXCollections.observableArrayList(zeroRate, fiveRate,
                eightRate, twentyThreeRate, reverseChargeRate);

        unitOfMeasureList = FXCollections.observableArrayList(millimeter,
                centimeter, meter, kilometer, gram, kilogram, ton,
                piece, pair, hour, day, m2, m3);
    }

    public ObservableList getVatRateList() {
        return vateRatesList;
    }

    public ObservableList getUnitOfMeasureList() {
        return unitOfMeasureList;
    }

    public void checkAndCreateDatabase() {
        dataBaseConnector = new DataBaseConnector();
    }

    public void makeConnection() {
        dataBaseConnector.connectToDataBase();
    }

    public void addNewCost(String newCost) {
        dataBaseConnector.addToDataBase(newCost);
    }

    public String getInsertNewMaterial() {
        return insertNewMaterial;
    }

    public void getFromDataBaseToTableView(String materialFormula, String fraze,
            TableView table, TableColumn column_0, TableColumn column_1, TableColumn column_2,
            TableColumn column_3, TableColumn column_4,
            TableColumn column_5, TableColumn column_6) {

        dataBaseConnector.lookForDataBase(materialFormula, fraze, table, column_0, column_1,
                column_2, column_3, column_4, column_5, column_6);
    }

    public String getselectFromMaterial() {
        return selectFromMaterial;
    }

    public void getRemoveFromDataBase(String materialFormula, String fraze) {
        dataBaseConnector.removeFromDataBase(materialFormula, fraze);
    }

    public String getSelectFromMaterialByID() {
        return selectFromMaterialByID;
    }

    public void getLookForDataBaseByID(String formula, String lookingFraze, Label infoLabel,
            Button removeButton, Button resetButton, Button pickButton, TextField idTextField) {
        dataBaseConnector.lookForDataBaseByID(formula, lookingFraze, infoLabel, removeButton,
                resetButton, pickButton, idTextField);
    }

    public String getRemoveFromMaterial() {
        return removeFromMaterial;
    }

    public String getSelectAllFromMaterials() {
        return selectAllFromMaterial;
    }

    public void getDataFromMaterialToChange(String formula, String lookingFraze,
            TextField iD, TextField materialName, TextField netPrice,
            DatePicker dayOfPrice, ChoiceBox unitOfMeasure, ChoiceBox vatRate,
            TextField supplier, Button save, Button pick, ObservableList listUnit, ObservableList listRate) {
        dataBaseConnector.dataFromMaterialToChange(formula, lookingFraze, iD,
                materialName, netPrice, dayOfPrice, unitOfMeasure, vatRate, supplier,
                save, pick, listUnit, listRate);
    }

    public void getSaveMaterialData(String name, String unit, BigDecimal price, String rate,
            String vendor, Date date, int ID) {
        dataBaseConnector.saveMaterialData(name, unit, price, rate, vendor, date, ID);
    }
    
    public void getAddRowMaterialDataToTable(TableColumn column0, TableColumn column1, TableColumn column2,
            TableColumn column3, TableColumn column4, TableColumn column5, TableColumn column6, TableColumn column7,
            TableColumn column8, TableColumn column9, TableView tableView, TextField textField, TextField quantityTF, TextField overheadTF, int materialPosition){
        dataBaseConnector.addRowMaterialDataToTable(column0, column1, column2, column3, column4, column5, column6, column7, column8, column9,
                tableView, textField, quantityTF, overheadTF, materialPosition);
    } 
}