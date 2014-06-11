package com.mygdx.game.System;

import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.Array;
import com.mygdx.game.MyGdxGame;
import com.mygdx.game.Parts.*;

import java.util.ArrayList;

/**
 * Created by Cyclone on 6/6/2014.
 */
public class GameSystem {

    private float x1,y1,x2,y2;

    private boolean isAnimating;

    private EntityManager em;

    private Array<Entity> selections;




    public GameSystem(EntityManager em){
        isAnimating=false;
        this.em=em;

    }

    public void update(float dt){

        //Run only If previous animation has completed
        if(!isAnimating) {

            //If user has selected two object, get the two objects XY and store it. Then set the animation to start
            this.selections = em.getSelections();
            if (selections.size == 2) {
                    x1 = selections.get(0).get(PositionPart.class).getX();
                    x2 = selections.get(1).get(PositionPart.class).getX();

                    y1 = selections.get(0).get(PositionPart.class).getY();
                    y2 = selections.get(1).get(PositionPart.class).getY();
                    isAnimating = true;
            }
        }
        else {

            //After two object is selected and it is a valid swap, start animation.
            if(checkValid(selections)) {




                boolean ani1 = animate(selections.get(0),
                        selections.get(0).get(PositionPart.class).getX(),
                        selections.get(0).get(PositionPart.class).getY(),
                        x2,
                        y2,
                        dt);
                boolean ani2 = animate(selections.get(1),
                        selections.get(1).get(PositionPart.class).getX(),
                        selections.get(1).get(PositionPart.class).getY(),
                        x1,
                        y1,
                        dt);


                //When animation has completed, reset everything and loop back
                if (ani1 && ani2) {
                    Vector2 v1 = selections.get(0).get(RowColumn.class).getVec();
                    Vector2 v2 = selections.get(1).get(RowColumn.class).getVec();

                    selections.get(0).get(RowColumn.class).setVec(v2);
                    selections.get(1).get(RowColumn.class).setVec(v1);

                    isAnimating = false;
                    selections.clear();
                    System.out.println("XY is matched.Animation is " + isAnimating);
                }
            }else{
                isAnimating = false;
                selections.clear();
                System.out.println("Row not valid");
            }

        }

    }

    public boolean animate(Entity e ,float iniX, float iniY, float finalX, float finalY, float dt){

        if(finalX!=iniX) {
            if (Math.abs(finalX - iniX) < e.get(PositionPart.class).getxSpeed() * dt) { //if X already close to dest, snapped it in
                e.get(PositionPart.class).setX(finalX);
            } else {
                if (finalX > iniX) { //if the dest is on the right side
                    e.get(PositionPart.class).setX(iniX + e.get(PositionPart.class).getxSpeed() * dt);
                } else {
                    e.get(PositionPart.class).setX(iniX - e.get(PositionPart.class).getxSpeed() * dt);
                }
            }
        }
        if (finalY!=iniY) {
            if (Math.abs(finalY - iniY) < e.get(PositionPart.class).getySpeed() * dt) {
                e.get(PositionPart.class).setY(finalY); //if Y already close to dest, snapped it in
            } else {
                if (finalY >iniY) { //if the dest is on the top side
                    e.get(PositionPart.class).setY(iniY + e.get(PositionPart.class).getySpeed() * dt);
                } else {
                    e.get(PositionPart.class).setY(iniY - e.get(PositionPart.class).getySpeed() * dt);
                }
            }
        }
        else if(finalY==iniY && finalX==iniX){
            System.out.println(e.get(DescriptionPart.class).getID()+ " has completed");
            return true;
        }
        return false;
    }

    public boolean checkValid(Array<Entity> selections)
    {
        Vector2 v1 = selections.get(0).get(RowColumn.class).getVec();
        Vector2 v2 = selections.get(1).get(RowColumn.class).getVec();

        int row1= (int) v1.y;
        int row2= (int) v2.y;
        int col1= (int) v1.x;
        int col2= (int) v2.x;

        if(Math.max(row1,row2)-Math.min(row1,row2) ==1 && Math.max(col1,col2) - Math.min(col1,col2)==0){
            System.out.println("Row Valid -- Gem1 Row : "+row1 +" --- Gem2 Row : "+ row2);
            return true;
        }
        if(Math.max(col1,col2)-Math.min(col1,col2) ==1 && Math.max(row1,row2) - Math.min(row1,row2)==0){
            System.out.println("Col Valid -- Gem1 Row : "+col1 +" --- Gem2 Row : "+ col2);
            return true;
        }

        System.out.println("Not Valid -- Gem1 Row : "+row1 +" --- Gem2 Row : "+ row2 + " Gem1 Col : "+ col1 +" --- Gem2 Col : "+ col2);

        return false;


    }

    public void findMatch(){
        for(int i=0; i< MyGdxGame.xBLOCK-2; i++ ){
            for(int y=0 ; y< MyGdxGame.yBLOCK-2;y++){
                mColor gem1 = em.getBoardEntity(y,i).get(ColorPart.class).getColor();
                mColor gem2 = em.getBoardEntity(y,i+1).get(ColorPart.class).getColor();
                mColor gem3 = em.getBoardEntity(y,i+2).get(ColorPart.class).getColor();
                if(gem1==gem2 && gem2==gem3){
                    em.addMatch(em.getBoardEntity(y,i));
                    em.addMatch(em.getBoardEntity(y,i+1));
                    em.addMatch(em.getBoardEntity(y,i+2));
                }
            }

        }
    }

    public boolean isAnimating() {
        return isAnimating;
    }

}
