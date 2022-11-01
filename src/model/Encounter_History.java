/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.util.ArrayList;

/**
 *
 * @author Guest123
 */
public class Encounter_History {
    
    ArrayList<Encounter> encounter_List;
 
    public ArrayList<Encounter> getEncounter_List() {
        return encounter_List;
    }
 
    public void setEncounter_List(ArrayList<Encounter> encounter_List) {
        this.encounter_List = encounter_List;
    }
 
    public Encounter_History() {
        encounter_List = new ArrayList<Encounter>();
    }
 
    public void addEncounter(Encounter encounter) {
        this.encounter_List.add(encounter);
    }
}
