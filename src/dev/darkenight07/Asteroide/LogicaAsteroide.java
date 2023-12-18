package dev.darkenight07.Asteroide;

import dev.darkenight07.Juego.Juego;
import dev.darkenight07.Util;

public class LogicaAsteroide {

    public void crearAsteroide() {
        for (int asteroideIndex = 0; asteroideIndex < Juego.asteroides.length; asteroideIndex++) {
            if (Juego.asteroides[asteroideIndex] == null) {
                Juego.asteroides[asteroideIndex] = new Asteroide(Util.generarNumeroAleatorio(0,800),Util.generarNumeroAleatorio(0,100),1);
                break;
            }
        }
    }

    public void movimientoAsteroide() {
        for (Asteroide asteroide : Juego.asteroides) {
            if (asteroide != null) {
                asteroide.setY(asteroide.getY() + asteroide.VELOCIDAD);
            }
        }
    }

    public void eliminarAsteroide() {
        for (int asteroideIndex = 0; asteroideIndex < Juego.asteroides.length; asteroideIndex++) {
            if (Juego.asteroides[asteroideIndex] != null) {
                if (Juego.asteroides[asteroideIndex].getY() > 600) {
                    Juego.asteroides[asteroideIndex] = null;
                }
            }
        }
    }

    public void colisiones() {
        final int ALTURA_ASTEROIDE = 25;
        final int ANCHURA_ASTEROIDE = 25;

        for (int asteroideIndex = 0; asteroideIndex < Juego.asteroides.length; asteroideIndex++) {
            if (Juego.asteroides[asteroideIndex] != null && Juego.balasAvion[asteroideIndex] != null) {
                int inicioAsteroideX = Juego.asteroides[asteroideIndex].getX();
                int finalAsteroideX = Juego.asteroides[asteroideIndex].getX() + ANCHURA_ASTEROIDE;
                int incioAsteroideY = Juego.asteroides[asteroideIndex].getY();
                int finalAsteroideY = Juego.asteroides[asteroideIndex].getY() + ALTURA_ASTEROIDE;

                if ((incioAsteroideY <= Juego.balasAvion[asteroideIndex].getY() && finalAsteroideY >= Juego.balasAvion[asteroideIndex].getY())) {
                    Juego.asteroides[asteroideIndex] = null;
                    Juego.balasAvion[asteroideIndex] = null;
                }
            }
        }
    }
}
