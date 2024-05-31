package com.teamprooject.team;


import com.teamprooject.team.reservation.ReservationServiceImpl;
import com.teamprooject.team.room.RoomServiceImpl;
import com.teamprooject.team.user.UserServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;


@RequiredArgsConstructor
@SpringBootApplication
public class TeamApplication implements ApplicationListener<ContextRefreshedEvent> {

	private final UserServiceImpl userService;
	private final RoomServiceImpl roomService;
	private final ReservationServiceImpl resService;



	public static void main(String[] args) {
		SpringApplication.run(TeamApplication.class, args);
	}

	@Override
	public void onApplicationEvent(ContextRefreshedEvent event) {
	    //userService.mongoInsert();
		//roomService.mongoRoomInsert();
		//resService.mongoReservationInsert();
	}
}
