package dev.darkenight07.Asteroide;

public class Asteroide {

    private int x;
    private int y;
    public final int VELOCIDAD;
    public Asteroide(int x, int y, int velocidad) {
        this.x = x;
        this.y = y;
        this.VELOCIDAD = velocidad;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }
}
