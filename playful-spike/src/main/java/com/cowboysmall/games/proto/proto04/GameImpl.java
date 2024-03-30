package com.cowboysmall.games.proto.proto04;

import com.cowboysmall.playful.math.v2.Matrix4;
import com.cowboysmall.playful.math.v2.Mesh;
import com.cowboysmall.playful.math.v2.ObjectFileLoader;
import com.cowboysmall.playful.math.v2.Transformations;

import java.awt.Dimension;

import static com.cowboysmall.playful.math.v2.Operations.multiply;
import static com.cowboysmall.playful.math.v2.Transformations.projection;
import static com.cowboysmall.playful.math.v2.Transformations.rotateX;
import static com.cowboysmall.playful.math.v2.Transformations.rotateY;
import static com.cowboysmall.playful.math.v2.Transformations.rotateZ;
import static com.cowboysmall.playful.math.v2.Transformations.scale;
import static com.cowboysmall.playful.math.v2.Transformations.translate;

public class GameImpl extends Game {

    private RendererPanel rendererPanel;
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
//        System.out.println(cube.getTriangles().size());

        rendererPanel = new RendererPanel();

        Windows.createWindow(1600, 900, rendererPanel);
//        Windows.createFullScreenWindow(rendererPanel);
    }

    @Override
    protected void update(double delta) {

        theta += delta * 0.025;

        Dimension size = rendererPanel.getSize();

        Matrix4 rotations = multiply(multiply(rotateX(theta), rotateY(theta * 0.33d)), rotateZ(theta * 0.66d));
        Mesh transformed = cube.transform(rotations);

//        Matrix4 translate = translate(1.0d, 1.0d, 0.0d);
//        Matrix4 scale = scale(size.getWidth() / 2.0d, size.getHeight() / 2.0d, 1.0d);
//        Matrix4 model = multiply(multiply(scale, translate), rotations);

        Matrix4 scale = scale(100.0d, 100.0d, 1.0d);
        transformed = transformed.transform(scale);

        Matrix4 translate = translate(size.getWidth() / 2.0d, size.getHeight() / 2.0d, 1.0d);
        transformed = transformed.transform(translate);
//        Matrix4 model = multiply(multiply(translate, scale), rotations);


        Matrix4 translate2 = Transformations.translate(0.0d, 0.0d, 5.0d);
        Matrix4 projection = projection(1.77777777778d, 90d, 0.0d, 1000d);
//        Matrix4 screen = Operations.multiply(projection, translate2);

//        transformed = transformed.transform(translate2);
        transformed = transformed.transform(projection);

        rendererPanel.drawMesh(transformed);


//        rendererPanel.drawMesh(cube.transform(model));
//        rendererPanel.drawMesh(cube.transform(multiply(screen, model)));
//        rendererPanel.drawMesh(cube.transform(Operations.multiply(model, Operations.multiply(rotations, projection))));
//        rendererPanel.drawMesh(cube.transform(Operations.multiply(model, rotations)));
//        rendererPanel.drawMesh(cube.transform(Operations.multiply(model, screen)));
//        rendererPanel.drawMesh(cube.transform(Operations.multiply(screen, model)));


//        rendererPanel.drawTriangle(
//                new Triangle(
//                        new Vector4(-0.5d, -0.5d, -0.5d),
//                        new Vector4(-0.5d, 0.5d, -0.5d),
//                        new Vector4(0.5d, 0.5d, -0.5d)
//                ).transform(model)
//        );
//        rendererPanel.drawTriangle(
//                new Triangle(
//                        new Vector4(-0.5d, -0.5d, -0.5d),
//                        new Vector4(0.5d, 0.5d, -0.5d),
//                        new Vector4(0.5d, -0.5d, -0.5d)
//                ).transform(model)
//        );
    }

    @Override
    protected void render() {

        rendererPanel.render();
    }

    @Override
    protected void destroy() {

    }

    public static void main(String[] args) throws Exception {

        Game game = new GameImpl(60);
        game.start();
    }
}
