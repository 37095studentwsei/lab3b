module com.example.lab3b {
    requires javafx.controls;
    requires javafx.fxml;
    requires mysql.connector.java;
    requires java.sql;


    opens pl.lublin.wsei.java.cwiczenia.test to javafx.fxml;
    exports pl.lublin.wsei.java.cwiczenia.test;
}