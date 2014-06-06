package com.mygdx.game.Parts;

import com.badlogic.gdx.utils.Array;


/**
 * Created by sokokhoe on 6/6/2014.
 */
public class EntityManager {



    private Array<Entity> entities;

    public EntityManager(){
        entities= new Array<Entity>();
    }


    public Array<Entity> getEntities() {
        return entities;
    }

    public void add(Entity entity){
        entities.add(entity);
    }



}
