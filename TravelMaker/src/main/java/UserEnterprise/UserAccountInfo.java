/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package UserEnterprise;

import Enterprise.Enterprise;
import LoginPage.MyConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author yufei
 */
public class UserAccountInfo {
    
    public void UpdateUserAccount(char operation, long ID, String Username, String Password, long Phone, String Email, String Location){
        
        Connection con = MyConnection.getConnection();
        PreparedStatement ps;
        
        if(operation == 'u'){
            try {
                ps = con.prepareStatement("UPDATE `Normaluser` SET `username`= ?, `password`= ?, `Phone`= ?, `Email`= ?, `Location`= ? WHERE `ID` = ?");
                
                
                ps.setString(1, Username);
                ps.setString(2, Password);
                ps.setLong(3, Phone);
                ps.setString(4, Email);
                ps.setString(5,  Location);
                ps.setLong(6, ID); 

                if(ps.executeUpdate() > 0){
                    JOptionPane.showMessageDialog(null, "User Account data Updated!");
                }
                
            } catch (SQLException ex) {
                Logger.getLogger(Enterprise.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        }
        
    }
    
}
