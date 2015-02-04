/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package net.tec.example.dao;

import java.util.Collection;
import javax.sql.RowSet;
import net.tec.example.to.InstallationTO;
import net.tec.example.to.PersonTO;

/**
 *
 * @author diego
 */
public interface InstallationDAO {
    // Basic CRUD operations
    
    // Create new person
    public int insertInstallation(InstallationTO ins);
    
    // Remove a person
    public boolean deleteInstallation();
    
    // Find an specific person
    public PersonTO findInstallation(int id);
    
    // Update a person
    public boolean updateInstallation();
    
    // Select a info row from specific person 
    public RowSet selectInstallationRS(int personID);
    
    // Select all info from table without criteria (select * from all)
    public Collection selectInstallationTO();
}
