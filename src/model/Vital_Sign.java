/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author Guest123
 */
public class Vital_Sign {
    
    private int respiratory_Rate;
    private int heart_Rate;
    private int systolic_Blood_Pressure;
    private int weight;
    private Date date_Time;

    
    public int getRespiratory_Rate() {
        return respiratory_Rate;
    }

    public void setRespiratory_Rate(int respiratory_Rate) {
        this.respiratory_Rate = respiratory_Rate;
    }

    public int getHeart_Rate() {
        return heart_Rate;
    }

    public void setHeart_Rate(int heart_Rate) {
        this.heart_Rate = heart_Rate;
    }

    public int getSystolic_Blood_Pressure() {
        return systolic_Blood_Pressure;
    }

    public void setSystolic_Blood_Pressure(int systolic_Blood_Pressure) {
        this.systolic_Blood_Pressure = systolic_Blood_Pressure;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public Date getDate_Time() {
        return date_Time;
    }

    public void setDate_Time(Date date_Time) {
        this.date_Time = date_Time;
    }
    
    @Override
    public String toString() {
        SimpleDateFormat ft = new SimpleDateFormat("MM/dd/yyyy 'at' hh:mm:ss a");
        return ft.format(date_Time);
    }
    
}
