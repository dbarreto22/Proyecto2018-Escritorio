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
import com.desktopclient.datatypes.DtCurso;
import com.desktopclient.datatypes.DtUsuario;
import com.desktopclient.datatypes.DtUsuarioLogueado;
import com.desktopclient.entidades.Curso;
import java.awt.Desktop;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import static java.util.UUID.randomUUID;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JOptionPane;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import org.apache.commons.codec.binary.Base64;
import org.apache.commons.lang3.StringUtils;
import sun.misc.BASE64Decoder;

/**
 *
 * @author Ernesto
 */
public class ActaEscolaridad extends javax.swing.JInternalFrame {

    tableUtils tUtils = tableUtils.getInstance();
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
     * Creates new form HorariosCursos
     */
    public ActaEscolaridad() {
//        this.usuariolog = usuariolog;
        initComponents();
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
        tableEstudiantes = new javax.swing.JTable();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        docEstudianteTxt = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        Buscar = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        nombreEstudianteTxt = new javax.swing.JTextField();

        setBackground(new java.awt.Color(245, 245, 245));
        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Escolaridad");

        paneldata.setBackground(new java.awt.Color(245, 245, 245));
        paneldata.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel4.setBackground(new java.awt.Color(255, 255, 255));
        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("Estudiantes");

        salir.setBackground(new java.awt.Color(102, 204, 255));
        salir.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        salir.setText("Salir");
        salir.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        salir.setPreferredSize(new java.awt.Dimension(49, 19));
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

        javax.swing.GroupLayout paneldataLayout = new javax.swing.GroupLayout(paneldata);
        paneldata.setLayout(paneldataLayout);
        paneldataLayout.setHorizontalGroup(
            paneldataLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, paneldataLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(paneldataLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 734, Short.MAX_VALUE)
                    .addGroup(paneldataLayout.createSequentialGroup()
                        .addGap(0, 632, Short.MAX_VALUE)
                        .addComponent(salir, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(23, 23, 23))
            .addGroup(paneldataLayout.createSequentialGroup()
                .addGap(238, 238, 238)
                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 226, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        paneldataLayout.setVerticalGroup(
            paneldataLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(paneldataLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 215, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(salir, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jPanel2.setBackground(new java.awt.Color(240, 245, 245));
        jPanel2.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel2.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel2.setText("Documento");

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

        jLabel3.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel3.setText("Nombre");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(nombreEstudianteTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 278, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 168, Short.MAX_VALUE)
                                .addComponent(Buscar, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(132, 132, 132))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(docEstudianteTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 278, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))))))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(docEstudianteTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(5, 5, 5)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(nombreEstudianteTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(Buscar, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 16, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(paneldata, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(20, 20, 20))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(paneldata, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void salirMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_salirMouseClicked
        // TODO add your handling code here:
        this.dispose();
    }//GEN-LAST:event_salirMouseClicked

    private void salirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_salirActionPerformed
        this.dispose();
    }//GEN-LAST:event_salirActionPerformed

    private void BuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BuscarActionPerformed
        panelUtils.getInstance().panelClearData(paneldata);
        tableConstructor();
    }//GEN-LAST:event_BuscarActionPerformed

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
    private javax.swing.JButton Buscar;
    private javax.swing.JTextField docEstudianteTxt;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTextField nombreEstudianteTxt;
    private javax.swing.JPanel paneldata;
    private javax.swing.JButton salir;
    private javax.swing.JTable tableEstudiantes;
    // End of variables declaration//GEN-END:variables

    private void tableConstructor() {
        List<DtUsuario> listestudiante = Recursos.getAllEstudiantes();
        if (checkLastStatusOK()) {
            String[] tableHeaders = {"Documento", "Nombre", "Apellido", "Carrera código", "Nombre"};
            List<Object[]> dataA = new ArrayList<>();

            String docEstudianteSelected = docEstudianteTxt.getText();
            String nombreEstudianteSelected = nombreEstudianteTxt.getText();
            listestudiante.forEach(estudiante -> {
                Boolean ok = true;
                System.out.println("estudiante: " + estudiante.getCedula());
                if (docEstudianteSelected != "" && (!StringUtils.containsIgnoreCase(estudiante.getCedula(), docEstudianteSelected))
                        || nombreEstudianteSelected != "" && (!StringUtils.containsIgnoreCase(estudiante.getApellido() + estudiante.getNombre(), nombreEstudianteSelected))) {
                } else {
                    System.out.println("OK");
                    estudiante.getCarreras().forEach(carrera -> {
                        dataA.add(new Object[]{estudiante.getCedula(), estudiante.getNombre(), estudiante.getApellido(),
                            carrera.getCodigo(), carrera.getNombre()});
                    });

                }
            });
            tableEstudiantes = tUtils.tableConfig(tableEstudiantes, tableHeaders, dataA, ListSelectionModel.SINGLE_SELECTION);
            System.out.println("dataA.size(): " + dataA.size());
            if (dataA.size() != 0) {
                tableEstudiantes.getSelectionModel().addListSelectionListener((ListSelectionEvent event) -> {
                    if (event.getValueIsAdjusting()) {
                        String cedula = tableEstudiantes.getModel().getValueAt(tableEstudiantes.getSelectedRow(), 0).toString();
                        Long codigoCarrera = Long.parseLong(tableEstudiantes.getModel().getValueAt(tableEstudiantes.getSelectedRow(), 3).toString());
                        getEscolaridad(cedula, codigoCarrera);
                    }
                });
            }
        }else{
            this.dispose();
        }
    }

    private void getEscolaridad(String cedula, Long codigoCarrera) {
        String pdfb64 = Recursos.getEscolaridad(cedula, codigoCarrera);
        if (checkLastStatusOK()) {
            try {
                System.out.println("LLAMO ARCHIVO CURSO OBJ");
                System.out.println("pdfb64: " + pdfb64);
                BASE64Decoder decoder = new BASE64Decoder();
                byte[] decodedBytes;
                FileOutputStream fop;
                decodedBytes = new BASE64Decoder().decodeBuffer(pdfb64);
                String fileName = ".\\actas\\acta_" + randomUUID() + ".pdf";
                System.out.println("fileName: " + fileName);

//            String filePath = new File("").getAbsolutePath();
//            String fullpath = filePath + fileName;
//            System.out.println("fullpath: " + fullpath);
                File file = new File(".", fileName);
                file.createNewFile();
                fop = new FileOutputStream(file);

                fop.write(decodedBytes);

                fop.flush();
                fop.close();

                if (Desktop.isDesktopSupported()) {
                    if (file.exists()) {
                        Desktop.getDesktop().open(file);
                    } else {
                        System.out.println("No existe el archivo");
                    }
                }
            } catch (FileNotFoundException ex) {
                System.out.println("FileNotFoundException : " + ex);
            } catch (IOException ex) {
                Logger.getLogger(ActaEscolaridad.class.getName()).log(Level.SEVERE, null, ex);
            }

        }else{
            this.dispose();
        }
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
