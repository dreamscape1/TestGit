package com.mygdx.game.System;

import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.utils.Array;
import com.mygdx.game.Parts.DescriptionPart;
import com.mygdx.game.Parts.Entity;
import com.mygdx.game.Parts.EntityManager;
import com.mygdx.game.Parts.PositionPart;

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

            //After two object is selected, start animation.
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
            if(ani1 && ani2){
                isAnimating=false;
                selections.clear();
                System.out.println("XY is matched.Animation is "+ isAnimating);
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

    public boolean isAnimating() {
        return isAnimating;
    }

}
