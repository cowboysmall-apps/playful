package com.cowboysmall.playful.games.breakout.ui;

public abstract class Component {

    protected int x;
    protected int y;


    //_________________________________________________________________________

    public Component(int x, int y) {

        this.x = x;
        this.y = y;
    }


    //_________________________________________________________________________

    public int getX() {

        return x;
    }

    public void setX(int x) {

        this.x = x;
    }

    public int getY() {

        return y;
    }

    public void setY(int y) {

        this.y = y;
    }
}
