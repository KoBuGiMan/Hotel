package com.teamprooject.team.room;

import lombok.RequiredArgsConstructor;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class RoomServiceImpl implements RoomService{

    private final RoomRepository roomRepository;
    private final MongoTemplate mongoTemplate;
    @Override
    public Room createRoom(Room room) {
        return roomRepository.save(room);
    }

    @Override
    public List<Room> getAllRooms() {
        return roomRepository.findAll();
    }

    @Override
    public Room getRoomById(String id) {
        return roomRepository.findById(id).orElse(null);
    }

    @Override
    public void deleteRoomById(String id) {
        roomRepository.deleteById(id);
    }

//    public void mongoRoomInsert(){
//        Room room1 = new Room();
//        room1.setRoomNum(201);
//        room1.setRoomCount(3);
//        room1.setRoomPrice(80_000);
//        room1.setRoomRole(RoomRole.STANDARD);
//
//        Room room2 = new Room();
//        room2.setRoomNum(302);
//        room2.setRoomCount(4);
//        room2.setRoomPrice(100_000);
//        room2.setRoomRole(RoomRole.DELUXE);
//
//        Room room3 = new Room();
//        room3.setRoomNum(401);
//        room3.setRoomCount(120_000);
//        room3.setRoomRole(RoomRole.LUXURY);
//
//        mongoTemplate.insert(room1);
//        mongoTemplate.insert(room2);
//        mongoTemplate.insert(room3);
//
//    }


}
