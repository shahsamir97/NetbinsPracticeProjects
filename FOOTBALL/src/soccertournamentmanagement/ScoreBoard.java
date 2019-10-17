/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package soccertournamentmanagement;


import static javafx.scene.paint.Color.color;
import javax.swing.table.DefaultTableModel;
import java.awt.Color;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.Date;
import net.proteanit.sql.DbUtils;
import java.util.Timer;
import java.util.TimerTask;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.scene.chart.PieChart.Data;

public class ScoreBoard extends javax.swing.JFrame {
    
    public ScoreBoard() {
        initComponents();
             refresh();
    }
    
      
   
    
    //Objects of Other classes
    DatabaseConnection dc = new DatabaseConnection();
   
    //Methods
     Timer timer = new Timer();
    public void refresh()
    {
        TimerTask tt = new TimerTask() {

            @Override
            public void run() {
                team1Data();
                team2Data();
                isMatchRunning();
            }
        };
        Timer timer = new Timer();
        timer.schedule(tt, new Date(), 3000);
    }
    
    
//    public void team1Data() throws ClassNotFoundException, SQLException
//    {
//        Connection conn;
//        Statement ps;
//        ResultSet rs;
//        
//        conn=dc.getConnection();
//        String query = "select playername,time from TEAM1";
//        ps=conn.createStatement();
//        rs=ps.executeQuery(query);
//        ResultSetMetaData rsmd=rs.getMetaData();
//        int count = rsmd.getColumnCount();
//        String goals=Integer.toString(count);
//        team1Goals.setText(goals);
//        
//        team1ScoreTable.setModel(DbUtils.resultSetToTableModel(rs));
//        conn.close();
//    }
//    
//    public void team2Data() throws ClassNotFoundException, SQLException
//    {
//        Connection conn;
//        Statement ps;
//        ResultSet rs;
//        
//        conn=dc.getConnection();
//        String query = "select playername,time from TEAM2";
//        ps=conn.createStatement();
//        rs=ps.executeQuery(query);
//        ResultSetMetaData rsmd1=rs.getMetaData();
//        int count1 = rsmd1.getColumnCount();
//        String goals=Integer.toString(count1);
//        team2Goals.setText(goals);
//        
//        team2ScoreTable.setModel(DbUtils.resultSetToTableModel(rs));
//        conn.close();
//    }
    
    
    
    
    
