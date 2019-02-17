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
        System.out.print('\b');
    }

    public static int turnoJugador(Carta player, PaqueteDeCartas baraja) {
        Scanner entrada = new Scanner(System.in);
        boolean pasar = false;
        String respuestaPasar, respuestaSumar = " ";
        int puntuacion = player.getPuntos(), aux = 0;
        System.out.println("--TURNO DEL JUGADOR--");
        System.out.println("PUNTUACION: "+player.getPuntos());
        do {
            System.out.println("PUNTUACIÓN: " + puntuacion + " | CARTA ACTUAL: " + player.getValor() + " de " + player.getPalo());

            if (player.getValor() == "As") {
                aux = metodoAs(puntuacion);
            } else {
                aux = player.getPuntos();
            }
            System.out.println("¿Desea pedir otra carta? S/N");
            respuestaPasar = entrada.nextLine();
            if (respuestaPasar.equals("S") || respuestaPasar.equals("s")) {
                player = baraja.repartirCarta();
                puntuacion+=aux;
            } else {
                pasar = true;
            }
        } while ((pasar == false) && (puntuacion <= 21));
        return puntuacion;
    }
    
    public static void turnoCpu(Carta cpu, int puntJug, PaqueteDeCartas baraja){
        System.out.println("--TURNO DE LA CPU--");
        int puntCpu=cpu.getPuntos(), aux=0;
        while(puntCpu<puntJug&&puntCpu<21){
            System.out.println("PUNTUACIÓN CPU: " + puntCpu + " | CARTA ACTUAL: " + cpu.getValor() + " de " + cpu.getPalo());
            cpu = baraja.repartirCarta();
            if(cpu.getPalo()=="As"){
                aux=metodoAsCpu(puntCpu);
            } else {
                aux=cpu.getPuntos();
            }
            puntCpu+=aux;
        }
        System.out.println("--PUNTUACIÓN DEL JUGADOR: "+puntJug);
        System.out.println("--PUNTUACION DE LA BANCA: "+puntCpu);
        if(puntJug>puntCpu||puntCpu>21){
            System.out.println("--GANA EL JUGADOR--");
        } else {
            if(puntCpu>puntJug&&puntCpu<=21){
                System.out.println("--GANA LA BANCA--");
            } else {
                if(puntCpu==puntJug){
                    System.out.println("--EMPATE--");
                }
            }
        }
    }

    public static int metodoAs(int punt) {
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
    
    public static int metodoAsCpu(int puntosCpu){
        if(puntosCpu<=11){
            return 11;
        } else {
            return 1;
        }
    }

}


