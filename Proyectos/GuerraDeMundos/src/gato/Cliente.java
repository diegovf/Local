/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package gato;

import java.io.*;
import java.net.*;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Diego
 */
public class Cliente {
public static final String IP_SERVER = "localhost"; //IP del Servidor
   JuegoGato ventanaCliente; // Ventana del cliente
   DataInputStream entrada = null;//leer comunicacion
   DataOutputStream salida = null;//escribir comunicacion
   Socket cliente = null;//para la comunicacion
   
   String nomCliente;// nombre del user
   /** Creates a new instance of Cliente */
   public Cliente(JuegoGato vent) throws IOException
   {      
      this.ventanaCliente=vent;
   }
   
   public void conexion() throws IOException 
   {
       System.out.println("-1");
      try {
          System.out.println("0");
          // se conecta con dos sockets al server, uno comunicacion otro msjes
         cliente = new Socket(IP_SERVER, 2307);
         // inicializa las entradas-lectura y salidas-escritura
         System.out.println("1. trying");
         entrada = new DataInputStream(cliente.getInputStream());
         System.out.println("2");
         salida = new DataOutputStream(cliente.getOutputStream());
         System.out.println("3");
         // solicita el nombre del user
         nomCliente = JOptionPane.showInputDialog("Introducir Nick :");
         //Lo coloca en la ventana
         ventanaCliente.setTitle(nomCliente);
         // es lo primero que envia al server
         // el thread servidor esta pendiente de leer el nombre antes de entrar
         // al while para leer opciones
         salida.writeUTF(nomCliente);
         System.out.println("1. Envia el nombre del cliente: "+nomCliente);
      } catch (IOException e) {
         System.out.println("\tEl servidor no esta levantado");
         System.out.println("\t=============================");
      }
      // solo se le pasa entrada pues es solo para leer mensajes
      // el hiloCliente lee lo que el servidor le envia, opciones y como tiene referencia
      // a la ventana gato puede colocar en la pantalla cualquier cosa, como las
      //imagenes de X o O, llamar a metodo marcar, colocar el nombre de enemigo
      // o el suyo propio
      new threadCliente(entrada, ventanaCliente).start();
   }
   
   //GETTET AND SETTER
   public String getNombre()
   {
      return nomCliente;
   }
}
