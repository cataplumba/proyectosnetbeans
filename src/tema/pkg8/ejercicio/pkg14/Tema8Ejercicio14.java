package tema.pkg8.ejercicio.pkg14;
import java.util.Scanner;
/**
 *
 * @author dsimonm01
 */
public class Tema8Ejercicio14 {

    public static void main(String[] args) {
        int puntosJugador;
        PaqueteDeCartas deck=new PaqueteDeCartas();
        deck.barajar();
        Carta jugador=deck.repartirCarta();
        Carta cpu=deck.repartirCarta();
        Juego.mostrarInicio(jugador, cpu);
        puntosJugador=Juego.turnoJugador(jugador, deck);
        System.out.println("LA PUNTUACION DEL JUGADOR ES: "+puntosJugador);
        if(puntosJugador>21){
            System.out.println("--GANA LA BANCA--");
        } else {
            Juego.turnoCpu(cpu, puntosJugador, deck);
        }
    }
    
}
