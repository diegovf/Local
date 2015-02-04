/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package net.tec.example.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import javax.sql.RowSet;
import net.tec.example.factory.SQLServerDAOFactory;
import net.tec.example.to.MetricTO;
import net.tec.example.to.PersonTO;

/**
 *
 * @author diego
 */
public class SQLServerMetricDAO implements MetricDAO{
    public SQLServerMetricDAO(){}
    // Implement insert metric here.
    // Return newly created metric number or a -1 on error
    @Override
    public int insertMetric(MetricTO metric) {
        Connection conn = null;
        PreparedStatement stmt;
        int rowCount = 0;
        try{
            conn = SQLServerDAOFactory.createConnection();
            stmt = conn.prepareStatement("Insert Into Metricas Values (?, ?, ?, ?)");
            stmt.setInt(1, metric.getId());
            stmt.setString(2, metric.getMetrica());
            stmt.setDouble(3, metric.getMinimo());
            stmt.setDouble(4, metric.getMaximo());
            rowCount = stmt.executeUpdate();
        } catch(SQLException e){
            rowCount = -1;
            System.out.println("Message: " + e.getMessage() + "\n" + "Code: " + e.getErrorCode());
        }
        finally{
            if(conn != null){
                try{
                    conn.close();
                }
                catch(SQLException e){
                    System.out.println("Message: " + e.getMessage() + "\n" + "Code: " + e.getErrorCode());
                }
            }
        }
        return rowCount;
    }

    // Implement delete metric here
    // Return true on success, false on failure
    @Override
    public boolean deleteMetric(int id) {
        Connection conn = null;
        PreparedStatement stmt;
        boolean state = true;
        try{  
            conn = SQLServerDAOFactory.createConnection();
            stmt = conn.prepareStatement("Delete From Metricas Where id = ?");
            stmt.setInt(1, id);
            state = stmt.executeUpdate() == 1; 
        } 
        catch(SQLException e){
            state = false;
            System.out.println("Message: " + e.getMessage() + "\n" + "Code: " + e.getErrorCode());
        }
        finally{
            if(conn != null){
                try{
                    conn.close();
                }
                catch(SQLException e){
                    System.out.println("Message: " + e.getMessage() + "\n" + "Code: " + e.getErrorCode());
                }
            }
        }
        return state;
    }
    
    // Implement find a person here using supplied argument values as search criteria
    // Return a Transfer Object if found, return null on error or if not found
    @Override
    public MetricTO findMetric(int id) {
        Connection conn = null;
        PreparedStatement stmt;
        ResultSet rs;
        MetricTO metric = null;
        
        try{  
            conn = SQLServerDAOFactory.createConnection();
            stmt = conn.prepareStatement("SELECT * FROM Metricas Where id = ?");
            stmt.setInt(1, id);
            rs = stmt.executeQuery();
            rs.next();
            metric = new MetricTO(rs.getInt("id"), rs.getString("metrica"), rs.getDouble("minimo"), rs.getDouble("maximo"));
        } 
        catch(SQLException e){
            System.out.println("Message: " + e.getMessage() + "\n" + "Code: " + e.getErrorCode());
        }
        finally{
            if(conn != null){
                try{
                    conn.close();
                }
                catch(SQLException e){
                    System.out.println("Message: " + e.getMessage() + "\n" + "Code: " + e.getErrorCode());
                }
            }
        }
        
        return metric;
    }

    // Implement update record here using data from the personData Transfer Object
    // Return true on success, false on failure or error
    @Override
    public boolean updateMetric(MetricTO metric) {
        Connection conn = null;
        PreparedStatement stmt;
        ResultSet rs;
        MetricTO p;
        boolean rpta = false;
        try{  
            conn = SQLServerDAOFactory.createConnection();
            stmt = conn.prepareStatement("Update Metricas Set metrica=?, minimo=?, maximo=? Where id = ?");
            stmt.setString(1, metric.getMetrica());
            stmt.setDouble(2, metric.getMinimo());
            stmt.setDouble(3, metric.getMaximo());
            stmt.setInt(4, metric.getId());
            rpta = stmt.executeUpdate()==1;
        } 
        catch(SQLException e){
            System.out.println("Message: " + e.getMessage() + "\n" + "Code: " + e.getErrorCode());
        }
        finally{
            if(conn != null){
                try{
                    conn.close();
                }
                catch(SQLException e){
                    System.out.println("Message: " + e.getMessage() + "\n" + "Code: " + e.getErrorCode());
                }
            }
        }
        
        return rpta;
    }

    // Implement search persons here using the supplied criteria.
    // Return a RowSet. 
    /*@Override
    public RowSet selectPersonRS(int personID) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }*/

    // Implement search metrics here using the supplied criteria.
    // Alternatively, implement to return a Collection of Transfer Objects.
    @Override
    public Collection selectMetricTO() {
        
        Connection conn = null;
        PreparedStatement stmt;
        ResultSet rs;
        Collection metricList = null;
        MetricTO p;
        
        try{  
            conn = SQLServerDAOFactory.createConnection();
            stmt = conn.prepareStatement("SELECT * FROM Metricas");
            rs = stmt.executeQuery();
            
            metricList = new ArrayList();
            
            while(rs.next()){
                p = new MetricTO(rs.getInt("ID"), rs.getString("metrica"), rs.getDouble("minimo"), rs.getDouble("maximo"));
                metricList.add(p);
            }
        } 
        catch(SQLException e){
            System.out.println("Message: " + e.getMessage() + "\n" + "Code: " + e.getErrorCode());
        }
        finally{
            if(conn != null){
                try{
                    conn.close();
                }
                catch(SQLException e){
                    System.out.println("Message: " + e.getMessage() + "\n" + "Code: " + e.getErrorCode());
                }
            }
        }
        
        return metricList;
    }
}
