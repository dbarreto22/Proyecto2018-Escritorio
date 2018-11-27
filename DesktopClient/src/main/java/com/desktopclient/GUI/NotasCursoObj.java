/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.desktopclient.GUI;

import com.desktopclient.Logic.Recursos;
import com.desktopclient.entidades.Carrera;
import com.desktopclient.entidades.Asignatura;
import com.desktopclient.Logic.MetodosEnvio;
import com.desktopclient.Logic.MyFrame;
import com.desktopclient.utils.panelUtils;
import com.desktopclient.utils.tableUtils;
import com.desktopclient.datatypes.DtAsignatura_Carrera;
import com.desktopclient.datatypes.DtCarrera;
import com.desktopclient.datatypes.DtCurso;
import com.desktopclient.datatypes.DtEstudiante_Curso;
import com.desktopclient.datatypes.DtUsuario;
import com.desktopclient.datatypes.DtUsuarioLogueado;
import com.desktopclient.entidades.Curso;
import com.desktopclient.entidades.Estudiante_Curso;
import java.awt.BorderLayout;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultCellEditor;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.table.TableColumn;
import org.apache.commons.lang3.StringUtils;
/**
 *
 * @author Ernesto
 */
public class NotasCursoObj extends MyFrame {
    tableUtils tUtils = tableUtils.getInstance();
    private Long idCurso;
    private String accion;
    private Long idAsigCar;
    private Curso curso;
    private List<DtEstudiante_Curso> listEst_Curso;
    private List<Object[]> data;


    /**
     * Creates new form HorariosCursos
     */    
    public NotasCursoObj(String accion, Long idCurso) {
        this.accion = accion;
        this.idCurso = idCurso;
        
        initComponents();
        setLocationRelativeTo(null);
        this.listEst_Curso = Recursos.getEstudiantesCalificacionCurso(idCurso);
        Curso curso = Recursos.getCurso(idCurso);
        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        cursoData.setText("Asignatura: " +curso.getAsignatura_Carrera().getAsignatura().getNombre() + 
                " - Carrera: " + curso.getAsignatura_Carrera().getCarrera().getNombre() + 
                " - Fecha: " + dateFormat.format(curso.getFecha()));
        tableConstructor();
        this.setVisible(true);
    }  
    

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        accionDsp = new javax.swing.JLabel();
        paneldata = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        aceptar = new javax.swing.JButton();
        salir = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        tableEstudiantes = new javax.swing.JTable();
        cursoData = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Curso");
        setBackground(new java.awt.Color(245, 245, 245));

        jPanel2.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        accionDsp.setFont(new java.awt.Font("Segoe UI Black", 1, 17)); // NOI18N
        accionDsp.setText("Accion");
        accionDsp.setText(accion);

        paneldata.setBackground(new java.awt.Color(245, 245, 245));
        paneldata.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel4.setBackground(new java.awt.Color(255, 255, 255));
        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("Calificaciones");

