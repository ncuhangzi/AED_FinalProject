/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.travelmaker.System;

import Enterprise.*;
import UserEnterprise.*;
import static Enterprise.CreateTravel.tblTravel;
import Enterprise.Enterprise;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
//import static Enterprise.EnterpriseInfo.tblEnterprise;
import javax.swing.table.DefaultTableModel;
import LoginPage.MyConnection;
import static UserEnterprise.UserManagement.tblUser;
import java.awt.Color;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author yufei
 */
public class SystemAdminManagement extends javax.swing.JFrame {

    /**
     * Creates new form TravelInfo
     */
    
    
    DefaultTableModel model;
    Enterprise etp = new Enterprise();//要改
    long curId;
    
    public SystemAdminManagement() {
        initComponents();
        this.setLocationRelativeTo(null);
        etp.fillJtable(tblSystem, "");
        model = (DefaultTableModel)tblSystem.getModel();
        tblSystem.setRowHeight(40);
        tblSystem.setShowGrid(true);
        tblSystem.setGridColor(Color.BLUE);
        tblSystem.setSelectionBackground(Color.BLACK);
//        admin.fillInfoJtable(tblSystem, "");
//        model = (DefaultTableModel)tblSystem.getModel();
    }
    public boolean verifText(){
        
        if(txtName.getText().equals("") || txtPassword.getText().equals("") )
        {
            JOptionPane.showMessageDialog(null, "One Or More Empty Field!");
            return false;
        }
        // choose a date higher then the current date
        // || endDateChooser.getDate().compareTo(startDateChooser.getDate()) == 1
        else{
            return true;
        }
        
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        UpPanel = new javax.swing.JPanel();
        lblTitle2 = new javax.swing.JLabel();
        lblIcon2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        btnBack = new javax.swing.JButton();
        MidPanel = new javax.swing.JPanel();
        BotPanel = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblSystem = new javax.swing.JTable();
        btnCreate = new javax.swing.JButton();
        txtName = new javax.swing.JTextField();
        lblSearch = new javax.swing.JLabel();
        txtPassword = new javax.swing.JTextField();
        lblSearch1 = new javax.swing.JLabel();
        btnUpdate = new javax.swing.JButton();
        btnDelete = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        UpPanel.setBackground(new java.awt.Color(250, 115, 12));

        lblTitle2.setBackground(new java.awt.Color(0, 102, 204));
        lblTitle2.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        lblTitle2.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblTitle2.setText("System Admin Account Management");

        lblIcon2.setSize(new java.awt.Dimension(40, 40));

        btnBack.setBackground(new java.awt.Color(250, 115, 12));
        btnBack.setText("Back");
        btnBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBackActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout UpPanelLayout = new javax.swing.GroupLayout(UpPanel);
        UpPanel.setLayout(UpPanelLayout);
        UpPanelLayout.setHorizontalGroup(
            UpPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(UpPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(UpPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(UpPanelLayout.createSequentialGroup()
                        .addComponent(btnBack, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(571, 571, 571))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, UpPanelLayout.createSequentialGroup()
                        .addComponent(lblTitle2, javax.swing.GroupLayout.PREFERRED_SIZE, 397, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(32, 32, 32)))
                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lblIcon2)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        UpPanelLayout.setVerticalGroup(
            UpPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(UpPanelLayout.createSequentialGroup()
                .addGroup(UpPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(UpPanelLayout.createSequentialGroup()
                        .addGap(64, 64, 64)
                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, UpPanelLayout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(UpPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblIcon2, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(UpPanelLayout.createSequentialGroup()
                                .addComponent(btnBack, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(3, 3, 3)
                                .addComponent(lblTitle2, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap())
        );

        MidPanel.setBackground(new java.awt.Color(0, 0, 0));

        javax.swing.GroupLayout MidPanelLayout = new javax.swing.GroupLayout(MidPanel);
        MidPanel.setLayout(MidPanelLayout);
        MidPanelLayout.setHorizontalGroup(
            MidPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        MidPanelLayout.setVerticalGroup(
            MidPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 79, Short.MAX_VALUE)
        );

        BotPanel.setBackground(new java.awt.Color(0, 0, 0));

        tblSystem.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Name", "Password"
            }
        ));
        tblSystem.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblSystemMouseClicked(evt);
            }
        });
        tblSystem.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                tblSystemKeyReleased(evt);
            }
        });
        jScrollPane1.setViewportView(tblSystem);

