package com.teamprooject.team.roomList;


import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("roomList")
@RequiredArgsConstructor
public class RoomListController {

    @Autowired
    private final RoomListService roomListService;

    @PostMapping
    public RoomList createRoomList(@RequestBody RoomList roomList){
        return roomListService.createRoomList(roomList);
    }
    @GetMapping
    public List<RoomList> getAllRoomList() {
        return roomListService.getAllRoomList();
    }

    @GetMapping("/{id}")
    public RoomList getRoomListById(@PathVariable String id){
        return roomListService.getRoomListById(id);
    }

    @DeleteMapping("/{id}")
    public void deleteRoomById(@PathVariable String id){
        roomListService.deleteRoomList(id);
    }

    @PostMapping("/dateCheck")
    public List<Integer> getDateRoomList(@RequestBody RoomList roomList) {
        return roomListService.getDateRoomList(roomList);
    }

    @PostMapping("/nowDateCheck")
    public List<Integer> getNowDateRoomList() {
        return roomListService.getNowDateRoomList();
    }
}
