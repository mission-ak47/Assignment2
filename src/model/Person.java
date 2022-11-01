/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author Guest123
 */
public class Person {
    
    private String person_Name;
    private int person_Age;
    private Patient patient;
    private City city;
    private House house;
    private Community community;
    private Hospital hospital;

    public Community getCommunity() {
        return community;
    }

    public void setCommunity(Community community) {
        this.community = community;
    }

    public void setCity(City city) {
        this.city = city;
    }

    public void setHouse(House house) {
        this.house = house;
    }

    public City getCity() {
        return city;
    }

    public House getHouse() {
        return house;
    }
    
    public String getPerson_Name() {
        return person_Name;
    }
    
    public void setPerson_Name(String person_Name) {
        this.person_Name = person_Name;
    }
    
    public int getPerson_Age() {
        return person_Age;
    }
    
    public void setPerson_Age(int person_Age) {
        this.person_Age = person_Age;
    }
    
    public Patient getPatient() {
        return patient;
    }
    
    public void setPatient(Patient patient) {
        this.patient = patient;
    }
    
    public Hospital getHospital() {
        return hospital;
    }
    
    public void setHospital(Hospital hospital) {
        this.hospital = hospital;
    }
    
    @Override
    public String toString()
    {
        return this.person_Name;
    }
    
}
