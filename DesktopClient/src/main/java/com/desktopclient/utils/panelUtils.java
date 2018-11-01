package com.desktopclient.utils;

import java.awt.Component;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.JTree;

/* @author agustin */
public class panelUtils {

    //<editor-fold defaultstate="collapsed" desc="Manejadores de instancia">
    private panelUtils() {
    }

    public static panelUtils getInstance() {
        return panelUtilsHolder.INSTANCE;
    }

    private static class panelUtilsHolder {

        private static final panelUtils INSTANCE = new panelUtils();
    }
//</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="Limpia un panel haciendolo invisible">
    public void panelClearData (javax.swing.JPanel panel) {
        tableUtils tUtils = tableUtils.getInstance();
        for(Component control : panel.getComponents()){
            if(control instanceof JTextField)
            {
                JTextField ctrl = (JTextField) control;
                ctrl.setText("");
            }
            else if (control instanceof JComboBox)
            {
                JComboBox ctrl = (JComboBox) control;
                ctrl.setSelectedIndex(0);
            }
            
            else if (control instanceof JComboBox)
            {
                JComboBox ctrl = (JComboBox) control;
                ctrl.setSelectedIndex(0);
            } 
            
            else if (control instanceof JFileChooser)
            {
                JFileChooser ctrl = (JFileChooser) control;
                ctrl.cancelSelection();
            } 
            
            else if (control instanceof JFileChooser)
            {
                JFileChooser ctrl = (JFileChooser) control;
                ctrl.cancelSelection();
            } 
            
            else if (control instanceof JTree)
            {
                JTree ctrl = (JTree) control;
                ctrl.clearSelection();
            } 
            
            else if (control instanceof JTable)
            {
                JTable ctrl = (JTable) control;
                String[] tableHeaders = {};
                List<Object[]> data = new ArrayList<>();
                ctrl.clearSelection();
//                ctrl.setModel(new javax.swing.table.DefaultTableModel(
//                new Object [][] {
//                },
//                new String [] {
//                }));
                  tUtils.tableConfig(ctrl, tableHeaders, data, 0);
            }
            
            else if (control instanceof JPanel)
            {
                JPanel ctrl = (JPanel) control;
                panelClearData(ctrl);
            }
            
            else if (control instanceof JLabel)
            {
                JLabel ctrl = (JLabel) control;
                ctrl.setIcon(null);
            }
            
//            panel.setVisible(false);
        }
    }
//</editor-fold>  
}
