/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.travelmaker.System;

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
public class SystemManage {
    
    public void AddUpdateDeleteEnterprise(char operation, long ID, String name, String password){
        
        Connection con = MyConnection.getConnection();
        PreparedStatement ps;
        
        // i for insert
        if(operation == 'i'){
            try {
                ps = con.prepareStatement("INSERT INTO Adminuser(AID, Ausername, Apassword) VALUES (?,?,?)");
                ps.setLong(1, ID);
                ps.setString(2, name);
                ps.setString(3, password);
                if(ps.executeUpdate() > 0){
                    JOptionPane.showMessageDialog(null, "New Admin Added!");
                }
                else{
                    JOptionPane.showMessageDialog(null, "The id is repeated!");
                }
                
            } catch (SQLException ex) {
                Logger.getLogger(EnterpriseManage.class.getName()).log(Level.SEVERE, null, ex);
            }   
        }
        
        if(operation == 'u'){
            try {
                ps = con.prepareStatement("UPDATE `Adminuser` SET `Ausername`= ?, `Apassword`= ? WHERE `AID` = ?");
                
                
                ps.setString(1, name);
                ps.setString(2, password);
                ps.setLong(3, ID); 

                if(ps.executeUpdate() > 0){
                    JOptionPane.showMessageDialog(null, "Admin data Updated!");
                }
                else{
                    JOptionPane.showMessageDialog(null, "You can't change the ID!");
                }
                
            } catch (SQLException ex) {
                Logger.getLogger(Enterprise.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        }
        
        if(operation == 'd'){
            
            int YesOrNo = JOptionPane.showConfirmDialog(null, "Are you sure to delete this data?","Delete User",JOptionPane.OK_CANCEL_OPTION,0);
            
            if(YesOrNo == JOptionPane.OK_OPTION)
            {
               try {
                ps = con.prepareStatement("DELETE FROM `Adminuser` WHERE `AID` = ?");
                ps.setLong(1,ID);
                if(ps.executeUpdate() > 0){
                    JOptionPane.showMessageDialog(null, "Admin user Deleted");
                    }
                
                } catch (SQLException ex) {
                Logger.getLogger(EnterpriseManage.class.getName()).log(Level.SEVERE, null, ex);
                } 
            } 
        }
        
    }
    
    public void fillJtable(JTable table, String valueToSearch){
        
        Connection con = MyConnection.getConnection();
        PreparedStatement ps;
        
        try {
            
            ps = con.prepareStatement("SELECT * FROM `Adminuser` WHERE CONCAT(`Ausername`)LIKE ?");
            ps.setString(1, "%"+valueToSearch+"%");
            ResultSet rs = ps.executeQuery();
            DefaultTableModel model = (DefaultTableModel)table.getModel();
            
            Object[] row;
            
            while(rs.next()){
                row = new Object[3];
                row[0] = rs.getLong(1);
                row[1] = rs.getString(2);
                row[2] = rs.getString(3);
                
                model.addRow(row);
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(EnterpriseManage.class.getName()).log(Level.SEVERE, null, ex);
        }   
    }
    
}
