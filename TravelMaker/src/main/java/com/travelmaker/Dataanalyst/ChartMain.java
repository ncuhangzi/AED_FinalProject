/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.travelmaker.Dataanalyst;


import com.travelmaker.UI.*;
import com.teamdev.jxbrowser.browser.Browser;
import com.teamdev.jxbrowser.engine.Engine;
import com.teamdev.jxbrowser.engine.EngineOptions;
import com.teamdev.jxbrowser.engine.RenderingMode;
import static com.teamdev.jxbrowser.engine.RenderingMode.HARDWARE_ACCELERATED;
import com.teamdev.jxbrowser.view.swing.BrowserView;
import com.travelmaker.Organization.City;
import com.travelmaker.Organization.State;
import com.travlemaker.Attractions.Attraction;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;


/**
 *
 * @author hangzi
 */
public class ChartMain extends javax.swing.JFrame {
    


    /**
     * Creates new form LocationPicker Form
     */
    public ChartMain() {
        initComponents();
        this.setLocationRelativeTo(null);
        populateOrderChart();
        populateProfitChart();
    }
    
    public void populateOrderChart(){
        orderchart4.addLegend("Orders", new Color(245, 189, 135));
        orderchart4.addData(new ModelChart("January", new double[]{500}));
        orderchart4.addData(new ModelChart("February", new double[]{600}));
        orderchart4.addData(new ModelChart("March", new double[]{200}));
        orderchart4.addData(new ModelChart("April", new double[]{480}));
        orderchart4.addData(new ModelChart("May", new double[]{350}));
        orderchart4.addData(new ModelChart("June", new double[]{190}));
    
    }
    
