package DataBase;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

/**
 *
 * @author Roxven89
 */
public final class DataBaseCalculations {
    
    private final String dataBaseHost = "jdbc:derby:C:/Users/Public/ProjectCalculationPreCalculationDataBase";
    private final String dataBaseHostCreate = "jdbc:derby:C:/Users/Public/ProjectCalculationPreCalculationDataBase;create=true;";
    private final String driver = "org.apache.derby.jdbc.EmbeddedDriver";
    private final String user = "Swarco";
    private final String password = "Swarco";
    private final String end = "jdbc:derby:C:/Users/Public/ProjectCalculationPreCalculationDataBase;shutdown=true";
    
    private final String sqlCreateCalculatingPersonTable = "CREATE TABLE CALCULATING_PERSON (PERSON_NAME VARCHAR (30))";
    private final String sqlCreateProjectTypeTable = "CREATE TABLE PROJECT_TYPE (PROJECT_TYPE VARCHAR(30))";
    private final String sqlCreateProjectSubtypeTable = "CREATE TABLE PROJECT_SUBTYPE (PROJECT_SUBTYPE VARCHAR (30))";
    private final String sqlCreateTableCompanyAsTable = "CREATE TABLE COMPANY_AS (COMPANY_AS VARCHAR (30))";
    private final String sqlCreateTableCustomerTable = "CREATE TABLE CUSTOMER (CUSTOMER VARCHAR (30))";
    private final String sqlCreateTableCityRegionTable = "CREATE TABLE CITY_REGION (CITY_REGION VARCHAR (30))";

    private final String correctInsertStatus = "Data added successfully!";
    private final String incorrectInsertStatus = "Data error! Please enter correct data.";
    private final String duplicateInsertStatus = "Data already exist!";
    
    private Connection connection;
    private Statement statement;
    private PreparedStatement preparedStatement;
    private ObservableList<String> list;

    public DataBaseCalculations() {
        list = FXCollections.observableArrayList();
        addDriver();

        try {
            connection = DriverManager.getConnection(dataBaseHost, user, password);
        } catch (SQLException error) {
            System.out.print(error);

            try {
                connection = DriverManager.getConnection(dataBaseHostCreate, user, password);
                statement = connection.createStatement();

                statement.addBatch(sqlCreateCalculatingPersonTable);
                statement.addBatch(sqlCreateProjectTypeTable);
                statement.addBatch(sqlCreateProjectSubtypeTable);
                statement.addBatch(sqlCreateTableCompanyAsTable);
                statement.addBatch(sqlCreateTableCustomerTable);
                statement.addBatch(sqlCreateTableCityRegionTable);

                statement.executeBatch();
                statement.close();

            } catch (SQLException errorX) {
                System.out.print(errorX);
            }
        } finally {

            try {
                connection = DriverManager.getConnection(end);
            } catch (SQLException error) {
                System.out.print(error);
            }
        }
    }
    
    public void connectToDataBase(){
        try {
            connection = DriverManager.getConnection(dataBaseHost, user, password);
            statement = connection.createStatement();
        } catch (SQLException error) {
            System.out.print(error);
        }
    }
    
    public void addDriver() {
        try {
            Class.forName(driver);
        } catch (java.lang.ClassNotFoundException error) {
            System.out.print(error);
        }
    }
    
    public void closeDataBase(){
        try {
                connection = DriverManager.getConnection(end);
            } catch (SQLException error) {
                System.out.print(error);
            }
    }
    
    public void addToDataBase(TextField textField, Label label, String sqlGetData, String sqlAddData){
        if(!textField.getText().trim().isEmpty()){
                try {
            ResultSet result = statement.executeQuery(sqlGetData);
            while (result.next()) {
                String value = String.valueOf(result.getString(1));
                if(value.equals(textField.getText())){
                    label.setText(duplicateInsertStatus);
                    return;
                }
            }
            statement.close();
        } catch (SQLException error) {
            System.out.print(error);
        }    
                    try {
                        preparedStatement = connection.prepareStatement(sqlAddData);
                        preparedStatement.setString(1, textField.getText());
                        preparedStatement.executeUpdate();
                        preparedStatement.close();
                    } catch (SQLException error) {
                        System.out.print(error);
                    }
                    label.setText(correctInsertStatus);
                    textField.clear();
        }
         else{
              label.setText(incorrectInsertStatus);
         }
    }
    
    public void getDataFromDataBase(String sqlAddData){
        try {
            list.clear();
            ResultSet result = statement.executeQuery(sqlAddData);
            while (result.next()) {
                String value = String.valueOf(result.getString(1));
                list.add(value);
            }
            statement.close();
        } catch (SQLException error) {
            System.out.print(error);
        } finally {
            closeDataBase();
        }
    }
    
    public ObservableList getList(){
        return list;
    }
}