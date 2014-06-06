package com.mygdx.game.Parts;

import com.mygdx.game.Gem;

/**
 * Created by sokokhoe on 6/4/2014.
 */
public abstract class Part {


    private boolean isAlive;

    public boolean isAlive() {
        return isAlive;
    }

    public void setAlive(boolean isAlive) {
        this.isAlive = isAlive;
    }

    public void update(float dt){

    }



}

