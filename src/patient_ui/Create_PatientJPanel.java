/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package patient_ui;

import java.awt.CardLayout;
import javax.swing.InputVerifier;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import model.Patient;
import model.Person;
import model.String_Verifier;

/**
 *
 * @author Guest123
 */
public class Create_PatientJPanel extends javax.swing.JPanel {

    /**
     * Creates new form CreatePatientJPanel
     */
    
    private Person person;
    private JPanel userAccessArea;
    
    public Create_PatientJPanel(JPanel upc, Person person) {
        initComponents();
        this.userAccessArea = upc;
        this.person=person;
        addVerifiers();
    }

    private void addVerifiers() {
        InputVerifier stringVerifier = new String_Verifier();
        txtPatientID.setInputVerifier(stringVerifier);
        txtDoctor.setInputVerifier(stringVerifier);
        txtPharmacy.setInputVerifier(stringVerifier);
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        lblPatientDetails = new javax.swing.JLabel();
        lblPatientID = new javax.swing.JLabel();
        lblDoctor = new javax.swing.JLabel();
        lblPharmacy = new javax.swing.JLabel();
        txtPatientID = new javax.swing.JTextField();
        txtDoctor = new javax.swing.JTextField();
        txtPharmacy = new javax.swing.JTextField();
        btnAddPatient = new javax.swing.JButton();
        btnBack = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();

        jPanel1.setBackground(new java.awt.Color(204, 255, 255));

        lblPatientDetails.setFont(new java.awt.Font("Lucida Grande", 0, 24)); // NOI18N
        lblPatientDetails.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblPatientDetails.setText("Patient Details");

        lblPatientID.setText("Patient ID");

        lblDoctor.setText("Doctor");

        lblPharmacy.setText("Hospital");

        txtPatientID.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtPatientIDActionPerformed(evt);
            }
        });

        txtDoctor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtDoctorActionPerformed(evt);
            }
        });

        txtPharmacy.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtPharmacyActionPerformed(evt);
            }
        });

        btnAddPatient.setText("Add Patient");
        btnAddPatient.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnAddPatient.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddPatientActionPerformed(evt);
            }
        });

        btnBack.setText("Back");
        btnBack.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBackActionPerformed(evt);
            }
        });

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/patient-icon-png-21.png"))); // NOI18N
        jLabel3.setMaximumSize(new java.awt.Dimension(100, 100));
        jLabel3.setMinimumSize(new java.awt.Dimension(100, 100));
        jLabel3.setPreferredSize(new java.awt.Dimension(100, 100));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(34, 34, 34)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lblPatientID)
                                    .addComponent(lblDoctor)
                                    .addComponent(lblPharmacy))
                                .addGap(25, 25, 25)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtPharmacy, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtDoctor, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtPatientID, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(btnAddPatient)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnBack))))
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 305, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(23, Short.MAX_VALUE))
            .addComponent(lblPatientDetails, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, 344, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(lblPatientDetails)
                .addGap(30, 30, 30)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtPatientID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblPatientID))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtDoctor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblDoctor))
                .addGap(14, 14, 14)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtPharmacy, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblPharmacy))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAddPatient)
                    .addComponent(btnBack))
                .addGap(111, 111, 111))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBackActionPerformed
        // TODO add your handling code here:
        userAccessArea.remove(this);
        CardLayout layout = (CardLayout) userAccessArea.getLayout();
        layout.previous(userAccessArea);
    }//GEN-LAST:event_btnBackActionPerformed

    private void btnAddPatientActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddPatientActionPerformed
        // TODO add your handling code here:

        //Validation for Patient ID
        if(txtPatientID.getText().equals("")) {
            JOptionPane.showMessageDialog(null,"Patient ID cannot be empty.");
            return;
        }

        // Validation for Doctor's Name
        if(txtDoctor.getText().equals("")) {
            JOptionPane.showMessageDialog(null,"Doctor Name cannot be empty.");
            return;
        }
        if(!isAlpha(txtDoctor.getText())) {
            JOptionPane.showMessageDialog(this,"Please enter a valid Name!");
            return;
        }

        //Validation for Patient ID
        //        if(txtPatientID.getText().equals("")) {
            //            JOptionPane.showMessageDialog(this,"Patient ID cannot be empty.");
            //            return;
            //        }
        //        if(!isNum(txtPatientID.getText())) {
            //            JOptionPane.showMessageDialog(this,"Please enter an valid Patient ID.");
            //            return;
            //        }

        // Validation for Pharmacy Name
        if(txtPharmacy.getText().equals("")) {
            JOptionPane.showMessageDialog(null,"Pharmacy Name cannot be empty.");
            return;
        }
        if(!isAlpha(txtPharmacy.getText())) {
            JOptionPane.showMessageDialog(this,"Please enter a valid Pharmacy Name!");
            return;
        }

        if (checkBlankInput())
        {
            Patient patient = new Patient();
            patient.setPatient_ID(txtPatientID.getText());
            patient.setDoctor(txtDoctor.getText());
            patient.setPharmacy(txtPharmacy.getText());
            //Adding Patient to Person
            person.setPatient(patient);
            JOptionPane.showMessageDialog(this, "Patient added.", "Update",
                JOptionPane.INFORMATION_MESSAGE);
            clearFields();
        }
        else
        {
            JOptionPane.showMessageDialog(this, "Please enter all values",
                "Error", JOptionPane.ERROR_MESSAGE);
        }
        }
        private void clearFields()
        {
            txtPatientID.setText("");
            txtDoctor.setText("");
            txtPharmacy.setText("");
        }
        private Boolean checkBlankInput()
        {
            if(txtPatientID.getText().length()==0
                ||txtDoctor.getText().length()==0
                ||txtPharmacy.getText().length()==0)
            {
                return false;
            }
            else{
                return true;
            }
    }//GEN-LAST:event_btnAddPatientActionPerformed

    private void txtPharmacyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtPharmacyActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtPharmacyActionPerformed

    private void txtDoctorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtDoctorActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtDoctorActionPerformed

    private void txtPatientIDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtPatientIDActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtPatientIDActionPerformed

    private boolean isAlpha(String s) {
        char[] ch = s.toCharArray();
        for(char c: ch){
            if (!Character.isLetter(c))
                return false;
        }
        return true;
    }
    
    private boolean isNum(String s) {
        char[] ch = s.toCharArray();
        for(char c: ch){
            if (!Character.isDigit(c))
                return false;
        }
        return true;
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAddPatient;
    private javax.swing.JButton btnBack;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel lblDoctor;
    private javax.swing.JLabel lblPatientDetails;
    private javax.swing.JLabel lblPatientID;
    private javax.swing.JLabel lblPharmacy;
    private javax.swing.JTextField txtDoctor;
    private javax.swing.JTextField txtPatientID;
    private javax.swing.JTextField txtPharmacy;
    // End of variables declaration//GEN-END:variables
}
