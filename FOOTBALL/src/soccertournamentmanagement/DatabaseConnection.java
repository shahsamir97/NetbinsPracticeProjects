
package soccertournamentmanagement;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {
    
   Connection conn;
   
   public Connection getConnection() throws ClassNotFoundException, SQLException
    {
        Class.forName("oracle.jdbc.driver.OracleDriver");
        conn=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","appdatabase","cyber101");
        
        return conn;
    }
   
}
