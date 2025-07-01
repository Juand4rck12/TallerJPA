package com.market.marketprojectone.utils;

import javax.swing.JOptionPane;

/**
 *
 * @author Juan Diego
 * Objetivo: Clase de utileria de mensajes
 */
public class MessageUtils {
    public static void showInfoMessage(String message) {
        JOptionPane.showMessageDialog(null, message, "Mensaje", JOptionPane.INFORMATION_MESSAGE);
    }
    
    public static void showWarningMessage(String message) {
        JOptionPane.showMessageDialog(null, message, "Advertencia", JOptionPane.WARNING_MESSAGE);
    }
    
    public static void showErrorMessage(String message) {
        JOptionPane.showMessageDialog(null, message, "Error", JOptionPane.ERROR_MESSAGE);
    }
}
