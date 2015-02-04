/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package net.tec.gui;

import java.sql.ResultSetMetaData;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import net.tec.example.client.Client;
import net.tec.example.to.AccommodationTO;
import net.tec.example.to.CountryTO;
import net.tec.example.to.EventTO;
import net.tec.example.to.GenderTO;
import net.tec.example.to.IndividualTO;
import net.tec.example.to.InstallationTO;
import net.tec.example.to.MetricTO;
import net.tec.example.to.SportTO;
import net.tec.example.to.TeamTO;

/**
 *
 * @author diego
 */

public class GUI extends javax.swing.JFrame {
    
    ResultSetMetaData rsm;
    DefaultTableModel dtm;
    
    /**
     * Creates new form GUI
     */
    public GUI() {
        initComponents();
        this.setLocationRelativeTo(null);
        cargarDatos();
        radioSeleccionado();
        Calendar cal1 = Calendar.getInstance();
                cal1.get(Calendar.YEAR);
    }
    
    private void cargarDatos(){
        Client client = new Client();
        Collection<MetricTO> metricList = client.requestSelectMetricTO();
        for(MetricTO m : metricList){
            this.comboBoxEventoMetrica.addItem(m.getId());
        }
        Collection<GenderTO> genderList = client.requestSelectGenderTO();
        for(GenderTO g : genderList){
            this.comboBoxEventoGenero.addItem(g.getId());
            this.comboBoxIndividuoGenero.addItem(g.getId());
            this.comboBoxEquipoGenero.addItem(g.getId());
        }
        Collection<InstallationTO> insList = client.requestSelectInstallationTO();
        for(InstallationTO i : insList){
            this.comboBoxEventoInstalacion.addItem(i.getNombre());
        }
        Collection<SportTO> spList = client.requestSelectSportTO();
        for(SportTO i : spList){
            this.comboBoxEventoDeportes.addItem(i.getId());
        }
        Collection<CountryTO> cntList = client.requestSelectCountryTO();
        for(CountryTO i : cntList){
            this.comboBoxCompetidoresPais.addItem(i.getCodigoISO());
        }
        Collection<AccommodationTO> acList = client.requestSelectAccommodationTO();
        for(AccommodationTO i : acList){
            this.comboBoxCompetidoresAlojamiento.addItem(i.getNombre());
        }
        Collection<IndividualTO> indiList = client.requestSelectIndividualTO();
        for(IndividualTO i : indiList){
            this.comboBoxIndividuos.addItem(i.getCedula());
        }
        Collection<TeamTO> teamList = client.requestSelectTeamTO();
        for(TeamTO t : teamList){
            String genero = client.requestFindIndividual(this.comboBoxIndividuos.getSelectedItem().toString()).getGenero();
            if(genero.equals(t.getGenero()))
                this.comboBoxEquipos.addItem(t.getId());
        }
    }
    
