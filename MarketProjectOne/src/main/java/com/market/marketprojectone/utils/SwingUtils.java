package com.market.marketprojectone.utils;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.function.Function;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author victus
 */
public class SwingUtils {
    public static <T> void fillTable(JTable table,
                                     List<T> items,
                                     LinkedHashMap<String, Function<T, Object>> columns)
    {
        DefaultTableModel model = new DefaultTableModel();
        
        columns.keySet().forEach(model::addColumn);
        
        for (T item : items) {
            Object[] row = columns.values()
                                  .stream()
                                  .map(f -> f.apply(item))
                                  .toArray();
            model.addRow(row);
        }
        
        table.setModel(model);
    }
    
    public static <T> void fillComboBox(JComboBox combo, List<T> items){
        DefaultComboBoxModel model = new DefaultComboBoxModel<>();
        items.forEach(model::addElement);
        combo.setModel(model);
        combo.setSelectedIndex(0);
    }
}
