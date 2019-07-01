/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package finalproject1;

import java.sql.Connection;                                          //INITIALIZATION
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 *
 * @author OWNER
 */

class scoreboard
{
    Connection conn;                                    // prepare a connection to the database
    ResultSet rs;
    PreparedStatement pst;                              // prepare the statements to be executed
    Statement stmt;                                     // prepare the statement to be filled with its contents
    String value;
    
    int score = 0;
    
    public int getScore()                                   // a function to get the total score of the player obtained 
        {
            String sql = "SELECT scores.score FROM scores";
            
            try
            {
                conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/finalproject1", "root", "");
                stmt = conn.createStatement();
                //pst = conn.prepareStatement(sql);
                rs = stmt.executeQuery(sql);                                                                                                                                                                                                                                                                                                       
                //pst.executeUpdate();
                //rs = pst.executeQuery();
                while(rs.next())
                {
                    int score = rs.getInt("score");
                    return score;
                }
            }
            catch (Exception e)
            {
                System.err.print("\n[GETSCORE] Whoops.. Somethings not right.. ");
                e.printStackTrace();
            }
            return 0;
        }
    
    public void addScore()                                          // a function to be called when a player guessed a correct answer in the quiz
        {
            String sql = "UPDATE scores SET score = score + 10";
            try
            {
                conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/finalproject1", "root", "");
                stmt = conn.createStatement();
                pst = conn.prepareStatement(sql);
                pst.executeUpdate();
                
            }
            catch (Exception e)
            {
                System.err.print("\n[ADDSCORE] Whoops.. Somethings not right.. ");
            }
        }
    
    public void reset()                                     // a function to reset/dispose the whole data in the score table in the database; used when creating a new game
        {
            String sql = "UPDATE scores SET score = 0";
            try
            {
                conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/finalproject1", "root", "");
                stmt = conn.createStatement();
                pst = conn.prepareStatement(sql);
                pst.executeUpdate();
            }
            catch (Exception e)
            {
                System.err.print("\n[RESET SCORE] Whoops.. Somethings not right.. ");
            }
        }
}
