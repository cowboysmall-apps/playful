package com.cowboysmall.playful.games;

import com.cowboysmall.playful.graphics.Mesh;
import com.cowboysmall.playful.graphics.Triangle;
import com.cowboysmall.playful.math.Vector4D;

public interface Renderable {

    void init();

    void clear();

    void render();


    void drawLine(Vector4D a, Vector4D b);

    void drawTriangle(Triangle triangle);

    void drawMesh(Mesh mesh);

    void drawRectangle(Vector4D a, Vector4D b, Vector4D c, Vector4D d);

    void drawCircle();
}
