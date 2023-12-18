package dev.darkenight07;

import dev.darkenight07.Juego.Juego;
import javax.swing.*;
import java.awt.*;

public class Main {

    public static void main(String[] args) {
        JFrame frame = new JFrame("Astro Strike");
        frame.setResizable(false);
        frame.setSize(800, 600);
        frame.setLayout(new BorderLayout());
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        Juego juego = new Juego();
        frame.add(juego, BorderLayout.CENTER);
        juego.requestFocusInWindow();

        frame.setVisible(true);
    }
}