package com.mygdx.game.System;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.mygdx.game.MyGdxGame;
import com.mygdx.game.Parts.*;

/**
 * Created by sokokhoe on 6/6/2014.
 */
public class DrawSystem {

    private EntityManager em;
    private ShapeRenderer sr;
    private MyGdxGame game;


    public DrawSystem(EntityManager em, MyGdxGame game){
        this.em=em;
        this.sr=game.getSr();
    }

    public void draw(){

        for(Entity e : em.getEntities()){

            switch(e.get(ColorPart.class).getColor()){
                case GREEN:
                    sr.setColor(Color.GREEN);
                    break;
                case BLUE:
                    sr.setColor(Color.BLUE);
                    break;
                case CYAN:
                    sr.setColor(Color.CYAN);
                    break;
                case BLACK:
                    sr.setColor(Color.BLACK);
                default:
                    assert false;
                    break;
            }
            sr.begin(ShapeRenderer.ShapeType.Filled);
            sr.circle(e.get(PositionPart.class).getX(),e.get(PositionPart.class).getY(),e.get(CirclePart.class).getRadius());
            sr.end();
        }
        for(Entity e : em.getSelections()){
            sr.begin(ShapeRenderer.ShapeType.Line);
            sr.setColor(Color.BLACK);
            sr.rect(e.get(PositionPart.class).getX() - e.get(CirclePart.class).getRadius() - 9,
                    e.get(PositionPart.class).getY() - e.get(CirclePart.class).getRadius() - 10,
                    60, 60);
            sr.end();
        }

        for(Entity e : em.getAllMatched()){
            sr.begin(ShapeRenderer.ShapeType.Line);
            sr.setColor(Color.MAGENTA);
            sr.rect(e.get(PositionPart.class).getX() - e.get(CirclePart.class).getRadius() - 9,
                    e.get(PositionPart.class).getY() - e.get(CirclePart.class).getRadius() - 10,
                    60, 60);
            sr.end();

        }

    }


}
