/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package soccertournamentmanagement;

import java.sql.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import static javax.swing.WindowConstants.DISPOSE_ON_CLOSE;

public class SoccerTournamentManagement {

    
    public static void main(String[] args) throws SQLException, ClassNotFoundException {

        HomeScreen hs = new HomeScreen();
        hs.setVisible(true);
               
        
    }
    
}
