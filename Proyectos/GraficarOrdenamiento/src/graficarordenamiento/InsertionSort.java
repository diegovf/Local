
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package graficarordenamiento;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.sound.sampled.LineUnavailableException;

/**
 *
 * @author diego
 */

public class InsertionSort extends Thread{
    Graficador g;
    InsertionSort(Graficador g){
        this.g = g;  
    }
    
    @Override
    public void run(){
        int i, j, nuevo;
        for (i = 1; i < g.lista.size(); i++) {
            nuevo = g.lista.get(i);
            j = i;
            while (j > 0 && g.lista.get(j - 1) > nuevo) {
                g.lista.set(j, g.lista.get(j - 1));
                g.dataset.addValue(g.lista.get(j),g.dataset.getRowKey(0),g.dataset.getColumnKey(j));
                try {
                    SoundUtils.tone(g.lista.get(j)*400, 10);
                } catch (LineUnavailableException ex) {
                    Logger.getLogger(BubbleSort.class.getName()).log(Level.SEVERE, null, ex);
                }
                g.dataset.addValue(nuevo,g.dataset.getRowKey(0),g.dataset.getColumnKey(j-1));
                try {
                    SoundUtils.tone(nuevo*400, 10);
                } catch (LineUnavailableException ex) {
                    Logger.getLogger(BubbleSort.class.getName()).log(Level.SEVERE, null, ex);
                }
                j--;
                try {
                    Thread.sleep(g.tiempo);
                } catch (InterruptedException ex){
                    Logger.getLogger(BubbleSort.class.getName()).log(Level.SEVERE, null, ex);
                }
                  
            }
            g.lista.set(j, nuevo);
            g.dataset.addValue(g.lista.get(j),g.dataset.getRowKey(0),g.dataset.getColumnKey(j));
            
            
        }
    }
}