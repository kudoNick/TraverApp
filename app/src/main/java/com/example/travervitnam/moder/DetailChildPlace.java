package com.example.travervitnam.moder;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

 public class DetailChildPlace {
    String name,img1,textImg1,img2,textImg2,comment1,comment2;

    public DetailChildPlace(JSONObject jsonObject ) throws JSONException {
        if (jsonObject.has("namePlace")) {
            name = jsonObject.getString("namePlace");
        }
        if (jsonObject.has("img1")) {
            img1 = jsonObject.getString("img1");
        }
        if (jsonObject.has("textImg1")) {
            textImg1 = jsonObject.getString("textImg1");
        }
        if (jsonObject.has("img2")) {
            img2 = jsonObject.getString("img2");
        }
        if (jsonObject.has("textImg2")) {
            textImg2 = jsonObject.getString("textImg2");
        }
        if (jsonObject.has("comment1")) {
            comment1 = jsonObject.getString("comment1");
        }
        if (jsonObject.has("comment2")) {
            comment2 = jsonObject.getString("comment2");
        }
    }

     public String getName() {
         return name;
     }

     public String getImg1() {
         return img1;
     }

     public String getTextImg1() {
         return textImg1;
     }

     public String getImg2() {
         return img2;
     }

     public String getTextImg2() {
         return textImg2;
     }

     public String getComment1() {
         return comment1;
     }

     public String getComment2() {
         return comment2;
     }
 }
