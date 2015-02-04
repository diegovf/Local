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
public class MetricTO {

    
    private int id;
    private String metrica;
    private Double minimo;
    private Double maximo;
    
    public MetricTO() {
        this.id = 0;
        this.metrica = "";
        this.minimo = 0.0;
        this.maximo = 0.0;
    }
    
    public MetricTO(int id, String metrica, Double minimo, Double maximo) {
        this.id = id;
        this.metrica = metrica;
        this.minimo = minimo;
        this.maximo = maximo;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMetrica() {
        return metrica;
    }

    public void setMetrica(String metrica) {
        this.metrica = metrica;
    }

    public Double getMinimo() {
        return minimo;
    }

    public void setMinimo(Double minimo) {
        this.minimo = minimo;
    }

    public Double getMaximo() {
        return maximo;
    }

    public void setMaximo(Double maximo) {
        this.maximo = maximo;
    }
    
    

    @Override
    public String toString() {
        return "Id=" + id + ", metrica=" + metrica + ", minimo=" + minimo + ", maximo=" + maximo;
    }
    
    
}
