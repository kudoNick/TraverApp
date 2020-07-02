package com.example.travervitnam.ui;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.androidnetworking.AndroidNetworking;
import com.androidnetworking.error.ANError;
import com.androidnetworking.interfaces.JSONArrayRequestListener;
import com.example.travervitnam.PlaceURL;
import com.example.travervitnam.R;
import com.example.travervitnam.adapter.ChildPlaceAdapter;
import com.example.travervitnam.moder.ChildPlace;
import com.example.travervitnam.moder.DetailChildPlace;

import org.json.JSONArray;
import org.json.JSONException;

import java.util.ArrayList;
import java.util.List;

public class ChildPlaceActivity extends AppCompatActivity {

    private TextView tvToolBar;
    private ImageView imgBack;
    private RecyclerView rcvPlace;
    Toolbar toolbar;

    List<ChildPlace> childPlaceList;
    ChildPlaceAdapter childPlaceAdapter;
    String url;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_child_place);
        overridePendingTransition(R.anim.slie_in_right,R.anim.slide_out_left);

        rcvPlace = findViewById(R.id.rcvPlace);
        toolbar = findViewById(R.id.Toolbar);
        tvToolBar=  toolbar.findViewById(R.id.tvToolbar);
        imgBack = toolbar.findViewById(R.id.imgBack);

        setSupportActionBar(toolbar);
        Intent intent = getIntent();
        String title = intent.getStringExtra("title");
        int id = intent.getIntExtra("id",0);
         url = PlaceURL.URL + id;

        getSupportActionBar().setDisplayShowTitleEnabled(false);
        tvToolBar.setText("Địa điểm du lịch ở " +title);
        imgBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });

        RecyclerView.LayoutManager layoutManager1 = new LinearLayoutManager(this, RecyclerView.VERTICAL, false);
        rcvPlace.setLayoutManager(layoutManager1);
        addChildPlace();

    }

    private void addChildPlace() {
        childPlaceList = new ArrayList<>();
        childPlaceAdapter = new ChildPlaceAdapter(childPlaceList, this);
        AndroidNetworking.get(url + "/chilPlace")
                .build()
                .getAsJSONArray(new JSONArrayRequestListener() {
                    @Override
                    public void onResponse(JSONArray response) {
                        for (int i = 0; i < response.length(); i++) {
                            try {
                                ChildPlace childPlace = new ChildPlace(response.getJSONObject(i));
                                childPlaceList.add(childPlace);
                            } catch (JSONException e) {
                                e.printStackTrace();
                            }
                        }
                        rcvPlace.setAdapter(childPlaceAdapter);
                    }

                    @Override
                    public void onError(ANError anError) {
                        Toast.makeText(ChildPlaceActivity.this, "Error", Toast.LENGTH_SHORT).show();
                    }
                });
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        overridePendingTransition(R.anim.sile_in_right_back,R.anim.slide_out_left_back);
    }
}