        btnCreate.setText("Create");
        btnCreate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCreateActionPerformed(evt);
            }
        });

        txtName.setFont(new java.awt.Font("Helvetica Neue", 1, 18)); // NOI18N

        lblSearch.setFont(new java.awt.Font("Helvetica Neue", 1, 18)); // NOI18N
        lblSearch.setForeground(new java.awt.Color(255, 255, 255));
        lblSearch.setText("Name :");

        txtPassword.setFont(new java.awt.Font("Helvetica Neue", 1, 18)); // NOI18N

        lblSearch1.setFont(new java.awt.Font("Helvetica Neue", 1, 18)); // NOI18N
        lblSearch1.setForeground(new java.awt.Color(255, 255, 255));
        lblSearch1.setText("Password:");

        btnUpdate.setText("Update");
        btnUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdateActionPerformed(evt);
            }
        });

        btnDelete.setText("Delete");
        btnDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout BotPanelLayout = new javax.swing.GroupLayout(BotPanel);
        BotPanel.setLayout(BotPanelLayout);
        BotPanelLayout.setHorizontalGroup(
            BotPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, BotPanelLayout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(BotPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(BotPanelLayout.createSequentialGroup()
                        .addGroup(BotPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(lblSearch1)
                            .addComponent(lblSearch))
                        .addGap(18, 18, 18)
                        .addGroup(BotPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtName, javax.swing.GroupLayout.PREFERRED_SIZE, 219, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtPassword, javax.swing.GroupLayout.PREFERRED_SIZE, 219, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(BotPanelLayout.createSequentialGroup()
                        .addComponent(btnDelete, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnUpdate, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnCreate, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(49, 49, 49)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 442, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        BotPanelLayout.setVerticalGroup(
            BotPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, BotPanelLayout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addGroup(BotPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtName, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblSearch))
                .addGap(31, 31, 31)
                .addGroup(BotPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblSearch1, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtPassword, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(BotPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnCreate, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnUpdate, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnDelete, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(142, 142, 142))
            .addGroup(BotPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 414, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(40, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(UpPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(BotPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(MidPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(UpPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(1, 1, 1)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(77, 77, 77)
                        .addComponent(BotPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(MidPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBackActionPerformed
        // TODO add your handling code here:
        this.dispose();
    }//GEN-LAST:event_btnBackActionPerformed

    int rowIndex;
    private void btnCreateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCreateActionPerformed
        
        String Name = txtName.getText();
        String Password = txtPassword.getText();
        
        if(verifText()){
            //need to change o the enterprise user table
            //Enterprise ep = new Enterprise();
            etp.AddUpdateDeleteEnterprise('i', Name, Password);

            tblSystem.setModel(new DefaultTableModel(null,new Object[]{"ID","Name","Password"}));
            etp.fillJtable(tblSystem, "");
        }
    }//GEN-LAST:event_btnCreateActionPerformed

    private void tblSystemMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblSystemMouseClicked
        rowIndex = tblSystem.getSelectedRow();

        long ID = Long.parseLong(model.getValueAt(rowIndex, 0).toString());
        String Name = model.getValueAt(rowIndex, 1).toString();
        String Password = model.getValueAt(rowIndex, 2).toString();
        txtName.setText(Name);
        txtPassword.setText(Password);
        this.curId = ID;


        
    }//GEN-LAST:event_tblSystemMouseClicked

    private void tblSystemKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tblSystemKeyReleased
        // TODO add your handling code here
    }//GEN-LAST:event_tblSystemKeyReleased

    private void btnUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateActionPerformed
        String Enter_Name = txtName.getText();
        String Enter_Password = txtPassword.getText();
        
        if(verifText()){
            //Enterprise ep = new Enterprise();
            etp.AddUpdateDeleteEnterprise('u', curId,Enter_Name, Enter_Password);

            tblSystem.setModel(new DefaultTableModel(null,new Object[]{"ID","Name","Password"}));
            etp.fillJtable(tblSystem, "");
        }
    }//GEN-LAST:event_btnUpdateActionPerformed

    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteActionPerformed
        if(txtName.getText().equals(""))
        {
           JOptionPane.showMessageDialog(null, "No System Admin Selected");
        }
        
        long Enter_ID = curId;
        //Enterprise etp = new Enterprise();
        etp.AddUpdateDeleteEnterprise('d', Enter_ID, null, null);
        tblSystem.setModel(new DefaultTableModel(null,new Object[]{"ID","Name","Password"}));
        etp.fillJtable(tblSystem, "");
        
        curId=0;
        txtName.setText("");
        txtPassword.setText("");
    }//GEN-LAST:event_btnDeleteActionPerformed

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
            java.util.logging.Logger.getLogger(SystemAdminManagement.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(SystemAdminManagement.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(SystemAdminManagement.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(SystemAdminManagement.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new SystemAdminManagement().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel BotPanel;
    private javax.swing.JPanel MidPanel;
    private javax.swing.JPanel UpPanel;
    private javax.swing.JButton btnBack;
    private javax.swing.JButton btnCreate;
    private javax.swing.JButton btnDelete;
    private javax.swing.JButton btnUpdate;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblIcon2;
    private javax.swing.JLabel lblSearch;
    private javax.swing.JLabel lblSearch1;
    private javax.swing.JLabel lblTitle2;
    public static javax.swing.JTable tblSystem;
    private javax.swing.JTextField txtName;
    private javax.swing.JTextField txtPassword;
    // End of variables declaration//GEN-END:variables
}
