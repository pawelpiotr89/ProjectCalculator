package projectCalculatorControllers;

import javafx.fxml.FXML;

import javafx.scene.control.TitledPane;

/**
 * FXML Controller class
 *
 * @author Roxven89
 */
public class CostCenterPaneController {
    
    @FXML
    private TitledPane materialCostTitledPane;
    
    @FXML
    private TitledPane subconstructorsCostTitledPane;
    
    @FXML
    private TitledPane labourCostTitledPane;
    
    @FXML
    private TitledPane logisticCostTitledPane;
    
    @FXML
    private TitledPane otherCostTitledPane;
    
    @FXML
    private TitledPane backToMenuTitledPane;
    
    @FXML
    private TitledPane addNewMaterialCostTitledPane;
    
    @FXML
    private TitledPane changeMaterialCostTitledPane;
    
    @FXML
    private TitledPane displayMaterialCostTitledPane;
    
    @FXML
    private TitledPane removeMaterialCostTitledPane;
    
    @FXML
    private void onMouseReleased(){
        if(addNewMaterialCostTitledPane.isExpanded() || 
           changeMaterialCostTitledPane.isExpanded() || 
           displayMaterialCostTitledPane.isExpanded() ||
           removeMaterialCostTitledPane.isExpanded()) {
           materialCostTitledPane.setCollapsible(false);
           subconstructorsCostTitledPane.setCollapsible(false);
           labourCostTitledPane.setCollapsible(false);
           logisticCostTitledPane.setCollapsible(false);
           otherCostTitledPane.setCollapsible(false);
           backToMenuTitledPane.setCollapsible(false);
        } else {
           materialCostTitledPane.setCollapsible(true);
           subconstructorsCostTitledPane.setCollapsible(true);
           labourCostTitledPane.setCollapsible(true);
           logisticCostTitledPane.setCollapsible(true);
           otherCostTitledPane.setCollapsible(true);
           backToMenuTitledPane.setCollapsible(true);
        }
    }          
}
