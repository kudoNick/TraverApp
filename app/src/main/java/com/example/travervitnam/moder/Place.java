package com.example.travervitnam.moder;

import org.json.JSONException;
import org.json.JSONObject;

public class Place {
    private String place,img,id;


    public Place(JSONObject jsonObject) throws JSONException {

        if (jsonObject.has("place")) {
            place = jsonObject.getString("place");
        }
        if (jsonObject.has("img")) {
            img = jsonObject.getString("img");
        }
        if (jsonObject.has("id")) {
            id = jsonObject.getString("id");
        }
    }

    public String getPlace() {
        return place;
    }

    public String getImg() {
        return img;
    }

    public String getId() {
        return id;
    }
}
