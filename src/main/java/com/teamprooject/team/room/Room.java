package com.teamprooject.team.room;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;


@Document(collection = "rooms")

public class Room {

    @Id
    private String id;
    private int roomPrice;
    private int roomCount;
    private RoomRole roomRole;

    public Room() {}

    public Room( int roomPrice, int roomCount,RoomRole roomRole) {
        this.roomPrice = roomPrice;
        this.roomCount = roomCount;
        this.roomRole = roomRole;
    }
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getRoomPrice() {
        return roomPrice;
    }

    public void setRoomPrice(int roomPrice) {
        this.roomPrice = roomPrice;
    }

    public int getRoomCount() {
        return roomCount;
    }

    public void setRoomCount(int roomCount) {
        this.roomCount = roomCount;
    }

    public RoomRole getRoomRole() {
        return roomRole;
    }

    public void setRoomRole(RoomRole roomRole) {
        this.roomRole = roomRole;
    }
}
