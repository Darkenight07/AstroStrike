package dev.darkenight07.Avion;

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
        balaAvion1 = new BalasAvion(340, 440, 2);
        balaAvion2 = new BalasAvion(416, 440, 2);
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
            balaAvion1.haSidoDisparada = true;
            balaAvion2.haSidoDisparada = true;
            return true;
        } else {
            return false;
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

    public void disparoBalas() {
        if (balaAvion1.y < -10) {
            balaAvion1.y = 440;
            balaAvion2.y = 440;
            balaAvion1.x = 340;
            balaAvion2.x = 416;
            balaAvion1.haSidoDisparada = false;
        } else {
            balaAvion1.y -= balaAvion1.VELOCIDAD;
            balaAvion2.y -= balaAvion2.VELOCIDAD;
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
