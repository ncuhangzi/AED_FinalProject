/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.travelmaker.UI;

import Enterprise.Enterprise;
import static Enterprise.EnterpriseInfo.tblEnterprise;
import com.teamdev.jxbrowser.browser.Browser;
import com.teamdev.jxbrowser.engine.Engine;
import com.teamdev.jxbrowser.engine.EngineOptions;
import static com.teamdev.jxbrowser.engine.RenderingMode.HARDWARE_ACCELERATED;
import com.teamdev.jxbrowser.frame.Frame;
import com.teamdev.jxbrowser.view.swing.BrowserView;
import com.travelmaker.Organization.City;
import com.travelmaker.Organization.State;
import com.travelmaker.Organization.StateCatalog;
import com.travlemaker.Attractions.Attraction;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Optional;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.RowFilter;
import javax.swing.SwingUtilities;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;

/**
 *
 * @author hangzi
 */
public class OrganizationManagerFrame extends javax.swing.JFrame {
    
    private City city;
    private State state;
    private StateCatalog stateList;
    String stateImagepath;
    String cityImagePath;
    String attractionImagePath;
    byte[] picture = null;
    String selectLocation;
    /**
     * Creates new form MainJFrame
     */
    public OrganizationManagerFrame(){
        initComponents();    
        txtLocation.setEditable(false); //should move to component initialize method later
        this.setLocationRelativeTo(null);
        this.state = new State("Boston","12345");
        roleSetting();
    }

    public OrganizationManagerFrame(State state, StateCatalog stateList) {
        initComponents();
        roleSetting();
        this.state = state;
        this.stateList = stateList;
        this.setLocationRelativeTo(null);
        usernameLabel.setText(state.getName()+" Administrator");
        populateAttractionTbl();
        populateAccountTable();
    }
    
    public char[] randomIdGenerator(int len){
        String nums = "1234567890";
        Random rand = new Random();
        char[] idarray = new char[len];
        for (int a=0; a<idarray.length; a++){
            idarray[a] = nums.charAt(rand.nextInt(nums.length()));
        }
        return idarray;
    }
    
    public void roleSetting(){
        String role = "State Manager";
        txtMayor.setEditable(false);
        if(role.equals("City Manager")){
            jTabbedPane.setEnabledAt(1, false);      
        }else if (role.equals("State Manager")){

        }

    
    }
    
    private void populateAttractionTbl() {
       
        DefaultTableModel model = (DefaultTableModel) tblAttraction.getModel();
        model.setRowCount(0);
        
        TableRowSorter<DefaultTableModel> trs = new TableRowSorter<>(model);
        tblAttraction.setRowSorter(trs);
        
        for(City city: state.getCityList()){
            for (Attraction attraction: city.getAttractionlist()){
                Object[] row = new Object[6];
                row[0] = attraction; 
                row[1] = attraction.getName();
                row[2] = attraction.getType();
                row[3] = city;
                row[4] = attraction.getCost();
                row[5] = attraction.getLocation();
            
                model.addRow(row);
            }
                              
        }  
    }
    
    private void populateAccountTable() {
       
        DefaultTableModel model = (DefaultTableModel) accountTbl.getModel();
        model.setRowCount(0);
        
        TableRowSorter<DefaultTableModel> trs = new TableRowSorter<>(model);
        accountTbl.setRowSorter(trs);
        cbCity.removeAllItems();
        for(City city: state.getCityList()){
            Object[] row = new Object[7];
            row[0] = city; 
            row[1] = city.getPassword();
            row[2] = city.getMayor();
            row[3] = city.getLevel();
            row[4] = city.getZipCode();
            row[5] = city.getPopulation();
            row[6] = city.getLocation();
            
            model.addRow(row);
            cbCity.addItem(city.toString());
            
                                          
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

        buttonGroup1 = new javax.swing.ButtonGroup();
        buttonGroup2 = new javax.swing.ButtonGroup();
        headerBar = new javax.swing.JPanel();
        registerLabel = new javax.swing.JLabel();
        foldLabel = new javax.swing.JLabel();
        crossLabel = new javax.swing.JLabel();
        contentPanel = new javax.swing.JPanel();
        logoutBtn = new javax.swing.JButton();
        welcomeLabel = new javax.swing.JLabel();
        usernameLabel = new javax.swing.JLabel();
        jTabbedPane = new javax.swing.JTabbedPane();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblAttraction = new javax.swing.JTable();
        lblType = new javax.swing.JLabel();
        lblAttractionId = new javax.swing.JLabel();
        lblPrice = new javax.swing.JLabel();
        lblAttPhoto = new javax.swing.JLabel();
        createBtn = new javax.swing.JButton();
        updateBtn = new javax.swing.JButton();
        deleteBtn = new javax.swing.JButton();
        txtName = new javax.swing.JTextField();
        txtPrice = new javax.swing.JTextField();
        lblAttractionName = new javax.swing.JLabel();
        cbType = new javax.swing.JComboBox<>();
        btnAttractionBrowse = new javax.swing.JButton();
        lblAttractionLoc = new javax.swing.JLabel();
        lblAtLocation = new javax.swing.JLabel();
        btnAttractionLocation = new javax.swing.JButton();
        lblAttractionImage = new javax.swing.JLabel();
        lblCity = new javax.swing.JLabel();
        cbCity = new javax.swing.JComboBox<>();
        jPanel4 = new javax.swing.JPanel();
        jScrollPane4 = new javax.swing.JScrollPane();
        accountTbl = new javax.swing.JTable();
        lblCityName = new javax.swing.JLabel();
        txtCityName = new javax.swing.JTextField();
        lblLevel = new javax.swing.JLabel();
        lblPhoto = new javax.swing.JLabel();
        lblZip = new javax.swing.JLabel();
        lblPassword = new javax.swing.JLabel();
        txtPassword = new javax.swing.JTextField();
        txtPopulation = new javax.swing.JTextField();
        lblPopulation = new javax.swing.JLabel();
        cbLevel = new javax.swing.JComboBox<>();
        accCreateBtn = new javax.swing.JButton();
        accUpdateBtn = new javax.swing.JButton();
        accDeleteBtn = new javax.swing.JButton();
        txtMayor = new javax.swing.JTextField();
        lblMayor = new javax.swing.JLabel();
        txtLocation = new javax.swing.JTextField();
        lblLocation = new javax.swing.JLabel();
        txtZIP = new javax.swing.JTextField();
        btnCityBrowse = new javax.swing.JButton();
        lblCityImage = new javax.swing.JLabel();
        btnChooseLocation = new javax.swing.JButton();
        jPanel5 = new javax.swing.JPanel();
        jScrollPane5 = new javax.swing.JScrollPane();
        accountTbl1 = new javax.swing.JTable();
        lblCityName1 = new javax.swing.JLabel();
        txtCityName1 = new javax.swing.JTextField();
        lblPassword1 = new javax.swing.JLabel();
        txtPassword1 = new javax.swing.JTextField();
        accCreateBtn1 = new javax.swing.JButton();
        accUpdateBtn1 = new javax.swing.JButton();
        accDeleteBtn1 = new javax.swing.JButton();
        cbLang1 = new javax.swing.JComboBox<>();
        lblLanguage1 = new javax.swing.JLabel();
        lblAdmit1 = new javax.swing.JLabel();
        txtAdmit1 = new javax.swing.JTextField();
        lblImage1 = new javax.swing.JLabel();
        btnStateBrowse1 = new javax.swing.JButton();
        lblAdmit2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        headerBar.setBackground(new java.awt.Color(250, 115, 12));

        registerLabel.setFont(new java.awt.Font("Hiragino Sans", 1, 24)); // NOI18N
        registerLabel.setForeground(new java.awt.Color(255, 255, 255));
        registerLabel.setText("Organization Management");

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
                .addComponent(registerLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 378, javax.swing.GroupLayout.PREFERRED_SIZE)
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
                    .addComponent(registerLabel, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(crossLabel, javax.swing.GroupLayout.Alignment.TRAILING)))
        );

