/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */

package com.travelmaker.System;

import Enterprise.*;
import LoginPage.HomeLogin;
import LoginPage.MyConnection;
import UserEnterprise.TravelInfo;
import UserEnterprise.UserManagement;
import com.travelmaker.UI.OrganizationManagerFrame;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author yufei
 */
public class SystemAdmin extends javax.swing.JFrame {

    /** Creates new form EnterpriseMainHome */
    
    EnterpriseAccount EA = new EnterpriseAccount();
    
    public SystemAdmin(){
        initComponents();
        this.setLocationRelativeTo(null);
    }
    
    public SystemAdmin(String username, String password) {
        initComponents();
        
        Connection con = MyConnection.getConnection();
        PreparedStatement ps;
        
        try {
                
                EA.txtName.setText(username);
                EA.txtPassword.setText(password);
                ps = con.prepareStatement("SELECT * FROM Enterpriseuser where username = '" + username + "' AND password = '" + password + "' ");
            
                ResultSet rs = ps.executeQuery();
                
                if(rs.next()){
                    
                    
//                    EnterpriseAccount.txtName.setText(rs.getString("username"));
//                    EnterpriseAccount.txtPassword.setText(rs.getString("password"));
                    EA.txtEname.setText(rs.getString("EnterpriseName"));
                    EA.txtPhone.setText(rs.getString("Phone"));
                    EA.txtID.setText(rs.getString("ID"));
                    EA.txtEmail.setText(rs.getString("Email"));
                    EA.txtLocation.setText(rs.getString("Location"));
                    EA.txtIntrod.setText(rs.getString("Introduction"));
                    
                    
                    this.dispose();
                }
                else{
                    JOptionPane.showMessageDialog(null, "You input wrong username!");
                }
            } 
            catch (SQLException ex) {
                Logger.getLogger(SystemAdmin.class.getName()).log(Level.SEVERE, null, ex);
            }
        
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        UpPanel = new javax.swing.JPanel();
        lblTitle = new javax.swing.JLabel();
        lblIcon = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        lblWelcome = new javax.swing.JLabel();
        MidPanel = new javax.swing.JPanel();
        btnInfo = new javax.swing.JButton();
        btnLogout = new javax.swing.JButton();
        btnInfo1 = new javax.swing.JButton();
        btnInfo2 = new javax.swing.JButton();
        BotPanel = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        UpPanel.setBackground(new java.awt.Color(250, 115, 12));

        lblTitle.setBackground(new java.awt.Color(0, 102, 204));
        lblTitle.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        lblTitle.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblTitle.setText("System Admin");

        lblIcon.setSize(new java.awt.Dimension(40, 40));

        lblWelcome.setFont(new java.awt.Font("Times New Roman", 0, 24)); // NOI18N
        lblWelcome.setText(" Welcome <#####>");

        javax.swing.GroupLayout UpPanelLayout = new javax.swing.GroupLayout(UpPanel);
        UpPanel.setLayout(UpPanelLayout);
        UpPanelLayout.setHorizontalGroup(
            UpPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(UpPanelLayout.createSequentialGroup()
                .addGroup(UpPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(UpPanelLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(lblWelcome, javax.swing.GroupLayout.PREFERRED_SIZE, 278, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(55, 55, 55)
                        .addComponent(lblTitle, javax.swing.GroupLayout.PREFERRED_SIZE, 356, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, UpPanelLayout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel2)
                        .addGap(336, 336, 336)))
                .addComponent(lblIcon)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        UpPanelLayout.setVerticalGroup(
            UpPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(UpPanelLayout.createSequentialGroup()
                .addGroup(UpPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(UpPanelLayout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(lblIcon, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(UpPanelLayout.createSequentialGroup()
                        .addGroup(UpPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(lblWelcome, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblTitle, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );

        MidPanel.setBackground(new java.awt.Color(51, 51, 51));

        btnInfo.setFont(new java.awt.Font("Helvetica Neue", 1, 18)); // NOI18N
        btnInfo.setText("Organization Management");
        btnInfo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnInfoActionPerformed(evt);
            }
        });

        btnLogout.setFont(new java.awt.Font("Helvetica Neue", 1, 18)); // NOI18N
        btnLogout.setText("Logout");
        btnLogout.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnLogoutMouseClicked(evt);
            }
        });
        btnLogout.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLogoutActionPerformed(evt);
            }
        });

        btnInfo1.setFont(new java.awt.Font("Helvetica Neue", 1, 18)); // NOI18N
        btnInfo1.setText("User Managemnet");
        btnInfo1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnInfo1ActionPerformed(evt);
            }
        });

        btnInfo2.setFont(new java.awt.Font("Helvetica Neue", 1, 18)); // NOI18N
        btnInfo2.setText("Enterprise Management");
        btnInfo2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnInfo2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout MidPanelLayout = new javax.swing.GroupLayout(MidPanel);
        MidPanel.setLayout(MidPanelLayout);
        MidPanelLayout.setHorizontalGroup(
            MidPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(MidPanelLayout.createSequentialGroup()
                .addGap(90, 90, 90)
                .addGroup(MidPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnLogout, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(MidPanelLayout.createSequentialGroup()
                        .addComponent(btnInfo1, javax.swing.GroupLayout.PREFERRED_SIZE, 211, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(12, 12, 12)
                        .addComponent(btnInfo)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnInfo2)))
                .addContainerGap(46, Short.MAX_VALUE))
        );
        MidPanelLayout.setVerticalGroup(
            MidPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(MidPanelLayout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addGroup(MidPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnInfo, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnInfo2, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnInfo1, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(btnLogout, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(56, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout BotPanelLayout = new javax.swing.GroupLayout(BotPanel);
        BotPanel.setLayout(BotPanelLayout);
        BotPanelLayout.setHorizontalGroup(
            BotPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        BotPanelLayout.setVerticalGroup(
            BotPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(UpPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(MidPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(BotPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addComponent(UpPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(1, 1, 1)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(MidPanel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(189, 189, 189)
                        .addComponent(BotPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnInfo1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnInfo1ActionPerformed
        // TODO add your handling code here:       
        UserManagement UM = new UserManagement();
        UM.setVisible(true);
        UM.pack();
        UM.setLocationRelativeTo(null);      
    }//GEN-LAST:event_btnInfo1ActionPerformed

    private void btnLogoutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLogoutActionPerformed
        HomeLogin HM = new HomeLogin();
        HM.setVisible(true);
        HM.pack();
        HM.setLocationRelativeTo(null);
    }//GEN-LAST:event_btnLogoutActionPerformed

    private void btnLogoutMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnLogoutMouseClicked
        // TODO add your handling code here:
        this.dispose();
    }//GEN-LAST:event_btnLogoutMouseClicked

    private void btnInfoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnInfoActionPerformed
        // TODO add your handling code here:
        OrganizationManagerFrame OMF= new OrganizationManagerFrame();
        OMF.setVisible(true);
        OMF.pack();
        OMF.setLocationRelativeTo(null);
    }//GEN-LAST:event_btnInfoActionPerformed

    private void btnInfo2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnInfo2ActionPerformed
        EnterpriseManagerHome EMH = new EnterpriseManagerHome();
        EMH.setVisible(true);
        EMH.pack();
        EMH.setLocationRelativeTo(null);
    }//GEN-LAST:event_btnInfo2ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(SystemAdmin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(SystemAdmin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(SystemAdmin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(SystemAdmin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new SystemAdmin().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel BotPanel;
    private javax.swing.JPanel MidPanel;
    private javax.swing.JPanel UpPanel;
    private javax.swing.JButton btnInfo;
    private javax.swing.JButton btnInfo1;
    private javax.swing.JButton btnInfo2;
    private javax.swing.JButton btnLogout;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel lblIcon;
    private javax.swing.JLabel lblTitle;
    public static javax.swing.JLabel lblWelcome;
    // End of variables declaration//GEN-END:variables

}
