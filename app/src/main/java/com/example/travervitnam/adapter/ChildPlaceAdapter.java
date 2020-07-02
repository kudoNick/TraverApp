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
import androidx.recyclerview.widget.RecyclerView;

import com.example.travervitnam.R;
import com.example.travervitnam.moder.ChildPlace;
import com.example.travervitnam.ui.DetailChildPlaceActivity;
import com.squareup.picasso.Picasso;

import java.util.List;

public class ChildPlaceAdapter extends RecyclerView.Adapter<ChildPlaceAdapter.ChildPlaceHolder> {

    List<ChildPlace> childPlaceList;
    Context context;

    public ChildPlaceAdapter(List<ChildPlace> childPlaceList, Context context) {
        this.childPlaceList = childPlaceList;
        this.context = context;
    }

    @NonNull
    @Override
    public ChildPlaceAdapter.ChildPlaceHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.child_plae, parent, false);
        ChildPlaceHolder childPlaceHolder = new ChildPlaceHolder(view);

        return childPlaceHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ChildPlaceAdapter.ChildPlaceHolder holder, final int position) {
        final ChildPlace childPlace = childPlaceList.get(position);

        holder.tvNamePlace.setText(childPlace.getNamePlace());
        Picasso.get().load(childPlace.getImg()).into(holder.imgPlace);
        holder.tvId.setText(childPlace.getId());
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, DetailChildPlaceActivity.class);
                intent.putExtra("id", childPlace.getId());
                intent.putExtra("img", childPlace.getImg());
                intent.putExtra("namePlace", childPlace.getNamePlace());
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return childPlaceList.size();
    }

    public class ChildPlaceHolder extends RecyclerView.ViewHolder {


        TextView tvNamePlace,tvId;
        ImageView imgPlace;
        public ChildPlaceHolder(@NonNull View view) {
            super(view);
            tvId = view.findViewById(R.id.tvId);
            tvNamePlace = view.findViewById(R.id.tvNamePlace);
            imgPlace = view.findViewById(R.id.imgPlace);
        }
    }
}
