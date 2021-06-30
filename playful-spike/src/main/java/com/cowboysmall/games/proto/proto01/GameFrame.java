package com.cowboysmall.games.proto.proto01;

import javax.swing.JFrame;

public class GameFrame extends JFrame {

    private GamePanel gamePanel;

    public GameFrame(String title, GamePanel gamePanel) {

        super(title);
        this.gamePanel = gamePanel;
    }


    //_________________________________________________________________________

    public void init() {

        add(gamePanel);
        addKeyListener(gamePanel);

        setSize(800, 600);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        setVisible(true);
        gamePanel.init();
    }
}
