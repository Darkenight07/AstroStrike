package dev.darkenight07.Avion;

import java.awt.event.KeyEvent;

public class KeyBoardListener implements java.awt.event.KeyListener{
    public boolean arriba;
    public boolean abajo;
    public boolean izquierda;
    public boolean derecha;

    public final int ARRIBA = 38;
    public final int ABAJO = 40;
    public final int IZQUIERDA = 37;
    public final int DERECHA = 39;


    public KeyBoardListener() {
        arriba = false;
        abajo = false;
        izquierda = false;
        derecha = false;
    }

    public boolean estaSubiendo() {
        if (arriba) {
            return true;
        } else {
            return false;
        }
    }
    public boolean estaBajando() {
        if (abajo) {
            return true;
        } else {
            return false;
        }
    }

    public boolean estaIzquierda() {
        if (izquierda) {
            return true;
        } else {
            return false;
        }
    }

    public boolean estaDerecha() {
        if (derecha) {
            return true;
        } else {
            return false;
        }
    }


    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        switch (e.getKeyCode()) {
            case ARRIBA:
                arriba = true;
                break;
            case ABAJO:
                abajo = true;
                break;
            case IZQUIERDA:
                izquierda = true;
                break;
            case DERECHA:
                derecha = true;
                break;
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
}
