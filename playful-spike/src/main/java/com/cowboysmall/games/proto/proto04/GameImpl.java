package com.cowboysmall.games.proto.proto04;

import com.cowboysmall.playful.math.v2.Matrix4;
import com.cowboysmall.playful.math.v2.Mesh;
import com.cowboysmall.playful.math.v2.ObjectFileLoader;

import javax.swing.JFrame;
import java.awt.Dimension;

import static com.cowboysmall.playful.math.v2.Operations.multiply;
import static com.cowboysmall.playful.math.v2.Transformations.projection;
import static com.cowboysmall.playful.math.v2.Transformations.rotateX;
import static com.cowboysmall.playful.math.v2.Transformations.rotateY;
import static com.cowboysmall.playful.math.v2.Transformations.rotateZ;
import static com.cowboysmall.playful.math.v2.Transformations.scale;
import static com.cowboysmall.playful.math.v2.Transformations.translate;

public class GameImpl extends Game {

    private State state;

    private Renderer renderer;

    private JFrame window;

    private Mesh cube;

    private double theta;


    public GameImpl(long fps) {
        super(fps);
    }


    //_________________________________________________________________________

    @Override
    protected void init() {

        cube = new ObjectFileLoader()
                .loadFromObjectFile("/playful-spike/src/main/resources/objects/cube1.obj");

        state = new State();
        renderer = new Renderer(state);

        window = Windows.createWindow(1600, 900, renderer, state);
//        Windows.createFullScreenWindow(renderer, state);
    }

    @Override
    protected void update(double delta) {

        Dimension size = state.getWindowSize();

        renderer.reset();

        if (state.isToggleRotation())
            theta += delta * 0.025;

        Matrix4 model =
                multiply(
                        projection(state.getAspectRatio(), 90.0d, 0.01d, 1000.0d),
                        translate(0.0d, 0.0d, 5.0d),
                        rotateX(theta),
                        rotateY(theta * 0.33d),
                        rotateZ(theta * 0.66d)
                );

        Matrix4 screen =
                multiply(
                        scale(size.getWidth() / 2.0d, size.getHeight() / 2.0d, 1.0d),
                        translate(1.0d, 1.0d, 0.0d)
                );

        renderer.drawMesh(cube.transform(multiply(screen, model)));
    }

    @Override
    protected void render() {

        renderer.render();
    }

    public static void main(String[] args) throws Exception {

        Game game = new GameImpl(60);
        game.start();
    }
}
