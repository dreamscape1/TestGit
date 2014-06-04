package com.mygdx.game;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import java.util.ArrayList;

/**
 * Created by sokokhoe on 5/29/2014.
 */
public class BasicObjectManager {

    private MyGdxGame game;
    private ArrayList<BasicObject> objects;
    private BasicObject ob;


    public BasicObjectManager(MyGdxGame game){
        this.game = game;
        objects = new ArrayList<BasicObject>();
    }


    public void update(float dt) {
        int count = objects.size();
        if(count<=0) {return;}

        for(int ii = 0; ii<count; ii++){
            objects.get(ii).update(dt,game.getCam());
        }

    }

    public void render(SpriteBatch sb){

        int count = objects.size();
        if(count<=0) {return;}

        for(int ii = 0; ii<count; ii++){
            objects.get(ii).draw(sb);
        }
    }


    public void addObject(BasicObject ob){
        objects.add(ob);
    }




    //---Getter Setter---//

    public BasicObject getObject() {
        return ob;
    }

    public void setObject(BasicObject ob) {
        this.ob = ob;
    }

    public MyGdxGame getGame() {
        return game;
    }

}

