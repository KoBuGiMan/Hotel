package com.teamprooject.team.roomList;

import com.teamprooject.team.room.RoomService;
import lombok.RequiredArgsConstructor;
import org.springframework.cglib.core.Local;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class RoomListServiceImpl implements RoomListService {

    private final RoomListRepository roomListRepository;
    private final MongoTemplate mongoTemplate;
    private final RoomService roomService;

    @Override
    public RoomList createRoomList(RoomList roomList) {
        return roomListRepository.save(roomList);
    }

    @Override
    public List<RoomList> getAllRoomList() {
        return roomListRepository.findAll();
    }

    @Override
    public RoomList getRoomListById(String id) {
        return roomListRepository.findById(id).orElse(null);
    }

    @Override
    public void deleteRoomList(String id) {
        roomListRepository.deleteById(id);
    }

    @Override
    public List<Integer> getDateRoomList(RoomList roomList) {
        int standardCnt = 0;
        int deluxeCnt = 0;
        int luxuryCnt = 0;

        List<RoomList> allRoomLists = getAllRoomList();

        for (LocalDate date = roomList.getStartDate(); !date.isAfter(roomList.getEndDate()); date = date.plusDays(1)) {
            for (RoomList rl : allRoomLists) {
                if (rl.getDate().equals(date)) {
                    if (standardCnt < rl.getRoom().get(0).getRoomCount()) {
                        standardCnt = rl.getRoom().get(0).getRoomCount();
                    }
                    if (deluxeCnt < rl.getRoom().get(1).getRoomCount()) {
                        deluxeCnt = rl.getRoom().get(1).getRoomCount();
                    }
                    if (luxuryCnt < rl.getRoom().get(2).getRoomCount()) {
                        luxuryCnt = rl.getRoom().get(2).getRoomCount();
                    }
                }
            }
        }

        List<Integer> list = new ArrayList<>();
        list.add(standardCnt);
        list.add(deluxeCnt);
        list.add(luxuryCnt);
        return list;
    }

    @Override
    public List<Integer> getNowDateRoomList(){

        int standardCnt = 0;
        int deluxeCnt = 0;
        int luxuryCnt = 0;

        List<RoomList> allRoomLists = getAllRoomList();
        LocalDate nowDate= LocalDate.now();


        for(RoomList roomList : allRoomLists){
            LocalDate roomDate = roomList.getDate();
            if(roomDate.equals(nowDate)) {
                standardCnt = roomList.getRoom().get(0).getRoomCount();
                deluxeCnt = roomList.getRoom().get(1).getRoomCount();
                luxuryCnt = roomList.getRoom().get(2).getRoomCount();
            }
        }
        List<Integer> list = new ArrayList<>();
        list.add(standardCnt);
        list.add(deluxeCnt);
        list.add(luxuryCnt);


        return list;
    }


    public void mongoRoomListInsert() {
        ZoneId seoulZoneId = ZoneId.of("Asia/Seoul");
        LocalDate startDate = LocalDate.now(seoulZoneId);
        LocalDate endDate = startDate.plusMonths(1);
        for (LocalDate date = startDate; !date.isAfter(endDate); date = date.plusDays(1)) {
            RoomList roomList = new RoomList();
            roomList.setDate(date);
            roomList.setRoom(roomService.getAllRooms());
            mongoTemplate.insert(roomList);
        }
    }

    public void mongoRoomListFix(){
        ZoneId seoulZoneId = ZoneId.of("Asia/Seoul");
        LocalDate startDate = LocalDate.now(seoulZoneId);
        LocalDate endDate = startDate.plusMonths(1);
        if(getAllRoomList().getLast().getDate().compareTo(endDate) < 0){
            LocalDate startedDate = getAllRoomList().getLast().getDate().plusDays(1);
            for (LocalDate date = startedDate; !date.isAfter(endDate); date = date.plusDays(1)){
                RoomList roomList = new RoomList();
                roomList.setDate(date);
                roomList.setRoom(roomService.getAllRooms());
                mongoTemplate.insert(roomList);
                System.out.println("Fix Success");
            }
        }
    }

    public void mongoRoomListDelete(){
        ZoneId seoulZoneId = ZoneId.of("Asia/Seoul");
        LocalDate now = LocalDate.now(seoulZoneId);
        for(int i = 0; i <getAllRoomList().toArray().length; i++ ){
            if(getAllRoomList().get(i).getDate().compareTo(now) < 0){
                mongoTemplate.remove(getAllRoomList().get(i));
                System.out.println("Delete Success");
            }
        }
    }

    @Scheduled(cron = "1 0 0 * * *", zone = "Asia/Seoul")
    public void run(){
        ZoneId seoulZoneId = ZoneId.of("Asia/Seoul");
        LocalDate startDate = LocalDate.now(seoulZoneId);
        LocalDate addDate = startDate.plusMonths(1);
        LocalDate deleteDate = startDate.minusDays(1);
        RoomList roomList = new RoomList();
        roomList.setDate(addDate);
        roomList.setRoom(roomService.getAllRooms());

        for(int i=0; i < getAllRoomList().toArray().length; i++){
            if(getAllRoomList().get(i).getDate().compareTo(deleteDate) < 0){
                deleteRoomList(getAllRoomList().get(i).getId());
            }
        }
        mongoTemplate.insert(roomList);

    }


}
