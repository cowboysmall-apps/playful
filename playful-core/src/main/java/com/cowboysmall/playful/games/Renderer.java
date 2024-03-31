package com.cowboysmall.playful.games;

import com.cowboysmall.playful.graphics.Mesh;
import com.cowboysmall.playful.graphics.Triangle;
import com.cowboysmall.playful.math.Vector4D;

import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.image.BufferedImage;

public class Renderer extends JPanel implements Renderable {

    private BufferedImage bufferedImage;

    private Graphics2D graphics2D;


    private final Color foreground;

    private final Color background;


    //_________________________________________________________________________

    public Renderer(Color foreground, Color background) {

        this.foreground = foreground;
        this.background = background;
    }

    public Renderer() {

        this(Color.WHITE, Color.BLACK);
    }


    //_________________________________________________________________________

    @Override
    public final void init() {

        bufferedImage = new BufferedImage(getWidth(), getHeight(), BufferedImage.TYPE_INT_RGB);

        graphics2D = bufferedImage.createGraphics();
        graphics2D.setBackground(background);
        graphics2D.setColor(foreground);
        graphics2D.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        graphics2D.setRenderingHint(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);
        graphics2D.setStroke(new BasicStroke(2, BasicStroke.CAP_BUTT, BasicStroke.JOIN_BEVEL));
    }

    @Override
    public final void clear() {

        graphics2D.clearRect(0, 0, getWidth(), getHeight());
    }

    @Override
    public final void render() {

        SwingUtilities.invokeLater(this::repaint);
    }


    //_________________________________________________________________________

    @Override
    protected void paintComponent(Graphics g) {

        super.paintComponent(g);
        g.drawImage(bufferedImage, 0, 0, null);
    }


    //_________________________________________________________________________

    public double getAspectRatio() {

        Dimension dimension = getSize();
        return dimension.getWidth() / dimension.getHeight();
    }


    //_________________________________________________________________________

    @Override
    public void drawLine(Vector4D a, Vector4D b) {

        graphics2D.drawLine((int) a.getX(), (int) a.getY(), (int) b.getX(), (int) b.getY());
    }

    @Override
    public void drawTriangle(Triangle triangle) {

        drawLine(triangle.getA(), triangle.getB());
        drawLine(triangle.getB(), triangle.getC());
        drawLine(triangle.getC(), triangle.getA());
    }

    @Override
    public void drawMesh(Mesh mesh) {

        mesh.getTriangles().stream()
                .filter(Triangle::isNegativeNormal)
                .forEach(this::drawTriangle);
    }

    @Override
    public void drawRectangle(Vector4D a, Vector4D b, Vector4D c, Vector4D d) {

        drawLine(a, b);
        drawLine(b, c);
        drawLine(c, d);
        drawLine(d, a);
    }

    @Override
    public void drawCircle() {

    }
}
