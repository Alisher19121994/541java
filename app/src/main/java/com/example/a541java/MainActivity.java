package com.example.a541java;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    RecyclerView recyclerview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initViews();
    }

    public void initViews() {
        recyclerview = findViewById(R.id.main_recyclerview);
        recyclerview.setLayoutManager(new LinearLayoutManager(this));
        getAdapter(getAllFakeDates());
    }

    void getAdapter(ArrayList<Chat_Main> list) {
        Adapter_RecyclerView adapterRecyclerView = new Adapter_RecyclerView(this, list);
        recyclerview.setAdapter(adapterRecyclerView);
    }

    ArrayList<Chat_Main> getAllFakeDates() {
        ArrayList<Chat_Main> list = new ArrayList<>();
        ArrayList<Room> rooms = new ArrayList<>();
        rooms.add(new Room(R.drawable.rasm, "Alisher Daminov", false));
        rooms.add(new Room(R.drawable.rasm, "Alisher Daminov", true));
        rooms.add(new Room(R.drawable.rasm, "Alisher Daminov", false));
        rooms.add(new Room(R.drawable.rasm, "Alisher Daminov", false));
        rooms.add(new Room(R.drawable.rasm, "Alisher Daminov", false));
        rooms.add(new Room(R.drawable.rasm, "Alisher Daminov", true));
        rooms.add(new Room(R.drawable.rasm, "Alisher Daminov", false));
        rooms.add(new Room(R.drawable.rasm, "Alisher Daminov", true));
        rooms.add(new Room(R.drawable.rasm, "Alisher Daminov", false));
        rooms.add(new Room(R.drawable.rasm, "Alisher Daminov", true));
        rooms.add(new Room(R.drawable.rasm, "Alisher Daminov", false));
        rooms.add(new Room(R.drawable.rasm, "Alisher Daminov", false));
        rooms.add(new Room(R.drawable.rasm, "Alisher Daminov", true));
        list.add(new Chat_Main(rooms));
        list.add(new Chat_Main(new Messages(R.drawable.rasm, "Alisher Daminov", "Abbos has just sent message", false)));
        list.add(new Chat_Main(new Messages(R.drawable.rasm, "Alisher Daminov", "Abbos has just sent message", false)));
        list.add(new Chat_Main(new Messages(R.drawable.rasm, "Alisher Daminov", "Abbos has just sent message", false)));
        list.add(new Chat_Main(new Messages(R.drawable.rasm, "Alisher Daminov", "Abbos has just sent message", false)));
        list.add(new Chat_Main(new Messages(R.drawable.rasm, "Alisher Daminov", "Abbos has just sent message", true)));
        list.add(new Chat_Main(new Messages(R.drawable.rasm, "Alisher Daminov", "Abbos has just sent message", false)));
        list.add(new Chat_Main(new Messages(R.drawable.rasm, "Alisher Daminov", "Abbos has just sent message", true)));
        list.add(new Chat_Main(new Messages(R.drawable.rasm, "Alisher Daminov", "Abbos has just sent message", false)));
        list.add(new Chat_Main(new Messages(R.drawable.rasm, "Alisher Daminov", "Abbos has just sent message", false)));
        list.add(new Chat_Main(new Messages(R.drawable.rasm, "Alisher Daminov", "Abbos has just sent message", false)));
        list.add(new Chat_Main(new Messages(R.drawable.rasm, "Alisher Daminov", "Abbos has just sent message", true)));
        list.add(new Chat_Main(new Messages(R.drawable.rasm, "Alisher Daminov", "Abbos has just sent message", false)));
        list.add(new Chat_Main(new Messages(R.drawable.rasm, "Alisher Daminov", "Abbos has just sent message", true)));
        list.add(new Chat_Main(new Messages(R.drawable.rasm, "Alisher Daminov", "Abbos has just sent message", false)));
        list.add(new Chat_Main(new Messages(R.drawable.rasm, "Alisher Daminov", "Abbos has just sent message", false)));
        list.add(new Chat_Main(new Messages(R.drawable.rasm, "Alisher Daminov", "Abbos has just sent message", false)));
        list.add(new Chat_Main(new Messages(R.drawable.rasm, "Alisher Daminov", "Abbos has just sent message", true)));
        list.add(new Chat_Main(new Messages(R.drawable.rasm, "Alisher Daminov", "Abbos has just sent message", false)));
        list.add(new Chat_Main(new Messages(R.drawable.rasm, "Alisher Daminov", "Abbos has just sent message", false)));
        return list;
    }
}