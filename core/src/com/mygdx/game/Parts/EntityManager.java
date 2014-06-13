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


    public EntityManager(){
        entities= new Array<Entity>();
        selections = new Array<Entity>();
        matched = new Array<Entity>();
        boardEntity = new Entity[MyGdxGame.rowBLOCK][MyGdxGame.colBLOCK]; //x is col, y is row
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
        return boardEntity[col][row];
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
