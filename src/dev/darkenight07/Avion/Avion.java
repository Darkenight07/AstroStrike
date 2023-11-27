package dev.darkenight07.Avion;

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
            System.out.println("Subiendo");
        }
    }

    public void disparar() {

    }

    public int getX() {
        return x;
    }
    public int getY() {
        return y;
    }
}
