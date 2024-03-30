package com.cowboysmall.games.proto.proto04;

import javax.swing.JFrame;
import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;

public class Windows {

    public static JFrame createWindow(int width, int height, Renderer renderer, State state) {

        JFrame window = new JFrame();
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.addKeyListener(state);
        window.addComponentListener(state);

        window.setSize(width, height);
        window.setLocationRelativeTo(null);

        renderer.setPreferredSize(window.getSize());
        window.add(renderer);
        window.pack();

        window.setVisible(true);
        renderer.init();

        return window;
    }

    public static JFrame createFullScreenWindow(Renderer renderer, State state) {

        GraphicsEnvironment graphics = GraphicsEnvironment.getLocalGraphicsEnvironment();
        GraphicsDevice device = graphics.getDefaultScreenDevice();

        JFrame window = new JFrame();
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.addKeyListener(state);
        window.addComponentListener(state);

        window.setUndecorated(true);
        window.setResizable(false);

        renderer.setPreferredSize(window.getSize());
        window.add(renderer);
        window.pack();

        device.setFullScreenWindow(window);
        renderer.init();

        return window;
    }
}
