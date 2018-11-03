package com.desktopclient.utils;

import com.desktopclient.Logic.StaticTableModel;
import com.desktopclient.Logic.StaticTableModel;
import java.util.List;
import javax.swing.JTable;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.TableModel;

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
//</editor-fold>ç
    
    public JTable tablaEditable(JTable t, String[] tableHeaders, List<Object[]> data) {
        t.setModel(new tablaEditable(tableHeaders,data));
        return t;
    }

    class tablaEditable extends AbstractTableModel{
        
        private String[] columnNames;
        private List<Object[]> data;
        
        tablaEditable(String[] columnNames, List<Object[]> data){
            this.columnNames = columnNames;
            this.data = data;
        }

        @Override
    public int getColumnCount() {
        return columnNames.length;
    }

        @Override
    public int getRowCount() {
        return data.size();
    }

        @Override
    public String getColumnName(int col) {
        return columnNames[col];
    }

        @Override
    public Object getValueAt(int row, int col) {
        Object[] object = data.get(row);
        return object[col];
    }

    public Class getColumnClass(int c) {
        return getValueAt(0, c).getClass();
    }

    /*
     * Don't need to implement this method unless your table's
     * editable.
     */
    public boolean isCellEditable(int row, int col) {
        //Note that the data/cell address is constant,
        //no matter where the cell appears onscreen.
        if (col == 3) {
            return true;
        } else {
            return false;
        }
    }
  
    }
}
