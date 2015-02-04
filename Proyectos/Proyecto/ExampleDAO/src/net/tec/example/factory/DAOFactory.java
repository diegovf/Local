/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package net.tec.example.factory;

import net.tec.example.dao.AccommodationDAO;
import net.tec.example.dao.CompetitorDAO;
import net.tec.example.dao.CountryDAO;
import net.tec.example.dao.EventDAO;
import net.tec.example.dao.GenderDAO;
import net.tec.example.dao.IndividualDAO;
import net.tec.example.dao.InstallationDAO;
import net.tec.example.dao.MetricDAO;
import net.tec.example.dao.PersonDAO;
import net.tec.example.dao.SportDAO;
import net.tec.example.dao.TeamDAO;

/**
 *
 * @author AAC
 */

public abstract class DAOFactory {

    // List of DAO types supported by the factory
    public static final int SQLSERVER = 1;
    //public static final int CLOUDSCAPE = 2;
    //public static final int ORACLE = 3;
    //public static final int SYBASE = 4;
    //public static final int MYSQL = 5;

    // There will be a method for each DAO that can be created. The concrete factories will have to implement these methods.
    public abstract PersonDAO getPersonDAO();
    
    public abstract MetricDAO getMetricDAO();
    
    public abstract EventDAO getEventDAO();
    
    public abstract GenderDAO getGenderDAO();
    
    public abstract InstallationDAO getInstallationDAO();
    
    public abstract SportDAO getSportDAO();
    
    public abstract CountryDAO getCountryDAO();
    
    public abstract AccommodationDAO getAccommodationDAO();
    
    public abstract CompetitorDAO getCompetitorDAO();
    
    public abstract IndividualDAO getIndividualDAO();
     
    public abstract TeamDAO getTeamDAO();
    
    public static DAOFactory getDAOFactory(int whichFactory){

        switch(whichFactory){
          case SQLSERVER: 
              return new SQLServerDAOFactory();
          default: 
              return null;
        }
    }
}
