package com.cowboysmall.playful.games.breakout;

import com.cowboysmall.playful.games.breakout.ui.Ball;

public interface Collidable {

    boolean collide(Ball ball);
}
