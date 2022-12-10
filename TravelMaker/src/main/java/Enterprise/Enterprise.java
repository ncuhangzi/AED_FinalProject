/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Enterprise;

import LoginPage.MyConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author yufei
 */
public class Enterprise {
    
    // 图片的格式需要确定  byte[] picture,
    public void AddUpdateDeleteEnterprise(char operation, long ID, String name, String city,String state, int zipcode, String location, String sdate, String edate, String type, double price, byte[] picture, String detail){
        
        Connection con = MyConnection.getConnection();
        PreparedStatement ps;
        
        // i for insert
        if(operation == 'i'){
            try {
                ps = con.prepareStatement("INSERT INTO EnterpriseInfo(ID, Name, City, State, Zipcode, Location, StartDate, EndDate, Type, Price, Picture, Detail) VALUES (?,?,?,?,?,?,?,?,?,?,?,?)");
                ps.setLong(1, ID);
                ps.setString(2, name);
                ps.setString(3, city);
                ps.setString(4, state);
                ps.setInt(5, zipcode);
                ps.setString(6, location);
                ps.setString(7,  sdate);
                ps.setString(8, edate);
                ps.setString(9, type);
                ps.setDouble(10, price);
                ps.setBytes(11, picture);
                ps.setString(12, detail);
                
                if(ps.executeUpdate() > 0){
                    JOptionPane.showMessageDialog(null, "New Enterprise Added!");
                }
                
            } catch (SQLException ex) {
                Logger.getLogger(Enterprise.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        }
        
        // update the date when operation == u
        if(operation == 'u'){
            try {
                ps = con.prepareStatement("UPDATE `EnterpriseInfo` SET `Name`= ?, `City`= ?, `State`= ?, `Zipcode`= ?, `Location`= ?, `StartDate`= ?, `EndDate`= ?, `Type`= ?, `Price`= ?, `Picture`= ?, `Detail`= ? WHERE `ID` = ?");
                
                
                ps.setString(1, name);
                ps.setString(2, city);
                ps.setString(3, state);
                ps.setInt(4, zipcode);
                ps.setString(5, location);
                ps.setString(6,  sdate);
                ps.setString(7, edate);
                ps.setString(8, type);
                ps.setDouble(9, price);
                ps.setBytes(10, picture);
                ps.setString(11, detail);
                 ps.setLong(12, ID); 

                if(ps.executeUpdate() > 0){
                    JOptionPane.showMessageDialog(null, "Enterprise data Updated!");
                }
                
            } catch (SQLException ex) {
                Logger.getLogger(Enterprise.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        }
        
        // d for delete
        if(operation == 'd'){
            
            int YesOrNo = JOptionPane.showConfirmDialog(null, "Are you sure to delete this data?","Delete Enterprise",JOptionPane.OK_CANCEL_OPTION,0);
            
            if(YesOrNo == JOptionPane.OK_OPTION)
            {
               try {
                ps = con.prepareStatement("DELETE FROM `EnterpriseInfo` WHERE `id` = ?");
                ps.setLong(1,ID);
                if(ps.executeUpdate() > 0){
                    JOptionPane.showMessageDialog(null, "Enterprise Deleted");
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
            
            ps = con.prepareStatement("SELECT * FROM `EnterpriseInfo` WHERE CONCAT(`Name`, `City`,`State`,`StartDate`,`Type`)LIKE ?");
            ps.setString(1, "%"+valueToSearch+"%");
            ResultSet rs = ps.executeQuery();
            DefaultTableModel model = (DefaultTableModel)table.getModel();
            
            Object[] row;
            
            while(rs.next()){
                row = new Object[12];
                row[0] = rs.getLong(1);
                row[1] = rs.getString(2);
                row[2] = rs.getString(3);
                row[3] = rs.getString(4);
                row[4] = rs.getInt(5);
                row[5] = rs.getString(6);
                row[6] = rs.getDate(7);
                row[7] = rs.getDate(8);
                row[8] = rs.getString(9);
                row[9] = rs.getDouble(10);
//                row[10] = rs.getBlob(11);
             
                row[10] = new ImageIcon(rs.getBytes(11)); 
                row[11] = rs.getString(12);
                
                model.addRow(row);
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(Enterprise.class.getName()).log(Level.SEVERE, null, ex);
        }
        
            
            
        
    }
    
}
