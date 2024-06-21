package com.anant.flightReservation.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.anant.flightReservation.dtos.ReservationCheckInRequest;
import com.anant.flightReservation.entities.Reservation;
import com.anant.flightReservation.repos.ReservationRepository;

@RestController
public class ReservationRestController {
	
	@Autowired
	private ReservationRepository reservationRepo;
	
	@GetMapping("/reservations/{id}")
	public Reservation getReservation(@PathVariable("id") Long id) {
		return reservationRepo.findById(id).get();
	}
	
	@PostMapping("/reservations")
	public Reservation setCheckedInAndAddNumberOfBags(@RequestBody ReservationCheckInRequest request) {
		Reservation reservation = reservationRepo.findById(request.getId()).get();
		
		reservation.setCheckedIn(request.isCheckedIn());
		reservation.setNumberOfBags(request.getNumberOfBags());
		
		return reservationRepo.save(reservation);
	}
}