    public void populateProfitChart(){
    
        profitchart.addLegend("Orders", new Color(245, 189, 135));
        profitchart.addData(new ModelChart("January", new double[]{500}));
        profitchart.addData(new ModelChart("February", new double[]{600}));
        profitchart.addData(new ModelChart("March", new double[]{200}));
        profitchart.addData(new ModelChart("April", new double[]{480}));
        profitchart.addData(new ModelChart("May", new double[]{350}));
        profitchart.addData(new ModelChart("June", new double[]{190}));
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        headerBar = new javax.swing.JPanel();
        hospitalinfoLabel = new javax.swing.JLabel();
        foldLabel = new javax.swing.JLabel();
        crossLabel = new javax.swing.JLabel();
        contentPanel = new javax.swing.JPanel();
        orderPanel4 = new javax.swing.JPanel();
        orderchart4 = new com.travelmaker.Dataanalyst.Chart();
        cbOrg = new javax.swing.JComboBox<>();
        lblOrg = new javax.swing.JLabel();
        lblTotalProfit = new javax.swing.JLabel();
        lblProfitAmount = new javax.swing.JLabel();
        profitPanel = new javax.swing.JPanel();
        profitchart = new com.travelmaker.Dataanalyst.Chart();
        btnSearch = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        headerBar.setBackground(new java.awt.Color(250, 115, 12));

        hospitalinfoLabel.setFont(new java.awt.Font("Hiragino Sans", 1, 24)); // NOI18N
        hospitalinfoLabel.setForeground(new java.awt.Color(255, 255, 255));
        hospitalinfoLabel.setText("Data Analyst");

        foldLabel.setFont(new java.awt.Font("Hiragino Sans", 1, 24)); // NOI18N
        foldLabel.setForeground(new java.awt.Color(255, 255, 255));
        foldLabel.setText("_");
        foldLabel.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        foldLabel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                foldLabelMouseClicked(evt);
            }
        });

        crossLabel.setFont(new java.awt.Font("Hiragino Sans", 1, 24)); // NOI18N
        crossLabel.setForeground(new java.awt.Color(255, 255, 255));
        crossLabel.setText("x");
        crossLabel.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        crossLabel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                crossLabelMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout headerBarLayout = new javax.swing.GroupLayout(headerBar);
        headerBar.setLayout(headerBarLayout);
        headerBarLayout.setHorizontalGroup(
            headerBarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(headerBarLayout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(hospitalinfoLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(foldLabel)
                .addGap(18, 18, 18)
                .addComponent(crossLabel)
                .addGap(18, 18, 18))
        );
        headerBarLayout.setVerticalGroup(
            headerBarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(headerBarLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(foldLabel)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, headerBarLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addGroup(headerBarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(hospitalinfoLabel, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(crossLabel, javax.swing.GroupLayout.Alignment.TRAILING)))
        );

        contentPanel.setBackground(new java.awt.Color(44, 62, 80));

        orderPanel4.setPreferredSize(new java.awt.Dimension(400, 400));

        javax.swing.GroupLayout orderPanel4Layout = new javax.swing.GroupLayout(orderPanel4);
        orderPanel4.setLayout(orderPanel4Layout);
        orderPanel4Layout.setHorizontalGroup(
            orderPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(orderchart4, javax.swing.GroupLayout.DEFAULT_SIZE, 477, Short.MAX_VALUE)
        );
        orderPanel4Layout.setVerticalGroup(
            orderPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(orderchart4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 318, Short.MAX_VALUE)
        );

        lblOrg.setFont(new java.awt.Font("Helvetica Neue", 0, 14)); // NOI18N
        lblOrg.setForeground(new java.awt.Color(255, 255, 255));
        lblOrg.setText("Organization:");

        lblTotalProfit.setFont(new java.awt.Font("Helvetica Neue", 0, 18)); // NOI18N
        lblTotalProfit.setForeground(new java.awt.Color(255, 255, 255));
        lblTotalProfit.setText("Total Profit:");

        lblProfitAmount.setFont(new java.awt.Font("Helvetica Neue", 0, 18)); // NOI18N
        lblProfitAmount.setForeground(new java.awt.Color(102, 255, 102));

        profitPanel.setPreferredSize(new java.awt.Dimension(400, 400));

        javax.swing.GroupLayout profitPanelLayout = new javax.swing.GroupLayout(profitPanel);
        profitPanel.setLayout(profitPanelLayout);
        profitPanelLayout.setHorizontalGroup(
            profitPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(profitchart, javax.swing.GroupLayout.DEFAULT_SIZE, 487, Short.MAX_VALUE)
        );
        profitPanelLayout.setVerticalGroup(
            profitPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(profitchart, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
        );

        btnSearch.setText("Search");
        btnSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSearchActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout contentPanelLayout = new javax.swing.GroupLayout(contentPanel);
        contentPanel.setLayout(contentPanelLayout);
        contentPanelLayout.setHorizontalGroup(
            contentPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(contentPanelLayout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(contentPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(contentPanelLayout.createSequentialGroup()
                        .addComponent(lblTotalProfit)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(lblProfitAmount, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(lblOrg)
                        .addGap(18, 18, 18)
                        .addComponent(cbOrg, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnSearch)
                        .addGap(24, 24, 24))
                    .addGroup(contentPanelLayout.createSequentialGroup()
                        .addGap(29, 29, 29)
                        .addComponent(orderPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, 477, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 26, Short.MAX_VALUE)
                        .addComponent(profitPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 487, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(35, 35, 35))))
        );
        contentPanelLayout.setVerticalGroup(
            contentPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(contentPanelLayout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addGroup(contentPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(contentPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(cbOrg, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(lblOrg)
                        .addComponent(lblTotalProfit)
                        .addComponent(btnSearch))
                    .addComponent(lblProfitAmount, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(94, 94, 94)
                .addGroup(contentPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(orderPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, 318, Short.MAX_VALUE)
                    .addComponent(profitPanel, javax.swing.GroupLayout.DEFAULT_SIZE, 318, Short.MAX_VALUE))
                .addContainerGap(67, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(headerBar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(contentPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(headerBar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(1, 1, 1)
                .addComponent(contentPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        setSize(new java.awt.Dimension(1072, 565));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void foldLabelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_foldLabelMouseClicked
        this.setState(JFrame.ICONIFIED);
    }//GEN-LAST:event_foldLabelMouseClicked

    private void crossLabelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_crossLabelMouseClicked
        this.dispose();
    }//GEN-LAST:event_crossLabelMouseClicked

    private void btnSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSearchActionPerformed

    }//GEN-LAST:event_btnSearchActionPerformed

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        orderchart4.start();
        profitchart.start();
    }//GEN-LAST:event_formWindowOpened

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
            java.util.logging.Logger.getLogger(ChartMain.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ChartMain.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ChartMain.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ChartMain.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
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
                new ChartMain().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnSearch;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JComboBox<String> cbOrg;
    private javax.swing.JPanel contentPanel;
    private javax.swing.JPanel contentPanel1;
    private javax.swing.JPanel contentPanel2;
    private javax.swing.JPanel contentPanel3;
    private javax.swing.JPanel contentPanel4;
    private javax.swing.JLabel crossLabel;
    private javax.swing.JLabel foldLabel;
    private javax.swing.JPanel headerBar;
    private javax.swing.JLabel hospitalinfoLabel;
    private javax.swing.JLabel lblOrg;
    private javax.swing.JLabel lblProfitAmount;
    private javax.swing.JLabel lblTotalProfit;
    private javax.swing.JPanel orderPanel;
    private javax.swing.JPanel orderPanel1;
    private javax.swing.JPanel orderPanel2;
    private javax.swing.JPanel orderPanel3;
    private javax.swing.JPanel orderPanel4;
    private com.travelmaker.Dataanalyst.Chart orderchart;
    private com.travelmaker.Dataanalyst.Chart orderchart1;
    private com.travelmaker.Dataanalyst.Chart orderchart2;
    private com.travelmaker.Dataanalyst.Chart orderchart3;
    private com.travelmaker.Dataanalyst.Chart orderchart4;
    private javax.swing.JPanel profitPanel;
    private com.travelmaker.Dataanalyst.Chart profitchart;
    // End of variables declaration//GEN-END:variables
}
