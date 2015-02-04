/*
 * JuegoGato.java
 *
 * Created on 2 de diciembre de 2008, 06:36 PM
 */

package gato;

import Servidor.ServidorGato;
import gato.Armeria;
import gato.Bodega;
import gato.Cliente;
import gato.Estructura;
import gato.Mercado;
import gato.Mundo;
import gato.Portal;
import gato.Templo;
import gato.escogerArmeria;
import gato.mina;
import gato.ventanaMercado;
import java.awt.LayoutManager;
import java.awt.event.MouseAdapter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.LayoutStyle;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.lang.Math;
import java.util.Random;

/**
 *
 * @author  Alejandro
 */
public class JuegoGato extends javax.swing.JFrame {
    
    int xTemporal = 0;
    int yTemporal = 0;
    String tmp = null;
    public JuegoGato() {
        try {
            //ARREGLAR AQUI LOS CLIENTES
            // esto es parte del gato
            initComponents();
            jPanel1.setLayout(null);
            generarTablero();
            generarTableroEnemigo();
            // Cra una cliente que es su coenxion al server
            cliente = new Cliente(this);
            cliente.conexion();
            // pide el status al server, el server le enviara
            // al cliente el numero jugador que es y el nombre
            // enemigo
            cliente.salida.writeInt(3);
            
            
          
        } catch (IOException ex) {
           
        }
    }
    
    //CON ESTO ES LO Q VOY A VER A CUAL HAY  Q MOSTRAR LA MATRIZ Y DEMAS
    //----------------------------------
    Cliente cliente;
    Cliente cliente2;
    Cliente cliente3;
    Cliente cliente4;
    //----------------------------------
    
    
    // cambiar este valor para dimensiones
    public static int DIMENSIONES = 15;
    // Tablero con objetos JButton
    JButton[][] tableroLabels = new JButton[DIMENSIONES][DIMENSIONES];
    JButton[][] tableroLabelsEnemigo = new JButton[DIMENSIONES][DIMENSIONES];
    //atributos del juego
    int turnoJugador = 1;
    int numeroJugador;
    int cantidadJugadores;
    int contadorBombas = 0;
    int contadorCombos = 0;
    int actual = 1;
    boolean  juegoIniciado = false;
    private ArrayList<Estructura>  aConectar  = new ArrayList(); // aqui entran los objetos a conectar
    private boolean aceptandoConectores = false;
    private boolean eliminando = false;
    public static int Mercados = 1;
    public static int Mundos = 1;
    public static int Conectores = 2;
    public static int Minas = 2;
    public static int Armerias = 2;
    public static int Templos = 2;
    public static int Misiles = 2;
    private static int Multis = 2;
    private static int Bombas = 2;
    private static int Combos = 2;
    private static ArrayList<String> inicioFin = new ArrayList();
    private static int choosen = 0;
    public static int dinero = 4000;
    public static int acero = 0;
    private static int produccionArmas = 0;
    private static int comodines = 10;
    private static int naves = 5;
    private static boolean proteccion = false;
    private static int protegidoPor = 0;
    private static boolean iniciar = false;
    private static int espias = 5;
    public static boolean conexionMercado = false;
    public static Estructura [][] tableroLogico = new Estructura[15][15];
    int iniciado = 0;

    
    public static int getComodines() {
        return comodines;
    }

    public static void setComodines(int comodines) {
        JuegoGato.comodines = comodines;
    }
    public static boolean isIniciar() {
        return iniciar;
    }

    public static void setIniciar(boolean iniciar) {
        JuegoGato.iniciar = iniciar;
    }

    
    public static boolean isProteccion() {
        return proteccion;
    }
    
    void disminuirProteccion()
    {
        System.out.println("entro a l avra de disminuir" + protegidoPor);
       protegidoPor--;
       if(protegidoPor == 0)
       {
           proteccion = false;
           labelProtected.setVisible(false);
           numeroTurnoProtegido.setVisible(false);
       }
       else
       {
        String ponemos = Integer.toString(protegidoPor); 
        numeroTurnoProtegido.setText(ponemos);
       }
    }
    public static void setProteccion(boolean nproteccion) {
        System.out.print("estoy entrando a esta funcion");
        Random rand = new Random();
        int random = rand.nextInt(7);
        protegidoPor = random +6;
        proteccion = nproteccion;
        System.out.println("ne protegieron");
        setProtegidoPor(protegidoPor);
        String poner = Integer.toString(protegidoPor);
        numeroTurnoProtegido.setText(poner);
        labelProtected.setVisible(true);
        numeroTurnoProtegido.setVisible(true);
    }

    boolean seraProtegido()
    {
        System.out.println("aqui pregunto aver si es true q mierda");
        if(proteccion)
            return true;
        else
            return false;
    }
    
    void rotuloProtegido()
    {
        enemigoProtegido.setVisible(true);
    }
    
    void rotuloDesprotegido()
    {
        enemigoProtegido.setVisible(false);
    }
    
    public static void espiaAux(){
        JOptionPane.showMessageDialog(null, "Para activar el espía debes presionar en el"
                + "tablero enemigo", "INFO", 1);
    }
    
    public static int getProtegidoPor() {
        return protegidoPor;
    }

    public static void setProtegidoPor(int protegidoPor) {
        protegidoPor = protegidoPor;
    }
    
    public static int getNaves() {
        return naves;
    }

    public static void setNaves(int naves) {
        JuegoGato.naves = naves;
    }

    public static int getEspias() {
        return espias;
    }

    public static void setEspias(int espias) {
        JuegoGato.espias = espias;
    }
    
    
    public static int getProduccionArmas() {
        return produccionArmas;
    }

    public static void setProduccionArmas(int produccionArmas) {
        JuegoGato.produccionArmas = produccionArmas;
    }
    
    
    

    public static int getAcero() {
        return acero;
    }

    public static void setAcero(int acero) {
        JuegoGato.acero = acero;
    }

    

    public static ArrayList<String> getInicioFin() {
        return inicioFin;
    }

    public static void setInicioFin(ArrayList<String> inicioFin) {
        JuegoGato.inicioFin = inicioFin;
    }

    public static int getMercados() {
        return Mercados;
    }

    public static void setMercados(int Mercados) {
        JuegoGato.Mercados = Mercados;
    }

    public static int getMundos() {
        return Mundos;
    }

    public static void setMundos(int Mundos) {
        JuegoGato.Mundos = Mundos;
    }

    public static int getConectores() {
        return Conectores;
    }

    public static void setConectores(int Conectores) {
        JuegoGato.Conectores = Conectores;
    }

    public static int getMinas() {
        return Minas;
    }

