package com.mygdx.game.Handler;


import com.badlogic.gdx.InputAdapter;


/**
 * Created by sokokhoe on 6/6/2014.
 */
public class InputHandler extends InputAdapter {

    private boolean isDown;



    @Override
    public boolean touchDown(int screenX, int screenY, int pointer, int button) {
        isDown=true;
        return true;
    }

    @Override
    public boolean touchUp(int screenX, int screenY, int pointer, int button) {
        if(isDown){
            return true;
        }
        return false;
    }

    @Override
    public boolean touchDragged(int screenX, int screenY, int pointer) {
        return false;
    }


}
