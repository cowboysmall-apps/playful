package com.cowboysmall.games.proto;

import javax.swing.JFrame;

public class GameFrame extends JFrame {

    public GameFrame(String title, GamePanel gamePanel) {

        setTitle(title);
        add(gamePanel);
        setSize(1600, 1200);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
