package com.example.travervitnam.ui;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.androidnetworking.AndroidNetworking;
import com.androidnetworking.error.ANError;
import com.androidnetworking.interfaces.JSONArrayRequestListener;
import com.androidnetworking.interfaces.JSONObjectRequestListener;
import com.example.travervitnam.R;
import com.example.travervitnam.adapter.ChildPlaceAdapter;
import com.example.travervitnam.adapter.DetailchildPlaceAdapter;
import com.example.travervitnam.moder.ChildPlace;
import com.example.travervitnam.moder.DetailChildPlace;
import com.squareup.picasso.Picasso;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class DetailChildPlaceActivity extends AppCompatActivity {


    private Toolbar toolbar;
    private RecyclerView rcvPlace;
    private ImageView imgPlace,imgBack;

    private List<DetailChildPlace> detailChildPlaceList;
    private DetailchildPlaceAdapter detailchildPlaceAdapter;

    private ProgressBar progressBar;

    String url = "https://my-json-server.typicode.com/kudoNick/sever1/detailPlace/";
    String url1 ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_child_place);
        overridePendingTransition(R.anim.slie_up,R.anim.slide_down);

        progressBar = findViewById(R.id.progressBar);
        imgPlace = findViewById(R.id.imgPlace);
        rcvPlace = findViewById(R.id.rcvPlace);
        toolbar = findViewById(R.id.Toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(false);


        Intent intent = getIntent();
        String img = intent.getStringExtra("img");
        String nameplace = intent.getStringExtra("namePlace");
        url1 = url + intent.getStringExtra("id");

        Toast.makeText(this, url1, Toast.LENGTH_SHORT).show();
        toolbar.setTitle(nameplace);

        Picasso.get().load(img).into(imgPlace);

        imgBack = toolbar.findViewById(R.id.imgBack);
        imgBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });

        RecyclerView.LayoutManager layoutManager1 = new LinearLayoutManager(this, RecyclerView.VERTICAL, false);
        rcvPlace.setLayoutManager(layoutManager1);

        addDetailChildPlace();
    }

    private void addDetailChildPlace() {
        detailChildPlaceList = new ArrayList<>();
        detailchildPlaceAdapter = new DetailchildPlaceAdapter(detailChildPlaceList, this);
        AndroidNetworking.get(url1)
                .build()
                .getAsJSONObject(new JSONObjectRequestListener() {
                    @Override
                    public void onResponse(JSONObject response) {
                        try {
                            DetailChildPlace detailChildPlace = new DetailChildPlace(response);
                            detailChildPlaceList.add(detailChildPlace);
                            progressBar.setVisibility(View.GONE);
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                        rcvPlace.setAdapter(detailchildPlaceAdapter);
                    }

                    @Override
                    public void onError(ANError anError) {
//                        Toast.makeText(DetailChildPlaceActivity.this, "Error", Toast.LENGTH_SHORT).show();
                    }
                });
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        overridePendingTransition(R.anim.slie_up_back,R.anim.slide_down_back);
    }
}