package ahorcado;

import java.util.Scanner;

/**
 *
 * @author dsimonm01
 */
public class Metodos {

    public static String palabraJuego() {
        String[] palabras = {"VACA", "COCO", "PATA", "ISLA","PARALELEPIPEDO","SATANAS","AVECREM","DIVORCIO","SUICIDIO","ANAL","CACHIBACHE","PERGANTINA","CIMBORRIO","PENCOHUEVO","JORDI","PENDEJO","SUPERCALIFRAGILISTICOESPIALIDOSO","CODIGO","SERPENTINO","VARIABLE","CHORIZO","CANTAMAÑANAS"};
        return palabras[(int) (Math.random() * palabras.length)];
    }

    public static void rellenarPalabra(char[] pal) {
        for (int i = 0; i < pal.length; i++) {
            pal[i] = '_';
        }
    }

    public static void mostrarVacia(char[] pal) {
        for (int i = 0; i < pal.length; i++) {
            System.out.print(pal[i] + " ");
        }
    }

    public static boolean comprobar(char c, char[] pal, String secret) {
        boolean sustituir = false;
        for (int i = 0; i < secret.length(); i++) {
            if (c == secret.charAt(i)) {
                pal[i] = c;
                sustituir = true;
            }
        }
        if (sustituir == false) {
            return false;
        } else {
            return true;
        }
    }

    public static boolean compruebaGanar(char[] pal) {
        int contguiones = 0;
        for (int i = 0; i < pal.length; i++) {
            if (pal[i] == '_') {
                contguiones++;
            }
        }
        if(contguiones>0){
            return false;
        } else {
            return true;
        }
    }

    public static char introducirLetra() {
        Scanner entrada = new Scanner(System.in);
        String c;
        System.out.println("|--INTRODUZCA UNA LETRA--|");
        c = entrada.nextLine();
        return c.charAt(0);
    }

    public static boolean comienzoDelJuego(char[] pal, String palabra) {
        boolean ganar = false, perder = false;
        char car = ' ';
        int cont = 0;
        System.out.println("--COMIENZO DEL JUEGO--");
        while ((perder == false) && (ganar == false)) {
            System.out.println("FALLOS: " + cont);
            dibujarMuneco(cont);
            mostrarVacia(pal);
            car = introducirLetra();
            if (comprobar(car, pal, palabra) == false) {
                cont++;
            }
            if (cont > 5) {
                perder = true;
            }
            if (compruebaGanar(pal) == true) {
                ganar = true;
            }
        }
        return perder;
    }

    public static void dibujarMuneco(int contador) {
        switch (contador) {
            case 0: {
                System.out.println("");
                System.out.println("");
                System.out.println("");
                System.out.println("");
                System.out.println("");
                break;
            }
            case 1: {
                System.out.println("|");
                System.out.println("");
                System.out.println("|");
                System.out.println("");
                System.out.println("|");
                break;
            }
            case 2: {
                System.out.println("   _ _");
                System.out.println("|");
                System.out.println("");
                System.out.println("|");
                System.out.println("|");
                break;
            }
            case 3: {
                System.out.println("   _ _");
                System.out.println("|     |");
                System.out.println("     O");
                System.out.println("|");
                System.out.println("|");
                break;
            }
            case 4: {
                System.out.println("   _ _");
                System.out.println("|     |");
                System.out.println("     O");
                System.out.println("|   /|\\");
                System.out.println("|");
                break;
            }
            case 5: {
                System.out.println("   _ _");
                System.out.println("|     |");
                System.out.println("      O");
                System.out.println("|   /||\\");
                System.out.println("|    /\\");
                break;
            }
        }
    }
}
