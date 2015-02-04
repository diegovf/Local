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
import net.tec.example.factory.DAOFactory;
import net.tec.example.factory.SQLServerDAOFactory;
import net.tec.example.to.PersonTO;

/**
 *
 * @author AAC
 */
public class SQLServerPersonDAO implements PersonDAO {
    
    public SQLServerPersonDAO(){ }
    
    // Implement insert person here.
    // Return newly created person number or a -1 on error
    @Override
    public int insertPerson() {
        Connection conn = null;
        PreparedStatement stmt;
        int rowCount = 0;
        try{
            conn = SQLServerDAOFactory.createConnection();
            stmt = conn.prepareStatement("Insert Into Person Values (?, ?, ?, ?, ?)");
            stmt.setInt(1, 11);
            stmt.setString(2, "Diego");
            stmt.setString(3, "Varela Flores");
            stmt.setString(4, "Costa Rica");
            stmt.setString(5, "Cartago, La Puebla");
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
    public boolean deletePerson() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    // Implement find a person here using supplied argument values as search criteria
    // Return a Transfer Object if found, return null on error or if not found
    @Override
    public PersonTO findPerson(int personID) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    // Implement update record here using data from the personData Transfer Object
    // Return true on success, false on failure or error
    @Override
    public boolean updatePerson() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    // Implement search persons here using the supplied criteria.
    // Return a RowSet. 
    @Override
    public RowSet selectPersonRS(int personID) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    // Implement search persons here using the supplied criteria.
    // Alternatively, implement to return a Collection of Transfer Objects.
    @Override
    public Collection selectPersonTO() {
        
        Connection conn = null;
        PreparedStatement stmt;
        ResultSet rs;
        Collection personList = null;
        PersonTO p;
        
        try{  
            conn = SQLServerDAOFactory.createConnection();
            stmt = conn.prepareStatement("SELECT * FROM Person");
            rs = stmt.executeQuery();
            
            personList = new ArrayList();
            
            while(rs.next()){
                p = new PersonTO(rs.getInt("personID"), rs.getString("name"), rs.getString("lastName"), rs.getString("country"), rs.getString("address"));
                personList.add(p);
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
        
        return personList;
    }
}
