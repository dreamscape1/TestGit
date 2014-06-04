package com.mygdx.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;

import java.util.ArrayList;
import java.util.Random;

public class MyGdxGame extends ApplicationAdapter {


    private SpriteBatch batch;
	private Texture img;
    private BasicObject obj;
    private  BasicObjectManager obm;
    private Gem gem;
    private ArrayList<Gem> gems;
    private ShapeRenderer sr;
    private int x1=0,x2=0,y1=0,y2=0;
    private int touchCnt=0;
    private BitmapFont bmf;
    private Gem gembuff1;
    private Gem gembuff2;
    private boolean swappable;
    private ArrayList<Gem> buffGem;
    private int gem1loc,gem2loc;
    //public static TextureLoader textureManager;



    private OrthographicCamera cam;
    float delta;
	
	@Override
	public void create () {
        gems= new ArrayList<Gem>();
        buffGem = new ArrayList<Gem>();
		batch = new SpriteBatch();
        sr = new ShapeRenderer();
        cam = new OrthographicCamera();
        cam.setToOrtho(false,640,480);
        delta=0;
        obm = new BasicObjectManager(this);
        obj = new BasicObject();
        obm.addObject(obj);
        int heightblock = 480/8;
        int widthblock = 640/8;
        bmf= new BitmapFont();

        // Testing purpose
        /*Gem gem1 =new Gem(0,0,50,sr,cam);
        Gem gem2 = new Gem(400,400,50,sr,cam);
        gems.add(gem1);
        gems.add(gem2);*/

        Random rand = new Random();
        for(int y = 1;y<8;y++){
            for(int x=1;x<8;x++){
                Gem gem = new Gem(x*widthblock,y*heightblock,20,sr,cam,rand.nextInt(3));
                gems.add(gem);
            }
        }
	}

	@Override
	public void render () {


        Gdx.graphics.setTitle("Test LibGdx -- FPS :"+ Gdx.graphics.getFramesPerSecond());
		Gdx.gl.glClearColor(1, 0, 0, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        cam.update();
        batch.setProjectionMatrix(cam.combined);

        //gem.draw(cam);
        sr.begin(ShapeRenderer.ShapeType.Filled);
        /*for(Gem gem: gems){
            gem.update();
            if(gem.getTouched()){
                System.out.println("X: "+gem.getX()+" -- Y: "+gem.getY());
                if(touchCnt<1)
                {
                    System.out.println("touched");
                    touchCnt++;
                    gembuff1=gem;
                    x1= (int)gem.getX();
                    y1=(int) gem.getY();
                }
                if(touchCnt==1){
                    //System.out.println("Waiting for second pos");
                    //touchCnt++;
                    if(gem!=gembuff1){
                        gembuff2=gem;
                        x2 = (int) gem.getX();
                        y2 = (int) gem.getY();
                        System.out.println("Gem1 (x,y) = " + x1 + "," + x2 + " --- Gem2 (x,y) = " + x2 + "," + y2);
                        touchCnt=0;
                        swappable=true;
                    }
                }

            }
            gem.draw();
        }*/

        for(int i =0;i< gems.size();i++){
            gems.get(i).update();
            if(gems.get(i).getTouched()){
                System.out.println("X: " + gems.get(i).getX() + " -- Y: " + gems.get(i).getY());
                if(touchCnt<1)
                {
                    System.out.println("touched");
                    touchCnt++;
                    //gembuff1=gem;
                    x1= (int)gems.get(i).getX();
                    y1=(int) gems.get(i).getY();
                    gem1loc=i;
                    gems.get(i).setTouch(false);
                }
                if(touchCnt==1){
                    //System.out.println("Waiting for second pos");
                    //touchCnt++;
                    if(i!=gem1loc){
                        //gembuff2=gem;
                        x2 = (int) gems.get(i).getX();
                        y2 = (int) gems.get(i).getY();
                        gem2loc=i;
                        System.out.println("Gem1 (x,y) = " + x1 + "," + x2 + " --- Gem2 (x,y) = " + x2 + "," + y2);
                        touchCnt=0;
                        swappable=true;
                        gems.get(i).setTouch(false);
                    }
                }
            }
            gems.get(i).draw();
        }

        if(swappable){
            /*
            gembuff1.setX(x2);
            gembuff1.setY(y2);

            gembuff2.setX(x1);
            gembuff2.setY(y1);*/


            gems.get(gem1loc).setX(x2);
            gems.get(gem1loc).setY(y2);

            gems.get(gem2loc).setX(x1);
            gems.get(gem2loc).setY(y1);

            try{
                Thread.sleep(32);
            }catch(Exception e){}

            gems.get(gem1loc).setTouch(true);
            gems.get(gem2loc).setTouch(true);

            x1=x2=y1=y2=0;
            //gembuff1=null;
            //gembuff2=null;
            swappable = false;

        }

        sr.end();
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
        for(Gem gem : gems){
            gem=null;
        }
    }

    public OrthographicCamera getCam() {
        return cam;
    }

    public SpriteBatch getBatch() {
        return batch;
    }
}
