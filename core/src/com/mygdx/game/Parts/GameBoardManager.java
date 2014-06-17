package com.mygdx.game.Parts;

import com.badlogic.gdx.Gdx;
import com.mygdx.game.MyGdxGame;

/**
 * Created by sokokhoe on 6/6/2014.
 */
public class GameBoardManager {

    private EntityManager em;

    public GameBoardManager(EntityManager em){
        this.em=em;
    }


    public void update(){
        //if(em.getEntities().size==0) fillBoard();

    }

    public void initialize(){
        fillBoard();
    }

    private synchronized void  fillBoard(){
        for(int x =0 ; x < MyGdxGame.colBLOCK; x++){ // x is col; y is row
            for(int y =0 ; y < MyGdxGame.rowBLOCK; y++){
                Entity entity = EntityGenerator.create
                        (true,
                                Gdx.graphics.getWidth()/ MyGdxGame.colBLOCK *x +MyGdxGame.xBLOCK_OFFSET,
                                Gdx.graphics.getHeight()/ MyGdxGame.rowBLOCK *y+MyGdxGame.yBLOCK_OFFSET,
                                20,
                                null);
                entity.get(RowColumn.class).setVec(y,x);
                em.add(entity);
                em.add(entity,x,y);

            }
        }

    }
}
