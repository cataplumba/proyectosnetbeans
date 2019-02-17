package tema.pkg8.ejercicio.pkg14;
import java.util.Scanner;

/**
 *
 * @author dsimonm01
 */
public class Juego {

    public static void mostrarInicio(Carta carta1, Carta carta2) {
        System.out.println("Carta del jugador: " + carta1.getValor() + "" + carta1.getPalo());
        System.out.println("Carta de la cpu: " + carta2.getValor() + "" + carta2.getPalo());
        System.out.println(" ");
    }

    public static int turnoJugador(Carta player, PaqueteDeCartas baraja) {
        Scanner entrada = new Scanner(System.in);
        boolean pasar = false, perder = false;
        String respuesta;
        int puntuacion = 0, aux = 0;
        if (player.getValor() == "As") {
            System.out.println("Has robado un As. ¿Deseas sumar 1 u 11 a tu puntuación?");
            aux = metodoAs();
        } else {
            aux = player.getPuntos();
        }
        System.out.println("--TURNO DEL JUGADOR--");
        do {
            puntuacion += aux;
            System.out.println("PUNTUACIÓN: " + puntuacion + " | CARTA ACTUAL: " + player.getValor() + " de " + player.getPalo());
            if (comprobar(puntuacion) == true) {
                System.out.println("¿Desea pedir otra carta?");
                respuesta = entrada.nextLine();
                if (respuesta.equals("S") || respuesta.equals("s")) {
                    player = baraja.repartirCarta();
                    if (player.getValor() == "As") {
                        System.out.println("Has robado un As. ¿Deseas sumar 1 u 11 a tu puntuación?");
                        aux = metodoAs();
                    } else {
                        aux = player.getPuntos();
                    }
                } else {
                    pasar = true;
                }
            } else {
                perder = true;
            }
        } while ((pasar == false) && (perder == false));
        return puntuacion;
    }

    public static void turnoCpu(Carta cpu, int puntJug, PaqueteDeCartas baraja) {
        System.out.println("--TURNO DE LA CPU--");
        int puntCpu = cpu.getPuntos(), aux = 0;
        while (puntCpu < puntJug && puntCpu < 21) {
            System.out.println("PUNTUACIÓN CPU: " + puntCpu + " | CARTA ACTUAL: " + cpu.getValor() + " de " + cpu.getPalo());
            cpu = baraja.repartirCarta();
            if (cpu.getPalo() == "As") {
                aux = metodoAsCpu(puntCpu);
            } else {
                aux = cpu.getPuntos();
            }
            puntCpu += aux;
        }

        System.out.println("--PUNTUACIÓN DEL JUGADOR: " + puntJug);
        System.out.println("--PUNTUACION DE LA BANCA: " + puntCpu);
        if (puntJug > puntCpu || puntCpu > 21) {
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
        Scanner entrada = new Scanner(System.in);
        String respuesta;
        do {
            System.out.println("¿Desea sumar 1 u 11?");
            respuesta = entrada.nextLine();
        } while (!respuesta.equals("1") && (!respuesta.equals("11")));
        if (respuesta.equals("1")) {
            return 1;
        } else {
            return 11;
        }
    }

    public static int metodoAsCpu(int puntosCpu) {
        if (puntosCpu <= 11) {
            return 11;
        } else {
            return 1;
        }
    }

    public static boolean comprobar(int punt) {
        if (punt <= 21) {
            return true;
        } else {
            return false;
        }
    }

}

/*if (player.getValor() == "As") {
 aux = metodoAs(puntuacion);
 } else {
 aux = player.getPuntos();
 }
 if (puntuacion <= 21) {
 System.out.println("¿Desea pedir otra carta? S/N");
 respuestaPasar = entrada.nextLine();
 if (respuestaPasar.equals("S") || respuestaPasar.equals("s")) {
 player = baraja.repartirCarta();
 puntuacion += aux;
 } else {
 pasar = true;
 }
 } else {
 pasar=true;
 }*/
