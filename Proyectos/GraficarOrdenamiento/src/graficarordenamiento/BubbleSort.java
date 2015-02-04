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
public class BubbleSort  extends Thread{
    Graficador g;
    BubbleSort(Graficador g){
        this.g = g;
    }
    
    @Override
    public void run(){
        boolean swapped = true;
        int j = 0;
        int tmp;
        while (swapped) {
            swapped = false;
            j++;
            for (int i = 0; i < g.lista.size() - j; i++) { 
                
                if (g.lista.get(i) > g.lista.get(i+1)) {
                    tmp = g.lista.get(i);
                    
                    g.lista.set(i, g.lista.get(i+1));
                    g.lista.set(i+1, tmp);
                    int s = (g.lista.get(i)+g.lista.get(i+1))*400;
                    
                    g.dataset.addValue(g.lista.get(i),g.dataset.getRowKey(0),g.dataset.getColumnKey(i));
                    g.dataset.addValue(g.lista.get(i+1),g.dataset.getRowKey(0),g.dataset.getColumnKey(i+1));
                    
                    try {
                        SoundUtils.tone(s, 10);
                    } catch (LineUnavailableException ex) {
                        Logger.getLogger(BubbleSort.class.getName()).log(Level.SEVERE, null, ex);
                        
                    }
                     
                    swapped = true;
                    
                    try {
                        Thread.sleep(g.tiempo);
                    } catch (InterruptedException ex){
                        Logger.getLogger(BubbleSort.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
                
            }                
        }
    } 
}
