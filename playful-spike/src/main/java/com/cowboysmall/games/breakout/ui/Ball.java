package com.cowboysmall.games.breakout.ui;

import com.cowboysmall.games.breakout.Drawable;
import com.cowboysmall.games.breakout.Movable;
import com.cowboysmall.games.breakout.Updateable;

import java.awt.Graphics2D;
import java.awt.Rectangle;

public class Ball extends Component implements Drawable, Movable, Updateable {

    private int dx = 5;
    private int dy = 5;


    //_________________________________________________________________________

    public Ball() {

        super(400, 300);
    }


    //_________________________________________________________________________

    public Rectangle getRectangle() {

        return new Rectangle(x, y, 20, 20);
    }

    public void reverseX() {

        dx = -dx;
    }

    public void reverseY() {

        dy = -dy;
    }


    //_________________________________________________________________________

    @Override
    public void draw(Graphics2D graphics2D) {

        graphics2D.fillOval(x, y, 20, 20);
    }

    @Override
    public void move(double delta) {

        x += dx;
        y += dy;
    }

    @Override
    public void update(int value) {

        if (x < 0 || x > 770)
            reverseX();

        if (y < 0 || y > 540)
            reverseY();
    }
}
