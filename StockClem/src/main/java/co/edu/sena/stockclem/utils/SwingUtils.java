package co.edu.sena.stockclem.utils;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.function.Function;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Juan Diego
 */
public class SwingUtils {
    
    /**
     * Genera y asigna un TableModel a cualquier JTable dado:
     * @param <T> Tipo de los objetos en items
     * @param table La tabla Swing a poblar
     * @param items Lista de objetos que representan las filas
     * @param columns LinkedHasMap donde:
     *                      ° key = Título de la columna
     *                      ° value = función que extrae el valor de esa columna
     *                                a partir de cada objeto T
     */
    public static <T> void fillTable(JTable table,
                                     List<T> items,
                                     LinkedHashMap<String, Function<T, Object>> columns) {
        DefaultTableModel model = new DefaultTableModel();
        // Agrega las columnas en el orden dado
        columns.keySet().forEach(model::addColumn);
        
        // Por cada objeto, crea una fila consultando cada función
        for (T item : items) {
            Object[] row = columns.values()
                                  .stream()
                                  .map(f -> f.apply(item))
                                  .toArray();
            model.addRow(row);
        }
        
        table.setModel(model);
    }
    
    /**
     * Llena cualquier JComboBox con la lista de items.
     * @param combo   El combo a poblar
     * @param items   Los objetos a mostrar; usa toString() de cada uno
     * @param <T>     Tipo de los objetos
     */
    public static <T> void fillComboBox(JComboBox<T> combo, List<T> items) {
        DefaultComboBoxModel<T> model = new DefaultComboBoxModel<>();
        items.forEach(model::addElement);
        combo.setModel(model);
        combo.setSelectedIndex(-1); // Ninguna selección inicial
    }
}
