package com.cowboysmall.games.proto.proto02;

import javax.swing.JFrame;
import java.awt.HeadlessException;

public class GameFrame extends JFrame {

    public GameFrame(String title) throws HeadlessException {

        super(title);

        setSize(1600, 1200);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        setVisible(true);
    }
}
