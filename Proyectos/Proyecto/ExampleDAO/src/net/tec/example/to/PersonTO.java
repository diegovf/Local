/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package net.tec.example.to;

/**
 *
 * @author diego
 */
public class PersonTO {
    
    private int personID;
    private String name;
    private String lastName;
    private String country;
    private String address;

    public PersonTO() {
        this.personID = 0;
        this.name = "";
        this.lastName = "";
        this.country = "";
        this.address = "";
    }
    
    public PersonTO(int personID, String name, String lastName, String country, String address) {
        this.personID = personID;
        this.name = name;
        this.lastName = lastName;
        this.country = country;
        this.address = address;
    }

    public int getPersonID() {
        return personID;
    }

    public void setPersonID(int personID) {
        this.personID = personID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastname() {
        return lastName;
    }

    public void setLastname(String lastName) {
        this.lastName = lastName;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "PersonID = " + personID + ", Name = " + name + ", Last Name = " + lastName + ", Country = " + country + ", Address = " + address;
    }
}
