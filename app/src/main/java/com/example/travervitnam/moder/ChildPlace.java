package com.example.travervitnam.moder;

import org.json.JSONException;
import org.json.JSONObject;

public class ChildPlace {
    String namePlace,img,id;

    public ChildPlace(JSONObject jsonObject) throws JSONException {
        if (jsonObject.has("namePlace")) {
            namePlace = jsonObject.getString("namePlace");
        }
        if (jsonObject.has("img")) {
            img = jsonObject.getString("img");
        }
        if (jsonObject.has("id")) {
            id = jsonObject.getString("id");
        }
    }

    public String getNamePlace() {
        return namePlace;
    }

    public String getImg() {
        return img;
    }

    public String getId() {
        return id;
    }
}
