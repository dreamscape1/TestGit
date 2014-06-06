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

    public Entity get(int index){
        return entities.get(index);
    }

    public void remove(int index){

        entities.removeIndex(index);
    }

    public void removeAll()
    {
        entities.removeAll(entities,true);
    }

    public void add(Entity entity){
        entities.add(entity);
    }

}
