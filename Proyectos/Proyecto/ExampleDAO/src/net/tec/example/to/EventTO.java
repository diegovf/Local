/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package net.tec.example.to;

import java.sql.Date;

/**
 *
 * @author diego
 */
public class EventTO {
    private int id;
    private String genero;
    private Date fechaInicio;
    private Date fechaFin;
    private int capacidad;
    private String instalacion;
    private int metrica;
    private String deporte;
    private int tipoCompetidor;
    
    public EventTO(){
        this.id = 0;
        this.genero = "";
        this.fechaInicio = null;
        this.fechaFin = null;
        this.capacidad = 0;
        this.instalacion = "";
        this.metrica = 0;
        this.deporte = "";
        this.tipoCompetidor = 0;
    }
    
    public EventTO(int id, String genero, Date fechaInicio, Date fechaFin, int capacidad, String instalacion, int metrica, String deporte, int tipo) {
        this.id = id;
        this.genero = genero;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
        this.capacidad = capacidad;
        this.instalacion = instalacion;
        this.metrica = metrica;
        this.deporte = deporte;
        this.tipoCompetidor = tipo;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public Date getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(Date fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public Date getFechaFin() {
        return fechaFin;
    }

    public void setFechaFin(Date fechaFin) {
        this.fechaFin = fechaFin;
    }

    public int getCapacidad() {
        return capacidad;
    }

    public void setCapacidad(int capacidad) {
        this.capacidad = capacidad;
    }

    public String getInstalacion() {
        return instalacion;
    }

    public void setInstalacion(String instalacion) {
        this.instalacion = instalacion;
    }

    public int getMetrica() {
        return metrica;
    }

    public void setMetrica(int metrica) {
        this.metrica = metrica;
    }

    public String getDeporte() {
        return deporte;
    }

    public void setDeporte(String deporte) {
        this.deporte = deporte;
    }

    public int getTipoCompetidor() {
        return tipoCompetidor;
    }

    public void setTipoCompetidor(int tipoCompetidor) {
        this.tipoCompetidor = tipoCompetidor;
    }
    
    
    @Override
    public String toString() {
        return "Id=" + id + ", genero=" + genero + ", fechaInicio=" + fechaInicio + ", fechaFin=" + fechaFin + ", capacidad=" + capacidad + ", instalacion=" + instalacion + ", metrica=" + metrica + ", deporte=" + deporte + ",tipoCompetidor=" + tipoCompetidor;
    }
    
    
    
}