        aceptar.setBackground(new java.awt.Color(204, 204, 255));
        aceptar.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        aceptar.setText("Aceptar");
        aceptar.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        aceptar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                aceptarActionPerformed(evt);
            }
        });

        salir.setBackground(new java.awt.Color(102, 204, 255));
        salir.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        salir.setText("Salir");
        salir.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        salir.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                salirMouseClicked(evt);
            }
        });
        salir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                salirActionPerformed(evt);
            }
        });

        tableEstudiantes.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "", ""
            }
        ));
        jScrollPane3.setViewportView(tableEstudiantes);

        cursoData.setFont(new java.awt.Font("Arial", 0, 15)); // NOI18N
        cursoData.setText("DatosCurso");

        javax.swing.GroupLayout paneldataLayout = new javax.swing.GroupLayout(paneldata);
        paneldata.setLayout(paneldataLayout);
        paneldataLayout.setHorizontalGroup(
            paneldataLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, paneldataLayout.createSequentialGroup()
                .addGap(65, 65, 65)
                .addComponent(aceptar, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(salir, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(82, 82, 82))
            .addGroup(paneldataLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 686, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(paneldataLayout.createSequentialGroup()
                .addGap(231, 231, 231)
                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 226, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, paneldataLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(cursoData, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        paneldataLayout.setVerticalGroup(
            paneldataLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(paneldataLayout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(cursoData)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 277, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(47, 47, 47)
                .addGroup(paneldataLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(aceptar, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(salir, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(paneldata, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel2Layout.createSequentialGroup()
                        .addComponent(accionDsp)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addComponent(accionDsp, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(paneldata, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(40, 40, 40))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel2.setSize(720, 533);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void salirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_salirActionPerformed
        this.dispose();
    }//GEN-LAST:event_salirActionPerformed

    private void salirMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_salirMouseClicked
        // TODO add your handling code here:
        this.dispose();
    }//GEN-LAST:event_salirMouseClicked

    private void aceptarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_aceptarActionPerformed
        if(listEst_Curso.isEmpty()){
            JOptionPane.showMessageDialog(null, "No hay calificaciones para actualizar", "", JOptionPane.ERROR_MESSAGE);
        }else{
            for (int i = 0; i < listEst_Curso.size() ; i++) {
                System.out.println("i: "+ i);
                Object[] dataAr = data.get(i);
                Long calificacion = (Long) dataAr[3];
                System.out.println("calificacion: " + calificacion);
                DtEstudiante_Curso est_cur = listEst_Curso.get(i);
                est_cur.setCalificacion(calificacion);
                listEst_Curso.set(i, est_cur);
            }
            Recursos.SetNotasCurso(listEst_Curso);
            if (checkLastStatusOK()){
                JOptionPane.showMessageDialog(null, "Ok, Se han cargado las calificaciones", "", JOptionPane.INFORMATION_MESSAGE);
            }
            
        }
    }//GEN-LAST:event_aceptarActionPerformed

    /**
     * @param args the command line arguments
     */
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
//            java.util.logging.Logger.getLogger(HorariosCursos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (InstantiationException ex) {
//            java.util.logging.Logger.getLogger(HorariosCursos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (IllegalAccessException ex) {
//            java.util.logging.Logger.getLogger(HorariosCursos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
//            java.util.logging.Logger.getLogger(HorariosCursos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        }
//        //</editor-fold>
//
//        /* Create and display the form */
//        java.awt.EventQueue.invokeLater(new Runnable() {
//            public void run() {
//                new HorariosCursos(usuariolog).setVisible(true);
//            }
//        });
//    }
   

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel accionDsp;
    private javax.swing.JButton aceptar;
    private javax.swing.JLabel cursoData;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JPanel paneldata;
    private javax.swing.JButton salir;
    private javax.swing.JTable tableEstudiantes;
    // End of variables declaration//GEN-END:variables

    private void tableConstructor() {
        String[] tableHeaders = {"Documento", "Nombre", "Apellido", "Calificación"};

        data = new ArrayList<>();
        listEst_Curso.forEach(curso -> {
            Long calificacion = 0L;
            if (curso.getCalificacion() != null) {
                calificacion = curso.getCalificacion();
            }
            data.add(new Object[]{curso.getUsuario().getCedula(), curso.getUsuario().getNombre(), curso.getUsuario().getApellido(), calificacion});
        });
        tableEstudiantes = tUtils.tablaEditable(tableEstudiantes, tableHeaders, data);
        System.out.println("dataA.size(): " + tableEstudiantes.getRowCount());
    }

    private boolean checkLastStatusOK() {
        System.out.println("checkLastStatusOK");
        int lastStatus = MetodosEnvio.getLastStatus();
        if (lastStatus == 403) {
            JOptionPane.showMessageDialog(null, "La sesión expiró. \n Vuelva a loguearse por favor.", "", JOptionPane.ERROR_MESSAGE);
            return false;
        } else {
            if (lastStatus == 401) {
                JOptionPane.showMessageDialog(null, "Acceso denegado.", "", JOptionPane.ERROR_MESSAGE);
                return false;
            }
        }
        return true;
    }

}