    public void team1Data() 
    {
        try {
            team1GoalsCounter();
            
            Connection conn;
            Statement ps;
            ResultSet rs;
            
            conn=dc.getConnection();
            String query = "select * from TEAM1";
            ps=conn.createStatement();
            rs=ps.executeQuery(query);
            
            team1ScoreTable.setModel(DbUtils.resultSetToTableModel(rs));
            conn.close();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ScoreBoard.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(ScoreBoard.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void team2Data() 
    {
        try {
             team2GoalsCounter();
            
            Connection conn;
            Statement s;
            ResultSet rs;
            
            conn=dc.getConnection();
            String query2 = "select * from TEAM2";
            s=conn.createStatement();
            rs=s.executeQuery(query2);
            
            team2ScoreTable.setModel(DbUtils.resultSetToTableModel(rs));
            conn.close();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ScoreBoard.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(ScoreBoard.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    public void team2GoalsCounter()
    {
        String goal;
        try {
            Connection conn;
            Statement s;
            ResultSet rs;
            
            conn=dc.getConnection();
            String query2 = "select count(*) from team2";
            s=conn.createStatement();
            rs=s.executeQuery(query2);
            rs.next();
            String goals=rs.getString(1);
            team2Goals.setText(goals);
            
          
            conn.close();
            
            // return goals;
        } catch (SQLException ex) {
            Logger.getLogger(ScoreBoard.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ScoreBoard.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
//    
    public void team1GoalsCounter() 
    {
        try {
            Connection conn;
            Statement s;
            ResultSet rs;
            
            String query="select count(*) from team2";
            conn=dc.getConnection();
            s=conn.createStatement();
            rs=s.executeQuery(query);
            rs.next();
            String goals=rs.getString(1);
          team1Goals.setText(goals);
            
           
            
            conn.close();
            
          //  return goals;
        } catch (SQLException ex) {
            Logger.getLogger(ScoreBoard.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ScoreBoard.class.getName()).log(Level.SEVERE, null, ex);
        }
      
    }
    
    public void getTeamNames() throws ClassNotFoundException, SQLException
    {
        Connection conn;
        Statement s;
        ResultSet rs;
        
     String query="select * from currentMatchTeams";
     conn=dc.getConnection();
     s=conn.createStatement();
     rs=s.executeQuery(query);
     rs.next();
    
     team1Label.setText(rs.getString("team1"));
     team2Label.setText(rs.getString("team2")); 
     
     conn.close();
     
       
    }
    
    
    private void isMatchRunning()
    {
        try {
            Connection conn;
            PreparedStatement ps;
            ResultSet rs;
   
            String query="select count(*) from currentMatchTeams";
            conn=dc.getConnection();
            ps=conn.prepareStatement(query);
            rs=ps.executeQuery();
            rs.next();
            int c=rs.getInt(1);
     
            conn.close();
            
            if(c==0)
            {
                team1Label.setForeground(Color.red);
                team2Label.setForeground(Color.red);
                team1Label.setText("No Match to show");
                team2Label.setText("No Match to show");
                
            }else
            {
                team1Label.setForeground(Color.black);
                team2Label.setForeground(Color.black);
                getTeamNames();
                 
            }  } catch (SQLException ex) {
            Logger.getLogger(ScoreBoard.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ScoreBoard.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * This method is called from within the constructor to initialize the form. WARNING: Do NOT modify this code. The content of this method is always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        team1Label = new javax.swing.JLabel();
        team1Goals = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        team1ScoreTable = new javax.swing.JTable();
        jPanel2 = new javax.swing.JPanel();
        team2Label = new javax.swing.JLabel();
        team2Goals = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        team2ScoreTable = new javax.swing.JTable();
        vs = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(988, 534));
        setResizable(false);
        getContentPane().setLayout(null);

        jPanel1.setBackground(new java.awt.Color(0, 153, 255));

        team1Label.setFont(new java.awt.Font("Castellar", 1, 24)); // NOI18N
        team1Label.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        team1Label.setText("TEAM 1");

        team1Goals.setFont(new java.awt.Font("Tahoma", 1, 42)); // NOI18N
        team1Goals.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        team1Goals.setText("0");

        team1ScoreTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "PlayerName", "Time"
            }
        ));
        jScrollPane1.setViewportView(team1ScoreTable);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(133, 133, 133)
                                .addComponent(team1Goals, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(25, 25, 25)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 345, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 10, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(team1Label, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(50, 50, 50)
                .addComponent(team1Label, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(team1Goals)
                .addGap(41, 41, 41)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(109, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel1);
        jPanel1.setBounds(10, 0, 390, 460);

        jPanel2.setBackground(new java.awt.Color(0, 204, 204));

        team2Label.setFont(new java.awt.Font("Castellar", 1, 24)); // NOI18N
        team2Label.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        team2Label.setText("TEAM 2");

        team2Goals.setFont(new java.awt.Font("Tahoma", 1, 42)); // NOI18N
        team2Goals.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        team2Goals.setText("0");

        team2ScoreTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "PlayerName", "Time"
            }
        ));
        jScrollPane3.setViewportView(team2ScoreTable);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(team2Label, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(14, Short.MAX_VALUE)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 345, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(21, 21, 21))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(168, 168, 168)
                .addComponent(team2Goals, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(50, 50, 50)
                .addComponent(team2Label, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(team2Goals)
                .addGap(38, 38, 38)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(112, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel2);
        jPanel2.setBounds(510, 0, 380, 460);

        vs.setFont(new java.awt.Font("Tahoma", 2, 36)); // NOI18N
        vs.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        vs.setText("VS");
        getContentPane().add(vs);
        vs.setBounds(410, 150, 90, 110);

        jLabel1.setBackground(new java.awt.Color(51, 102, 255));
        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setIcon(new javax.swing.ImageIcon("C:\\Users\\Samir\\OneDrive\\Documents\\scorebrd.jpg")); // NOI18N
        jLabel1.setText("jLabel1");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(0, 0, 910, 460);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(ScoreBoard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ScoreBoard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ScoreBoard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ScoreBoard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ScoreBoard().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JLabel team1Goals;
    private javax.swing.JLabel team1Label;
    private javax.swing.JTable team1ScoreTable;
    private javax.swing.JLabel team2Goals;
    private javax.swing.JLabel team2Label;
    private javax.swing.JTable team2ScoreTable;
    private javax.swing.JLabel vs;
    // End of variables declaration//GEN-END:variables
}
