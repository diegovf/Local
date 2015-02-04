/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package net.tec.example.dao;

import java.util.Collection;
import net.tec.example.to.GenderTO;

/**
 *
 * @author diego
 */
public interface GenderDAO {
    // Basic CRUD operations
    
    // Create new event
    public int insertGender(GenderTO event);
    
    // Remove a event
    public boolean deleteGender(int id);
    
    // Find an specific event
    public GenderTO findGender(int id);
    
    // Update a event
    public boolean updateGender(GenderTO gender);
    
    // Select a info row from specific event 
    //public RowSet selectPersonRS(int id);
    
    // Select all info from table without criteria (select * from all)
    public Collection selectGenderTO();
}
