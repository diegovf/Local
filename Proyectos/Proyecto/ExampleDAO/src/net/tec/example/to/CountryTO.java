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
public class CountryTO {
    private String codigoISO;
    private String nombre;
    
    public CountryTO() {
        this.codigoISO = "";
        this.nombre = "";
    }
    
    public CountryTO(String codigoISO, String nombre) {
        this.codigoISO = codigoISO;
        this.nombre = nombre;
    }

    public String getCodigoISO() {
        return codigoISO;
    }

    public void setCodigoISO(String codigoISO) {
        this.codigoISO = codigoISO;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public String toString() {
        return "codigoISO=" + codigoISO + ", nombre=" + nombre;
    }
    
    
    
}
