package com.cowboysmall.games.proto.proto04;

import javax.swing.JFrame;
import java.awt.Dimension;
import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class State implements KeyListener, ComponentListener {

    private Dimension windowSize;

    private boolean toggleRotation;


    //_________________________________________________________________________

    public Dimension getWindowSize() {

        return windowSize;
    }

    public boolean isToggleRotation() {

        return toggleRotation;
    }

    public double getAspectRatio() {

        return windowSize.getWidth() / windowSize.getHeight();
    }


    //_________________________________________________________________________

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {

        if (e.getKeyCode() == KeyEvent.VK_ESCAPE)
            System.exit(0);

        if (e.getKeyCode() == KeyEvent.VK_R)
            toggleRotation = !toggleRotation;
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }


    //_________________________________________________________________________

    @Override
    public void componentResized(ComponentEvent e) {

        JFrame window = (JFrame) e.getSource();
        windowSize = window.getSize();
    }

    @Override
    public void componentMoved(ComponentEvent e) {

    }

    @Override
    public void componentShown(ComponentEvent e) {

    }

    @Override
    public void componentHidden(ComponentEvent e) {

    }
}
