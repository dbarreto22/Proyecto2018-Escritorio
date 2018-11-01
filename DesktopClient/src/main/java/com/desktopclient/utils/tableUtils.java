package com.desktopclient.utils;

import com.desktopclient.Logic.StaticTableModel;
import com.desktopclient.Logic.StaticTableModel;
import java.util.List;
import javax.swing.JTable;

/* @author agustin */
public class tableUtils {

    //<editor-fold defaultstate="collapsed" desc="Manejadores de instancia">
    private tableUtils() {
    }

    public static tableUtils getInstance() {
        return tableUtilsHolder.INSTANCE;
    }

    private static class tableUtilsHolder {

        private static final tableUtils INSTANCE = new tableUtils();
    }
//</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="Configuracion del DefaultTableModel - Setea las columnas y filas"y las hace no editables">
    public StaticTableModel staticTableModelBuilder(String[] headers, List<Object[]> data) {
        StaticTableModel m = new StaticTableModel();
        for (String h : headers) {
            m.addColumn(h);
        }
        data.forEach((c) -> {
            m.addRow(c);
        });
        return m;
    }
//</editor-fold>  

    //<editor-fold defaultstate="collapsed" desc="Configuracion de JTable - setea el modelo(Llamada a tableModelBuilder) y setea el SelectionMode">
    public JTable tableConfig(JTable t, String[] tableHeaders, List<Object[]> data, int selectionMode) {
        t.setModel(this.staticTableModelBuilder(tableHeaders, data));
        t.setSelectionMode(selectionMode);
        return t;
    }
//</editor-fold>

}
