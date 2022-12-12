/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.travlemaker.Attractions;

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
 * @author hangzi
 */
public class Attraction {
    private String name;
    private String uid;
    private String location;
    private double cost;
    private String imagePath;
    private String type;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }

    public String getImagePath() {
        return imagePath;
    }

    public void setImagePath(String imagePath) {
        this.imagePath = imagePath;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
  
    public boolean isMatch(String s) {
    return (this.uid == null ? s == null : this.uid.equals(s));
    }

    @Override
    public String toString() {
        return uid;
    }
    
//    private String name;
//    private String uid;
//    private String location;
//    private double cost;
//    private String imagePath;
//    private String type;
//    // 图片的格式需要确定  byte[] picture,
    public void AddUpdateDeleteAttraction(char operation, Long ID, String state, String type, String city, double cost, String location, byte[] picture, String name){
        
        Connection con = MyConnection.getConnection();
        PreparedStatement ps;
        
        // i for insert
        if(operation == 'i'){
            try {
                ps = con.prepareStatement("INSERT INTO OrganizationInfo(OID, OName, OType, OCity, OPrice, OLocation, Oimage, Oattraction) VALUES (?,?,?,?,?,?,?,?)");
                ps.setLong(1, ID);
                ps.setString(2, state);
                ps.setString(3, type);
                ps.setString(4, city);
                ps.setDouble(5, cost);
                ps.setString(6, location);
                ps.setBytes(7, picture);
                ps.setString(8, name);
                
                if(ps.executeUpdate() > 0){
                    JOptionPane.showMessageDialog(null, "New Attraction Added!");
                }
                
            } catch (SQLException ex) {
                Logger.getLogger(Attraction.class.getName()).log(Level.SEVERE, null, ex);
                JOptionPane.showMessageDialog(null, "The id is repeat, Please input another ID!");
            }
            
        }
        
        // update the date when operation == u
        if(operation == 'u'){
            try {
                ps = con.prepareStatement("UPDATE `OrganizationInfo` SET `OName`= ?, `OType`= ?, `OCity`= ?, `OPrice`= ? ,`OLocation`= ?,`Oimage`= ?,`Oattraction`= ? WHERE `OID` = ?");
                              
                ps.setString(1, state);
                ps.setString(2, type);
                ps.setString(3, city);
                ps.setDouble(4, cost);
                ps.setString(5, location);
                ps.setBytes(6, picture);
                ps.setString(7, name);
                ps.setLong(8, ID);

                if(ps.executeUpdate() > 0){
                    JOptionPane.showMessageDialog(null, "Attraction data Updated!");
                }
                
            } catch (SQLException ex) {
                Logger.getLogger(Attraction.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        }
        
        // d for delete
        if(operation == 'd'){
            
            int YesOrNo = JOptionPane.showConfirmDialog(null, "Are you sure to delete this data?","Delete Attraction",JOptionPane.OK_CANCEL_OPTION,0);
            
            if(YesOrNo == JOptionPane.OK_OPTION)
            {
               try {
                ps = con.prepareStatement("DELETE FROM `OrganizationInfo` WHERE `OID` = ?");
                ps.setLong(1,ID);
                if(ps.executeUpdate() > 0){
                    JOptionPane.showMessageDialog(null, "Attraction Deleted");
                    }
                
                } catch (SQLException ex) {
                Logger.getLogger(Attraction.class.getName()).log(Level.SEVERE, null, ex);
                } 
            }
            
            
        }
        
    }
    
    public void fillJtable(JTable table, String valueToSearch){
        
        Connection con = MyConnection.getConnection();
        PreparedStatement ps;
        
        try {
            
            ps = con.prepareStatement("SELECT * FROM `OrganizationInfo` WHERE CONCAT(`OID`, `OName`, `OType`,`OCity`,`OPrice`,`OLocation`,`Oimage`, `Oattraction`)LIKE ?");
            ps.setString(1, "%"+valueToSearch+"%");
            ResultSet rs = ps.executeQuery();
            DefaultTableModel model = (DefaultTableModel)table.getModel();
            
            Object[] row;
            
            while(rs.next()){
                row = new Object[7];
                row[0] = rs.getLong(1);
                row[1] = rs.getString(2);
                row[2] = rs.getString(3);
                row[3] = rs.getString(4);
                row[4] = rs.getDouble(5);
                row[5] = rs.getString(6);
                row[6] = rs.getString(8);
                

                model.addRow(row);
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(Attraction.class.getName()).log(Level.SEVERE, null, ex);
        }                  
        
    }
    
    
}
