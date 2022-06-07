module com.example.lab3b {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.lab3b to javafx.fxml;
    exports com.example.lab3b;
}