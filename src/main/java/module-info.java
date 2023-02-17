module io.javasmithy {
    requires javafx.base;
    requires javafx.controls;
    requires org.kordamp.ikonli.core;
    requires org.kordamp.ikonli.javafx;
    requires org.kordamp.ikonli.antdesignicons;
    requires org.kordamp.ikonli.weathericons;
    requires java.net.http;
    requires com.google.gson;
    requires retrofit2;
    requires retrofit2.converter.gson;

    exports io.javasmithy;

    opens io.javasmithy.geo to com.google.gson;
    opens io.javasmithy.geo.point to com.google.gson;
    opens io.javasmithy.weather to com.google.gson;

}
