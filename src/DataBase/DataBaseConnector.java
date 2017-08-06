package DataBase;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author Roxven89
 */
public class DataBaseConnector {

    private final String dataBaseHost = "jdbc:derby:C:/Users/Public/ProjectCalculatorDataBase";
    private final String dataBaseHostCreate = "jdbc:derby:C:/Users/Public/ProjectCalculatorDataBase;create=true";
    private final String driver = "org.apache.derby.jdbc.EmbeddedDriver";
    private final String userName = "Swarco";
    private final String userPassword = "Swarco";
    private final String sqlCreateTableMaterials = "CREATE TABLE MATERIALS " + 
            "( ID INTEGER NOT NULL PRIMARY KEY, " + 
            "MATERIAL_NAME VARCHAR(40), " + 
            "MATERIAL_UNIT VARCHAR(40), " + 
            "MATERIAL_PRICE DECIMAL(12,2), " + 
            "MATERIAL_VAT_RATE DECIMAL(12,2), " + 
            "MATERIAL_VENDOR VARCHAR(40), " + 
            "MATERIAL_DATE_OF_ENTRY DATE )";
    private final String sqlCreateTableSubconstructors = "CREATE TABLE SUBCONSTRUCTORS " + 
            "( ID INTEGER NOT NULL PRIMARY KEY, " + 
            "SUBCONSTRUCTOR_NAME VARCHAR(40), " + 
            "SUBCONSTRUCTOR_UNIT VARCHAR(40), " + 
            "SUBCONSTRUCTOR_PRICE DECIMAL(12,2), " + 
            "SUBCONSTRUCTOR_VAT_RATE DECIMAL(12,2), " + 
            "SUBCONSTRUCTOR_VENDOR VARCHAR(40), " + 
            "SUBCONSTRUCTOR_DATE_OF_ENTRY DATE )";
    private final String sqlCreateTableLabour = "CREATE TABLE LABOUR " + 
            "( ID INTEGER NOT NULL PRIMARY KEY, " + 
            "LABOUR_EMPLOYEE_NAME VARCHAR(40), " + 
            "LABOUR_UNIT VARCHAR(40), " + 
            "LABOUR_COST_PER_HOUR DECIMAL(12,2), " + 
            "LABOUR_GROSS_OVERHEAD DECIMAL(12,2), " + 
            "LABOUR_EMPLOYEE_TYPE VARCHAR(40), " + 
            "LABOUR_DATE_OF_ENTRY DATE )";
    private final String sqlCreateTableLogistic = "CREATE TABLE LOGISTIC " + 
            "( ID INTEGER NOT NULL PRIMARY KEY, " + 
            "LOGISTIC_NAME VARCHAR(40), " + 
            "LOGISTIC_UNIT VARCHAR(40), " + 
            "LOGISTIC_PRICE DECIMAL(12,2), " + 
            "LOGISTIC_VAT_RATE DECIMAL(12,2), " + 
            "LOGISTIC_VENDOR VARCHAR(40), " + 
            "LOGISTIC_DATE_OF_ENTRY DATE )";
    private final String sqlCreateTableOtherCosts = "CREATE TABLE OTHERCOSTS " + 
            "( ID INTEGER NOT NULL PRIMARY KEY, " + 
            "OTHERCOSTS_NAME VARCHAR(40), " + 
            "OTHERCOSTS_UNIT VARCHAR(40), " + 
            "OTHERCOSTS_PRICE DECIMAL(12,2), " + 
            "OTHERCOSTS_VAT_RATE DECIMAL(12,2), " + 
            "OTHERCOSTS_VENDOR VARCHAR(40), " + 
            "OTHERCOSTS_DATE_OF_ENTRY DATE )";
    Connection connection;
    DatabaseMetaData metaData;
    Statement statement;

    public DataBaseConnector() {

        try {
            Class.forName(driver);
        } catch (java.lang.ClassNotFoundException error) {
            System.out.print(error);
        }

        try {
            connection = DriverManager.getConnection(dataBaseHost);
        } catch (SQLException error) {
            System.out.print(error);
            
            try {
                connection = DriverManager.getConnection(dataBaseHostCreate);
                statement = connection.createStatement();
                
                statement.addBatch(sqlCreateTableMaterials);
                statement.addBatch(sqlCreateTableSubconstructors);
                statement.addBatch(sqlCreateTableLabour);
                statement.addBatch(sqlCreateTableLogistic);
                statement.addBatch(sqlCreateTableOtherCosts);
               
                statement.executeLargeBatch();
                statement.close();
                
            } catch (SQLException errorX) {
                System.out.print(errorX);
            }  
        } finally {
            
            try {
                connection.close();
            } catch (SQLException error) {
                System.out.print(error);
            }
        }
    }
}