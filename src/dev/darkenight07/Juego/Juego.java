package dev.darkenight07.Juego;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Timer;
import java.util.TimerTask;
import dev.darkenight07.Avion.Avion;

public class Juego extends JPanel {
    private BufferedImage usuarioAvion;
    private Avion avion;

    public Juego(JFrame frame) {
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
                System.out.println("Bala 1: " + avion.getBalasX(1) + " " + avion.getBalasY(1) + " 2: " + avion.getBalasX(2) + " " + avion.getBalasY(2));

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
        g2d.setColor(Color.blue);
        g2d.fillRect(avion.getBalasX(1), avion.getBalasY(1), 5, 25);
        g2d.fillRect(avion.getBalasX(2), avion.getBalasY(2), 5, 25);
    }
    public void actualizar() {
        avion.mover();

        if (avion.disparando()) {
            avion.disparoBalas();
        }
    }
}
