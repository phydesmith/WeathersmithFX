package io.javasmithy;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class GeoModel {
    private final StringProperty postalCode = new SimpleStringProperty("");
    private final StringProperty placeName = new SimpleStringProperty("");

    public String getPlaceName() {
        return placeName.get();
    }

    public StringProperty placeNameProperty() {
        return placeName;
    }

    public void setPlaceName(String placeName) {
        this.placeName.set(placeName);
    }

    public String getPostalCode() {
        return postalCode.get();
    }

    public StringProperty postalCodeProperty() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode.set(postalCode);
    }
}
