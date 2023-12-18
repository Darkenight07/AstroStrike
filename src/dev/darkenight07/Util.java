package dev.darkenight07;

public class Util {
    public static int generarNumeroAleatorio(int min, int max) {
        return (int) Math.floor(Math.random() * (max - min + 1) + min);
    }
}
