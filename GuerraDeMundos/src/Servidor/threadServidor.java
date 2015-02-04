/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Servidor;
import gato.JuegoGato;
import gato.Informacion;
import java.io.*;
import java.net.*;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author Diego
 */
public class threadServidor extends Thread
{
     Socket cliente = null;//referencia a socket de comunicacion de cliente
     DataInputStream entrada=null;//Para leer comunicacion
     DataOutputStream salida=null;//Para enviar comunicacion	
     String nameUser; //Para el nombre del usuario de esta conexion
     ServidorGato servidor;// referencia al servidor
     int iniciado;
     int opcion;

     // para envio de mensajes al enemigo
     threadServidor enemigo = null;
     threadServidor enemigo2 = null;
     threadServidor enemigo3 = null;
     threadServidor enemigo4 = null;
     // identificar el numero de jugador
     int numeroDeJugador;
     int cantidadJugadores;
     
     public threadServidor(Socket cliente,ServidorGato serv, int num,int pCantidadJugadores)
     {
        this.iniciado = 0;
        this.cliente = cliente;
        this.servidor = serv;
        this.numeroDeJugador = num;
        this.cantidadJugadores = pCantidadJugadores;
        nameUser="";// inicialmente se desconoce, hasta el primer read del hilo
     }
     
     //Getter an Setter...
     public String getNameUser()
     {
       return nameUser;
     }
     
     public void setNameUser(String name)
     {
       nameUser=name;
     }
     
