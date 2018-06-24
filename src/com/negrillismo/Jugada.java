package com.negrillismo;
import java.security.SecureRandom;

public class Jugada {
    private int[] posiciones;

    public Jugada() {
        super();
    }

    public Jugada(int[] datos){
        super();
        posiciones = datos;
    }

    public Jugada(int extension) {
        super();
        posiciones = new int[extension];
    }

    public void setPosiciones(int[] posiciones) {
        this.posiciones = posiciones;
    }

    public int[]getPosiciones(){
        return this.posiciones;
    }

    public String toString() {
        String salida = "";
        for (int i=0;i<this.posiciones.length;i++) {
            salida +=posiciones[i]+"  ";
        }
        return salida;
    }

    public void jugadaAleatoria(int extension) {
        int[] base = new int[extension]; //genero una matriz de la que voy a sacar posiciones aleatorias
        for(int i = 0;i<extension;i++) {
            base[i] = i;
        } //Relleno el array de números de 0 a la extensión que me han pasado.

        SecureRandom sr = new SecureRandom(); //esto es para crear números aleatorios de forma segura, según: https://es.stackoverflow.com/questions/5390/como-generar-n%C3%BAmeros-aleatorios-dentro-de-un-rango-de-valores

        this.posiciones = new int[extension];

        int k = extension;
        for(int i=0;i<this.posiciones.length;i++) {
            int n = sr.nextInt(k);//genero un número aleatorio entre [0,k)
            this.posiciones[i] = base[n];//asigno un número aleatorio a la jugada que estoy creando
            base[n] = base[k-1];//coloco el número que hay al final del array en la posición que acabo de usar
            k--;//el contador también lo reduzco en uno para que no coja la última posición, que puede ser repetida.
        }
    }
}