    public static void setMinas(int Minas) {
        JuegoGato.Minas = Minas;
    }

    public static int getArmerias() {
        return Armerias;
    }

    public static void setArmerias(int Armerias) {
        JuegoGato.Armerias = Armerias;
    }

    public static int getTemplos() {
        return Templos;
    }

    public static void setTemplos(int Templos) {
        JuegoGato.Templos = Templos;
    }

    public static int getMisiles() {
        return Misiles;
    }

    public static void setMisiles(int Misiles) {
        JuegoGato.Misiles = Misiles;
    }

    public static int getMultis() {
        return Multis;
    }

    public static void setMultis(int Multis) {
        JuegoGato.Multis = Multis;
    }

    public static int getBombas() {
        return Bombas;
    }

    public static void setBombas(int Bombas) {
        JuegoGato.Bombas = Bombas;
    }

    public static int getCombos() {
        return Combos;
    }

    public static void setCombos(int Combos) {
        JuegoGato.Combos = Combos;
    }

    public static int getChoosen() {
        return choosen;
    }

    public static void setChoosen(int choosen) {
        JuegoGato.choosen = choosen;
    }

    public static int getDinero() {
        return dinero;
    }

    public static void setDinero(int dinero) {
        JuegoGato.dinero = dinero;
    }
    //en esta lista van a estar el nombre de tods los componentes que están en juego
    //servirá para terminar el juego y comenzarlo
    ArrayList<String> componentes = new ArrayList();
   
      public static void limpiarVisitados()
    {
        for(int i =0; i==15 ;i++)
        {
            for(int j =0; j==15 ;j++)
            {
                   if(tableroLogico[i][j] != null)
                       tableroLogico[i][j].setVisitado(false);
            }
        }
    }
    
    
    
    public static boolean existeEnTablero(Estructura estructura)
    {
        for(int i =0; i==15 ;i++)
        {
            for(int j =0; j==15 ;j++)
            {
                   if(estructura.equals(tableroLogico[i][j]))
                       return true;
            }
        }
        return false;
    }
    
    public static void eliminarReferencias(Estructura eliminado)
    {   
        for(int i =0; i==15 ;i++)
        {
            for(int j =0; j==15 ;j++)
            {
                for(Estructura estructura : tableroLogico[i][j].getConectores())
                {
                    if(estructura.equals(eliminado))
                        tableroLogico[i][j].getConectores().remove(eliminado);
                }
            }
        }
    }
    
    void labelDeJugado(int number)
    {
        tmp = Integer.toString(number);
        labelJugado.setText(tmp);
        return;
    }
    public void recibirDisparo(int x, int y)
    {
        Estructura estructura = tableroLogico[x][y];
        tableroLogico[x][y] = null;
        
        if(!existeEnTablero(estructura))
            eliminarReferencias(estructura);
    }
    
    void darMensaje()
    {
        JOptionPane.showMessageDialog(null, "¡La guerra ha comenzado!", "SOBREVIVE", 1);
    }
    void generarTablero()
    {
        for(int i=0;i<DIMENSIONES;i++)
        {
            for(int j=0;j<DIMENSIONES;j++)
            {
           System.out.println(i+","+j);
                tableroLabels[i][j] = new JButton();
                    
                //añade al panel el boton;
                jPanel1.add(tableroLabels[i][j]);
                // coloca dimensiones y localidad
                tableroLabels[i][j].setBounds(50+30*i, 75+30*j, 30, 30);
                // coloca el comand como i , j 
                tableroLabels[i][j].setActionCommand(i+","+j);//i+","+j
                
                                
                //aclickSobreTablero(evt);ñade el listener al boton
                tableroLabels[i][j].addMouseListener(new MouseAdapter() {
                public void mouseClicked(java.awt.event.MouseEvent evt) {                       
                    clickSobreTablero(evt);                   
                }
                }); 
                // en logico indica estado en disponible
            }
        }
        hacerAgujeros();
    }
    
