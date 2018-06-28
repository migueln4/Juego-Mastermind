package com.negrillismo;
import java.util.Scanner;
import java.util.ArrayList;

public class Main {

    static Scanner leerConsola = new Scanner(System.in);

    public static void main(String[] args) {

        int posiciones = 4;
        Jugada secreta = new Jugada();
        secreta.jugadaAleatoria(posiciones);

        ArrayList<Jugada> intentos = new ArrayList<>();
        System.out.println("Vamos a jugar con "+posiciones+" posiciones.");

        desarrollo(secreta,intentos);

    }

    private static void desarrollo (Jugada secreta, ArrayList<Jugada> intentos) {
        int posiciones = secreta.getPosiciones().length;
        while(!secreta.getFin()) {
            System.out.println("Este es tu intento número "+(1+intentos.size()));
            Jugada propia = new Jugada(leerIntentos(posiciones));
            System.out.println("Este es tu intento número "+intentos.size());
            System.out.println("Juegas :\t"+propia.toString());
            System.out.println("Tienes :\t"+secreta.compararJugada(propia.getPosiciones()));
        }
    }

    private static int[] leerIntentos(int posiciones) {
        int[] salida = new int[posiciones];
        for (int i=0;i<posiciones;i++) {
            do {
                System.out.println("Opciones válidas: "+imprimirOpciones(posiciones));
                System.out.println("Introduce el número para la posición " + (i + 1));
                salida[i] = leerEntero();
            } while (!comprobarRango(salida[i],posiciones));
        }
        return salida;
    }

    private static boolean comprobarRango(int n, int posiciones) {
        boolean salida = false;
        for (int i = 0; i<posiciones; i++) {
            if (i == n) {
                salida = true;
            }
        }
        return salida;
    }

    private static String imprimirOpciones(int n) {
        String salida = "";
        for (int i=0;i<n;i++) {
            salida += i;
            if (i!=(n-1)) {
                salida += " - ";
            }
        }
        return salida;
    }

    private static int leerEntero() {
        return leerConsola.nextInt();
    }

}
