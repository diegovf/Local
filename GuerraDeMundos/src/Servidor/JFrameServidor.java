/*
 * JFrameServidor.java
 *
 * Created on 5 de diciembre de 2008, 08:13 PM
 */

package Servidor;

/**
 *
 * @author  Diego
 */
public class JFrameServidor extends javax.swing.JFrame {

    ServidorGato servidor;
    /** Creates new form JFrameServidor */
    public JFrameServidor() {
        initComponents();
        servidor = new ServidorGato(this);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        txaMensajesServidor = new javax.swing.JTextArea();
        Dos = new javax.swing.JButton();
        Tres = new javax.swing.JButton();
        Cuatro = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        txaMensajesServidor.setColumns(20);
        txaMensajesServidor.setRows(5);
        txaMensajesServidor.setEnabled(false);
        jScrollPane1.setViewportView(txaMensajesServidor);

        Dos.setText("Dos");
        Dos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                DosMouseClicked(evt);
            }
        });

        Tres.setText("Tres");
        Tres.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TresMouseClicked(evt);
            }
        });

        Cuatro.setText("Cuatro");
        Cuatro.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                CuatroMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(Dos)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 124, Short.MAX_VALUE)
                        .addComponent(Tres)
                        .addGap(82, 82, 82)
                        .addComponent(Cuatro)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 331, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(Cuatro)
                            .addComponent(Tres, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addContainerGap(12, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(Dos)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void DosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_DosMouseClicked
        ServidorGato.opcionJugadores = 2;
        ServidorGato.empezemos = true;
        Dos.enable(false);
        Tres.enable(false);
        Cuatro.enable(false);
    }//GEN-LAST:event_DosMouseClicked

    private void TresMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TresMouseClicked
        ServidorGato.opcionJugadores = 3;
        ServidorGato.empezemos = true;
        Dos.enable(false);
        Tres.enable(false);
        Cuatro.enable(false);
    }//GEN-LAST:event_TresMouseClicked

    private void CuatroMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_CuatroMouseClicked
        ServidorGato.opcionJugadores = 4;
        ServidorGato.empezemos = true;
        Dos.enable(false);
        Tres.enable(false);
        Cuatro.enable(false);
    }//GEN-LAST:event_CuatroMouseClicked

    public static void main(String args[]) throws InterruptedException {
        JFrameServidor serv =new JFrameServidor();
        serv.setVisible(true);
        serv.servidor.runServer();
        
            
    }
    
    public void mostrar (String texto)
    {
        txaMensajesServidor.append(texto+"\n");
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Cuatro;
    private javax.swing.JButton Dos;
    private javax.swing.JButton Tres;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea txaMensajesServidor;
    // End of variables declaration//GEN-END:variables

}
