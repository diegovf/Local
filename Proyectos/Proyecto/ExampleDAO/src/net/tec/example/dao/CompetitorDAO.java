/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package net.tec.example.dao;

import java.util.Collection;
import net.tec.example.to.CompetitorTO;

/**
 *
 * @author diego
 */
public interface CompetitorDAO {
    // Basic CRUD operations
    
    // Create new event
    public int insertCompetitor(CompetitorTO cmp);
    
    // Remove a event
    public boolean deleteCompetitor(int id);
    
    // Find an specific event
    public CompetitorTO findCompetitor(int id);
    
    // Update a event
    public boolean updateCompetitor(CompetitorTO cmp);
    
    // Select a info row from specific event 
    //public RowSet selectPersonRS(int id);
    
    // Select all info from table without criteria (select * from all)
    public Collection selectCompetitorTO();
}
