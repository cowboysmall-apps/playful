package com.cowboysmall.games.breakout.ui;

import com.cowboysmall.games.breakout.Collidable;
import com.cowboysmall.games.breakout.Drawable;

import java.awt.Graphics2D;

public class Wall implements Drawable, Collidable {

    private Brick[][] bricks = new Brick[8][16];


    //_________________________________________________________________________

    public Wall() {

        for (int i = 0; i < 8; i++)
            for (int j = 0; j < 16; j++)
                bricks[i][j] = new Brick(20 + (j * 98), 120 + (i * 30));
    }


    //_________________________________________________________________________

    @Override
    public void draw(Graphics2D graphics2D) {

        for (int i = 0; i < 8; i++)
            for (int j = 0; j < 16; j++)
                bricks[i][j].draw(graphics2D);
    }

    @Override
    public boolean collide(Ball ball) {

        for (int i = 0; i < 8; i++) {

            for (int j = 0; j < 16; j++) {

                if (bricks[i][j].collide(ball)) {

                    bricks[i][j].update(0);
                    return true;
                }
            }
        }
        return false;
    }
}
