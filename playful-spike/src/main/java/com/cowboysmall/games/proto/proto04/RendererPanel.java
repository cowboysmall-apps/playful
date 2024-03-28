package com.cowboysmall.games.proto.proto04;

import com.cowboysmall.playful.math.v2.Vector4;

import javax.swing.JPanel;
import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.image.BufferedImage;

public class RendererPanel extends JPanel implements Renderer {

    private final Color foreground;
    private final Color background;

    private BufferedImage bufferedImage;
    private Graphics2D graphics2D;


    //_________________________________________________________________________

    public RendererPanel(Color foreground, Color background) {

        this.foreground = foreground;
        this.background = background;
    }

    public RendererPanel() {

        this(Color.WHITE, Color.BLACK);
    }


    //_________________________________________________________________________

    public final void init() {

        bufferedImage = new BufferedImage(getWidth(), getHeight(), BufferedImage.TYPE_INT_RGB);

        graphics2D = bufferedImage.createGraphics();
        graphics2D.setBackground(background);
        graphics2D.setColor(foreground);
        graphics2D.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        graphics2D.setRenderingHint(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);
        graphics2D.setStroke(new BasicStroke(3, BasicStroke.CAP_BUTT, BasicStroke.JOIN_BEVEL));
    }

    public final void reset() {

        graphics2D.clearRect(0, 0, getWidth(), getHeight());
    }


    @Override
    public final void render() {

        repaint();
    }


    //_________________________________________________________________________

//    @Override
//    public void drawPoint() {
//
//        graphics2D.dra
//    }

    @Override
    public void drawLine(Vector4 a, Vector4 b) {

        graphics2D.drawLine((int) a.getX(), (int) a.getY(), (int) b.getX(), (int) b.getY());
    }

    @Override
    public void drawTriangle(Vector4 a, Vector4 b, Vector4 c) {

        graphics2D.drawLine((int) a.getX(), (int) a.getY(), (int) b.getX(), (int) b.getY());
        graphics2D.drawLine((int) b.getX(), (int) b.getY(), (int) c.getX(), (int) c.getY());
        graphics2D.drawLine((int) c.getX(), (int) c.getY(), (int) a.getX(), (int) a.getY());
    }

    @Override
    public void drawRectangle() {

    }

    @Override
    public void drawCircle() {

    }

    @Override
    public void drawMesh() {

    }


    //_________________________________________________________________________

    @Override
    protected void paintComponent(Graphics g) {

        super.paintComponent(g);
        g.drawImage(bufferedImage, 0, 0, null);
    }
}
