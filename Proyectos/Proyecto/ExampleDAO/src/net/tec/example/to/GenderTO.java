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
public class GenderTO {
    private String id;
    private String genero;
    
    public GenderTO(){
        this.id = "";
        this.genero = "";
    }
    
    public GenderTO(String id, String genero) {
        this.id = id;
        this.genero = genero;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    @Override
    public String toString() {
        return "Id=" + id + ", genero=" + genero + '}';
    }
    
    
}
