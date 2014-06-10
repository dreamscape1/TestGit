package com.mygdx.game.System;

import com.badlogic.gdx.utils.Array;
import com.mygdx.game.Parts.Entity;

/**
 * Created by sokokhoe on 6/10/2014.
 */
public class EntityPool {

    private Array<Entity> entityPool;
    private Array<Entity> entityStore;

    public EntityPool(int size){
        this.entityPool = new Array<Entity>(size);
        this.entityStore =new Array<Entity>();
    }

    public Entity obtain(){
        return null;// TODO add stuff
    }



}
