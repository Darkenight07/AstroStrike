package dev.darkenight07.Juego;

import javax.imageio.ImageIO;
import javax.swing.*;
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

        try {
            usuarioAvion = ImageIO.read(getClass().getResource("/dev/darkenight07/img/avion_combate.png"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        Timer timer = new Timer();
        TimerTask  timerTask = new TimerTask() {
            @Override
            public void run() {
                repaint();
                avion.mover();

                try {
                    Thread.sleep(10);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };
        timer.schedule(timerTask, 0, 10);
    }
    @Override
    public void paintComponent(java.awt.Graphics g) {
        g.drawImage(usuarioAvion, avion.getX(), avion.getY(), 80,90, this);
    }

}
