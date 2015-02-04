/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package graficarordenamiento;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.sound.sampled.LineUnavailableException;

public class QuickSort extends Thread {
  private int tamaño;
  
  Graficador g;
    QuickSort(Graficador g){
        this.g = g;
    }

  @Override
  public void run(){
    tamaño = g.lista.size();
    quicksort(0, tamaño - 1);
  }

  private void quicksort(int low, int high) {
    int i = low, j = high;
    // Get the pivot element from the middle of the list
    int pivote = g.lista.get(low + (high-low)/2);

    // Divide into two lists
    while (i <= j) {
      // If the current value from the left list is smaller then the pivot
      // element then get the next element from the left list
      while (g.lista.get(i) < pivote) {
        i++;
      }
      // If the current value from the right list is larger then the pivot
      // element then get the next element from the right list
      while (g.lista.get(j) > pivote) {
        j--;
      }

      // If we have found a values in the left list which is larger then
      // the pivot element and if we have found a value in the right list
      // which is smaller then the pivot element then we exchange the
      // values.
      // As we are done we can increase i and j
      if (i <= j) {
        exchange(i, j);
        i++;
        j--;
      }
    }
    // Recursion
    if (low < j)
      quicksort(low, j);
    if (i < high)
      quicksort(i, high);
  }

  private void exchange(int i, int j) {
    int temp = g.lista.get(i);
    g.lista.set(i, g.lista.get(j));
    g.dataset.addValue(g.lista.get(i),g.dataset.getRowKey(0),g.dataset.getColumnKey(i));
    try {
        SoundUtils.tone(g.lista.get(i)*400, 10);
    } catch (LineUnavailableException ex) {
        Logger.getLogger(BubbleSort.class.getName()).log(Level.SEVERE, null, ex);
    }
    
    
    g.lista.set(j, temp);
    try {
        SoundUtils.tone(g.lista.get(j)*400, 10);
    } catch (LineUnavailableException ex) {
        Logger.getLogger(BubbleSort.class.getName()).log(Level.SEVERE, null, ex);
    }
    g.dataset.addValue(g.lista.get(j),g.dataset.getRowKey(0),g.dataset.getColumnKey(j)); 
    
    try {
        Thread.sleep(g.tiempo);
    } catch (InterruptedException ex) {
        Logger.getLogger(QuickSort.class.getName()).log(Level.SEVERE, null, ex);
    }
  }
} 