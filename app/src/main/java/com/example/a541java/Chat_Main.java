package com.example.a541java;

import java.util.ArrayList;

public class Chat_Main {
    Messages messages;
    ArrayList<Room> rooms;

    public Chat_Main(Messages messages) {
        this.messages = messages;
    }

    public Chat_Main(ArrayList<Room> rooms) {
        this.rooms = rooms;
    }
}
