/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package pablo;

import javax.swing.JOptionPane;

/**
 *
 * @author pablo
 */
public class LaMorra {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
    }
    
    
    public static String mostrarMenuJuego(){
        
        String texto="""
                        La Morra 
                       -----------
                       Escriba "Jugar" para comenzar.
                       Escribar "Salir" si no quiere jugar.
                    
                     
                    """;
        
        String opcion= JOptionPane.showInputDialog(null, texto);
        
        
        return opcion;
        
    }
}
