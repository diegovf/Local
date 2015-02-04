/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gato;

import static gato.JuegoGato.tableroLogico;
import java.util.ArrayList;

/**
 *
 * @author Pablo PC
 */
public class Estructura {

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public ArrayList<Estructura> getConectores() {
        return conectores;
    }

    public void setConectores(ArrayList<Estructura> conectores) {
        this.conectores = conectores;
    }
    

    
    
    public  ArrayList<Estructura> getEstructurasMundos(Estructura [][] tableroEvaluar)
    {
        ArrayList<Estructura> mundos = new ArrayList();
         for(int i =0; i<15 ;i++)
         {
            for(int j =0; j<15 ;j++)
            {
                if(tableroEvaluar[i][j]==null)
                {
                    //System.out.println("sot un null de mierda");
                } else {
                    //System.out.println("este es el tipo de esta  estructura" + tableroEvaluar[i][j].getTipo());
                    if(tableroEvaluar[i][j].getTipo().equals("mundo") && !mundos.contains(tableroEvaluar[i][j]))
                    {
                    //System.out.println("he encontrado un mundo");
                    mundos.add(tableroEvaluar[i][j]);
                    }
                        }
            }
          }
           //System.out.println("este es el tamaño de los mundos" + mundos.size());
          return mundos;
    }
    
     public boolean alcanza(Estructura est)
    {
        if(this.alcanzaAux(est) == Boolean.TRUE)
        {
                for(int i =0; i==15 ;i++)
            {
                for(int j =0; j==15 ;j++)
                {
                       if(tableroFinal[i][j] != null)
                           tableroFinal[i][j].visitado = false;
                }
            }
            return true;
        }
        else
        {
               for(int i =0; i==15 ;i++)
            {
                for(int j =0; j==15 ;j++)
                {
                       if(tableroFinal[i][j] != null)
                           tableroFinal[i][j].visitado = false;;
                }
            }
            return false ;
        }
    }
    
    public Boolean alcanzaAux(Estructura aAlcanzar)
    {
        System.out.println("soy la estructura a evaluar" + aAlcanzar + this + "...." + this.visitado);
        for(int i = 0; i< this.conectores.size();i++)
        {
            System.out.println("soy un conector..." + this.conectores.get(i));
        }
        if(this.conectores.contains(aAlcanzar))
            return Boolean.TRUE;
        if(this.conectores.isEmpty())
            return Boolean.FALSE;
        if(this.isVisitado())
            return Boolean.FALSE;
        //this.visitado = true;
        if(this.equals(aAlcanzar))
            return Boolean.TRUE;
        Boolean aRetornar = Boolean.FALSE;
        ArrayList<Boolean> list =  new ArrayList<Boolean>();
        for(Estructura estructura : conectores)
        {
            System.out.println("me fui una vez mas...." + estructura);
            list.add(estructura.alcanza(aAlcanzar));
        }
        for(Boolean bool : list)
        {
            if(bool == Boolean.TRUE)
            {
                aRetornar = Boolean.TRUE;
                break;
            }
        }
        return aRetornar;
    }

    public boolean conectadaAMundo()
    {
        for(Estructura mundo : getEstructurasMundos(tableroLogico))
        {
            for(int i = 0;i < mundo.getConectores().size();i++)
            {
                System.out.println("soy uno de los MAES..." + mundo.getConectores().get(i));
            }
            
            if(mundo.alcanza(this))
            {               
                return true;
            }
            
        }
        //System.out.println("este es el tamaño de lista mundos" + getEstructurasMundos(tableroLogico).size());
        return false;
    }
   
    public void enseñarEstructura(int enseñarPara,Estructura [][] tableroLogico)
    {
        tableroFinal = tableroLogico;
        if(!conectadaAMundo())
        {
            System.out.println("tantas estructuras no estaban conectadas al mundo");
            if(enseñarPara == 1)            
                this.visibleUno = true;           
            else if(enseñarPara == 2)
                this.visibleDos = true;
            else if(enseñarPara == 3)
                this.visibleTres = true;
            else if(enseñarPara == 4)
                this.visibleCuatro = true;
        }
            
        for(Estructura estructura : conectores)
        {
            estructura.enseñarEstructura(enseñarPara,tableroLogico);
        }
    }
    
    public void esconderEstructura(int enseñarPara,Estructura [][] tableroLogico)
    {
        //agregar ifs
        //this.visible = true;
        for(Estructura estructura : conectores)
            estructura.enseñarEstructura(enseñarPara,tableroLogico);
    }
    
    public boolean isVisitado() {
        return visitado;
    }

    public void setVisitado(boolean visitado) {
        this.visitado = visitado;
    }
    
    private String tipo;
    private ArrayList<Estructura> conectores = new ArrayList();
    private boolean visibleUno;

    public boolean isVisibleUno() {
        return visibleUno;
    }

    public void setVisibleUno(boolean visibleUno) {
        this.visibleUno = visibleUno;
    }

    public boolean isVisibleDos() {
        return visibleDos;
    }

    public void setVisibleDos(boolean visibleDos) {
        this.visibleDos = visibleDos;
    }

    public boolean isVisibleTres() {
        return visibleTres;
    }

    public void setVisibleTres(boolean visibleTres) {
        this.visibleTres = visibleTres;
    }

    public boolean isVisibleCuatro() {
        return visibleCuatro;
    }

    public void setVisibleCuatro(boolean visibleCuatro) {
        this.visibleCuatro = visibleCuatro;
    }
    Estructura [][] tableroFinal;
    private boolean visibleDos;
    private boolean visibleTres;
    private boolean visibleCuatro;
    private boolean visitado = false;
    
    public Estructura(String nTipo)
    {
        tipo = nTipo;
        conectores = new ArrayList();
        visibleUno = false;
        visibleDos = false;
        visibleTres = false;
        visibleCuatro = false;
    }

    
   
}
