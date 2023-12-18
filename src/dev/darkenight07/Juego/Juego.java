package dev.darkenight07.Juego;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Timer;
import java.util.TimerTask;
import dev.darkenight07.Avion.Avion;
import dev.darkenight07.Avion.BalasAvion;
import dev.darkenight07.Asteroide.Asteroide;
import dev.darkenight07.Asteroide.LogicaAsteroide;

public class Juego extends JPanel {
    private BufferedImage usuarioAvion;
    private Avion avion;
    private int dispararCooldown = 0;
    public static BalasAvion[] balasAvion = new BalasAvion[20];
    public static Asteroide[] asteroides = new Asteroide[20];
    private LogicaAsteroide logicaAsteroide = new LogicaAsteroide();


    public Juego() {
        avion = new Avion(340, 400,2);

        setFocusable(true);
        addKeyListener(avion.getKeyBoardListener());

        try {
            usuarioAvion = ImageIO.read(getClass().getResource("/dev/darkenight07/img/avion_combate.png"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        Timer timer = new Timer();
        TimerTask  timerTask = new TimerTask() {
            @Override
            public void run() {
                actualizar();
                logicaAsteroide.crearAsteroide();
                logicaAsteroide.movimientoAsteroide();
                logicaAsteroide.eliminarAsteroide();
                logicaAsteroide.colisiones();

                try {
                    Thread.sleep(10);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                repaint();
            }
        };
        timer.schedule(timerTask, 0, 10);
    }
    @Override
    public void paintComponent(java.awt.Graphics g) {
        super.paintComponent(g);
        g.drawImage(usuarioAvion, avion.getX(), avion.getY(), 80,90, this);
        Graphics2D g2d = (Graphics2D) g;

        for(BalasAvion bala : balasAvion) {
            if(bala != null){
                g2d.setColor(Color.blue);
                g2d.fillRect(bala.getX(), bala.getY(), 5, 25);
            }
        }

        for(Asteroide asteroide : asteroides) {
            if(asteroide != null){
                g2d.setColor(Color.gray);
                g2d.fillRect(asteroide.getX(), asteroide.getY(), 25, 25);
            }
        }
    }
    public void actualizar() {
        avion.mover();

        if(avion.disparando() && puedeDisparar()) {
            avion.dispararBalas();
        }

        eliminarBala();
        dispararCooldown--;
        avion.movimientoBalas();
    }

    public void eliminarBala() {
        for (int balaIndex = 0; balaIndex < balasAvion.length; balaIndex++) {
            if (balasAvion[balaIndex] != null) {
                if (balasAvion[balaIndex].getY() < -25) {
                    balasAvion[balaIndex] = null;
                }
            }
        }
    }

    public boolean puedeDisparar() {
        if(dispararCooldown > 0) {
            dispararCooldown--;
            return false;
        } else {
            dispararCooldown = 50;
            return true;
        }
    }
}
