package com.mygdx.game.Parts;

import com.badlogic.gdx.utils.Array;


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
        System.out.println("Current Size:" + selections.size);
        if(selections.size > 1) {
            System.out.println("More than 2 selection. Clear previous selection");
            selections.clear();

        }
        if(selections.size>=0 && selections.size <=1 ){
            selections.add(entity);
            System.out.println(entity.get(DescriptionPart.class).getID() + " is selected. Current Size:" + selections.size);
        }

    }

}
