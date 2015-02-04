/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package net.tec.example.dao;

import java.util.Collection;
import javax.sql.RowSet;
import net.tec.example.to.PersonTO;

/**
 *
 * @author AAC
 */
public interface PersonDAO {
    
    // Basic CRUD operations
    
    // Create new person
    public int insertPerson();
    
    // Remove a person
    public boolean deletePerson();
    
    // Find an specific person
    public PersonTO findPerson(int personID);
    
    // Update a person
    public boolean updatePerson();
    
    // Select a info row from specific person 
    public RowSet selectPersonRS(int personID);
    
    // Select all info from table without criteria (select * from all)
    public Collection selectPersonTO();
}