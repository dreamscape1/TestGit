package com.mygdx.game.Parts;

import com.badlogic.gdx.utils.Array;
import com.mygdx.game.MyGdxGame;


/**
 * Created by sokokhoe on 6/6/2014.
 */
public class EntityManager {

    private Array<Entity> entities;
    private static Array<Entity> selections;
    private Entity[][] boardEntity;
    private Array<Entity> matched;
    private Array<Entity> entityPool;
    private boolean isMatched;


    public EntityManager(){
        entities= new Array<Entity>();
        selections = new Array<Entity>();
        matched = new Array<Entity>();
        boardEntity = new Entity[MyGdxGame.rowBLOCK][MyGdxGame.colBLOCK]; //x is col, y is row
        entityPool = new Array<Entity>();
    }


    //**Simple Entity Pool**//
    public void putPool(Entity e){
        if(entityPool.size>0) {
            if (!entityPool.contains(e, true)) {
                entityPool.add(e);
            }
        }else{
            entityPool.add(e);
        }
    }

    public Entity obtainPool(){
        return entityPool.get(entityPool.size-1);
    }


    public void update(){
        for(Entity e : entities){
            if(!e.get(AlivePart.class).isAlive()){
                putPool(e);
                entities.removeValue(e,true);
            }
        }

    }

    //**All Entities**//
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


    //**Entities in X,Y**//
    public void add(Entity e, int row, int col){
        boardEntity[col][row] =e;
    }

    public Entity getBoardEntity(int row, int col){
        return boardEntity[col][row];
    }


    //**User Selected Entity**//
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


    //**Matched Entities**//
    public Array<Entity> getAllMatched(){
        return matched;
    }

    public synchronized void clearMatchEntity(){
        matched.clear();
        //matched.removeAll(matched,true);
        //for(int i =0; i<matched.size;i++) matched.removeIndex(i);
    }

    public void addMatch(Entity e){
        if(!matched.contains(e,true)) matched.add(e);

    }


    //**Entity Manipulation
    public void swap(Entity e1, Entity e2){
        Entity buffer =e1;
        int x1 = (int) e1.get(RowColumn.class).getVec().x;
        int y1 = (int) e1.get(RowColumn.class).getVec().y;

        int x2 = (int) e2.get(RowColumn.class).getVec().x;
        int y2 = (int) e2.get(RowColumn.class).getVec().y;

        System.out.println("(x1,y1) : "+x1+","+y1+ "--- (x2,y2) : "+ x2+","+y2);

        boardEntity[y1][x1] =e2;
        boardEntity[y2][x2] =e1;


    }

}
