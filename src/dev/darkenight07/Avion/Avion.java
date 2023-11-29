package dev.darkenight07.Avion;

import dev.darkenight07.Juego.Juego;

import java.awt.event.KeyListener;

public class Avion {
    public int x;
    public int y;
    private final int VELOCIDAD;
    private KeyBoardListener keyBoardListener;
    public BalasAvion balaAvion1;
    public BalasAvion balaAvion2;


    public Avion(int x, int y, int velocidad) {
        this.x = x;
        this.y = y;
        this.VELOCIDAD = velocidad;
        keyBoardListener = new KeyBoardListener();
        balaAvion1 = new BalasAvion(340, 440, 3);
        balaAvion2 = new BalasAvion(416, 440, 3);
    }

    public void mover() {
        if (keyBoardListener.estaSubiendo()) {
            y -= VELOCIDAD;
            if (balaAvion1.haSidoDisparada && balaAvion2.haSidoDisparada) {

            } else {
                balaAvion1.y -= balaAvion1.VELOCIDAD;
                balaAvion2.y -= balaAvion2.VELOCIDAD;
            }
        }
        if (keyBoardListener.estaBajando()){
            y += VELOCIDAD;
            if (balaAvion1.haSidoDisparada && balaAvion2.haSidoDisparada) {

            } else {
                balaAvion1.y += balaAvion1.VELOCIDAD;
                balaAvion2.y += balaAvion2.VELOCIDAD;
            }
        }
        if (keyBoardListener.estaIzquierda()) {
            x -= VELOCIDAD;
            if (balaAvion1.haSidoDisparada && balaAvion2.haSidoDisparada) {

            } else {
                balaAvion1.x -= balaAvion1.VELOCIDAD;
                balaAvion2.x -= balaAvion2.VELOCIDAD;
            }
        }
        if (keyBoardListener.estaDerecha()) {
            x += VELOCIDAD;
            if (balaAvion1.haSidoDisparada && balaAvion2.haSidoDisparada) {

            } else {
                balaAvion1.x += balaAvion1.VELOCIDAD;
                balaAvion2.x += balaAvion2.VELOCIDAD;
            }
        }
    }

    public boolean disparando() {
        if (keyBoardListener.estaDisparando()) {
            return true;
        } else {
            balaAvion1.haSidoDisparada = false;
            balaAvion2.haSidoDisparada = false;
            return false;
        }
    }

    public void disparoBalas() {

        if (balaAvion1.y < -25) {
            setBalasX(1, getX());
            setBalasY(1, getY() + 40);

            setBalasX(2, getX() + 76);
            setBalasY(2, getY() + 40);
            balaAvion1.vecesDisparada = 0;
            balaAvion2.vecesDisparada = 0;
        } else {
            if (balaAvion1.vecesDisparada < 1 && balaAvion2.vecesDisparada < 1) {
                balaAvion2.vecesDisparada = 1;
                balaAvion1.vecesDisparada = 1;
            }
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
                bala.y -= bala.VELOCIDAD;
            }
        }
    }


    public int getX() {
        return x;
    }
    public int getY() {
        return y;
    }

    public int getBalasY(int opcionBala) {
        if (opcionBala == 1) { // 1 = balaAvion1, 2 = balaAvion2
            return balaAvion1.getY();
        } else if  (opcionBala == 2) {
            return balaAvion2.getY();
        } else {
            return 0;
        }
    }
    public int getBalasX(int opcionBala) {
        if (opcionBala == 1) { // 1 = balaAvion1, 2 = balaAvion2
            return balaAvion1.getX();
        } else if  (opcionBala == 2) {
            return balaAvion2.getX();
        } else {
            return 0;
        }
    }


    public void setBalasY(int opcionBala, int y) {
        if (opcionBala == 1) { // 1 = balaAvion1, 2 = balaAvion2
            balaAvion1.y = y;
        } else if  (opcionBala == 2) {
            balaAvion2.y = y;
        }
    }
    public void setBalasX(int opcionBala, int x) {
        if (opcionBala == 1) { // 1 = balaAvion1, 2 = balaAvion2
            balaAvion1.x = x;
        } else if  (opcionBala == 2) {
            balaAvion2.x = x;
        }
    }



    public void setX(int x) {
        this.x = x;
    }
    public void setY(int y) {
        this.y = y;
    }

    public KeyListener getKeyBoardListener() {
        return keyBoardListener;
    }
}
