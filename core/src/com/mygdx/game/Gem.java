package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputAdapter;
import com.badlogic.gdx.graphics.*;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.Vector3;
import com.badlogic.gdx.physics.box2d.CircleShape;
import com.badlogic.gdx.physics.box2d.Shape;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.InputListener;
import com.badlogic.gdx.scenes.scene2d.Touchable;

import java.awt.*;
import java.awt.Color;

import static java.awt.Color.*;

/**
 * Created by sokokhoe on 5/30/2014.
 */
public class Gem extends InputAdapter{

    private float radius;
    private int x,y;

    private int type;
    private Shape circle;
    private ShapeRenderer sr;
    private boolean touched;
    private boolean dragged;
    private boolean canTouch;
    OrthographicCamera cam;


    public Gem(int x, int y, float radius,ShapeRenderer sr,OrthographicCamera cam,int type) {
        this.x=x;
        this.y=y;
        this.radius= radius;
        //circle = new CircleShape();
        //circle.setRadius(radius);
        this.sr=sr;
        this.cam=cam;
        this.type = type;
        canTouch =true;

    }

    public void update(){
        if(canTouch) {
            if (Gdx.input.isTouched()) {
                Vector3 touchPos = new Vector3();
                touchPos.set(Gdx.input.getX(), Gdx.input.getY(), 0);
                cam.unproject(touchPos);
                //System.out.println("X:" + touchPos.x +"   Y: "+ touchPos.y);
                if (touchPos.x > (x - radius) && touchPos.x <= x + radius) {
                    //System.out.println("X Touched");
                    if (touchPos.y < y + radius && touchPos.y >= y - radius) {
                        //System.out.println("Tocuhed == Vector X: "+touchPos.x +" Vector Y: "+touchPos.y);
                        canTouch=false;
                        touched = true;
                    }
                } else {
                    touched = false;
                    canTouch=true;
                }
            }
        }
    }

    public void draw(){
        //sr.begin(ShapeRenderer.ShapeType.Filled);

        switch(type){
            case 0:
                sr.setColor(com.badlogic.gdx.graphics.Color.CYAN);
                break;

            case 1:
                sr.setColor(com.badlogic.gdx.graphics.Color.BLUE);
                break;

            case 2:
                sr.setColor(com.badlogic.gdx.graphics.Color.GREEN);
                break;

            case 3:
                sr.setColor(com.badlogic.gdx.graphics.Color.BLACK);
                break;
        }

        //sr.setColor(com.badlogic.gdx.graphics.Color.BLACK);
        sr.circle(x, y, radius);
        if(touched) {
            sr.setColor(com.badlogic.gdx.graphics.Color.WHITE);
            sr.rect(x-radius,y-radius,2*radius,2*radius);
            touched=false;
        }

        //sr.end();
    }


    public boolean getTouched() {return touched;}

    public float getX() {return x;}
    public float getY() {return y;}
    public Gem getGem() {return this;}

    public void setX(int x) {this.x=x;}
    public void setY(int y){this.y=y;}
    public void setTouch(boolean b) {canTouch=b;}
    public void setType(int type){
        if(type< 0 || type>2){this.type=3;}
        else{this.type=type;}
    }


    @Override
    public boolean touchDragged(int screenX, int screenY, int pointer) {
        return super.touchDragged(screenX, screenY, pointer);
    }
}
