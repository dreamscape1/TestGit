package com.mygdx.game.Parts;

/**
 * Created by sokokhoe on 6/6/2014.
 */
public class PositionPart extends Part {

    private float x;
    private float y;



    private float xSpeed=800;
    private float ySpeed=600;

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

    public float getxSpeed() {
        return xSpeed;
    }

    public void setxSpeed(float xSpeed) {
        this.xSpeed = xSpeed;
    }

    public float getySpeed() {
        return ySpeed;
    }

    public void setySpeed(float ySpeed) {
        this.ySpeed = ySpeed;
    }
}
