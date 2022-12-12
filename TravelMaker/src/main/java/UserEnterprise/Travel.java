/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package UserEnterprise;

import Enterprise.Enterprise;
import LoginPage.MyConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.*;
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
 * @author yufei
 */
public class Travel {
    
    public void AddUpdateDeleteEnterprise(char operation, long ID, String Oname, String city, String type, String attraction, String location, double cost, double price, String travelname, String sdate, String edate, String detail, String Ename){
        
        Connection con = MyConnection.getConnection();
        PreparedStatement ps;
        
        // i for insert
        if(operation == 'i'){
            try {
                ps = con.prepareStatement("INSERT INTO TravelInfo(TID, Torganization, Tcity, Ttype, Tattraction, Tlocation, Tcost, Tprice, Travelname, Tstartdate, Tenddate, Tdetail, Tenterprise) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?)");
                ps.setLong(1, ID);
                ps.setString(2, Oname);
                ps.setString(3, city);
                ps.setString(4, type);
                ps.setString(5, attraction);
                ps.setString(6, location);
                ps.setDouble(7, cost);
                ps.setDouble(8, price);
                ps.setString(9, travelname);
                ps.setString(10,  sdate);
                ps.setString(11, edate);
                ps.setString(12, detail);
                ps.setString(13, Ename);
                
                if(ps.executeUpdate() > 0){
                    JOptionPane.showMessageDialog(null, "New Enterprise Added!");
                }
                
            } catch (SQLException ex) {
                Logger.getLogger(Travel.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        }
        
        
        // update the date when operation == u
        if(operation == 'u'){
            try {
                ps = con.prepareStatement("UPDATE `TravelInfo` SET `Torganization`= ?, `Tcity`= ?, `Ttype`= ?, `Tattraction`= ?, `Tlocation`= ?, `Tcost`= ?, `Tprice`= ?, `Travelname`= ?, `Tstartdate`= ?, `Tenddate`= ?, `Tdetail`= ?, `Tenterprise`= ? WHERE `TID` = ?");
                
                ps.setString(1, Oname);
                ps.setString(2, city);
                ps.setString(3, type);
                ps.setString(4, attraction);
                ps.setString(5, location);
                ps.setDouble(6, cost);
                ps.setDouble(7, price);
                ps.setString(8, travelname);
                ps.setString(9,  sdate);
                ps.setString(10, edate);
                ps.setString(11, detail);
                ps.setString(12, Ename);
                ps.setLong(13, ID); 

                if(ps.executeUpdate() > 0){
                    JOptionPane.showMessageDialog(null, "Travel data Updated!");
                }
                
            } catch (SQLException ex) {
                Logger.getLogger(Travel.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        }
        
        // d for delete
        if(operation == 'd'){
            
            int YesOrNo = JOptionPane.showConfirmDialog(null, "Are you sure to delete this data?","Delete Travel",JOptionPane.OK_CANCEL_OPTION,0);
            
            if(YesOrNo == JOptionPane.OK_OPTION)
            {
               try {
                ps = con.prepareStatement("DELETE FROM `TravelInfo` WHERE `TID` = ?");
                ps.setLong(1,ID);
                if(ps.executeUpdate() > 0){
                    JOptionPane.showMessageDialog(null, "Travel Deleted");
                    }
                
                } catch (SQLException ex) {
                Logger.getLogger(Travel.class.getName()).log(Level.SEVERE, null, ex);
                } 
            }
            
            
        }
        
        
    }
    
    public void fillInfoJtable(JTable table, String valueToSearch){
        
        Connection con = MyConnection.getConnection();
        PreparedStatement ps;
        
        try {
            
            ps = con.prepareStatement("SELECT * FROM `TravelInfo` WHERE CONCAT(`Torganization`, `Tcity`,`Ttype`,`Tstartdate`, `Tattraction`, `Tenddate`, `Tenterprise`)LIKE ?");
            ps.setString(1, "%"+valueToSearch+"%");
            ResultSet rs = ps.executeQuery();
            DefaultTableModel model = (DefaultTableModel)table.getModel();
            
            Object[] row;
            
            while(rs.next()){
                
                row = new Object[13];
                row[0] = rs.getLong(1);
                row[1] = rs.getString(2);
                row[2] = rs.getString(3);
                row[3] = rs.getString(4);
                row[4] = rs.getString(5);
                row[5] = rs.getString(6);
                row[6] = rs.getDouble(7);
                row[7] = rs.getDouble(8);
                row[8] = rs.getString(9);
                row[9] = rs.getDate(10);
                row[10] = rs.getDate(11);
                row[11] = rs.getString(12);
                row[12] = rs.getString(13);

                
                model.addRow(row);
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(Travel.class.getName()).log(Level.SEVERE, null, ex);
        }      
        
    }
    
    
    // Like page fill
    public void fillLikeJtable(JTable table, String valueToSearch){
        
        Connection con = MyConnection.getConnection();
        PreparedStatement ps;
        
        try {
            
            ps = con.prepareStatement("SELECT * FROM `TravelLike` WHERE CONCAT(`Torganization`, `Tcity`,`Ttype`,`Tstartdate`, `Tattraction`, `Tenddate`, `Tprice`, `Tenterprise`)LIKE ?");
            ps.setString(1, "%"+valueToSearch+"%");
            ResultSet rs = ps.executeQuery();
            DefaultTableModel model = (DefaultTableModel)table.getModel();
            
            Object[] row;
            
            while(rs.next()){
                
                row = new Object[13];
                row[0] = rs.getLong(1);
                row[1] = rs.getString(2);
                row[2] = rs.getString(3);
                row[3] = rs.getString(4);
                row[4] = rs.getString(5);
                row[5] = rs.getString(6);
                row[6] = rs.getDouble(7);
                row[7] = rs.getDouble(8);
                row[8] = rs.getString(9);
                row[9] = rs.getDate(10);
                row[10] = rs.getDate(11);
                row[11] = rs.getString(12);
                row[12] = rs.getString(13);

                
                model.addRow(row);
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(Travel.class.getName()).log(Level.SEVERE, null, ex);
        }      
        
    }
    public void fillOrderJtable(JTable table, String valueToSearch){
        
        Connection con = MyConnection.getConnection();
        PreparedStatement ps;
        
        try {
            
            ps = con.prepareStatement("SELECT * FROM `TravelOrder` WHERE CONCAT(`Torganization`, `Tcity`,`Ttype`,`Tstartdate`, `Tattraction`, `Tenddate`, `Tprice`, `Tenterprise`)LIKE ?");
            ps.setString(1, "%"+valueToSearch+"%");
            ResultSet rs = ps.executeQuery();
            DefaultTableModel model = (DefaultTableModel)table.getModel();
            
            Object[] row;
            
            while(rs.next()){
                
                row = new Object[13];
                row[0] = rs.getLong(1);
                row[1] = rs.getString(2);
                row[2] = rs.getString(3);
                row[3] = rs.getString(4);
                row[4] = rs.getString(5);
                row[5] = rs.getString(6);
                row[6] = rs.getDouble(7);
                row[7] = rs.getDouble(8);
                row[8] = rs.getString(9);
                row[9] = rs.getDate(10);
                row[10] = rs.getDate(11);
                row[11] = rs.getString(12);
                row[12] = rs.getString(13);



               
                model.addRow(row);
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(Travel.class.getName()).log(Level.SEVERE, null, ex);
        }      
        
    }
    
    
//    public ArrayList<Travel> getData(int catID){
//        
//        ArrayList<Travel> list = new ArrayList<Travel>();
//        Connection con = MyConnection.getConnection();
//        Statement st;
//        ResultSet rs;
//   
//        try {
//            st = con.createStatement();
//            rs = st.executeQuery("SELECT `ID_PRO`, `PRO_NAME`, `QTE_IN_STOCK`, `PRICE`, `ID_CAT` FROM `products` WHERE `ID_CAT` = "+ catID);
//   
//            Product p;
//            while(rs.next()){
//                p = new Product(
//                rs.getString("ID_PRO"),
//                rs.getString("PRO_NAME"),
//                rs.getInt("QTE_IN_STOCK"),
//                rs.getString("PRICE"),
//                rs.getInt("ID_CAT")
//                );
//                list.add(p);
//            }
//   
//        } catch (SQLException ex) {
//            Logger.getLogger(MyQuery.class.getName()).log(Level.SEVERE, null, ex);
//        }
//        return list;
//    }
    
//    public String getOrganization(String Organization){
//        
//        
//        Connection con = MyConnection.getConnection();
//        PreparedStatement ps;
//        try {
//            ps = con.prepareStatement("SELECT `Oname` FROM `OrganizationInfo` ");
//            ps.setString(1, Organization);
//            
//            ResultSet rs = ps.executeQuery();
// 
//            
//            if(rs.next()){
//              courseId = rs.getInt("Id");
//            }
//            
//        } catch (SQLException ex) {
//            Logger.getLogger(Travel.class.getName()).log(Level.SEVERE, null, ex);
//        }
//        
//        return Organization;
//        
//    }
    
}
