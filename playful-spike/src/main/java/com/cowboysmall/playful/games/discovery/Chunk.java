package com.cowboysmall.playful.games.discovery;

import com.cowboysmall.playful.games.Renderable;
import com.cowboysmall.playful.math.Matrix4D;

import static com.cowboysmall.playful.math.Transformations.translate;

public class Chunk {

    private int x, y, z;

    private Block[][][] blocks;

    public Chunk(int x, int y, int z) {

        this.x = x;
        this.y = y;
        this.z = z;

        blocks = new Block[x][y][z];
        for (int i = 0; i < x; i++)
            for (int j = 0; j < y; j++)
                for (int k = 0; k < z; k++)
                    blocks[i][j][k] = new Block().transform(translate(i, j, k));
    }


    //_________________________________________________________________________

    public Chunk transform(Matrix4D matrix4D) {

        for (int i = 0; i < x; i++)
            for (int j = 0; j < y; j++)
                for (int k = 0; k < z; k++)
                    blocks[i][j][k] = blocks[i][j][k].transform(matrix4D);
        return this;
    }

    public void drawChunk(Renderable renderable) {

        for (int i = 0; i < x; i++)
            for (int j = 0; j < y; j++)
                for (int k = 0; k < z; k++)
                    if ((i == 0 || i == x - 1) || (j == 0 || j == y - 1) || (k == 0 || k == z - 1))
                        blocks[i][j][k].drawBlock(renderable);
    }
}
