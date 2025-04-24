package co.edu.sena.stockclem.utils;

import javax.swing.JOptionPane;

/**
 *Date: 09/10/2024
 * @author Esteban Colorado Vargas
 * objetivo: clase para utileria de mensajes en pantalla
 */
public class MessageUtils {
    
    public static void showInfoMessage(String message){
        JOptionPane.showMessageDialog(null, message,"Mensaje",JOptionPane.INFORMATION_MESSAGE);
    }
    
    public static void showWarningMessage(String message){
        JOptionPane.showMessageDialog(null, message,"Advertencia",JOptionPane.WARNING_MESSAGE);
    }
    
    public static void showErrorMessage(String message){
        JOptionPane.showMessageDialog(null, message,"Error",JOptionPane.ERROR_MESSAGE);
    }

    public static void showInfoMessage(int i) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
