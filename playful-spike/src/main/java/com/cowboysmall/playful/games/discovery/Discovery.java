package com.cowboysmall.playful.games.discovery;

import com.cowboysmall.playful.games.Game;
import com.cowboysmall.playful.games.Window;
import com.cowboysmall.playful.math.Matrix4D;

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

    private Block block = new Block();

    private boolean toggleRotation = true;

    private double theta;


    //_________________________________________________________________________

    public Discovery(long fps) {

        super(fps);
    }


    //_________________________________________________________________________

    @Override
    protected void init() {

        block = new Block();

        Window.create(this, 1600, 900);
        // Windows.createFullScreen(this);
    }

    @Override
    protected void update(double delta) {

        Dimension size = getRenderer().getSize();

        getRenderer().clear();

        if (toggleRotation)
            theta += delta * 0.025;


        Matrix4D projection = projection(getRenderer().getAspectRatio(), 90.0d, 0.01d, 1000.0d);


        Matrix4D model1 =
                multiply(
                        translate(0.0d, sin(theta), 5.0d),
                        rotateZ(theta * 0.66d),
                        rotateY(theta * 0.33d),
                        rotateX(theta)
                );

        Matrix4D model2 =
                multiply(
                        translate(0.0d, sin(theta + 1), 5.0d),
                        rotateZ(theta * 0.66d),
                        rotateY(theta * 0.33d),
                        rotateX(theta)
                );

        Matrix4D model3 =
                multiply(
                        translate(0.0d, sin(theta + 2), 5.0d),
                        rotateZ(theta * 0.66d),
                        rotateY(theta * 0.33d),
                        rotateX(theta)
                );


        Matrix4D screen1 =
                multiply(
                        translate(size.getWidth() / 4.0d, size.getHeight() / 2.0d, 5.0d),
                        scale(size.getWidth() / 2.0d, size.getHeight() / 2.0d, 1.0d)
                );

        Matrix4D screen2 =
                multiply(
                        translate(size.getWidth() / 2.0d, size.getHeight() / 2.0d, 5.0d),
                        scale(size.getWidth() / 2.0d, size.getHeight() / 2.0d, 1.0d)
                );

        Matrix4D screen3 =
                multiply(
                        translate(3 * size.getWidth() / 4.0d, size.getHeight() / 2.0d, 5.0d),
                        scale(size.getWidth() / 2.0d, size.getHeight() / 2.0d, 1.0d)
                );


        block.transform(multiply(screen1, projection, model1)).drawBlock(getRenderer());
        block.transform(multiply(screen2, projection, model2)).drawBlock(getRenderer());
        block.transform(multiply(screen3, projection, model3)).drawBlock(getRenderer());





//        Matrix4D screen4 =
//                multiply(
//                        translate(size.getWidth() / 2.0d, size.getHeight() / 2.0d, 5.0d),
//                        scale(size.getWidth() / 2.0d, size.getHeight() / 2.0d, 1.0d)
//                );

//        new Chunk(32, 1, 32)
//                .transform(multiply(screen4, projection, translate(-16.0d, -32.0d, 32.0d)))
//                .drawChunk(getRenderer());


//        new Block().transform(translate(0, 0, 0)).transform(multiply(screen1, model1)).drawBlock(getRenderer());
//        new Block().transform(translate(1, 0, 0)).transform(multiply(screen1, model1)).drawBlock(getRenderer());
//        new Block().transform(translate(2, 0, 0)).transform(multiply(screen1, model1)).drawBlock(getRenderer());
//        new Block().transform(translate(0, 1, 0)).transform(multiply(screen1, model1)).drawBlock(getRenderer());
//        new Block().transform(translate(1, 1, 0)).transform(multiply(screen1, model1)).drawBlock(getRenderer());
//        new Block().transform(translate(2, 1, 0)).transform(multiply(screen1, model1)).drawBlock(getRenderer());
//        new Block().transform(translate(0, 1, 1)).transform(multiply(screen1, model1)).drawBlock(getRenderer());
//        new Block().transform(translate(1, 1, 1)).transform(multiply(screen1, model1)).drawBlock(getRenderer());
//        new Block().transform(translate(2, 1, 1)).transform(multiply(screen1, model1)).drawBlock(getRenderer());
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
