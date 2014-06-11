package com.mygdx.game.Parts;

import com.badlogic.gdx.utils.Array;
import com.mygdx.game.MyGdxGame;
import com.mygdx.game.System.GameSystem;

import java.util.ArrayList;


/**
 * Created by sokokhoe on 6/6/2014.
 */
public class EntityManager {

    private Array<Entity> entities;
    private static Array<Entity> selections;
    private Entity[][] boardEntity;
    private Array<Entity> matched;


    public EntityManager(){
        entities= new Array<Entity>();
        selections = new Array<Entity>();
        matched = new Array<Entity>();
        boardEntity = new Entity[MyGdxGame.xBLOCK][MyGdxGame.yBLOCK];
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

    public void add(Entity e, int row, int col){
        boardEntity[col][row] =e;
    }

    public Entity getBoardEntity(int row, int col){
        return boardEntity[row][col];
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

    public void addMatch(Entity e){
        matched.add(e);
    }

    public Array<Entity> getAllMatched(){
        return matched;
    }

}
