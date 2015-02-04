/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package net.tec.example.dao;

import java.util.Collection;
import net.tec.example.to.CountryTO;

/**
 *
 * @author diego
 */
public interface CountryDAO {
    // Basic CRUD operations
    
    // Create new event
    public int insertCountry(CountryTO cnt);
    
    // Remove a event
    public boolean deleteCountry();
    
    // Find an specific event
    public CountryTO findCountry(int id);
    
    // Update a event
    public boolean updateCountry(CountryTO cnt);
    
    // Select a info row from specific event 
    //public RowSet selectPersonRS(int id);
    
    // Select all info from table without criteria (select * from all)
    public Collection selectCountryTO();
}
