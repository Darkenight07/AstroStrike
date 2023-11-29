package dev.darkenight07.Avion;

public class BalasAvion {

    public boolean haSidoDisparada = false;
    public int vecesDisparada = 0;
    public int vecesPulsada = 0;
    public int x;
    public int y;
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
}
