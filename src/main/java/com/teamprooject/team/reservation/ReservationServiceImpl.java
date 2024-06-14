package com.teamprooject.team.reservation;

import com.teamprooject.team.room.RoomRole;
import lombok.RequiredArgsConstructor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReservationServiceImpl  implements ReservationService{

	@Autowired
    private final ReservationRepository reservationRepository;
    private final MongoTemplate mongoTemplate;

    public ReservationServiceImpl(ReservationRepository reservationRepository, MongoTemplate mongoTemplate){
        this.reservationRepository = reservationRepository;
        this.mongoTemplate = mongoTemplate;
    }

    @Override
    public Reservation createReservation(Reservation res) {
        return reservationRepository.save(res);
    }

    @Override
    public List<Reservation> getAllReservations() {
        return reservationRepository.findAll();
    }

    @Override
    public Reservation getReservationById(String id) {
        return reservationRepository.findById(id).orElse(null);
    }

    @Override
    public void deleteReservationById(String id) {
       reservationRepository.deleteById(id);
    }



    public void mongoReservationInsert(){
        Reservation res = new Reservation();
        res.setFirstName("rla");
        res.setLastName("xogh");
        res.setEmail("rlaxogh@naver.com");
        res.setPhone("01011111111");
        res.setRoomPrice(80000);
        res.setRoomCount(1);
        res.setRoomRole(RoomRole.STANDARD);

        Reservation res2 = new Reservation();
        res2.setFirstName("rla");
        res2.setLastName("xogh");
        res2.setEmail("rlaxogh@naver.com");
        res2.setPhone("01011111111");
        res2.setRoomPrice(100000);
        res2.setRoomCount(1);
        res2.setRoomRole(RoomRole.DELUXE);

        Reservation res3 = new Reservation();
        res3.setFirstName("rla");
        res3.setLastName("xogh");
        res3.setEmail("rlaxogh@naver.com");
        res3.setPhone("01011111111");
        res3.setRoomPrice(120000);
        res3.setRoomCount(1);
        res3.setRoomRole(RoomRole.LUXURY);
        mongoTemplate.insert(res);
        mongoTemplate.insert(res2);
        mongoTemplate.insert(res3);

    }
}
