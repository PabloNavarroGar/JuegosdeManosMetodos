/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */

package pablo;

import javax.swing.JOptionPane;

/**
 *
 * @author pablo
 */
public class ParesYnones {

    public static void main(String[] args) {
        System.out.println("Hello World!");
        String opcion="";
        
    }
    
    public static String mostrarMenuJuego(){
        //String que contiene el texto del menu
        String texto="""
                      Pares Y Nones 3000 Next Generation
                     _____________________________________
                     
                     Escribar "Jugar" para comenzar.
                     --------------------------------------
                     Escriba "Salir" si no quiere jugar.
                     
                     """;
        
        String opcion = JOptionPane.showInputDialog(null, texto);
        return opcion;
    }
    
    
    public static String pedirOpcion(){
        //declaramos el string opcion, que entramos en un bucle que opcion es igual
        //al menu y la opc
        String opcion;
        do{
            opcion=mostrarMenuJuego();
        }while(!opcionValida(opcion));
        
        return opcion;
    }
    
    public static boolean opcionValida(String opcion){
            //declaramos en el parametro String opcion y que haga un return 
            //con las opciones
    
        return opcion.equalsIgnoreCase("Jugar")||
                opcion.equalsIgnoreCase("Salir");
    
    
    }
    
    
}
