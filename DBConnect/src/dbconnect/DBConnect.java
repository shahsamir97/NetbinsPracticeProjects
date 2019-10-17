/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dbconnect;

import java.sql.*;

public class DBConnect {

    public static void main(String[] args){
        try
        {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            Connection conn=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","Samir_database","Samir85649213"); 
       PreparedStatement ps =conn.prepareStatement("Select ename from emp where ename='SMITH'");
       ResultSet rs =ps.executeQuery();
       while(rs.next())
       {
           String name=rs.getString(1);
           if("samir".equals(name))
           {
               System.out.println("Name matched"
                       + "Person Found");
           }else
           {
               System.out.println("Nobody found in database");
           }
       }
        }catch(Exception e)
        {
            System.out.println(e);
            e.printStackTrace();
        }
       
    }
    
}
