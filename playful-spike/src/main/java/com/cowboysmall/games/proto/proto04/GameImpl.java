package com.cowboysmall.games.proto.proto04;

import com.cowboysmall.playful.math.v2.Vector4;

public class GameImpl extends Game {

    private RendererPanel rendererPanel;

    public GameImpl(long fps) {
        super(fps);
    }


    //_________________________________________________________________________

    @Override
    protected void init() {

        rendererPanel = new RendererPanel();

//        Windows.createWindow(640, 480, rendererPanel);
        Windows.createFullScreenWindow(rendererPanel);
    }

    @Override
    protected void update(double delta) {

        rendererPanel.drawTriangle(
                new Vector4(25f, 25f, 25f),
                new Vector4(25f, 75f, 25f),
                new Vector4(75f, 75f, 25f)
        );
        rendererPanel.drawTriangle(
                new Vector4(25f, 25f, 25f),
                new Vector4(75f, 25f, 25f),
                new Vector4(75f, 75f, 25f)
        );
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
