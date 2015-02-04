/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gato;

/**
 *
 * @author Pablo PC
 */
public class Templo extends Estructura
{
    Thread rezar;
    public int tiempoRezo;
    public Templo(String nTipo) {
        super(nTipo);
    }
    
    public void rezando(int tiempo)
    {
        rezar = new Thread();
        tiempoRezo = tiempo;
        rezar.start();
    }
    
    public void run() 
    {
        try {
            while(true)
            {
                Thread.sleep(300);
                int nombre = JuegoGato.getComodines();
                nombre++;
                JuegoGato.setComodines(nombre);
            }
                
            }catch(InterruptedException e) {}
        
        System.out.println("termine de rezar");
    }
}
