/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataBase;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 *
 * @author Roxven89
 */
public class DataBaseCalculations {
    
    private final String construction = "Construction";
    private final String maintenance = "Maintenance";
    private final String temporarySignalization = "Temporary Signalization";
    private final String material = "Material";
    private final String signalizationController = "Signalization Controller";
    private final String other = "Other";
    private final String generalContractor = "General Contractor";
    private final String subContractor = "Subcontractor";
    
    //private final
    private final ObservableList projectsList;
    private final ObservableList companyAs;
    
    public DataBaseCalculations(){
          
        projectsList = FXCollections.observableArrayList(construction, maintenance, 
                        temporarySignalization, material, signalizationController, 
                        other);  
        
        companyAs = FXCollections.observableArrayList(generalContractor, subContractor);
    }
    
    public ObservableList getProjectsList(){
        return projectsList;
    }
    
    public ObservableList getCompanyAs(){
        return companyAs;
    }
}
