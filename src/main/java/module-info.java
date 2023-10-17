module com.javasmithy {
    requires javafx.base;
    requires javafx.controls;
    requires org.kordamp.ikonli.core;
    requires org.kordamp.ikonli.javafx;
    requires org.kordamp.ikonli.antdesignicons;
    requires org.kordamp.ikonli.materialdesign2;
    requires org.kordamp.ikonli.weathericons;
    requires org.controlsfx.controls;
    requires java.net.http;
    requires com.google.gson;
    requires retrofit2;
    requires retrofit2.converter.gson;

    exports com.javasmithy;

    opens com.javasmithy.geo to com.google.gson;
    opens com.javasmithy.geo.point to com.google.gson;
    opens com.javasmithy.weather to com.google.gson;

}
