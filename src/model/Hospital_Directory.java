/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author Guest123
 */
public class Hospital_Directory {
    
    public Hospital createAndAddHospital() {
        Hospital hospital = new Hospital();
        hospital_Directory.add(hospital);
        return hospital;
    }
    
    public void deleteHospital(Hospital hospital) {
        hospital_Directory.remove(hospital);
    }

    private static class hospital_Directory {

        private static void remove(Hospital hospital) {
            throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        }

        private static void add(Hospital hospital) {
            throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        }

        public hospital_Directory() {
        }
    }
}
