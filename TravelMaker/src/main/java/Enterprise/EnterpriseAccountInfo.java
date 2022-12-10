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
                ps = con.prepareStatement("SELECT * FROM `Enterpriseuser` WHERE `username` = ?");
                
                
            } catch (SQLException ex) {
                Logger.getLogger(EnterpriseAccountInfo.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        }
        
    }
        
    
}
