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
import net.tec.example.to.GenderTO;

/**
 *
 * @author diego
 */
public class SQLServerGenderDAO implements GenderDAO{
    public SQLServerGenderDAO(){}
    // Implement insert metric here.
    // Return newly created metric number or a -1 on error
    @Override
    public int insertGender(GenderTO gender) {
        Connection conn = null;
        PreparedStatement stmt;
        int rowCount = 0;
        try{
            conn = SQLServerDAOFactory.createConnection();
            stmt = conn.prepareStatement("Insert Into Generos Values (?, ?)");
            stmt.setString(1, gender.getId());
            stmt.setString(2, gender.getGenero());
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
    public boolean deleteGender(int id) {
        Connection conn = null;
        PreparedStatement stmt;
        boolean state = true;
        try{  
            conn = SQLServerDAOFactory.createConnection();
            stmt = conn.prepareStatement("Delete From Generos Where id = ?");
            stmt.setInt(1, id);
            state = stmt.executeUpdate() == 1; 
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
        return state;
    }
    
    // Implement find a person here using supplied argument values as search criteria
    // Return a Transfer Object if found, return null on error or if not found
    @Override
    public GenderTO findGender(int id) {
        Connection conn = null;
        PreparedStatement stmt;
        ResultSet rs;
        GenderTO gender = null;
        
        try{  
            conn = SQLServerDAOFactory.createConnection();
            stmt = conn.prepareStatement("SELECT * FROM Generos Where id = ?");
            stmt.setInt(1, id);
            rs = stmt.executeQuery();
            rs.next();
            gender = new GenderTO(rs.getString("id"), rs.getString("genero"));
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
        
        return gender;
    }

    // Implement update record here using data from the personData Transfer Object
    // Return true on success, false on failure or error
    @Override
    public boolean updateGender(GenderTO gender) {
        Connection conn = null;
        PreparedStatement stmt;
        boolean rpta = false;
        try{  
            conn = SQLServerDAOFactory.createConnection();
            stmt = conn.prepareStatement("Update Generos Set gendero=? where id=?");
            stmt.setString(1, gender.getGenero());
            stmt.setString(2,gender.getId());
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
    public Collection selectGenderTO() {
        
        Connection conn = null;
        PreparedStatement stmt;
        ResultSet rs;
        Collection genderList = null;
        GenderTO p;
        
        try{  
            conn = SQLServerDAOFactory.createConnection();
            stmt = conn.prepareStatement("SELECT * FROM Generos");
            rs = stmt.executeQuery();
            
            genderList = new ArrayList();
            
            while(rs.next()){
                p = new GenderTO(rs.getString("id"), rs.getString("genero"));
                genderList.add(p);
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
        
        return genderList;
    }
}
