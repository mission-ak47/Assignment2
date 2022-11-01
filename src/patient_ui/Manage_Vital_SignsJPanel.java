/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package patient_ui;

import java.awt.CardLayout;
//import java.awt.Color;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;
import javax.swing.InputVerifier;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;
import model.Patient;
import model.Person;
import model.Person_Directory;
import model.Vital_Sign;
import model.String_Verifier;
//import org.jfree.chart.ChartFactory;
//import org.jfree.chart.ChartFrame;
//import org.jfree.chart.JFreeChart;
//import org.jfree.chart.axis.CategoryAxis;
//import org.jfree.chart.axis.CategoryLabelPositions;
//import org.jfree.chart.axis.NumberAxis;
//import org.jfree.chart.plot.CategoryPlot;
//import org.jfree.chart.plot.PlotOrientation;
//import org.jfree.data.category.DefaultCategoryDataset;

/**
 *
 * @author Guest123
 */
public class Manage_Vital_SignsJPanel extends javax.swing.JPanel {

    /**
     * Creates new form Manage_Vital_SigndJPanel
     */
    
    private Person_Directory person_Directory;
    private JPanel userAccessArea;
    
    public Manage_Vital_SignsJPanel(JPanel userAccessArea, Person_Directory person_Directory) {
        initComponents();
        this.userAccessArea = userAccessArea;
        this.person_Directory = person_Directory;
        InputVerifier stringVerifier = new String_Verifier();
        txtSearchCommunity.setInputVerifier(stringVerifier);
        ArrayList<Person> personList = person_Directory.getPerson_History();
        populatePatientsTable(personList);
        populateVitalSignTable(null);
        populateAbnormalCommunityTable(new ArrayList<>(), null);
        populateCommunities(personList);
        
    }
        
        private void populatePatientsTable(ArrayList<Person> personList) {
        DefaultTableModel model = (DefaultTableModel) tblManage_Patient.getModel();
        model.setRowCount(0);
        if (personList.isEmpty()) {
            JOptionPane.showMessageDialog(this, "No Persons found. Please add Persons",
                    "Error", JOptionPane.INFORMATION_MESSAGE);
            return;
        }
        for (Person person : personList) {
            Object[] row = new Object[4];
            row[0] = person;
            row[1] = person.getPerson_Age();
            row[3] = person.getCommunity().getCommunity_Name();
            if (person.getPatient() != null) {
                row[2] = person.getPatient().getPatient_ID();
            } else {
                row[2] = "Patient Not Created";
            }

            model.addRow(row);
        }
    }

    private void populateVitalSignTable(Person person) {

        DefaultTableModel model = (DefaultTableModel) tblVisitTime.getModel();
        model.setRowCount(0);
        if (person != null) {
            int patientAge = person.getPerson_Age();
            ArrayList<Vital_Sign> vitalSignList = person.getPatient().getVital_Sign_History().getHistory();

            if (vitalSignList.isEmpty()) {
                JOptionPane.showMessageDialog(this, "No vital signs found. Please"
                        + " add vital signs", "Error", JOptionPane.INFORMATION_MESSAGE);
                return;
            }
            for (Vital_Sign vital_Sign : vitalSignList) {
                Object[] row = new Object[2];
                row[0] = vital_Sign;
                row[1] = VitalSignStatus(patientAge, vital_Sign);
                model.addRow(row);
            }
        }
    }

    private void populateCommunities(ArrayList<Person> personList) {
        ArrayList<String> communities = new ArrayList<String>();
        for (Person person : personList) {
            communities.add(person.getCommunity().getCommunity_Name());
        }
        Set<String> uniqueCommunities = new HashSet<String>(communities);
        for (String str : uniqueCommunities) {
            ddCommunity.addItem(str);
        }
    }

    private void populateAbnormalCommunityTable(ArrayList<Person> personList, String community) {

        DefaultTableModel model = (DefaultTableModel) tblCommunity.getModel();
        model.setRowCount(0);
        for (Person person : personList) {
            if (person != null) {
                if (!person.getCommunity().getCommunity_Name().equalsIgnoreCase(community)) {
                    continue;
                }
                int patientAge = person.getPerson_Age();
                ArrayList<Vital_Sign> vitalSignList = person.getPatient().getVital_Sign_History().getHistory();
                if (vitalSignList.isEmpty()) {
                    continue;
                }
                String vitalSignStatus = VitalSignStatus(patientAge, vitalSignList.get(vitalSignList.size() - 1));
                if ("Abnormal".equalsIgnoreCase(vitalSignStatus)) {
                    Object[] row = new Object[2];
                    row[0] = community;
                    row[1] = vitalSignStatus;
                    model.addRow(row);
                }
            }
        }
        if (model.getRowCount() == 0) {
            JOptionPane.showMessageDialog(this, "No persons found", "Error", JOptionPane.INFORMATION_MESSAGE);
            return;
        }
    }

