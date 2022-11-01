/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author Guest123
 */
public class Encounter {
    
    private Patient patient;
    private Vital_Sign vital_Signs;
    private String date_Time;
 
    public Patient getPatient() {
        return patient;
    }
 
    public void setPatient(Patient patient) {
        this.patient = patient;
    }
 
    public Vital_Sign getVital_Signs() {
        return vital_Signs;
    }
 
    public void setVital_Signs(Vital_Sign vital_Signs) {
        this.vital_Signs = vital_Signs;
    }
 
    public String getTimeStamp() {
        return date_Time;
    }
 
    public void setTimeStamp(String date_Time) {
        this.date_Time = date_Time;
    }
    
}
