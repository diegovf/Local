/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package net.tec.example.to;

/**
 *
 * @author diego
 */
public class AccommodationTO {
    private String nombre;
    private String direccion;
    private String facilidades;
    
    public AccommodationTO(String nombre, String direccion, String facilidades) {
        this.nombre = nombre;
        this.direccion = direccion;
        this.facilidades = facilidades;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getFacilidades() {
        return facilidades;
    }

    public void setFacilidades(String facilidades) {
        this.facilidades = facilidades;
    }

    @Override
    public String toString() {
        return "nombre=" + nombre + ", direccion=" + direccion + ", facilidades=" + facilidades;
    }
    
    
}
