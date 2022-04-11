package com.techstart.museum;

import java.util.List;

public class Room {
    int roomNumber;
    List<Room> connRooms;
    boolean exitRoom;

    public Room(int roomNumber, List<Room> connRooms, boolean isExitRoom) {
        this.roomNumber = roomNumber;
        this.connRooms = connRooms;
        this.exitRoom = isExitRoom;
    }

    public void setExitRoom(){
        this.exitRoom = true;
    }
}

