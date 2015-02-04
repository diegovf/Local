/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package net.tec.example.client;

import java.util.Collection;
import java.util.Date;
import net.tec.example.dao.AccommodationDAO;
import net.tec.example.dao.CompetitorDAO;
import net.tec.example.dao.CountryDAO;
import net.tec.example.dao.EventDAO;
import net.tec.example.dao.GenderDAO;
import net.tec.example.dao.IndividualDAO;
import net.tec.example.dao.InstallationDAO;
import net.tec.example.dao.MetricDAO;
import net.tec.example.dao.SportDAO;
import net.tec.example.dao.TeamDAO;
import net.tec.example.factory.DAOFactory;
import net.tec.example.to.AccommodationTO;
import net.tec.example.to.CompetitorTO;
import net.tec.example.to.CountryTO;
import net.tec.example.to.EventTO;
import net.tec.example.to.GenderTO;
import net.tec.example.to.IndividualTO;
import net.tec.example.to.InstallationTO;
import net.tec.example.to.MetricTO;
import net.tec.example.to.SportTO;
import net.tec.example.to.TeamTO;

/**
 *
 * @author AAC
 */
public class Client {

    public Client() {
    }
    
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        DAOFactory sqlserverFactory = DAOFactory.getDAOFactory(DAOFactory.SQLSERVER);
        MetricDAO metric = sqlserverFactory.getMetricDAO();
        
        System.out.println(metric.deleteMetric(11));
        
