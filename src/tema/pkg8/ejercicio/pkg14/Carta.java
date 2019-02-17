package tema.pkg8.ejercicio.pkg14;

/**
 *
 * @author dsimonm01
 */
public class Carta {
    private String valor;
    private String palo;
    private int puntos;
    
    Carta(){
        this.valor="";
        this.palo="";
        this.puntos=0;
    }
    
    Carta(int valor1, int valor2){
        String[][]val={{"♥","♦","♣","♠"},{"As","Dos","Tres","Cuatro","Cinco","Seis","Siete","Ocho","Nueve","Diez","Jack","Queen","King"}};
        this.valor=val[1][valor2];
        this.palo=val[0][valor1];
        if(valor2>=10){
            this.puntos=10;
        } else {
            this.puntos=valor2+1;
        }
    }

    public String getValor() {
        return valor;
    }

    public String getPalo() {
        return palo;
    }

    public int getPuntos() {
        return puntos;
    }

    public void setValor(String valor) {
        this.valor = valor;
    }

    public void setPalo(String palo) {
        this.palo = palo;
    }

    public void setPuntos(int puntos) {
        this.puntos = puntos;
    }

    
}
