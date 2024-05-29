package com.teamprooject.team.room;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;


@Document(collection = "rooms")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class Room {

    @Id
    private String id;
    private int roomNum;
    private int roomPrice;
    private int roomCount;
    private RoomRole roomRole;


}
