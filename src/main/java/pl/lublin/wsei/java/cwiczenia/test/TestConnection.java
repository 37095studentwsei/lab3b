package pl.lublin.wsei.java.cwiczenia.test;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.*;
import java.util.Properties;
//import MyDB;
import com.mysql.jdbc.Driver;

public class TestConnection {
        public static void main(String[] args)throws ClassNotFoundException, SQLException{
            String serverName = "localhost";
            String database = "mydb";
            String portNumber = "3306";
//            Number portNumber = 3306;
//            Connection conn = null;
//            Properties connectionProps = new Properties();
//            connectionProps.put("user", "root");
//            connectionProps.put("password", "root");
//            connectionProps.put("serverTimezone", "Europe/Warsaw");
//
//            conn = DriverManager.getConnection(
//            "jdbc:mysql://"+ serverName + ":" + portNumber + "/" + database, connectionProps);
//
//            System.out.println("Connected to database");

            MyDB myDB = new MyDB(serverName, portNumber, database);
            myDB.setUser("root");
            myDB.setPassword("root");
            Connection conn = myDB.getConnection();
            if (conn != null){
                System.out.println("Połączono do bazy danych");
            }else{
                System.out.println("Problem!!!!");
            }

        }
}
