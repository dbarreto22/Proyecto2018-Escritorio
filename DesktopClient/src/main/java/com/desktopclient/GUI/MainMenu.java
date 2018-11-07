/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.desktopclient.GUI;

import com.desktopclient.Logic.JPanelWithBackground;
import com.desktopclient.Logic.MetodosEnvio;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JInternalFrame;
import javax.swing.JOptionPane;

/**
 *
 * @author eperroux
 */
public class MainMenu extends javax.swing.JFrame {
    
    /**
     * Creates new form Main
     */
    public MainMenu() {
        initComponents();
        
        setLocationRelativeTo(null);
        this.setVisible(rootPaneCheckingEnabled);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMenuItem10 = new javax.swing.JMenuItem();
        jMenuItem11 = new javax.swing.JMenuItem();
        jMenuItem12 = new javax.swing.JMenuItem();
        desktop = desktop = new com.desktopclient.Logic.JPanelWithBackground(".\\Logo_MiUdelar.jpg");
        jMenuBar1 = new javax.swing.JMenuBar();
        Cursos = new javax.swing.JMenu();
        GestionCursos = new javax.swing.JMenuItem();
        NotasCursos = new javax.swing.JMenuItem();
        ActasCursos = new javax.swing.JMenuItem();
        Examenes = new javax.swing.JMenu();
        GestionExamen = new javax.swing.JMenuItem();
        NotasExamenes = new javax.swing.JMenuItem();
        ActasExamenes = new javax.swing.JMenuItem();
        Estudiantes = new javax.swing.JMenu();
        Escolaridad = new javax.swing.JMenuItem();

        jMenuItem10.setText("jMenuItem10");

        jMenuItem11.setText("jMenuItem11");

        jMenuItem12.setText("jMenuItem12");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        desktop.setOpaque(false);
        desktop.setPreferredSize(new java.awt.Dimension(1125, 800));

        javax.swing.GroupLayout desktopLayout = new javax.swing.GroupLayout(desktop);
        desktop.setLayout(desktopLayout);
        desktopLayout.setHorizontalGroup(
            desktopLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1125, Short.MAX_VALUE)
        );
        desktopLayout.setVerticalGroup(
            desktopLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 800, Short.MAX_VALUE)
        );

        jMenuBar1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jMenuBar1.setMaximumSize(new java.awt.Dimension(397, 32769));
        jMenuBar1.setPreferredSize(new java.awt.Dimension(397, 26));

        Cursos.setText("Cursos");
        Cursos.setFont(new java.awt.Font("Segoe UI", 1, 20)); // NOI18N
        Cursos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CursosActionPerformed(evt);
            }
        });

        GestionCursos.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        GestionCursos.setText("Gestión");
        GestionCursos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                GestionCursosActionPerformed(evt);
            }
        });
        Cursos.add(GestionCursos);
        GestionCursos.getAccessibleContext().setAccessibleName("Gestion");

        NotasCursos.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        NotasCursos.setText("Calificaciones");
        NotasCursos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                NotasCursosActionPerformed(evt);
            }
        });
        Cursos.add(NotasCursos);

        ActasCursos.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        ActasCursos.setText("Actas");
        ActasCursos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ActasCursosActionPerformed(evt);
            }
        });
        Cursos.add(ActasCursos);

        jMenuBar1.add(Cursos);

        Examenes.setText("Exámenes");
        Examenes.setFont(new java.awt.Font("Segoe UI", 1, 20)); // NOI18N

        GestionExamen.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        GestionExamen.setText("Gestión");
        GestionExamen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                GestionExamenActionPerformed(evt);
            }
        });
        Examenes.add(GestionExamen);
        GestionExamen.getAccessibleContext().setAccessibleName("Gestion");

        NotasExamenes.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        NotasExamenes.setText("Calificaciones");
        NotasExamenes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                NotasExamenesActionPerformed(evt);
            }
        });
        Examenes.add(NotasExamenes);

        ActasExamenes.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        ActasExamenes.setText("Actas");
        ActasExamenes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ActasExamenesActionPerformed(evt);
            }
        });
        Examenes.add(ActasExamenes);

        jMenuBar1.add(Examenes);

        Estudiantes.setText("Estudiantes");
        Estudiantes.setFont(new java.awt.Font("Segoe UI", 1, 20)); // NOI18N

        Escolaridad.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        Escolaridad.setText("Escolaridad");
        Escolaridad.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                EscolaridadActionPerformed(evt);
            }
        });
        Estudiantes.add(Escolaridad);

        jMenuBar1.add(Estudiantes);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(desktop, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(desktop, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void GestionCursosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_GestionCursosActionPerformed
        internalFrameBuilder(new GestionCursos());
        
    }//GEN-LAST:event_GestionCursosActionPerformed

    private void EscolaridadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EscolaridadActionPerformed
        internalFrameBuilder(new ActaEscolaridad());
    }//GEN-LAST:event_EscolaridadActionPerformed

    private void CursosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CursosActionPerformed
