package com.cowboysmall.games.proto;

import com.cowboysmall.playful.graphics.Mesh;
import com.cowboysmall.playful.graphics.Triangle;
import com.cowboysmall.playful.math.Matrix4D;
import com.cowboysmall.playful.math.Vector4D;

import java.awt.BasicStroke;
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
        graphics2D.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        graphics2D.setRenderingHint(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);
        graphics2D.setStroke(new BasicStroke(2, BasicStroke.CAP_BUTT, BasicStroke.JOIN_BEVEL));
    }


    //_________________________________________________________________________

    public boolean add(Mesh mesh) {

        return children.add(mesh);
    }


    //_________________________________________________________________________

    public void transform(Matrix4D matrix4D) {

        transformed =
                children.stream()
                        .map(mesh -> mesh.transform(matrix4D))
                        .collect(Collectors.toList());
    }

    public void draw() {

        graphics2D.clearRect(0, 0, getWidth(), getHeight());
        if (transformed != null)
            transformed.forEach(this::drawMesh);
    }


    //_________________________________________________________________________

    private void drawMesh(Mesh mesh) {

        mesh.getTriangles().forEach(this::drawTriangle);
    }

    private void drawTriangle(Triangle triangle) {

        drawLine(triangle.getA(), triangle.getB(), triangle.getC());
    }

    private void drawLine(Vector4D a, Vector4D b, Vector4D c) {

        graphics2D.drawLine((int) a.getX(), (int) a.getY(), (int) b.getX(), (int) b.getY());
        graphics2D.drawLine((int) b.getX(), (int) b.getY(), (int) c.getX(), (int) c.getY());
        graphics2D.drawLine((int) c.getX(), (int) c.getY(), (int) a.getX(), (int) a.getY());
    }
}
