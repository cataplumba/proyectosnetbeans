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
            System.out.println("LA PALABRA ERA: "+palabraSecreta);
        } else {
            System.out.println("--HAS GANADO--");
            System.out.println("LA PALABRA ERA: "+palabraSecreta);
        }
    }
    
}