        contentPanel.setBackground(new java.awt.Color(44, 62, 80));

        logoutBtn.setBackground(new java.awt.Color(246, 71, 71));
        logoutBtn.setFont(new java.awt.Font("Helvetica Neue", 1, 14)); // NOI18N
        logoutBtn.setForeground(new java.awt.Color(255, 255, 255));
        logoutBtn.setText("Back");
        logoutBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                logoutBtnActionPerformed(evt);
            }
        });

        welcomeLabel.setFont(new java.awt.Font("Hiragino Sans", 0, 14)); // NOI18N
        welcomeLabel.setForeground(new java.awt.Color(255, 255, 255));
        welcomeLabel.setText("Welcome, ");
        welcomeLabel.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        usernameLabel.setFont(new java.awt.Font("Hiragino Sans", 0, 14)); // NOI18N
        usernameLabel.setForeground(new java.awt.Color(255, 255, 255));
        usernameLabel.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        usernameLabel.setText("[default user]");

        jTabbedPane.setBackground(new java.awt.Color(250, 115, 12));

        jPanel2.setBackground(new java.awt.Color(52, 73, 94));

        tblAttraction.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "UID", "Name", "Type", "City", "Cost", "Location"
            }
        ));
        tblAttraction.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblAttractionMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tblAttraction);

        lblType.setFont(new java.awt.Font("Hiragino Sans", 0, 14)); // NOI18N
        lblType.setForeground(new java.awt.Color(228, 241, 254));
        lblType.setText("Type:");

        lblAttractionId.setFont(new java.awt.Font("Hiragino Sans", 0, 14)); // NOI18N
        lblAttractionId.setForeground(new java.awt.Color(228, 241, 254));

        lblPrice.setFont(new java.awt.Font("Hiragino Sans", 0, 14)); // NOI18N
        lblPrice.setForeground(new java.awt.Color(228, 241, 254));
        lblPrice.setText("Cost:");

        lblAttPhoto.setFont(new java.awt.Font("Hiragino Sans", 0, 14)); // NOI18N
        lblAttPhoto.setForeground(new java.awt.Color(228, 241, 254));
        lblAttPhoto.setText("Photo:");

        createBtn.setBackground(new java.awt.Color(250, 115, 12));
        createBtn.setText("Create");
        createBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                createBtnActionPerformed(evt);
            }
        });

        updateBtn.setBackground(new java.awt.Color(129, 207, 224));
        updateBtn.setText("Update");
        updateBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updateBtnActionPerformed(evt);
            }
        });

        deleteBtn.setBackground(new java.awt.Color(246, 71, 71));
        deleteBtn.setText("Delete");
        deleteBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteBtnActionPerformed(evt);
            }
        });

        txtName.setBackground(new java.awt.Color(106, 122, 137));
        txtName.setForeground(new java.awt.Color(228, 241, 254));

        txtPrice.setBackground(new java.awt.Color(106, 122, 137));
        txtPrice.setForeground(new java.awt.Color(228, 241, 254));

        lblAttractionName.setFont(new java.awt.Font("Hiragino Sans", 0, 14)); // NOI18N
        lblAttractionName.setForeground(new java.awt.Color(228, 241, 254));
        lblAttractionName.setText("Name:");

        cbType.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Show", "Tour", "Restaurant" }));

        btnAttractionBrowse.setText("Browse");
        btnAttractionBrowse.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAttractionBrowseActionPerformed(evt);
            }
        });

        lblAttractionLoc.setFont(new java.awt.Font("Hiragino Sans", 0, 8)); // NOI18N
        lblAttractionLoc.setForeground(new java.awt.Color(228, 241, 254));

        lblAtLocation.setFont(new java.awt.Font("Hiragino Sans", 0, 14)); // NOI18N
        lblAtLocation.setForeground(new java.awt.Color(228, 241, 254));
        lblAtLocation.setText("Location:");

        btnAttractionLocation.setText("Choose Location");
        btnAttractionLocation.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAttractionLocationActionPerformed(evt);
            }
        });

        lblCity.setFont(new java.awt.Font("Hiragino Sans", 0, 14)); // NOI18N
        lblCity.setForeground(new java.awt.Color(228, 241, 254));
        lblCity.setText("City:");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblAttractionId, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(lblType, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(lblAttractionName, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(deleteBtn)
                            .addComponent(lblAttPhoto, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblAtLocation, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblPrice, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtPrice, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtName, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cbType, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnAttractionBrowse)
                            .addComponent(btnAttractionLocation)
                            .addComponent(lblAttractionLoc, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblAttractionImage, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(updateBtn)
                                .addGap(40, 40, 40)
                                .addComponent(createBtn))))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(lblCity, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cbCity, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 63, Short.MAX_VALUE)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 550, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 516, Short.MAX_VALUE)
                        .addContainerGap())
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(lblAttractionId, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblAttractionName))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblType)
                            .addComponent(cbType, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblCity)
                            .addComponent(cbCity, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtPrice, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblPrice))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnAttractionLocation)
                            .addComponent(lblAtLocation))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblAttractionLoc, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnAttractionBrowse)
                            .addComponent(lblAttPhoto))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblAttractionImage, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(updateBtn)
                            .addComponent(createBtn)
                            .addComponent(deleteBtn))
                        .addGap(22, 22, 22))))
        );

        jTabbedPane.addTab("Attractions", jPanel2);

        jPanel4.setBackground(new java.awt.Color(52, 73, 94));

        accountTbl.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "City", "Password", "Mayor", "Level", "ZIP", "Population", "Location"
            }
        ));
        accountTbl.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                accountTblMouseClicked(evt);
            }
        });
        jScrollPane4.setViewportView(accountTbl);
        if (accountTbl.getColumnModel().getColumnCount() > 0) {
            accountTbl.getColumnModel().getColumn(5).setHeaderValue("Population");
            accountTbl.getColumnModel().getColumn(6).setHeaderValue("Location");
        }

        lblCityName.setFont(new java.awt.Font("Hiragino Sans", 0, 13)); // NOI18N
        lblCityName.setForeground(new java.awt.Color(228, 241, 254));
        lblCityName.setText("City Name:");

        txtCityName.setBackground(new java.awt.Color(106, 122, 137));
        txtCityName.setForeground(new java.awt.Color(228, 241, 254));

        lblLevel.setFont(new java.awt.Font("Hiragino Sans", 0, 13)); // NOI18N
        lblLevel.setForeground(new java.awt.Color(228, 241, 254));
        lblLevel.setText("Level:");

        lblPhoto.setFont(new java.awt.Font("Hiragino Sans", 0, 13)); // NOI18N
        lblPhoto.setForeground(new java.awt.Color(228, 241, 254));
        lblPhoto.setText("Photo:");

        lblZip.setFont(new java.awt.Font("Hiragino Sans", 0, 13)); // NOI18N
        lblZip.setForeground(new java.awt.Color(228, 241, 254));
        lblZip.setText("ZIP Code:");

        lblPassword.setFont(new java.awt.Font("Hiragino Sans", 0, 13)); // NOI18N
        lblPassword.setForeground(new java.awt.Color(228, 241, 254));
        lblPassword.setText("Password:");

        txtPassword.setBackground(new java.awt.Color(106, 122, 137));
        txtPassword.setForeground(new java.awt.Color(228, 241, 254));

        txtPopulation.setBackground(new java.awt.Color(106, 122, 137));
        txtPopulation.setForeground(new java.awt.Color(228, 241, 254));

        lblPopulation.setFont(new java.awt.Font("Hiragino Sans", 0, 13)); // NOI18N
        lblPopulation.setForeground(new java.awt.Color(228, 241, 254));
        lblPopulation.setText("Population:");

        cbLevel.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "First-Level", "Second-Level", "Third-Level" }));

        accCreateBtn.setBackground(new java.awt.Color(250, 115, 12));
        accCreateBtn.setText("Create");
        accCreateBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                accCreateBtnActionPerformed(evt);
            }
        });

        accUpdateBtn.setBackground(new java.awt.Color(129, 207, 224));
        accUpdateBtn.setText("Update");
        accUpdateBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                accUpdateBtnActionPerformed(evt);
            }
        });

        accDeleteBtn.setBackground(new java.awt.Color(246, 71, 71));
        accDeleteBtn.setText("Delete");
        accDeleteBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                accDeleteBtnActionPerformed(evt);
            }
        });

        txtMayor.setBackground(new java.awt.Color(106, 122, 137));
        txtMayor.setForeground(new java.awt.Color(228, 241, 254));

        lblMayor.setFont(new java.awt.Font("Hiragino Sans", 0, 13)); // NOI18N
        lblMayor.setForeground(new java.awt.Color(228, 241, 254));
        lblMayor.setText("Mayor:");

        txtLocation.setBackground(new java.awt.Color(106, 122, 137));
        txtLocation.setForeground(new java.awt.Color(228, 241, 254));
        txtLocation.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtLocationKeyPressed(evt);
            }
        });

        lblLocation.setFont(new java.awt.Font("Hiragino Sans", 0, 13)); // NOI18N
        lblLocation.setForeground(new java.awt.Color(228, 241, 254));
        lblLocation.setText("Location:");

        txtZIP.setBackground(new java.awt.Color(106, 122, 137));
        txtZIP.setForeground(new java.awt.Color(228, 241, 254));

        btnCityBrowse.setText("Browse");
        btnCityBrowse.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCityBrowseActionPerformed(evt);
            }
        });

        btnChooseLocation.setText("Choose Location");
        btnChooseLocation.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnChooseLocationActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(accDeleteBtn)
                            .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addGroup(jPanel4Layout.createSequentialGroup()
                                    .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(lblLevel)
                                        .addComponent(cbLevel, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGap(32, 32, 32)
                                    .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(lblZip)
                                        .addComponent(txtZIP, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGap(9, 9, 9))
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel4Layout.createSequentialGroup()
                                    .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel4Layout.createSequentialGroup()
                                            .addGap(128, 128, 128)
                                            .addComponent(accUpdateBtn))
                                        .addComponent(txtLocation, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGap(0, 0, Short.MAX_VALUE)))
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lblCityName)
                                    .addComponent(txtCityName, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(32, 32, 32)
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtPassword, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(lblPassword)))
                            .addComponent(lblLocation))
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 30, Short.MAX_VALUE)
                                .addComponent(accCreateBtn)
                                .addGap(87, 87, 87))
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addGap(20, 20, 20)
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtMayor, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(lblMayor)
                                    .addComponent(lblPopulation)
                                    .addComponent(txtPopulation, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(btnChooseLocation)
                            .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(jPanel4Layout.createSequentialGroup()
                                    .addGap(94, 94, 94)
                                    .addComponent(lblCityImage, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(jPanel4Layout.createSequentialGroup()
                                    .addContainerGap()
                                    .addComponent(lblPhoto)
                                    .addGap(18, 18, 18)
                                    .addComponent(btnCityBrowse))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 498, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(lblPassword)
                                    .addComponent(lblMayor))
                                .addGap(35, 35, 35))
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel4Layout.createSequentialGroup()
                                        .addComponent(lblCityName)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(txtCityName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel4Layout.createSequentialGroup()
                                        .addGap(27, 27, 27)
                                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                            .addComponent(txtPassword, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(txtMayor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblLevel)
                            .addComponent(lblZip)
                            .addComponent(lblPopulation))
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(cbLevel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtZIP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtPopulation, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addComponent(lblLocation)
                        .addGap(4, 4, 4)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtLocation, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnChooseLocation))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblPhoto)
                            .addComponent(btnCityBrowse))
                        .addGap(8, 8, 8)
                        .addComponent(lblCityImage, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 91, Short.MAX_VALUE)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(accCreateBtn)
                            .addComponent(accUpdateBtn)
                            .addComponent(accDeleteBtn))
                        .addGap(27, 27, 27))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jScrollPane4)
                        .addContainerGap())))
        );

        jTabbedPane.addTab("City Management", jPanel4);

        jPanel5.setBackground(new java.awt.Color(52, 73, 94));

        accountTbl1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Name", "Password", "Language", "Admitted", "Photo"
            }
        ));
        accountTbl1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                accountTbl1MouseClicked(evt);
            }
        });
        jScrollPane5.setViewportView(accountTbl1);

        lblCityName1.setFont(new java.awt.Font("Hiragino Sans", 0, 13)); // NOI18N
        lblCityName1.setForeground(new java.awt.Color(228, 241, 254));
        lblCityName1.setText("Organization Name:");

        txtCityName1.setBackground(new java.awt.Color(106, 122, 137));
        txtCityName1.setForeground(new java.awt.Color(228, 241, 254));

        lblPassword1.setFont(new java.awt.Font("Hiragino Sans", 0, 14)); // NOI18N
        lblPassword1.setForeground(new java.awt.Color(228, 241, 254));
        lblPassword1.setText("Password:");

        txtPassword1.setBackground(new java.awt.Color(106, 122, 137));
        txtPassword1.setForeground(new java.awt.Color(228, 241, 254));

        accCreateBtn1.setBackground(new java.awt.Color(250, 115, 12));
        accCreateBtn1.setText("Create");
        accCreateBtn1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                accCreateBtn1ActionPerformed(evt);
            }
        });

        accUpdateBtn1.setBackground(new java.awt.Color(129, 207, 224));
        accUpdateBtn1.setText("Update");
        accUpdateBtn1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                accUpdateBtn1ActionPerformed(evt);
            }
        });

        accDeleteBtn1.setBackground(new java.awt.Color(246, 71, 71));
        accDeleteBtn1.setText("Delete");
        accDeleteBtn1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                accDeleteBtn1ActionPerformed(evt);
            }
        });

        cbLang1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "English", "Spanish", "Chinese", "Portuguese" }));

        lblLanguage1.setFont(new java.awt.Font("Hiragino Sans", 0, 14)); // NOI18N
        lblLanguage1.setForeground(new java.awt.Color(228, 241, 254));
        lblLanguage1.setText("Language:");

        lblAdmit1.setFont(new java.awt.Font("Hiragino Sans", 0, 14)); // NOI18N
        lblAdmit1.setForeground(new java.awt.Color(228, 241, 254));
        lblAdmit1.setText("Admitted:");

        txtAdmit1.setBackground(new java.awt.Color(106, 122, 137));
        txtAdmit1.setForeground(new java.awt.Color(228, 241, 254));

        btnStateBrowse1.setText("Browse");
        btnStateBrowse1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnStateBrowse1ActionPerformed(evt);
            }
        });

        lblAdmit2.setFont(new java.awt.Font("Hiragino Sans", 0, 14)); // NOI18N
        lblAdmit2.setForeground(new java.awt.Color(228, 241, 254));
        lblAdmit2.setText("Photo:");

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel5Layout.createSequentialGroup()
                                        .addGap(128, 128, 128)
                                        .addComponent(accUpdateBtn1))
                                    .addComponent(accDeleteBtn1))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(accCreateBtn1))
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel5Layout.createSequentialGroup()
                                        .addGap(29, 29, 29)
                                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(jPanel5Layout.createSequentialGroup()
                                                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addComponent(lblCityName1)
                                                    .addComponent(lblPassword1))
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addComponent(txtPassword1, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addComponent(txtCityName1, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                            .addGroup(jPanel5Layout.createSequentialGroup()
                                                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addComponent(lblLanguage1)
                                                    .addComponent(lblAdmit1)
                                                    .addComponent(lblAdmit2))
                                                .addGap(54, 54, 54)
                                                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                    .addComponent(cbLang1, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                    .addComponent(txtAdmit1)))))
                                    .addGroup(jPanel5Layout.createSequentialGroup()
                                        .addGap(128, 128, 128)
                                        .addComponent(lblImage1, javax.swing.GroupLayout.PREFERRED_SIZE, 183, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(0, 31, Short.MAX_VALUE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnStateBrowse1)
                        .addGap(111, 111, 111)))
                .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 566, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGap(37, 37, 37)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblCityName1)
                            .addComponent(txtCityName1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(10, 10, 10)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblPassword1)
                            .addComponent(txtPassword1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblLanguage1)
                            .addComponent(cbLang1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtAdmit1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblAdmit1))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblAdmit2)
                            .addComponent(lblImage1, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnStateBrowse1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(accCreateBtn1)
                            .addComponent(accUpdateBtn1)
                            .addComponent(accDeleteBtn1))
                        .addGap(27, 27, 27))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(jScrollPane5, javax.swing.GroupLayout.DEFAULT_SIZE, 516, Short.MAX_VALUE)
                        .addContainerGap())))
        );

        jTabbedPane.addTab("Organization Management", jPanel5);

        javax.swing.GroupLayout contentPanelLayout = new javax.swing.GroupLayout(contentPanel);
        contentPanel.setLayout(contentPanelLayout);
        contentPanelLayout.setHorizontalGroup(
            contentPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(contentPanelLayout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(contentPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(contentPanelLayout.createSequentialGroup()
                        .addComponent(welcomeLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(usernameLabel)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(contentPanelLayout.createSequentialGroup()
                        .addGroup(contentPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jTabbedPane, javax.swing.GroupLayout.PREFERRED_SIZE, 932, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(logoutBtn))
                        .addGap(0, 106, Short.MAX_VALUE))))
        );
        contentPanelLayout.setVerticalGroup(
            contentPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, contentPanelLayout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(contentPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(welcomeLabel)
                    .addComponent(usernameLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTabbedPane)
                .addGap(18, 18, 18)
                .addComponent(logoutBtn)
                .addGap(17, 17, 17))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(contentPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addComponent(headerBar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(45, 45, 45)
                .addComponent(contentPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addComponent(headerBar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void foldLabelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_foldLabelMouseClicked
        this.setState(JFrame.ICONIFIED);
    }//GEN-LAST:event_foldLabelMouseClicked

    private void crossLabelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_crossLabelMouseClicked
        this.dispose();
    }//GEN-LAST:event_crossLabelMouseClicked

    private void logoutBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_logoutBtnActionPerformed
        //       
        this.dispose();
        //required text field check

    }//GEN-LAST:event_logoutBtnActionPerformed

    private void deleteBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteBtnActionPerformed
        int selectedRowIndex = tblAttraction.getSelectedRow();

        if (selectedRowIndex<0) {
            JOptionPane.showMessageDialog(this, "Please select a row to view.");
            return;
        }

        DefaultTableModel model = (DefaultTableModel) tblAttraction.getModel();
        Attraction selectattraction = (Attraction)model.getValueAt(selectedRowIndex, 0);

        String cname = cbCity.getSelectedItem().toString();
        City city = state.findCity(cname);
        
        
//        selectattraction.AddUpdateDeleteAttraction('d', selectattraction.getUid(), selectattraction.getName(), selectattraction.getLocation(), selectattraction.getCost(), selectattraction.getType(), cname, state.getName(), picture);

        tblAttraction.setModel(new DefaultTableModel(null,new Object[]{"ID","Name","City","State","Zip code","Location","Start Date","End Date","Type","Price","Picture","Detail"}));
        selectattraction.fillJtable(tblAttraction, "");
        
        city.deleteAttraction(selectattraction);

        JOptionPane.showMessageDialog(this, "Attraction deleted.");

        //populateAttractionTbl(); //refresh the table
        //clear the textfields below
        txtName.setText("");
        txtPrice.setText("");
        cbType.setSelectedIndex(0);
        cbCity.setSelectedIndex(0);
        lblAttractionLoc.setText("");
        lblAttractionId.setText("");
        lblAttractionImage.setIcon(null);

    }//GEN-LAST:event_deleteBtnActionPerformed

    private void updateBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updateBtnActionPerformed
        int selectedRowIndex = tblAttraction.getSelectedRow();

        if (selectedRowIndex<0) {
            JOptionPane.showMessageDialog(this, "Please select a row to view.");
            return;
        }

        DefaultTableModel model = (DefaultTableModel) tblAttraction.getModel();
        Attraction selectattraction = (Attraction)model.getValueAt(selectedRowIndex, 0);
        
        String cname = cbCity.getSelectedItem().toString();
        String aname = txtName.getText();
        City city = state.findCity(cname);
        double cost = Double.parseDouble(txtPrice.getText());
        String type = cbType.getSelectedItem().toString();
        //create a new attraction 
        if(!city.isExisted(selectattraction.getUid())){
            String uid = null;     
            do{
                uid = String.valueOf(randomIdGenerator(8));
            }while(city.isExisted(uid));
            Attraction attraction = city.newAttraction(aname, uid, cbType.getSelectedItem().toString());
            attraction.setType(cbType.getSelectedItem().toString());
            attraction.setCost(Double.parseDouble(txtPrice.getText()));
            attraction.setImagePath(attractionImagePath);
            attraction.setLocation(lblAttractionLoc.getText());
            lblAttractionId.setText(uid);
            populateAttractionTbl(); 
            return;
        }
        selectattraction.setName(aname);
        selectattraction.setType(cbType.getSelectedItem().toString());
        selectattraction.setCost(Double.parseDouble(txtPrice.getText()));
        selectattraction.setImagePath(attractionImagePath);
        selectattraction.setLocation(lblAttractionLoc.getText());
        lblAttractionId.setText(selectattraction.getUid());
        
//        selectattraction.AddUpdateDeleteAttraction('u', selectattraction.getUid(), aname, lblAttractionLoc.getText(), cost, type, cname, state.getName(), picture);

        tblAttraction.setModel(new DefaultTableModel(null,new Object[]{"ID","State","Type","City","Cost","Location","Image","Attraction"}));
        selectattraction.fillJtable(tblAttraction, "");

        
        //populateAttractionTbl(); //refresh the table
    }//GEN-LAST:event_updateBtnActionPerformed

    private void createBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_createBtnActionPerformed
        String aname = txtName.getText();
        String type = cbType.getSelectedItem().toString();
        String city = cbCity.getSelectedItem().toString();
        String location = lblAttractionLoc.getText();
        String attractionImagePath = this.attractionImagePath;
        double price = Double.valueOf(txtPrice.getText());
        String uid = "123";
                
        if("".equals(aname)){
            JOptionPane.showMessageDialog(null, "Attraction name is required");
            return;
        }
        
        City selectcity = state.findCity(city);
        do{
            uid = String.valueOf(randomIdGenerator(8));
        }while(selectcity.isExisted(uid));
        
        Attraction newattraction = selectcity.newAttraction(aname, uid, type);
        
        newattraction.setName(aname);
        newattraction.setUid(uid);
        newattraction.setCost(price);
        newattraction.setImagePath(attractionImagePath);
        newattraction.setLocation(location);
        newattraction.setType(type);
        
//        newattraction.AddUpdateDeleteAttraction('i', uid, aname, location, price, type, city, state.getName(), picture);

        tblAttraction.setModel(new DefaultTableModel(null,new Object[]{"ID","Name","City","State","Zip code","Location","Start Date","End Date","Type","Price","Picture","Detail"}));
        newattraction.fillJtable(tblAttraction, "");

        txtName.setText("");
        txtPrice.setText("");
        lblAttractionId.setText("");
        lblAttractionImage.setIcon(null);
        //populateAttractionTbl();

    }//GEN-LAST:event_createBtnActionPerformed

    private void tblAttractionMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblAttractionMouseClicked
        int selectedRowIndex = tblAttraction.getSelectedRow();

        if (selectedRowIndex<0) {
            JOptionPane.showMessageDialog(this, "Please select a row to view.");
            return;
        }

        DefaultTableModel model = (DefaultTableModel) tblAttraction.getModel();
        Attraction selectattraction = (Attraction)model.getValueAt(selectedRowIndex, 0);
        City selectcity = (City)model.getValueAt(selectedRowIndex, 3);
        txtName.setText(selectattraction.getName());
        txtPrice.setText(String.valueOf(selectattraction.getCost()));
        lblAttractionLoc.setText(selectattraction.getLocation());
        if(selectattraction.getType() == "Show"){
            cbType.setSelectedIndex(0);
        }else if(selectattraction.getType() == "Tour"){
            cbType.setSelectedIndex(1);
        }else if(selectattraction.getType() == "Restaurant"){
            cbType.setSelectedIndex(2);
        }
        for(int i=0;i<cbCity.getItemCount();i++){
            if(selectcity.getName() == cbCity.getItemAt(i)){
                cbCity.setSelectedIndex(i);
            }
        }

        
        lblAttractionId.setText(selectattraction.getUid());
        this.attractionImagePath = selectattraction.getImagePath();
        if(attractionImagePath==""){
            lblAttractionImage.setIcon(null);
        }else{
            ImageIcon ii = new ImageIcon(attractionImagePath);
            Image img = ii.getImage().getScaledInstance(lblAttractionImage.getWidth(), lblAttractionImage.getHeight(), Image.SCALE_SMOOTH);
            lblAttractionImage.setIcon(new ImageIcon(img));
        }

    }//GEN-LAST:event_tblAttractionMouseClicked

    private void txtLocationKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtLocationKeyPressed
        char c = evt.getKeyChar();
        if(Character.isLetter(c)){
            txtLocation.setEditable(false);
        }else{
            txtLocation.setEditable(true);

        }
    }//GEN-LAST:event_txtLocationKeyPressed

    private void accDeleteBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_accDeleteBtnActionPerformed
        int selectedRowIndex = accountTbl.getSelectedRow();

        if (selectedRowIndex<0) {
            JOptionPane.showMessageDialog(this, "Please select a row to view.");
            return;
        }
        DefaultTableModel model = (DefaultTableModel) accountTbl.getModel();
        City selectcity = (City)model.getValueAt(selectedRowIndex, 0);
        
        state.deleteCity(selectcity); 

        JOptionPane.showMessageDialog(this, "City deleted.");

        txtCityName.setText("");
        txtPassword.setText("");
        txtMayor.setText("");
        txtLocation.setText("");
        txtZIP.setText("");
        txtPopulation.setText("");
        cbLevel.setSelectedIndex(0);
        lblCityImage.setIcon(null);
        populateAccountTable();
    }//GEN-LAST:event_accDeleteBtnActionPerformed

    private void accUpdateBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_accUpdateBtnActionPerformed
        String name = txtCityName.getText();
        String password = txtPassword.getText();
        String location = txtLocation.getText();
        String mayor = txtMayor.getText();
        String population = txtPopulation.getText();
        String zipCode = txtZIP.getText();
        String cityImagePath = this.cityImagePath;
        String level = cbLevel.getSelectedItem().toString();
        if("".equals(name)){
            JOptionPane.showMessageDialog(null, "City name is required");
            return;
        }else if("".equals(password)){
            JOptionPane.showMessageDialog(null, "Password is required");
            return;
        }
        
        String PATTERN = "^[0-9]{0,5}[-][0-9]{0,5}$";
        Pattern patt = Pattern.compile(PATTERN);
        Matcher match = patt.matcher(zipCode);

        if(!match.matches()){
            JOptionPane.showMessageDialog(null, "ZIP code format is wrong!");
            return;
        }
        String PATTERN2 = "^[0-9]{0,30}$";
        Pattern patt2 = Pattern.compile(PATTERN2);
        Matcher match2 = patt2.matcher(population);

        if(!match2.matches()){
            JOptionPane.showMessageDialog(null, "Population only allowed numbers!");
            return;
        }

        int selectedRowIndex = accountTbl.getSelectedRow();

        if (selectedRowIndex<0) {
            JOptionPane.showMessageDialog(this, "Please select a row to view.");
            return;
        }
        DefaultTableModel model = (DefaultTableModel) accountTbl.getModel();
        City selectcity = (City)model.getValueAt(selectedRowIndex, 0);

        if(state.isExisted(name)){
            if(!name.equals(selectcity.getName())){
                JOptionPane.showMessageDialog(null, "City already existed!");
                return;
            }
        }


        selectcity.setName(name);
        selectcity.setPassword(password);
        selectcity.setLevel(level);
        selectcity.setLocation(location);
        selectcity.setMayor(mayor);
        selectcity.setPopulation(population);
        selectcity.setImagePath(cityImagePath);
        selectcity.setZipCode(zipCode);

        populateAccountTable();
    }//GEN-LAST:event_accUpdateBtnActionPerformed

    private void accCreateBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_accCreateBtnActionPerformed
        String name = txtCityName.getText();
        String password = txtPassword.getText();
        String location = txtLocation.getText();
        String mayor = txtMayor.getText();
        String population = txtPopulation.getText();
        String zipCode = txtZIP.getText();
        String cityImagePath = this.cityImagePath;
        String level = cbLevel.getSelectedItem().toString();
        if("".equals(name)){
            JOptionPane.showMessageDialog(null, "City name is required");
            return;
        }else if("".equals(password)){
            JOptionPane.showMessageDialog(null, "Password is required");
            return;
        }

        String PATTERN = "^[0-9]{0,5}[-][0-9]{0,5}$";
        Pattern patt = Pattern.compile(PATTERN);
        Matcher match = patt.matcher(zipCode);

        if(!match.matches()){
            JOptionPane.showMessageDialog(null, "ZIP code format is wrong!");
            return;
        }
        String PATTERN2 = "^[0-9]{0,30}$";
        Pattern patt2 = Pattern.compile(PATTERN2);
        Matcher match2 = patt2.matcher(population);

        if(!match2.matches()){
            JOptionPane.showMessageDialog(null, "Population only allowed numbers!");
            return;
        }

        //employeeId existed !!
        if(state.isExisted(name)){
            JOptionPane.showMessageDialog(null, "City already existed!");
            return;
        }

        City newcity = state.newCity(name, password);

        newcity.setName(name);
        newcity.setPassword(password);
        newcity.setLevel(level);
        newcity.setLocation(location);
        newcity.setMayor(mayor);
        newcity.setPopulation(population);
        newcity.setImagePath(cityImagePath);
        newcity.setZipCode(zipCode);

        txtCityName.setText("");
        txtPassword.setText("");
        txtMayor.setText("");
        txtLocation.setText("");
        txtZIP.setText("");
        txtPopulation.setText("");
        cbLevel.setSelectedIndex(0);
        lblCityImage.setIcon(null);
        populateAccountTable();
    }//GEN-LAST:event_accCreateBtnActionPerformed

    private void accountTblMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_accountTblMouseClicked
        int selectedRowIndex = accountTbl.getSelectedRow();

        if (selectedRowIndex<0) {
            JOptionPane.showMessageDialog(this, "Please select a row to view.");
            return;
        }

        DefaultTableModel model = (DefaultTableModel) accountTbl.getModel();
        City selectcity = (City)model.getValueAt(selectedRowIndex, 0);

        txtCityName.setText(selectcity.getName());
        txtPassword.setText(selectcity.getPassword());
        txtMayor.setText(selectcity.getMayor());
        txtLocation.setText(selectcity.getLocation());
        txtZIP.setText(selectcity.getZipCode());
        txtPopulation.setText(selectcity.getPopulation());
        this.cityImagePath = selectcity.getImagePath();
        if(null != selectcity.getLevel())switch (selectcity.getLevel()) {
            case "First-Level" -> {
                cbLevel.setSelectedIndex(0);
            }
            case "Second-Level" -> {
                cbLevel.setSelectedIndex(1);
            }
            case "Third-Level" -> {
                cbLevel.setSelectedIndex(2);
            }
            default -> {
            }
        }
        if(this.cityImagePath == ""){
            lblCityImage.setIcon(null);
        }else{
            ImageIcon ii = new ImageIcon(cityImagePath);
            Image img = ii.getImage().getScaledInstance(lblCityImage.getWidth(), lblCityImage.getHeight(), Image.SCALE_SMOOTH);
            lblCityImage.setIcon(new ImageIcon(img));      
        }


    }//GEN-LAST:event_accountTblMouseClicked

    private void btnChooseLocationActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnChooseLocationActionPerformed
        Engine engine = Engine.newInstance(
        EngineOptions.newBuilder(HARDWARE_ACCELERATED)
                .licenseKey("6P830J66YBX0YGUC06OM6Y7U70YS7G14WF0L5DF5YH06G6QJF7L7JKJ9K9X8B7FZTWZW")
                .build());

        // Create a Browser instance.
        Browser browser = engine.newBrowser();
        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("Location Picker");
            JPanel mapPanel = new JPanel();           
            JPanel buttonPanel = new JPanel();
            JButton select = new JButton();
            select.setText("SELECT");
            select.setSize(100, 50);
            select.setHorizontalAlignment(JButton.CENTER);
            frame.addWindowListener(new WindowAdapter() {
                @Override
                public void windowClosing(WindowEvent e) {
                    // Shutdown Chromium and release allocated resources.
                    engine.close();
                }
            });
            select.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    
                    browser.focusedFrame().ifPresent(frame ->{
                        frame.document().ifPresent(document -> {
                            document.documentElement().ifPresent(documentElemnt ->
                                    documentElemnt.findElementsByClassName("gm-style-iw-d").forEach(element -> {                                     
                                        selectLocation = element.innerText();
                                        lblAttractionLoc.setText(selectLocation);
                                    }));
                        });                  
                    });
                    JOptionPane.showMessageDialog(null, "You have selected:"+selectLocation);
                }
            });
            // Create and embed Swing BrowserView component to display web content.
            select.addMouseListener(new MouseAdapter(){
                public void MouseClicked(MouseEvent evt){
                    
                    

                }
            
            });
            mapPanel.add(BrowserView.newInstance(browser),BorderLayout.CENTER);
            mapPanel.setBounds(0, 0, 600, 400);
            mapPanel.setSize(600, 400);
 
            
            buttonPanel.setBounds(0, 600, 600, 100);
            buttonPanel.setLayout(new BorderLayout());
            buttonPanel.setBackground(Color.blue);
            //select.setBounds(250, 50, 50, 50);
            buttonPanel.add(select,BorderLayout.CENTER );
            frame.setSize(600, 650);
            frame.setLocationRelativeTo(null);
            frame.setVisible(true);
            frame.add(mapPanel);           
            frame.add(buttonPanel); 
            //frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            // Load the required web page.
            //browser.navigation().loadUrl("https://html5test.com/");
            String url = "file://"+new File("simple_map.html").getAbsolutePath();
            String[] urls = url.split("simple_map.html");        
            url = urls[0]+"src/main/resources/simple_map.html";       
            browser.navigation().loadUrl(url);

        });
    }//GEN-LAST:event_btnChooseLocationActionPerformed

    private void btnAttractionBrowseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAttractionBrowseActionPerformed
        // TODO add your handling code here:
        JFileChooser browseImageFile = new JFileChooser();
        //Filter image extensions
        FileNameExtensionFilter fnef = new FileNameExtensionFilter("IMAGES", "png", "jpg", "jpeg");
        browseImageFile.addChoosableFileFilter(fnef);
        int showOpenDialogue = browseImageFile.showOpenDialog(null);
        try{
            if(showOpenDialogue == JFileChooser.APPROVE_OPTION){
                File selectedImageFile = browseImageFile.getSelectedFile();
                String selectedImagePath = selectedImageFile.getAbsolutePath();
                this.attractionImagePath = selectedImagePath;
                JOptionPane.showMessageDialog(null, "You are now selecting "+selectedImagePath);
                FileInputStream fis = new FileInputStream(selectedImageFile);
                ByteArrayOutputStream bos = new ByteArrayOutputStream();
                byte[] buf = new byte[1024];
                for(int readNum; (readNum = fis.read(buf))!=-1;){
                    bos.write(buf, 0, readNum);
                }
                picture = bos.toByteArray();
                //Display image on jlabel
                ImageIcon ii = new ImageIcon(selectedImagePath);
                //Resize image to fit the label
                Image img = ii.getImage().getScaledInstance(lblAttractionImage.getWidth(), lblAttractionImage.getHeight(), Image.SCALE_SMOOTH);

                lblAttractionImage.setIcon(new ImageIcon(img));
               
                }
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, e);    
        }
    }//GEN-LAST:event_btnAttractionBrowseActionPerformed

    private void btnAttractionLocationActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAttractionLocationActionPerformed
