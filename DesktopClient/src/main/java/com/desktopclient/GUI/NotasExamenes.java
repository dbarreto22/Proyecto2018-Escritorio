/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.desktopclient.GUI;

import com.desktopclient.entidades.Carrera;
import com.desktopclient.entidades.Asignatura;
import com.desktopclient.Logic.MetodosEnvio;
import com.desktopclient.Logic.Recursos;
import com.desktopclient.utils.panelUtils;
import com.desktopclient.utils.tableUtils;
import com.desktopclient.datatypes.DtAsignatura_Carrera;
import com.desktopclient.datatypes.DtCarrera;
import com.desktopclient.datatypes.DtExamen;
import com.desktopclient.datatypes.DtUsuarioLogueado;
import com.desktopclient.entidades.Examen;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JOptionPane;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import org.apache.commons.lang3.StringUtils;

/**
 *
 * @author Ernesto
 */
public class NotasExamenes extends javax.swing.JInternalFrame {

    tableUtils tUtils = tableUtils.getInstance();
    private Long idExamen;
//    private DtUsuarioLogueado usuariolog;

//    public DtUsuarioLogueado getUsuarioLog() {
//        return usuariolog;
//    }
//
//    public void setUsuarioLog(DtUsuarioLogueado usuariolog) {
//        this.usuariolog = usuariolog;
//        cargarCarreras();
//    }
    /**
     * Creates new form HorariosExamenes
     */
    public NotasExamenes() {
//        this.usuariolog = usuariolog;
        initComponents();
        cargarCarreras();
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

        paneldata = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        salir = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        tableExamenes = new javax.swing.JTable();
        cargar = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        asignaturaTxt = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        Carreras = new javax.swing.JComboBox<>();
        jLabel5 = new javax.swing.JLabel();
        Buscar = new javax.swing.JButton();

        setBackground(new java.awt.Color(245, 245, 245));
        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Calificaciones Exámenes");

        paneldata.setBackground(new java.awt.Color(245, 245, 245));
        paneldata.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel4.setBackground(new java.awt.Color(255, 255, 255));
        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("Exámenes");

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

        tableExamenes.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "", ""
            }
        ));
        jScrollPane3.setViewportView(tableExamenes);

        cargar.setBackground(new java.awt.Color(102, 204, 255));
        cargar.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        cargar.setText("Cargar");
        cargar.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        cargar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                cargarMouseClicked(evt);
            }
        });
        cargar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cargarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout paneldataLayout = new javax.swing.GroupLayout(paneldata);
        paneldata.setLayout(paneldataLayout);
        paneldataLayout.setHorizontalGroup(
            paneldataLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, paneldataLayout.createSequentialGroup()
                .addGap(37, 37, 37)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 712, Short.MAX_VALUE)
                .addGap(23, 23, 23))
            .addGroup(paneldataLayout.createSequentialGroup()
                .addGap(266, 266, 266)
                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 226, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, paneldataLayout.createSequentialGroup()
                .addGap(52, 52, 52)
                .addComponent(cargar, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(salir, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(41, 41, 41))
        );
        paneldataLayout.setVerticalGroup(
            paneldataLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(paneldataLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 204, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 60, Short.MAX_VALUE)
                .addGroup(paneldataLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(salir, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cargar, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        jLabel4.getAccessibleContext().setAccessibleName("examenes");

        jPanel2.setBackground(new java.awt.Color(240, 245, 245));
        jPanel2.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel2.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel2.setText("Asignatura");

        jLabel1.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel1.setText("Carrera");

        Carreras.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                CarrerasItemStateChanged(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Segoe UI Black", 1, 17)); // NOI18N
        jLabel5.setText("Filtros");

        Buscar.setBackground(new java.awt.Color(204, 204, 255));
        Buscar.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        Buscar.setText("Buscar");
        Buscar.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        Buscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BuscarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(asignaturaTxt))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addGap(26, 26, 26)
                                .addComponent(Carreras, 0, 349, Short.MAX_VALUE)))
                        .addGap(99, 99, 99)
                        .addComponent(Buscar, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(132, 132, 132))))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(Carreras, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(asignaturaTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Buscar, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(23, 23, 23))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(paneldata, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(paneldata, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(19, 19, 19))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void salirMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_salirMouseClicked
        // TODO add your handling code here:
        this.dispose();
    }//GEN-LAST:event_salirMouseClicked

    private void CarrerasItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_CarrerasItemStateChanged
        // TODO add your handling code here:
//        List<Carrera> carreras = Reexamenes.getAllCarreras(usuariolog.getToken());
//        long idCarrera = 0;
//        for (int i = 0; i < carreras.size(); i++) {
//            if (carreras.get(i).getNombre().equals(Carreras.getSelectedItem().toString())){
//                idCarrera = carreras.get(i).getCodigo();
//                break;
//            }
//        }

//        List<Asignatura> asignaturas = Reexamenes.getAsignaturasByCarrera(idCarrera,usuariolog.getToken());
//        Asignatura a = new Asignatura();
//        
//        for (int i = 0; i < asignaturas.size(); i++) {
//            a = asignaturas.get(i);
//            Asignaturas.addItem(a.getNombre());
//        }
        //System.out.println(Carreras.getSelectedItem().toString());
    }//GEN-LAST:event_CarrerasItemStateChanged

    private void BuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BuscarActionPerformed
        idExamen = 0L;
        panelUtils.getInstance().panelClearData(paneldata);
        tableConstructor();
    }//GEN-LAST:event_BuscarActionPerformed

    private void salirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_salirActionPerformed
        this.dispose();
    }//GEN-LAST:event_salirActionPerformed

    private void cargarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cargarMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_cargarMouseClicked

    private void cargarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cargarActionPerformed
        // TODO add your handling code here:
        System.out.println("NOTAS EXAMEN OBJ");
        NotasExamenObj nc = new NotasExamenObj("Resultados Examen", idExamen);
    }//GEN-LAST:event_cargarActionPerformed

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
//            java.util.logging.Logger.getLogger(HorariosExamenes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (InstantiationException ex) {
//            java.util.logging.Logger.getLogger(HorariosExamenes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (IllegalAccessException ex) {
//            java.util.logging.Logger.getLogger(HorariosExamenes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
//            java.util.logging.Logger.getLogger(HorariosExamenes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        }
//        //</editor-fold>
//
//        /* Create and display the form */
//        java.awt.EventQueue.invokeLater(new Runnable() {
//            public void run() {
//                new HorariosExamenes(usuariolog).setVisible(true);
//            }
//        });
//    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Buscar;
    private javax.swing.JComboBox<String> Carreras;
    private javax.swing.JTextField asignaturaTxt;
    private javax.swing.JButton cargar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JPanel paneldata;
    private javax.swing.JButton salir;
    private javax.swing.JTable tableExamenes;
    // End of variables declaration//GEN-END:variables

    private void tableConstructor() {
        if (checkLastStatusOK()) {
            String[] tableHeaders = {"", "Asignatura", "Carrera", "Fecha"};
            List<Object[]> dataA = new ArrayList<>();
            String carreraStr = Carreras.getSelectedItem().toString();
            Long carreraSelected = Long.parseLong(carreraStr.substring(0, carreraStr.indexOf("-")));    
            String asginaturaSelected = asignaturaTxt.getText();
            List<DtExamen> listexamen = Recursos.getAllExamenes();
            listexamen.forEach((examen) -> {
                Boolean ok = true;
                Long codCar = examen.getAsignatura_Carrera().getCarrera().getCodigo();
                System.out.println("codCar: " + codCar);
                if (!carreraSelected.equals(0) && !codCar.equals(carreraSelected)) {
                    ok = false;
                } else {
                    String asig = examen.getAsignatura_Carrera().getAsignatura().getCodigo() + examen.getAsignatura_Carrera().getAsignatura().getNombre();
                    System.out.println("asig: " + asig);
                    if (asginaturaSelected != "" && (!StringUtils.containsIgnoreCase(asig, asginaturaSelected))) {
                        ok = false;
                    }
                    if (ok) {
                        System.out.println("OK");
                        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
                        String date = dateFormat.format(examen.getFecha());
                        System.out.println(date);

                        dataA.add(new Object[]{examen.getId(), examen.getAsignatura_Carrera().getAsignatura().getNombre(),
                            examen.getAsignatura_Carrera().getCarrera().getNombre(), date});
                    }
                }
            });
            tableExamenes = tUtils.tableConfig(tableExamenes, tableHeaders, dataA, ListSelectionModel.SINGLE_SELECTION);
            tableExamenes.removeColumn(tableExamenes.getColumnModel().getColumn(0));
            System.out.println("dataA.size(): " + dataA.size());
            if (dataA.size() != 0) {
                tableExamenes.getSelectionModel().addListSelectionListener((ListSelectionEvent event) -> {
                    if (event.getValueIsAdjusting()) {
                        idExamen = Long.parseLong(tableExamenes.getModel().getValueAt(tableExamenes.getSelectedRow(), 0).toString());
                    }
                });
            }
        } else {
            this.dispose();
        }

    }

    private void cargarCarreras() {
        System.out.println("cargarCarreras");
        List<DtCarrera> carreras = Recursos.getAllCarreras();
        System.out.println("carreras: " + carreras.toString());

        carreras.forEach(carrera -> {
            Carreras.addItem(carrera.getCodigo() + "-" + carrera.getNombre());
        });
//        for (int i = 0; i < carreras.size(); i++) {
//            c = carreras.get(i);
//            Carreras.addItem(c.getNombre());
//        }
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
