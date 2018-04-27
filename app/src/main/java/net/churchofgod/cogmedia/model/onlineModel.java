package net.churchofgod.cogmedia.model;

import org.json.JSONObject;

/**
 * Created by liemvo on 10/3/16.
 */
public class onlineModel {
    private int id;
    private String imageUrl;
    private String title;

    public onlineModel(){

    }

    public onlineModel(JSONObject jsonObject){
        if(jsonObject == null) return;
        this.id = jsonObject.optInt("id");
        this.imageUrl = jsonObject.optString("image");
        this.title = jsonObject.optString("title");
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}