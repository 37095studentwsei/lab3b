package pl.lublin.wsei.java.cwiczenia.test;

import java.sql.DriverManager;
import java.sql.*;
import java.util.Properties;

import java.sql.Connection;

public class TestSelect {
    public static void main(String[] args) throws SQLException {
        String serverName = "localhost";
        String database = "mydb";
        String portNumber = "3306";

        MyDB myDB = new MyDB(serverName, portNumber, database);
        myDB.setUser("root");
        myDB.setPassword("root");
        Connection conn = myDB.getConnection();
        if (conn != null) {
            Statement polecenie = conn.createStatement();
            ResultSet res = polecenie.executeQuery("SELECT  * FROM coffee_houses");
            System.out.printf("%10s%20s%7s%7s%7s\n","STORE_ID","CITY","COFFEE","MERCH","TOTAL");
            while (res.next()){
                System.out.printf("%10d%20s%7d%7d%7d\n",res.getInt(1),res.getString("CITY"),
                        res.getInt(3),res.getInt(4),res.getInt(5));
            }
        }
        myDB.closeConnection();
        System.out.println("Połączenie z bazą zakończone");
    }

}


