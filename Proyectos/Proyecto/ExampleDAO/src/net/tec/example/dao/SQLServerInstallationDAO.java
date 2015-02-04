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
import net.tec.example.to.InstallationTO;
import net.tec.example.to.PersonTO;

/**
 *
 * @author diego
 */
public class SQLServerInstallationDAO implements InstallationDAO{
     public SQLServerInstallationDAO(){ }
    
    // Implement insert person here.
    // Return newly created person number or a -1 on error
    @Override
    public int insertInstallation(InstallationTO ins) {
        Connection conn = null;
        PreparedStatement stmt;
        int rowCount = 0;
        try{
            conn = SQLServerDAOFactory.createConnection();
            stmt = conn.prepareStatement("Insert Into Instalaciones Values (?, ?, ?)");
            stmt.setString(1, ins.getNombre());
            stmt.setString(2, ins.getDireccion());
            stmt.setInt(3, ins.getAsientos());
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
    public boolean deleteInstallation() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    // Implement find a person here using supplied argument values as search criteria
    // Return a Transfer Object if found, return null on error or if not found
    @Override
    public PersonTO findInstallation(int personID) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    // Implement update record here using data from the personData Transfer Object
    // Return true on success, false on failure or error
    @Override
    public boolean updateInstallation() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    // Implement search persons here using the supplied criteria.
    // Return a RowSet. 
    @Override
    public RowSet selectInstallationRS(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    // Implement search persons here using the supplied criteria.
    // Alternatively, implement to return a Collection of Transfer Objects.
    @Override
    public Collection selectInstallationTO() {
        
        Connection conn = null;
        PreparedStatement stmt;
        ResultSet rs;
        Collection insList = null;
        InstallationTO p;
        
        try{  
            conn = SQLServerDAOFactory.createConnection();
            stmt = conn.prepareStatement("SELECT * FROM Instalaciones");
            rs = stmt.executeQuery();
            
            insList = new ArrayList();
            
            while(rs.next()){
                p = new InstallationTO(rs.getString("nombre"), rs.getInt("capacidad"), rs.getString("direccion"));
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
