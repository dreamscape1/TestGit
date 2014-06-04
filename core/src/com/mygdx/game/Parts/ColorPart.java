package com.mygdx.game.Parts;

/**
 * Created by sokokhoe on 6/4/2014.
 */
public class ColorPart extends Part {

    public enum mColor{
        GREEN,
        BLUE,
        CYAN
    }
    private mColor mcolor;

    public ColorPart(){}

    public void setColor(mColor mcolor){
        this.mcolor = mcolor;
    }

    public mColor getColor(){return mcolor;}
}

