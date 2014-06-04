package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.math.Vector3;

import java.awt.*;

/**
 * Created by sokokhoe on 5/22/2014.
 */
public class BasicObject {

    public float x,y;
    private float dx,dy;
    private SpriteBatch sb;
    private Rectangle rect;
    private Texture texture;


    public BasicObject(){

        this.dx=50;
        this.dy =0;
        TextureLoader.load("Object","badlogic.jpg");
        this.texture= TextureLoader.getTexture("Object");
    }



    public void update(float deltatime,OrthographicCamera cam){

        if (x<0) dx=50;
        if (x>640 -texture.getWidth()) dx=-50;

        x= x +dx*deltatime;

        if(Gdx.input.isTouched()) {
            Vector3 touchPos = new Vector3();
            touchPos.set(Gdx.input.getX(), Gdx.input.getY(), 0);
            cam.unproject(touchPos);
            this.y = touchPos.y ;
            this.x = touchPos.x ;
        }


    }

    public void draw(SpriteBatch sb){
        sb.draw(texture,x,y);
    }

}
