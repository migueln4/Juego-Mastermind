package com.negrillismo;
import java.util.Scanner;

public class Main {

    static Scanner leerConsola = new Scanner(System.in);

    public static void main(String[] args) {
        int[] ejemplo = {0,5,6,8};
        Jugada j = new Jugada(ejemplo);
        Jugada j2 = new Jugada();
        System.out.println(j.toString());
        j2.jugadaAleatoria(4);
        System.out.println(j2.toString());
    }

    private static int leerEntero() {
        return leerConsola.nextInt();
    }
}
