/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.travelmaker.UI;

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
public class OrganizationProfile {
    
    public void UpdateOrganizationUserAccount(char operation, String Username, String Password, String language, String admit, byte[] picture){
        
        Connection con = MyConnection.getConnection();
        PreparedStatement ps;
        
        if(operation == 'u'){
            try {
                ps = con.prepareStatement("UPDATE `Organizationuser` SET  `Opassword`= ?, `Olanguage`= ?, `Oadmitted`= ?, `Oimage`= ? WHERE `Oname` = ?");
                
                
                
                ps.setString(1, Password);
                ps.setString(2, language);
                ps.setString(3, admit);
                ps.setBytes(4,  picture);
                ps.setString(5, Username);

                if(ps.executeUpdate() > 0){
                    JOptionPane.showMessageDialog(null, "Organization User Account data Updated!");
                }
                
            } catch (SQLException ex) {
                Logger.getLogger(OrganizationProfile.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        }
    }
    
    
}
