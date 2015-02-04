package gato;
import java.awt.Color;
import java.awt.Point;
import java.io.*;
import java.util.ArrayList;
import java.util.Random;

class threadCliente extends Thread{
   //solo de lectura
    DataInputStream entrada;
   JuegoGato vcli; //referencia acliente
   public threadCliente (DataInputStream entrada,JuegoGato vcli) throws IOException
   {
      this.entrada=entrada;
      this.vcli=vcli;
   }
   public void run()
   {
       //VARIABLES
      String menser="",amigo="";
      
      // solamente lee lo que el servidor threadServidor le envia
      while(true)
      {       
         try{
             int opcion=0;
             // esta leyendo siempre la instruccion, un int
             
             opcion=entrada.readInt();
             System.out.println("Soy opcion" + opcion);
            switch(opcion)
            {
               case 1://mensaje enviado
                   vcli.juegoIniciado = true;
                   vcli.darMensaje();
                  break;
               case 2://se lee el nombre del user  
                  vcli.iniciado++;
                  
                  if(vcli.cantidadJugadores == 2 && vcli.iniciado == 2)
                    {                       
                        vcli.cliente.salida.writeInt(1);
                    }
                  else if(vcli.cantidadJugadores == 3 && vcli.iniciado == 3)
                      vcli.cliente.salida.writeInt(1);
                  else if(vcli.cantidadJugadores == 4 && vcli.iniciado == 4)
                      vcli.cliente.salida.writeInt(1);
                  else
                      vcli.cliente.salida.writeInt(2);
                  break;
               case 3://lee el numero del jugador
                  vcli.numeroJugador = entrada.readInt();
                  // lee el nomnre del enemigo vuando pide el status y lo coloca
                  // en la pantalla cliente
                  vcli.cantidadJugadores = entrada.readInt();
                  vcli.setEnemigo(entrada.readUTF());
                  vcli.labelDeJugado(vcli.numeroJugador);
                  System.out.println("OP3, lee numero de jugador "+vcli.numeroJugador);
                  System.out.println("OP3, lee cantidad jugadores "+vcli.cantidadJugadores);
                  break;
                case 4:
                    // lee el mensaje
                  menser = entrada.readUTF();
                  // muestra el mensjae en pantalla.
                  System.out.println("OP4, lee mensaje "+menser);
                  vcli.mostrar(menser);
                break;
                
                case 5:
                    System.out.println("estoy aqui metido" + vcli.cantidadJugadores + vcli.turnoJugador);
                    if(vcli.cantidadJugadores == 2)
                    {
                        System.out.println("estoy aqui metido en CANTIDADJUGADORES" + vcli.cantidadJugadores + vcli.turnoJugador);
                        if(vcli.turnoJugador == 1)
                        {
                            vcli.turnoJugador++;
                            vcli.cambiarLabelTurno();
                        }
                        else if(vcli.turnoJugador == 2)
                        {
                            
                            vcli.turnoJugador = 1;
                            vcli.cambiarLabelTurno();
                        }
                    }
                    else if(vcli.cantidadJugadores == 3)
                    {
                        if(vcli.turnoJugador == 1)
                        {
                            vcli.turnoJugador++;
                            vcli.cambiarLabelTurno();
                        }                        
                        else if(vcli.turnoJugador == 2)
                        {
                            vcli.turnoJugador++;
                            vcli.cambiarLabelTurno();
                        }
                        else if(vcli.turnoJugador == 3)
                        {
                            vcli.turnoJugador = 1;
                            vcli.cambiarLabelTurno();
                        }
                    }
                    else if(vcli.cantidadJugadores == 4)
                    {
                        if(vcli.turnoJugador == 1)
                        {
                            vcli.turnoJugador++;
                            vcli.cambiarLabelTurno();
                        }                        
                        else if(vcli.turnoJugador == 2)
                        {
                            vcli.turnoJugador++;
                            vcli.cambiarLabelTurno();
                        }
                        else if(vcli.turnoJugador == 3)
                        {
                            vcli.turnoJugador++;
                            vcli.cambiarLabelTurno();
                        }
                        else if(vcli.turnoJugador == 4)
                        {
                            vcli.turnoJugador = 1;
                            vcli.cambiarLabelTurno();                          
                        }
                    }
                 break;
                    
                case 6:
                    //cambiando turno
                    
                    int nuevoTurno = entrada.readInt();
                    if(nuevoTurno == 1)
                    {
                    vcli.turnoJugador = 2;
                    }
                    else
                    {
                        vcli.turnoJugador = 1;
                    }
                    System.out.println("OP6 cambia turno" + nuevoTurno);
                break;
                case 7:
                    
                    vcli.cliente.salida.writeInt(8);
                    int numeroJugador = entrada.readInt();
                    vcli.cliente.salida.writeInt(numeroJugador);
                    System.out.println("en la segunda aqui no entro" + numeroJugador);
                    if(vcli.seraProtegido())
                    {
                        System.out.println("si estoy protegido yujuu");
                        vcli.cliente.salida.writeBoolean(true);
                    }
                    else
                        vcli.cliente.salida.writeBoolean(false);
                    for(int i = 0; i< 15;i++)
                    {
                        for(int j = 0;j<15;j++)
                        {
                            if(vcli.tableroLogico[i][j] == null)
                            {
                                String ceroCero = "";
                                Boolean ceroCeroVis = false;
                             
                                        vcli.cliente.salida.writeUTF(ceroCero);
                                        vcli.cliente.salida.writeBoolean(ceroCeroVis);
                                 
                            }
                            else
                            {
                                String ceroCero = vcli.tableroLogico[i][j].getTipo();
                                Boolean ceroCeroVis = false;
                                if(numeroJugador == 1)
                                    ceroCeroVis = vcli.tableroLogico[i][j].isVisibleUno();
                                else if(numeroJugador == 2)
                                    ceroCeroVis = vcli.tableroLogico[i][j].isVisibleDos();
                                else if(numeroJugador == 3)
                                    ceroCeroVis = vcli.tableroLogico[i][j].isVisibleTres();
                                else if(numeroJugador == 4)
                                    ceroCeroVis = vcli.tableroLogico[i][j].isVisibleCuatro();
                                
                                System.out.println("aqui entre tantas veces " + ceroCero);
                                vcli.cliente.salida.writeUTF(ceroCero);
                                vcli.cliente.salida.writeBoolean(ceroCeroVis);                                                              
                            }
                        }
                    }
                                   
                   break;
                case 8:
                    boolean rotulo = entrada.readBoolean();
                    if(rotulo == true)
                        vcli.rotuloProtegido();
                    else
                        vcli.rotuloDesprotegido();
                    for (int i = 0; i< 15; i++)
                    {
                        for(int j = 0; j<15;j++)
                        {
                            String primerCuadro = entrada.readUTF();
                            if(primerCuadro.equals("mercado"))
                            {
                                vcli.tableroLabelsEnemigo[i][j].setBackground(Color.green);
                            }
                            else if(primerCuadro.equals("portal"))
                            {
                                vcli.tableroLabelsEnemigo[i][j].setBackground(Color.BLACK);
                            }
                            else if(primerCuadro.equals("mina"))
                            {
                                vcli.tableroLabelsEnemigo[i][j].setBackground(Color.green);
                            }
                            else if(primerCuadro.equals("armeria"))
                            {
                                vcli.tableroLabelsEnemigo[i][j].setBackground(Color.red);
                            }
                            else if(primerCuadro.equals("templo"))
                            {
                                vcli.tableroLabelsEnemigo[i][j].setBackground(Color.MAGENTA);
                            }
                            else
                            {
                                //System.out.println("estoy entrando al else mas IMPORTANTE");
                                vcli.tableroLabelsEnemigo[i][j].setBackground(Color.ORANGE);
                            }
                            //System.out.println("me acabo de salirin third" + primerCuadro);
                        }
                    }
                    break;
                case 9:
                     int contadorObjetos = 0;
                     int sentBy = entrada.readInt();
                     int filaConsulta = entrada.readInt();
                     int columnaConsulta = entrada.readInt();
                     
                     if(vcli.seraProtegido())
                     {
                         System.out.println("SI ESTOY PROTEGIDO DE DISPAROS");
                         vcli.disminuirProteccion();
                        break; 
                     }
                                         
                    if(vcli.tableroLogico[filaConsulta][columnaConsulta]==null)
                    {
                        System.out.println("estoy vacio y por ahorita no hago nada");
                        //enviar el mensaje al chat de tal jugador ha fallado!!!!!!!!!!!!!!!!
                    } 
                    else 
                    {
                        Estructura eliminado = vcli.tableroLogico[filaConsulta][columnaConsulta];
                        if(vcli.tableroLogico[filaConsulta][columnaConsulta].getTipo().equals("agujero"))
                        {
                            vcli.agujereando();
                            break;
                        }
                        if(eliminado.getTipo().equals("portal"))
                        {
                            //hacer algoritmo y return
                            for(int i = 0; i<15;i++)
                            {
                                for(int j = 0;j<15;j++)
                                {
                                    if(vcli.tableroLogico[i][j]!=null)
                                    {
                                        for (int m = 0;m< vcli.tableroLogico[i][j].getConectores().size();m++)
                                        {
                                            if(vcli.tableroLogico[i][j].getConectores().get(m).equals(eliminado))
                                            {
                                                ///System.out.println("estoy logrando borrar algoritmo funciona");
                                                vcli.tableroLogico[i][j].getConectores().remove(m);
                                            }
                                        }
                                    }
                               }
                            }
                            
                        }
                        for(int i = 0; i<15;i++)
                        {
                            for(int j = 0; j<15;j++)
                            {
                                if(eliminado == vcli.tableroLogico[filaConsulta][columnaConsulta])
                                {
                                    contadorObjetos++;
                                }
                            }
                        }
                        if(contadorObjetos == 1)
                        {
                             for(int i = 0; i<15;i++)
                            {
                                for(int j = 0;j<15;j++)
                                {
                                    if(vcli.tableroLogico[i][j]!=null)
                                    {
                                        for (int m = 0;m< vcli.tableroLogico[i][j].getConectores().size();m++)
                                        {
                                            if(vcli.tableroLogico[i][j].getConectores().get(m).equals(eliminado))
                                            {
                                                System.out.println("estoy logrando borrar cuando no es un portal YEAH");
                                                vcli.tableroLogico[i][j].getConectores().remove(m);
                                            }
                                        }
                                    }
                               }
                            }
                        }
                        vcli.tableroLabels[filaConsulta][columnaConsulta].setBackground(Color.yellow);
                        JuegoGato.tableroLogico[filaConsulta][columnaConsulta] = null;
                        
                        //HACIENDO RECORRIDO A VER Q.................
                        for(int n = 0; n<15;n++)
                        {
                            for (int h = 0; h<15;h++)
                            {
                                if(vcli.tableroLogico[n][h] == null)
                                {
                                   
                                } else {
      
                                        vcli.tableroLogico[n][h].enseñarEstructura(sentBy,vcli.tableroLogico);
                                       }
                                    
                                }
                            }
                        }
                        //QUI SE CAMBIA POR IMAGENES
                        //AQUI AHAGO LO DLE RECORRIDO A VER SI ES EL ULTIMO ELEMENTO SE HACE CON UN FOR Y PASO POR TODOS LOS GET CONECTORES
                    
                    break;
                case 10:
                    System.out.println("me esta llegando el disparo de un multi shot");
                     int acertado = 4;
                     int sentedBy = entrada.readInt();
                     int contadorObjetosMulti = 0;
                     int filaMulti = entrada.readInt();
                     int columnaMulti = entrada.readInt();
                     boolean lePegue = false;
                     //System.out.println("estoy llegando a dond ese debria cambiar");
                     
                     if(vcli.seraProtegido())
                     {
                         System.out.println("SI ESTOY PROTEGIDO DE DISPAROS");
                         vcli.disminuirProteccion();
                         break; 
                     }
                     
                    if(vcli.tableroLogico[filaMulti][columnaMulti]!=null)
                    {
                        acertado = 0;
                        if(vcli.tableroLogico[filaMulti][columnaMulti].getTipo().equals("agujero"))
                        {
                            lePegue = true;                  
                        }
                        Estructura eliminado = vcli.tableroLogico[filaMulti][columnaMulti];
                        if(eliminado.getTipo().equals("portal"))
                        {
                            //hacer algoritmo y return
                            for(int i = 0; i<15;i++)
                            {
                                for(int j = 0;j<15;j++)
                                {
                                    if(vcli.tableroLogico[i][j]!=null)
                                    {
                                        for (int m = 0;m< vcli.tableroLogico[i][j].getConectores().size();m++)
                                        {
                                            if(vcli.tableroLogico[i][j].getConectores().get(m).equals(eliminado))
                                            {
                                                System.out.println("estoy logrando borrar algoritmo funciona");
                                                vcli.tableroLogico[i][j].getConectores().remove(m);
                                            }
                                        }
                                    }
                               }
                            }
                            
                        }
                        for(int i = 0; i<15;i++)
                        {
                            for(int j = 0; j<15;j++)
                            {
                                if(eliminado == vcli.tableroLogico[filaMulti][columnaMulti])
                                {
                                    contadorObjetosMulti++;
                                }
                            }
                        }
                        if(contadorObjetosMulti == 1)
                        {
                             for(int i = 0; i<15;i++)
                            {
                                for(int j = 0;j<15;j++)
                                {
                                    if(vcli.tableroLogico[i][j]!=null)
                                    {
                                        for (int m = 0;m< vcli.tableroLogico[i][j].getConectores().size();m++)
                                        {
                                            if(vcli.tableroLogico[i][j].getConectores().get(m).equals(eliminado))
                                            {
                                                System.out.println("estoy logrando borrar cuando no es un portal YEAH");
                                                vcli.tableroLogico[i][j].getConectores().remove(m);
                                            }
                                        }
                                    }
                               }
                            }
                        }
                        vcli.tableroLabels[filaMulti][columnaMulti].setBackground(Color.yellow);
                        vcli.tableroLogico[filaMulti][columnaMulti] = null;
                        contadorObjetosMulti = 0;
                        for(int n = 0; n<15;n++)
                        {
                            for (int h = 0; h<15;h++)
                            {
                                if(vcli.tableroLogico[n][h] == null)
                                {
                                   
                                } else {
      
                                        vcli.tableroLogico[n][h].enseñarEstructura(sentedBy,vcli.tableroLogico);
                                       }
                                    
                                }
                            }
                        
                        
                        while(acertado<4)
                        {
                            filaMulti = (int)Math.random()*15;
                            columnaMulti = (int)Math.random()*15;
                             if(vcli.tableroLogico[filaMulti][columnaMulti]!=null)
                    {
                        eliminado = vcli.tableroLogico[filaMulti][columnaMulti];
                        if(eliminado.getTipo().equals("portal"))
                        {
                            //hacer algoritmo y return
                            for(int i = 0; i<15;i++)
                            {
                                for(int j = 0;j<15;j++)
                                {
                                    if(vcli.tableroLogico[i][j]!=null)
                                    {
                                        for (int m = 0;m< vcli.tableroLogico[i][j].getConectores().size();m++)
                                        {
                                            if(vcli.tableroLogico[i][j].getConectores().get(m).equals(eliminado))
                                            {
                                                System.out.println("estoy logrando borrar algoritmo funciona");
                                                vcli.tableroLogico[i][j].getConectores().remove(m);
                                            }
                                        }
                                    }
                               }
                            }
                            
                        }
                        for(int i = 0; i<15;i++)
                        {
                            for(int j = 0; j<15;j++)
                            {
                                if(eliminado == vcli.tableroLogico[filaMulti][columnaMulti])
                                {
                                    contadorObjetosMulti++;
                                }
                            }
                        }
                        if(contadorObjetosMulti == 1)
                        {
                             for(int i = 0; i<15;i++)
                            {
                                for(int j = 0;j<15;j++)
                                {
                                    if(vcli.tableroLogico[i][j]!=null)
                                    {
                                        for (int m = 0;m< vcli.tableroLogico[i][j].getConectores().size();m++)
                                        {
                                            if(vcli.tableroLogico[i][j].getConectores().get(m).equals(eliminado))
                                            {
                                                System.out.println("estoy logrando borrar cuando no es un portal YEAH");
                                                vcli.tableroLogico[i][j].getConectores().remove(m);
                                            }
                                        }
                                    }
                               }
                            }
                        }
                        vcli.tableroLabels[filaMulti][columnaMulti].setBackground(Color.yellow);
                        vcli.tableroLogico[filaMulti][columnaMulti] = null;
                        contadorObjetosMulti = 0;
                        for(int n = 0; n<15;n++)
                        {
                            for (int h = 0; h<15;h++)
                            {
                                if(vcli.tableroLogico[n][h] == null)
                                {
                                   
                                } else {
      
                                        vcli.tableroLogico[n][h].enseñarEstructura(sentedBy,vcli.tableroLogico);
                                       }
                                    
                                }
                            }
                        }
                    
                             System.out.println("estoy sumando el acetado");
                             acertado++;
                        }
                    } 
                    if(lePegue)
                    {
                        vcli.agujereando();  
                        break;
                    }
                    break;
                
                case 11:
                    boolean lehePegado = false;
                    System.out.println("estoty entrando a donde deberia resibir las bombas");
                    int enviadoDesde = entrada.readInt();
                    int [] temporal = new int[12];
                    int filaUno = entrada.readInt();
                    int columnaUno = entrada.readInt();
                    int filaUnoUno = entrada.readInt();
                    int columnaUnoUno = entrada.readInt();
                    int filaDos = entrada.readInt();
                    int columnaDos = entrada.readInt();
                    int filaDosDos = entrada.readInt();
                    int columnaDosDos = entrada.readInt();
                    int filaTres = entrada.readInt();
                    int columnaTres = entrada.readInt();
                    int filaTresTres = entrada.readInt();
                    int columnaTresTres = entrada.readInt();
                    contadorObjetos = 0;
                    temporal[0] = filaUno;
                    temporal[1] = columnaUno;
                    temporal[2] = filaUnoUno;
                    temporal[3] = columnaUnoUno;
                    temporal[4] = filaDos;
                    temporal[5] = columnaDos;
                    temporal[6] = filaDosDos;
                    temporal[7] = columnaDosDos;
                    temporal[8] = filaTres;
                    temporal[9] = columnaTres;
                    temporal[10] = filaTresTres;
                    temporal[11] = columnaTresTres;
                    System.out.println("voy a imprimir todos los valores");
                    for(int y = 0;y<12;y++)
                    {
                        System.out.println(temporal[y]);
                    }
                    for(int k = 0; k<12;k++)
                    {
                         if(vcli.seraProtegido())
                     {
                         System.out.println("SI ESTOY PROTEGIDO DE DISPAROS");
                         vcli.disminuirProteccion();
                         k++;
                     }
                         else if(vcli.tableroLogico[temporal[k]][temporal[k+1]]==null)
                    {
                        System.out.println("estoy vacio y por ahorita no hago nada" + temporal[k]+ temporal[k+1]);
                        k++;
                        //enviar el mensaje al chat de tal jugador ha fallado!!!!!!!!!!!!!!!!
                    } 
                    else 
                    {
                        Estructura eliminado = vcli.tableroLogico[temporal[k]][temporal[k+1]];
                        if(eliminado.getTipo().equals("portal"))
                        {                        
                            //hacer algoritmo y return
                            for(int i = 0; i<15;i++)
                            {
                                for(int j = 0;j<15;j++)
                                {
                                    if(vcli.tableroLogico[i][j]!=null)
                                    {
                                        for (int m = 0;m< vcli.tableroLogico[i][j].getConectores().size();m++)
                                        {
                                            if(vcli.tableroLogico[i][j].getConectores().get(m).equals(eliminado))
                                            {
                                                System.out.println("estoy logrando borrar algoritmo funciona");
                                                vcli.tableroLogico[i][j].getConectores().remove(m);
                                            }
                                        }
                                    }
                               }
                            }
                            
                        }
                        else
                        {
                     
                           for(int i = 0; i<15;i++)
                            {
                                for(int j = 0;j<15;j++)
                                {
                                    if(vcli.tableroLogico[i][j]!=null)
                                    {
                                        if(!eliminado.getTipo().equals("agujero"))
                                        {
                                        for (int m = 0;m< vcli.tableroLogico[i][j].getConectores().size();m++)
                                        {
                                            if(vcli.tableroLogico[i][j].getConectores().get(m).equals(eliminado))
                                            {
                                                System.out.println("estoy logrando borrar algoritmo funciona");
                                                vcli.tableroLogico[i][j].getConectores().remove(m);
                                                if(eliminado.getTipo().equals("agujero"))
                                                    lehePegado = true;
                                            }
                                        }
                                    }
                                    }else
                                        lehePegado = true;
                               }
                            }  
                        }
                        for(int i = 0; i<15;i++)
                        {
                            for(int j = 0; j<15;j++)
                            {
                                if(eliminado == vcli.tableroLogico[temporal[k]][temporal[k+1]])
                                {
                                    contadorObjetos++;
                                }
                            }
                        }
                        if(contadorObjetos == 1)
                        {
                             for(int i = 0; i<15;i++)
                            {
                                for(int j = 0;j<15;j++)
                                {
                                    if(vcli.tableroLogico[i][j]!=null)
                                    {
                                        for (int m = 0;m< vcli.tableroLogico[i][j].getConectores().size();m++)
                                        {
                                            if(vcli.tableroLogico[i][j].getConectores().get(m).equals(eliminado))
                                            {
                                                System.out.println("estoy logrando borrar cuando no es un portal YEAH");
                                                vcli.tableroLogico[i][j].getConectores().remove(m);
                                            }
                                        }
                                    }
                               }
                            }
                        }
                        vcli.tableroLabels[temporal[k]][temporal[k+1]].setBackground(Color.yellow);
                        vcli.tableroLogico[temporal[k]][temporal[k+1]] = null;
                        k++;
                    }
                        for(int n = 0; n<15;n++)
                        {
                            for (int h = 0; h<15;h++)
                            {
                                if(vcli.tableroLogico[n][h] == null)
                                {
                                   
                                } else {
      
                                        vcli.tableroLogico[n][h].enseñarEstructura(enviadoDesde,vcli.tableroLogico);
                                       }
                                    
                                }
                            }
                        }
                             
                    if(lehePegado)
                    {
                        vcli.agujereando();  
                        break;
                    }
                    
                    break;
                 
                case 12:
                    boolean pegado = false;
                    System.out.println("estoty entrando a donde deberia resibir los combos");
                    int niIdea = entrada.readInt();
                    int [] temporalCombo = new int[20]; 
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
                    contadorObjetos = 0;
                    temporalCombo[0] = filaComboUno;
                    temporalCombo[1] = columnaComboUno;
                    temporalCombo[2] = filaComboDos;
                    temporalCombo[3] = columnaComboDos;
                    temporalCombo[4] = filaComboTres;
                    temporalCombo[5] = columnaComboTres;
                    temporalCombo[6] = filaComboCuatro;
                    temporalCombo[7] = columnaComboCuatro;
                    temporalCombo[8] = filaComboCinco;
                    temporalCombo[9] = columnaComboCinco;
                    temporalCombo[10] = filaComboSeis;
                    temporalCombo[11] = columnaComboSeis;
                    temporalCombo[12] = filaComboSiete;
                    temporalCombo[13] = columnaComboSiete;
                    temporalCombo[14] = filaComboOcho;
                    temporalCombo[15] = columnaComboOcho;
                    temporalCombo[16] = filaComboNueve;
                    temporalCombo[17] = columnaComboNueve;
                    temporalCombo[18] = filaComboDiez;
                    temporalCombo[19] = columnaComboDiez;
                    System.out.println("voy a imprimir todos los valores");
                    for(int y = 0;y<20;y++)
                    {
                        System.out.println(temporalCombo[y]);
                    }
                    for(int k = 0; k<20;k++)
                    {
                         if(vcli.seraProtegido())
                     {
                         System.out.println("SI ESTOY PROTEGIDO DE DISPAROS");
                         vcli.disminuirProteccion();
                         k++;
                     }
                         else if(vcli.tableroLogico[temporalCombo[k]][temporalCombo[k+1]]==null)
                    {
                        System.out.println("estoy vacio y por ahorita no hago nada" + temporalCombo[k]+ temporalCombo[k+1]);
                        k++;
                        //enviar el mensaje al chat de tal jugador ha fallado!!!!!!!!!!!!!!!!
                    } 
                    else 
                    {
                        Estructura eliminado = vcli.tableroLogico[temporalCombo[k]][temporalCombo[k+1]];
                        if(eliminado.getTipo().equals("portal"))
                        {
                            //hacer algoritmo y return
                            for(int i = 0; i<15;i++)
                            {
                                if(!eliminado.getTipo().equals("agujero"))
                                {
                                for(int j = 0;j<15;j++)
                                {
                                    if(vcli.tableroLogico[i][j]!=null)
                                    {
                                        for (int m = 0;m< vcli.tableroLogico[i][j].getConectores().size();m++)
                                        {
                                            if(vcli.tableroLogico[i][j].getConectores().get(m).equals(eliminado))
                                            {
                                                System.out.println("estoy logrando borrar algoritmo funciona");
                                                vcli.tableroLogico[i][j].getConectores().remove(m);
                                                
                                            }
                                        }
                                    }
                               }
                            }
                                else
                                {
                                    pegado = true;
                                }
                            }
                        }
                        for(int i = 0; i<15;i++)
                        {
                            for(int j = 0; j<15;j++)
                            {
                                if(eliminado == vcli.tableroLogico[temporalCombo[k]][temporalCombo[k+1]])
                                {
                                    contadorObjetos++;
                                }
                            }
                        }
                        if(contadorObjetos == 1)
                        {
                             for(int i = 0; i<15;i++)
                            {
                                for(int j = 0;j<15;j++)
                                {
                                    if(vcli.tableroLogico[i][j]!=null)
                                    {
                                        for (int m = 0;m< vcli.tableroLogico[i][j].getConectores().size();m++)
                                        {
                                            if(vcli.tableroLogico[i][j].getConectores().get(m).equals(eliminado))
                                            {
                                                System.out.println("estoy logrando borrar cuando no es un portal YEAH");
                                                vcli.tableroLogico[i][j].getConectores().remove(m);
                                            }
                                        }
                                    }
                               }
                            }
                        }
                        vcli.tableroLabels[temporalCombo[k]][temporalCombo[k+1]].setBackground(Color.yellow);
                        vcli.tableroLogico[temporalCombo[k]][temporalCombo[k+1]] = null;
                        k++;
                    }
                    for(int n = 0; n<15;n++)
                        {
                            for (int h = 0; h<15;h++)
                            {
                                if(vcli.tableroLogico[n][h] == null)
                                {
                                   
                                } else {
      
                                        vcli.tableroLogico[n][h].enseñarEstructura(niIdea,vcli.tableroLogico);
                                       }
                                    
                                }
                            }
                    } 
                    if(pegado)
                    {
                        vcli.agujereando();  
                        break;
                    }
                    break;
                 
                case 13: // ESTA ES LA NAVE
                    System.out.println("Ya llegué");
                    int vieneDel = entrada.readInt();
                    int filaRadio  = entrada.readInt();
                    int columnaRadio = entrada.readInt();
                    String tipoDos = null;
                    int enviarFila = 0;
                    int enviarColumna = 0;
                    vcli.cliente.salida.writeInt(15);
                    vcli.cliente.salida.writeInt(vieneDel);

                    int x = columnaRadio-3;
                    int y = filaRadio-3;
                    
                    ArrayList<Point> coordenadas = new ArrayList();
                    ArrayList<Estructura> objetos = new ArrayList();
                    
                    for (int i = 0; i < 7; i++){
                        for (int e = 0 ; e < 7; e++){
                            if ( x < 0 || y < 0 || x > 14 || y > 14 || vcli.tableroLogico[x][y] == null ){
                               
                            }else{
                                coordenadas.add(new Point(x, y));
                                objetos.add(vcli.tableroLogico[x][y]);
                            }
                            y++;
                        }
                        y = filaRadio-3;
                        x++;
                    }
                    
                    int cantidades = objetos.size();
                    vcli.cliente.salida.writeInt(cantidades);
                    System.out.println("soy el SIZE:" + cantidades);
                    for(int h = 0; h < objetos.size(); h++)
                    {
                        System.out.println("hago for MUY importante");
                        tipoDos = objetos.get(h).getTipo();  
                        vcli.cliente.salida.writeUTF(tipoDos);
                        enviarFila = coordenadas.get(h).x;
                        vcli.cliente.salida.writeInt(enviarFila);
                        enviarFila = coordenadas.get(h).y;
                        vcli.cliente.salida.writeInt(enviarFila);
                    }
                    break;
                 
                case 14:
                    vcli.iniciado++;                
                  if(vcli.cantidadJugadores == 2 && vcli.iniciado == 2)
                    {                       
                        vcli.cliente.salida.writeInt(1);
                    }
                  else if(vcli.cantidadJugadores == 3 && vcli.iniciado == 3)
                      vcli.cliente.salida.writeInt(1);
                  else if(vcli.cantidadJugadores == 4 && vcli.iniciado == 4)
                      vcli.cliente.salida.writeInt(1);
                  break;
                  
               
                 
                case 15: // ESTE ES EL ESPIA
                    System.out.println("entre a random espcial");
                    int player = entrada.readInt();
                    String filon = null;
                    int columnon = 0;
                    vcli.cliente.salida.writeInt(15);
                    vcli.cliente.salida.writeInt(player);
                    Random randMore = new Random();
                    int number = randMore.nextInt(4);
                    ArrayList<Estructura> lugares = new ArrayList();
                    ArrayList<Point> posiciones = new ArrayList();
                    if (number == 0){
                        for (int i = 0; i < 7; i++){
                            for (int j = 0; j < 7; j++){
                                if ( vcli.tableroLogico[i][j] == null){
                                    
                                }else{
                                    lugares.add(vcli.tableroLogico[i][j]);
                                    posiciones.add(new Point(i,j));
                                }
                            }
                        }
                    }
                    else if (number == 1){
                         
                        for (int i = 7; i < 15; i++){
                            for (int j = 0; j < 7; j++){
                                if ( vcli.tableroLogico[i][j] == null){
                                    
                                }else{
                                    lugares.add(vcli.tableroLogico[i][j]);
                                    posiciones.add(new Point(i,j));
                                }
                            }
                        }
                    }
                    else if(number == 2){
                        for (int i = 0; i < 7; i++){
                            for (int j = 7; j < 15; j++){
                                if ( vcli.tableroLogico[i][j] == null){
                                    
                                }else{
                                    lugares.add(vcli.tableroLogico[i][j]);
                                    posiciones.add(new Point(i,j));
                                }
                                    
                            }
                        }
                    }
                    else{
                        for (int i = 7; i < 15; i++){
                            for (int j = 7; j < 15; j++){
                                if ( vcli.tableroLogico[i][j] == null){
                                    
                                }else{
                                    lugares.add(vcli.tableroLogico[i][j]);
                                    posiciones.add(new Point(i,j));
                                }
                                    
                            }
                        }
                    }
                    int cantidad = lugares.size();
                    vcli.cliente.salida.writeInt(cantidad);
                    for(int h = 0; h < lugares.size(); h++)
                    {
                        System.out.println("hago for importante");
                        filon = lugares.get(h).getTipo();  
                        vcli.cliente.salida.writeUTF(filon);
                        columnon = posiciones.get(h).x;
                        vcli.cliente.salida.writeInt(columnon);
                        columnon = posiciones.get(h).y;
                        vcli.cliente.salida.writeInt(columnon);
                    }
                    break;
                    
                case 16:
                    Informacion info = new Informacion();
                    int cant = entrada.readInt();
                    String tipo = null;
                    int xx = 0;
                    int yy = 0; 
                    for ( int i = 0; i < cant; i++){
                        tipo = entrada.readUTF();
                        xx = entrada.readInt();
                        yy = entrada.readInt();
                        info.getTexto().append("Tipo : " + tipo+ " Posicion: " + xx + "," + yy + "\n");
                    }
                    info.setVisible(true);
                    
                    break;
                 
               
            }
         }
         catch (IOException e){
            System.out.println("Error en la comunicaci�n "+"Informaci�n para el usuario");
            break;
         }
      }
      System.out.println("se desconecto el servidor");
   }

   
}