        Collection<MetricTO> metricList = metric.selectMetricTO();
        for(MetricTO m : metricList) {
            System.out.println(m.toString());
        }
        /*PersonDAO perDAO = sqlserverFactory.getPersonDAO();
        perDAO.insertPerson();
        
        Collection<PersonTO> personList = perDAO.selectPersonTO();
        for(PersonTO p : personList) {
            System.out.println(p.toString());
        }*/
    }
    
    public int requestInsertMetric(String id, String tipo, String min, String max){
        DAOFactory sqlserverFactory = DAOFactory.getDAOFactory(DAOFactory.SQLSERVER);
        MetricDAO metric = sqlserverFactory.getMetricDAO();
        
        MetricTO m = new MetricTO(Integer.parseInt(id), tipo, Double.parseDouble(min), Double.parseDouble(max));
        return metric.insertMetric(m);
    }
    public boolean requestDeleteMetric(String id){
        DAOFactory sqlserverFactory = DAOFactory.getDAOFactory(DAOFactory.SQLSERVER);
        MetricDAO metric = sqlserverFactory.getMetricDAO();
        return metric.deleteMetric(Integer.parseInt(id));
    }
    public String requestFindMetric(String id){
        DAOFactory sqlserverFactory = DAOFactory.getDAOFactory(DAOFactory.SQLSERVER);
        MetricDAO metric = sqlserverFactory.getMetricDAO();
        
        MetricTO m = null;
        System.out.println(id);
        m = metric.findMetric(Integer.parseInt(id));
        if(m == null)
            return "No se encontró ninguna metrica";
        else
            return m.toString();
    }
    public Collection<MetricTO> requestSelectMetricTO(){
        DAOFactory sqlserverFactory = DAOFactory.getDAOFactory(DAOFactory.SQLSERVER);
        MetricDAO metric = sqlserverFactory.getMetricDAO();
        
        return metric.selectMetricTO();
    } 
    public boolean requestUpdateMetric(String id, String tipo, String min, String max){
        DAOFactory sqlserverFactory = DAOFactory.getDAOFactory(DAOFactory.SQLSERVER);
        MetricDAO metric = sqlserverFactory.getMetricDAO();
        
        MetricTO m = new MetricTO(Integer.parseInt(id), tipo, Double.parseDouble(min), Double.parseDouble(max));
        return metric.updateMetric(m);
    }
    
    // Inicio metodos para realizar las consultas relacionadas con Eventos
    // Insert, Delet, Update, Find, select all
    public int requestInsertEvent(String id, String genero, Date inicio, Date fin, String cap, String inst, String met, String dep, int tipo){
        DAOFactory sqlserverFactory = DAOFactory.getDAOFactory(DAOFactory.SQLSERVER);
        EventDAO event = sqlserverFactory.getEventDAO();
        
        EventTO e = new EventTO(Integer.parseInt(id), genero, new java.sql.Date(inicio.getTime()), 
                new java.sql.Date(fin.getTime()), Integer.parseInt(cap),inst, Integer.parseInt(met), 
                dep, tipo);
        return event.insertEvent(e);
    }
    public boolean requestDeleteEvent(String id){
        DAOFactory sqlserverFactory = DAOFactory.getDAOFactory(DAOFactory.SQLSERVER);
        EventDAO event = sqlserverFactory.getEventDAO();
        return event.deleteEvent(Integer.parseInt(id));
    }
    public Collection<EventTO> requestSelectEventTO(){
        DAOFactory sqlserverFactory = DAOFactory.getDAOFactory(DAOFactory.SQLSERVER);
        EventDAO event = sqlserverFactory.getEventDAO();
        
        return event.selectEventTO();
    }
    public String requestFindEvent(String id){
        DAOFactory sqlserverFactory = DAOFactory.getDAOFactory(DAOFactory.SQLSERVER);
        EventDAO event = sqlserverFactory.getEventDAO();
        
        EventTO m = null;
        m = event.findEvent(Integer.parseInt(id));
        if(m == null)
            return "No se encontró ningun evento";
        else
            return m.toString();
    }
    public boolean requestUpdateEvent(String id, String genero, Date inicio, Date fin, String cap, String inst, String met, String dep, int tipo){
        DAOFactory sqlserverFactory = DAOFactory.getDAOFactory(DAOFactory.SQLSERVER);
        EventDAO event = sqlserverFactory.getEventDAO();
        
        EventTO e = new EventTO(Integer.parseInt(id), genero, new java.sql.Date(inicio.getTime()), 
                new java.sql.Date(fin.getTime()), Integer.parseInt(cap), inst, Integer.parseInt(met), 
                dep, tipo);
        return event.updateEvent(e);
    }
    //Fin metodos para realizar las consultas relacionadas con Eventos
    
    // Inicio metodos para realizar las consultas relacionadas con Generos
    // Insert, Delet, Update, Find, select all
    public Collection<GenderTO> requestSelectGenderTO(){
        DAOFactory sqlserverFactory = DAOFactory.getDAOFactory(DAOFactory.SQLSERVER);
        GenderDAO gender = sqlserverFactory.getGenderDAO();
        
        return gender.selectGenderTO();
    }
    //Fin metodos para realizar las consultas relacionadas con Generos
    
    // Inicio metodos para realizar las consultas relacionadas con Instalaciones
    // Insert, Delet, Update, Find, select all
    public Collection<InstallationTO> requestSelectInstallationTO(){
        DAOFactory sqlserverFactory = DAOFactory.getDAOFactory(DAOFactory.SQLSERVER);
        InstallationDAO ins = sqlserverFactory.getInstallationDAO();
        
        return ins.selectInstallationTO();
    }
    
    //Fin metodos para realizar las consultas relacionadas con Instalaciones
    
    // Inicio metodos para realizar las consultas relacionadas con Deportes
    // Insert, Delet, Update, Find, select all
    public Collection<SportTO> requestSelectSportTO(){
        DAOFactory sqlserverFactory = DAOFactory.getDAOFactory(DAOFactory.SQLSERVER);
        SportDAO sp = sqlserverFactory.getSportDAO();
        
        return sp.selectSportTO();
    }
    //Fin metodos para realizar las consultas relacionadas con Deportes
    
    // Inicio metodos para realizar las consultas relacionadas con Paises
    // Insert, Delet, Update, Find, select all
    public Collection<CountryTO> requestSelectCountryTO(){
        DAOFactory sqlserverFactory = DAOFactory.getDAOFactory(DAOFactory.SQLSERVER);
        CountryDAO metric = sqlserverFactory.getCountryDAO();
        
        return metric.selectCountryTO();
    }
    //Fin metodos para realizar las consultas relacionadas con Paises
    
    // Inicio metodos para realizar las consultas relacionadas con Alojamientos
    // Insert, Delet, Update, Find, select all
    public Collection<AccommodationTO> requestSelectAccommodationTO(){
        DAOFactory sqlserverFactory = DAOFactory.getDAOFactory(DAOFactory.SQLSERVER);
        AccommodationDAO metric = sqlserverFactory.getAccommodationDAO();
        
        return metric.selectAccommodationTO();
    }
    //Fin metodos para realizar las consultas relacionadas con Alojamientos
    
    // Inicio metodos para realizar las consultas relacionadas con Competidores
    // Insert, Delet, Update, Find, select all
    public int requestInsertCompetitor(String id, String codigoISO, String alojamiento, int tipo){
        DAOFactory sqlserverFactory = DAOFactory.getDAOFactory(DAOFactory.SQLSERVER);
        CompetitorDAO comp = sqlserverFactory.getCompetitorDAO();
        
        CompetitorTO cmp = new CompetitorTO(Integer.parseInt(id), codigoISO, alojamiento, tipo);
        return comp.insertCompetitor(cmp);
    }
    public boolean requestDeleteCompetitor(String id){
        DAOFactory sqlserverFactory = DAOFactory.getDAOFactory(DAOFactory.SQLSERVER);
        CompetitorDAO cmp = sqlserverFactory.getCompetitorDAO();
        return cmp.deleteCompetitor(Integer.parseInt(id));
    }
    //Fin metodos para realizar las consultas relacionadas con Competidores
    
    // Inicio metodos para realizar las consultas relacionadas con Individuos
    // Insert, Delet, Update, Find, select all
    public int requestInsertIndividual(String ced, String nombre, String apellidos, Date naci, String edad, String genero,
            String ocupacion, String ciudad, String entrenador, String idComp){
        DAOFactory sqlserverFactory = DAOFactory.getDAOFactory(DAOFactory.SQLSERVER);
        IndividualDAO ind = sqlserverFactory.getIndividualDAO();
        
        IndividualTO individuo = new IndividualTO(Integer.parseInt(ced), nombre, apellidos, new java.sql.Date(naci.getTime()),
        Integer.parseInt(edad), genero, ocupacion, ciudad, entrenador, Integer.parseInt(idComp));
        return ind.insertIndividual(individuo);
    }
    public Collection<IndividualTO> requestSelectIndividualTO(){
        DAOFactory sqlserverFactory = DAOFactory.getDAOFactory(DAOFactory.SQLSERVER);
        IndividualDAO sp = sqlserverFactory.getIndividualDAO();
        
        return sp.selectIndividualTO();
    }
    public IndividualTO requestFindIndividual(String id){
        DAOFactory sqlserverFactory = DAOFactory.getDAOFactory(DAOFactory.SQLSERVER);
        IndividualDAO sp = sqlserverFactory.getIndividualDAO();
        
        return sp.findIndividual(Integer.parseInt(id));
    }
    //Fin metodos para realizar las consultas relacionadas con Individuos
    
    // Inicio metodos para realizar las consultas relacionadas con Equipos
    // Insert, Delet, Update, Find, select all
    public int requestInsertTeam(String id, String nombreEquipo, String genero,  String telefono, 
            String correo, String entrenador, String idCompetidor){
        DAOFactory sqlserverFactory = DAOFactory.getDAOFactory(DAOFactory.SQLSERVER);
        TeamDAO ind = sqlserverFactory.getTeamDAO();
        
        TeamTO team = new TeamTO(Integer.parseInt(id), nombreEquipo, genero, 
                Integer.parseInt(telefono), correo, entrenador, Integer.parseInt(idCompetidor));
        return ind.insertTeam(team);
    }
    public Collection<TeamTO> requestSelectTeamTO(){
        DAOFactory sqlserverFactory = DAOFactory.getDAOFactory(DAOFactory.SQLSERVER);
        TeamDAO sp = sqlserverFactory.getTeamDAO();
        
        return sp.selectTeamTO();
    }
    //Fin metodos para realizar las consultas relacionadas con Individuos
}
