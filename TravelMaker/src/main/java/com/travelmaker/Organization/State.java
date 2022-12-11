/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.travelmaker.Organization;

import Enterprise.Enterprise;
import LoginPage.MyConnection;
import com.travlemaker.Attractions.Attraction;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author hangzi
 */
public class State {
    private String name;
    private String password;
    private String language;
    private String admitted;
    private String imagePath;
    ArrayList<City> cityList;

    public State(String name, String password) {
        this.name = name;
        this.password = password;
        this.cityList = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public String getAdmitted() {
        return admitted;
    }

    public void setAdmitted(String admitted) {
        this.admitted = admitted;
    }

    public String getImagePath() {
        return imagePath;
    }

    public void setImagePath(String imagePath) {
        this.imagePath = imagePath;
    }

    public ArrayList<City> getCityList() {
        return cityList;
    }

    public void setCityList(ArrayList<City> cityList) {
        this.cityList = cityList;
    }
    
    public boolean isMatch(String name){
        return this.name.equals(name);
    }
    
    public City newCity(String name, String password){
        City city = new City(name, password);
        cityList.add(city);
        return city;
    }
    public City findCity(String name) {

        for (City c : cityList) {

            if (c.isMatch(name)) {
                return c;
            }
        }
            return null;
    }
    public void deleteCity(City city){
        cityList.remove(city);
    }
    
    public boolean isExisted(String name){
        for (City c : cityList) {

            if (c.isMatch(name)) {
                return true;
            }
        }
            return false;
    }
    // 图片的格式需要确定  byte[] picture,
    public void AddUpdateDeleteOrganziation(char operation, String name, String password, String language, String admitted, byte[] picture){
        
        Connection con = MyConnection.getConnection();
        PreparedStatement ps;
        
        // i for insert
        if(operation == 'i'){
            try {
                ps = con.prepareStatement("INSERT INTO OrganizationUser(Name, Password, Language, Admitted, Picture) VALUES (?,?,?,?,?)");
                ps.setString(1, name);
                ps.setString(2, password);
                ps.setString(3, language);
                ps.setString(4, admitted);
                ps.setBytes(5, picture);
                
                if(ps.executeUpdate() > 0){
                    JOptionPane.showMessageDialog(null, "New Organization Added!");
                }
                
            } catch (SQLException ex) {
                Logger.getLogger(Enterprise.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        }
        
        // update the date when operation == u
        if(operation == 'u'){
            try {
                ps = con.prepareStatement("UPDATE `OrganizationUser` SET `Name`= ?, `Password`= ?, `Language`= ?, `Admitted`= ?, `Picture`= ? WHERE `Name` = ?");
                              
                ps.setString(1, name);
                ps.setString(2, password);
                ps.setString(3, language);
                ps.setString(4, admitted);
                ps.setBytes(5, picture);

                if(ps.executeUpdate() > 0){
                    JOptionPane.showMessageDialog(null, "Organization data Updated!");
                }
                
            } catch (SQLException ex) {
                Logger.getLogger(Enterprise.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        }
        
        // d for delete
        if(operation == 'd'){
            
            int YesOrNo = JOptionPane.showConfirmDialog(null, "Are you sure to delete this data?","Delete Orgainization",JOptionPane.OK_CANCEL_OPTION,0);
            
            if(YesOrNo == JOptionPane.OK_OPTION)
            {
               try {
                ps = con.prepareStatement("DELETE FROM `OrganizationUser` WHERE `Name` = ?");
                ps.setString(1,name);
                if(ps.executeUpdate() > 0){
                    JOptionPane.showMessageDialog(null, "Organization Deleted");
                    }
                
                } catch (SQLException ex) {
                Logger.getLogger(Enterprise.class.getName()).log(Level.SEVERE, null, ex);
                } 
            }
            
            
        }
        
    }
    
    public void fillJtable(JTable table, String valueToSearch){
        
        Connection con = MyConnection.getConnection();
        PreparedStatement ps;
        
        try {
            
            ps = con.prepareStatement("SELECT * FROM `OrganizationUser` WHERE CONCAT(`Name`, `Password`,`Language`,`Admitted`,`Picture`)LIKE ?");
            ps.setString(1, "%"+valueToSearch+"%");
            ResultSet rs = ps.executeQuery();
            DefaultTableModel model = (DefaultTableModel)table.getModel();
            
            Object[] row;
            
            while(rs.next()){
                row = new Object[5];
                row[0] = rs.getString(1);
                row[1] = rs.getString(2);
                row[2] = rs.getString(3);
                row[3] = rs.getString(4);
                row[4] = rs.getBytes(5);

                model.addRow(row);
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(Enterprise.class.getName()).log(Level.SEVERE, null, ex);
        }                  
        
    }
    
    
}
