/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */
package pablo;

import java.util.Random;
import javax.swing.JOptionPane;

/**
 *
 * @author pablo
 */
public class ParesYnones {

    public static void main(String[] args) {
        //variables para los metodos
        String opcion = "";
        String pares_o_nones = "";

        int usuario = 0;
        int numero_maquina;
        int suma = 0;
        //Inicio del bucle que contiene el programa
        do {
            //El string de la opcion con el metodo de pedir la opcion
            opcion = pedirOpcion(); // Opcion es "salir" o "jugar"
            // si escribimos algo que no sea salir, va al menu
            if (!opcion.equalsIgnoreCase("salir")) {

                //pedir pares o nones el menu
                pares_o_nones = pedirParesOnones().toLowerCase();
                //si no escribimos nones , nos metera en el bucle del los Pares , 
                //si le pones nones nos va a los nones
                if (pares_o_nones.equalsIgnoreCase("Pares")) {
                    //Panel para informar que estas en los pares
                    System.out.println("Has seleccionado Pares");
                    //Metodo para pedir numero al usuario
                    usuario = pedirNumeroUsuarioSinErrores(usuario);
                    //variable para que se muestre lo que devuelve la variable maquina ene l metodo
                    
                    //metodo con su variable para que se vea lo que devuelve el metodo maquina
                    numero_maquina = numeroMaquina();
                    suma = sumaMaquinaUsuario(usuario, numero_maquina);
                    //si la suma de los 2 numeros divididos es resto da 0 ganas, si no pierdes
                    if (suma % 2 == 0) {

                        JOptionPane.showMessageDialog(null, +suma
                                +" es Par ,"+ " has ganado ");

                    } else {
                        JOptionPane.showMessageDialog(null,+suma
                                +" Es Impar ," +" has perdido");
                    }
                } else {
                    //Misma descripcion que arriba, solo qe si escribimos nones, nos lleva aqui
                    System.out.println("Has seleccionado Nones");
                    //Metodo para pedir numero
                    usuario = pedirNumeroUsuarioSinErrores(usuario);
                    
                    numero_maquina = numeroMaquina();
                    suma = sumaMaquinaUsuario(usuario, numero_maquina);
                    if (suma % 2 == 0) {

                        JOptionPane.showMessageDialog(null, +suma+" es Par, " +" has perdido ");

                    } else {
                        JOptionPane.showMessageDialog(null,+suma +" es Impar, "+ " has ganado");
                    }
                }
            }
            //condigimos del bucle para que se ejecute hay que escribir jugar
        } while (opcion.equalsIgnoreCase("jugar"));

    }
    //String del menu

    public static String mostrarMenuJuego() {
        //String que contiene el texto del menu
        String texto = """
                      Pares Y Nones 3000 Next Generation
                     _____________________________________
                     
                     Escriba "Jugar" para comenzar.
                     --------------------------------------
                     Escriba "Salir" si no quiere jugar.
                     
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
    //Menu del pares o nones

    public static String menuParesOnones() {

        String texto = """
                                Escriba lo que quiere seleccionar :
                     ---------------------------------------------
                                             Pares
                     ---------------------------------------------
                                             Nones
                     """;

        String opcion = JOptionPane.showInputDialog(texto);
        return opcion;

    }

    public static boolean esParesOnones(String codigo) {
        //en este metodo declaramos el string en el parametros para que pille por "codigo"
        return (codigo.equalsIgnoreCase("Pares") ||
                codigo.equalsIgnoreCase("Nones"));

    }
    //En este menu el String lo compajinamos con el menu pares o nones, y
    //el while con el metodo es esl pares o nones con el return del codigo

    public static String pedirParesOnones() {
        String codigo;
        do {
            codigo = menuParesOnones();
            //aqui se introduce la condicipon con el metodo anterior que devuelve el Pares y Nones
        } while (!esParesOnones(codigo));

        return codigo;
    }

    public static int pedirNumeroUsuarioSinErrores(int numeroUsuario) {
        //Pedimos un entero al usuario 
        do {
           
            try {
                String numero = JOptionPane.showInputDialog("Introduce un numero del 1 al 10: ");
                numeroUsuario = Integer.parseInt(numero);
                JOptionPane.showMessageDialog(null, "El numero "
                        + "que has escogido es el: " + numero);
            } catch (NumberFormatException nfe) {
                JOptionPane.showConfirmDialog(null, "No has "
                        + "introducido un número entero.");
            }
        } while (numeroUsuario < 1 || numeroUsuario > 10);

        return numeroUsuario;

    }
    //Clase para generar el numero de la maquina

    public static int numeroMaquina() {
        //Clase random para , gracias samuel
        Random numeroAleatorio = new Random();
        //El int de la maquina se iguala al numero random con un next Int para que sea int
        //y 10 y fuera del parentesiss +1 para que pille los 10, si no seria hasta 9
        int maquina = numeroAleatorio.nextInt(10) + 1;
        JOptionPane.showMessageDialog(null, "La maquina a escogido el numero : " + maquina);
        return maquina;
    }

    public static int sumaMaquinaUsuario(int numeroUsuario, int numeroMaquina) {
        int suma;

        suma = numeroUsuario + numeroMaquina;

        JOptionPane.showMessageDialog(null, " La suma de " 
                + numeroUsuario + " y " + numeroMaquina + " es de " + suma);

        return suma;
    }

}
