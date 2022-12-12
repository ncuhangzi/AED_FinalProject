/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.travelmaker.UI;

import Enterprise.Enterprise;
import LoginPage.MyConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author yufei
 */
public class OrganizationInfo {
    
    public void AddUpdateDeleteEnterprise(char operation, long ID, String name, String password, String mayor, String level, String zipcode, String population, String location, byte[] picture){
        
        Connection con = MyConnection.getConnection();
        PreparedStatement ps;
        
        // i for insert
        if(operation == 'i'){
            try {
                ps = con.prepareStatement("INSERT INTO OrganizationCity(OID, Cityname, Password, Mayor, Level, Zipcode, Population, Location, Photo) VALUES (?,?,?,?,?,?,?,?,?)");
                ps.setLong(1, ID);
                ps.setString(2, name);
                ps.setString(3, password);
                ps.setString(4, mayor);
                ps.setString(5, level);
                ps.setString(6, zipcode);
                ps.setString(7, population);
                ps.setString(8, location);
                ps.setBytes(9, picture);
                
                
                if(ps.executeUpdate() > 0){
                    JOptionPane.showMessageDialog(null, "New Organization City Added!");
                }
                
            } catch (SQLException ex) {
                Logger.getLogger(OrganizationInfo.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        }
        
        // update the date when operation == u
        if(operation == 'u'){
            try {
                ps = con.prepareStatement("UPDATE `OrganizationCity` SET `Cityname`= ?, `Password`= ?, `Mayor`= ?, `Level`= ?, `Zipcode`= ?, `Population`= ?, `Location`= ?, `Photo`= ? WHERE `OID` = ?");
                
                
                ps.setString(1, name);
                ps.setString(2, password);
                ps.setString(3, mayor);
                ps.setString(4, level);
                ps.setString(5, zipcode);
                ps.setString(6,  population);
                ps.setString(7, location);
                ps.setBytes(8, picture);
                ps.setLong(9, ID);
                

                if(ps.executeUpdate() > 0){
                    JOptionPane.showMessageDialog(null, "Organization data Updated!");
                }
                
            } catch (SQLException ex) {
                Logger.getLogger(OrganizationInfo.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        }
        
        // d for delete
        if(operation == 'd'){
            
            int YesOrNo = JOptionPane.showConfirmDialog(null, "Are you sure to delete this data?","Delete Organization",JOptionPane.OK_CANCEL_OPTION,0);
            
            if(YesOrNo == JOptionPane.OK_OPTION)
            {
               try {
                ps = con.prepareStatement("DELETE FROM `OrganizationCity` WHERE `OID` = ?");
                ps.setLong(1,ID);
                if(ps.executeUpdate() > 0){
                    JOptionPane.showMessageDialog(null, "Organization City Deleted");
                    }
                
                } catch (SQLException ex) {
                Logger.getLogger(OrganizationInfo.class.getName()).log(Level.SEVERE, null, ex);
                } 
            }
            
            
        }
        
    }
    
    
    // fill the table
    public void fillJtable(JTable table, String valueToSearch){
        
        Connection con = MyConnection.getConnection();
        PreparedStatement ps;
        
        try {
            
            ps = con.prepareStatement("SELECT * FROM `OrganizationCity` WHERE CONCAT(`Cityname`,`Location`)LIKE ?");
            ps.setString(1, "%"+valueToSearch+"%");
            ResultSet rs = ps.executeQuery();
            DefaultTableModel model = (DefaultTableModel)table.getModel();
            
            Object[] row;
            
            while(rs.next()){
                
//                ps.setLong(1, ID);
//                ps.setString(2, name);
//                ps.setString(3, password);
//                ps.setString(4, mayor);
//                ps.setString(5, level);
//                ps.setString(6, zipcode);
//                ps.setString(7, population);
//                ps.setString(8, location);
//                ps.setBytes(9, picture);
                
                row = new Object[12];
                row[0] = rs.getLong(1);
                row[1] = rs.getString(2);
                row[2] = rs.getString(3);
                row[3] = rs.getString(4);
                row[4] = rs.getString(5);
                row[5] = rs.getString(6);
                row[6] = rs.getString(7);
                row[7] = rs.getString(8);
                row[8] = rs.getBlob(9);

                
                model.addRow(row);
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(OrganizationInfo.class.getName()).log(Level.SEVERE, null, ex);
        }   
    }
    
}
