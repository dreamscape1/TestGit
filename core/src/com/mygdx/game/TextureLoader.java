package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;

import java.util.HashMap;

/**
 * Created by sokokhoe on 5/30/2014.
 */
public class TextureLoader {

    private static HashMap<String,Texture> textures = new HashMap<String, Texture>();

    /*public static TextureLoader(){
        textures = new HashMap<String, Texture>();
    }*/

    public static void load(String key, String path){

        try{
            Texture texture = new Texture(Gdx.files.internal(path));
            textures.put(key,texture);
        }
        catch(Exception e){

        }
    }

    public static Texture getTexture(String key){
        Texture texture = textures.get(key);
        return texture;

    }


}
