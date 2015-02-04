/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package net.tec.example.dao;

import java.util.Collection;
import net.tec.example.to.AccommodationTO;
import net.tec.example.to.CountryTO;

/**
 *
 * @author diego
 */
public interface AccommodationDAO {
    // Basic CRUD operations
    
    // Create new event
    public int insertAccommodation(AccommodationTO acd);
    
    // Remove a event
    public boolean deleteAccommodation();
    
    // Find an specific event
    public AccommodationTO findAccommodation(int id);
    
    // Update a event
    public boolean updateAccommodation(AccommodationTO cnt);
    
    // Select a info row from specific event 
    //public RowSet selectPersonRS(int id);
    
    // Select all info from table without criteria (select * from all)
    public Collection selectAccommodationTO();
}
