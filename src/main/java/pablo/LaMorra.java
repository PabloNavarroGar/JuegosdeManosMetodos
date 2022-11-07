/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package pablo;

import javax.swing.JOptionPane;
import static pablo.ParesYnones.mostrarMenuJuego;
import static pablo.ParesYnones.pedirOpcion;

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
        //variables
        String opcion="";
        String mensajeIntrucciones="";
        
            do{
                
                opcion = pedirOpcion(); // Opcion es "salir" o "jugar"
                if(!opcion.equalsIgnoreCase("salir")){
                    
                    
                    mensajeIntrucciones=mensajePartidaSimple(opcion);
                    
                    
                }
                
                
            }while(opcion.equalsIgnoreCase("jugar"));
        
        
        
        
        
        
        
        
        
        
        
    }

    public static String mostrarMenuJuego() {

        String texto = """
                        La Morra 
                       -----------
                       Escriba "Jugar" para comenzar una partida simple.
                       Escribar "Salir" si no quiere jugar.
                    
                     
                    """;

        String opcion = JOptionPane.showInputDialog(null, texto);

        return opcion;

    }

    public static String pedirOpcion() {
        //declaramos el string opcion, que entramos en un bucle que opcion es igual
        //al menu y la opcion se iguala con el metodo del menu, y la condicion del si es valida
        String opcion;
        do {
            opcion = mostrarMenuJuego();
        } while (!opcionValida(opcion));

        return opcion;
    }

    public static boolean opcionValida(String opcion) {
        //declaramos en el parametro String opcion y que haga un return 
        //con las opciones jugar o salir 

        return opcion.equalsIgnoreCase("Jugar")
                || opcion.equalsIgnoreCase("Salir");
    }

    public static String mensajePartidaSimple(String texto) {

         texto = """
                     "Bienvenido al juego de la morra,"
                     "Ambos jugadores sacareis un numero de 0 a 5,"
                     "a la vez que decis un numero que penseis que será la suma,"
                     "entre los dedos de ambos jugadores "
                    
                     
                    """;

        JOptionPane.showMessageDialog(null, texto);

        return texto;

    }
}
