package com.cowboysmall.games.proto.proto01;

import com.cowboysmall.playful.graphics.Mesh;
import com.cowboysmall.playful.math.v1.Matrix4D;
import com.cowboysmall.playful.math.v1.Vector4D;
import com.cowboysmall.playful.math.v1.lookat.LookAt;
import com.cowboysmall.playful.math.v1.projection.Projection;
import com.cowboysmall.playful.math.v1.rotation.Rotation;
import com.cowboysmall.playful.math.v1.scale.Scale;
import com.cowboysmall.playful.math.v1.translation.Translation;
import com.cowboysmall.playful.math.v1.view.View;

import javax.swing.JPanel;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.stream.Stream;

import static java.lang.Math.cos;
import static java.lang.Math.sin;
import static java.lang.Math.toRadians;

public class GamePanel extends JPanel implements KeyListener {

    private final Mesh[] assets;

    private GameCanvas gameCanvas;

    private Vector4D position = new Vector4D();
    private Vector4D eye = new Vector4D(0d, 0d, -0.01d);
    //    private Vector4D eye = new Vector4D(0d, 0d, 0.01d);
    private Vector4D up = new Vector4D(0d, 1d, 0d);

    private double pitch = 0;
    private double yaw = 0;
    private double amount = 5;

    private double theta;

    private boolean toggleRotation;


    //_________________________________________________________________________

    public GamePanel(Mesh... assets) {

        super();
        this.assets = assets;
    }


    //_________________________________________________________________________

    public void init() {

        System.out.println("(" + getWidth() + ", " + getHeight() + ")");

        gameCanvas = new GameCanvas(getWidth(), getHeight());
        Stream.of(assets).forEach(gameCanvas::add);
    }

    public void update(double delta) {

        if (toggleRotation)
            theta += delta * 0.025;

        Matrix4D model = new Translation(1.0d, 1.0d, 0.0d)
                .preMultiply(new Scale(getWidth() / 2.0d, getHeight() / 2.0d, 1.0d));

//        Matrix4D screen = new Translation(0.0d, 0.0d, 5.0d)
//                .preMultiply(new Projection(1.77777777778d, 90d, 0d, 1000d));

        Matrix4D screen = new Rotation(theta, theta * 0.33d, theta * 0.66d)
                .preMultiply(new Translation(0.0d, 0.0d, 5.0d))
                .preMultiply(new Projection(1.77777777778d, 90d, 0d, 1000d));

        Matrix4D lookAt = new LookAt(eye, up)
                .preMultiply(new View(pitch, yaw, position))
                .preMultiply(new Translation(position.getX(), position.getY(), position.getZ()));

//        Matrix4D lookAt = new LookAt(eye, up)
//                .preMultiply(new View(pitch, yaw, position));

        gameCanvas.transform(lookAt.preMultiply(screen).preMultiply(model));
    }

    @Override
    public void paintComponent(Graphics g) {

        super.paintComponent(g);

        gameCanvas.draw();
        g.drawImage(gameCanvas, 0, 0, null);
    }


    //_________________________________________________________________________

    @Override
    public void keyPressed(KeyEvent e) {

        if (e.getKeyCode() == KeyEvent.VK_W)
            up(amount);
        if (e.getKeyCode() == KeyEvent.VK_S)
            up(-amount);
        if (e.getKeyCode() == KeyEvent.VK_A)
            left(amount);
        if (e.getKeyCode() == KeyEvent.VK_D)
            left(-amount);

        if (e.getKeyCode() == KeyEvent.VK_R)
            toggleRotation = !toggleRotation;

        if (e.getKeyCode() == KeyEvent.VK_UP)
            position = position.translateZ(-0.25);
        if (e.getKeyCode() == KeyEvent.VK_DOWN)
            position = position.translateZ(0.25);
        if (e.getKeyCode() == KeyEvent.VK_LEFT)
            position = position.translateX(0.25);
        if (e.getKeyCode() == KeyEvent.VK_RIGHT)
            position = position.translateX(-0.25);

        if (e.getKeyCode() == KeyEvent.VK_J)
            yaw += 0.05;
        if (e.getKeyCode() == KeyEvent.VK_L)
            yaw -= 0.05;
        yaw %= 360;

        if (e.getKeyCode() == KeyEvent.VK_I)
            if (pitch < 90)
                pitch -= 0.05;
        if (e.getKeyCode() == KeyEvent.VK_K)
            if (-90 < pitch)
                pitch += 0.05;
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }

    @Override
    public void keyTyped(KeyEvent e) {

    }


    //_________________________________________________________________________

    private void left(double amount) {

        Vector4D v = up.normalise();

        eye = rotate(toRadians(amount), v).preMultiply(eye);
    }

    private void up(double amount) {

        Vector4D u = eye.crossProduct(up).normalise();

        eye = rotate(toRadians(amount), u).preMultiply(eye);
        up = rotate(toRadians(amount), u).preMultiply(up);
    }

    private Matrix4D rotate(double radians, Vector4D axis) {

        Matrix4D I = Matrix4D.identity();
        Matrix4D T = axis.outerProduct(axis);
        Matrix4D D = new Matrix4D(0, -axis.getZ(), axis.getY(), 0, axis.getZ(), 0, -axis.getX(), 0, -axis.getY(), axis.getX(), 0, 0, 0, 0, 0, 1);

        return I.multiply(cos(radians)).add(T.multiply(1 - cos(radians))).add(D.multiply(sin(radians)));
    }
}
