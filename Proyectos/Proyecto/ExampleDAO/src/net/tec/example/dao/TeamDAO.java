/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package net.tec.example.dao;

import java.util.Collection;
import net.tec.example.to.SportTO;
import net.tec.example.to.TeamTO;

/**
 *
 * @author diego
 */
public interface TeamDAO {
    // Basic CRUD operations
    
    // Create new team
    public int insertTeam(TeamTO sp);
    
    // Remove a team
    public boolean deleteTeam(String id);
    
    // Find an specific team
    public SportTO findTeam(String id);
    
    // Update a team
    public boolean updateTeam(TeamTO sp);
    
    // Select a info row from specific team 
   // public RowSet selectTeamRS(int teamId);
    
    // Select all info from table without criteria (select * from all)
    public Collection selectTeamTO();
}
