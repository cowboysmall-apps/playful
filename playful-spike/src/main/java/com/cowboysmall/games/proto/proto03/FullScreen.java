package com.cowboysmall.games.proto.proto03;


import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;

public class FullScreen {

    public static void main(String[] args) {

        GraphicsEnvironment graphics = GraphicsEnvironment.getLocalGraphicsEnvironment();
        GraphicsDevice device = graphics.getDefaultScreenDevice();


        JLabel label = new JLabel("fullscreen!", JLabel.CENTER);

        JPanel panel = new JPanel(new BorderLayout());
        panel.setBackground(Color.BLACK);
        panel.add(label);

        JFrame frame = new JFrame("fullscreen");
        frame.add(panel);
        frame.setUndecorated(true);
        frame.setResizable(false);

        device.setFullScreenWindow(frame);

        System.out.println(label.getSize());
        System.out.println(panel.getSize());
        System.out.println(frame.getSize());
    }
}
