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
import net.tec.example.to.IndividualTO;
import net.tec.example.to.InstallationTO;
import net.tec.example.to.PersonTO;

/**
 *
 * @author diego
 */
public class SQLServerIndividualDAO implements IndividualDAO{
     public SQLServerIndividualDAO(){ }
    
    // Implement insert person here.
    // Return newly created person number or a -1 on error
    @Override
    public int insertIndividual(IndividualTO ind) {
        Connection conn = null;
        PreparedStatement stmt;
        int rowCount = 0;
        try{
            conn = SQLServerDAOFactory.createConnection();
            stmt = conn.prepareStatement("Insert Into Individuos Values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)");
            stmt.setInt(1, ind.getCedula());
            stmt.setString(2, ind.getNombre());
            stmt.setString(3, ind.getApellidos());
            stmt.setDate(4, ind.getFechaNacimiento());
            stmt.setInt(5, ind.getEdad());
            stmt.setString(6, ind.getGenero());
            stmt.setString(7, ind.getOcupacion());
            stmt.setString(8, ind.getCiudad());
            stmt.setString(9, ind.getEntrenador());
            stmt.setInt(10, ind.getIdCompetidor());
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
    public boolean deleteIndividual() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    // Implement find a person here using supplied argument values as search criteria
    // Return a Transfer Object if found, return null on error or if not found
    @Override
    public IndividualTO findIndividual(int id) {
        Connection conn = null;
        PreparedStatement stmt;
        ResultSet rs;
        IndividualTO ind = null;
        
        try{  
            conn = SQLServerDAOFactory.createConnection();
            stmt = conn.prepareStatement("SELECT * FROM Individuos Where cedula = ?");
            stmt.setInt(1, id);
            rs = stmt.executeQuery();
            rs.next();
            ind = new IndividualTO(rs.getInt("cedula"), rs.getString("nombre"), rs.getString("apellidos"), 
                        rs.getDate("fechaNacimiento"), rs.getInt("edad"), rs.getString("idGenero"), rs.getString("Ocupacion"),
                        rs.getString("ciudad"), rs.getString("nombreEntrenador"), rs.getInt("idCompetidor"));
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
        
        return ind;
    }

    // Implement update record here using data from the personData Transfer Object
    // Return true on success, false on failure or error
    @Override
    public boolean updateIndividual() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    // Implement search persons here using the supplied criteria.
    // Return a RowSet. 
    @Override
    public RowSet selectIndividualRS(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    // Implement search persons here using the supplied criteria.
    // Alternatively, implement to return a Collection of Transfer Objects.
    @Override
    public Collection selectIndividualTO() {
        
        Connection conn = null;
        PreparedStatement stmt;
        ResultSet rs;
        Collection insList = null;
        IndividualTO p;
        
        try{  
            conn = SQLServerDAOFactory.createConnection();
            stmt = conn.prepareStatement("SELECT * FROM Individuos");
            rs = stmt.executeQuery();
            
            insList = new ArrayList();
            
            while(rs.next()){
                p = new IndividualTO(rs.getInt("cedula"), rs.getString("nombre"), rs.getString("apellidos"), 
                        rs.getDate("fechaNacimiento"), rs.getInt("edad"), rs.getString("idGenero"), rs.getString("Ocupacion"),
                        rs.getString("ciudad"), rs.getString("nombreEntrenador"), rs.getInt("idCompetidor"));
                insList.add(p);
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
        
        return insList;
    }
}
