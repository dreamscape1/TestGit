package com.mygdx.game.Parts;

/**
 * Created by sokokhoe on 6/17/2014.
 */
public class AlivePart extends Part {

    private boolean isAlive;

    public AlivePart(Boolean isAlive){
        this.isAlive=isAlive;
    }

    public boolean isAlive() {
        return isAlive;
    }

    public void setAlive(boolean isAlive) {
        this.isAlive = isAlive;
    }
}
