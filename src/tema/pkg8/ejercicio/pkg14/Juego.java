package tema.pkg8.ejercicio.pkg14;
import java.util.Scanner;

/**
 *
 * @author dsimonm01
 */
public class Juego {

    public static void mostrarInicio(Carta carta1, Carta carta2) {
        //Este método simplemente muestra la carta inicial, tanto del jugador como de la CPU
        System.out.println("Carta del jugador: " + carta1.getValor() + "" + carta1.getPalo());
        System.out.println("Carta de la cpu: " + carta2.getValor() + "" + carta2.getPalo());
        System.out.println(" ");
    }

    public static int turnoJugador(Carta player, PaqueteDeCartas baraja) {
        //Aquí empieza el turno del jugador
        Scanner entrada = new Scanner(System.in);
        boolean pasar = false, perder = false;
        String respuesta;
        int puntuacion = 0, aux = 0;
        
        //Se comprueba la carta del jugador, por si se da el caso de que sea un As.
        //En cuyo caso, se le dará la opción al jugador de sumar 1 u 11 puntos a su puntuación
        if (player.getValor() == "As") {
            System.out.println("Has robado un As. ¿Deseas sumar 1 u 11 a tu puntuación?");
            aux = metodoAs();
        } else {
            aux = player.getPuntos();
        }
        System.out.println("--TURNO DEL JUGADOR--");
        
        //A partir de aquí comienza el turno del jugador
        do {
            //Lo primero que se hace es sumar el valor de aux a la puntuación
            puntuacion += aux;
            System.out.println("PUNTUACIÓN: " + puntuacion + " | CARTA ACTUAL: " + player.getValor() + " de " + player.getPalo());
            
            //Se invoca al método comprobar con la puntuación del jugador, para comprobar si se ha pasado o no de 21
            if (comprobar(puntuacion) == true) {
                
                //Si la puntuación del jugador no pasa de 21, se le pregunta si quiere otra carta
                System.out.println("¿Desea pedir otra carta?");
                respuesta = entrada.nextLine();
                if (respuesta.equals("S") || respuesta.equals("s")) {
                    
                    //Si la respuesta del jugador es "S" o "s", se lel 4reparte una nueva carta al jugador
                    player = baraja.repartirCarta();
                    if (player.getValor() == "As") {
                        
                        //en el caso de que se le reparta un As, se procederá a preguntarle al usuario si desea sumar 1 u 11
                        System.out.println("Has robado un As. ¿Deseas sumar 1 u 11 a tu puntuación?");
                        
                        //Se acumula en la variable aux el valor que devuelva el método "metodoAs"
                        aux = metodoAs();
                    } else {
                        
                        //En caso de que la nueva carta no sea un As, se acumula en la variable aux el valor de puntos de la nueva carta
                        aux = player.getPuntos();
                    }
                } else {
                    
                    /*Este es el caso de que el jugador responda que no quiere una nueva carta, 
                    en cuyo caso la variable pasar pasa a ser true y el bucle no se repite más*/
                    pasar = true;
                }
            } else {
                
                //Si la puntuación del jugador supera los 21 puntos, el jugador pierde y el bucle deja de repetirse
                perder = true;
            }
        } while ((pasar == false) && (perder == false)); /*El bucle se repetirá mientras las variables pasar y perder sean false. En cuanto una de ellas
        contenga el valor true, el bucle se romperá*/
        return puntuacion;
    }

    public static void turnoCpu(Carta cpu, int puntJug, PaqueteDeCartas baraja) {
        
        //Este es el turno de la CPU
        System.out.println("--TURNO DE LA CPU--");
        int puntCpu = cpu.getPuntos(), aux = 0;
        
        /*La cpu pedirá cartas mientras su puntuación sea menor que la del jugador. En el momento en el que su puntuación sea mayor que la del jugador, o mayor que 21
        se dejará de repetir el bucle*/
        while (puntCpu < puntJug && puntCpu < 21) {
            System.out.println("PUNTUACIÓN CPU: " + puntCpu + " | CARTA ACTUAL: " + cpu.getValor() + " de " + cpu.getPalo());
            cpu = baraja.repartirCarta();
            if (cpu.getPalo() == "As") {
                //Si a la CPU le llega un As, en función de su puntuación sumará 1 u 11
                aux = metodoAsCpu(puntCpu);
            } else {
                aux = cpu.getPuntos();
            }
            puntCpu += aux;
        }
        
        //Al terminar el turno de la cpu, se muestran las puntuaciones tanto del jugador como de la cpu
        System.out.println("--PUNTUACIÓN DEL JUGADOR: " + puntJug);
        System.out.println("--PUNTUACION DE LA BANCA: " + puntCpu);
        
        //Se procede a comparar la puntuación del jugador con la de la cpu
        if (puntJug > puntCpu || puntCpu > 21) {
            
            //Si la puntuación del jugador es mayor que la de la cpu, el jugador gana
            System.out.println("--GANA EL JUGADOR--");
        } else {
            if (puntCpu > puntJug && puntCpu <= 21) {
                System.out.println("--GANA LA BANCA--");
            } else {
                if (puntCpu == puntJug) {
                    System.out.println("--EMPATE--");
                }
            }
        }
    }

    public static int metodoAs() {
        //Este método le pregunta al usuario cúanto quiere sumar a su puntuación.
        Scanner entrada = new Scanner(System.in);
        String respuesta;
        do {
            //Este bucle pide al usuario cuánto quiere sumar, y se repetirá a menos que el usuario introduzca un 1 o un 11 como respuesta
            System.out.println("¿Desea sumar 1 u 11?");
            respuesta = entrada.nextLine();
        } while (!respuesta.equals("1") && (!respuesta.equals("11")));
        
        //Si la respuesta es "1", el método devolverá el valor 1. En cualquier otro caso, devolverá 11
        if (respuesta.equals("1")) {
            return 1;
        } else {
            return 11;
        }
    }

    public static int metodoAsCpu(int puntosCpu) {
        
        //En este metodo la cpu pide 1 u 11 en función de su puntuación. Si es igual o menor que 10, sumará 11 para llegar a 21. Sino, sumará 1.
        if (puntosCpu >= 10) {
            return 11;
        } else {
            return 1;
        }
    }

    public static boolean comprobar(int punt) {
        
        //Este método comprueba que el jugador no supere 21 en su puntuación
        if (punt <= 21) {
            return true;
        } else {
            return false;
        }
    }

}
