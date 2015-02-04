/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package net.tec.example.dao;

import java.util.Collection;
import javax.sql.RowSet;
import net.tec.example.to.MetricTO;

/**
 *
 * @author diego
 */
public interface MetricDAO {
    // Basic CRUD operations
    
    // Create new metric
    public int insertMetric(MetricTO metric);
    
    // Remove a metric
    public boolean deleteMetric(int id);
    
    // Find an specific metric
    public MetricTO findMetric(int id);
    
    // Update a metric
    public boolean updateMetric(MetricTO metric);
    
    // Select a info row from specific person 
   // public RowSet selectPersonRS(int personID);
    
    // Select all info from table without criteria (select * from all)
    public Collection selectMetricTO();
}
