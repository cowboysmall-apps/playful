package com.cowboysmall.playful.games;

import javax.swing.JFrame;
import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;

public class Window {

    public static void create(Game game, int width, int height) {

        JFrame window = new JFrame();
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.addKeyListener(game);
        window.addComponentListener(game);

        window.setSize(width, height);
        window.setLocationRelativeTo(null);

        window.add(game.getRenderer());
        window.setVisible(true);
    }

    public static void createFullScreen(Game game) {

        GraphicsEnvironment graphics = GraphicsEnvironment.getLocalGraphicsEnvironment();
        GraphicsDevice device = graphics.getDefaultScreenDevice();

        JFrame window = new JFrame();
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.addKeyListener(game);
        window.addComponentListener(game);

        window.setUndecorated(true);
        window.setResizable(false);

        window.add(game.getRenderer());
        device.setFullScreenWindow(window);
    }
}
