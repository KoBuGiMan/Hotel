package com.teamprooject.team.roomList;

import java.util.List;

public interface RoomListService {

    RoomList createRoomList(RoomList roomList);
    List<RoomList> getAllRoomList();
    RoomList getRoomListById(String id);
    void deleteRoomList(String id);
    List<Integer> getDateRoomList(RoomList roomList);
}
