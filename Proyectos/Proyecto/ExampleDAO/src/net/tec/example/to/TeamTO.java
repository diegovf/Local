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
public class TeamTO {
    private int id;
    private String nombre;
    private String genero;
    private int telefono;
    private String correo;
    private String entrenador;
    private int idCompetidor;
    
    public TeamTO() {
        this.id = 0;
        this.nombre = "";
        this.genero = "";
        this.telefono = 0;
        this.correo = "";
        this.entrenador = "";
        this.idCompetidor = 0;
    }
    
    public TeamTO(int id, String nombre, String genero, int telefono, String correo, String entrenador, int idCompetidor) {
        this.id = id;
        this.nombre = nombre;
        this.genero = genero;
        this.telefono = telefono;
        this.correo = correo;
        this.entrenador = entrenador;
        this.idCompetidor = idCompetidor;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public int getTelefono() {
        return telefono;
    }

    public void setTelefono(int telefono) {
        this.telefono = telefono;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
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
        return "id=" + id + ", nombre=" + nombre + ", genero=" + genero + ", telefono=" + 
                telefono + ", correo=" + correo + ", entrenador=" + entrenador + ", idCompetidor=" + idCompetidor;
    }
    
    
}
