package pl.lublin.wsei.java.cwiczenia.test;
        import java.sql.Connection;
        import java.sql.DriverManager;
        import java.sql.*;
        import java.util.Properties;

        import com.mysql.jdbc.Driver;

public class MyDB {

    public MyDB(String dbAddress, String dbPort, String dbName) {
        this.dbAddress = dbAddress;
        this.dbPort = dbPort;
        this.dbName = dbName;
    }

    private Connection conn = null;
    private String dbAddress;
    private String dbPort;
    private String dbName;
    private String user;
    private String password;

    private void connect() {
        Properties connectionProps = new Properties();
        connectionProps.put("user", user);
        connectionProps.put("password", password);
        connectionProps.put("serverTimezone", "Europe/Warsaw");

        String jdbcString = "jdbc:mysql://" + dbAddress + ":" + dbPort + "/" + dbName;
        try {
            conn = DriverManager.getConnection(
                    jdbcString, connectionProps);
            System.out.println("Connected to database" + dbName);
        } catch (SQLException e) {
            System.out.println("Błąd połączenia do bazy" + jdbcString);
            System.out.println("Komunikat błędu:" + e.getMessage());
            conn = null;

        }
    }
    public Connection getConnection () {
        if (conn == null)
            connect();
        return conn;
    }

    public void setUser (String user){
        this.user = user;
    }

    public void setPassword (String password){
        this.password = password;
    }
    public void closeConnection(){
        if (conn !=null)
            try{
                conn.close();
            } catch (SQLException e){
                System.out.println("Błąd przy zamykaniu łącza bazodanowego"+e.getMessage());
            }
        conn=null;
    }

}
