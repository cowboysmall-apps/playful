package com.cowboysmall.games.proto.proto01;

import javax.swing.JFrame;
import java.awt.*;

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
        System.out.println(getSize());
        add(gamePanel);
        pack();

        setVisible(true);
        gamePanel.init();
    }
}
