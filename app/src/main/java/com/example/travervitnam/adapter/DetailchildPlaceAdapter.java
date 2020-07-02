package com.example.travervitnam.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.travervitnam.R;
import com.example.travervitnam.moder.DetailChildPlace;
import com.squareup.picasso.Picasso;

import java.util.List;

public class DetailchildPlaceAdapter extends RecyclerView.Adapter<DetailchildPlaceAdapter.DetailchildPlaceHolder> {

    List<DetailChildPlace> detailChildPlaceList;
    Context context;

    public DetailchildPlaceAdapter(List<DetailChildPlace> detailChildPlaceList, Context context) {
        this.detailChildPlaceList = detailChildPlaceList;
        this.context = context;
    }

    @NonNull
    @Override
    public DetailchildPlaceAdapter.DetailchildPlaceHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.detail_child_place, parent, false);
        DetailchildPlaceHolder detailchildPlaceHolder = new DetailchildPlaceHolder(view);
        return detailchildPlaceHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull DetailchildPlaceAdapter.DetailchildPlaceHolder holder, int position) {
        DetailChildPlace detailChildPlace = detailChildPlaceList.get(position);

        holder.tvComment1.setText(detailChildPlace.getComment1());
        holder.tvComment2.setText(detailChildPlace.getComment2());
        holder.tvImg1.setText(detailChildPlace.getTextImg1());
        holder.tvImg2.setText(detailChildPlace.getTextImg2());

        Picasso.get().load(detailChildPlace.getImg1()).into(holder.img1);
        Picasso.get().load(detailChildPlace.getImg2()).into(holder.img2);
    }

    @Override
    public int getItemCount() {
        return detailChildPlaceList.size();
    }

    public class DetailchildPlaceHolder extends RecyclerView.ViewHolder {

        private TextView tvComment1;
        private TextView tvComment2;
        private TextView tvImg1;
        private TextView tvImg2;
        private ImageView img1,img2;
        public DetailchildPlaceHolder(@NonNull View itemView) {
            super(itemView);

            tvComment1 = itemView.findViewById(R.id.tvComment1);
            tvComment2 = itemView.findViewById(R.id.tvComment2);
            tvImg1 = itemView.findViewById(R.id.tvImg1);
            tvImg2 = itemView.findViewById(R.id.tvImg2);
            img1 = itemView.findViewById(R.id.img1);
            img2 = itemView.findViewById(R.id.img2);
        }
    }
}
