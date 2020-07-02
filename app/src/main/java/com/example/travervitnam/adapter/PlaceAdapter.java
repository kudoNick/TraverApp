package com.example.travervitnam.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.Placeholder;
import androidx.recyclerview.widget.RecyclerView;

import com.example.travervitnam.R;
import com.example.travervitnam.moder.Place;
import com.example.travervitnam.ui.ChildPlaceActivity;
import com.squareup.picasso.Picasso;

import java.util.List;

public class PlaceAdapter extends RecyclerView.Adapter<PlaceAdapter.PlaceViewHolder>{

    List<Place> placeList;
    Context context;

    public PlaceAdapter(List<Place> placeList, Context context) {
        this.placeList = placeList;
        this.context = context;
    }

    @NonNull
    @Override
    public PlaceAdapter.PlaceViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.place, parent, false);
        PlaceViewHolder placeViewHolder = new PlaceViewHolder(view);
        return placeViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull PlaceAdapter.PlaceViewHolder holder, final int position) {
        final Place place = placeList.get(position);

        holder.tvPlace.setText(place.getPlace());
        Picasso.get().load(place.getImg()).into(holder.imgPlace);

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, ChildPlaceActivity.class);
                intent.putExtra("title",place.getPlace());
                intent.putExtra("id",position +1);
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return placeList.size();
    }

    public class PlaceViewHolder extends RecyclerView.ViewHolder {
        private TextView tvPlace;
        private ImageView imgPlace;
        public PlaceViewHolder(@NonNull View view) {
            super(view);
            tvPlace = view.findViewById(R.id.tvPlace);
            imgPlace = view.findViewById(R.id.imgPlace);
        }
    }
}
