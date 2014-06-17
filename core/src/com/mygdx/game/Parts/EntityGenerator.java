package com.mygdx.game.Parts;

import com.badlogic.gdx.math.MathUtils;

/**
 * Created by sokokhoe on 6/6/2014.
 */
public class EntityGenerator {

    public static int entityCount=0;
    private boolean isRandom;


    public static Entity create(boolean isRandom, float x, float y, float radius, mColor color){

        Entity newEntity = new Entity();
        //newEntity.get(Part.class).setAlive(true);
        newEntity.attach(new AlivePart(true));
        newEntity.attach(new PositionPart(x,y));
        newEntity.attach(new ColorPart());
        newEntity.attach(new CirclePart(radius));
        newEntity.attach(new DescriptionPart());
        newEntity.attach(new RowColumn());
        newEntity.get(DescriptionPart.class).setID("#" + entityCount);
        entityCount++;


        if(isRandom) {
            if (color == null) {
                int randomNum = MathUtils.random(2);

                switch (randomNum) {
                    case 0:
                        newEntity.get(ColorPart.class).setColor(mColor.GREEN);
                        break;
                    case 1:
                        newEntity.get(ColorPart.class).setColor(mColor.BLUE);
                        break;
                    case 2:
                        newEntity.get(ColorPart.class).setColor(mColor.CYAN);
                        break;
                    case 3:
                        assert false;
                        break;
                    default:
                        assert false;
                        break;

                }
            } else {
                throw new IllegalArgumentException("Entity Generator: Cannot set color when isRandom is true");
            }
        }else{
            newEntity.get(ColorPart.class).setColor(color);
        }

        return newEntity;
    }
}
