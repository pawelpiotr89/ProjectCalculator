package projectCalculatorMain;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

/**
 *
 * @author Roxven89
 */
public class CostCenterDataBaseDetails {

    private final StringProperty id;
    private final StringProperty name;
    private final StringProperty price;
    private final StringProperty unit;
    private final StringProperty vat;
    private final StringProperty vendor;
    private final StringProperty date;

    public CostCenterDataBaseDetails(String id, String name, String unit, String price, String vat,
            String vendor, String date) {

        this.id = new SimpleStringProperty(id);
        this.name = new SimpleStringProperty(name);
        this.price = new SimpleStringProperty(price);
        this.unit = new SimpleStringProperty(unit);
        this.vat = new SimpleStringProperty(vat);
        this.vendor = new SimpleStringProperty(vendor);
        this.date = new SimpleStringProperty(date);
    }

    public String getId() {
        return id.get();
    }

    public String getName() {
        return name.get();
    }

    public String getPrice() {
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

    public void setName(String vale) {
        name.set(vale);
    }

    public void setPrice(String vale) {
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

    public StringProperty nameId() {
        return id;
    }

    public StringProperty nameProperty() {
        return name;
    }

    public StringProperty namePrice() {
        return price;
    }

    public StringProperty nameUnit() {
        return unit;
    }

    public StringProperty nameVat() {
        return vat;
    }

    public StringProperty nameVendor() {
        return vendor;
    }

    public StringProperty nameDate() {
        return date;
    }
}