    void generarTableroEnemigo()
    {
        for(int i=0;i<DIMENSIONES;i++)
        {
            for(int j=0;j<DIMENSIONES;j++)
            {                
                // coloca imagen a todos vacio
                tableroLabelsEnemigo[i][j] = new JButton();
                //añade al panel el boton;
                //tableroLabelsEnemigo[i][j].setEnabled(false);
                jPanel1.add(tableroLabelsEnemigo[i][j]);
                // coloca dimensiones y localidad
                tableroLabelsEnemigo[i][j].setBounds(650+30*i, 75+30*j, 30, 30);
                // coloca el comand como i , j 
                tableroLabelsEnemigo[i][j].setActionCommand(i+","+j);//i+","+j
               
                //aclickSobreTablero(evt);ñade el listener al boton
                tableroLabelsEnemigo[i][j].addMouseListener(new MouseAdapter() {
                public void mouseClicked(java.awt.event.MouseEvent evt) {
                    try {
                        clickSobreEnemigo(evt);
                    } catch (IOException ex) {
                        Logger.getLogger(JuegoGato.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    
                }
                });
                // en logico indica estado en disponible
                
            }
        }
    }
   
    // reiniciar el juego es poner todo como en un inicio
  
    public void hacerAgujeros()
    {
        AgujeroNegro agujeroUno = new AgujeroNegro("agujero"); 
        AgujeroNegro agujeroDos = new AgujeroNegro("agujero"); 
        Random rand = new Random();
        int random = rand.nextInt(15); 
        int segundoRandom = rand.nextInt(15);
        int terceRandom = rand.nextInt(15);
        int cuartoRandom = rand.nextInt(15);
        tableroLogico[random][segundoRandom] = agujeroUno;
        tableroLogico[terceRandom][cuartoRandom] = agujeroDos;
        tableroLabels[random][segundoRandom].setBackground(Color.DARK_GRAY);
        tableroLabels[terceRandom][cuartoRandom].setBackground(Color.DARK_GRAY);
                
    }
    public void agujereando() throws IOException
    {
        Random rand = new Random();
        int randomw = rand.nextInt(15); 
        int segundoRandomw = rand.nextInt(15);
        cliente.salida.writeInt(9);
        cliente.salida.writeInt(numeroJugador);
        cliente.salida.writeInt(actual); // AQUI LE MANDO A QUIEN ESTOY ATACANDO
        cliente.salida.writeInt(randomw);
        cliente.salida.writeInt(segundoRandomw);
        int terceRandomw = rand.nextInt(15);
        int cuartoRandomw = rand.nextInt(15);
        cliente.salida.writeInt(9);
        cliente.salida.writeInt(numeroJugador);
        cliente.salida.writeInt(actual); // AQUI LE MANDO A QUIEN ESTOY ATACANDO
        cliente.salida.writeInt(terceRandomw);
        cliente.salida.writeInt(cuartoRandomw);
        int quintoRandow = rand.nextInt(15);
        int sextoRandow = rand.nextInt(15);
        cliente.salida.writeInt(9);
        cliente.salida.writeInt(numeroJugador);
        cliente.salida.writeInt(actual); // AQUI LE MANDO A QUIEN ESTOY ATACANDO
        cliente.salida.writeInt(quintoRandow);
        cliente.salida.writeInt(sextoRandow);
        
    }
    
     public void clickSobreEnemigo(java.awt.event.MouseEvent evt) throws IOException
     {
         if(turnoJugador != numeroJugador)
         {
             JOptionPane.showMessageDialog(null, "este no es tu turno", "INFO", 1);
             return;
         }
         JButton botonTemp = (JButton)evt.getComponent();
        // obtiene el i,j de action command del boton
        String identificadorBoton = botonTemp.getActionCommand();
        int fila = 
          Integer.parseInt(identificadorBoton.substring(0,identificadorBoton.indexOf(",")));
        int columna = 
          Integer.parseInt(identificadorBoton.substring(1+identificadorBoton.indexOf(",")));
        if(contadorCombos!=0 && contadorCombos<10)
        {
            cliente.salida.writeInt(fila);
            cliente.salida.writeInt(columna);
            contadorCombos++;
            if (contadorCombos == 10)
            {
                contadorCombos = 0;
                JOptionPane.showMessageDialog(null, "Combo-shot enviado correctamente", "INFO", 1);
            }
            System.out.println("estoy entrando al contador de los combos" + contadorCombos);
            return;
        }
        if(contadorBombas!=0 && contadorBombas <3)
        {
            //botonTemp.setOpaque(true); HACERLE EL BRETE AL BOTON
            cliente.salida.writeInt(fila);
            cliente.salida.writeInt(columna);
            contadorBombas++;
            if(contadorBombas == 3)
            {
                contadorBombas = 0;
                JOptionPane.showMessageDialog(null, "Bomba enviada correctamente", "INFO", 1);
            }
            System.out.println("estoy entrando al contador de la bombas" + contadorBombas);
            return;
        }
        // separa el string del action comand para obtener columnas
        //AQUI LE ESTOY MANDO UN MISIL-------------------------------------------MISIL
        if(choosen == 7) // este es un misil
        {
            if(cantidadJugadores == 2)
            {
                //System.out.println("si lo estoy mandando");
                cliente.salida.writeInt(9);
                cliente.salida.writeInt(numeroJugador);
                cliente.salida.writeInt(actual); // AQUI LE MANDO A QUIEN ESTOY ATACANDO
                cliente.salida.writeInt(fila);
                cliente.salida.writeInt(columna);
                System.out.println("estoy mandando un multi s");
            }
            else if(cantidadJugadores == 3)
            {
                cliente.salida.writeInt(9);
                cliente.salida.writeInt(numeroJugador);
                cliente.salida.writeInt(actual); // AQUI LE MANDO A QUIEN ESTOY ATACANDO
                cliente.salida.writeInt(fila);
                cliente.salida.writeInt(columna);
                System.out.println("estoy mandando un multi shot");
            }
            else if(cantidadJugadores == 4)
            {
                cliente.salida.writeInt(9);
                cliente.salida.writeInt(numeroJugador);
                cliente.salida.writeInt(actual); // AQUI LE MANDO A QUIEN ESTOY ATACANDO
                cliente.salida.writeInt(fila);
                cliente.salida.writeInt(columna);
                System.out.println("estoy mandando un multi shot");
            }
        }
        
        //AQUILE ESTOY MANDANDO UN MULTI - SHOT.......................MULTI - SHOT
        else if(choosen == 8)// este es un multi - shot
        {           
                cliente.salida.writeInt(10);
                cliente.salida.writeInt(numeroJugador);
                cliente.salida.writeInt(actual); // AQUI LE MANDO A QUIEN ESTOY ATACANDO
                cliente.salida.writeInt(fila);
                cliente.salida.writeInt(columna);
                System.out.println("estoy mandando un multi shot");
            
        }
        //AQUI EMPIEZA LA VRA DE LAS BOMBAS...............................BOMBAS
        
        else if(choosen == 9) // esta es una bomba
        {
            
                System.out.println("AQUI DEBERIA DE ENTRAR CUANDO ES UNA BOMBA");
                cliente.salida.writeInt(11);
                //botonTemp.setPressedIcon(null); HACERLO SI TENGO TIEMPO
                cliente.salida.writeInt(numeroJugador);
                cliente.salida.writeInt(actual);
                cliente.salida.writeInt(fila);
                cliente.salida.writeInt(columna);
                contadorBombas++;
            
        }
        
        //AQUI EMPIEZA LA VRA DE LOS COMBO -- SHOT--------------------------------------COMBOS
        else if(choosen == 10)// este es un combo-shot
        {
           if(cantidadJugadores == 2)
            {
                System.out.println("aqui debe haber entrado con el combo-shot");
                cliente.salida.writeInt(12); //verificar estos a partir del 9 que son otras armas...
                cliente.salida.writeInt(numeroJugador);
                cliente.salida.writeInt(actual);
                cliente.salida.writeInt(fila);
                cliente.salida.writeInt(columna);
                contadorCombos++;
            } 
        }
        //AQUI VA LO DE LAS NAVES
        else if(choosen == 11)
        {
            cliente.salida.writeInt(13); 
            cliente.salida.writeInt(actual);
            cliente.salida.writeInt(numeroJugador);
            cliente.salida.writeInt(fila);
            cliente.salida.writeInt(columna);
        }
        // aqui esta lo del espia
        else if(choosen == 12)
        {
                System.out.println("llego a la primera etapa de espia");
                cliente.salida.writeInt(14);
                cliente.salida.writeInt(numeroJugador);
                cliente.salida.writeInt(actual); 
        }
        
                
        
     }
  
    public static void setEnManoLabel(JLabel enManoLabel) {
        JuegoGato.enManoLabel = enManoLabel;
    }
    
    
    boolean haGanado()
    {      
        return false;
    }

    public static JLabel getEnManoLabel() {
        return enManoLabel;
    }
    
    // set el nombre del enemigo
    public void setEnemigo(String enem)
    {
        lblEnemigo.setText("vs. "+enem);
    }
    
    
    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jToggleButton1 = new javax.swing.JToggleButton();
        jPopupMenu1 = new javax.swing.JPopupMenu();
        jPanel1 = new javax.swing.JPanel();
        lblEnemigo = new javax.swing.JLabel();
        txfMensaje = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        txaMensajes = new javax.swing.JTextArea();
        btnEnviar = new javax.swing.JButton();
        btnActualizar = new javax.swing.JButton();
        botonPrinArmeria = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        enManoLabel = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        botonAnterior = new javax.swing.JButton();
        cambiarSiguiente = new javax.swing.JButton();
        cambiarTurno = new javax.swing.JButton();
        labelProtected = new javax.swing.JLabel();
        botonIniciar = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        numeroTurnoProtegido = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        labelJugado = new javax.swing.JLabel();
        labelNumeroJugador = new javax.swing.JLabel();
        enemigoProtegido = new javax.swing.JLabel();
        botonMercadoNegro = new javax.swing.JButton();

        jToggleButton1.setText("jToggleButton1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(0, 102, 102));

        lblEnemigo.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lblEnemigo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        txaMensajes.setColumns(20);
        txaMensajes.setRows(5);
        jScrollPane1.setViewportView(txaMensajes);

        btnEnviar.setText("Enviar");
        btnEnviar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEnviarActionPerformed(evt);
            }
        });

