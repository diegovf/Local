/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package net.tec.example.dao;

import java.util.Collection;
import net.tec.example.to.EventTO;

/**
 *
 * @author diego
 */
public interface EventDAO {
    // Basic CRUD operations
    
    // Create new event
    public int insertEvent(EventTO event);
    
    // Remove a event
    public boolean deleteEvent(int id);
    
    // Find an specific event
    public EventTO findEvent(int id);
    
    // Update a event
    public boolean updateEvent(EventTO evnt);
    
    // Select a info row from specific event 
    //public RowSet selectPersonRS(int id);
    
    // Select all info from table without criteria (select * from all)
    public Collection selectEventTO();
}
