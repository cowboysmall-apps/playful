package com.cowboysmall.games.proto.proto01;

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

    private final Mesh[] assets;

    private GameCanvas gameCanvas;

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

    public void update(long delta) {

        theta += delta * 0.025;

        Matrix4D matrix4D =
                new View(pitch, yaw, position)
                        .preMultiply(new Rotation(theta, theta * 0.33d, theta * 0.66d))
                        .preMultiply(new Translation(0.0d, 0.0d, 5.0d))
                        .preMultiply(new Projection(1.3333d, 60d, 0.1d, 1000d))
                        .preMultiply(new Translation(1.0d, 1.0d, 0.0d))
                        .preMultiply(new Scale(getWidth() / 2.0d, getHeight() / 2.0d, 1.0d));

        gameCanvas.transform(matrix4D);
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
            position = position.translateY(-0.05);
        if (e.getKeyCode() == KeyEvent.VK_DOWN)
            position = position.translateY(0.05);
        if (e.getKeyCode() == KeyEvent.VK_LEFT)
            position = position.translateX(-0.05);
        if (e.getKeyCode() == KeyEvent.VK_RIGHT)
            position = position.translateX(0.05);

        if (e.getKeyCode() == KeyEvent.VK_A)
            yaw -= 0.05;
        if (e.getKeyCode() == KeyEvent.VK_D)
            yaw += 0.05;
        yaw %= 360;

        if (e.getKeyCode() == KeyEvent.VK_W)
            if (pitch < 90)
                pitch += 0.05;
        if (e.getKeyCode() == KeyEvent.VK_S)
            if (-90 < pitch)
                pitch -= 0.05;
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }

    @Override
    public void keyTyped(KeyEvent e) {

    }
}
