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
public class IndividualTO {
    private int cedula;
    private String nombre;
    private String apellidos;
    private Date fechaNacimiento;
    private int edad;
    private String genero;
    private String ocupacion;
    private String ciudad;
    private String entrenador;
    private int idCompetidor;
    
    public IndividualTO() {
        this.cedula = 0;
        this.nombre = "";
        this.apellidos = "";
        this.fechaNacimiento = null;
        this.edad = 0;
        this.genero = "";
        this.ocupacion = "";
        this.ciudad = "";
        this.entrenador = "";
        this.idCompetidor = 0;
    }
    
    public IndividualTO(int cedula, String nombre, String apellidos, Date fechaNacimiento, int edad, String genero, String ocupacion, String ciudad, String entrenador, int idCompetidor) {
        this.cedula = cedula;
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.fechaNacimiento = fechaNacimiento;
        this.edad = edad;
        this.genero = genero;
        this.ocupacion = ocupacion;
        this.ciudad = ciudad;
        this.entrenador = entrenador;
        this.idCompetidor = idCompetidor;
    }

    public int getCedula() {
        return cedula;
    }

    public void setCedula(int cedula) {
        this.cedula = cedula;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public Date getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(Date fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public String getOcupacion() {
        return ocupacion;
    }

    public void setOcupacion(String ocupacion) {
        this.ocupacion = ocupacion;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public String getEntrenador() {
        return entrenador;
    }

    public void setEntrenador(String entrenador) {
        this.entrenador = entrenador;
    }

    public int getIdCompetidor() {
        return idCompetidor;
    }

    public void setIdCompetidor(int idCompetidor) {
        this.idCompetidor = idCompetidor;
    }

    @Override
    public String toString() {
        return "cedula=" + cedula + ", nombre=" + nombre + ", apellidos=" + apellidos + 
                ", fechaNacimiento=" + fechaNacimiento + ", edad=" + edad + ", genero=" + genero + 
                ", ocupacion=" + ocupacion + ", ciudad=" + ciudad + ", entrenador=" + entrenador + 
                ", idCompetidor=" + idCompetidor;
    }
    
    
    
}
