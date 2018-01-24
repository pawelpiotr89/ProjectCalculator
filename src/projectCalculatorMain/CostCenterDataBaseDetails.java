package projectCalculatorMain;

import javafx.beans.property.DoubleProperty;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

/**
 *
 * @author Roxven89
 */
public class CostCenterDataBaseDetails {

    private final StringProperty id;
    private final StringProperty name;
    private final DoubleProperty price;
    private final StringProperty unit;
    private final StringProperty vat;
    private final StringProperty vendor;
    private final StringProperty date;
    private final IntegerProperty position;
    private final DoubleProperty overhead;
    private final DoubleProperty quantity;

    public CostCenterDataBaseDetails(String id, String name, String unit, double price, String vat,
            String vendor, String date) {

        this.id = new SimpleStringProperty(id);
        this.name = new SimpleStringProperty(name);
        this.price = new SimpleDoubleProperty(price);
        this.unit = new SimpleStringProperty(unit);
        this.vat = new SimpleStringProperty(vat);
        this.vendor = new SimpleStringProperty(vendor);
        this.date = new SimpleStringProperty(date);
        this.position = new SimpleIntegerProperty();
        this.overhead = new SimpleDoubleProperty();
        this.quantity = new SimpleDoubleProperty();
    }
    
    public CostCenterDataBaseDetails(int position, String id, String name, String unit, double price, String vat,
            String vendor, String date, double overhead, double quantity) {

        this.id = new SimpleStringProperty(id);
        this.position = new SimpleIntegerProperty(position);
        this.name = new SimpleStringProperty(name);
        this.price = new SimpleDoubleProperty(price);
        this.unit = new SimpleStringProperty(unit);
        this.vat = new SimpleStringProperty(vat);
        this.vendor = new SimpleStringProperty(vendor);
        this.date = new SimpleStringProperty(date);
        this.overhead = new SimpleDoubleProperty(overhead);
        this.quantity = new SimpleDoubleProperty(quantity);
        
    }

    public String getId() {
        return id.get();
    }
    
    public int getPosition() {
        return position.get();
    }
    
    public double getOverhead() {
        return overhead.get();
    }
    
    public double getQuantity() {
        return quantity.get();
    }

    public String getName() {
        return name.get();
    }

    public double getPrice() {
        return price.get();
    }

    public String getUnit() {
        return unit.get();
    }

    public String getVat() {
        return vat.get();
    }

    public String getVendor() {
        return vendor.get();
    }

    public String getDate() {
        return date.get();
    }

    public void setId(String vale) {
        id.set(vale);
    }
    
    public void setPosition(int vale) {
        position.set(vale);
    }
    
    public void setOverhead(double vale) {
        overhead.set(vale);
    }
    
    public void setQuantity(double vale) {
        quantity.set(vale);
    }

    public void setName(String vale) {
        name.set(vale);
    }

    public void setPrice(double vale) {
        price.set(vale);
    }

    public void setUnit(String vale) {
        unit.set(vale);
    }

    public void setVat(String vale) {
        vat.set(vale);
    }

    public void setVendor(String vale) {
        vendor.set(vale);
    }

    public void setDate(String vale) {
        date.set(vale);
    }

    public StringProperty propertyId() {
        return id;
    }
    
    public IntegerProperty propertyPosition() {
        return position;
    }
    
    public DoubleProperty propertyOverhead() {
        return overhead;
    }
    
    public DoubleProperty propertyQuantity() {
        return quantity;
    }

    public StringProperty propertyName() {
        return name;
    }

    public DoubleProperty propertyPrice() {
        return price;
    }

    public StringProperty propertyUnit() {
        return unit;
    }

    public StringProperty propertyVat() {
        return vat;
    }

    public StringProperty propertyVendor() {
        return vendor;
    }

    public StringProperty propertyDate() {
        return date;
    }
}