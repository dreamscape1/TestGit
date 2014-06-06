package com.mygdx.game.Parts;

import com.badlogic.gdx.utils.Array;
import com.mygdx.game.System.GameSystem;


/**
 * Created by sokokhoe on 6/6/2014.
 */
public class EntityManager {

    private Array<Entity> entities;
    private static Array<Entity> selections;


    public EntityManager(){
        entities= new Array<Entity>();
        selections = new Array<Entity>();
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

    public Array<Entity> getSelections() {
        return selections;
    }

    public void select(Entity entity){
        if(selections.size > 2) {
            selections.clear();

        }
        if(selections.size>=0 && selections.size <=2 ){
            selections.add(entity);
        }

    }

}
