package com.cowboysmall.playful.games.discovery;

import com.cowboysmall.playful.games.Renderable;
import com.cowboysmall.playful.graphics.Mesh;
import com.cowboysmall.playful.graphics.Triangle;
import com.cowboysmall.playful.math.Matrix4D;
import com.cowboysmall.playful.math.Vector4D;

import java.util.Arrays;

public class Block {

    private Mesh mesh;

    public Block(Mesh mesh) {

        this.mesh = mesh;
    }

    public Block() {

        mesh = new Mesh(Arrays.asList(
                new Triangle(new Vector4D(-0.5, -0.5, -0.5), new Vector4D(-0.5, 0.5, -0.5), new Vector4D(0.5, 0.5, -0.5)),
                new Triangle(new Vector4D(-0.5, -0.5, -0.5), new Vector4D(0.5, 0.5, -0.5), new Vector4D(0.5, -0.5, -0.5)),

                new Triangle(new Vector4D(0.5, -0.5, -0.5), new Vector4D(0.5, 0.5, -0.5), new Vector4D(0.5, 0.5, 0.5)),
                new Triangle(new Vector4D(0.5, -0.5, -0.5), new Vector4D(0.5, 0.5, 0.5), new Vector4D(0.5, -0.5, 0.5)),

                new Triangle(new Vector4D(0.5, -0.5, 0.5d), new Vector4D(0.5, 0.5, 0.5), new Vector4D(-0.5, 0.5, 0.5)),
                new Triangle(new Vector4D(0.5, -0.5, 0.5d), new Vector4D(-0.5, 0.5, 0.5), new Vector4D(-0.5, -0.5, 0.5)),

                new Triangle(new Vector4D(-0.5, -0.5, 0.5d), new Vector4D(-0.5, 0.5, 0.5), new Vector4D(-0.5, 0.5, -0.5)),
                new Triangle(new Vector4D(-0.5, -0.5, 0.5d), new Vector4D(-0.5, 0.5, -0.5), new Vector4D(-0.5, -0.5, -0.5)),

                new Triangle(new Vector4D(-0.5, 0.5, -0.5d), new Vector4D(-0.5, 0.5, 0.5), new Vector4D(0.5, 0.5, 0.5)),
                new Triangle(new Vector4D(-0.5, 0.5, -0.5d), new Vector4D(0.5, 0.5, 0.5), new Vector4D(0.5, 0.5, -0.5)),

                new Triangle(new Vector4D(0.5, -0.5, 0.5d), new Vector4D(-0.5, -0.5, 0.5), new Vector4D(-0.5, -0.5, -0.5)),
                new Triangle(new Vector4D(0.5, -0.5, 0.5d), new Vector4D(-0.5, -0.5, -0.5), new Vector4D(0.5, -0.5, -0.5))
        ));
    }

    public Block transform(Matrix4D transform) {

        return new Block(mesh.transform(transform));
    }

    public void drawBlock(Renderable renderable) {

        renderable.drawMesh(mesh);
    }
}
