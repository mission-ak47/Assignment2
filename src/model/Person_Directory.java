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
public class Person_Directory {
    
    private ArrayList<Person> person_Directory;
    
    public Person_Directory() {
        person_Directory = new ArrayList<>();
    }
    
    public ArrayList<Person> getPerson_History() {
        return person_Directory;
    }
    
    public void setPerson_History(ArrayList<Person> person_History) {
        this.person_Directory = person_History;
    }
    
    public Person createAndAddPerson() {
        Person person = new Person();
        person_Directory.add(person);
        return person;
    }
    
    public void deletePerson(Person person) {
        person_Directory.remove(person);
    }
    
    public ArrayList<Person> searchPatient(String key)
    {
        ArrayList<Person> searchPatientDirectory = new ArrayList();
        for(Person person: person_Directory)
        {
            if(person.getCommunity().getCommunity_Name().toLowerCase().startsWith(key.toLowerCase()))
            {
                if(person.getPatient()!=null)
                {
                    searchPatientDirectory.add(person);
                }
            }
        }
        return searchPatientDirectory;
    }
    
    public ArrayList<Person> searchPerson(String key)
    {
        ArrayList<Person> searchPersonDirectory = new ArrayList();
        for(Person person: person_Directory)
        {
            if(person.getPerson_Name().toLowerCase().startsWith(key.toLowerCase()))
            {
                searchPersonDirectory.add(person);
            }
        }
        return searchPersonDirectory;
    }
    
}
