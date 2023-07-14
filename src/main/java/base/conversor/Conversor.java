/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */

package base.conversor;

import java.util.Arrays;
import javax.swing.JOptionPane;

/**
 *
 * @author Edwin_God
 */
public class Conversor { 

    /**
    *
    * Este es el metodo main que va a correr el metodo de menu principal para que empiece a correr el programa
    */
    public static void main(String[] args) {
        menuPrincipal();
    }
    
    /**
    *El metodo de menu principal es el encargado de lanzar una ventana de tipo JOptionPane para que el usuario 
    * seleccione una opción, en ese caso solo existe una opción
    */
    public static void menuPrincipal (){
         String[] opcion = {"Conversor de moneda"};
        String tipoDeConversion = (String) JOptionPane.showInputDialog(null, "Selecciona un tipo de conversión:",
                "Tipo de conversión", JOptionPane.PLAIN_MESSAGE, null, opcion, opcion[0]);
        
        if (tipoDeConversion.equals(opcion[0])){
            conversorMoneda();
        }else {
            System.out.println("Voy a convertir temperatura");
        }
    }
    
    public static void conversorMoneda(){
        String cantidadStr = "";
        double cantidad = 0.0;
        double resultado=0;
        boolean esNumeroValido = false;
        
        String[] tipoDeCambio = {"Peso Mexicano a Dolar", "Peso Mexicano a Euro", "Peso Mexicano a Peso Colombiano", 
        "Dolar a Peso Mexicano", "Euro a Peso Mexicano", "Peso Colombiano a Peso Mexicano"};
        
        //Ventana por la cual va a elegir el tipo de cambio 
        String tipoDeMoneda = (String) JOptionPane.showInputDialog(null, "Selecciona un tipo de conversión:",
                "Tipo de conversión", JOptionPane.PLAIN_MESSAGE, null, tipoDeCambio, tipoDeCambio[0]);
        
        // Obtener la cantidad a convertir 

        while (!esNumeroValido) {
            cantidadStr = JOptionPane.showInputDialog(null, "Ingresa la cantidad a convertir:",
                    "Convertidor de Moneda", JOptionPane.PLAIN_MESSAGE);

            try {
                cantidad = Double.parseDouble(cantidadStr);
                esNumeroValido = true;
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Error: Ingresa un número válido.", "Error de Entrada",
                        JOptionPane.ERROR_MESSAGE);
            }
        }

        
        switch (tipoDeMoneda){
            case "Peso Mexicano a Dolar":
                resultado = cantidad * 0.058;
                break;
            case "Peso Mexicano a Euro":
                resultado = cantidad * 0.054;
                break;    
            case "Peso Mexicano a Peso Colombiano":
                resultado = cantidad * 243.48;
                break;    
            case "Dolar a Peso Mexicano":
                resultado = cantidad * 17.11;
                break;
            case "Euro a Peso Mexicano":
                resultado = cantidad * 18.67;
                break;    
            case "Peso Colombiano a Peso Mexicano":
                resultado = cantidad * 0.0041;
                break;         
        }
        
        JOptionPane.showMessageDialog(null,"Usted tiene: "+ resultado, tipoDeMoneda, JOptionPane.INFORMATION_MESSAGE);
        reinicio();
    }
    
    public static void reinicio (){
        int confirmado = JOptionPane.showConfirmDialog(null,"¿Conrinuar con el programa?","Continuar",0);
        
        if (JOptionPane.OK_OPTION == confirmado)
            menuPrincipal();
        else
            JOptionPane.showMessageDialog(null, "El programa ha finalizado", "Programa Finalizado", JOptionPane.INFORMATION_MESSAGE);
    }
}


