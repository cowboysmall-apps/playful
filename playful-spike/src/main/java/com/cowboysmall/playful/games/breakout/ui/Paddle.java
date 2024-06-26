package com.cowboysmall.playful.games.breakout.ui;

import com.cowboysmall.playful.games.breakout.Collidable;
import com.cowboysmall.playful.games.breakout.Drawable;
import com.cowboysmall.playful.games.breakout.Movable;
import com.cowboysmall.playful.games.breakout.Updateable;

import java.awt.Graphics2D;
import java.awt.Rectangle;

public class Paddle extends Component implements Drawable, Movable, Updateable, Collidable {

    private int dx = 0;


    //_________________________________________________________________________

    public Paddle() {

        super(395, 470);
    }


    //_________________________________________________________________________

    public Rectangle getRectangle() {

        return new Rectangle(x, y, 100, 25);
    }


    //_________________________________________________________________________

    @Override
    public void draw(Graphics2D graphics2D) {

        graphics2D.fillRect(x, y, 100, 25);
    }

    @Override
    public void move(double delta) {

        x += dx;

        if (x < 0)
            x = 0;
        if (x > 690)
            x = 690;
    }

    @Override
    public void update(int value) {

        dx = value;
    }

    @Override
    public boolean collide(Ball ball) {

        return getRectangle().intersects(ball.getRectangle());
    }
}
