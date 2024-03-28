package com.cowboysmall.games.proto.proto04;

import javax.swing.JFrame;
import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;

public class Windows {

    public static void createWindow(int width, int height, RendererPanel rendererPanel) {

        JFrame window = new JFrame();
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.addKeyListener(new Input());

        window.setSize(width, height);
        window.setLocationRelativeTo(null);

        rendererPanel.setPreferredSize(window.getSize());
        window.add(rendererPanel);
        window.pack();

        window.setVisible(true);
        rendererPanel.init();
    }

    public static void createFullScreenWindow(RendererPanel rendererPanel) {

        GraphicsEnvironment graphics = GraphicsEnvironment.getLocalGraphicsEnvironment();
        GraphicsDevice device = graphics.getDefaultScreenDevice();

        JFrame window = new JFrame();
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.addKeyListener(new Input());

        window.setUndecorated(true);
        window.setResizable(false);

        rendererPanel.setPreferredSize(window.getSize());
        window.add(rendererPanel);
        window.pack();

        device.setFullScreenWindow(window);
        rendererPanel.init();
    }
}
