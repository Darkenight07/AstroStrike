package dev.darkenight07.Avion;

import java.awt.event.KeyListener;

public class Avion {
    public int x;
    public int y;
    private final int VELOCIDAD;
    private KeyBoardListener keyBoardListener;


    public Avion(int x, int y, int velocidad) {
        this.x = x;
        this.y = y;
        this.VELOCIDAD = velocidad;
        keyBoardListener = new KeyBoardListener();
    }

    public void mover() {
        if (keyBoardListener.estaSubiendo()) {
            y -= VELOCIDAD;
        }
        if (keyBoardListener.estaBajando()){
            y += VELOCIDAD;
        }
        if (keyBoardListener.estaIzquierda()) {
            x -= VELOCIDAD;
        }
        if (keyBoardListener.estaDerecha()) {
            x += VELOCIDAD;
        }
        if (keyBoardListener.estaDisparando()) {
            disparar();
        }
    }

    public void disparar() {
        System.out.println("Disparando");
    }

    public int getX() {
        return x;
    }
    public int getY() {
        return y;
    }

    public KeyListener getKeyBoardListener() {
        return keyBoardListener;
    }
}
