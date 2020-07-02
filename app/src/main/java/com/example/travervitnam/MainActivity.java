package com.example.travervitnam;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import android.app.Dialog;
import android.os.Bundle;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.androidnetworking.AndroidNetworking;
import com.androidnetworking.error.ANError;
import com.androidnetworking.interfaces.JSONArrayRequestListener;
import com.example.travervitnam.adapter.PlaceAdapter;
import com.example.travervitnam.moder.Place;
import com.roger.gifloadinglibrary.GifLoadingView;

import org.json.JSONArray;
import org.json.JSONException;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    List<Place> placeList;
    PlaceAdapter placeAdapter;
    Place place;
    private RecyclerView rcvPlace;
    private ProgressBar progressBar;
    private GifLoadingView gifLoadingView;
    Dialog dialog;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        gifLoadingView = new GifLoadingView();

        rcvPlace = findViewById(R.id.rcvPlace);
        progressBar = findViewById(R.id.pgBar);

        StaggeredGridLayoutManager gridLayoutManager = new StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL);
        rcvPlace.setHasFixedSize(true);
        rcvPlace.setLayoutManager(gridLayoutManager);
        addPlace();

//        gifLoadingView.setImageResource(R.drawable.num5);
//        gifLoadingView.show(getFragmentManager());

        dialog = new Dialog(this);
        dialog.setContentView(R.layout.loading);
        dialog.setCancelable(false);
        dialog.show();
    }

    private void addPlace(){
        placeList = new ArrayList<>();
        AndroidNetworking.get(PlaceURL.URL)
                .build()
                .getAsJSONArray(new JSONArrayRequestListener() {
                    @Override
                    public void onResponse(JSONArray response) {
                        for (int i = 0; i <response.length() ; i++) {
                            try {
                                place = new Place(response.getJSONObject(i));
                                placeList.add(place);
                                progressBar.setVisibility(View.GONE);
                                dialog.cancel();
                            } catch (JSONException e) {

                                e.printStackTrace();
                            }
                        }
                        placeAdapter = new PlaceAdapter(placeList, MainActivity.this);
                        rcvPlace.setAdapter(placeAdapter);
                    }

                    @Override
                    public void onError(ANError anError) {
                        Toast.makeText(MainActivity.this, "Error", Toast.LENGTH_SHORT).show();
                    }
                });
    }
}