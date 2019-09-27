package com.cowboysmall.games.breakout;

import javax.swing.JFrame;

public class BreakoutFrame extends JFrame {

    public BreakoutFrame(String title, BreakoutPanel breakoutPanel) {

        super(title);

        add(breakoutPanel);
        pack();

        addKeyListener(breakoutPanel);
        addMouseListener(breakoutPanel);

        setSize(1600, 1200);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
