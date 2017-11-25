package projectCalculatorMain;

import java.math.BigDecimal;
import java.sql.Date;

/**
 *
 * @author Roxven89
 */
public class CostRowDraft {
    
    private String costName;
    private BigDecimal costPrice;
    private double costQuantity;
    private String costUnit;
    private String costVatRate;
    private double costOverhead;
    private String costVendor;
    private Date costDate;
    
    public CostRowDraft(String costName, BigDecimal costPrice,
                        double costQuantity, String costUnit, String costVatRate, 
                        double costOverhead, String costVendor, Date costDate){
            
            this.costName = costName;
            this.costPrice = costPrice;
            this.costQuantity = costQuantity;
            this.costUnit = costUnit;
            this.costVatRate = costVatRate;
            this.costOverhead = costOverhead;
            this.costVendor = costVendor;
            this.costDate = costDate;
        
    }
    
    public String getCostName(){
        return costName;
    }
    
    public BigDecimal getCostPrice(){
        return costPrice;
    }
    
    public double getCostQuantity(){
        return costQuantity;
    }
    
    public String getCostUnit(){
        return costUnit;
    }
    
    public String getCostVatRate(){
        return costVatRate;
    }
    
    public double getCostOverhead(){
        return costOverhead;
    }
    
    public String getCostVendor(){
        return costVendor;
    }
    
    public Date getCostDate(){
        return costDate;
    }
    
    public void setCostName(String costName){
        this.costName = costName;
    }
    
    public void setCostPrice(BigDecimal costPrice){
        this.costPrice = costPrice;
    }
    
    public void setCostQuantity(double costQuantity){
        this.costQuantity = costQuantity;
    }
    
    public void setCostunit(String costUnit){
        this.costUnit = costUnit;
    }
    
    public void setCostVatRate(String costVatRate){
        this.costVatRate = costVatRate;
    }
    
    public void setCostOverhead(double costOverhead){
        this.costOverhead = costOverhead;
    }
    
    public void setCostVendor(String costVendor){
        this.costVendor = costVendor;
    }
    
    public void setCostDate(Date costDate){
        this.costDate = costDate;
    }
}