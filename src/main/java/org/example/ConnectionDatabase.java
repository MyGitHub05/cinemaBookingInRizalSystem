package org.example;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionDatabase extends Declaration{
    private static final String dbname_url = "jdbc:mysql://localhost:3306/cinemasinrizal";
    private static final String user = "root";
    private static final String password = "";
    private static Connection con;

    public void connect(){
        try {
            con = connection();
            System.out.println("connected");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }
    public Connection connection() throws SQLException {
        return DriverManager.getConnection(dbname_url,user,password);
    }
}
