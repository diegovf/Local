/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gato;

/**
 *
 * @author Pablo PC
 */
public class escogerArmeria extends javax.swing.JDialog {

    /**
     * Creates new form escogerArmeria
     */
    public escogerArmeria(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
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
        aceptarArma = new javax.swing.JButton();
        misil = new javax.swing.JRadioButton();
        multi = new javax.swing.JRadioButton();
        bomba = new javax.swing.JRadioButton();
        combo = new javax.swing.JRadioButton();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        aceptarArma.setText("Aceptar");
        aceptarArma.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                aceptarArmaMouseClicked(evt);
            }
        });
        aceptarArma.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                aceptarArmaActionPerformed(evt);
            }
        });

        buttonGroup1.add(misil);
        misil.setSelected(true);
        misil.setText("Misil");

        buttonGroup1.add(multi);
        multi.setText("Multi-Shot");

        buttonGroup1.add(bomba);
        bomba.setText("Bomba");

        buttonGroup1.add(combo);
        combo.setText("Combo-shot");

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLabel1.setText("Escoja el tipo de arma que desea producir");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(multi)
                                    .addComponent(misil))
                                .addGap(143, 143, 143)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(bomba)
                                    .addComponent(combo)))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(121, 121, 121)
                        .addComponent(aceptarArma)))
                .addContainerGap(18, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 39, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(misil)
                    .addComponent(bomba))
                .addGap(35, 35, 35)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(combo)
                    .addComponent(multi))
                .addGap(30, 30, 30)
                .addComponent(aceptarArma)
                .addGap(37, 37, 37))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void aceptarArmaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_aceptarArmaMouseClicked
        if(misil.isSelected())
        {
            JuegoGato.setProduccionArmas(1);
        }
        else if(multi.isSelected())
        {
            JuegoGato.setProduccionArmas(2);
        }
        else if(bomba.isSelected())
        {
            JuegoGato.setProduccionArmas(3);
        }
        else
        {
            JuegoGato.setProduccionArmas(4);
        }
        this.dispose();
    }//GEN-LAST:event_aceptarArmaMouseClicked

    private void aceptarArmaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_aceptarArmaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_aceptarArmaActionPerformed

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
            java.util.logging.Logger.getLogger(escogerArmeria.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(escogerArmeria.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(escogerArmeria.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(escogerArmeria.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                escogerArmeria dialog = new escogerArmeria(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton aceptarArma;
    private javax.swing.JRadioButton bomba;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JRadioButton combo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JRadioButton misil;
    private javax.swing.JRadioButton multi;
    // End of variables declaration//GEN-END:variables
}