//        LocationPicker lcp = new LocationPicker();
//        lcp.setVisible(true);
//        lcp.pack();
//        lcp.setLocationRelativeTo(null);
//        lcp.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                // Initialize Chromium.
        Engine engine = Engine.newInstance(
        EngineOptions.newBuilder(HARDWARE_ACCELERATED)
                .licenseKey("6P830J66YBX0YGUC06OM6Y7U70YS7G14WF0L5DF5YH06G6QJF7L7JKJ9K9X8B7FZTWZW")
                .build());

        // Create a Browser instance.
        Browser browser = engine.newBrowser();
        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("Location Picker");
            JPanel mapPanel = new JPanel();           
            JPanel buttonPanel = new JPanel();
            JButton select = new JButton();
            select.setText("SELECT");
            select.setSize(100, 50);
            select.setHorizontalAlignment(JButton.CENTER);
            frame.addWindowListener(new WindowAdapter() {
                @Override
                public void windowClosing(WindowEvent e) {
                    // Shutdown Chromium and release allocated resources.
                    engine.close();
                }
            });
            select.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    
                    browser.focusedFrame().ifPresent(frame ->{
                        frame.document().ifPresent(document -> {
                            document.documentElement().ifPresent(documentElemnt ->
                                    documentElemnt.findElementsByClassName("gm-style-iw-d").forEach(element -> {                                     
                                        selectLocation = element.innerText();
                                        lblAttractionLoc.setText(selectLocation);
                                    }));
                        });                  
                    });
                    JOptionPane.showMessageDialog(null, "You have selected:"+selectLocation);
                }
            });
            // Create and embed Swing BrowserView component to display web content.
            select.addMouseListener(new MouseAdapter(){
                public void MouseClicked(MouseEvent evt){
                    
                    

                }
            
            });
            mapPanel.add(BrowserView.newInstance(browser),BorderLayout.CENTER);
            mapPanel.setBounds(0, 0, 600, 400);
            mapPanel.setSize(600, 400);
 
            
            buttonPanel.setBounds(0, 600, 600, 100);
            buttonPanel.setLayout(new BorderLayout());
            buttonPanel.setBackground(Color.blue);
            //select.setBounds(250, 50, 50, 50);
            buttonPanel.add(select,BorderLayout.CENTER );
            frame.setSize(600, 650);
            frame.setLocationRelativeTo(null);
            frame.setVisible(true);
            frame.add(mapPanel);           
            frame.add(buttonPanel); 
            //frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            // Load the required web page.
            //browser.navigation().loadUrl("https://html5test.com/");
            String url = "file://"+new File("simple_map.html").getAbsolutePath();
            String[] urls = url.split("simple_map.html");        
            url = urls[0]+"src/main/resources/simple_map.html";       
            browser.navigation().loadUrl(url);

        });
    }//GEN-LAST:event_btnAttractionLocationActionPerformed

    private void btnCityBrowseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCityBrowseActionPerformed
        JFileChooser browseImageFile = new JFileChooser();
        //Filter image extensions
        FileNameExtensionFilter fnef = new FileNameExtensionFilter("IMAGES", "png", "jpg", "jpeg");
        browseImageFile.addChoosableFileFilter(fnef);
        int showOpenDialogue = browseImageFile.showOpenDialog(null);
        try{
            if(showOpenDialogue == JFileChooser.APPROVE_OPTION){
                File selectedImageFile = browseImageFile.getSelectedFile();
                String selectedImagePath = selectedImageFile.getAbsolutePath();
                this.cityImagePath = selectedImagePath;
                JOptionPane.showMessageDialog(null, "You are now selecting "+selectedImagePath);
                //Display image on jlabel
                ImageIcon ii = new ImageIcon(selectedImagePath);
                //Resize image to fit the label
                Image img = ii.getImage().getScaledInstance(lblCityImage.getWidth(), lblCityImage.getHeight(), Image.SCALE_SMOOTH);

                lblCityImage.setIcon(new ImageIcon(img));
               
                }
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, e);    
        }
    }//GEN-LAST:event_btnCityBrowseActionPerformed

    private void accountTbl1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_accountTbl1MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_accountTbl1MouseClicked

    private void accCreateBtn1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_accCreateBtn1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_accCreateBtn1ActionPerformed

    private void accUpdateBtn1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_accUpdateBtn1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_accUpdateBtn1ActionPerformed

    private void accDeleteBtn1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_accDeleteBtn1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_accDeleteBtn1ActionPerformed

    private void btnStateBrowse1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnStateBrowse1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnStateBrowse1ActionPerformed

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
            java.util.logging.Logger.getLogger(OrganizationManagerFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(OrganizationManagerFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(OrganizationManagerFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(OrganizationManagerFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
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
                new OrganizationManagerFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton accCreateBtn;
    private javax.swing.JButton accCreateBtn1;
    private javax.swing.JButton accDeleteBtn;
    private javax.swing.JButton accDeleteBtn1;
    private javax.swing.JButton accUpdateBtn;
    private javax.swing.JButton accUpdateBtn1;
    private javax.swing.JTable accountTbl;
    private javax.swing.JTable accountTbl1;
    private javax.swing.JButton btnAttractionBrowse;
    private javax.swing.JButton btnAttractionLocation;
    private javax.swing.JButton btnChooseLocation;
    private javax.swing.JButton btnCityBrowse;
    private javax.swing.JButton btnStateBrowse1;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.ButtonGroup buttonGroup2;
    private javax.swing.JComboBox<String> cbCity;
    private javax.swing.JComboBox<String> cbLang1;
    private javax.swing.JComboBox<String> cbLevel;
    private javax.swing.JComboBox<String> cbType;
    private javax.swing.JPanel contentPanel;
    private javax.swing.JButton createBtn;
    private javax.swing.JLabel crossLabel;
    private javax.swing.JButton deleteBtn;
    private javax.swing.JLabel foldLabel;
    private javax.swing.JPanel headerBar;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JTabbedPane jTabbedPane;
    private javax.swing.JLabel lblAdmit1;
    private javax.swing.JLabel lblAdmit2;
    private javax.swing.JLabel lblAtLocation;
    private javax.swing.JLabel lblAttPhoto;
    private javax.swing.JLabel lblAttractionId;
    private javax.swing.JLabel lblAttractionImage;
    private javax.swing.JLabel lblAttractionLoc;
    private javax.swing.JLabel lblAttractionName;
    private javax.swing.JLabel lblCity;
    private javax.swing.JLabel lblCityImage;
    private javax.swing.JLabel lblCityName;
    private javax.swing.JLabel lblCityName1;
    private javax.swing.JLabel lblImage1;
    private javax.swing.JLabel lblLanguage1;
    private javax.swing.JLabel lblLevel;
    private javax.swing.JLabel lblLocation;
    private javax.swing.JLabel lblMayor;
    private javax.swing.JLabel lblPassword;
    private javax.swing.JLabel lblPassword1;
    private javax.swing.JLabel lblPhoto;
    private javax.swing.JLabel lblPopulation;
    private javax.swing.JLabel lblPrice;
    private javax.swing.JLabel lblType;
    private javax.swing.JLabel lblZip;
    private javax.swing.JButton logoutBtn;
    private javax.swing.JLabel registerLabel;
    private javax.swing.JTable tblAttraction;
    private javax.swing.JTextField txtAdmit1;
    private javax.swing.JTextField txtCityName;
    private javax.swing.JTextField txtCityName1;
    private javax.swing.JTextField txtLocation;
    private javax.swing.JTextField txtMayor;
    private javax.swing.JTextField txtName;
    private javax.swing.JTextField txtPassword;
    private javax.swing.JTextField txtPassword1;
    private javax.swing.JTextField txtPopulation;
    private javax.swing.JTextField txtPrice;
    private javax.swing.JTextField txtZIP;
    private javax.swing.JButton updateBtn;
    private javax.swing.JLabel usernameLabel;
    private javax.swing.JLabel welcomeLabel;
    // End of variables declaration//GEN-END:variables
}
