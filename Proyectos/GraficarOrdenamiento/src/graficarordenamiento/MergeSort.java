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
public class MergeSort extends Thread{
    
    int tam;
    final String BLANKS = "  "; // A String of two blanks
    Graficador g;
    ListaDoble temp;
    
    MergeSort(Graficador g){
        this.g = g;
        temp = new ListaDoble();
    }
    
    @Override
    public void run(){
        tam = g.lista.size();
        mergesort(g.lista, 0, g.lista.size());
        g.lista.imprimirLista();
    }
   
   public void mergesort(ListaDoble data, int first, int n)
   {
      int n1; // Size of the first half of the array
      int n2; // Size of the second half of the array

      if (n > 1)
      {
         // Compute sizes of the two halves
         n1 = n / 2;
         n2 = n - n1;

         mergesort(data, first, n1);      // Sort data[first] through data[first+n1-1]
         mergesort(data, first + n1, n2); // Sort data[first+n1] to the end

         // Merge the two sorted halves.
         merge(data, first, n1, n2);
         
      }
   } 
  
   private void merge(ListaDoble data, int first, int n1, int n2)
   {
      
      for (int i = 0; i < (n1+n2); i++){
          temp.add(0);
      }
      int copied  = 0; // Number of elements copied from data to temp
      int copied1 = 0; // Number copied from the first half of data
      int copied2 = 0; // Number copied from the second half of data
      int i;           // Array index to copy from temp back into data

      // Merge elements, copying from two halves of data to the temporary array.
      while ((copied1 < n1) && (copied2 < n2))
      {
         if (data.get(first + copied1) < data.get(first + n1 + copied2)){
            int x = copied;
            int y = copied1;
            temp.set(copied++, data.get(first + (copied1++)));
            
         }else{
            int x = copied;
            int y = copied2;
            temp.set(copied++, data.get(first + n1 + (copied2++)));
            
         }
         try {
              Thread.sleep(10);
          } catch (InterruptedException ex) {
              Logger.getLogger(MergeSort.class.getName()).log(Level.SEVERE, null, ex);
          }
             
      }

      // Copy any remaining entries in the left and right subarrays.
        while (copied1 < n1){
            int x = copied;
            int y = copied1;
            temp.set(copied++, data.get(first + (copied1++)));
            try {
              Thread.sleep(100);
          } catch (InterruptedException ex) {
              Logger.getLogger(MergeSort.class.getName()).log(Level.SEVERE, null, ex);
          }
        }
          
          
        while (copied2 < n2){
            int x = copied;
            int y = copied2;
            temp.set(copied++, data.get(first + n1 + (copied2++)));
           try {
              Thread.sleep(10);
          } catch (InterruptedException ex) {
              Logger.getLogger(MergeSort.class.getName()).log(Level.SEVERE, null, ex);
          }
            
        }
            

      // Copy from temp back to the data array.
      for (i = 0; i < n1+n2; i++){
         data.set(first + i, temp.get(i));
         try {
            SoundUtils.tone(data.get(first + i)*400, 10);
         } catch (LineUnavailableException ex) {
            Logger.getLogger(BubbleSort.class.getName()).log(Level.SEVERE, null, ex);
         }
         
         g.dataset.addValue(temp.get(i),g.dataset.getRowKey(0),g.dataset.getColumnKey(first + i));
         
          try {
              Thread.sleep(g.tiempo);
          } catch (InterruptedException ex) {
              Logger.getLogger(MergeSort.class.getName()).log(Level.SEVERE, null, ex);
          }
      }
         
            
   }
   
}