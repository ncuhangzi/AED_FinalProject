/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Enterprise;

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
public class EnterpriseAccountInfo {
    
    public void UpdateEnterpriseAccount(char operation, long ID, String Username, String Password, String EnterpriseName, long Phone, String Email, String Location, String Introduction){
        
        Connection con = MyConnection.getConnection();
        PreparedStatement ps;
        
        if(operation == 'u'){
            try {
                ps = con.prepareStatement("UPDATE `Enterpriseuser` SET `username`= ?, `password`= ?, `EnterpriseName`= ?, `Phone`= ?, `Email`= ?, `Location`= ?, `Introduction`= ? WHERE `ID` = ?");
                
                
                ps.setString(1, Username);
                ps.setString(2, Password);
                ps.setString(3, EnterpriseName);
                ps.setLong(4, Phone);
                ps.setString(5, Email);
                ps.setString(6,  Location);
                ps.setString(7, Introduction);
                ps.setLong(8, ID); 

                if(ps.executeUpdate() > 0){
                    JOptionPane.showMessageDialog(null, "Enterprise data Updated!");
                }
                
            } catch (SQLException ex) {
                Logger.getLogger(Enterprise.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        }
        
    }
        
    
}
