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
import net.tec.example.to.AccommodationTO;
import net.tec.example.to.CompetitorTO;

/**
 *
 * @author diego
 */
public class SQLServerCompetitorDAO implements CompetitorDAO{
     public SQLServerCompetitorDAO(){ }
    
    // Implement insert person here.
    // Return newly created person number or a -1 on error
    @Override
    public int insertCompetitor(CompetitorTO cmp) {
        Connection conn = null;
        PreparedStatement stmt;
        int rowCount = 0;
        try{
            conn = SQLServerDAOFactory.createConnection();
            stmt = conn.prepareStatement("Insert Into Competidores Values (?, ?, ?, ?)");
            stmt.setInt(1, cmp.getId());
            stmt.setString(2, cmp.getCodigoISO());
            stmt.setString(3, cmp.getAlojamiento());
            stmt.setInt(4, cmp.getTipoCompetidor());
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
    public boolean deleteCompetitor(int id) {
        Connection conn = null;
        PreparedStatement stmt;
        boolean state = true;
        try{  
            conn = SQLServerDAOFactory.createConnection();
            stmt = conn.prepareStatement("Delete From Competidores Where id = ?");
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
    public CompetitorTO findCompetitor(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    // Implement update record here using data from the personData Transfer Object
    // Return true on success, false on failure or error
    @Override
    public boolean updateCompetitor(CompetitorTO cmp) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
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
    public Collection selectCompetitorTO() {
        
        Connection conn = null;
        PreparedStatement stmt;
        ResultSet rs;
        Collection cmpList = null;
        CompetitorTO cmp;
        
        try{  
            conn = SQLServerDAOFactory.createConnection();
            stmt = conn.prepareStatement("SELECT * FROM Competidores");
            rs = stmt.executeQuery();
            
            cmpList = new ArrayList();
            
            while(rs.next()){
                cmp = new CompetitorTO(rs.getInt("id"), rs.getString("codigoISO"), rs.getString("idAlojamiento"), rs.getInt("tipoCompetidor"));
                cmpList.add(cmp);
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
        
        return cmpList;
    }
}