     public void run()
     {
    	try
    	{
            System.out.println("aquui si" + this.cantidadJugadores);
            // inicializa para lectura y escritura con stream de cliente
          entrada=new DataInputStream(cliente.getInputStream());//comunic
          salida=new DataOutputStream(cliente.getOutputStream());//comunic
          // Es el primer read que hace, para el nombre del user
          
          System.out.println("lee el nombre");
          this.setNameUser(entrada.readUTF());
          System.out.println("1. Leyo nombre: " + nameUser);
          enviaUser(); // envia su nombre al otro usuario, que es con un 2
          // al enemigo
    	}
    	catch (IOException e) {  e.printStackTrace();     }
    	//VARIABLES
        opcion=0;                
    	while(true)
    	{
            
          try
          {
              
              //Siempre espera leer un int que será la instruccion por hacer
             opcion=entrada.readInt();
             System.out.println("aqui deberia sevir con esta" + opcion);
             switch(opcion)
             {
                case 1:
                    iniciado++;
                    System.out.println("lllego al caso numero uno" + iniciado);
                    if(cantidadJugadores == 2)
                    {                       
                        enemigo.salida.writeInt(1);
                        salida.writeInt(1);
                    }
                    else if(cantidadJugadores == 3)
                    {                       
                        enemigo.salida.writeInt(1);
                        enemigo2.salida.writeInt(1);
                        salida.writeInt(1);
                    }
                    else if(cantidadJugadores == 4)
                    {                       
                        enemigo.salida.writeInt(1);
                        enemigo2.salida.writeInt(1);
                        enemigo3.salida.writeInt(1);
                        salida.writeInt(1);
                    }
                /* 
                    break;
                    //ENVIAR EL JOPTION MESAGE A TODOS LOS JUGADORES
                   /*
                   int columna = entrada.readInt();//Lee coordenada
                   int fila = entrada.readInt();//Lee coordenada fila
                   servidor.ventana.mostrar("Recibido " + columna +","+fila);
                   // ENVIA LA COORDENADA AL ENEMIGO
                   enemigo.salida.writeInt(1);// Opcion 1 al hilo cliente del enemigo
                   enemigo.salida.writeInt(columna);// envia columna
                   enemigo.salida.writeInt(fila);// envia fila
                   
                   System.out.println("Op1: lee col,fil, envia al enemigo, 1, col, fila: "+columna+" , "+fila );
                   break;*/
                    
                case 2://para iniciarlos jugadores
                    if(cantidadJugadores == 2)
                    {                       
                        enemigo.salida.writeInt(14);
                        salida.writeInt(14);
                    }
                    else if(cantidadJugadores == 3)
                    {                       
                        enemigo.salida.writeInt(14);
                        enemigo2.salida.writeInt(14);
                        salida.writeInt(14);
                    }
                    else if(cantidadJugadores == 4)
                    {                       
                        enemigo.salida.writeInt(14);
                        enemigo2.salida.writeInt(14);
                        enemigo3.salida.writeInt(14);
                        salida.writeInt(14);
                    }
                    System.out.println("que cagada");
                 break;
                case 3: //le envia el status, que es el numero de jugador y el nombre enemigo
                    System.out.println("3. Op3: envia 3 y numeroJugador y enemigo: "+ numeroDeJugador);
                    salida.writeInt(3);
                    System.out.println("3. Op3: envia 3 y numeroJugador y enemigo: "+ cantidadJugadores);
                    salida.writeInt(numeroDeJugador);
                    salida.writeInt(cantidadJugadores);
                    
                    //salida.writeInt(cantidadJugadores);
                    
                    if (enemigo == null)
                        salida.writeUTF("");
                    else
                        salida.writeUTF(enemigo.nameUser);
                        
                   break;
                 case 4:
                     System.out.println("estoy tratando de hacer esto");
                     // lee el mensaje enviado desde el jframe
                     String mensaje = entrada.readUTF();
                     // envia un 4 al thradCliente enemigo
                     if(ServidorGato.opcionJugadores == 2)
                     {
                        enemigo.salida.writeInt(4);
                        // envia el emnsaje al thread cliente enemigo
                        enemigo.salida.writeUTF(mensaje);
                        System.out.println("Op4: envia 4 y mensaje: "+ mensaje);
                     }
                     else if(ServidorGato.opcionJugadores== 3)
                     {
                        enemigo.salida.writeInt(4);
                        enemigo2.salida.writeInt(4);
                        // envia el emnsaje al thread cliente enemigo
                        enemigo.salida.writeUTF(mensaje);
                        enemigo2.salida.writeUTF(mensaje);
                        System.out.println("Op4: envia 4 y mensaje: "+ mensaje);   
                     }
                     else if(ServidorGato.opcionJugadores == 4)
                     {
                        System.out.println("asi se hace");
                        enemigo.salida.writeInt(4);
                        enemigo2.salida.writeInt(4);
                        enemigo3.salida.writeInt(4);
                        // envia el emnsaje al thread cliente enemigo
                        enemigo.salida.writeUTF(mensaje);
                        enemigo2.salida.writeUTF(mensaje);
                        enemigo3.salida.writeUTF(mensaje);
                     }
                 break;
                 case 5:
                     // aqui cambio los turnos
                     //int jugador = entrada.readInt();
                     
                     
                     if(cantidadJugadores == 2)
                     {
                         enemigo.salida.writeInt(5);
                     }
                     else if(cantidadJugadores == 3)
                     {
                        enemigo.salida.writeInt(5);
                        enemigo2.salida.writeInt(5);
                     }
                     else if(cantidadJugadores == 4)
                     {
                         enemigo.salida.writeInt(5);
                         enemigo2.salida.writeInt(5);
                         enemigo3.salida.writeInt(5);
                     }
                             
                 break;
                 case 6:
                     //cambia turno
                     System.out.println("al menos llego");
                     enemigo.salida.writeInt(6);
                     int turnoActual = entrada.readInt();
                     if(ServidorGato.opcionJugadores == 2)
                     {
                         System.out.println("vooy bien");
                         if(turnoActual == 2)
                         {
                             turnoActual = 1;
                             enemigo.salida.writeInt(turnoActual);
                         }
                         else if(turnoActual == 1)
                         {
                             turnoActual = 2;
                             enemigo.salida.writeInt(turnoActual);
                         }
                             
                     }
                     else if(ServidorGato.opcionJugadores == 3)
                     {
                         System.out.println("vooy bien");
                         if(turnoActual == 2)
                         {
                             turnoActual = 3;
                             enemigo.salida.writeInt(3);
                         }
                         else if(turnoActual == 1)
                         {
                             turnoActual = 2;
                             enemigo.salida.writeInt(2);
                         }
                         else if(turnoActual == 3)
                         {
                             turnoActual = 1;
                             enemigo.salida.writeInt(1);
                         }
                     }
                     else if(ServidorGato.opcionJugadores == 4)
                     {
                         System.out.println("vooy bien");
                         if(turnoActual == 2)
                         {
                             turnoActual = 3;
                             enemigo.salida.writeInt(3);
                         }
                         else if(turnoActual == 1)
                         {
                             turnoActual = 2;
                             enemigo.salida.writeInt(2);
                         }
                         else if(turnoActual == 3)
                         {
                             turnoActual = 4;
                             enemigo.salida.writeInt(4);
                         }
                         else if(turnoActual == 4)
                         {
                             turnoActual = 1;
                             enemigo.salida.writeInt(1);
                         }
                     }
                     break;
                 case 7:
                     
                     int escogerMatriz = entrada.readInt();
                     int numeroJugador = entrada.readInt();
                     System.out.println("Este es mi numero de jugador" + numeroJugador + escogerMatriz);
                     if (escogerMatriz == 1)
                     {
                         System.out.println("estoy jodido");
                         enemigo.salida.writeInt(7);
                         enemigo.salida.writeInt(numeroJugador);
                     }
                     else if(escogerMatriz == 2)
                     {
                         enemigo2.salida.writeInt(7);
                         enemigo2.salida.writeInt(numeroJugador);
                     }    
                     else if(escogerMatriz == 3)
                     {
                         enemigo3.salida.writeInt(7);
                         enemigo3.salida.writeInt(numeroJugador);
                     }
                     break;
                     
                 case 8:
                     String primerCuadro;
                     boolean visPrimerCuadro;
                     
                     int numeroJugadorFinal = entrada.readInt();
                     boolean protec = entrada.readBoolean();
                     if(numeroJugadorFinal == 1)
                     {
                        enemigo.salida.writeInt(8);
                        enemigo.salida.writeBoolean(protec);
                     }
                     else if(numeroJugadorFinal == 2)
                     {
                         enemigo.salida.writeInt(8);
                         enemigo.salida.writeBoolean(protec);
                     }
                     else if(numeroJugadorFinal == 3)
                     {
                         enemigo2.salida.writeInt(8);
                         enemigo2.salida.writeBoolean(protec);
                     }
                     else if(numeroJugadorFinal == 4)
                     {
                         enemigo3.salida.writeInt(8);
                         enemigo3.salida.writeBoolean(protec);
                     }
                         
                     //String primerCuadro = entrada.readUTF();
                     //boopabslean visPrimerCuadro = entrada.readBoolean();
                     for(int i = 0; i < 15;i++)
                     {
                         for(int j = 0; j < 15;j++)
                         {
                            //System.out.println("a la fuerza");
                            primerCuadro = entrada.readUTF();
                            //System.out.println("aun tengo entradas");
                            visPrimerCuadro = entrada.readBoolean();
                            if(primerCuadro == null)
                            {
                                 if(numeroJugadorFinal == 1)
                                    {
                                        enemigo.salida.writeUTF("");
                                    }
                                else if(numeroJugadorFinal == 2)
                                    {
                                        enemigo.salida.writeUTF("");
                                  
                                    }
                                else if(numeroJugadorFinal ==3)

                                {
                                    enemigo2.salida.writeUTF("");
                                }
                                else if(numeroJugadorFinal == 4)
                                {
                                    enemigo3.salida.writeUTF("");
                                }
                             }
                            else
                            {
                                 if(visPrimerCuadro == true)
                                 {
                                     
                                    if(numeroJugadorFinal == 1)
                                    {
                                        enemigo.salida.writeUTF(primerCuadro);
                                    }
                                    else if(numeroJugadorFinal == 2)
                                    {
                                        enemigo.salida.writeUTF(primerCuadro);
                                  
                                    }
                                    else if(numeroJugadorFinal ==3)

                                    {
                                        enemigo2.salida.writeUTF(primerCuadro);
                                    }
                                    else if(numeroJugadorFinal == 4)
                                    {
                                        enemigo3.salida.writeUTF(primerCuadro);
                                    }
                                 }
                                 else
                                 {
                                    
                                     if(numeroJugadorFinal == 1)
                                    {
                                        enemigo.salida.writeUTF("");
                                    }
                                    else if(numeroJugadorFinal == 2)
                                    {
                                        enemigo.salida.writeUTF("");
                                  
                                    }
                                    else if(numeroJugadorFinal ==3)

                                    {
                                        enemigo2.salida.writeUTF("");
                                    }
                                    else if(numeroJugadorFinal == 4)
                                    {
                                        enemigo3.salida.writeUTF("");
                                    }
                                     //System.out.println("aqui me quedo pegado");
                                 }
                             }
                     
                         }
                     }
                     break;
                 case 9:
                     
                     int sentBy = entrada.readInt();
                     int atacarHacia = entrada.readInt();
                     int filaDisparo = entrada.readInt();
                     int columnaDisparo = entrada.readInt();
                     if(cantidadJugadores == 2)
                     {
                           enemigo.salida.writeInt(9);
                           enemigo.salida.writeInt(sentBy);
                           enemigo.salida.writeInt(filaDisparo);
                           enemigo.salida.writeInt(columnaDisparo);
                     }
                     else if(cantidadJugadores == 3 || cantidadJugadores == 4)
                     {
                        if(sentBy == 1 && (atacarHacia == 2 || atacarHacia ==1))
                        {
                           enemigo.salida.writeInt(9);
                           enemigo.salida.writeInt(sentBy);
                           enemigo.salida.writeInt(filaDisparo);
                           enemigo.salida.writeInt(columnaDisparo);
                        }
                        else if(sentBy == 1 && atacarHacia == 3)
                        {
                           enemigo2.salida.writeInt(9);
                           enemigo2.salida.writeInt(sentBy);
                           enemigo2.salida.writeInt(filaDisparo);
                           enemigo2.salida.writeInt(columnaDisparo);
                        }
                        else if(sentBy == 1 && atacarHacia == 4)
                        {
                           enemigo3.salida.writeInt(9);
                           enemigo3.salida.writeInt(sentBy);
                           enemigo3.salida.writeInt(filaDisparo);
                           enemigo3.salida.writeInt(columnaDisparo);
                        }
                        else if(sentBy == 2 && atacarHacia == 1)
                        {
                           enemigo.salida.writeInt(9);
                           enemigo.salida.writeInt(sentBy);
                           enemigo.salida.writeInt(filaDisparo);
                           enemigo.salida.writeInt(columnaDisparo);
                        }
                        else if(sentBy == 2 && atacarHacia == 3)
                        {
                           enemigo2.salida.writeInt(9);
                           enemigo2.salida.writeInt(sentBy);
                           enemigo2.salida.writeInt(filaDisparo);
                           enemigo2.salida.writeInt(columnaDisparo);
                        }
                        else if(sentBy == 2 && atacarHacia == 4)
                        {
                           enemigo3.salida.writeInt(9);
                           enemigo3.salida.writeInt(sentBy);
                           enemigo3.salida.writeInt(filaDisparo);
                           enemigo3.salida.writeInt(columnaDisparo);
                        }
                        else if(sentBy == 3 && atacarHacia == 1)
                        {
                           enemigo.salida.writeInt(9);
                           enemigo.salida.writeInt(sentBy);
                           enemigo.salida.writeInt(filaDisparo);
                           enemigo.salida.writeInt(columnaDisparo);
                        }
                        else if(sentBy == 3 && atacarHacia == 2)
                        {
                           enemigo2.salida.writeInt(9);
                           enemigo2.salida.writeInt(sentBy);
                           enemigo2.salida.writeInt(filaDisparo);
                           enemigo2.salida.writeInt(columnaDisparo);
                        }
                         else if(sentBy == 3 && atacarHacia == 4)
                        {
                           enemigo3.salida.writeInt(9);
                           enemigo3.salida.writeInt(sentBy);
                           enemigo3.salida.writeInt(filaDisparo);
                           enemigo3.salida.writeInt(columnaDisparo);
                        }
                        else if(sentBy == 2 && atacarHacia == 4)
                        {
                           enemigo3.salida.writeInt(9);
                           enemigo3.salida.writeInt(sentBy);
                           enemigo3.salida.writeInt(filaDisparo);
                           enemigo3.salida.writeInt(columnaDisparo);
                        }
                        else if(sentBy == 3 && atacarHacia == 1)
                        {
                           enemigo.salida.writeInt(9);
                           enemigo.salida.writeInt(sentBy);
                           enemigo.salida.writeInt(filaDisparo);
                           enemigo.salida.writeInt(columnaDisparo);
                        }
                        else if(sentBy == 3 && atacarHacia == 2)
                        {
                           enemigo2.salida.writeInt(9);
                           enemigo2.salida.writeInt(sentBy);
                           enemigo2.salida.writeInt(filaDisparo);
                           enemigo2.salida.writeInt(columnaDisparo);
                        }
                         else if(sentBy == 3 && atacarHacia == 4)
                        {
                           enemigo3.salida.writeInt(9);
                           enemigo3.salida.writeInt(sentBy);
                           enemigo3.salida.writeInt(filaDisparo);
                           enemigo3.salida.writeInt(columnaDisparo);
                        }
                        else if(sentBy == 4 && atacarHacia == 1)
                        {
                           enemigo.salida.writeInt(9);
                           enemigo.salida.writeInt(sentBy);
                           enemigo.salida.writeInt(filaDisparo);
                           enemigo.salida.writeInt(columnaDisparo);
                        }
                        else if(sentBy == 4 && atacarHacia == 2)
                        {
                           enemigo2.salida.writeInt(9);
                           enemigo2.salida.writeInt(sentBy);
                           enemigo2.salida.writeInt(filaDisparo);
                           enemigo2.salida.writeInt(columnaDisparo);
                        }
                         else if(sentBy == 4 && atacarHacia == 3)
                        {
                           enemigo3.salida.writeInt(9);
                           enemigo3.salida.writeInt(sentBy);
                           enemigo3.salida.writeInt(filaDisparo);
                           enemigo3.salida.writeInt(columnaDisparo);
                        }
                     }
                   
                     System.out.println("me estan llegando bien los disparos de un misil");
                     break;
                 case 10:
                     int sendedBy = entrada.readInt();
                     int atacandoHacia = entrada.readInt();
                     int filaMulti = entrada.readInt();
                     int columnaMulti = entrada.readInt();
                     if(cantidadJugadores == 2)
                     {
                           enemigo.salida.writeInt(10);
                           enemigo.salida.writeInt(sendedBy);
                           enemigo.salida.writeInt(filaMulti);
                           enemigo.salida.writeInt(columnaMulti);
                     }
                     else if(cantidadJugadores == 3 || cantidadJugadores == 4)
                     {
                        if(sendedBy == 1 && (atacandoHacia == 2 || atacandoHacia ==1))
                        {
                           enemigo.salida.writeInt(10);
                           enemigo.salida.writeInt(sendedBy);
                           enemigo.salida.writeInt(filaMulti);
                           enemigo.salida.writeInt(columnaMulti);
                        }
                        else if(sendedBy == 1 && atacandoHacia == 3)
                        {
                           enemigo2.salida.writeInt(10);
                           enemigo2.salida.writeInt(sendedBy);
                           enemigo2.salida.writeInt(filaMulti);
                           enemigo2.salida.writeInt(columnaMulti);
                        }
                        else if(sendedBy == 1 && atacandoHacia == 4)
                        {
                           enemigo3.salida.writeInt(10);
                           enemigo3.salida.writeInt(sendedBy);
                           enemigo3.salida.writeInt(filaMulti);
                           enemigo3.salida.writeInt(columnaMulti);
                        }
                        else if(sendedBy == 2 && atacandoHacia == 1)
                        {
                           enemigo.salida.writeInt(10);
                           enemigo.salida.writeInt(sendedBy);
                           enemigo.salida.writeInt(filaMulti);
                           enemigo.salida.writeInt(columnaMulti);
                        }
                        else if(sendedBy == 2 && atacandoHacia == 3)
                        {
                           enemigo2.salida.writeInt(10);
                           enemigo2.salida.writeInt(sendedBy);
                           enemigo2.salida.writeInt(filaMulti);
                           enemigo2.salida.writeInt(columnaMulti);
                        }
                        else if(sendedBy == 2 && atacandoHacia == 4)
                        {
                           enemigo3.salida.writeInt(10);
                           enemigo3.salida.writeInt(sendedBy);
                           enemigo3.salida.writeInt(filaMulti);
                           enemigo3.salida.writeInt(columnaMulti);
                        }
                        else if(sendedBy == 3 && atacandoHacia == 1)
                        {
                           enemigo.salida.writeInt(10);
                           enemigo.salida.writeInt(sendedBy);
                           enemigo.salida.writeInt(filaMulti);
                           enemigo.salida.writeInt(columnaMulti);
                        }
                        else if(sendedBy == 3 && atacandoHacia == 2)
                        {
                           enemigo2.salida.writeInt(10);
                           enemigo2.salida.writeInt(sendedBy);
                           enemigo2.salida.writeInt(filaMulti);
                           enemigo2.salida.writeInt(columnaMulti);
                        }
                         else if(sendedBy == 3 && atacandoHacia == 4)
                        {
                           enemigo3.salida.writeInt(10);
                           enemigo3.salida.writeInt(sendedBy);
                           enemigo3.salida.writeInt(filaMulti);
                           enemigo3.salida.writeInt(columnaMulti);
                        }
                        else if(sendedBy == 2 && atacandoHacia == 4)
                        {
                           enemigo3.salida.writeInt(10);
                           enemigo3.salida.writeInt(sendedBy);
                           enemigo3.salida.writeInt(filaMulti);
                           enemigo3.salida.writeInt(columnaMulti);
                        }
                        else if(sendedBy == 3 && atacandoHacia == 1)
                        {
                           enemigo.salida.writeInt(10);
                           enemigo.salida.writeInt(sendedBy);
                           enemigo.salida.writeInt(filaMulti);
                           enemigo.salida.writeInt(columnaMulti);
                        }
                        else if(sendedBy == 3 && atacandoHacia == 2)
                        {
                           enemigo2.salida.writeInt(10);
                           enemigo2.salida.writeInt(sendedBy);
                           enemigo2.salida.writeInt(filaMulti);
                           enemigo2.salida.writeInt(columnaMulti);
                        }
                         else if(sendedBy == 3 && atacandoHacia == 4)
                        {
                           enemigo3.salida.writeInt(10);
                           enemigo3.salida.writeInt(sendedBy);
                           enemigo3.salida.writeInt(filaMulti);
                           enemigo3.salida.writeInt(columnaMulti);
                        }
                        else if(sendedBy == 4 && atacandoHacia == 1)
                        {
                           enemigo.salida.writeInt(10);
                           enemigo.salida.writeInt(sendedBy);
                           enemigo.salida.writeInt(filaMulti);
                           enemigo.salida.writeInt(columnaMulti);
                        }
                        else if(sendedBy == 4 && atacandoHacia == 2)
                        {
                           enemigo2.salida.writeInt(10);
                           enemigo2.salida.writeInt(sendedBy);
                           enemigo2.salida.writeInt(filaMulti);
                           enemigo2.salida.writeInt(columnaMulti);
                        }
                         else if(sendedBy == 4 && atacandoHacia == 3)
                        {
                           enemigo3.salida.writeInt(10);
                           enemigo3.salida.writeInt(sendedBy);
                           enemigo3.salida.writeInt(filaMulti);
                           enemigo3.salida.writeInt(columnaMulti);
                        }
                     }
                   
                     System.out.println("me estan llegando bien los disparos del multi - shot");
                     break;
                     
                 case 11:
                     int enviador = entrada.readInt();
                     int enviadoA = entrada.readInt();
                     int filaUno = entrada.readInt();
                     int columnaUno = entrada.readInt();
                     int filaDos = entrada.readInt();
                     int columnaDos = entrada.readInt();
                     int filaTres = entrada.readInt();
                     int columnaTres = entrada.readInt();
                     int filaUnoUno = 0;
                     int columnaUnoUno = 0;
                     int filaDosDos = 0;
                     int columnaDosDos = 0;
                     int filaTresTres = 0;
                     int columnaTresTres = 0;
                     int pruebas = 0;
                     
                     //para el primer par
                     if(filaUno != 0 && columnaUno !=14)
                     {
                         pruebas = (int)Math.random()*2;
                         if(pruebas == 0)
                         {
                             filaUnoUno = filaUno;
                             columnaUnoUno = columnaUno +1;
                         }
                     }
                     else
                     {
                         if(filaUno == 0 && columnaUno!= 14)
                         {
                             filaUnoUno = filaUno;
                             columnaUnoUno = columnaUno + 1;
                         }
                         else
                         {
                            filaUnoUno = filaUno-1;
                             columnaUnoUno = columnaUno;   
                         }                       
                     }
                     
                     //para el segundo par
                     if(filaDos != 0 && columnaDos !=14)
                     {
                         pruebas = (int)Math.random()*2;
                         if(pruebas == 0)
                         {
                             filaDosDos = filaDos;
                             columnaDosDos = columnaDos +1;
                         }
                     }
                     else
                     {
                         if(filaDos == 0 && columnaDos!= 14)
                         {
                             filaDosDos = filaDos;
                             columnaDosDos = columnaDos + 1;
                         }
                         else
                         {
                             filaDosDos = filaDos-1;
                             columnaDosDos = columnaDos;   
                         }                       
                     }
                     
                     //para el tecer par
                     if(filaTres != 0 && columnaTres !=14)
                     {
                         pruebas = (int)Math.random()*2;
                         if(pruebas == 0)
                         {
                             filaTresTres = filaTres;
                             columnaTresTres = columnaTres +1;
                         }
                     }
                     else
                     {
                         if(filaTres == 0 && columnaTres!= 14)
                         {
                             filaTresTres = filaTres;
                             columnaTresTres = columnaTres + 1;
                         }
                         else
                         {
                            filaTresTres = filaTres-1;
                             columnaTresTres = columnaTres;   
                         }                       
                     }
                     if(cantidadJugadores == 2)
                     {
                        enemigo.salida.writeInt(11);
                        enemigo.salida.writeInt(enviador);                      
                        enemigo.salida.writeInt(filaUno);
                        enemigo.salida.writeInt(columnaUno);
                        enemigo.salida.writeInt(filaUnoUno);
                        enemigo.salida.writeInt(columnaUnoUno);
                        enemigo.salida.writeInt(filaDos);
                        enemigo.salida.writeInt(columnaDos);
                        enemigo.salida.writeInt(filaDosDos);
                        enemigo.salida.writeInt(columnaDosDos);
                        enemigo.salida.writeInt(filaTres);
                        enemigo.salida.writeInt(columnaTres);
                        enemigo.salida.writeInt(filaTresTres);
                        enemigo.salida.writeInt(columnaTresTres);
                     }
                     else if(cantidadJugadores == 3 || cantidadJugadores == 4)
                     {
                        if(enviador == 1 && (enviadoA == 2 || enviadoA ==1))
                        {
                            enemigo.salida.writeInt(11);
                            enemigo.salida.writeInt(enviador);
                            enemigo.salida.writeInt(filaUno);
                            enemigo.salida.writeInt(columnaUno);
                            enemigo.salida.writeInt(filaUnoUno);
                            enemigo.salida.writeInt(columnaUnoUno);
                            enemigo.salida.writeInt(filaDos);
                            enemigo.salida.writeInt(columnaDos);
                            enemigo.salida.writeInt(filaDosDos);
                            enemigo.salida.writeInt(columnaDosDos);
                            enemigo.salida.writeInt(filaTres);
                            enemigo.salida.writeInt(columnaTres);
                            enemigo.salida.writeInt(filaTresTres);
                            enemigo.salida.writeInt(columnaTresTres);
                        }
                        else if(enviador == 1 && enviadoA == 3)
                        {
                            enemigo2.salida.writeInt(11);
                            enemigo2.salida.writeInt(enviador);
                            enemigo2.salida.writeInt(filaUno);
                            enemigo2.salida.writeInt(columnaUno);
                            enemigo2.salida.writeInt(filaUnoUno);
                            enemigo2.salida.writeInt(columnaUnoUno);
                            enemigo2.salida.writeInt(filaDos);
                            enemigo2.salida.writeInt(columnaDos);
                            enemigo2.salida.writeInt(filaDosDos);
                            enemigo2.salida.writeInt(columnaDosDos);
                            enemigo2.salida.writeInt(filaTres);
                            enemigo2.salida.writeInt(columnaTres);
                            enemigo2.salida.writeInt(filaTresTres);
                            enemigo2.salida.writeInt(columnaTresTres);
                        }
                        else if(enviador == 1 && enviadoA == 4)
                        {
                            enemigo3.salida.writeInt(11);
                            enemigo3.salida.writeInt(enviador);
                            enemigo3.salida.writeInt(filaUno);
                            enemigo3.salida.writeInt(columnaUno);
                            enemigo3.salida.writeInt(filaUnoUno);
                            enemigo3.salida.writeInt(columnaUnoUno);
                            enemigo3.salida.writeInt(filaDos);
                            enemigo3.salida.writeInt(columnaDos);
                            enemigo3.salida.writeInt(filaDosDos);
                            enemigo3.salida.writeInt(columnaDosDos);
                            enemigo3.salida.writeInt(filaTres);
                            enemigo3.salida.writeInt(columnaTres);
                            enemigo3.salida.writeInt(filaTresTres);
                            enemigo3.salida.writeInt(columnaTresTres);
                        }
                        else if(enviador == 2 && enviadoA == 1)
                        {
                            enemigo.salida.writeInt(11);
                            enemigo.salida.writeInt(enviador);
                            enemigo.salida.writeInt(filaUno);
                            enemigo.salida.writeInt(columnaUno);
                            enemigo.salida.writeInt(filaUnoUno);
                            enemigo.salida.writeInt(columnaUnoUno);
                            enemigo.salida.writeInt(filaDos);
                            enemigo.salida.writeInt(columnaDos);
                            enemigo.salida.writeInt(filaDosDos);
                            enemigo.salida.writeInt(columnaDosDos);
                            enemigo.salida.writeInt(filaTres);
                            enemigo.salida.writeInt(columnaTres);
                            enemigo.salida.writeInt(filaTresTres);
                            enemigo.salida.writeInt(columnaTresTres);
                        }
                        else if(enviador == 2 && enviadoA == 3)
                        {
                            enemigo2.salida.writeInt(11);
                            enemigo2.salida.writeInt(enviador);
                            enemigo2.salida.writeInt(filaUno);
                            enemigo2.salida.writeInt(columnaUno);
                            enemigo2.salida.writeInt(filaUnoUno);
                            enemigo2.salida.writeInt(columnaUnoUno);
                            enemigo2.salida.writeInt(filaDos);
                            enemigo2.salida.writeInt(columnaDos);
                            enemigo2.salida.writeInt(filaDosDos);
                            enemigo2.salida.writeInt(columnaDosDos);
                            enemigo2.salida.writeInt(filaTres);
                            enemigo2.salida.writeInt(columnaTres);
                            enemigo2.salida.writeInt(filaTresTres);
                            enemigo2.salida.writeInt(columnaTresTres);
                        }
                        else if(enviador == 2 && enviadoA == 4)
                        {
                            enemigo3.salida.writeInt(11);
                            enemigo3.salida.writeInt(enviador);
                            enemigo3.salida.writeInt(filaUno);
                            enemigo3.salida.writeInt(columnaUno);
                            enemigo3.salida.writeInt(filaUnoUno);
                            enemigo3.salida.writeInt(columnaUnoUno);
                            enemigo3.salida.writeInt(filaDos);
                            enemigo3.salida.writeInt(columnaDos);
                            enemigo3.salida.writeInt(filaDosDos);
                            enemigo3.salida.writeInt(columnaDosDos);
                            enemigo3.salida.writeInt(filaTres);
                            enemigo3.salida.writeInt(columnaTres);
                            enemigo3.salida.writeInt(filaTresTres);
                            enemigo3.salida.writeInt(columnaTresTres);
                        }
                        else if(enviador == 3 && enviadoA == 1)
                        {
                            enemigo.salida.writeInt(11);
                            enemigo.salida.writeInt(enviador);
                            enemigo.salida.writeInt(filaUno);
                            enemigo.salida.writeInt(columnaUno);
                            enemigo.salida.writeInt(filaUnoUno);
                            enemigo.salida.writeInt(columnaUnoUno);
                            enemigo.salida.writeInt(filaDos);
                            enemigo.salida.writeInt(columnaDos);
                            enemigo.salida.writeInt(filaDosDos);
                            enemigo.salida.writeInt(columnaDosDos);
                            enemigo.salida.writeInt(filaTres);
                            enemigo.salida.writeInt(columnaTres);
                            enemigo.salida.writeInt(filaTresTres);
                            enemigo.salida.writeInt(columnaTresTres);
                        }
                        else if(enviador == 3 && enviadoA == 2)
                        {
                            enemigo2.salida.writeInt(11);
                            enemigo2.salida.writeInt(enviador);
                            enemigo2.salida.writeInt(filaUno);
                            enemigo2.salida.writeInt(columnaUno);
                            enemigo2.salida.writeInt(filaUnoUno);
                            enemigo2.salida.writeInt(columnaUnoUno);
                            enemigo2.salida.writeInt(filaDos);
                            enemigo2.salida.writeInt(columnaDos);
                            enemigo2.salida.writeInt(filaDosDos);
                            enemigo2.salida.writeInt(columnaDosDos);
                            enemigo2.salida.writeInt(filaTres);
                            enemigo2.salida.writeInt(columnaTres);
                            enemigo2.salida.writeInt(filaTresTres);
                            enemigo2.salida.writeInt(columnaTresTres);
                        }
                         else if(enviador == 3 && enviadoA == 4)
                        {
                            enemigo3.salida.writeInt(11);
                            enemigo3.salida.writeInt(enviador);
                            enemigo3.salida.writeInt(filaUno);
                            enemigo3.salida.writeInt(columnaUno);
                            enemigo3.salida.writeInt(filaUnoUno);
                            enemigo3.salida.writeInt(columnaUnoUno);
                            enemigo3.salida.writeInt(filaDos);
                            enemigo3.salida.writeInt(columnaDos);
                            enemigo3.salida.writeInt(filaDosDos);
                            enemigo3.salida.writeInt(columnaDosDos);
                            enemigo3.salida.writeInt(filaTres);
                            enemigo3.salida.writeInt(columnaTres);
                            enemigo3.salida.writeInt(filaTresTres);
                            enemigo3.salida.writeInt(columnaTresTres);
                        }
                     
                        else if(enviador == 4 && enviadoA == 1)
                        {
                            enemigo.salida.writeInt(11);
                            enemigo.salida.writeInt(enviador);
                            enemigo.salida.writeInt(filaUno);
                            enemigo.salida.writeInt(columnaUno);
                            enemigo.salida.writeInt(filaUnoUno);
                            enemigo.salida.writeInt(columnaUnoUno);
                            enemigo.salida.writeInt(filaDos);
                            enemigo.salida.writeInt(columnaDos);
                            enemigo.salida.writeInt(filaDosDos);
                            enemigo.salida.writeInt(columnaDosDos);
                            enemigo.salida.writeInt(filaTres);
                            enemigo.salida.writeInt(columnaTres);
                            enemigo.salida.writeInt(filaTresTres);
                            enemigo.salida.writeInt(columnaTresTres);
                        }
                        else if(enviador == 4 && enviadoA == 2)
                        {
                            enemigo2.salida.writeInt(11);
                            enemigo2.salida.writeInt(enviador);
                            enemigo2.salida.writeInt(filaUno);
                            enemigo2.salida.writeInt(columnaUno);
                            enemigo2.salida.writeInt(filaUnoUno);
                            enemigo2.salida.writeInt(columnaUnoUno);
                            enemigo2.salida.writeInt(filaDos);
                            enemigo2.salida.writeInt(columnaDos);
                            enemigo2.salida.writeInt(filaDosDos);
                            enemigo2.salida.writeInt(columnaDosDos);
                            enemigo2.salida.writeInt(filaTres);
                            enemigo2.salida.writeInt(columnaTres);
                            enemigo2.salida.writeInt(filaTresTres);
                            enemigo2.salida.writeInt(columnaTresTres);
                        }
                         else if(enviador == 4 && enviadoA == 3)
                        {
                            enemigo3.salida.writeInt(11);
                            enemigo3.salida.writeInt(enviador);
                            enemigo3.salida.writeInt(filaUno);
                            enemigo3.salida.writeInt(columnaUno);
                            enemigo3.salida.writeInt(filaUnoUno);
                            enemigo3.salida.writeInt(columnaUnoUno);
                            enemigo3.salida.writeInt(filaDos);
                            enemigo3.salida.writeInt(columnaDos);
                            enemigo3.salida.writeInt(filaDosDos);
                            enemigo3.salida.writeInt(columnaDosDos);
                            enemigo3.salida.writeInt(filaTres);
                            enemigo3.salida.writeInt(columnaTres);
                            enemigo3.salida.writeInt(filaTresTres);
                            enemigo3.salida.writeInt(columnaTresTres);
                        }
                     }
             
                     break;
                     // ESTE ES EL CASE DE LAS BOMBAS
                 case 12:
                     int from = entrada.readInt();
                     int to = entrada.readInt();
                     int filaComboUno = entrada.readInt();
                     int columnaComboUno = entrada.readInt();
                     int filaComboDos = entrada.readInt();
                     int columnaComboDos = entrada.readInt();
                     int filaComboTres = entrada.readInt();
                     int columnaComboTres = entrada.readInt();
                     int filaComboCuatro = entrada.readInt();
                     int columnaComboCuatro = entrada.readInt();
                     int filaComboCinco = entrada.readInt();
                     int columnaComboCinco = entrada.readInt();
                     int filaComboSeis = entrada.readInt();
                     int columnaComboSeis = entrada.readInt();
                     int filaComboSiete = entrada.readInt();
                     int columnaComboSiete = entrada.readInt();
                     int filaComboOcho = entrada.readInt();
                     int columnaComboOcho = entrada.readInt();
                     int filaComboNueve = entrada.readInt();
                     int columnaComboNueve = entrada.readInt();
                     int filaComboDiez = entrada.readInt();
                     int columnaComboDiez = entrada.readInt();
                     
                                          
                     if(cantidadJugadores == 2)
                     {
                        enemigo.salida.writeInt(12);
                        enemigo.salida.writeInt(from);
                        enemigo.salida.writeInt(filaComboUno);
                        enemigo.salida.writeInt(columnaComboUno);
                        enemigo.salida.writeInt(filaComboDos);
                        enemigo.salida.writeInt(columnaComboDos);
                        enemigo.salida.writeInt(filaComboTres);
                        enemigo.salida.writeInt(columnaComboTres);
                        enemigo.salida.writeInt(filaComboCuatro);
                        enemigo.salida.writeInt(columnaComboCuatro);
                        enemigo.salida.writeInt(filaComboCinco);
                        enemigo.salida.writeInt(columnaComboCinco);
                        enemigo.salida.writeInt(filaComboSeis);
                        enemigo.salida.writeInt(columnaComboSeis);
                        enemigo.salida.writeInt(filaComboSiete);
                        enemigo.salida.writeInt(columnaComboSiete);
                        enemigo.salida.writeInt(filaComboOcho);
                        enemigo.salida.writeInt(columnaComboOcho);
                        enemigo.salida.writeInt(filaComboNueve);
                        enemigo.salida.writeInt(columnaComboNueve);
                        enemigo.salida.writeInt(filaComboDiez);
                        enemigo.salida.writeInt(columnaComboDiez);
                     }
                     else if(cantidadJugadores == 3 || cantidadJugadores == 4)
                     {
                        if(from == 1 && (to == 2 || to ==1))
                        {
                            enemigo.salida.writeInt(12);
                            enemigo.salida.writeInt(from);
                            enemigo.salida.writeInt(filaComboUno);
                            enemigo.salida.writeInt(columnaComboUno);
                            enemigo.salida.writeInt(filaComboDos);
                            enemigo.salida.writeInt(columnaComboDos);
                            enemigo.salida.writeInt(filaComboTres);
                            enemigo.salida.writeInt(columnaComboTres);
                            enemigo.salida.writeInt(filaComboCuatro);
                            enemigo.salida.writeInt(columnaComboCuatro);
                            enemigo.salida.writeInt(filaComboCinco);
                            enemigo.salida.writeInt(columnaComboCinco);
                            enemigo.salida.writeInt(filaComboSeis);
                            enemigo.salida.writeInt(columnaComboSeis);
                            enemigo.salida.writeInt(filaComboSiete);
                            enemigo.salida.writeInt(columnaComboSiete);
                            enemigo.salida.writeInt(filaComboOcho);
                            enemigo.salida.writeInt(columnaComboOcho);
                            enemigo.salida.writeInt(filaComboNueve);
                            enemigo.salida.writeInt(columnaComboNueve);
                            enemigo.salida.writeInt(filaComboDiez);
                            enemigo.salida.writeInt(columnaComboDiez);
                        }
                        else if(from == 1 && to == 3)
                        {
                            enemigo2.salida.writeInt(12);
                            enemigo2.salida.writeInt(from);
                            enemigo2.salida.writeInt(filaComboUno);
                            enemigo2.salida.writeInt(columnaComboUno);
                            enemigo2.salida.writeInt(filaComboDos);
                            enemigo2.salida.writeInt(columnaComboDos);
                            enemigo2.salida.writeInt(filaComboTres);
                            enemigo2.salida.writeInt(columnaComboTres);
                            enemigo2.salida.writeInt(filaComboCuatro);
                            enemigo2.salida.writeInt(columnaComboCuatro);
                            enemigo2.salida.writeInt(filaComboCinco);
                            enemigo2.salida.writeInt(columnaComboCinco);
                            enemigo2.salida.writeInt(filaComboSeis);
                            enemigo2.salida.writeInt(columnaComboSeis);
                            enemigo2.salida.writeInt(filaComboSiete);
                            enemigo2.salida.writeInt(columnaComboSiete);
                            enemigo2.salida.writeInt(filaComboOcho);
                            enemigo2.salida.writeInt(columnaComboOcho);
                            enemigo2.salida.writeInt(filaComboNueve);
                            enemigo2.salida.writeInt(columnaComboNueve);
                            enemigo2.salida.writeInt(filaComboDiez);
                            enemigo2.salida.writeInt(columnaComboDiez);
                        }
                        else if(from == 1 && to == 4)
                        {
                            enemigo3.salida.writeInt(12);
                            enemigo3.salida.writeInt(from);
                            enemigo3.salida.writeInt(filaComboUno);
                            enemigo3.salida.writeInt(columnaComboUno);
                            enemigo3.salida.writeInt(filaComboDos);
                            enemigo3.salida.writeInt(columnaComboDos);
                            enemigo3.salida.writeInt(filaComboTres);
                            enemigo3.salida.writeInt(columnaComboTres);
                            enemigo3.salida.writeInt(filaComboCuatro);
                            enemigo3.salida.writeInt(columnaComboCuatro);
                            enemigo3.salida.writeInt(filaComboCinco);
                            enemigo3.salida.writeInt(columnaComboCinco);
                            enemigo3.salida.writeInt(filaComboSeis);
                            enemigo3.salida.writeInt(columnaComboSeis);
                            enemigo3.salida.writeInt(filaComboSiete);
                            enemigo3.salida.writeInt(columnaComboSiete);
                            enemigo3.salida.writeInt(filaComboOcho);
                            enemigo3.salida.writeInt(columnaComboOcho);
                            enemigo3.salida.writeInt(filaComboNueve);
                            enemigo3.salida.writeInt(columnaComboNueve);
                            enemigo3.salida.writeInt(filaComboDiez);
                            enemigo3.salida.writeInt(columnaComboDiez);
                        }
                        else if(from == 2 && to == 1)
                        {
                            enemigo.salida.writeInt(12);
                            enemigo.salida.writeInt(from);
                            enemigo.salida.writeInt(filaComboUno);
                            enemigo.salida.writeInt(columnaComboUno);
                            enemigo.salida.writeInt(filaComboDos);
                            enemigo.salida.writeInt(columnaComboDos);
                            enemigo.salida.writeInt(filaComboTres);
                            enemigo.salida.writeInt(columnaComboTres);
                            enemigo.salida.writeInt(filaComboCuatro);
                            enemigo.salida.writeInt(columnaComboCuatro);
                            enemigo.salida.writeInt(filaComboCinco);
                            enemigo.salida.writeInt(columnaComboCinco);
                            enemigo.salida.writeInt(filaComboSeis);
                            enemigo.salida.writeInt(columnaComboSeis);
                            enemigo.salida.writeInt(filaComboSiete);
                            enemigo.salida.writeInt(columnaComboSiete);
                            enemigo.salida.writeInt(filaComboOcho);
                            enemigo.salida.writeInt(columnaComboOcho);
                            enemigo.salida.writeInt(filaComboNueve);
                            enemigo.salida.writeInt(columnaComboNueve);
                            enemigo.salida.writeInt(filaComboDiez);
                            enemigo.salida.writeInt(columnaComboDiez);
                        }
                        else if(from == 2 && to == 3)
                        {
                            enemigo2.salida.writeInt(12);
                            enemigo2.salida.writeInt(from);
                            enemigo2.salida.writeInt(filaComboUno);
                            enemigo2.salida.writeInt(columnaComboUno);
                            enemigo2.salida.writeInt(filaComboDos);
                            enemigo2.salida.writeInt(columnaComboDos);
                            enemigo2.salida.writeInt(filaComboTres);
                            enemigo2.salida.writeInt(columnaComboTres);
                            enemigo2.salida.writeInt(filaComboCuatro);
                            enemigo2.salida.writeInt(columnaComboCuatro);
                            enemigo2.salida.writeInt(filaComboCinco);
                            enemigo2.salida.writeInt(columnaComboCinco);
                            enemigo2.salida.writeInt(filaComboSeis);
                            enemigo2.salida.writeInt(columnaComboSeis);
                            enemigo2.salida.writeInt(filaComboSiete);
                            enemigo2.salida.writeInt(columnaComboSiete);
                            enemigo2.salida.writeInt(filaComboOcho);
                            enemigo2.salida.writeInt(columnaComboOcho);
                            enemigo2.salida.writeInt(filaComboNueve);
                            enemigo2.salida.writeInt(columnaComboNueve);
                            enemigo2.salida.writeInt(filaComboDiez);
                            enemigo2.salida.writeInt(columnaComboDiez);
                        }
                        else if(from == 2 && to == 4)
                        {
                            enemigo3.salida.writeInt(12);
                            enemigo3.salida.writeInt(from);
                            enemigo3.salida.writeInt(filaComboUno);
                            enemigo3.salida.writeInt(columnaComboUno);
                            enemigo3.salida.writeInt(filaComboDos);
                            enemigo3.salida.writeInt(columnaComboDos);
                            enemigo3.salida.writeInt(filaComboTres);
                            enemigo3.salida.writeInt(columnaComboTres);
                            enemigo3.salida.writeInt(filaComboCuatro);
                            enemigo3.salida.writeInt(columnaComboCuatro);
                            enemigo3.salida.writeInt(filaComboCinco);
                            enemigo3.salida.writeInt(columnaComboCinco);
                            enemigo3.salida.writeInt(filaComboSeis);
                            enemigo3.salida.writeInt(columnaComboSeis);
                            enemigo3.salida.writeInt(filaComboSiete);
                            enemigo3.salida.writeInt(columnaComboSiete);
                            enemigo3.salida.writeInt(filaComboOcho);
                            enemigo3.salida.writeInt(columnaComboOcho);
                            enemigo3.salida.writeInt(filaComboNueve);
                            enemigo3.salida.writeInt(columnaComboNueve);
                            enemigo3.salida.writeInt(filaComboDiez);
                            enemigo3.salida.writeInt(columnaComboDiez);
                        }
                        else if(from == 3 && to == 1)
                        {
                            enemigo.salida.writeInt(12);
                            enemigo.salida.writeInt(from);
                            enemigo.salida.writeInt(filaComboUno);
                            enemigo.salida.writeInt(columnaComboUno);
                            enemigo.salida.writeInt(filaComboDos);
                            enemigo.salida.writeInt(columnaComboDos);
                            enemigo.salida.writeInt(filaComboTres);
                            enemigo.salida.writeInt(columnaComboTres);
                            enemigo.salida.writeInt(filaComboCuatro);
                            enemigo.salida.writeInt(columnaComboCuatro);
                            enemigo.salida.writeInt(filaComboCinco);
                            enemigo.salida.writeInt(columnaComboCinco);
                            enemigo.salida.writeInt(filaComboSeis);
                            enemigo.salida.writeInt(columnaComboSeis);
                            enemigo.salida.writeInt(filaComboSiete);
                            enemigo.salida.writeInt(columnaComboSiete);
                            enemigo.salida.writeInt(filaComboOcho);
                            enemigo.salida.writeInt(columnaComboOcho);
                            enemigo.salida.writeInt(filaComboNueve);
                            enemigo.salida.writeInt(columnaComboNueve);
                            enemigo.salida.writeInt(filaComboDiez);
                            enemigo.salida.writeInt(columnaComboDiez);
                        }
                        else if(from == 3 && to == 2)
                        {
                            enemigo2.salida.writeInt(12);
                            enemigo2.salida.writeInt(from);
                            enemigo2.salida.writeInt(filaComboUno);
                            enemigo2.salida.writeInt(columnaComboUno);
                            enemigo2.salida.writeInt(filaComboDos);
                            enemigo2.salida.writeInt(columnaComboDos);
                            enemigo2.salida.writeInt(filaComboTres);
                            enemigo2.salida.writeInt(columnaComboTres);
                            enemigo2.salida.writeInt(filaComboCuatro);
                            enemigo2.salida.writeInt(columnaComboCuatro);
                            enemigo2.salida.writeInt(filaComboCinco);
                            enemigo2.salida.writeInt(columnaComboCinco);
                            enemigo2.salida.writeInt(filaComboSeis);
                            enemigo2.salida.writeInt(columnaComboSeis);
                            enemigo2.salida.writeInt(filaComboSiete);
                            enemigo2.salida.writeInt(columnaComboSiete);
                            enemigo2.salida.writeInt(filaComboOcho);
                            enemigo2.salida.writeInt(columnaComboOcho);
                            enemigo2.salida.writeInt(filaComboNueve);
                            enemigo2.salida.writeInt(columnaComboNueve);
                            enemigo2.salida.writeInt(filaComboDiez);
                            enemigo2.salida.writeInt(columnaComboDiez);
                        }
                         else if(from == 3 && to == 4)
                        {
                            enemigo3.salida.writeInt(12);
                            enemigo3.salida.writeInt(from);
                            enemigo3.salida.writeInt(filaComboUno);
                            enemigo3.salida.writeInt(columnaComboUno);
                            enemigo3.salida.writeInt(filaComboDos);
                            enemigo3.salida.writeInt(columnaComboDos);
                            enemigo3.salida.writeInt(filaComboTres);
                            enemigo3.salida.writeInt(columnaComboTres);
                            enemigo3.salida.writeInt(filaComboCuatro);
                            enemigo3.salida.writeInt(columnaComboCuatro);
                            enemigo3.salida.writeInt(filaComboCinco);
                            enemigo3.salida.writeInt(columnaComboCinco);
                            enemigo3.salida.writeInt(filaComboSeis);
                            enemigo3.salida.writeInt(columnaComboSeis);
                            enemigo3.salida.writeInt(filaComboSiete);
                            enemigo3.salida.writeInt(columnaComboSiete);
                            enemigo3.salida.writeInt(filaComboOcho);
                            enemigo3.salida.writeInt(columnaComboOcho);
                            enemigo3.salida.writeInt(filaComboNueve);
                            enemigo3.salida.writeInt(columnaComboNueve);
                            enemigo3.salida.writeInt(filaComboDiez);
                            enemigo3.salida.writeInt(columnaComboDiez);
                        }
                        else if(from == 2 && to == 4)
                        {
                            enemigo.salida.writeInt(12);
                            enemigo.salida.writeInt(from);
                            enemigo.salida.writeInt(filaComboUno);
                            enemigo.salida.writeInt(columnaComboUno);
                            enemigo.salida.writeInt(filaComboDos);
                            enemigo.salida.writeInt(columnaComboDos);
                            enemigo.salida.writeInt(filaComboTres);
                            enemigo.salida.writeInt(columnaComboTres);
                            enemigo.salida.writeInt(filaComboCuatro);
                            enemigo.salida.writeInt(columnaComboCuatro);
                            enemigo.salida.writeInt(filaComboCinco);
                            enemigo.salida.writeInt(columnaComboCinco);
                            enemigo.salida.writeInt(filaComboSeis);
                            enemigo.salida.writeInt(columnaComboSeis);
                            enemigo.salida.writeInt(filaComboSiete);
                            enemigo.salida.writeInt(columnaComboSiete);
                            enemigo.salida.writeInt(filaComboOcho);
                            enemigo.salida.writeInt(columnaComboOcho);
                            enemigo.salida.writeInt(filaComboNueve);
                            enemigo.salida.writeInt(columnaComboNueve);
                            enemigo.salida.writeInt(filaComboDiez);
                            enemigo.salida.writeInt(columnaComboDiez);
                        }
                      
                        else if(from == 4 && to == 1)
                        {
                            enemigo.salida.writeInt(12);
                            enemigo.salida.writeInt(from);
                            enemigo.salida.writeInt(filaComboUno);
                            enemigo.salida.writeInt(columnaComboUno);
                            enemigo.salida.writeInt(filaComboDos);
                            enemigo.salida.writeInt(columnaComboDos);
                            enemigo.salida.writeInt(filaComboTres);
                            enemigo.salida.writeInt(columnaComboTres);
                            enemigo.salida.writeInt(filaComboCuatro);
                            enemigo.salida.writeInt(columnaComboCuatro);
                            enemigo.salida.writeInt(filaComboCinco);
                            enemigo.salida.writeInt(columnaComboCinco);
                            enemigo.salida.writeInt(filaComboSeis);
                            enemigo.salida.writeInt(columnaComboSeis);
                            enemigo.salida.writeInt(filaComboSiete);
                            enemigo.salida.writeInt(columnaComboSiete);
                            enemigo.salida.writeInt(filaComboOcho);
                            enemigo.salida.writeInt(columnaComboOcho);
                            enemigo.salida.writeInt(filaComboNueve);
                            enemigo.salida.writeInt(columnaComboNueve);
                            enemigo.salida.writeInt(filaComboDiez);
                            enemigo.salida.writeInt(columnaComboDiez);
                        }
                        else if(from == 4 && to == 2)
                        {
                            enemigo2.salida.writeInt(12);
                            enemigo2.salida.writeInt(from);
                            enemigo2.salida.writeInt(filaComboUno);
                            enemigo2.salida.writeInt(columnaComboUno);
                            enemigo2.salida.writeInt(filaComboDos);
                            enemigo2.salida.writeInt(columnaComboDos);
                            enemigo2.salida.writeInt(filaComboTres);
                            enemigo2.salida.writeInt(columnaComboTres);
                            enemigo2.salida.writeInt(filaComboCuatro);
                            enemigo2.salida.writeInt(columnaComboCuatro);
                            enemigo2.salida.writeInt(filaComboCinco);
                            enemigo2.salida.writeInt(columnaComboCinco);
                            enemigo2.salida.writeInt(filaComboSeis);
                            enemigo2.salida.writeInt(columnaComboSeis);
                            enemigo2.salida.writeInt(filaComboSiete);
                            enemigo2.salida.writeInt(columnaComboSiete);
                            enemigo2.salida.writeInt(filaComboOcho);
                            enemigo2.salida.writeInt(columnaComboOcho);
                            enemigo2.salida.writeInt(filaComboNueve);
                            enemigo2.salida.writeInt(columnaComboNueve);
                            enemigo2.salida.writeInt(filaComboDiez);
                            enemigo2.salida.writeInt(columnaComboDiez);
                        }
                         else if(from == 4 && to == 3)
                        {
                            enemigo3.salida.writeInt(12);
                            enemigo3.salida.writeInt(from);
                            enemigo3.salida.writeInt(filaComboUno);
                            enemigo3.salida.writeInt(columnaComboUno);
                            enemigo3.salida.writeInt(filaComboDos);
                            enemigo3.salida.writeInt(columnaComboDos);
                            enemigo3.salida.writeInt(filaComboTres);
                            enemigo3.salida.writeInt(columnaComboTres);
                            enemigo3.salida.writeInt(filaComboCuatro);
                            enemigo3.salida.writeInt(columnaComboCuatro);
                            enemigo3.salida.writeInt(filaComboCinco);
                            enemigo3.salida.writeInt(columnaComboCinco);
                            enemigo3.salida.writeInt(filaComboSeis);
                            enemigo3.salida.writeInt(columnaComboSeis);
                            enemigo3.salida.writeInt(filaComboSiete);
                            enemigo3.salida.writeInt(columnaComboSiete);
                            enemigo3.salida.writeInt(filaComboOcho);
                            enemigo3.salida.writeInt(columnaComboOcho);
                            enemigo3.salida.writeInt(filaComboNueve);
                            enemigo3.salida.writeInt(columnaComboNueve);
                            enemigo3.salida.writeInt(filaComboDiez);
                            enemigo3.salida.writeInt(columnaComboDiez);
                        }
                     }
                     break;
                 
                 case 13:
                     int jugadorInspeccionado = entrada.readInt();
                     int jugadorNumero = entrada.readInt();
                     int filaInspec = entrada.readInt();
                     int columnaInspec = entrada.readInt();
                     if(jugadorInspeccionado == 1 || jugadorInspeccionado == 2)
                     {
                         enemigo.salida.writeInt(13);
                         enemigo.salida.writeInt(jugadorNumero);
                         enemigo.salida.writeInt(filaInspec);
                         enemigo.salida.writeInt(columnaInspec);
                     }
                     else if(jugadorInspeccionado == 3)
                     {
                         enemigo2.salida.writeInt(13);
                         enemigo2.salida.writeInt(jugadorNumero);
                         enemigo2.salida.writeInt(filaInspec);
                         enemigo2.salida.writeInt(columnaInspec);
                     }    
                     else if(jugadorInspeccionado == 4)
                     {
                         enemigo3.salida.writeInt(13);
                         enemigo3.salida.writeInt(jugadorNumero);
                         enemigo3.salida.writeInt(filaInspec);
                         enemigo3.salida.writeInt(columnaInspec);
                     }
                     break;       
                     
                 case 14:
                   
                     int yoJuego = entrada.readInt();
                     int soyActual = entrada.readInt();
                     
                     if(cantidadJugadores == 2)
                     {
                         System.out.println("soy 14 y soy la etapa dos");
                           enemigo.salida.writeInt(15);
                           enemigo.salida.writeInt(yoJuego);
                     }
                     else if(cantidadJugadores == 3 || cantidadJugadores == 4)
                     {
                        if(yoJuego == 1 && (soyActual == 2 || soyActual ==1))
                        {
                           enemigo.salida.writeInt(15);
                           enemigo.salida.writeInt(yoJuego);
                        }
                        else if(yoJuego == 1 && soyActual == 3)
                        {
                           enemigo2.salida.writeInt(15);
                           enemigo2.salida.writeInt(yoJuego);
                        }
                        else if(yoJuego == 1 && soyActual == 4)
                        {
                           enemigo3.salida.writeInt(15);
                           enemigo3.salida.writeInt(yoJuego);
                        }
                        else if(yoJuego == 2 && soyActual == 1)
                        {
                           enemigo.salida.writeInt(15);
                           enemigo.salida.writeInt(yoJuego);
                        }
                        else if(yoJuego == 2 && soyActual == 3)
                        {
                           enemigo2.salida.writeInt(15);
                           enemigo2.salida.writeInt(yoJuego);
                        }
                        else if(yoJuego == 2 && soyActual == 4)
                        {
                           enemigo3.salida.writeInt(15);
                           enemigo3.salida.writeInt(yoJuego);
                        }
                        else if(yoJuego == 3 && soyActual == 1)
                        {
                           enemigo.salida.writeInt(15);
                           enemigo.salida.writeInt(yoJuego);
                        }
                        else if(yoJuego == 3 && soyActual == 2)
                        {
                           enemigo2.salida.writeInt(15);
                           enemigo2.salida.writeInt(yoJuego);
                        }
                         else if(yoJuego == 3 && soyActual == 4)
                        {
                           enemigo3.salida.writeInt(15);
                           enemigo3.salida.writeInt(yoJuego);
                        }
                        else if(yoJuego == 2 && soyActual == 4)
                        {
                           enemigo3.salida.writeInt(15);
                           enemigo3.salida.writeInt(yoJuego);
                        }
                        else if(yoJuego == 3 && soyActual == 1)
                        {
                           enemigo.salida.writeInt(15);
                           enemigo.salida.writeInt(yoJuego);
                        }
                        else if(yoJuego == 3 && soyActual == 2)
                        {
                           enemigo2.salida.writeInt(15);
                           enemigo2.salida.writeInt(yoJuego);
                        }
                         else if(yoJuego == 3 && soyActual == 4)
                        {
                           enemigo3.salida.writeInt(15);
                           enemigo3.salida.writeInt(yoJuego);
                        }
                        else if(yoJuego == 4 && soyActual == 1)
                        {
                           enemigo.salida.writeInt(15);
                           enemigo.salida.writeInt(yoJuego);
                        }
                        else if(yoJuego == 4 && soyActual == 2)
                        {
                           enemigo2.salida.writeInt(15);
                           enemigo2.salida.writeInt(yoJuego);
                        }
                         else if(yoJuego == 4 && soyActual == 3)
                        {
                           enemigo3.salida.writeInt(15);
                           enemigo3.salida.writeInt(yoJuego);
                        }
                     }
                 break;
                
                 case 15:
                     int juegando = entrada.readInt();
                     int x = 0;
                     int y = 0;
                     int cantidad = entrada.readInt();
                     String tipo = null;
                     
                     
                     if(juegando == 1 || juegando == 2)
                     {
                         enemigo.salida.writeInt(16);
                         enemigo.salida.writeInt(cantidad);
                         for (int i = 0; i < cantidad; i++ ){
                             tipo = entrada.readUTF();
                             x = entrada.readInt();
                             y = entrada.readInt();
                             enemigo.salida.writeUTF(tipo);
                             enemigo.salida.writeInt(x);
                             enemigo.salida.writeInt(y);
                         }
                     }
                     else if(juegando == 3)
                     {
                         enemigo2.salida.writeInt(16);
                         enemigo2.salida.writeInt(cantidad);
                         for (int i = 0; i < cantidad; i++ ){
                             tipo = entrada.readUTF();
                             x = entrada.readInt();
                             y = entrada.readInt();
                             enemigo2.salida.writeUTF(tipo);
                             enemigo2.salida.writeInt(x);
                             enemigo2.salida.writeInt(y);
                         }
                       
                     }    
                     else if(juegando == 4)
                     {
                         enemigo3.salida.writeInt(16);
                         enemigo3.salida.writeInt(cantidad);
                        for (int i = 0; i < cantidad; i++ ){
                             tipo = entrada.readUTF();
                             x = entrada.readInt();
                             y = entrada.readInt();
                             enemigo3.salida.writeUTF(tipo);
                             enemigo3.salida.writeInt(x);
                             enemigo3.salida.writeInt(y);
                         }
                     }
                 break;
             }
             
                
             
          }
        catch (IOException e) {
              System.out.println("El cliente termino la conexion");break;}
        }
          
    	
    	servidor.ventana.mostrar("Se removio un usuario");
        
    	try
    	{
            servidor.ventana.mostrar("Se desconecto un usuario: "+nameUser);
        
             cliente.close();
         
        }
          catch(Exception et)
        {servidor.ventana.mostrar("no se puede cerrar el socket");}
}
           
        
     
     // Envia su nombre a todos los demas usuarios excepto él
     public void enviaUser()
     {
        if (enemigo != null)
        {
            System.out.println("hola mundo");
        }
     }

}


