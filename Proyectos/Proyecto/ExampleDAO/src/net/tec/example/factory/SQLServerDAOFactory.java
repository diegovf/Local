/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package net.tec.example.factory;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import net.tec.example.dao.AccommodationDAO;
import net.tec.example.dao.CompetitorDAO;
import net.tec.example.dao.CountryDAO;
import net.tec.example.dao.EventDAO;
import net.tec.example.dao.GenderDAO;
import net.tec.example.dao.IndividualDAO;
import net.tec.example.dao.InstallationDAO;
import net.tec.example.dao.MetricDAO;
import net.tec.example.dao.PersonDAO;
import net.tec.example.dao.SQLServerAccommodationDAO;
import net.tec.example.dao.SQLServerCompetitorDAO;
import net.tec.example.dao.SQLServerCountryDAO;
import net.tec.example.dao.SQLServerEventDAO;
import net.tec.example.dao.SQLServerGenderDAO;
import net.tec.example.dao.SQLServerIndividualDAO;
import net.tec.example.dao.SQLServerInstallationDAO;
import net.tec.example.dao.SQLServerMetricDAO;
import net.tec.example.dao.SQLServerPersonDAO;
import net.tec.example.dao.SQLServerSportDAO;
import net.tec.example.dao.SQLServerTeamDAO;
import net.tec.example.dao.SportDAO;
import net.tec.example.dao.TeamDAO;

/**
 *
 * @author AAC
 */
public class SQLServerDAOFactory extends DAOFactory {
    
    public static final String DRIVER = "com.microsoft.sqlserver.jdbc.SQLServerDriver"; // Ref http://technet.microsoft.com/en-us/library/ms378526.aspx
    public static final String DBURL = "jdbc:sqlserver://localhost;databaseName=JuegosDeportivos;user=sa;password=123;"; // Ref http://technet.microsoft.com/en-us/library/ms378428.aspx

    // Method to create SQLServer connections
    public static Connection createConnection() {
        
        Connection conn = null;
        
        try{
            Class.forName(DRIVER);
            conn = DriverManager.getConnection(DBURL);
            // If there is an error about PORT IP/TCP is not litening in port 1433 (SQL Server 2012), look this link http://msdn.microsoft.com/en-us/library/ms177440.aspx
        } 
        catch(ClassNotFoundException ex){
            System.out.println("Message: " + ex.getMessage());
        } 
        catch(SQLException ex) {
            System.out.println("Message: " + ex.getMessage() + "\n" + "Code: " + ex.getErrorCode());
        }
        
        return conn;
    }
    
    @Override
    public PersonDAO getPersonDAO() {
        
        // SQLServerPersonDAO implements PersonDAO
        return new SQLServerPersonDAO();
    }
    
    @Override
    public MetricDAO getMetricDAO() {
        
        // SQLServerPersonDAO implements PersonDAO
        return new SQLServerMetricDAO();
    }
    
    @Override
    public EventDAO getEventDAO() {
        
        // SQLServerPersonDAO implements PersonDAO
        return new SQLServerEventDAO();
    }
    
    @Override
    public GenderDAO getGenderDAO() {
        
        // SQLServerPersonDAO implements PersonDAO
        return new SQLServerGenderDAO();
    }
    
    @Override
    public InstallationDAO getInstallationDAO() {
        
        // SQLServerPersonDAO implements PersonDAO
        return new SQLServerInstallationDAO();
    }
    
    @Override
    public SportDAO getSportDAO() {
        
        // SQLServerPersonDAO implements PersonDAO
        return new SQLServerSportDAO();
    }
    
    @Override
    public CountryDAO getCountryDAO() {
        
        // SQLServerPersonDAO implements PersonDAO
        return new SQLServerCountryDAO();
    }
    
    @Override
    public AccommodationDAO getAccommodationDAO() {
        
        // SQLServerPersonDAO implements PersonDAO
        return new SQLServerAccommodationDAO();
    }
    
    @Override
    public CompetitorDAO getCompetitorDAO() {
        
        // SQLServerPersonDAO implements PersonDAO
        return new SQLServerCompetitorDAO();
    }
    
    @Override
    public IndividualDAO getIndividualDAO() {
        
        // SQLServerPersonDAO implements PersonDAO
        return new SQLServerIndividualDAO();
    }
    
    @Override
    public TeamDAO getTeamDAO() {
        
        // SQLServerPersonDAO implements PersonDAO
        return new SQLServerTeamDAO();
    }
}