        btnActualizar.setText("Actualizar");
        btnActualizar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnActualizarMouseClicked(evt);
            }
        });

        botonPrinArmeria.setText("Bodega");
        botonPrinArmeria.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                botonPrinArmeriaMouseClicked(evt);
            }
        });

        jLabel2.setText("En mano:");

        jPanel2.setBackground(new java.awt.Color(0, 0, 0));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 11, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        botonAnterior.setText("Ant.");
        botonAnterior.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                botonAnteriorMouseClicked(evt);
            }
        });

        cambiarSiguiente.setText("Sig.");
        cambiarSiguiente.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                cambiarSiguienteMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                cambiarSiguienteMouseEntered(evt);
            }
        });

        cambiarTurno.setText("Pasar");
        cambiarTurno.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                cambiarTurnoMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                cambiarTurnoMouseEntered(evt);
            }
        });

        labelProtected.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        labelProtected.setForeground(new java.awt.Color(255, 0, 0));
        labelProtected.setText("Protegido");

        botonIniciar.setText("Iniciar");
        botonIniciar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                botonIniciarMouseClicked(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 0, 0));
        jLabel3.setText("Turno de Jugador: ");

        numeroTurnoProtegido.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        numeroTurnoProtegido.setForeground(new java.awt.Color(255, 0, 0));
        numeroTurnoProtegido.setText("1");

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 0, 0));
        jLabel4.setText("Jugador");

        labelJugado.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        labelJugado.setForeground(new java.awt.Color(255, 0, 0));

        labelNumeroJugador.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        labelNumeroJugador.setForeground(new java.awt.Color(255, 0, 0));
        labelNumeroJugador.setText("1");

        enemigoProtegido.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        enemigoProtegido.setForeground(new java.awt.Color(255, 0, 0));
        enemigoProtegido.setText("Protegido");

        botonMercadoNegro.setText("Mercado Negro");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(txfMensaje, javax.swing.GroupLayout.PREFERRED_SIZE, 253, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnEnviar, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 334, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(enManoLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addComponent(botonIniciar, javax.swing.GroupLayout.DEFAULT_SIZE, 69, Short.MAX_VALUE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(botonPrinArmeria, javax.swing.GroupLayout.DEFAULT_SIZE, 73, Short.MAX_VALUE)
                                    .addComponent(cambiarTurno, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGap(51, 51, 51))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(labelProtected)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(numeroTurnoProtegido, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(9, 9, 9)
                        .addComponent(jLabel3)
                        .addGap(14, 14, 14)
                        .addComponent(labelNumeroJugador, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(labelJugado, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(enemigoProtegido)
                        .addGap(75, 75, 75))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(81, 81, 81)
                        .addComponent(botonAnterior)
                        .addGap(34, 34, 34)))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(lblEnemigo, javax.swing.GroupLayout.PREFERRED_SIZE, 217, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(151, 151, 151))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(btnActualizar, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(43, 43, 43)
                        .addComponent(cambiarSiguiente)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(botonMercadoNegro)
                        .addGap(24, 24, 24))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblEnemigo, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(27, 27, 27)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(labelProtected)
                            .addComponent(jLabel3)
                            .addComponent(numeroTurnoProtegido, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4)
                            .addComponent(labelJugado, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(labelNumeroJugador, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(24, 24, 24)
                        .addComponent(enemigoProtegido)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 539, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel2)
                                    .addComponent(enManoLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(cambiarTurno)
                                    .addComponent(botonIniciar)))
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txfMensaje, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnEnviar)
                            .addComponent(botonPrinArmeria)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(botonAnterior)
                            .addComponent(cambiarSiguiente)
                            .addComponent(btnActualizar)
                            .addComponent(botonMercadoNegro))
                        .addContainerGap())))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

