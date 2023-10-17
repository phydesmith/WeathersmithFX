package com.javasmithy;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class GeoModel {
    private final StringProperty postalCode = new SimpleStringProperty("");
    private final StringProperty placeName = new SimpleStringProperty("");

    private final StringProperty stateCode = new SimpleStringProperty("");

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

    public String getStateCode() {
        return stateCode.get();
    }

    public StringProperty stateCodeProperty() {
        return stateCode;
    }

    public void setStateCode(String stateCode) {
        this.stateCode.set(stateCode);
    }
}
