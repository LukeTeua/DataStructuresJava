/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pdc_assignment_2;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Luke
 */
public class GameDatabase {
    Connection conn = null;
    String url = "jdbc:derby:GameDBChopChop_Embd;create=true";
    String dbusername = "pdc";
    String dbpassword = "pdc";
    String rules = "rules goes here";

    public void dbsetup(){
        try{
            conn = DriverManager.getConnection(url, dbusername, dbpassword);
            Statement statement = conn.createStatement();
            String tableName = "GameProfile";
            
            if(!checkTableExisting(tableName)){
                //We created a table to store out players stats.
                statement.executeUpdate("CREATE TABLE " + tableName + " (username VARCHAR(12), password VARCHAR(12), hpMulti INT, dmgMulti INT, luckMulti INT)");
            }
            statement.close();
        } catch (Throwable e) {
            System.out.println("??");
        }
    }



    public GameData checkName(String username, String password){
        GameData data = new GameData();
        Player player = new Player();    

        try{
            Statement statement = conn.createStatement(); //SQL STATEMENT #2 SELECTING THE PROFILE IF IT EXISTS
            ResultSet rs = statement.executeQuery("SELECT username,password FROM GameProfile " + "WHERE username = '" + username + "'");
            if(rs.next()){
                String pass = rs.getString("password");
                System.out.println("***" + pass);
                System.out.println("found user");
                if(password.compareTo(pass) == 0){
                    data.hpMulti = rs.getInt("hpMulti");
                    data.dmgMulti = rs.getInt("dmgMulti");
                    data.luckMulti = rs.getInt("luckMulti");
                    data.loginFlag = true;
                } else {

                    data.loginFlag = false;
                }
            } else { //SQL STATEMENT #3 - Adding new account to DB.
                System.out.println("User created and added to DB");
                statement.executeUpdate("INSERT INTO GameProfile " + "VALUES('" + username + "', '" + password + "', 1, 1, 1)");
                data.loginFlag = true;
            }            
        } catch (SQLException ex){
            Logger.getLogger(GameDatabase.class.getName()).log(Level.SEVERE, null, ex);
        }
        return data;
    }
          //SQL STATEMENT #4 TO CHECK IF TABLES EXIST.
    private boolean checkTableExisting(String newTableName){
        boolean flag = false;
        try {
            System.out.println("check existing tables.... ");
            DatabaseMetaData dbmd = conn.getMetaData();
            ResultSet rsDBMeta = dbmd.getTables(null, null, null, null);
            while (rsDBMeta.next()) {
                String tableName = rsDBMeta.getString("TABLE_NAME");
                if (tableName.compareToIgnoreCase(newTableName) == 0) {
                    System.out.println(tableName + "  is there");
                    flag = true;
                }
            }
            if (rsDBMeta != null) {
                rsDBMeta.close();
            }
        } catch (SQLException ex) {
        }
        return flag;
    }

    //SQL Statement #5 to retrieve multipliers.
    public void saveDB(int hpMulti, int dmgMulti, int luckMulti, String username){
        Statement statement; 
        String Query_Hp_Multiplier = "UPDATE GameProfile SET hpMulti=" +hpMulti + "WHERE username ='"  +username+"'";
        String Query_Dmg_Multiplier = "UPDATE GameProfile SET dmgMulti=" +dmgMulti + "WHERE username ='" +username+"'";
        String Query_Luck_Multiplier = "UPDATE GameProfile SET luckMulti=" +luckMulti + "WHERE username ='" +username+"'";

        try{
            statement = conn.createStatement();
            statement.executeUpdate(Query_Hp_Multiplier);
            statement.executeUpdate(Query_Dmg_Multiplier);
            statement.executeUpdate(Query_Luck_Multiplier);          
            } catch (SQLException ex){
            System.out.println("Update not successful");
        }
    }
}

