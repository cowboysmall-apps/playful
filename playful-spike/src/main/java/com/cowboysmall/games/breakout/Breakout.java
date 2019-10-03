package com.cowboysmall.games.breakout;

public class Breakout {

    public static void main(String... args) {

        BreakoutFrame breakoutFrame = new BreakoutFrame("Breakout", new BreakoutPanel());
        breakoutFrame.setVisible(true);
    }
}
