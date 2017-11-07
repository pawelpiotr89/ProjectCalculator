package projectCalculatorMain;

import DataBase.DataBaseCalculations;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;

/**
 *
 * @author Roxven89
 */
public class PreCalculationData {

    private final DataBaseCalculations dataBaseCalculations;

    private final String sqlAddPersonToDataBase = "INSERT INTO CALCULATING_PERSON (PERSON_NAME) VALUES (?)";
    private final String sqlGetPersonFromDataBase = "SELECT * FROM CALCULATING_PERSON";
    private final String sqlAddProjectTypeDataBase = "INSERT INTO PROJECT_TYPE (PROJECT_TYPE) VALUES (?)";
    private final String sqlGetProjectTypeFromDataBase = "SELECT * FROM PROJECT_TYPE";
    private final String sqlAddProjectSubtypeToDataBase = "INSERT INTO PROJECT_SUBTYPE (PROJECT_SUBTYPE) VALUES (?)";
    private final String sqlGetProjectSubtypeFromDataBase = "SELECT * FROM PROJECT_SUBTYPE";
    private final String sqlAddCompanyAsToDataBase = "INSERT INTO COMPANY_AS (COMPANY_AS) VALUES (?)";
    private final String sqlGetCompanyAsFromDataBase = "SELECT * FROM COMPANY_AS";
    private final String sqlAddCustomerToDataBase = "INSERT INTO CUSTOMER (CUSTOMER) VALUES (?)";
    private final String sqlGetCustomerFromDataBase = "SELECT * FROM CUSTOMER";
    private final String sqlAddCityRegionToDataBase = "INSERT INTO CITY_REGION (CITY_REGION) VALUES (?)";
    private final String sqlGetCityRegionFromDataBase = "SELECT * FROM CITY_REGION";

    public PreCalculationData() {
        dataBaseCalculations = new DataBaseCalculations();
    }

    public void populateChoiceBox(String sqlGetDataFromDataBase) {
        dataBaseCalculations.addDriver();
        dataBaseCalculations.connectToDataBase();
        dataBaseCalculations.getDataFromDataBase(sqlGetDataFromDataBase);
    }

    public void standardTextFieldActions(KeyEvent event) {
        TextField textFieldSource = (TextField) event.getSource();
        String character = event.getCharacter();
        String charSequence = "";
        if (event.getSource().equals(textFieldSource)) {
            charSequence = textFieldSource.getText();
        }
        if (charSequence.length() > 39 || charSequence.startsWith(" ")
                || charSequence.isEmpty() && " ".contains(character)) {
            event.consume();
        }
    }

    public void addPersonToDataBase(ActionEvent event, TextField textField, Label label) {
        dataBaseCalculations.addDriver();
        dataBaseCalculations.connectToDataBase();
        dataBaseCalculations.addToDataBase(textField, label, sqlGetPersonFromDataBase, sqlAddPersonToDataBase);
        dataBaseCalculations.closeDataBase();
    }

    public void addProjectTypeToDataBase(ActionEvent event, TextField textField, Label label) {
        dataBaseCalculations.addDriver();
        dataBaseCalculations.connectToDataBase();
        dataBaseCalculations.addToDataBase(textField, label, sqlGetProjectTypeFromDataBase, sqlAddProjectTypeDataBase);
        dataBaseCalculations.closeDataBase();
    }

    public void addProjectSubtypeToDataBase(ActionEvent event, TextField textField, Label label) {
        dataBaseCalculations.addDriver();
        dataBaseCalculations.connectToDataBase();
        dataBaseCalculations.addToDataBase(textField, label, sqlGetProjectSubtypeFromDataBase, sqlAddProjectSubtypeToDataBase);
        dataBaseCalculations.closeDataBase();
    }

    public void addCompanyAsToDataBase(ActionEvent event, TextField textField, Label label) {
        dataBaseCalculations.addDriver();
        dataBaseCalculations.connectToDataBase();
        dataBaseCalculations.addToDataBase(textField, label, sqlGetCompanyAsFromDataBase, sqlAddCompanyAsToDataBase);
        dataBaseCalculations.closeDataBase();
    }

    public void addCustomerToDataBase(ActionEvent event, TextField textField, Label label) {
        dataBaseCalculations.addDriver();
        dataBaseCalculations.connectToDataBase();
        dataBaseCalculations.addToDataBase(textField, label, sqlGetCustomerFromDataBase, sqlAddCustomerToDataBase);
        dataBaseCalculations.closeDataBase();
    }

    public void addCityRegionToDataBase(ActionEvent event, TextField textField, Label label) {
        dataBaseCalculations.addDriver();
        dataBaseCalculations.connectToDataBase();
        dataBaseCalculations.addToDataBase(textField, label, sqlGetCityRegionFromDataBase, sqlAddCityRegionToDataBase);
        dataBaseCalculations.closeDataBase();
    }

    public ObservableList getList() {
        return dataBaseCalculations.getList();
    }

    public String getSQLPerson() {
        return sqlGetPersonFromDataBase;
    }

    public String getSQLProject() {
        return sqlGetProjectTypeFromDataBase;
    }

    public String getSQLProjectSubtype() {
        return sqlGetProjectSubtypeFromDataBase;
    }

    public String getSQLCompanyAs() {
        return sqlGetCompanyAsFromDataBase;
    }

    public String getSQLCustomer() {
        return sqlGetCustomerFromDataBase;
    }

    public String getSQLCityRegion() {
        return sqlGetCityRegionFromDataBase;
    }
}