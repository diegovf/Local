/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package net.tec.example.dao;

import java.util.Collection;
import net.tec.example.to.SportTO;

/**
 *
 * @author diego
 */
public interface SportDAO {
    // Basic CRUD operations
    
    // Create new metric
    public int insertSport(SportTO sp);
    
    // Remove a metric
    public boolean deleteSport(String id);
    
    // Find an specific metric
    public SportTO findSport(String id);
    
    // Update a metric
    public boolean updateSport(SportTO sp);
    
    // Select a info row from specific person 
   // public RowSet selectPersonRS(int personID);
    
    // Select all info from table without criteria (select * from all)
    public Collection selectSportTO();
}
