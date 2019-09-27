package com.cowboysmall.games.breakout;

import com.cowboysmall.games.breakout.ui.Ball;

public interface Collidable {

    boolean collide(Ball ball);
}
