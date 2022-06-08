package pl.lublin.wsei.java.cwiczenia.test;
//import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.*;
import java.util.Properties;
//import MyDB.java;
import java.sql.Connection;

public class TestMyDB {

    public static void main(String[] args) {
        String serverName = "localhost";
        String database = "mydb";
        String portNumber = "3306";

        MyDB myDB = new MyDB(serverName, portNumber, database);
        myDB.setUser("root");
        myDB.setPassword("root");
        Connection conn = myDB.getConnection();
        if (conn != null) {
            System.out.println("Połączono do bazy danych");
        }
        myDB.closeConnection();
        System.out.println("Połączenie z bazą zakończone");
    }
}
