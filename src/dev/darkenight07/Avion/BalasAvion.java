package dev.darkenight07.Avion;

public class BalasAvion {

    private int x;
    private int y;
    public final int VELOCIDAD;

    public BalasAvion(int x, int y, int velocidad) {
        this.x = x;
        this.y = y;
        VELOCIDAD = velocidad;
    }

    public int getY() {
        return y;
    }
    public int getX() {
        return x;
    }

    public void setY(int y) {
        this.y = y;
    }
}
