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
public class CompetitorTO {
    private int id;
    private String codigoISO;
    private String alojamiento;
    private int tipoCompetidor;
    
    public CompetitorTO() {
        this.id = 0;
        this.codigoISO = "";
        this.alojamiento = "";
        this.tipoCompetidor = 0;
    }
    
    public CompetitorTO(int id, String codigoISO, String alojamiento, int tipo) {
        this.id = id;
        this.codigoISO = codigoISO;
        this.alojamiento = alojamiento;
        this.tipoCompetidor = tipo;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCodigoISO() {
        return codigoISO;
    }

    public void setCodigoISO(String codigoISO) {
        this.codigoISO = codigoISO;
    }

    public String getAlojamiento() {
        return alojamiento;
    }

    public void setAlojamiento(String alojamiento) {
        this.alojamiento = alojamiento;
    }

    public int getTipoCompetidor() {
        return tipoCompetidor;
    }

    public void setTipoCompetidor(int tipoCompetidor) {
        this.tipoCompetidor = tipoCompetidor;
    }
    
    @Override
    public String toString() {
        return "id=" + id + ", codigoISO=" + codigoISO + ", alojamiento=" + alojamiento + ",tipoCompetidor=" + tipoCompetidor;
    }
    
    
}
