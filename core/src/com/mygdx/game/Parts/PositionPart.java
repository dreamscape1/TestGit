package com.mygdx.game.Parts;

/**
 * Created by sokokhoe on 6/6/2014.
 */
public class PositionPart extends Part {

    private float x;
    private float y;

    public PositionPart(float x, float y){
        this.x=x;
        this.y=y;
    }


    public float getX() {
        return x;
    }

    public void setX(float x) {
        this.x = x;
    }

    public float getY() {
        return y;
    }

    public void setY(float y) {
        this.y = y;
    }
}
