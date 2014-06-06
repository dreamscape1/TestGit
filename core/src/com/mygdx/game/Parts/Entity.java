package com.mygdx.game.Parts;

import java.util.HashMap;

/**
 * Created by sokokhoe on 6/4/2014.
 */
public class Entity {


    private HashMap<Class<? extends Part>, Part> parts = new HashMap<Class<? extends Part>, Part>();

    public void attach(Part part) {
        if (has(part.getClass())) {
            throw new IllegalArgumentException("Part :" +part.getClass().getName() +" is already exist");
        }

        parts.put(part.getClass(),part);
    }

    @SuppressWarnings("unchecked")
    public <T extends Part> T get(Class<T>partClass){
        if(!has(partClass)){
            throw new IllegalArgumentException("Part : "+partClass.getClass().getName()+" could not be found");
        }
        return (T)parts.get(partClass);

    }

    public <T extends Part> boolean has(Class<T>partClass){
         return parts.containsKey(partClass);
     }
}
