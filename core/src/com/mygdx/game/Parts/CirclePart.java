package com.mygdx.game.Parts;

/**
 * Created by sokokhoe on 6/6/2014.
 */
public class CirclePart extends Part {



    private float radius;

    public CirclePart(){
        this(10);
    }

    public CirclePart(float radius){
        this.radius=radius;
    }

    public float getRadius() {
        return radius;
    }

    public void setRadius(float radius) {
        this.radius = radius;
    }
}