private void btnEnviarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEnviarActionPerformed
        try {
            System.out.println("Estoy tratando de mandar un mensaje");
            // se toma lo escrito
            String mensaje = txfMensaje.getText();
            // se muestra en el text area
            txaMensajes.append(cliente.nomCliente+"> "+ mensaje + "\n");
            // se limpia el textfield
            txfMensaje.setText("");

            // envia al server la opcion 4 para que le pase al enemigo
            // lo escrito
            cliente.salida.writeInt(4);
            // le envia el mensaje
            cliente.salida.writeUTF(cliente.nomCliente+"> "+mensaje);                     
        } catch (IOException ex) {
            System.out.println("me estoy cayendo aqui");
        }
    
    
}//GEN-LAST:event_btnEnviarActionPerformed

    private void botonPrinArmeriaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_botonPrinArmeriaMouseClicked
        Bodega cosas = new Bodega(this,true);
        System.out.print("numero " + comodines);
        //pasando variable de int a string
        String stringMercados = Integer.toString(Mercados);
        String stringMundos = Integer.toString(Mundos);
        String stringConector = Integer.toString(Conectores);
        String stringMinas = Integer.toString(Minas);
        String stringArmeria = Integer.toString(Armerias);
        String stringTemplos = Integer.toString(Templos);
        String stringMisiles = Integer.toString(Misiles);
        String stringMultis = Integer.toString(Multis);
        String stringBombas = Integer.toString(Bombas);
        String stringCombos = Integer.toString(Combos);
        String stringComodines = Integer.toString(comodines);
        String stringEspias = Integer.toString(espias);
        String stringNaves = Integer.toString(naves);
        
        if(Mercados == 0)
         cosas.getBotonMercados().setEnabled(false);
        else
            cosas.getNumeroMercados().setText(stringMercados);
        if(Mundos == 0)
         cosas.getBotonMundos().setEnabled(false);
        else
            cosas.getNumeroMundos().setText(stringMundos);
        if(Conectores == 0)
         cosas.getBotonConectores().setEnabled(false);
        else
            cosas.getNumeroConectores().setText(stringConector);
        if(Minas == 0)
         cosas.getBotonMinas().setEnabled(false);
        else
            cosas.getNumeroMina().setText(stringMinas);
        if(Armerias == 0)
         cosas.getBotonArmerias().setEnabled(false);
        else
            cosas.getNumeroArmerias().setText(stringArmeria);
        if(Templos == 0)
         cosas.getBotonTemplo().setEnabled(false);
        else
            cosas.getNumeroTemplos().setText(stringTemplos);
        if(Misiles == 0)
         cosas.getBotonMisil().setEnabled(false);
        else
            cosas.getNumeroMisiles().setText(stringMisiles);
        if(Multis == 0)
         cosas.getBotonMulti().setEnabled(false);
        else
            cosas.getNumeroMulti().setText(stringMultis);
        if(Bombas == 0)
         cosas.getBotonBomba().setEnabled(false);
        else
            cosas.getNumeroBombas().setText(stringBombas);
        if(Combos == 0)
         cosas.getBotonCombo().setEnabled(false);
        else
            cosas.getNumeroCombos().setText(stringCombos);
        if(comodines == 0)
            cosas.getComo().setEnabled(false);
        else
            cosas.getNumeroComodines().setText(stringComodines);
        if(espias == 0)
            cosas.getBotonEspias().setEnabled(false);
        else
            cosas.getNumeroEspias().setText(stringEspias);
        if(naves == 0)
            cosas.getBotonNave().setEnabled(false);
        else
            cosas.getNumeroNaves().setText(stringNaves);
        cosas.setVisible(true);
        
    }//GEN-LAST:event_botonPrinArmeriaMouseClicked

    private void botonAnteriorMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_botonAnteriorMouseClicked
        if(cantidadJugadores == 3)
        {
            if(actual == 1)
                actual = 2;
            else if(actual == 2)
                actual = 1;
        }
        else if(cantidadJugadores == 4)
        {
            if(actual == 1)
                actual = 2;
            else if(actual == 2)
                actual--;
            else if(actual == 3)
                actual--;
        }
        
        if(cantidadJugadores == 2)
         {
             System.out.println("entre a los dos jugadores");
             try {
                 cliente.salida.writeInt(7);
                 cliente.salida.writeInt(actual);
                 cliente.salida.writeInt(numeroJugador);
             } catch (IOException ex) {
                 Logger.getLogger(JuegoGato.class.getName()).log(Level.SEVERE, null, ex);
             }
         }
         else if(cantidadJugadores == 3)
         {
             System.out.println("entre a los tres jugadores");
             try {
                 cliente.salida.writeInt(7);
                 cliente.salida.writeInt(actual);
                 cliente.salida.writeInt(numeroJugador);
             } catch (IOException ex) {
                 Logger.getLogger(JuegoGato.class.getName()).log(Level.SEVERE, null, ex);
             }
         }
         else if(cantidadJugadores == 4)
         {
             System.out.println("entre a los cuatro jugadores");
             try {
                 cliente.salida.writeInt(7);
                 cliente.salida.writeInt(actual);
                 cliente.salida.writeInt(numeroJugador);
             } catch (IOException ex) {
                 Logger.getLogger(JuegoGato.class.getName()).log(Level.SEVERE, null, ex);
             }
         }
    }//GEN-LAST:event_botonAnteriorMouseClicked

    private void cambiarTurnoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cambiarTurnoMouseClicked
        try {
            if(turnoJugador == numeroJugador)
            {
               System.out.println("este es mi numero de jugador  " + numeroJugador);               
               if(cantidadJugadores == 2)
               {
                   if(turnoJugador == 2)
                   {
                       turnoJugador = 1;
                   }
                   else
                   {
                       turnoJugador++;
                   }
               }
               else if(cantidadJugadores == 3)
               {
                   if(turnoJugador == 1)
                       turnoJugador++;
                   else if(turnoJugador == 2)
                       turnoJugador++;
                   else if(turnoJugador == 3)
                       turnoJugador = 1;
               }
               else if(cantidadJugadores == 4)
               {
                    if(turnoJugador == 1)
                       turnoJugador++;
                   else if(turnoJugador == 2)
                       turnoJugador++;
                   else if(turnoJugador == 3)
                       turnoJugador++;
                   else if(turnoJugador == 4)
                       turnoJugador = 1;
               }
               cliente.salida.writeInt(5);
               cambiarLabelTurno();
            }
            else
                JOptionPane.showMessageDialog(null, "Este no es tu turno", "INFO", 1);
                          
        } catch (IOException ex) {
            
        }
    }//GEN-LAST:event_cambiarTurnoMouseClicked

    private void cambiarTurnoMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cambiarTurnoMouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_cambiarTurnoMouseEntered

    private void btnActualizarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnActualizarMouseClicked
         //System.out.println("soy nueva estrategia  " + turnoJugador);
         if(cantidadJugadores == 2)
         {
             System.out.println("entre a los dos jugadores");
             try {
                 cliente.salida.writeInt(7);
                 cliente.salida.writeInt(actual);
                 cliente.salida.writeInt(numeroJugador);
             } catch (IOException ex) {
                 Logger.getLogger(JuegoGato.class.getName()).log(Level.SEVERE, null, ex);
             }
         }
         else if(cantidadJugadores == 3)
         {
             System.out.println("entre a los tres jugadores");
             try {
                 cliente.salida.writeInt(7);
                 cliente.salida.writeInt(actual);
                 cliente.salida.writeInt(numeroJugador);
             } catch (IOException ex) {
                 Logger.getLogger(JuegoGato.class.getName()).log(Level.SEVERE, null, ex);
             }
         }
         else if(cantidadJugadores == 4)
         {
             System.out.println("entre a los cuatro jugadores");
             try {
                 cliente.salida.writeInt(7);
                 cliente.salida.writeInt(actual);
                 cliente.salida.writeInt(numeroJugador);
             } catch (IOException ex) {
                 Logger.getLogger(JuegoGato.class.getName()).log(Level.SEVERE, null, ex);
             }
         }
    }//GEN-LAST:event_btnActualizarMouseClicked

    private void cambiarSiguienteMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cambiarSiguienteMouseClicked
        if(cantidadJugadores == 3)
        {
            if(actual == 1)
                actual++;
            else if(actual == 2)
                actual = 1;
        }
        else if(cantidadJugadores == 4)
        {
            if(actual == 1)
                actual++;
            else if(actual == 2)
                actual++;
            else if(actual == 3)
                actual = 1;
        }
        
        if(cantidadJugadores == 2)
         {
             System.out.println("entre a los dos jugadores");
             try {
                 cliente.salida.writeInt(7);
                 cliente.salida.writeInt(actual);
                 cliente.salida.writeInt(numeroJugador);
             } catch (IOException ex) {
                 Logger.getLogger(JuegoGato.class.getName()).log(Level.SEVERE, null, ex);
             }
         }
         else if(cantidadJugadores == 3)
         {
             System.out.println("entre a los tres jugadores" + actual);
             try {
                 cliente.salida.writeInt(7);
                 cliente.salida.writeInt(actual);
                 cliente.salida.writeInt(numeroJugador);
             } catch (IOException ex) {
                 Logger.getLogger(JuegoGato.class.getName()).log(Level.SEVERE, null, ex);
             }
         }
         else if(cantidadJugadores == 4)
         {
             System.out.println("entre a los cuatro jugadores");
             try {
                 cliente.salida.writeInt(7);
                 cliente.salida.writeInt(actual);
                 cliente.salida.writeInt(numeroJugador);
             } catch (IOException ex) {
                 Logger.getLogger(JuegoGato.class.getName()).log(Level.SEVERE, null, ex);
             }
         }
    }//GEN-LAST:event_cambiarSiguienteMouseClicked

    private void cambiarSiguienteMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cambiarSiguienteMouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_cambiarSiguienteMouseEntered

    private void botonIniciarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_botonIniciarMouseClicked
        try {        
           
            cliente.salida.writeInt(2);
            
        } catch (IOException ex) {
            Logger.getLogger(JuegoGato.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_botonIniciarMouseClicked
    
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new JuegoGato().setVisible(true);
                labelProtected.setVisible(false);
                numeroTurnoProtegido.setVisible(false);
                enemigoProtegido.setVisible(false);
           }
        });
    }
    
    public void cambiarLabelTurno()
    {
        String nextString = Integer.toString(turnoJugador);
        labelNumeroJugador.setText(nextString);
    }
    public void mostrar(String texto)
    {
        txaMensajes.append(texto+"\n");
    }
    
    public static void protegerJuego()
    {
        protegidoPor = (int)Math.random()*6;
        protegidoPor = protegidoPor + 6;
        proteccion = true;
        labelProtected.setVisible(true);
       
    }
    
    public void desProtegerJuego()
    {
        protegidoPor = 0;
        proteccion = false;
        labelProtected.setVisible(false);
        
    }
    public void clickSobreTablero(java.awt.event.MouseEvent evt)
    {
        System.out.println("soy el jugador numero..." + numeroJugador);
        System.out.println("con el turno..." + turnoJugador);
        // obtiene el boton 
        JButton botonTemp = (JButton)evt.getComponent();
        // obtiene el i,j de action command del boton
        String identificadorBoton = botonTemp.getActionCommand();
        
        // separa el string del action comand para obtener columnas
     int fila = 
          Integer.parseInt(identificadorBoton.substring(0,identificadorBoton.indexOf(",")));
         int columna = Integer.parseInt(identificadorBoton.substring(1+identificadorBoton.indexOf(",")));
          if(aceptandoConectores)
        {
            if(!aConectar.get(0).getTipo().equals("portal"))
            {
                if(tableroLogico[fila][columna].getTipo().equals("portal"))
                {

                        Estructura strucTemp = tableroLogico[fila][columna];
                        aConectar.add(strucTemp);
                        System.out.println("estoy conectando");                           
                        aceptandoConectores = false;
                      
                        for(int i=0;i < aConectar.get(0).getConectores().size();i++)
                        {
                            System.out.println("soy el de la lista" + aConectar.get(0).getConectores().get(i));
                            System.out.println("soy el temp" + aConectar.get(0).getConectores().get(i));
                            if(strucTemp.equals(aConectar.get(0).getConectores().get(i)))
                            {
                                JOptionPane.showMessageDialog(null, "Estos componentes ya se encuentran conectados");
                                return;
                            }
                        }
                        aConectar.get(0).getConectores().add(strucTemp);
                        System.out.println("soy el portal conectado " + aConectar.get(0).getConectores().get(0));
                        JOptionPane.showMessageDialog(null, "Componentes conectados correctamente");
                        aConectar.clear();
                        return;
                }
                else
                {
                    JOptionPane.showMessageDialog(this, "El componente destino no es un portal.","Error",0);
                    aceptandoConectores = false;
                    aConectar.clear();
                    return;
                }
            }
            else
            {
                Estructura strucTemp = tableroLogico[fila][columna];
                aConectar.add(strucTemp);
                System.out.println("estoy conectando abajo");                           
                aceptandoConectores = false;
                for(int i=0;i < aConectar.get(0).getConectores().size();i++)
                {
                   if(strucTemp.equals(aConectar.get(0).getConectores().get(i)))
                   {
                        JOptionPane.showMessageDialog(null, "Estos componentes ya se encuentran conectados");
                        aConectar.clear();
                        return;
                   }
                }
                aConectar.get(0).getConectores().add(strucTemp);
                JOptionPane.showMessageDialog(null, "Componentes conectados correctamente");
                aConectar.clear();
                return;    
            }
        }
        
        if(eliminando)
        {
            Estructura objetoEliminar = tableroLogico[fila][columna];
        }
        
        if(tableroLogico[fila][columna] == null)
        {
        System.out.println("soy fila" + fila);
        System.out.println("soy columna" + columna);
        if(choosen!=0)
        {
            if(choosen == 1)
            {
                final JuegoGato var = this;
                
                Mercado mercado = new Mercado("mercado");
                Random rand = new Random();
                int random = rand.nextInt(2);
                 
                if(random == 0 )
                {
                    if(columna == 0){
                        tableroLabels[fila][columna].setBackground(Color.green);
                        tableroLabels[fila][columna+1].setBackground(Color.green);
                
                        tableroLogico[fila][columna+1] = mercado;
                        tableroLogico[fila][columna] = mercado;
                        Mercados--;
                    }
                    else{
                        tableroLabels[fila][columna].setBackground(Color.green);
                        tableroLabels[fila][columna-1].setBackground(Color.green);
                     
                        tableroLogico[fila][columna] = mercado;
                        tableroLogico[fila][columna-1] = mercado;
                        Mercados--;
                    }
                }
                else{
                    if(fila == 14){
                        tableroLabels[fila][columna].setBackground(Color.green);
                        tableroLabels[fila-1][columna].setBackground(Color.green);
                       
                        tableroLogico[fila][columna] = mercado;
                        tableroLogico[fila-1][columna] = mercado;
                        Mercados--;
                    }
                    else{
                        tableroLabels[fila][columna].setBackground(Color.green);
                        tableroLabels[fila+1][columna].setBackground(Color.green);
                   
                        tableroLogico[fila][columna] = mercado;
                        tableroLogico[fila+1][columna] = mercado;
                        Mercados--;                       
                    }
                }
               
                if(Mercados == 0)
                {
                    choosen = 0;
                    enManoLabel.setText("");
                }
                return;
                
            }
            else if(choosen == 2)
            {   
                
                /*          
                if(iniciado == false)
                {
                    iniciarJuego++;
                    Mundos--;
                    preJuego();
                }
                */
                if(Mundos == 0)
                {
                    choosen = 0;
                    enManoLabel.setText("");
                }              
               
                else if(fila == 0 && columna == 14){
                    Mundo mundo = new Mundo("mundo");
                    tableroLabels[fila][columna].setBackground(Color.BLUE);
                    tableroLabels[fila+1][columna].setBackground(Color.BLUE);
                    tableroLabels[fila][columna-1].setBackground(Color.BLUE);
                    tableroLabels[fila+1][columna-1].setBackground(Color.BLUE);
                    tableroLogico[fila][columna] = mundo;
                    tableroLogico[fila+1][columna] = mundo;
                    tableroLogico[fila][columna-1] = mundo;
                    tableroLogico[fila+1][columna-1] = mundo;
                    Mundos--;
                }
                else if(columna == 14 && (fila >= 1 && fila <= 13)){
                    Mundo mundo = new Mundo("mundo");
                    tableroLabels[fila][columna].setBackground(Color.BLUE);
                    tableroLabels[fila+1][columna].setBackground(Color.BLUE);
                    tableroLabels[fila][columna-1].setBackground(Color.BLUE);
                    tableroLabels[fila+1][columna-1].setBackground(Color.BLUE);
                    tableroLogico[fila][columna] = mundo;
                    tableroLogico[fila+1][columna] = mundo;
                    tableroLogico[fila][columna-1] = mundo;
                    tableroLogico[fila+1][columna-1] = mundo;
                    Mundos--;
                }
                else if(fila == 0){
                    Mundo mundo = new Mundo("mundo");
                    tableroLabels[fila][columna].setBackground(Color.BLUE);
                    tableroLabels[fila+1][columna].setBackground(Color.BLUE);
                    tableroLabels[fila][columna+1].setBackground(Color.BLUE);
                    tableroLabels[fila+1][columna+1].setBackground(Color.BLUE);
                    tableroLogico[fila][columna] = mundo;
                    tableroLogico[fila+1][columna] = mundo;
                    tableroLogico[fila][columna+1] = mundo;
                    tableroLogico[fila+1][columna+1] = mundo;
                    Mundos--;
                }
                else if(fila == 14 && columna == 14)
                {
                    Mundo mundo = new Mundo("mundo");
                    tableroLabels[fila][columna].setBackground(Color.BLUE);
                    tableroLabels[fila][columna-1].setBackground(Color.BLUE);
                    tableroLabels[fila-1][columna-1].setBackground(Color.BLUE);
                    tableroLabels[fila-1][columna].setBackground(Color.BLUE);
                    tableroLogico[fila][columna] = mundo;
                    tableroLogico[fila][columna-1] = mundo;
                    tableroLogico[fila-1][columna-1] = mundo;
                    tableroLogico[fila-1][columna] = mundo;
                    Mundos--;
                }
                else if(fila == 0 && columna == 14)
                {
                    Mundo mundo = new Mundo("mundo");
                    tableroLabels[fila][columna-1].setBackground(Color.BLUE);
                    tableroLabels[fila+1][columna].setBackground(Color.BLUE);
                    tableroLabels[fila+1][columna-1].setBackground(Color.BLUE);
                    tableroLogico[fila][columna-1] = mundo;
                    tableroLogico[fila+1][columna] = mundo;
                    tableroLogico[fila+1][columna-1] = mundo;
                    tableroLogico[fila][columna-1] = mundo;
                    Mundos--;
                }
                else
                {
                    Mundo mundo = new Mundo("mundo");
                    tableroLabels[fila][columna].setBackground(Color.BLUE);
                    tableroLabels[fila-1][columna].setBackground(Color.BLUE);
                    tableroLabels[fila][columna+1].setBackground(Color.BLUE);
                    tableroLabels[fila-1][columna+1].setBackground(Color.BLUE);
                    tableroLogico[fila][columna] = mundo;
                    tableroLogico[fila-1][columna] = mundo;
                    tableroLogico[fila][columna+1] = mundo;
                    tableroLogico[fila-1][columna+1] = mundo;
                    Mundos--;
                   
                }
                if(Mundos == 0)
                {
                    choosen = 0;
                    enManoLabel.setText("");
                }
                return;
                
            }
            else if(choosen == 3)
            {
                Portal portal = new Portal("portal");
                tableroLabels[fila][columna].setBackground(Color.BLACK);
                tableroLogico[fila][columna] = portal;
                Conectores --;
                if(Conectores == 0)
                {
                    choosen = 0;
                    enManoLabel.setText("");
                }
                return;
            }
            else if(choosen == 5)
            {
                mina Mina = new mina("mina");
                Random rand = new Random();
                int random = rand.nextInt(2);
                if(random == 0 )
                {
                    if(columna == 0){
                        tableroLabels[fila][columna].setBackground(Color.cyan);
                        tableroLabels[fila][columna+1].setBackground(Color.cyan);
                        tableroLogico[fila][columna+1] = Mina;
                        tableroLogico[fila][columna] = Mina;
                        Mercados--;
                    }
                    else{
                        tableroLabels[fila][columna].setBackground(Color.cyan);
                        tableroLabels[fila][columna-1].setBackground(Color.cyan);
                        tableroLogico[fila][columna] = Mina;
                        tableroLogico[fila][columna-1] = Mina;
                        Mercados--;
                    }
                }
                else{
                    if(fila == 14){
                        tableroLabels[fila][columna].setBackground(Color.cyan);
                        tableroLabels[fila-1][columna].setBackground(Color.cyan);
                        tableroLogico[fila][columna] = Mina;
                        tableroLogico[fila-1][columna] = Mina;
                        Mercados--;
                    }
                    else{
                        tableroLabels[fila][columna].setBackground(Color.cyan);
                        tableroLabels[fila+1][columna].setBackground(Color.green);
                        tableroLogico[fila][columna] = Mina;
                        tableroLogico[fila+1][columna] = Mina;
                        Mercados--;                       
                    }
                }
                if(Minas == 0)
                {
                    choosen = 0;
                    enManoLabel.setText("");
                }
                return;
            }
            else if(choosen == 4)
            {
                String tipoArma = null;
                int cantidadAcero = 0;
                escogerArmeria dialogArmas = new escogerArmeria(this,true);
                dialogArmas.setVisible(true);
                if(produccionArmas == 1)
                {
                    tipoArma = "misil";
                    cantidadAcero = 500;
                }
                else if(produccionArmas == 2)
                {
                    tipoArma = "multi";
                    cantidadAcero = 1000;
                }
                else if(produccionArmas == 3)
                {
                    tipoArma = "bombas";
                    cantidadAcero = 2000;
                }
                else
                {
                    tipoArma = "combos";
                    cantidadAcero = 5000;
                }
                    
                Armeria armeria = new Armeria("armeria",cantidadAcero,tipoArma);
                Random rand = new Random();
                int random = rand.nextInt(2);
                if(random == 0 )
                {
                    if(columna == 0){
                        tableroLabels[fila][columna].setBackground(Color.red);
                        tableroLabels[fila][columna+1].setBackground(Color.red);
                        tableroLogico[fila][columna+1] = armeria;
                        tableroLogico[fila][columna] = armeria;
                        Mercados--;
                    }
                    else{
                        tableroLabels[fila][columna].setBackground(Color.red);
                        tableroLabels[fila][columna-1].setBackground(Color.red);
                        tableroLogico[fila][columna] = armeria;
                        tableroLogico[fila][columna-1] = armeria;
                        Mercados--;
                    }
                }
                else{
                    if(fila == 14){
                        tableroLabels[fila][columna].setBackground(Color.red);
                        tableroLabels[fila-1][columna].setBackground(Color.red);
                        tableroLogico[fila][columna] = armeria;
                        tableroLogico[fila-1][columna] = armeria;
                        Mercados--;
                    }
                    else{
                        tableroLabels[fila][columna].setBackground(Color.red);
                        tableroLabels[fila+1][columna].setBackground(Color.red);
                        tableroLogico[fila][columna] = armeria;
                        tableroLogico[fila+1][columna] = armeria;
                        Mercados--;                       
                    }
                }
                if(Armerias == 0)
                {
                    choosen = 0;
                    enManoLabel.setText("");
                }
                return;
            }
            else if(choosen == 6)
            {
                Templo templo = new Templo("templo");
                Random rand = new Random();
                int random = rand.nextInt(2);
                if(random == 0 )
                {
                    if(columna == 0){
                        tableroLabels[fila][columna].setBackground(Color.green);
                        tableroLabels[fila][columna+1].setBackground(Color.green);
                        tableroLogico[fila][columna+1] = templo;
                        tableroLogico[fila][columna] = templo;
                        Mercados--;
                    }
                    else{
                        tableroLabels[fila][columna].setBackground(Color.green);
                        tableroLabels[fila][columna-1].setBackground(Color.green);
                        tableroLogico[fila][columna] = templo;
                        tableroLogico[fila][columna-1] = templo;
                        Mercados--;
                    }
                }
                else{
                    if(fila == 14){
                        tableroLabels[fila][columna].setBackground(Color.green);
                        tableroLabels[fila-1][columna].setBackground(Color.green);
                        tableroLogico[fila][columna] = templo;
                        tableroLogico[fila-1][columna] = templo;
                        Mercados--;
                    }
                    else{
                        tableroLabels[fila][columna].setBackground(Color.green);
                        tableroLabels[fila+1][columna].setBackground(Color.green);
                        tableroLogico[fila][columna] = templo;
                        tableroLogico[fila+1][columna] = templo;
                        Mercados--;                       
                    }
                }
            }
            
        
        if(Templos == 0)
                {
                    choosen = 0;
                    enManoLabel.setText("");
                }
        }
        return;
        }
        // aqui es donde voy a hacer la vra de los CONECTORES
        if(tableroLogico[fila][columna]!= null)
        {
            if(tableroLogico[fila][columna].getTipo().equals("mundo"))
                JOptionPane.showMessageDialog(null, "Seleccione el portal al cual desea conectar este mundo");
            //else if(tableroLogico[fila][columna].getTipo().equals("mercado"))
                //JOptionPane.showMessageDialog(null, "Seleccione el portal al cual desea conectar este mercado");
            else if(tableroLogico[fila][columna].getTipo().equals("mina"))
                JOptionPane.showMessageDialog(null, "Seleccione el portal al cual desea conectar esta mina");
            else if(tableroLogico[fila][columna].getTipo().equals("armeria"))
                JOptionPane.showMessageDialog(null, "Seleccione el portal al cual desea conectar este armeria");
            else if(tableroLogico[fila][columna].getTipo().equals("templo"))
                JOptionPane.showMessageDialog(null, "Seleccione el portal al cual desea conectar este templo");
            else if(tableroLogico[fila][columna].getTipo().equals("portal"))
                JOptionPane.showMessageDialog(null, "Seleccione el componente al cual desea conectar este portal");
            else if(tableroLogico[fila][columna].getTipo().equals("mercado"))
            {
                        conexMercado decision = new conexMercado(this,true);
                         ventanaMercado ventana = new ventanaMercado(this,true);
                         decision.setVisible(true);
                         if(conexionMercado)
                         {
                            decision.setVisible(false);
                            ventana.setLabelDinero(dinero);
                            ventana.setVisible(true);   
                            return;
                         }
                         JOptionPane.showMessageDialog(null, "Seleccione el portal al cual desea conectar este mercado");
            }
            Estructura structTemp = tableroLogico[fila][columna];
            aConectar.add(structTemp);
            aceptandoConectores = true;
            return;
        // si gano el jugador 1 lo indica
          
    }
    }
   
  
 
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botonAnterior;
    private javax.swing.JButton botonIniciar;
    private javax.swing.JButton botonMercadoNegro;
    private javax.swing.JButton botonPrinArmeria;
    private javax.swing.JButton btnActualizar;
    private javax.swing.JButton btnEnviar;
    private javax.swing.JButton cambiarSiguiente;
    private javax.swing.JButton cambiarTurno;
    private static javax.swing.JLabel enManoLabel;
    private static javax.swing.JLabel enemigoProtegido;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPopupMenu jPopupMenu1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JToggleButton jToggleButton1;
    private javax.swing.JLabel labelJugado;
    private javax.swing.JLabel labelNumeroJugador;
    private static javax.swing.JLabel labelProtected;
    private javax.swing.JLabel lblEnemigo;
    private static javax.swing.JLabel numeroTurnoProtegido;
    private javax.swing.JTextArea txaMensajes;
    private javax.swing.JTextField txfMensaje;
    // End of variables declaration//GEN-END:variables

    
    
}
