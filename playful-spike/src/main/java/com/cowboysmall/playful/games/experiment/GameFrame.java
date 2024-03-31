package com.cowboysmall.playful.games.experiment;

import javax.swing.JFrame;

public class GameFrame extends JFrame {

    private GamePanel gamePanel;

    public GameFrame(String title, GamePanel gamePanel) {

        super(title);
        this.gamePanel = gamePanel;
    }


    //_________________________________________________________________________

    public void init() {

        setSize(1600, 900);

        addKeyListener(gamePanel);

        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        gamePanel.setPreferredSize(getSize());
        add(gamePanel);
        pack();

        setVisible(true);
        gamePanel.init();
    }
}
