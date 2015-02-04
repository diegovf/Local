/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package graficarordenamiento;

/**
 *
 * @author diego
 */
public class Nodo {
    int dato;
    Nodo next;
    Nodo ant;
    Nodo(int val){
        this.dato = val;
        this.next = null;
        this.ant = null;
    }
}
