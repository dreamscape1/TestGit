package com.mygdx.game.Handler;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputAdapter;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.Vector3;
import com.mygdx.game.Parts.CirclePart;
import com.mygdx.game.Parts.DescriptionPart;
import com.mygdx.game.Parts.Entity;
import com.mygdx.game.Parts.PositionPart;

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
