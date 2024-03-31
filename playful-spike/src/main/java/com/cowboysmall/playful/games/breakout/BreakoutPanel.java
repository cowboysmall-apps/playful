package com.cowboysmall.playful.games.breakout;

import com.cowboysmall.playful.games.breakout.ui.Ball;
import com.cowboysmall.playful.games.breakout.ui.Canvas;
import com.cowboysmall.playful.games.breakout.ui.Paddle;
import com.cowboysmall.playful.games.breakout.ui.Wall;

import javax.swing.JPanel;
import javax.swing.Timer;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class BreakoutPanel extends JPanel implements KeyListener, MouseListener, ActionListener {

    private Canvas canvas;

    private Paddle paddle;
    private Ball ball;
    private Wall wall;


    //_________________________________________________________________________

    public BreakoutPanel() {

        setBackground(Color.BLACK);
        setForeground(Color.WHITE);

        paddle = new Paddle();
        ball = new Ball();
        wall = new Wall();

        canvas = new Canvas(790, 570);
        canvas.add(paddle);
        canvas.add(ball);
        canvas.add(wall);


        Timer timer = new Timer(1000 / 60, this);
        timer.start();
    }


    //_________________________________________________________________________

    public void update() {

        ball.update(0);
    }

    public void move() {

        ball.move(0);
        paddle.move(0);
    }

    public void collisions() {

        if (paddle.collide(ball))
            ball.reverseY();

        if (wall.collide(ball))
            ball.reverseY();
    }


    //_________________________________________________________________________

    @Override
    protected void paintComponent(Graphics g) {

        super.paintComponent(g);

        canvas.draw();
        g.drawImage(canvas, 0, 0, null);
    }


    //_________________________________________________________________________

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {

        if (e.getKeyCode() == KeyEvent.VK_LEFT)
            paddle.update(-5);

        if (e.getKeyCode() == KeyEvent.VK_RIGHT)
            paddle.update(5);
    }

    @Override
    public void keyReleased(KeyEvent e) {

        paddle.update(0);
    }


    //_________________________________________________________________________

    @Override
    public void mouseClicked(MouseEvent e) {

    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }


    //_________________________________________________________________________

    @Override
    public void actionPerformed(ActionEvent e) {

        update();
        move();
        collisions();
        repaint();
    }
}
