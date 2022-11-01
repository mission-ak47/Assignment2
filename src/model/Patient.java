/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author Guest123
 */
public class Patient {
    
    private String patient_ID;
    private String doctor;
    private String pharmacy;

    
    private Vital_Sign_History vital_Sign_History;
    
    public Patient() {
        this.vital_Sign_History = new Vital_Sign_History();
    }
    
    public String getPatient_ID() {
        return patient_ID;
    }
    
    public void setPatient_ID(String patient_ID) {
        this.patient_ID = patient_ID;
    }
    
    public String getDoctor() {
        return doctor;
    }
    
    public void setDoctor(String doctor) {
        this.doctor = doctor;
    }
    
    public String getPharmacy() {
        return pharmacy;
    }
    
    public void setPharmacy(String pharmacy) {
        this.pharmacy = pharmacy;
    }
    
    public Vital_Sign_History getVital_Sign_History() {
        return vital_Sign_History;
    }
    
    public void setVital_Sign_History(Vital_Sign_History vital_Sign_History) {
        this.vital_Sign_History = vital_Sign_History;
    }
    
    @Override
    public String toString()
    {
        return String.valueOf(this.patient_ID);
    }
    
}
