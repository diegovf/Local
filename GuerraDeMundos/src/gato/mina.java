/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gato;


public class mina extends Estructura implements Runnable
{
    Thread producir;

    public mina(String nTipo) {
        super(nTipo);
        System.out.println("soy una mina");
        producir = new Thread(this);
        producir.start();
    }

    public void run() {
        
        while(true)
        {
            System.out.println("soy una mina :(");
            
            System.out.println("acero" + JuegoGato.acero);
            try {
                Thread.sleep(2000);
            }catch(InterruptedException e) {}       
           
            JuegoGato.acero = JuegoGato.acero +50;
        
    }
    
   
}
}
