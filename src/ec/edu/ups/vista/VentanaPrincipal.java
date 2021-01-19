/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.ups.vista;

import ec.edu.ups.controlador.*;


/**
 *
 * @author Dutan2000
 */
public class VentanaPrincipal extends javax.swing.JFrame {

    private ControladorAsunto controladorA;
    private ControladorPersona controaldorC;
    private ControladorProcurador controaldorP;
    private ControladorRegex controladorR;

    private VentanaAsunto ventanaA;
    private VentanaCliente ventanaC;
    private VentanaProcurador ventanaP;

    public VentanaPrincipal() {
        initComponents();
        controladorA = new ControladorAsunto();
        controaldorC = new ControladorPersona();
        controaldorP = new ControladorProcurador();
        controladorR=new ControladorRegex();

        ventanaA = new VentanaAsunto(controladorA,controaldorC, controaldorP, controladorR);
        ventanaC = new VentanaCliente(controaldorC,controladorR);
        ventanaP = new VentanaProcurador(controaldorP,controladorR);
        
        desktopPane.add(ventanaA);
        desktopPane.add(ventanaC);
        desktopPane.add(ventanaP);

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        desktopPane = new javax.swing.JDesktopPane();
        menuBar = new javax.swing.JMenuBar();
        fileMenu = new javax.swing.JMenu();
        itemRegistrarC = new javax.swing.JMenuItem();
        itemRegistrarP = new javax.swing.JMenuItem();
        itemRegistrarA = new javax.swing.JMenuItem();
        exitMenuItem = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        desktopPane.setLayout(null);

        fileMenu.setMnemonic('f');
        fileMenu.setText("MENU");

        itemRegistrarC.setMnemonic('o');
        itemRegistrarC.setText("REGISTRAR C.");
        itemRegistrarC.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemRegistrarCActionPerformed(evt);
            }
        });
        fileMenu.add(itemRegistrarC);

        itemRegistrarP.setMnemonic('s');
        itemRegistrarP.setText("REGISTRAR P.");
        itemRegistrarP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemRegistrarPActionPerformed(evt);
            }
        });
        fileMenu.add(itemRegistrarP);

        itemRegistrarA.setMnemonic('a');
        itemRegistrarA.setText("REGISTRAR A.");
        itemRegistrarA.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemRegistrarAActionPerformed(evt);
            }
        });
        fileMenu.add(itemRegistrarA);

        exitMenuItem.setMnemonic('x');
        exitMenuItem.setText("Exit");
        exitMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exitMenuItemActionPerformed(evt);
            }
        });
        fileMenu.add(exitMenuItem);

        menuBar.add(fileMenu);

        setJMenuBar(menuBar);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(desktopPane, javax.swing.GroupLayout.DEFAULT_SIZE, 685, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(desktopPane, javax.swing.GroupLayout.DEFAULT_SIZE, 487, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void exitMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exitMenuItemActionPerformed
        System.exit(0);
    }//GEN-LAST:event_exitMenuItemActionPerformed

    private void itemRegistrarCActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemRegistrarCActionPerformed
        ventanaC.setVisible(true);
        
    }//GEN-LAST:event_itemRegistrarCActionPerformed

    private void itemRegistrarPActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemRegistrarPActionPerformed
        
        ventanaP.setVisible(true);
    }//GEN-LAST:event_itemRegistrarPActionPerformed

    private void itemRegistrarAActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemRegistrarAActionPerformed
        
        ventanaA.setVisible(true);
    }//GEN-LAST:event_itemRegistrarAActionPerformed

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
            java.util.logging.Logger.getLogger(VentanaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(VentanaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(VentanaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(VentanaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new VentanaPrincipal().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JDesktopPane desktopPane;
    private javax.swing.JMenuItem exitMenuItem;
    private javax.swing.JMenu fileMenu;
    private javax.swing.JMenuItem itemRegistrarA;
    private javax.swing.JMenuItem itemRegistrarC;
    private javax.swing.JMenuItem itemRegistrarP;
    private javax.swing.JMenuBar menuBar;
    // End of variables declaration//GEN-END:variables

}
