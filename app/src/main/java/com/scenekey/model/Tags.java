package com.scenekey.model;

import java.io.Serializable;

/**
 * Created by mindiii on 15/2/18.
 */

public class Tags implements Serializable {

    public String id ;
    public String tag ;
    public boolean selected;

    public Tags() {
    }

    public Tags(String id, String tag, boolean selected) {
        this.id = id;
        this.tag = tag;
        this.selected = selected;
    }

    @Override
    public String toString() {
        return  id+"";
    }

}
