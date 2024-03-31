package com.cowboysmall.playful.games.experiment;

import com.cowboysmall.playful.graphics.old.Mesh;
import com.cowboysmall.playful.graphics.old.Triangle;
import com.cowboysmall.playful.math.old.Matrix4D;
import com.cowboysmall.playful.math.old.Vector4D;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class GameCanvas extends BufferedImage {

    private final Graphics2D graphics2D;

    private List<Mesh> children = new ArrayList<>();

    private List<Mesh> transformed;


    //_________________________________________________________________________

    public GameCanvas(int width, int height) {

        super(width, height, BufferedImage.TYPE_INT_RGB);

        graphics2D = createGraphics();
        graphics2D.setBackground(Color.BLACK);
        graphics2D.setColor(Color.WHITE);
        graphics2D.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        graphics2D.setRenderingHint(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);
        graphics2D.setStroke(new BasicStroke(1, BasicStroke.CAP_BUTT, BasicStroke.JOIN_BEVEL));
    }


    //_________________________________________________________________________

    public boolean add(Mesh mesh) {

        return children.add(mesh);
    }


    //_________________________________________________________________________

    public void transform(Matrix4D transformation) {

        transformed =
                children.stream()
                        .map(mesh -> mesh.transform(transformation))
                        .collect(Collectors.toList());
    }

    public void draw() {

        if (transformed != null)
            transformed.forEach(this::drawMesh);
    }

    public void reset() {

        graphics2D.clearRect(0, 0, getWidth(), getHeight());
    }


    //_________________________________________________________________________

    private void drawMesh(Mesh mesh) {

        mesh.getTriangles().stream().filter(Triangle::isNegativeNormal).forEach(this::drawTriangle);
    }

    private void drawTriangle(Triangle triangle) {

        drawLine(triangle.getA(), triangle.getB());
        drawLine(triangle.getB(), triangle.getC());
        drawLine(triangle.getC(), triangle.getA());
    }

    private void drawLine(Vector4D a, Vector4D b) {

        graphics2D.drawLine((int) a.getX(), (int) a.getY(), (int) b.getX(), (int) b.getY());
    }
}
