package com.mygdx.game.Parts;

/**
 * Created by sokokhoe on 6/4/2014.
 */
public class ColorPart extends Part {


    private mColor mcolor;

    public ColorPart(mColor color){
        this.mcolor=color;
    }

    public ColorPart() {this.mcolor = mColor.BLACK;}

    public void setColor(mColor mcolor){
        this.mcolor = mcolor;
    }

    public mColor getColor(){return mcolor;}
}

