package com.mygdx.game.System;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.mygdx.game.MyGdxGame;
import com.mygdx.game.Parts.ColorPart;
import com.mygdx.game.Parts.Entity;
import com.mygdx.game.Parts.EntityManager;
import com.mygdx.game.Parts.PositionPart;

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
            if(e.get(ColorPart.class).getColor()== ColorPart.mColor.GREEN)
                sr.setColor(Color.GREEN);
            if(e.get(ColorPart.class).getColor()== ColorPart.mColor.BLUE)
                sr.setColor(Color.BLUE);
            else if(e.get(ColorPart.class).getColor()== ColorPart.mColor.CYAN)
                sr.setColor(Color.CYAN);

            sr.circle(e.get(PositionPart.class).getX(),e.get(PositionPart.class).getY(),50);
        }
    }
}
