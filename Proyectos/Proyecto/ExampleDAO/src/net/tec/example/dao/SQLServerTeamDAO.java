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
import net.tec.example.to.SportTO;
import net.tec.example.to.TeamTO;

/**
 *
 * @author diego
 */
public class SQLServerTeamDAO implements TeamDAO{
    public SQLServerTeamDAO(){ }

    @Override
    public int insertTeam(TeamTO team) {
        Connection conn = null;
        PreparedStatement stmt;
        int rowCount = 0;
        try{
            conn = SQLServerDAOFactory.createConnection();
            stmt = conn.prepareStatement("Insert Into Equipos Values (?, ?, ?, ?, ?, ?, ?)");
            stmt.setInt(1, team.getId());
            stmt.setString(2, team.getNombre());
            stmt.setString(3, team.getGenero());
            stmt.setInt(4, team.getTelefono());
            stmt.setString(5, team.getCorreo());
            stmt.setString(6, team.getEntrenador());
            stmt.setInt(7, team.getIdCompetidor());
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

    @Override
    public boolean deleteTeam(String id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public SportTO findTeam(String id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean updateTeam(TeamTO sp) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Collection selectTeamTO() {
        Connection conn = null;
        PreparedStatement stmt;
        ResultSet rs;
        Collection teamList = null;
        TeamTO team;
        
        try{  
            conn = SQLServerDAOFactory.createConnection();
            stmt = conn.prepareStatement("SELECT * FROM Equipos");
            rs = stmt.executeQuery();
            
            teamList = new ArrayList();
            
            while(rs.next()){
                team = new TeamTO(rs.getInt("id"), rs.getString("nombreEquipo"), rs.getString("idGenero"), 
                rs.getInt("telefonoContacto"), rs.getString("correoContacto"), rs.getString("nombreEntrenador"), rs.getInt("idCompetidor"));
                teamList.add(team);
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
        
        return teamList;
    }
}
