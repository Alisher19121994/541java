package com.example.a541java;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.imageview.ShapeableImageView;

import java.util.ArrayList;

public class RoomAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    Context context;
    ArrayList<Room> list;

    public RoomAdapter(Context context, ArrayList<Room> list) {
        this.context = context;
        this.list = list;
    }

    int CREATE = 0;
    int ROOM = 1;

    class MyRoomHolder extends RecyclerView.ViewHolder {
        ShapeableImageView shapeableImageView;
        TextView fullname;
        LinearLayout online;

        public MyRoomHolder(@NonNull View itemView) {
            super(itemView);
            shapeableImageView = itemView.findViewById(R.id.room_image_id);
            fullname = itemView.findViewById(R.id.room_text_fullname_id);
            online = itemView.findViewById(R.id.is_online);
        }
    }

    class MyCreateHolderView extends RecyclerView.ViewHolder {

        public MyCreateHolderView(@NonNull View itemView) {
            super(itemView);
        }
    }

    boolean isHeader(int position) {
        return position == 0;
    }

    @Override
    public int getItemViewType(int position) {
        if (isHeader(position)) return CREATE;
        if (list.isEmpty()) {
            return ROOM;
        }
        return ROOM;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
       if (viewType ==CREATE){
           View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.create,parent,false);
           return new MyCreateHolderView(view);
       }
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.room,parent,false);
        return new MyRoomHolder(view);

    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        Room room = list.get(position);
        if (holder instanceof MyRoomHolder){
            ((MyRoomHolder) holder).shapeableImageView.setImageResource(room.image);
            ((MyRoomHolder) holder).fullname.setText(room.fullname);

        }
    }

    @Override
    public int getItemCount() {
        return list.size();
    }
}
