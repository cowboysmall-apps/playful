package com.cowboysmall.games.proto.proto04;

import com.cowboysmall.playful.math.v2.Vector4;

public interface Renderer {

    void init();

    void reset();

    void render();


//    void drawPoint();

    void drawLine(Vector4 a, Vector4 b);

    void drawTriangle(Vector4 a, Vector4 b, Vector4 c);

    void drawRectangle();

    void drawCircle();

    void drawMesh();
}
