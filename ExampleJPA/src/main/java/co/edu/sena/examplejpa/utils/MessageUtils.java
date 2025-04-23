/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.edu.sena.examplejpa.utils;

import javax.swing.JOptionPane;

/**
 * Fecha: 9/10/24
 * @author Lina Vanessa Salcedo
 * Objetivo: Clase para utileria de mensajes en pantalla
 */
public class MessageUtils {
    
    public static void ShowInfoMessage(String message)
    {
        JOptionPane.showMessageDialog(null, message, "Mensaje", JOptionPane.INFORMATION_MESSAGE);
    }
    public static void ShowWarningMessage(String message)
    {
        JOptionPane.showConfirmDialog(null, message, "Advertencia", JOptionPane.WARNING_MESSAGE);
    }
    public static void ShowErrorMessage(String message)
    {
        JOptionPane.showMessageDialog(null, message, "Error", JOptionPane.ERROR_MESSAGE);
    }
}
