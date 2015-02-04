/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package net.tec.example.dao;

import java.util.Collection;
import javax.sql.RowSet;
import net.tec.example.to.IndividualTO;
import net.tec.example.to.PersonTO;

/**
 *
 * @author diego
 */
public interface IndividualDAO {
    // Basic CRUD operations
    
    // Create new person
    public int insertIndividual(IndividualTO ind);
    
    // Remove a person
    public boolean deleteIndividual();
    
    // Find an specific person
    public IndividualTO findIndividual(int id);
    
    // Update a person
    public boolean updateIndividual();
    
    // Select a info row from specific person 
    public RowSet selectIndividualRS(int individualId);
    
    // Select all info from table without criteria (select * from all)
    public Collection selectIndividualTO();
}