    private String VitalSignStatus(int patientAge, Vital_Sign vital_Sign) {
        String vitalSignStatus = "Normal";

        int respirationRate = vital_Sign.getRespiratory_Rate();
        int heartRate = vital_Sign.getHeart_Rate();
        int bloodPressure = vital_Sign.getSystolic_Blood_Pressure();
        float weight = vital_Sign.getWeight();

        //Toddler
        if (patientAge >= 1 && patientAge <= 3) {
            if ((respirationRate < 20 || respirationRate > 30) 
                    || (heartRate < 80 || heartRate > 130) 
                    || (bloodPressure < 80 || bloodPressure > 110) 
                    || (weight < 22 || weight > 31)) {
                vitalSignStatus = "Abnormal";
            }
        }
        //Preschooler
        if (patientAge > 3 && patientAge <= 5) {
            if ((respirationRate < 20 || respirationRate > 30)
                    || (heartRate < 80 || heartRate > 120)
                    || (bloodPressure < 80 || bloodPressure > 110)
                    || (weight < 31 || weight > 40)) {
                vitalSignStatus = "Abnormal";
            }
        }
        //School Age//
        if (patientAge >= 6 && patientAge <= 12) {
            if ((respirationRate < 20 || respirationRate > 30)
                    || (heartRate < 70 || heartRate > 110)
                    || (bloodPressure < 80 || bloodPressure > 120)
                    || (weight < 41 || weight > 92)) {
                vitalSignStatus = "Abnormal";
            }
        }
        //Adolescent//
        if (patientAge >= 13) {
            if ((respirationRate < 12 || respirationRate > 20)
                    || (heartRate < 55 || heartRate > 105)
                    || (bloodPressure < 110 || bloodPressure > 120)
                    || (weight < 110)) {
                vitalSignStatus = "Abnormal";
            }
        }
        return vitalSignStatus;
    }

    
    private void refreshVialSigns() {
        int selectedRow = tblManage_Patient.getSelectedRow();
        if (selectedRow < 0) {
            populateVitalSignTable(null);
        } else {
            Person person = (Person) tblManage_Patient.getValueAt(selectedRow, 0);
            Patient patient = person.getPatient();
            if (patient != null) {
                populateVitalSignTable(person);
            } else {
                populateVitalSignTable(null);
            }
        }
    }

//    private void createChart() {
//        DefaultCategoryDataset vitalSignDataset = new DefaultCategoryDataset();
//        int selectedRow = tblManage_Patient.getSelectedRow();
//        Person person = (Person) tblManage_Patient.getValueAt(selectedRow, 0);
//        Patient patient = person.getPatient();
//        if (patient == null) {
//            JOptionPane.showMessageDialog(this, "Patient not created, Please create "
//                    + "Patient first.", "Error", JOptionPane.ERROR_MESSAGE);
//            return;
//        }
//
//        ArrayList<Vital_Sign> vitalSignList = patient.getVital_Sign_History().getHistory();
//        if (vitalSignList.isEmpty() || vitalSignList.size() == 1) {
//            JOptionPane.showMessageDialog(this, "No vital signs or only one vital "
//                    + "sign found. At least 2 vital sign records needed to show chart!",
//                    "Warning", JOptionPane.INFORMATION_MESSAGE);
//            return;
//        }
//        for (Vital_Sign vital_Sign : vitalSignList) {
//            vitalSignDataset.addValue(vital_Sign.getRespiratory_Rate(), "RR", vital_Sign.getDate_Time());
//            vitalSignDataset.addValue(vital_Sign.getHeart_Rate(), "HR", vital_Sign.getDate_Time());
//            vitalSignDataset.addValue(vital_Sign.getSystolic_Blood_Pressure(), "BP", vital_Sign.getDate_Time());
//            vitalSignDataset.addValue(vital_Sign.getWeight(), "WT", vital_Sign.getDate_Time());
//        }
//
//        JFreeChart vitalSignChart = ChartFactory.createBarChart("Vital Sign Chart",
//                "Time Stamp", "Rate", vitalSignDataset, PlotOrientation.VERTICAL, true, false, false);
//        vitalSignChart.setBackgroundPaint(Color.white);
//        CategoryPlot vitalSignChartPlot = vitalSignChart.getCategoryPlot();
//        vitalSignChartPlot.setBackgroundPaint(Color.lightGray);
//
//        CategoryAxis vitalSignDomainAxis = vitalSignChartPlot.getDomainAxis();
//        vitalSignDomainAxis.setCategoryLabelPositions(
//                CategoryLabelPositions.createUpRotationLabelPositions(Math.PI / 6.0)
//        );
//
//        NumberAxis vitalSignRangeAxis = (NumberAxis) vitalSignChartPlot.getRangeAxis();
//        vitalSignRangeAxis.setStandardTickUnits(NumberAxis.createIntegerTickUnits());
//
//        ChartFrame chartFrame = new ChartFrame("Chart", vitalSignChart);
//        chartFrame.setVisible(true);
//        chartFrame.setSize(500, 500);
//
//    }
    
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        btnBack = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblVisitTime = new javax.swing.JTable();
        btnViewVitalSign = new javax.swing.JButton();
        btnUpdateVitalSigns = new javax.swing.JButton();
        btnDeleteVitalSign = new javax.swing.JButton();
        btnRefreshVitalSigns = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tblCommunity = new javax.swing.JTable();
        btnSearchAbnormalPatients = new javax.swing.JButton();
        ddCommunity = new javax.swing.JComboBox<>();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblManage_Patient = new javax.swing.JTable();
        txtSearchCommunity = new javax.swing.JTextField();
        btnSearchCommunity = new javax.swing.JButton();
        btnDisplayStatus = new javax.swing.JButton();
        btnAddVitalSigns = new javax.swing.JButton();
        btnRefreshPatients = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();

