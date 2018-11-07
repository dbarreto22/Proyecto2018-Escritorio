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
public class GestionExamen extends javax.swing.JInternalFrame {

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
     * Creates new form HorariosExamens
     */
    public GestionExamen() {
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
        agregar = new javax.swing.JButton();
        eliminar = new javax.swing.JButton();
        editar = new javax.swing.JButton();
        salir = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        tableExamenes = new javax.swing.JTable();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        asignaturaTxt = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        Carreras = new javax.swing.JComboBox<>();
        jLabel5 = new javax.swing.JLabel();
        Buscar = new javax.swing.JButton();

        setBackground(new java.awt.Color(245, 245, 245));
        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Gestión Exámenes");

        paneldata.setBackground(new java.awt.Color(245, 245, 245));
        paneldata.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel4.setBackground(new java.awt.Color(255, 255, 255));
        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("Exámenes");

        agregar.setBackground(new java.awt.Color(204, 204, 255));
        agregar.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        agregar.setText("Agregar");
        agregar.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        agregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                agregarActionPerformed(evt);
            }
        });

        eliminar.setBackground(new java.awt.Color(204, 204, 255));
        eliminar.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        eliminar.setText("Eliminar");
        eliminar.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        eliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                eliminarActionPerformed(evt);
            }
        });

        editar.setBackground(new java.awt.Color(204, 204, 255));
        editar.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        editar.setText("Editar");
        editar.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        editar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editarActionPerformed(evt);
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

        tableExamenes.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "", ""
            }
        ));
        jScrollPane3.setViewportView(tableExamenes);

        javax.swing.GroupLayout paneldataLayout = new javax.swing.GroupLayout(paneldata);
        paneldata.setLayout(paneldataLayout);
        paneldataLayout.setHorizontalGroup(
            paneldataLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, paneldataLayout.createSequentialGroup()
                .addGroup(paneldataLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(paneldataLayout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(salir, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, paneldataLayout.createSequentialGroup()
                        .addGap(37, 37, 37)
                        .addGroup(paneldataLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane3, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(paneldataLayout.createSequentialGroup()
                                .addGroup(paneldataLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(paneldataLayout.createSequentialGroup()
                                        .addComponent(editar, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(38, 38, 38)
                                        .addComponent(eliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(paneldataLayout.createSequentialGroup()
                                        .addComponent(agregar, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(119, 119, 119)
                                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 226, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(0, 0, Short.MAX_VALUE)))))
                .addGap(23, 23, 23))
        );
        paneldataLayout.setVerticalGroup(
            paneldataLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(paneldataLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(paneldataLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(agregar, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 204, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(paneldataLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(eliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(editar, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(salir, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

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
                                .addComponent(Carreras, 0, 319, Short.MAX_VALUE)))
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
                .addGap(21, 21, 21)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(paneldata, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(46, Short.MAX_VALUE))
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

        getAccessibleContext().setAccessibleName("Gestion_Examen");

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void eliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_eliminarActionPerformed
        
        if (idExamen == null || idExamen.equals(0L)) {
            JOptionPane.showMessageDialog(null, "Debe seleccionar un examen", "Error", JOptionPane.ERROR_MESSAGE);
        } else {
            System.out.println("idExamen: " + idExamen);
            JFrame frame = new JFrame();
            String[] options = new String[2];
            options[0] = new String("Sí");
            options[1] = new String("No");
            int dialogButton = JOptionPane.showOptionDialog(frame.getContentPane(), "Está seguro que desea eliminar el examen?", "Examen", 0, JOptionPane.YES_NO_OPTION, null, options, null);

            if (dialogButton == JOptionPane.YES_OPTION) {
                System.out.println("ELIMINAR");
                String result = Recursos.removeExamen(idExamen);
                JOptionPane.showMessageDialog(null, result, "", JOptionPane.INFORMATION_MESSAGE);
                tableConstructor();
            }
        }
    }//GEN-LAST:event_eliminarActionPerformed

    private void salirMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_salirMouseClicked
        // TODO add your handling code here:
        this.dispose();
    }//GEN-LAST:event_salirMouseClicked

    private void CarrerasItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_CarrerasItemStateChanged
        // TODO add your handling code here:
//        List<Carrera> carreras = Recursos.getAllCarreras(usuariolog.getToken());
//        long idCarrera = 0;
//        for (int i = 0; i < carreras.size(); i++) {
//            if (carreras.get(i).getNombre().equals(Carreras.getSelectedItem().toString())){
//                idCarrera = carreras.get(i).getCodigo();
//                break;
//            }
//        }

//        List<Asignatura> asignaturas = Recursos.getAsignaturasByCarrera(idCarrera,usuariolog.getToken());
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

    private void agregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_agregarActionPerformed
        ExamenObj ne = new ExamenObj("Datos nuevo Examen", 0L);
    }//GEN-LAST:event_agregarActionPerformed

    private void editarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editarActionPerformed
        if (idExamen == null || idExamen.equals(0L)) {
            JOptionPane.showMessageDialog(null, "Debe seleccionar un examen", "Error", JOptionPane.ERROR_MESSAGE);
        } else {
            ExamenObj ne = new ExamenObj("Editar Examen", idExamen);
        }
    }//GEN-LAST:event_editarActionPerformed

    private void salirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_salirActionPerformed
        this.dispose();
    }//GEN-LAST:event_salirActionPerformed

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
//            java.util.logging.Logger.getLogger(HorariosExamens.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (InstantiationException ex) {
//            java.util.logging.Logger.getLogger(HorariosExamens.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (IllegalAccessException ex) {
//            java.util.logging.Logger.getLogger(HorariosExamens.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
//            java.util.logging.Logger.getLogger(HorariosExamens.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        }
//        //</editor-fold>
//
//        /* Create and display the form */
//        java.awt.EventQueue.invokeLater(new Runnable() {
//            public void run() {
//                new HorariosExamens(usuariolog).setVisible(true);
//            }
//        });
//    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Buscar;
    private javax.swing.JComboBox<String> Carreras;
    private javax.swing.JButton agregar;
    private javax.swing.JTextField asignaturaTxt;
    private javax.swing.JButton editar;
    private javax.swing.JButton eliminar;
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
        String[] tableHeaders = {"", "Asignatura", "Carrera", "Fecha"};
        List<Object[]> dataA = new ArrayList<>();
        String carreraStr = Carreras.getSelectedItem().toString();
        Long carreraSelected = Long.parseLong(carreraStr.substring(0, carreraStr.indexOf("-")));
        System.out.println("carreraSelected: " + carreraSelected);
        String asginaturaSelected = asignaturaTxt.getText();
        System.out.println("asginaturaSelected: " + asginaturaSelected);
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
                if(event.getValueIsAdjusting()){
                    idExamen = Long.parseLong(tableExamenes.getModel().getValueAt(tableExamenes.getSelectedRow(), 0).toString());
                }
            });
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

}
