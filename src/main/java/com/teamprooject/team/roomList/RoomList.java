package com.teamprooject.team.roomList;


import com.teamprooject.team.room.Room;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;
import java.util.List;

@Document(collection = "roomList")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class RoomList {

    @Id
    private String id;
    private LocalDate date;
    private List<Room> room;
    private LocalDate startDate;
    private LocalDate endDate;

}
