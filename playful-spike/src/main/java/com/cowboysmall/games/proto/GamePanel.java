package com.cowboysmall.games.proto;

import com.cowboysmall.playful.graphics.Mesh;
import com.cowboysmall.playful.math.Matrix4D;
import com.cowboysmall.playful.math.Vector4D;
import com.cowboysmall.playful.math.projection.Projection;
import com.cowboysmall.playful.math.rotation.Rotation;
import com.cowboysmall.playful.math.scale.Scale;
import com.cowboysmall.playful.math.translation.Translation;
import com.cowboysmall.playful.math.view.View;

import javax.swing.JPanel;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.stream.Stream;

public class GamePanel extends JPanel implements KeyListener {

    private GameCanvas gameCanvas;
    private Mesh[] assets;

    private Vector4D position;

    private double pitch = 0;
    private double yaw = 0;

    private double theta;


    //_________________________________________________________________________

    public GamePanel(Mesh... assets) {

        super();
        this.assets = assets;

        setBackground(Color.BLACK);
        setForeground(Color.WHITE);
    }


    //_________________________________________________________________________

    public void init() {

        gameCanvas = new GameCanvas(getWidth(), getHeight());
        Stream.of(assets)
                .forEach(gameCanvas::add);

        position = new Vector4D();
    }

    public void update(double delta) {

        theta += delta * 0.0125;

//        Matrix4D matrix4D =
//                new Rotation(theta, theta * 0.33d, theta * 0.66d)
//                        .preMultiply(new Translation(0.0d, 0.0d, 10.0d))
//                        .preMultiply(new View(pitch, yaw, position))
//                        .preMultiply(new Projection(1.3333d, 90d, 0.1d, 1000d))
//                        .preMultiply(new Translation(1.0d, 1.0d, 0.0d))
//                        .preMultiply(new Scale(getWidth() / 2.0d, getHeight() / 2.0d, 1.0d));
//
//        gameCanvas.transform(matrix4D);

        Matrix4D view = new View(pitch, yaw, position);

        Matrix4D world1 =
                new Rotation(theta, theta * 0.33d, theta * 0.66d)
                        .preMultiply(new Translation(0.0d, 0.0d, 10.0d));

        Matrix4D world2 = new Translation(0.0d, 0.0d, 15.0d);


        Matrix4D screen1 =
                new Projection(1.3333d, 90d, 0.1d, 1000d)
                        .preMultiply(new Translation(1.0d, 1.0d, 0.0d))
                        .preMultiply(new Scale(getWidth() / 2.0d, getHeight() / 2.0d, 1.0d));

        Matrix4D screen2 =
                new Projection(1.3333d, 90d, 0.1d, 1000d)
                        .preMultiply(new Translation(0.5d, 0.5d, 0.0d))
                        .preMultiply(new Scale(getWidth() / 2.0d, getHeight() / 2.0d, 1.0d));


        gameCanvas.transformAll(
                world1.preMultiply(view).preMultiply(screen1),
                world2.preMultiply(view).preMultiply(screen2)
        );
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

        if (e.getKeyCode() == KeyEvent.VK_UP)
            position = position.translateZ(0.05);
        if (e.getKeyCode() == KeyEvent.VK_DOWN)
            position = position.translateZ(-0.05);
        if (e.getKeyCode() == KeyEvent.VK_LEFT)
            position = position.translateX(0.05);
        if (e.getKeyCode() == KeyEvent.VK_RIGHT)
            position = position.translateX(-0.05);

        if (e.getKeyCode() == KeyEvent.VK_A)
            yaw -= 0.5;
        if (e.getKeyCode() == KeyEvent.VK_D)
            yaw += 0.5;
        yaw %= 360;

        if (e.getKeyCode() == KeyEvent.VK_W)
            if (pitch < 90)
                pitch += 0.5;
        if (e.getKeyCode() == KeyEvent.VK_S)
            if (-90 < pitch)
                pitch -= 0.5;
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }

    @Override
    public void keyTyped(KeyEvent e) {

    }
}
