/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Servidor;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Diego
 */
public class ServidorGato {
    
    JFrameServidor ventana;
    Socket cliente1;
    Socket cliente2;
    Socket cliente3;
    Socket cliente4;
    public boolean prueba = false;
    public static boolean empezemos = false;
    public static int opcionJugadores = 0;

    
    public ArrayList<threadServidor> hilosserver;
    
    public ServidorGato(JFrameServidor padre)
    {
        // asigna la ventana
        this.ventana = padre;
    }
    
    public void runServer() throws InterruptedException
    {
        while(true)
        {
         //System.out.println(opcionJugadores); 
            Thread.sleep(2);
        try {
            
            if(opcionJugadores == 2)
            {
            //crea el socket servidor para aceptar dos conexiones
            ServerSocket serv = new ServerSocket(2307);
            ventana.mostrar(".::Servidor Activo");
            ventana.mostrar(".::Esperando dos usuarios");
            
            // espera primer cliente
            cliente1 = serv.accept();
            ventana.mostrar(".::Primer Cliente Aceptado");
            threadServidor user1 = new threadServidor(cliente1, this,1,2);
            user1.start();
            System.out.println("hasta aqui si llega");
            
            cliente2 = serv.accept();
            ventana.mostrar(".::Segundo Cliente Aceptado");
            threadServidor user2 = new threadServidor(cliente2, this,2,2);
            user2.start();
             
            user1.enemigo = user2;
            user2.enemigo = user1;
         
            }
            else if(opcionJugadores == 3)
            {
                ServerSocket serv = new ServerSocket(2307);
                ventana.mostrar(".::Servidor Activo");
                ventana.mostrar(".::Esperando tres usuarios");

                // espera primer cliente
                cliente1 = serv.accept();
                ventana.mostrar(".::Primer Cliente Acepta"
                        + "do");
                threadServidor user1 = new threadServidor(cliente1, this,1,opcionJugadores);
                user1.start();
                System.out.println("hasta aqui si llega");

                cliente2 = serv.accept();
                ventana.mostrar(".::Segundo Cliente Aceptado");
                threadServidor user2 = new threadServidor(cliente2, this,2,opcionJugadores);
                user2.start();

                System.out.println("hasta aqui si llega");
                cliente3 = serv.accept();
                ventana.mostrar(".::Tercer Cliente Aceptado");
                threadServidor user3 = new threadServidor(cliente3, this,3,opcionJugadores);
                user3.start();

                user1.enemigo = user2;
                user1.enemigo2 = user3;
                user2.enemigo = user1;
                user2.enemigo2 = user3;
                user3.enemigo = user1;
                user3.enemigo2 = user2;
            
            }
            
            else if(opcionJugadores == 4)
            {
            System.out.println("entro a mae de cuatrooo");
            //crea el socket servidor para aceptar dos conexiones
            ServerSocket serv = new ServerSocket(30000);
            ventana.mostrar(".::Servidor Activo");
            ventana.mostrar(".::Esperando cuatro usuarios");
            
            // espera primer cliente
            cliente1 = serv.accept();
            ventana.mostrar(".::Primer Cliente Aceptado");
            threadServidor user1 = new threadServidor(cliente1, this,1,opcionJugadores);
            user1.start();
            
            cliente2 = serv.accept();
            ventana.mostrar(".::Segundo Cliente Aceptado");
            threadServidor user2 = new threadServidor(cliente2, this,2,opcionJugadores);
            user2.start();
            
            System.out.println("hasta aqui si llega");
            cliente3 = serv.accept();
            ventana.mostrar(".::Tercer Cliente Aceptado");
            threadServidor user3 = new threadServidor(cliente3, this,3,opcionJugadores);
            user3.start();
            
            cliente4 = serv.accept();
            ventana.mostrar(".::Cuarto Cliente Aceptado");
            threadServidor user4 = new threadServidor(cliente4, this,4,opcionJugadores);
            user4.start();
            
            // 
            user1.enemigo = user2;
            user1.enemigo2 = user3;
            user1.enemigo3 = user4;
            user2.enemigo = user1;
            user2.enemigo2 = user3;
            user2.enemigo3 = user4;
            user3.enemigo = user1;
            user3.enemigo2 = user2;
            user3.enemigo3 = user4;
            user4.enemigo = user1; 
            user4.enemigo2 = user2;
            user4.enemigo3 = user3;
            }
            
            while (empezemos)
            {
            
            }
            
        } catch (IOException ex) {
            ventana.mostrar("ERROR ... en el servidor");
        }
    }
    }
}
