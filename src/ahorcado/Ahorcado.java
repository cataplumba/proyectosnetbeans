package ahorcado;

/**
 *
 * @author dsimonm01
 */
public class Ahorcado {
    
    public static void main(String[] args) {
        String palabraSecreta=Metodos.palabraJuego();
        char[] palabraJuego=new char[palabraSecreta.length()];
        Metodos.rellenarPalabra(palabraJuego);
        if(Metodos.comienzoDelJuego(palabraJuego, palabraSecreta)==true){
            System.out.println("--HAS PERDIDO--");
        } else {
            System.out.println("--HAS GANADO--");
        }
    }
    
}
