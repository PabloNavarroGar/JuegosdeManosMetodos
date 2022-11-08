/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package pablo;

import java.util.Random;
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
        String opcion = "";
        String mensajeIntrucciones = "";
        int usuario = 0;
        int maquina;
        int prediccionUsuario = 0;
        int prediccionMaquina;
        int suma;
        int victoriasUsuario=0;
        int victoriasMaquina=0;
        String resultado="";
        int contador=0;
        do {

            opcion = pedirOpcion(); // Opcion es "salir" o "jugar"
            if (!opcion.equalsIgnoreCase("salir")) {

                mensajeIntrucciones = mensajePartidaSimple(opcion);
                usuario = pedirNumeroUsuarioSinErrores(usuario);
                maquina = numeroMaquina();

                //Continuan con la prediciion del usuaruo y prediccion de la maquina
                prediccionUsuario = prediccionUsuario(usuario, prediccionUsuario);
                prediccionMaquina = prediccionMaquina(maquina);
                //Inciamos la suma de ambas partes

                suma = sumaMaquinaUsuario(usuario, maquina);
                       //Metodo para comprobar el ganador
                comprobarGanadorRonda(suma, maquina, prediccionUsuario, prediccionMaquina, suma);

               
                if (resultado == "Empate, siguiente ronda") {

                    //Si han empatado se le suma una victoria a cada jugador
                    victoriasUsuario++;
                    victoriasMaquina++;

                    JOptionPane.showMessageDialog(null,
                            "Empate, un punto para cada uno");

                } else if (resultado == "Has ganado") {

                    //Si ha ganado el usuario se le suma una victoria
                    JOptionPane.showMessageDialog(null,
                            "Has ganado la ronda");

                    victoriasUsuario++;

                } else if (resultado == "Ha ganado la maquina") {

                    //Si ha ganado la máquina se le suma una victoria
                    JOptionPane.showMessageDialog(null,
                            "La máquina ha ganado la ronda");

                    victoriasMaquina++;

                } else {

                    //Si no ha acertado nadie el programa continua
                    JOptionPane.showMessageDialog(null,
                            "Nadie ha ganado siguiente ronda");
                }

                //Inicializamos la variable que muestra el número de victorias de
                //cada uno y el número de ronda correspondiente
                String resultados = """
                           
                           Jugador = %d
                           Maquina = %d
                           
                           Ronda = %d
                           """.formatted(
                        victoriasUsuario,
                        victoriasMaquina,
                        contador + 1);

                JOptionPane.showMessageDialog(null, resultados);
            }

        } while (opcion.equalsIgnoreCase("jugar"));

    }

    public static String mostrarMenuJuego() {

        String texto = """
                        La Morra 
                       -----------
                       Escriba "Jugar" para comenzar una Partida Simple.
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

    public static int pedirNumeroUsuarioSinErrores(int numeroUsuario) {
        //Pedimos un entero al usuario 
        //Se va a jugar con una mano
        do {

            try {
                String numero = JOptionPane.showInputDialog("Introduce un numero de dedos del 0 al 5 : ");
                numeroUsuario = Integer.parseInt(numero);
                JOptionPane.showMessageDialog(null, "El numero "
                        + "que has escogido es el: " + numero);
            } catch (NumberFormatException nfe) {
                JOptionPane.showConfirmDialog(null, "No has "
                        + "introducido un número entero.");
            }
        } while (numeroUsuario < 0 || numeroUsuario > 5);

        return numeroUsuario;

    }

    public static int numeroMaquina() {
        //Clase random para , gracias samuel
        Random numeroAleatorio = new Random();
        //El int de la maquina se iguala al numero random con un next Int para que sea int
        //y 10 y fuera del parentesiss +1 para que pille los 10, si no seria hasta 9
        int maquina = numeroAleatorio.nextInt(5) + 1;
        JOptionPane.showMessageDialog(null, "La maquina a escogido el numero : " + maquina);
        return maquina;
    }

    public static int sumaMaquinaUsuario(int numeroUsuario, int numeroMaquina) {
        int suma;

        suma = numeroUsuario + numeroMaquina;

        JOptionPane.showMessageDialog(null, " La suma del numero de usuario  "
                + numeroUsuario + " y el numero de la maquina es " + numeroMaquina + " en total la suma total de dedos son : " + suma);

        return suma;
    }

    @SuppressWarnings("empty-statement")
    public static int prediccionUsuario(int numeroUsuario, int prediccionUsuario) {
        ;

        do {
            try {

                //Inicializamos la variable con lo que el usuario introduzca
                prediccionUsuario = Integer.parseInt(JOptionPane.showInputDialog("Piensa cual numero vas a predecir, no puede"
                        + " ser mas pequeño del que hayas seleccionado y mas grande que la suma maxima posible +"));

                //Ponemos a false para salir del primer bucle y comprobar la
                //segunda conndición de rango
            } catch (NumberFormatException nfe) {

                //Mensaje que salta si hay error de introducción
                JOptionPane.showMessageDialog(null,
                        "Valor no numérico, repita");
            }

            //Mensaje que salta si no coincidimos con el rango disponible
            return prediccionUsuario;

        } while (prediccionUsuario <= pedirNumeroUsuarioSinErrores(numeroUsuario) || prediccionUsuario > 10);

    }

    public static int prediccionMaquina(int prediccionMaquina) {

        Random numeroAleatorio = new Random();
        //El int de la maquina se iguala al numero random con un next Int para que sea int
        //y 10 y fuera del parentesiss +1 para que pille los 10, si no seria hasta 9
        int maquina = numeroAleatorio.nextInt(11 - prediccionMaquina + 1) + prediccionMaquina;
        JOptionPane.showMessageDialog(null, "La maquina a escogido como prediccion el numero  : " + maquina);
        return maquina;

    }

    public static String comprobarGanadorRonda(int numeroJugador, int numeroMaquina, int prediccionJugador, int prediccionMaquina,
            int suma) {

        //Variable que muestra lo que ha sacado cada jugador, cual es la
        //prediccion de cada uno y la suma de los dedos sacados en cada ronda
        String resultado = "";
        String datos = """
                     
                     Número que has sacado = %d
                     Numero que has predecido = %d
                     
                     Número que ha sacado la máquina = %d
                     Número que ha predecido la máquina = %d
                     
                     Suma total = %d
                     
                     """.formatted(numeroJugador, prediccionJugador,
                numeroMaquina, prediccionMaquina, suma);
                        
        JOptionPane.showMessageDialog(null, datos);

        if (prediccionJugador == suma && prediccionMaquina == suma) {
            resultado = "Empate, siguiente ronda";

        } else {

            //Gana el usuario si acierta con la suma
            if (prediccionJugador == suma) {
                resultado = "Has ganado";

            }

            //Gana la máquina si acierta con la suma
            if (prediccionMaquina == suma) {
                resultado = "Ha ganado la maquina";

            }

            //No gana nadie si ninguno acierta es distinto !=
            if (prediccionJugador != suma && prediccionMaquina != suma) {
                resultado = "Nadie ha ganado se repite la ronda";
            }
        }

        //Se devuelve el valor de la cadena y este valor se almacenará en la
        //variable resultado en el método partidaSimple que se usara para contar
        //las victorias de ambos jugadores
        return resultado;

    }

}
