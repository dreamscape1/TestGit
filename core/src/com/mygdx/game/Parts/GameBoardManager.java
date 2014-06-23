package com.mygdx.game.Parts;

import com.badlogic.gdx.Gdx;
import com.mygdx.game.MyGdxGame;
import com.mygdx.game.System.AnimationSystem;
import javafx.animation.Animation;

/**
 * Created by sokokhoe on 6/6/2014.
 */
public class GameBoardManager {

    private EntityManager em;
    private AnimationSystem am;

    public GameBoardManager(EntityManager em, AnimationSystem am){
        this.em=em;
        this.am=am;
    }


    public void update(){
        //if(em.getEntities().size==0) fillBoard();
        fallingGem();

    }

    public void initialize(){
        fillBoard();
    }

    public void fallingGem(){
        for(int x=0; x< MyGdxGame.colBLOCK ; x++ ){
            for(int y=0 ; y< MyGdxGame.rowBLOCK-1;y++){

                if(!em.getBoardEntity(x,y).get(AlivePart.class).isAlive()){
                    if(em.getBoardEntity(x,y+1).get(AlivePart.class).isAlive()){
                        //System.out.println("GBM: Stuff added to animation queue");
                        am.addtoQueue(em.getBoardEntity(x,y+1),em.getBoardEntity(x,y));
                    }
                }

            }

        }
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
