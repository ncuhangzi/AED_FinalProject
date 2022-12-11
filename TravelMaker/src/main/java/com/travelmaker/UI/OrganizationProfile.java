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
    
    public void UpdateOrganizationUserAccount(char operation, long ID, String Username, String Password, String language, String admit, byte[] picture){
        
        Connection con = MyConnection.getConnection();
        PreparedStatement ps;
        
        if(operation == 'u'){
            try {
                ps = con.prepareStatement("UPDATE `Organizationuser` SET `Oname`= ?, `Opassword`= ?, `Olanguage`= ?, `Oadmitted`= ?, `Oimage`= ? WHERE `ID` = ?");
                
                
                ps.setString(1, Username);
                ps.setString(2, Password);
                ps.setString(3, language);
                ps.setString(4, admit);
                ps.setBytes(5,  picture);
                ps.setLong(6, ID); 

                if(ps.executeUpdate() > 0){
                    JOptionPane.showMessageDialog(null, "Organization User Account data Updated!");
                }
                
            } catch (SQLException ex) {
                Logger.getLogger(OrganizationProfile.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        }
    }
    
    
}
