package com.cowboysmall.playful.games.discovery;

import com.cowboysmall.playful.games.Game;
import com.cowboysmall.playful.games.Window;
import com.cowboysmall.playful.math.Matrix4D;
import com.cowboysmall.playful.graphics.Mesh;
import com.cowboysmall.playful.graphics.ObjectFileLoader;

import java.awt.Dimension;
import java.awt.event.KeyEvent;

import static com.cowboysmall.playful.math.Operations.multiply;
import static com.cowboysmall.playful.math.Transformations.projection;
import static com.cowboysmall.playful.math.Transformations.rotateX;
import static com.cowboysmall.playful.math.Transformations.rotateY;
import static com.cowboysmall.playful.math.Transformations.rotateZ;
import static com.cowboysmall.playful.math.Transformations.scale;
import static com.cowboysmall.playful.math.Transformations.translate;
import static java.lang.Math.sin;

public class Discovery extends Game {

    private Mesh cube;


    private boolean toggleRotation;
    private double theta;


    //_________________________________________________________________________

    public Discovery(long fps) {

        super(fps);
    }


    //_________________________________________________________________________

    @Override
    protected void init() {

        cube = new ObjectFileLoader()
                .loadFromObjectFile("/playful-spike/src/main/resources/objects/cube1.obj");

        Window.create(this, 1600, 900);
        // Windows.createFullScreen(this);
    }

    @Override
    protected void update(double delta) {

        Dimension size = getRenderer().getSize();

        getRenderer().clear();

        if (toggleRotation)
            theta += delta * 0.025;

        Matrix4D model =
                multiply(
                        projection(getRenderer().getAspectRatio(), 90.0d, 0.01d, 1000.0d),
                        translate(0.0d, sin(theta), 5.0d),
                        rotateZ(theta * 0.66d),
                        rotateY(theta * 0.33d),
                        rotateX(theta)
                );

        Matrix4D screen1 =
                multiply(
                        scale(size.getWidth() / 2.0d, size.getHeight() / 2.0d, 1.0d),
                        translate(0.5d, 1.0d, 0.0d)
                );

        Matrix4D screen2 =
                multiply(
                        scale(size.getWidth() / 2.0d, size.getHeight() / 2.0d, 1.0d),
                        translate(1.0d, 1.0d, 2.0d)
                );

        Matrix4D screen3 =
                multiply(
                        scale(size.getWidth() / 2.0d, size.getHeight() / 2.0d, 1.0d),
                        translate(1.5d, 1.0d, 0.0d)
                );

        getRenderer().drawMesh(cube.transform(multiply(screen1, model)));
        getRenderer().drawMesh(cube.transform(multiply(screen2, model)));
        getRenderer().drawMesh(cube.transform(multiply(screen3, model)));
    }


    //_________________________________________________________________________

    @Override
    public void keyPressed(KeyEvent e) {

        if (e.getKeyCode() == KeyEvent.VK_ESCAPE)
            System.exit(0);

        if (e.getKeyCode() == KeyEvent.VK_R)
            toggleRotation = !toggleRotation;
    }


    //_________________________________________________________________________

    public static void main(String[] args) throws Exception {

        Game game = new Discovery(60);
        game.start();
    }
}