//        internalFrameBuilder(new GestionCursos(usuariolog));
    }//GEN-LAST:event_CursosActionPerformed

    private void GestionExamenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_GestionExamenActionPerformed
        internalFrameBuilder(new GestionExamen());
    }//GEN-LAST:event_GestionExamenActionPerformed

    private void NotasCursosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_NotasCursosActionPerformed
        internalFrameBuilder(new NotasCursos());
    }//GEN-LAST:event_NotasCursosActionPerformed

    private void NotasExamenesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_NotasExamenesActionPerformed
       internalFrameBuilder(new NotasExamenes());
    }//GEN-LAST:event_NotasExamenesActionPerformed

    private void ActasCursosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ActasCursosActionPerformed
         internalFrameBuilder(new ActaCurso());
    }//GEN-LAST:event_ActasCursosActionPerformed

    private void ActasExamenesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ActasExamenesActionPerformed
        internalFrameBuilder(new ActaExamen());
    }//GEN-LAST:event_ActasExamenesActionPerformed

    /**
     * @param args the command line arguments
     */
    private void internalFrameBuilder(JInternalFrame internal) {
        for (JInternalFrame frame : desktop.getAllFrames()) {
            frame.dispose();
        }
        desktop.removeAll();
//        internal.setBounds(0, 0, desktop.getWidth() - 150, desktop.getHeight() - 150);
        desktop.add(internal);
        internal.setVisible(true);
        internal.setLocation((desktop.getWidth() - internal.getWidth()) / 2, (desktop.getHeight() -100 - internal.getHeight()) / 2);
    }
    
//    public static void main(String args[]) {
//        /* Set the Nimbus look and feel */
//        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
//        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
//         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
//         */
//        try {
//            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
//                if ("Nimbus".equals(info.getName())) {
//                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
//                    break;
//                }
//            }
//        } catch (ClassNotFoundException ex) {
//            java.util.logging.Logger.getLogger(MainMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (InstantiationException ex) {
//            java.util.logging.Logger.getLogger(MainMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (IllegalAccessException ex) {
//            java.util.logging.Logger.getLogger(MainMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
//            java.util.logging.Logger.getLogger(MainMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        }
//        //</editor-fold>
//        //</editor-fold>
//
//        /* Create and display the form */
//        java.awt.EventQueue.invokeLater(new Runnable() {
//            public void run() {
//                new MainMenu().setVisible(true);
//            }
//        });
//    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem ActasCursos;
    private javax.swing.JMenuItem ActasExamenes;
    private javax.swing.JMenu Cursos;
    private javax.swing.JMenuItem Escolaridad;
    private javax.swing.JMenu Estudiantes;
    private javax.swing.JMenu Examenes;
    private javax.swing.JMenuItem GestionCursos;
    private javax.swing.JMenuItem GestionExamen;
    private javax.swing.JMenuItem NotasCursos;
    private javax.swing.JMenuItem NotasExamenes;
    private javax.swing.JDesktopPane desktop;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem10;
    private javax.swing.JMenuItem jMenuItem11;
    private javax.swing.JMenuItem jMenuItem12;
    // End of variables declaration//GEN-END:variables
}
