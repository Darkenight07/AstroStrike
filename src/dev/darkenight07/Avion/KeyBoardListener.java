package dev.darkenight07.Avion;

import java.awt.event.KeyEvent;

public class KeyBoardListener implements java.awt.event.KeyListener {
    private boolean arriba;
    private boolean abajo;
    private boolean izquierda;
    private boolean derecha;
    private boolean disparar;

    private final int ARRIBA = 38;
    private final int ABAJO = 40;
    private final int IZQUIERDA = 37;
    private final int DERECHA = 39;
    private final int ESPACIO = 32;


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

    public boolean estaDisparando() {
        if (disparar) {
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
            case ESPACIO:
                disparar = true;
                break;
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        switch (e.getKeyCode()) {
            case ARRIBA:
                arriba = false;
                break;
            case ABAJO:
                abajo = false;
                break;
            case IZQUIERDA:
                izquierda = false;
                break;
            case DERECHA:
                derecha = false;
                break;
            case ESPACIO:
                disparar = false;
                break;
        }
    }
}
