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
public class Vital_Sign_History {
    
    private ArrayList<Vital_Sign> history;
    
    public Vital_Sign_History (){
        history = new ArrayList();
    }

    public ArrayList<Vital_Sign> getHistory() {
        return history;
    }

    public void setHistory(ArrayList<Vital_Sign> history) {
        this.history = history;
    }
    
    public Vital_Sign createAndAddVital_Sign() {
        Vital_Sign vital_Sign = new Vital_Sign();
        history.add(vital_Sign);
        return vital_Sign;
    }
    
    public void deleteVital_Sign(Vital_Sign vital_Sign) {
        history.remove(vital_Sign);
    }
    
}
