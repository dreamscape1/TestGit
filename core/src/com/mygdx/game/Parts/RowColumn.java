package com.mygdx.game.Parts;

import com.badlogic.gdx.math.Vector2;

/**
 * Created by sokokhoe on 6/10/2014.
 */
public class RowColumn extends Part {
    private Vector2 vec;

    public RowColumn(int row, int col) {
        vec = new Vector2();
        setVec(row, col);
    }

    public RowColumn() {
        this(0, 0);

    }

    public void setVec(int row, int col) {
        this.vec.x = col;
        this.vec.y = row;
    }

    public void setVec(Vector2 vec) {
        this.vec = vec;
    }

    public Vector2 getVec() {
        return vec;
    }
}




