package com.cowboysmall.games.breakout.ui;

import com.cowboysmall.games.breakout.Drawable;

import java.awt.BasicStroke;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.List;

public class Canvas extends BufferedImage {

    private final Graphics2D graphics2D;

    private List<Drawable> children = new ArrayList<>();


    //_________________________________________________________________________

    public Canvas(int width, int height) {

        super(width, height, BufferedImage.TYPE_INT_RGB);

        graphics2D = createGraphics();
        graphics2D.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        graphics2D.setRenderingHint(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);
        graphics2D.setStroke(new BasicStroke(2, BasicStroke.CAP_BUTT, BasicStroke.JOIN_BEVEL));
    }


    //_________________________________________________________________________

    public boolean add(Drawable drawable) {

        return children.add(drawable);
    }


    //_________________________________________________________________________

    public void draw() {

        graphics2D.clearRect(0, 0, getWidth(), getHeight());
        children.forEach(child -> child.draw(graphics2D));
    }
}
