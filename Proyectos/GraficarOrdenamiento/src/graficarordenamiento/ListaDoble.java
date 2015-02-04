/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package graficarordenamiento;


public class ListaDoble {
    
    Nodo primero;
    Nodo ultimo;
    ListaDoble(){
        primero = null;
        ultimo = null;
    }
    
    /* Para saber si la lista está vacá*/
    public boolean estaVacio(){
        if (primero == null)
            return true;
        return false;
    }
    
    public void add(int val){
        if (estaVacio()){
            Nodo nuevo = new Nodo(val);
            primero = nuevo;
            ultimo = nuevo;
        }else{
            Nodo nuevo = new Nodo(val);
            ultimo.next = nuevo;
            nuevo.ant = ultimo;
            ultimo = nuevo;
        }
    }
    
    public boolean contains(int val){
        Nodo w = primero;
        boolean sal = false;
        for (int i = 0; i < this.size(); i++){
            if ( w.dato == val)
                sal = true;
            w = w.next;
        }
        return sal;
    }
    
    public int get(int pos){
        Nodo w = primero;
        for (int i = 0; i < pos; i++){
            w = w.next;
        }
        return w.dato;
    }
    
    public void set(int pos, int val){
        Nodo w = primero;
        for (int i = 0; i < pos; i++){
            w = w.next;
        }
        w.dato = val;
    }
    public boolean delete(int val){
        Nodo anterior = null;
        Nodo actual = primero;
        while(actual != null){
            if (actual.dato == val){
                if (anterior == null){
                    primero = actual.next;
                    primero.ant = null;
                }else{
                    if (actual.next == null){
                        actual.ant.next = null;
                        actual.ant = null;
                    }else{
                        anterior.next = actual.next;
                        actual.next.ant = anterior;
                    }
                }
                return true;
            }
            anterior = actual;
            actual = actual.next;
        }
        return false;
    }
    
    public void imprimirLista(){
        if (primero == null)
            System.out.println("La lista está vaciá");
        else{
            Nodo actual = primero;
            while (actual != null){
                System.out.println(actual.dato);
                actual = actual.next;
            }
        }
    }
    
    public void imprimirListaInversa(){
        if (primero == null)
            System.out.println("La lista está vaciá");
        else{
            Nodo actual = ultimo;
            while (actual != null){
                System.out.println(actual.dato);
                actual = actual.ant;
            }
        }
    }
    
    public int size(){
        int tamaño = 0;
        Nodo actual = primero;
        while (actual != null){
            tamaño++;
            actual = actual.next;
        }
        return  tamaño;  
    }
}
