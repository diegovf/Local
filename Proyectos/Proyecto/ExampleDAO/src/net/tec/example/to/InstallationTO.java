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
public class InstallationTO {
    private String nombre;
    private int asientos;
    private String direccion;
    
    public InstallationTO() {
        this.nombre = "";
        this.asientos = 0;
        this.direccion = "";
    }
    
    public InstallationTO(String nombre, int asientos, String direccion) {
        this.nombre = nombre;
        this.asientos = asientos;
        this.direccion = direccion;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getAsientos() {
        return asientos;
    }

    public void setAsientos(int asientos) {
        this.asientos = asientos;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    @Override
    public String toString() {
        return "Nombre=" + nombre + ", capacidad=" + asientos + ", direccion=" + direccion;
    }
    
    
    
}
