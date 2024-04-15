module main.java.org.flyweight {
    requires javafx.controls;
    requires javafx.fxml;


    opens main.java.org.flyweight to javafx.fxml;
    exports main.java.org.flyweight;
}