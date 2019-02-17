package tema.pkg8.ejercicio.pkg14;

/**
 *
 * @author dsimonm01
 */
public class PaqueteDeCartas {
    private Carta[]baraja=new Carta[52];
    private static int cartaActual=0;
    
    PaqueteDeCartas(){
        int cartaNum=0;
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 13; j++) {
                baraja[cartaNum]=new Carta(i,j);
                cartaNum++;
            }
        }
    }
    
    public int generarAleatorio(){
        int num=(int)(Math.random()*51);
        return num;
    }
    
    public void barajar(){
        Carta aux,carta2;
        int num;
        for (int i = 0; i < baraja.length-1; i++) {
            num = generarAleatorio();
            carta2=baraja[num];
            aux=carta2;
            carta2=baraja[i];
            baraja[i]=aux;
        }
    }
    
    public void setCartaActual(int carta){
        this.cartaActual=carta;
    }
    
    public int getCartaActual(){
        return this.cartaActual;
    }
    
    public static int incrementarCartaActual;
    
    public Carta repartirCarta(){
        cartaActual++;
        return baraja[cartaActual-1];
    }
}
