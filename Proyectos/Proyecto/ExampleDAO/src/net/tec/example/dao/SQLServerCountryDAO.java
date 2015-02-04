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
import net.tec.example.to.CountryTO;

/**
 *
 * @author diego
 */
public class SQLServerCountryDAO implements CountryDAO{
    
    public SQLServerCountryDAO(){ }
    
    // Implement insert person here.
    // Return newly created person number or a -1 on error
    @Override
    public int insertCountry(CountryTO cnt) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    // Implement delete person here
    // Return true on success, false on failure
    @Override
    public boolean deleteCountry() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    // Implement find a person here using supplied argument values as search criteria
    // Return a Transfer Object if found, return null on error or if not found
    @Override
    public CountryTO findCountry(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    // Implement update record here using data from the personData Transfer Object
    // Return true on success, false on failure or error
    @Override
    public boolean updateCountry(CountryTO cnt) {
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
    public Collection selectCountryTO() {
        
        Connection conn = null;
        PreparedStatement stmt;
        ResultSet rs;
        Collection eventList = null;
        CountryTO cnt;
        
        try{  
            conn = SQLServerDAOFactory.createConnection();
            stmt = conn.prepareStatement("SELECT * FROM Paises");
            rs = stmt.executeQuery();
            
            eventList = new ArrayList();
            
            while(rs.next()){
                cnt = new CountryTO(rs.getString("codigoISO"), rs.getString("nombre"));
                eventList.add(cnt);
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
