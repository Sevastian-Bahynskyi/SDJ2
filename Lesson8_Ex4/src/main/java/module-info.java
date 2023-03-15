module com.example.lesson8_ex4 {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.desktop;


    opens com.example.lesson8_ex4 to javafx.fxml;
    opens com.example.lesson8_ex4.view to javafx.fxml;
    exports com.example.lesson8_ex4;
}