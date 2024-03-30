package com.cowboysmall.games.proto.proto04;

import com.cowboysmall.playful.math.v2.Mesh;
import com.cowboysmall.playful.math.v2.Triangle;
import com.cowboysmall.playful.math.v2.Vector4;

public interface Renderable {

    void init();

    void reset();

    void render();



    void drawLine(Vector4 a, Vector4 b);

    void drawTriangle(Triangle triangle);

    void drawMesh(Mesh mesh);


//    void drawPoint();

    void drawRectangle();

    void drawCircle();
}