    private void radioSeleccionado(){
        if(this.radioButtonCompetidoresIndividuo.isSelected()){
            this.campoEquipoCodigo.setEnabled(false);
            this.campoEquipoNombre.setEnabled(false);
            this.campoEquipoCorreo.setEnabled(false);
            this.campoEquipoEntrenador.setEnabled(false);
            this.campoEquipoTelefono.setEnabled(false);
            this.comboBoxEquipoGenero.setEnabled(false);
            
            // cambio
            
            this.campoIndividuoCedula.setEnabled(true);
            this.campoIndividuoNombre.setEnabled(true);
            this.campoIndividuoApellidos.setEnabled(true);
            this.campoIndividuoEntrenador.setEnabled(true);
            this.campoIndividuoCiudad.setEnabled(true);
            this.campoIndividuoOcupacion.setEnabled(true);
            this.comboBoxIndividuoGenero.setEnabled(true);
            this.calendarComboBoxIndividuoNacimiento.setEnabled(true);
        }else{
            this.campoIndividuoCedula.setEnabled(false);
            this.campoIndividuoNombre.setEnabled(false);
            this.campoIndividuoApellidos.setEnabled(false);
            this.campoIndividuoEntrenador.setEnabled(false);
            this.campoIndividuoCiudad.setEnabled(false);
            this.campoIndividuoOcupacion.setEnabled(false);
            this.comboBoxIndividuoGenero.setEnabled(false);
            this.calendarComboBoxIndividuoNacimiento.setEnabled(false);
            
            // cambio
            
            this.campoEquipoCodigo.setEnabled(true);
            this.campoEquipoNombre.setEnabled(true);
            this.campoEquipoCorreo.setEnabled(true);
            this.campoEquipoEntrenador.setEnabled(true);
            this.campoEquipoTelefono.setEnabled(true);
            this.comboBoxEquipoGenero.setEnabled(true);
        }
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        campoEventoCapacidad = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        campoEventoId = new javax.swing.JTextField();
        comboBoxEventoGenero = new javax.swing.JComboBox();
        comboBoxEventoInstalacion = new javax.swing.JComboBox();
        comboBoxEventoMetrica = new javax.swing.JComboBox();
        comboBoxEventoDeportes = new javax.swing.JComboBox();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jLabel17 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTextArea2 = new javax.swing.JTextArea();
        jLabel18 = new javax.swing.JLabel();
        jScrollPane4 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        jButton5 = new javax.swing.JButton();
        jLabel38 = new javax.swing.JLabel();
        comboBoxEventoTipo = new javax.swing.JComboBox();
        calendarComboBoxEventoInicio = new com.toedter.calendar.JDateChooser();
        calendarComboBoxEventoFin = new com.toedter.calendar.JDateChooser();
        jPanel6 = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        campoMetricaId = new javax.swing.JTextField();
        botonMetricaBuscar = new javax.swing.JButton();
        botonMetricaBorrar = new javax.swing.JButton();
        campoMetricaTipo = new javax.swing.JTextField();
        campoMetricaMin = new javax.swing.JTextField();
        campoMetricaMax = new javax.swing.JTextField();
        botonMetricaInsertar = new javax.swing.JButton();
        botonMetricaActualizar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        botonMetricaTodo = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel19 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();
        jLabel26 = new javax.swing.JLabel();
        jLabel27 = new javax.swing.JLabel();
        jLabel28 = new javax.swing.JLabel();
        campoIndividuoApellidos = new javax.swing.JTextField();
        campoIndividuoNombre = new javax.swing.JTextField();
        campoIndividuoCedula = new javax.swing.JTextField();
        campoCompetidorId = new javax.swing.JTextField();
        campoIndividuoOcupacion = new javax.swing.JTextField();
        campoIndividuoCiudad = new javax.swing.JTextField();
        jLabel23 = new javax.swing.JLabel();
        jLabel29 = new javax.swing.JLabel();
        comboBoxCompetidoresPais = new javax.swing.JComboBox();
        comboBoxCompetidoresAlojamiento = new javax.swing.JComboBox();
        comboBoxIndividuoGenero = new javax.swing.JComboBox();
        campoIndividuoEntrenador = new javax.swing.JTextField();
        jLabel30 = new javax.swing.JLabel();
        jLabel31 = new javax.swing.JLabel();
        jButton6 = new javax.swing.JButton();
        radioButtonCompetidoresIndividuo = new javax.swing.JRadioButton();
        radioButtonCompetidoresEquipo = new javax.swing.JRadioButton();
        jLabel32 = new javax.swing.JLabel();
        jLabel33 = new javax.swing.JLabel();
        jLabel34 = new javax.swing.JLabel();
        jLabel35 = new javax.swing.JLabel();
        jLabel36 = new javax.swing.JLabel();
        jLabel37 = new javax.swing.JLabel();
        campoEquipoEntrenador = new javax.swing.JTextField();
        campoEquipoNombre = new javax.swing.JTextField();
        campoEquipoCodigo = new javax.swing.JTextField();
        campoEquipoTelefono = new javax.swing.JTextField();
        campoEquipoCorreo = new javax.swing.JTextField();
        comboBoxEquipoGenero = new javax.swing.JComboBox();
        calendarComboBoxIndividuoNacimiento = new com.toedter.calendar.JDateChooser();
        jPanel3 = new javax.swing.JPanel();
        comboBoxIndividuos = new javax.swing.JComboBox();
        comboBoxEquipos = new javax.swing.JComboBox();
        jButton7 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jTabbedPane1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTabbedPane1MouseClicked(evt);
            }
        });

        jPanel1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanel1MouseClicked(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Arial Black", 0, 14)); // NOI18N
        jLabel2.setText("Registro De Eventos");

        jLabel3.setText("Código");

        jLabel4.setText("Género");

        jLabel5.setText("Fecha inicio del evento");

        jLabel6.setText("Fecha finalización del evento");

        jLabel7.setText("Capacidad (competidores por serie)");

        jLabel8.setText("Instalacion");

        jLabel15.setText("Metrica");

        jLabel16.setText("Tipo de deporte");

        comboBoxEventoGenero.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "<<select >>" }));

        comboBoxEventoInstalacion.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "<<select>>" }));

        comboBoxEventoMetrica.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "<<select>>" }));

        comboBoxEventoDeportes.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "<<select>>" }));

        jButton1.setText("Buscar");
        jButton1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton1MouseClicked(evt);
            }
        });

        jButton2.setText("Borrar");
        jButton2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton2MouseClicked(evt);
            }
        });

        jButton3.setText("Insertar");
        jButton3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton3MouseClicked(evt);
            }
        });

        jButton4.setText("Actualizar");
        jButton4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton4MouseClicked(evt);
            }
        });

        jLabel17.setText("Resultado de la búsqueda");

        jTextArea2.setColumns(20);
        jTextArea2.setRows(5);
        jScrollPane3.setViewportView(jTextArea2);

        jLabel18.setText("Registro Completo");

        jTable2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Id", "Genero", "Fecha Inicio", "Fecha Finalizacion", "Capacidad", "Instalacion", "Metrica", "Tipo de deporte", "Tipo Competidor"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.Integer.class, java.lang.Object.class, java.lang.Object.class, java.lang.Integer.class, java.lang.Integer.class, java.lang.Integer.class, java.lang.Integer.class, java.lang.Integer.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane4.setViewportView(jTable2);

        jButton5.setText("Obtener");
        jButton5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton5MouseClicked(evt);
            }
        });

        jLabel38.setText("Tipo de Evento");

        comboBoxEventoTipo.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Individual", "Equipo" }));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel17)
                .addGap(310, 310, 310))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(22, 22, 22)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4)
                            .addComponent(jLabel3)
                            .addComponent(jLabel5)
                            .addComponent(jLabel6)
                            .addComponent(jLabel7)
                            .addComponent(jLabel8)
                            .addComponent(jLabel15)
                            .addComponent(jLabel16)
                            .addComponent(jLabel38))
                        .addGap(50, 50, 50)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(campoEventoId, javax.swing.GroupLayout.DEFAULT_SIZE, 124, Short.MAX_VALUE)
                            .addComponent(comboBoxEventoGenero, 0, 124, Short.MAX_VALUE)
                            .addComponent(comboBoxEventoDeportes, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(campoEventoCapacidad, javax.swing.GroupLayout.DEFAULT_SIZE, 124, Short.MAX_VALUE)
                            .addComponent(comboBoxEventoInstalacion, 0, 124, Short.MAX_VALUE)
                            .addComponent(comboBoxEventoMetrica, 0, 124, Short.MAX_VALUE)
                            .addComponent(comboBoxEventoTipo, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(calendarComboBoxEventoInicio, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(calendarComboBoxEventoFin, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jButton4)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(279, 279, 279)
                                        .addComponent(jButton5))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(18, 18, 18)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 612, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 612, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(339, 339, 339)
                                .addComponent(jLabel18))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(368, 368, 368)
                        .addComponent(jLabel2)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addComponent(jLabel2)
                .addGap(18, 18, 18)
                .addComponent(jLabel17)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(campoEventoId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton1))
                        .addGap(8, 8, 8)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(comboBoxEventoGenero, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4)
                            .addComponent(jButton2)))
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addGap(13, 13, 13)
                        .addComponent(jLabel6)
                        .addGap(13, 13, 13)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(campoEventoCapacidad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel7))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(comboBoxEventoInstalacion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel8))
                        .addGap(13, 13, 13)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(comboBoxEventoMetrica, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel15))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(comboBoxEventoDeportes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel16))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButton3)
                            .addComponent(jButton5)
                            .addComponent(jLabel38)
                            .addComponent(comboBoxEventoTipo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addComponent(jButton4))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel18)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(calendarComboBoxEventoInicio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(calendarComboBoxEventoFin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(29, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Eventos", jPanel1);

        jLabel9.setFont(new java.awt.Font("Arial Black", 0, 14)); // NOI18N
        jLabel9.setText("REGISTRO DE METRICAS");

        jLabel10.setText("Código");

        jLabel11.setText("Tipo de métrica");

        jLabel12.setText("Rango-Mínimo");

        jLabel13.setText("Rango-Máximo");

        jLabel14.setText("Resultado de la búsqueda");

        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jScrollPane2.setViewportView(jTextArea1);

        botonMetricaBuscar.setText("Buscar");
        botonMetricaBuscar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                botonMetricaBuscarMouseClicked(evt);
            }
        });

        botonMetricaBorrar.setText("Borrar");
        botonMetricaBorrar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                botonMetricaBorrarMouseClicked(evt);
            }
        });

        botonMetricaInsertar.setText("Insertar");
        botonMetricaInsertar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                botonMetricaInsertarMouseClicked(evt);
            }
        });

        botonMetricaActualizar.setText("Actualizar");
        botonMetricaActualizar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                botonMetricaActualizarMouseClicked(evt);
            }
        });

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Id", "Metrica", "Minimo", "Maximo"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(jTable1);

        botonMetricaTodo.setText("Obtener");
        botonMetricaTodo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                botonMetricaTodoMouseClicked(evt);
            }
        });

        jLabel1.setText("Registro Completo");

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                .addGap(52, 52, 52)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addComponent(jLabel10)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(campoMetricaId, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addComponent(jLabel11)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(campoMetricaTipo, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addComponent(jLabel12)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(campoMetricaMin, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addComponent(jLabel13)
                        .addGap(35, 35, 35)
                        .addComponent(campoMetricaMax, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(27, 27, 27)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addComponent(botonMetricaBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(botonMetricaBorrar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addComponent(botonMetricaInsertar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(botonMetricaActualizar)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 231, Short.MAX_VALUE)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 390, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 390, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(50, 50, 50))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                        .addComponent(botonMetricaTodo)
                        .addGap(202, 202, 202))))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(217, 217, 217))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                        .addComponent(jLabel14)
                        .addGap(190, 190, 190))))
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(419, 419, 419)
                .addComponent(jLabel9)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(38, 38, 38)
                .addComponent(jLabel9)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(botonMetricaBuscar)
                        .addComponent(campoMetricaId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel10)
                        .addComponent(botonMetricaBorrar))
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(campoMetricaTipo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel11))
                        .addGap(27, 27, 27)
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(campoMetricaMin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel12))
                        .addGap(21, 21, 21)
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(campoMetricaMax, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel13)))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(botonMetricaInsertar)
                    .addComponent(botonMetricaActualizar)
                    .addComponent(botonMetricaTodo))
                .addContainerGap(117, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Metricas", jPanel6);

        jLabel19.setText("Id Competidor");

        jLabel20.setText("Nombre");

        jLabel21.setText("Apellidos");

        jLabel22.setText("Fecha de nacimiento");

        jLabel24.setText("Género");

        jLabel25.setText("Ocupacion");

        jLabel26.setText("Ciudad");

        jLabel27.setText("Nombre entrenador");

        jLabel28.setText("Cedula");

        jLabel23.setText("País Representado");

        jLabel29.setText("Alojamiento");

        comboBoxCompetidoresPais.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "<<select>>" }));

        comboBoxCompetidoresAlojamiento.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "<<select>>" }));

        comboBoxIndividuoGenero.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "<<select>>" }));

        jLabel30.setText("Individuo");

        jLabel31.setText("Equipo");

        jButton6.setText("Insertar");
        jButton6.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton6MouseClicked(evt);
            }
        });

        buttonGroup1.add(radioButtonCompetidoresIndividuo);
        radioButtonCompetidoresIndividuo.setSelected(true);
        radioButtonCompetidoresIndividuo.setText("Individuo");
        radioButtonCompetidoresIndividuo.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                radioButtonCompetidoresIndividuoStateChanged(evt);
            }
        });

        buttonGroup1.add(radioButtonCompetidoresEquipo);
        radioButtonCompetidoresEquipo.setText("Equipo");
        radioButtonCompetidoresEquipo.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                radioButtonCompetidoresEquipoStateChanged(evt);
            }
        });

        jLabel32.setText("Código");

        jLabel33.setText("Nombre equipo");

        jLabel34.setText("Género");

        jLabel35.setText("Teléfono");

        jLabel36.setText("Correo");

        jLabel37.setText("Nombre Entrenador");

        comboBoxEquipoGenero.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "<<select>>" }));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(39, 39, 39)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel30)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jLabel22)
                        .addComponent(jLabel21)
                        .addComponent(jLabel19)
                        .addComponent(jLabel24)
                        .addComponent(jLabel25)
                        .addComponent(jLabel26)
                        .addComponent(jLabel27)
                        .addComponent(jLabel20)
                        .addComponent(jLabel28)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(campoCompetidorId, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 29, Short.MAX_VALUE)
                        .addComponent(jLabel23)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(comboBoxCompetidoresPais, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel29)
                                .addGap(18, 18, 18)
                                .addComponent(comboBoxCompetidoresAlojamiento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(86, 86, 86)
                                .addComponent(jLabel31)))
                        .addContainerGap(464, Short.MAX_VALUE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(campoIndividuoEntrenador, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(campoIndividuoApellidos)
                                    .addComponent(campoIndividuoNombre)
                                    .addComponent(campoIndividuoCedula)
                                    .addComponent(campoIndividuoOcupacion)
                                    .addComponent(campoIndividuoCiudad)
                                    .addComponent(comboBoxIndividuoGenero, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(calendarComboBoxIndividuoNacimiento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addGap(29, 29, 29)
                                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(radioButtonCompetidoresIndividuo)
                                            .addComponent(radioButtonCompetidoresEquipo)
                                            .addComponent(jButton6, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(31, 31, 31)
                                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel37)
                                            .addComponent(jLabel35)
                                            .addComponent(jLabel36)
                                            .addComponent(campoEquipoEntrenador, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel34)))
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addGap(141, 141, 141)
                                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel32)
                                            .addComponent(jLabel33))
                                        .addGap(10, 10, 10)
                                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(campoEquipoCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(campoEquipoTelefono, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(campoEquipoCorreo, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                                .addComponent(comboBoxEquipoGenero, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(campoEquipoNombre, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 105, Short.MAX_VALUE)))))))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(42, 42, 42)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel23)
                    .addComponent(jLabel29)
                    .addComponent(comboBoxCompetidoresPais, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(comboBoxCompetidoresAlojamiento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(campoCompetidorId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel19))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel30)
                    .addComponent(jLabel31))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(campoIndividuoCedula, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel28))
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel32)
                        .addComponent(campoEquipoCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel20, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(campoIndividuoNombre, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(13, 13, 13)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel21, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(campoIndividuoApellidos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(radioButtonCompetidoresIndividuo)))
                        .addGap(14, 14, 14)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel22)
                            .addComponent(calendarComboBoxIndividuoNacimiento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(15, 15, 15)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(campoEquipoNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel33))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 10, Short.MAX_VALUE)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel34)
                            .addComponent(comboBoxEquipoGenero, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(24, 24, 24)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(radioButtonCompetidoresEquipo)
                                    .addComponent(jLabel35)))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addComponent(campoEquipoTelefono, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel24)
                            .addComponent(comboBoxIndividuoGenero, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel25, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(campoIndividuoOcupacion, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel26, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(campoIndividuoCiudad, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel36)
                            .addComponent(campoEquipoCorreo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton6, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel37)
                        .addGap(18, 18, 18)
                        .addComponent(campoEquipoEntrenador, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(21, 21, 21)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel27)
                    .addComponent(campoIndividuoEntrenador, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(25, 25, 25))
        );

        jTabbedPane1.addTab("Administrar Competidores", jPanel2);

        comboBoxIndividuos.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                comboBoxIndividuosItemStateChanged(evt);
            }
        });

        comboBoxEquipos.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "<<select>>" }));

        jButton7.setText("Asociar");
        jButton7.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton7MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(316, 316, 316)
                        .addComponent(comboBoxIndividuos, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(130, 130, 130)
                        .addComponent(comboBoxEquipos, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(459, 459, 459)
                        .addComponent(jButton7, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(397, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(102, 102, 102)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(comboBoxIndividuos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(comboBoxEquipos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(50, 50, 50)
                .addComponent(jButton7, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(224, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Asociar Individuos-Equipos", jPanel3);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void botonMetricaBuscarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_botonMetricaBuscarMouseClicked
        this.jTextArea1.setText("");
        Client client = new Client();
        this.jTextArea1.setText(client.requestFindMetric(this.campoMetricaId.getText()));
            
    }//GEN-LAST:event_botonMetricaBuscarMouseClicked

    private void botonMetricaInsertarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_botonMetricaInsertarMouseClicked
        Client client = new Client();
        int number = client.requestInsertMetric(this.campoMetricaId.getText(), this.campoMetricaTipo.getText(), 
                this.campoMetricaMin.getText(), this.campoMetricaMax.getText());
        if (number == -1)
            JOptionPane.showMessageDialog(this, "Failure", "Information", JOptionPane.ERROR_MESSAGE);
        else
            JOptionPane.showMessageDialog(this, "Success", "Information", JOptionPane.INFORMATION_MESSAGE);
    }//GEN-LAST:event_botonMetricaInsertarMouseClicked

    private void botonMetricaBorrarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_botonMetricaBorrarMouseClicked
        Client client = new Client();
        if(!client.requestDeleteMetric(this.campoMetricaId.getText()))
            JOptionPane.showMessageDialog(this, "Failure", "Information", JOptionPane.ERROR_MESSAGE);
        else
            JOptionPane.showMessageDialog(this, "Success", "Information", JOptionPane.INFORMATION_MESSAGE);
    }//GEN-LAST:event_botonMetricaBorrarMouseClicked

    private void botonMetricaTodoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_botonMetricaTodoMouseClicked
        
        Client client = new Client();
        Collection<MetricTO> metricList = client.requestSelectMetricTO();
        ArrayList<Object[]> data = new ArrayList();
        Object[] rows;
        for(MetricTO m : metricList){
            rows = new Object[]{m.getId(),m.getMetrica(),m.getMinimo(),m.getMaximo()};
            data.add(rows);
        }
        dtm = (DefaultTableModel)this.jTable1.getModel();
        dtm.setRowCount(0);
        for(int i = 0; i < data.size(); i++){
            dtm.addRow(data.get(i));
        }
                
    }//GEN-LAST:event_botonMetricaTodoMouseClicked

    private void botonMetricaActualizarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_botonMetricaActualizarMouseClicked
        Client client = new Client();
        if(client.requestUpdateMetric(this.campoMetricaId.getText(), this.campoMetricaTipo.getText(), 
                this.campoMetricaMin.getText(), this.campoMetricaMax.getText()))
            JOptionPane.showMessageDialog(this, "Success", "Information", JOptionPane.INFORMATION_MESSAGE);
        else
            JOptionPane.showMessageDialog(this, "Failure", "Information", JOptionPane.ERROR_MESSAGE);
    }//GEN-LAST:event_botonMetricaActualizarMouseClicked

    private void jButton3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton3MouseClicked
        Client client = new Client();
        int tipo = 0;
        if (comboBoxEventoTipo.getSelectedItem().toString().equals("Individuo"))
            tipo = 1;
        int number = client.requestInsertEvent(this.campoEventoId.getText(), this.comboBoxEventoGenero.getSelectedItem().toString(),
                this.calendarComboBoxEventoInicio.getDate(), this.calendarComboBoxEventoFin.getDate(), this.campoEventoCapacidad.getText(),
                this.comboBoxEventoInstalacion.getSelectedItem().toString(), this.comboBoxEventoMetrica.getSelectedItem().toString(),
                this.comboBoxEventoDeportes.getSelectedItem().toString(), tipo);
        if (number == -1)
            JOptionPane.showMessageDialog(this, "Failure", "Information", JOptionPane.ERROR_MESSAGE);
        else
            JOptionPane.showMessageDialog(this, "Success", "Information", JOptionPane.INFORMATION_MESSAGE);
    }//GEN-LAST:event_jButton3MouseClicked

    private void jTabbedPane1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTabbedPane1MouseClicked
        this.comboBoxEventoDeportes.removeAllItems();
        this.comboBoxEventoGenero.removeAllItems();
        this.comboBoxEventoInstalacion.removeAllItems();
        this.comboBoxEventoMetrica.removeAllItems();
        this.comboBoxIndividuoGenero.removeAllItems();
        this.comboBoxEquipoGenero.removeAllItems();
        this.comboBoxCompetidoresPais.removeAllItems();
        this.comboBoxCompetidoresAlojamiento.removeAllItems();
        this.comboBoxIndividuos.removeAllItems();
        this.comboBoxEquipos.removeAllItems();
        cargarDatos();
    }//GEN-LAST:event_jTabbedPane1MouseClicked

    private void jPanel1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel1MouseClicked
        
    }//GEN-LAST:event_jPanel1MouseClicked

    private void jButton5MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton5MouseClicked
        Client client = new Client();
        Collection<EventTO> evtList = client.requestSelectEventTO();
        ArrayList<Object[]> data = new ArrayList();
        Object[] rows;
        for(EventTO e : evtList){
            System.out.println(e.getDeporte());
            rows = new Object[]{e.getId(),e.getGenero(),e.getFechaInicio(),e.getFechaFin(),e.getCapacidad(),e.getInstalacion(),e.getMetrica(),e.getDeporte(), e.getTipoCompetidor()};
            data.add(rows);
        }
        dtm = (DefaultTableModel)this.jTable2.getModel();
        dtm.setRowCount(0);
        for(int i = 0; i < data.size(); i++){
            dtm.addRow(data.get(i));
        }
    }//GEN-LAST:event_jButton5MouseClicked

    private void jButton1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton1MouseClicked
        this.jTextArea2.setText("");
        Client client = new Client();
        this.jTextArea2.setText(client.requestFindEvent(this.campoEventoId.getText()));
    }//GEN-LAST:event_jButton1MouseClicked

    private void jButton6MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton6MouseClicked
        Client client = new Client();
        int tipo = 0;
        if (comboBoxEventoTipo.getSelectedItem().toString().equals("Individual"))
            tipo = 1;
        
        if(client.requestInsertCompetitor(this.campoCompetidorId.getText(), this.comboBoxCompetidoresPais.getSelectedItem().toString(), this.comboBoxCompetidoresAlojamiento.getSelectedItem().toString(), tipo) == -1){
            JOptionPane.showMessageDialog(this, "Failure, inserting competitor", "Information", JOptionPane.ERROR_MESSAGE);
        }else{
            if(this.radioButtonCompetidoresIndividuo.isSelected()){
                System.out.println("HAHHAHA");
                Calendar cal = Calendar.getInstance();
                int anio = cal.get( Calendar.YEAR );
                Calendar c = Calendar.getInstance();
                c.setTime(this.calendarComboBoxIndividuoNacimiento.getDate());
                int edad = anio - c.get( Calendar.YEAR );
                System.out.println(edad);
                if(client.requestInsertIndividual(this.campoIndividuoCedula.getText(), this.campoIndividuoNombre.getText(), this.campoIndividuoApellidos.getText(), this.calendarComboBoxIndividuoNacimiento.getDate(), edad + "", this.comboBoxIndividuoGenero.getSelectedItem().toString(), this.campoIndividuoOcupacion.getText(), this.campoIndividuoCiudad.getText(), this.campoIndividuoEntrenador.getText(), this.campoCompetidorId.getText()) == -1){
                    client.requestDeleteCompetitor(this.campoCompetidorId.getText());
                    JOptionPane.showMessageDialog(this, "Failure, inserting individual", "Information", JOptionPane.ERROR_MESSAGE);
                }else{
                    JOptionPane.showMessageDialog(this, "Success", "Information", JOptionPane.INFORMATION_MESSAGE);
                }
            }else{
                if(client.requestInsertTeam(this.campoEquipoCodigo.getText(), this.campoEquipoNombre.getText(), 
                    this.comboBoxEquipoGenero.getSelectedItem().toString(), this.campoEquipoTelefono.getText(), 
                    this.campoEquipoCorreo.getText(), this.campoEquipoEntrenador.getText(), this.campoCompetidorId.getText()) == -1){
                    client.requestDeleteCompetitor(this.campoCompetidorId.getText());
                    JOptionPane.showMessageDialog(this, "Failure, inserting Team", "Information", JOptionPane.ERROR_MESSAGE);
                 }else{
                    JOptionPane.showMessageDialog(this, "Success", "Information", JOptionPane.INFORMATION_MESSAGE);
                }
            }  
        }  
    }//GEN-LAST:event_jButton6MouseClicked

    private void radioButtonCompetidoresEquipoStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_radioButtonCompetidoresEquipoStateChanged
        radioSeleccionado();
    }//GEN-LAST:event_radioButtonCompetidoresEquipoStateChanged

    private void radioButtonCompetidoresIndividuoStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_radioButtonCompetidoresIndividuoStateChanged
        radioSeleccionado();
    }//GEN-LAST:event_radioButtonCompetidoresIndividuoStateChanged

    private void jButton4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton4MouseClicked
        Client client = new Client();
        int tipo = 0;
        if (comboBoxEventoTipo.getSelectedItem().toString().equals("Individual"))
            tipo = 1;
        boolean s = client.requestUpdateEvent(this.campoEventoId.getText(), this.comboBoxEventoGenero.getSelectedItem().toString(),
                this.calendarComboBoxEventoInicio.getDate(), this.calendarComboBoxEventoFin.getDate(), this.campoEventoCapacidad.getText(),
                this.comboBoxEventoInstalacion.getSelectedItem().toString(), this.comboBoxEventoMetrica.getSelectedItem().toString(),
                this.comboBoxEventoDeportes.getSelectedItem().toString(), tipo);
        if (s)
            JOptionPane.showMessageDialog(this, "Success", "Information", JOptionPane.INFORMATION_MESSAGE);
        else
            JOptionPane.showMessageDialog(this, "Failure", "Information", JOptionPane.ERROR_MESSAGE);
    }//GEN-LAST:event_jButton4MouseClicked

    private void jButton2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton2MouseClicked
        Client client = new Client();
        if(client.requestDeleteEvent(this.campoEventoId.getText()))
            JOptionPane.showMessageDialog(this, "Success", "Information", JOptionPane.INFORMATION_MESSAGE);
        else
            JOptionPane.showMessageDialog(this, "Failure", "Information", JOptionPane.ERROR_MESSAGE);
    }//GEN-LAST:event_jButton2MouseClicked

    private void jButton7MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton7MouseClicked
        
    }//GEN-LAST:event_jButton7MouseClicked

    private void comboBoxIndividuosItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_comboBoxIndividuosItemStateChanged
        
    }//GEN-LAST:event_comboBoxIndividuosItemStateChanged

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(GUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(GUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(GUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(GUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            new GUI().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botonMetricaActualizar;
    private javax.swing.JButton botonMetricaBorrar;
    private javax.swing.JButton botonMetricaBuscar;
    private javax.swing.JButton botonMetricaInsertar;
    private javax.swing.JButton botonMetricaTodo;
    private javax.swing.ButtonGroup buttonGroup1;
    private com.toedter.calendar.JDateChooser calendarComboBoxEventoFin;
    private com.toedter.calendar.JDateChooser calendarComboBoxEventoInicio;
    private com.toedter.calendar.JDateChooser calendarComboBoxIndividuoNacimiento;
    private javax.swing.JTextField campoCompetidorId;
    private javax.swing.JTextField campoEquipoCodigo;
    private javax.swing.JTextField campoEquipoCorreo;
    private javax.swing.JTextField campoEquipoEntrenador;
    private javax.swing.JTextField campoEquipoNombre;
    private javax.swing.JTextField campoEquipoTelefono;
    private javax.swing.JTextField campoEventoCapacidad;
    private javax.swing.JTextField campoEventoId;
    private javax.swing.JTextField campoIndividuoApellidos;
    private javax.swing.JTextField campoIndividuoCedula;
    private javax.swing.JTextField campoIndividuoCiudad;
    private javax.swing.JTextField campoIndividuoEntrenador;
    private javax.swing.JTextField campoIndividuoNombre;
    private javax.swing.JTextField campoIndividuoOcupacion;
    private javax.swing.JTextField campoMetricaId;
    private javax.swing.JTextField campoMetricaMax;
    private javax.swing.JTextField campoMetricaMin;
    private javax.swing.JTextField campoMetricaTipo;
    private javax.swing.JComboBox comboBoxCompetidoresAlojamiento;
    private javax.swing.JComboBox comboBoxCompetidoresPais;
    private javax.swing.JComboBox comboBoxEquipoGenero;
    private javax.swing.JComboBox comboBoxEquipos;
    private javax.swing.JComboBox comboBoxEventoDeportes;
    private javax.swing.JComboBox comboBoxEventoGenero;
    private javax.swing.JComboBox comboBoxEventoInstalacion;
    private javax.swing.JComboBox comboBoxEventoMetrica;
    private javax.swing.JComboBox comboBoxEventoTipo;
    private javax.swing.JComboBox comboBoxIndividuoGenero;
    private javax.swing.JComboBox comboBoxIndividuos;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel34;
    private javax.swing.JLabel jLabel35;
    private javax.swing.JLabel jLabel36;
    private javax.swing.JLabel jLabel37;
    private javax.swing.JLabel jLabel38;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTable jTable2;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JTextArea jTextArea2;
    private javax.swing.JRadioButton radioButtonCompetidoresEquipo;
    private javax.swing.JRadioButton radioButtonCompetidoresIndividuo;
    // End of variables declaration//GEN-END:variables
}
