package com.mygdx.game.System;

import com.badlogic.gdx.utils.Array;
import com.mygdx.game.Parts.DescriptionPart;
import com.mygdx.game.Parts.Entity;
import com.mygdx.game.Parts.EntityManager;
import com.mygdx.game.Parts.PositionPart;

/**
 * Created by sokokhoe on 6/23/2014.
 */
public class AnimationSystem {

    private Array<Entity> entityToAnimate;
    private Array<Entity> targetEntityAnimationDestination;
    private Array<Boolean> animationQueue;

    private EntityManager em;

    private static boolean isAnimating;


    public AnimationSystem(EntityManager em){
        this.em=em;
        entityToAnimate = new Array<Entity>();
        targetEntityAnimationDestination = new Array<Entity>();
        animationQueue = new Array<Boolean>();
    }

    public void update(float dt){
        if(entityToAnimate.size==0) isAnimating=false;
        if(entityToAnimate.size>0){

            isAnimating=true;
            for(int i=0; i<entityToAnimate.size; i++){
                System.out.println("AM: Animating stuff in queue. In queue: "+ entityToAnimate.size);
                animationQueue.set(i,
                                   animate(entityToAnimate.get(i),
                                           targetEntityAnimationDestination.get(i),
                                           dt)
                );
                if(animationQueue.get(i)){
                    em.swap(entityToAnimate.get(i),targetEntityAnimationDestination.get(i));
                    entityToAnimate.removeIndex(i);
                    targetEntityAnimationDestination.removeIndex(i);
                    animationQueue.removeIndex(i);
                    System.out.println("Run remove");
                }
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
            System.out.println("AM: " +e.get(DescriptionPart.class).getID()+ " has completed");
            return true;
        }
        return false;
    }

    private boolean animate(Entity target, Entity destination, float dt){
        boolean buff = false;
        if(isAnimating) {
            buff = animate(target,
                    target.get(PositionPart.class).getX(),
                    target.get(PositionPart.class).getY(),
                    destination.get(PositionPart.class).getX(),
                    destination.get(PositionPart.class).getY(),
                    dt
            );
        }
        return buff;
    }

    public void addtoQueue(Entity targetEntity, Entity entityDestination){
        entityToAnimate.add(targetEntity);
        targetEntityAnimationDestination.add(entityDestination);
        animationQueue.add(false);
    }

    //Getters//
    public Array<Entity> getEntityToAnimate() {
        return entityToAnimate;
    }

    public Array<Entity> getTargetEntityAnimationDestination() {
        return targetEntityAnimationDestination;
    }

    public static boolean isAnimating() {
        return isAnimating;
    }


    //Setters
    public void setEntityToAnimate(Array<Entity> entityToAnimate) {
        this.entityToAnimate = entityToAnimate;
    }

    public void setTargetEntityAnimationDestination(Array<Entity> targetEntityAnimationDestination) {
        this.targetEntityAnimationDestination = targetEntityAnimationDestination;
    }

    public void setAnimating(boolean isAnimating) {
        this.isAnimating = isAnimating;
    }
}


