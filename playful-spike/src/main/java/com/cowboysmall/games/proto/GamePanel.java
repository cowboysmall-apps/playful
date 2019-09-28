package com.cowboysmall.games.proto;

import com.cowboysmall.playful.graphics.Mesh;
import com.cowboysmall.playful.graphics.Triangle;
import com.cowboysmall.playful.math.Vector4D;
import com.cowboysmall.playful.math.projection.Projection;
import com.cowboysmall.playful.math.rotation.RotationX;
import com.cowboysmall.playful.math.rotation.RotationY;
import com.cowboysmall.playful.math.rotation.RotationZ;
import com.cowboysmall.playful.math.scale.Scale;
import com.cowboysmall.playful.math.translation.Translation;

import javax.swing.JPanel;
import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.image.BufferedImage;
import java.util.HashMap;
import java.util.Map;

public class GamePanel extends JPanel {

    private Projection projection;

    private Mesh updated;
    private Mesh asset;

    private BufferedImage bufferedImage;
    private Graphics2D g2d;

    private double theta;


    //_________________________________________________________________________

    public GamePanel(Projection projection, Mesh asset) {

        this.projection = projection;
        this.asset = asset;

        setBackground(Color.BLACK);
        setForeground(Color.WHITE);

        updated = new Mesh();

        bufferedImage = new BufferedImage(1600, 1200, BufferedImage.TYPE_INT_RGB);
        g2d = bufferedImage.createGraphics();

        Map<RenderingHints.Key, Object> hints = new HashMap<>();
        hints.put(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        hints.put(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);

        g2d.setRenderingHints(new RenderingHints(hints));
        g2d.setStroke(new BasicStroke(2, BasicStroke.CAP_BUTT, BasicStroke.JOIN_BEVEL));
    }


    //_________________________________________________________________________

    public void update(double delta) {

        theta += delta * 0.025;

        updated =
                asset.transform(
                        new RotationX(theta * 0.33d)
                                .preMultiply(new RotationY(theta * 0.66d))
                                .preMultiply(new RotationZ(theta))
                                .preMultiply(new Translation(0.0d, 0.0d, 10.0d))
                                .preMultiply(projection)
                                .preMultiply(new Translation(1.0d, 1.0d, 0.0d))
                                .preMultiply(new Scale(800.0d, 600.0d, 1.0d))
                );
    }

    @Override
    public void paintComponent(Graphics g) {

        super.paintComponent(g);

        g2d.clearRect(0, 0, 1600, 1200);
        for (Triangle triangle : updated.getTriangles())
            drawTriangle(g2d, triangle.getA(), triangle.getB(), triangle.getC());

        g.drawImage(bufferedImage, 0, 0, null);
    }


    //_________________________________________________________________________

    private void drawTriangle(Graphics2D g2d, Vector4D a, Vector4D b, Vector4D c) {

        g2d.drawLine((int) a.getX(), (int) a.getY(), (int) b.getX(), (int) b.getY());
        g2d.drawLine((int) b.getX(), (int) b.getY(), (int) c.getX(), (int) c.getY());
        g2d.drawLine((int) c.getX(), (int) c.getY(), (int) a.getX(), (int) a.getY());
    }
}
