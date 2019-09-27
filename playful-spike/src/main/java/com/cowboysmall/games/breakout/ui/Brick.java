package com.cowboysmall.games.breakout.ui;

import com.cowboysmall.games.breakout.Collidable;
import com.cowboysmall.games.breakout.Drawable;
import com.cowboysmall.games.breakout.Updateable;

import java.awt.Graphics2D;
import java.awt.Rectangle;

public class Brick extends Component implements Drawable, Updateable, Collidable {

    private boolean active = true;

    //_________________________________________________________________________

    public Brick(int x, int y) {

        super(x, y);
    }


    //_________________________________________________________________________

    public Rectangle getRectangle() {

        return new Rectangle(x, y, 80, 20);
    }


    //_________________________________________________________________________

    @Override
    public void draw(Graphics2D graphics2D) {

        if (active)
            graphics2D.fillRect(x, y, 80, 20);
    }

    @Override
    public void update(int value) {

        active = false;
    }

    @Override
    public boolean collide(Ball ball) {

        return active && getRectangle().intersects(ball.getRectangle());
    }
}
