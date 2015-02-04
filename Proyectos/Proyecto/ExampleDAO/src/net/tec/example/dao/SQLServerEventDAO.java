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
import net.tec.example.factory.SQLServerDAOFactory;
import net.tec.example.to.EventTO;

/**
 *
 * @author diego
 */
public class SQLServerEventDAO implements EventDAO{
    public SQLServerEventDAO(){ }
    
    // Implement insert person here.
    // Return newly created person number or a -1 on error
    @Override
    public int insertEvent(EventTO event) {
        Connection conn = null;
        PreparedStatement stmt;
        int rowCount = 0;
        try{
            conn = SQLServerDAOFactory.createConnection();
            stmt = conn.prepareStatement("Insert Into Eventos Values (?, ?, ?, ?, ?, ?, ?, ?, ?)");
            stmt.setInt(1, event.getId());
            stmt.setString(2, event.getGenero());
            stmt.setDate(3, event.getFechaInicio());
            stmt.setDate(4, event.getFechaFin());
            stmt.setInt(5, event.getCapacidad());
            stmt.setString(6, event.getInstalacion());
            stmt.setInt(7, event.getMetrica());
            stmt.setString(8, event.getDeporte());
            stmt.setInt(9, event.getTipoCompetidor());
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

    // Implement delete person here
    // Return true on success, false on failure
    @Override
    public boolean deleteEvent(int id) {
        Connection conn = null;
        PreparedStatement stmt;
        boolean state = true;
        try{  
            conn = SQLServerDAOFactory.createConnection();
            stmt = conn.prepareStatement("Delete From Eventos Where id = ?");
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
    public EventTO findEvent(int id) {
        Connection conn = null;
        PreparedStatement stmt;
        ResultSet rs;
        EventTO event = null;
        
        try{  
            conn = SQLServerDAOFactory.createConnection();
            stmt = conn.prepareStatement("SELECT * FROM Eventos Where id = ?");
            stmt.setInt(1, id);
            rs = stmt.executeQuery();
            rs.next();
            event = new EventTO(rs.getInt("id"), rs.getString("idGenero"), rs.getDate("fechaInicial"), rs.getDate("fechaFinal"), 
                        rs.getInt("capacidad"), rs.getString("idInstalacion"), rs.getInt("idMetrica"), rs.getString("idDeporte"), Integer.parseInt(rs.getString("tipoCompetidor")));
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
        
        return event;
    }

    // Implement update record here using data from the personData Transfer Object
    // Return true on success, false on failure or error
    @Override
    public boolean updateEvent(EventTO event) {
        Connection conn = null;
        PreparedStatement stmt;
        boolean rpta = false;
        try{  
            conn = SQLServerDAOFactory.createConnection();
            stmt = conn.prepareStatement("Update Eventos Set idGenero=?, fechaInicial=?, fechaFinal=?, capacidad=?, idInstalacion=?, idMetrica=?, idDeporte=?, tipoCompetidor=? Where id = ?");
            stmt.setString(1, event.getGenero());
            stmt.setDate(2, event.getFechaInicio());
            stmt.setDate(3, event.getFechaFin());
            stmt.setInt(4, event.getCapacidad());
            stmt.setString(5, event.getInstalacion());
            stmt.setInt(6, event.getMetrica());
            stmt.setString(7, event.getDeporte());
            stmt.setInt(8, event.getTipoCompetidor());
            stmt.setInt(9, event.getId());
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
    /*
    @Override
    public RowSet selectEventRS(int personID) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    */
    // Implement search persons here using the supplied criteria.
    // Alternatively, implement to return a Collection of Transfer Objects.
    @Override
    public Collection selectEventTO() {
        
        Connection conn = null;
        PreparedStatement stmt;
        ResultSet rs;
        Collection eventList = null;
        EventTO p;
        
        try{  
            conn = SQLServerDAOFactory.createConnection();
            stmt = conn.prepareStatement("SELECT * FROM Eventos");
            rs = stmt.executeQuery();
            
            eventList = new ArrayList();
            
            while(rs.next()){
                p = new EventTO(rs.getInt("id"), rs.getString("idGenero"), rs.getDate("fechaInicial"), rs.getDate("fechaFinal"), 
                        rs.getInt("capacidad"), rs.getString("idInstalacion"), rs.getInt("idMetrica"), rs.getString("idDeporte"), Integer.parseInt(rs.getString("tipoCompetidor")));
                eventList.add(p);
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
        
        return eventList;
    }
}