        jPanel1.setBackground(new java.awt.Color(204, 255, 255));

        btnBack.setText("Back");
        btnBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBackActionPerformed(evt);
            }
        });

        jPanel2.setBackground(new java.awt.Color(204, 240, 240));

        jTabbedPane1.setBackground(new java.awt.Color(153, 255, 255));

        jPanel3.setBackground(new java.awt.Color(153, 250, 250));

        tblVisitTime.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "Check-Up Date & Time", "Patient Health Status"
            }
        ));
        jScrollPane1.setViewportView(tblVisitTime);

        btnViewVitalSign.setText("View Vital Signs");
        btnViewVitalSign.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnViewVitalSignActionPerformed(evt);
            }
        });

        btnUpdateVitalSigns.setText("Update Vital Signs");
        btnUpdateVitalSigns.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdateVitalSignsActionPerformed(evt);
            }
        });

        btnDeleteVitalSign.setText("Delete Vital Signs");
        btnDeleteVitalSign.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteVitalSignActionPerformed(evt);
            }
        });

        btnRefreshVitalSigns.setText("Refresh Vital Signs");
        btnRefreshVitalSigns.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRefreshVitalSignsActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane1)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(btnViewVitalSign, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnUpdateVitalSigns)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnDeleteVitalSign)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnRefreshVitalSigns, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(22, Short.MAX_VALUE))
        );

        jPanel3Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {btnDeleteVitalSign, btnRefreshVitalSigns, btnUpdateVitalSigns, btnViewVitalSign});

        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 179, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnViewVitalSign)
                    .addComponent(btnUpdateVitalSigns)
                    .addComponent(btnRefreshVitalSigns)
                    .addComponent(btnDeleteVitalSign))
                .addGap(27, 27, 27))
        );

        jTabbedPane1.addTab("Visit Timing", jPanel3);

        jPanel4.setBackground(new java.awt.Color(153, 250, 250));

        tblCommunity.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "Community", "Patient Health Status"
            }
        ));
        jScrollPane3.setViewportView(tblCommunity);

        btnSearchAbnormalPatients.setText("Search Potential Pateints");
        btnSearchAbnormalPatients.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSearchAbnormalPatientsActionPerformed(evt);
            }
        });

        ddCommunity.setFont(new java.awt.Font("Comic Sans MS", 0, 14)); // NOI18N
        ddCommunity.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ddCommunityActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 571, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                        .addComponent(ddCommunity, javax.swing.GroupLayout.PREFERRED_SIZE, 358, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnSearchAbnormalPatients, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(164, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(ddCommunity, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnSearchAbnormalPatients, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(40, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Comunity", jPanel4);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 741, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 12, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGap(0, 28, Short.MAX_VALUE)
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 286, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        tblManage_Patient.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Patient Name", "Patient Age", "Patient ID", "Comunity"
            }
        ));
        jScrollPane2.setViewportView(tblManage_Patient);

        txtSearchCommunity.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtSearchCommunityActionPerformed(evt);
            }
        });

        btnSearchCommunity.setText("Search Community");
        btnSearchCommunity.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSearchCommunityActionPerformed(evt);
            }
        });

        btnDisplayStatus.setText("Display Status");
        btnDisplayStatus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDisplayStatusActionPerformed(evt);
            }
        });

        btnAddVitalSigns.setText("Add Vital Signs");
        btnAddVitalSigns.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddVitalSignsActionPerformed(evt);
            }
        });

        btnRefreshPatients.setText("Refresh Patients");
        btnRefreshPatients.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRefreshPatientsActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Lucida Grande", 0, 24)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Community Summary");

        jButton1.setText("Print");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 757, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 757, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(btnDisplayStatus)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnAddVitalSigns)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnRefreshPatients)
                        .addGap(37, 37, 37)
                        .addComponent(txtSearchCommunity, javax.swing.GroupLayout.PREFERRED_SIZE, 205, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnSearchCommunity, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addComponent(jButton1)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(btnBack))
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel1Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {btnAddVitalSigns, btnDisplayStatus, btnRefreshPatients});

        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnDisplayStatus)
                    .addComponent(btnAddVitalSigns)
                    .addComponent(btnRefreshPatients)
                    .addComponent(txtSearchCommunity, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnSearchCommunity))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnBack)
                    .addComponent(jButton1))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBackActionPerformed
        // TODO add your handling code here:
        userAccessArea.remove(this);
        CardLayout layout = (CardLayout) userAccessArea.getLayout();
        layout.previous(userAccessArea);
    }//GEN-LAST:event_btnBackActionPerformed

    private void txtSearchCommunityActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtSearchCommunityActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtSearchCommunityActionPerformed

    private void btnSearchCommunityActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSearchCommunityActionPerformed
        // TODO add your handling code here:
        String key = txtSearchCommunity.getText().trim();
        if (key.length() == 0) {
            JOptionPane.showMessageDialog(this, "Please enter key.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        /*Storing searched patients in an array to display in table.*/
        ArrayList<Person> searchPatients = person_Directory.searchPatient(key);
        populatePatientsTable(searchPatients);
    }//GEN-LAST:event_btnSearchCommunityActionPerformed

    private void btnDisplayStatusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDisplayStatusActionPerformed
        // TODO add your handling code here:
        int selectedRow = tblManage_Patient.getSelectedRow();
        if (selectedRow < 0) {
            JOptionPane.showMessageDialog(this, "Please select a row from table.",
                    "Error", JOptionPane.INFORMATION_MESSAGE);
            return;
        }
        Person person = (Person) tblManage_Patient.getValueAt(selectedRow, 0);
        Patient patient = person.getPatient();
        if (patient != null) {
            populateVitalSignTable(person);
        } else {
            JOptionPane.showMessageDialog(this, "Patient not created, Please create "
                    + "Patient first.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnDisplayStatusActionPerformed

    private void btnAddVitalSignsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddVitalSignsActionPerformed
        // TODO add your handling code here:
        
        int selectedRow = tblManage_Patient.getSelectedRow();
        if (selectedRow < 0) {
            JOptionPane.showMessageDialog(this, "Please select a row from table.",
                    "Error", JOptionPane.INFORMATION_MESSAGE);
            return;
        }
        Person person = (Person) tblManage_Patient.getValueAt(selectedRow, 0);
        Patient patient = person.getPatient();
        if (patient != null) {
            Vital_Signs_RecordJPanel cvsJPanel = new Vital_Signs_RecordJPanel(userAccessArea, patient);
            userAccessArea.add("cvsJPanel", cvsJPanel);
            CardLayout layout = (CardLayout) userAccessArea.getLayout();
            layout.next(userAccessArea);
        } else {
            JOptionPane.showMessageDialog(this, "Patient not created, Please create"
                    + " Patient first.", "Error", JOptionPane.ERROR_MESSAGE);
        }
        
    }//GEN-LAST:event_btnAddVitalSignsActionPerformed

    private void btnRefreshPatientsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRefreshPatientsActionPerformed
        // TODO add your handling code here:
        txtSearchCommunity.setText("");
        populatePatientsTable(person_Directory.getPerson_History());
    }//GEN-LAST:event_btnRefreshPatientsActionPerformed

    private void ddCommunityActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ddCommunityActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ddCommunityActionPerformed

    private void btnSearchAbnormalPatientsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSearchAbnormalPatientsActionPerformed
        if (ddCommunity.getSelectedItem() == null) {
            JOptionPane.showMessageDialog(this, "No community selected", "Error", JOptionPane.INFORMATION_MESSAGE);
            return;
        }
        String community = ddCommunity.getSelectedItem().toString();
        populateAbnormalCommunityTable(person_Directory.getPerson_History(), community);
    }//GEN-LAST:event_btnSearchAbnormalPatientsActionPerformed

    private void btnRefreshVitalSignsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRefreshVitalSignsActionPerformed
        // TODO add your handling code here:
        refreshVialSigns();
    }//GEN-LAST:event_btnRefreshVitalSignsActionPerformed

    private void btnDeleteVitalSignActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteVitalSignActionPerformed
        // TODO add your handling code here:
        int selectedRow = tblManage_Patient.getSelectedRow();
        if (selectedRow < 0) {
            JOptionPane.showMessageDialog(this, "Please select a row from table.");
            return;
        }
        Person person = (Person) tblManage_Patient.getValueAt(selectedRow, 0);
        Patient patient = person.getPatient();
        if (patient == null) {
            JOptionPane.showMessageDialog(this, "Patient not created, Please create"
                + " Patient first.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        selectedRow = tblVisitTime.getSelectedRow();
        if (selectedRow < 0) {
            JOptionPane.showMessageDialog(this, "Please select a row from table.",
                "Error", JOptionPane.INFORMATION_MESSAGE);
            return;
        }
        Vital_Sign vitalSign = (Vital_Sign) tblVisitTime.getValueAt(selectedRow, 0);

        int flag = JOptionPane.showConfirmDialog(this, "Are you sure want to remove?",
            "Warning", JOptionPane.YES_NO_OPTION);
        if (flag == 0) {
            patient.getVital_Sign_History().deleteVital_Sign(vitalSign);
            refreshVialSigns();
        }
    }//GEN-LAST:event_btnDeleteVitalSignActionPerformed

    private void btnUpdateVitalSignsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateVitalSignsActionPerformed
        // TODO add your handling code here:
        int selectedRow = tblVisitTime.getSelectedRow();
        if (selectedRow < 0) {
            JOptionPane.showMessageDialog(this, "Please select a row from table.",
                "Error", JOptionPane.INFORMATION_MESSAGE);
            return;
        }
        Vital_Sign vitalSign = (Vital_Sign) tblVisitTime.getValueAt(selectedRow, 0);

        Updated_Vital_SignJPanel vuvsJPanel = new Updated_Vital_SignJPanel(userAccessArea,
            vitalSign, Boolean.TRUE);
        userAccessArea.add("vuvsJPanel", vuvsJPanel);
        CardLayout layout = (CardLayout) userAccessArea.getLayout();
        layout.next(userAccessArea);
    }//GEN-LAST:event_btnUpdateVitalSignsActionPerformed

    private void btnViewVitalSignActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnViewVitalSignActionPerformed
        // TODO add your handling code here:
        int selectedRow = tblVisitTime.getSelectedRow();
        if (selectedRow < 0) {
            JOptionPane.showMessageDialog(this, "Please select a row from table.",
                "Error", JOptionPane.INFORMATION_MESSAGE);
            return;
        }
        Vital_Sign vital_Sign = (Vital_Sign) tblVisitTime.getValueAt(selectedRow, 0);
        Updated_Vital_SignJPanel vuvsJPanel = new Updated_Vital_SignJPanel(userAccessArea,
            vital_Sign, Boolean.FALSE);
        userAccessArea.add("vuvsJPanel", vuvsJPanel);
        CardLayout layout = (CardLayout) userAccessArea.getLayout();
        layout.next(userAccessArea);
    }//GEN-LAST:event_btnViewVitalSignActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAddVitalSigns;
    private javax.swing.JButton btnBack;
    private javax.swing.JButton btnDeleteVitalSign;
    private javax.swing.JButton btnDisplayStatus;
    private javax.swing.JButton btnRefreshPatients;
    private javax.swing.JButton btnRefreshVitalSigns;
    private javax.swing.JButton btnSearchAbnormalPatients;
    private javax.swing.JButton btnSearchCommunity;
    private javax.swing.JButton btnUpdateVitalSigns;
    private javax.swing.JButton btnViewVitalSign;
    private javax.swing.JComboBox<String> ddCommunity;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTable tblCommunity;
    private javax.swing.JTable tblManage_Patient;
    private javax.swing.JTable tblVisitTime;
    private javax.swing.JTextField txtSearchCommunity;
    // End of variables declaration//GEN-END:variables
}
