package com.example.a541java;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.imageview.ShapeableImageView;

import java.util.ArrayList;

public class Adapter_RecyclerView extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    Context context;
    ArrayList<Chat_Main> list;

    public Adapter_RecyclerView(Context context, ArrayList<Chat_Main> list) {
        this.context = context;
        this.list = list;

    }

    int ROOM = 0;
    int MESSAGE = 1;


    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        if (viewType == ROOM) {
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.room_recyclerview, parent, false);
            return new MyRoomHorizontalHolder(view);
        }
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.message_vertical, parent, false);
        return new MyMessageVerticalHolder(view);

    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        Chat_Main chat_main = list.get(position);

        if (holder instanceof MyRoomHorizontalHolder) {
            RecyclerView recyclerView = ((MyRoomHorizontalHolder) holder).recyclerView;
            bringSecondADAPTER(chat_main.rooms, recyclerView);
        }

        if (holder instanceof MyMessageVerticalHolder) {
            ((MyMessageVerticalHolder) holder).shapeableImageView.setImageResource(chat_main.messages.messageImage);
            ((MyMessageVerticalHolder) holder).fullname.setText(chat_main.messages.fullname);
            ((MyMessageVerticalHolder) holder).text.setText(chat_main.messages.messages);

            /*if (room.is_onlineRoom){
                ((MyRoomHolder) holder).online.getVisibility() = View.VISIBLE;
            }*/
        }
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    class MyMessageVerticalHolder extends RecyclerView.ViewHolder {
        ShapeableImageView shapeableImageView;
        TextView fullname;
        LinearLayout online;
        TextView text;

        public MyMessageVerticalHolder(@NonNull View itemView) {
            super(itemView);
            shapeableImageView = itemView.findViewById(R.id.message_image_id);
            fullname = itemView.findViewById(R.id.message_fullname);
            text = itemView.findViewById(R.id.message_text_id);
            online = itemView.findViewById(R.id.message_is_online);
        }
    }

    class MyRoomHorizontalHolder extends RecyclerView.ViewHolder {
        RecyclerView recyclerView;

        public MyRoomHorizontalHolder(@NonNull View itemView) {
            super(itemView);
            recyclerView = itemView.findViewById(R.id.recyclerview);
            recyclerView.setLayoutManager(new LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false));
        }
    }

    boolean isHeader(int position) {
        return position == 0;
    }

    @Override
    public int getItemViewType(int position) {
        if (isHeader(position)) return ROOM;
        if (list.isEmpty()) {
            return MESSAGE;
        }
        return MESSAGE;
    }

    void bringSecondADAPTER(ArrayList<Room> rooms, RecyclerView recyclerView) {
        RoomAdapter roomAdapter = new RoomAdapter(context, rooms);
        recyclerView.setAdapter(roomAdapter);
    }
}
