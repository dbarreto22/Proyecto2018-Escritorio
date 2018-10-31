package com.desktopclient.Logic;

import javax.swing.table.DefaultTableModel;

/*
 * @author acaceres
 */
public class StaticTableModel extends DefaultTableModel {

    @Override
    public boolean isCellEditable(int row, int column) {
        return false;
    }
}