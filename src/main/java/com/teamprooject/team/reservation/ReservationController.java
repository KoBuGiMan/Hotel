package com.teamprooject.team.reservation;

import com.teamprooject.team.room.Room;
import com.teamprooject.team.room.RoomRepository;
import com.teamprooject.team.room.RoomService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/reservations")
public class ReservationController {
    @Autowired
    private final ReservationService reservationService;
    private final RoomService roomService;

    @PostMapping
    public Reservation createReservation(@RequestBody Reservation res) {
        return reservationService.createReservation(res);
    }
    @GetMapping
    public List<Reservation> getAllReservations(){
        return reservationService.getAllReservations();
    }
    @GetMapping("/{id}")
    public Reservation getReservationById(@PathVariable String id){
        return reservationService.getReservationById(id);
    }

    @DeleteMapping("/{id}")
    public void deleteReservationById(@PathVariable String id){
        reservationService.deleteReservationById(id);
    }

//    @PostMapping("success")
//    public void dateTest(@RequestBody Reservation res){
//        System.out.println("Received Reservation: " + res.getStartDate() + " " + res.getEndDate() + " " + res.getRoomId());
//        System.out.println(roomService.getRoomById(res.getRoomId()).getRoomRole());
//
//    }

}
