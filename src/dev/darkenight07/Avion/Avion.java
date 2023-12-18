package dev.darkenight07.Avion;

import dev.darkenight07.Juego.Juego;

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
    }

    public boolean disparando() {
        if (keyBoardListener.estaDisparando()) {
            return true;
        } else {
            return false;
        }
    }

    public void dispararBalas(){
        for(int balaIndex = 0; balaIndex < Juego.balasAvion.length; balaIndex++) {
            if (Juego.balasAvion[balaIndex] == null) {
                Juego.balasAvion[balaIndex] = new BalasAvion(getX(), getY(), 15);
                Juego.balasAvion[balaIndex + 1] = new BalasAvion(getX() + 75, getY(), 15);
                break;
            }
        }
    }

    public void movimientoBalas() {
        for(BalasAvion bala : Juego.balasAvion) {
            if(bala != null){
                bala.setY(bala.getY() - bala.VELOCIDAD);
            }
        }
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
