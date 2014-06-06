package com.mygdx.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.scenes.scene2d.InputListener;
import com.mygdx.game.Parts.*;
import com.mygdx.game.System.DrawSystem;

import java.util.ArrayList;
import java.util.Random;

public class MyGdxGame extends ApplicationAdapter implements InputListener {


    //**Screen Stuff**//
	private Texture img;
    private BasicObject obj;
    private OrthographicCamera cam;
    private float delta;

    //**Game Board Stuff**//
    private static final int xBLOCK =6;
    private static final int yBLOCK = 5;
    private static final float xBLOCK_OFFSET = 60;
    private static final float yBLOCK_OFFSET = 40;




    private int x1=0,x2=0,y1=0,y2=0;
    private int touchCnt=0;
    private BitmapFont bmf;


    //**SpriteBatch and ShapeRenderer**//
    private ShapeRenderer sr;
    private SpriteBatch batch;

    //**Managers**//
    private EntityManager em;
    private BasicObjectManager obm;
    //public static TextureLoader textureManager;

    //**Systems**//
    private DrawSystem drawer;

	
	@Override
	public void create () {
        //Initialize Camera
        cam = new OrthographicCamera();
        cam.setToOrtho(false,640,480);

        //Initialize Renderer
        batch = new SpriteBatch();
        sr = new ShapeRenderer();



        //Initialize Managers//
        obm = new BasicObjectManager(this);
        em = new EntityManager();

        //Initialize Systems//
        drawer=new DrawSystem(em, this);

        delta=0;
        bmf= new BitmapFont();


        //Create 'gem' on screen//
        for(int x =0 ; x < xBLOCK ; x++){

            for(int y =0 ; y <yBLOCK ; y++){
                Entity entity = EntityGenerator.create
                        (true,
                         Gdx.graphics.getWidth()/xBLOCK*x +xBLOCK_OFFSET,
                         Gdx.graphics.getHeight()/yBLOCK*y+yBLOCK_OFFSET,
                         20,
                         null);
                em.add(entity);

            }
        }

	}


	@Override
	public void render () {
        //Clear Screen and display FPS on title
        Gdx.graphics.setTitle("Test LibGdx -- FPS :"+ Gdx.graphics.getFramesPerSecond());
		Gdx.gl.glClearColor(1, 0, 0, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        //Update Camera
        cam.update();
        batch.setProjectionMatrix(cam.combined);

        //Draw Shape
        sr.begin(ShapeRenderer.ShapeType.Filled);

        drawer.draw();

        sr.end();


        //Draw Sprites
		batch.begin();

        obm.update(Gdx.graphics.getDeltaTime());
        bmf.draw(batch,"Gem1 (x,y) : ("+ x1+","+y1+") --- Gem2 (x,y) : ("+x2+","+y2+") --- TouchCnt: " +touchCnt,10,470);
        //obm.render(batch);
		batch.end();

	}


    @Override
    public void dispose() {
        sr.dispose();
        batch.dispose();
        super.dispose();
    }



    //Getters and Setters
    public OrthographicCamera getCam() {
        return cam;
    }

    public SpriteBatch getBatch() {
        return batch;
    }


    public ShapeRenderer getSr() {
        return sr;
    }
}
