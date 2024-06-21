package com.anant.flightReservation.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import com.anant.flightReservation.dtos.ReservationRequest;
import com.anant.flightReservation.entities.Flight;
import com.anant.flightReservation.entities.Reservation;
import com.anant.flightReservation.repos.FlightRepository;
import com.anant.flightReservation.services.ReservationService;

@Controller
public class ReservationController {
	
	@Autowired
	private ReservationService reservationService;
	
	@Autowired
	private FlightRepository flightRepository;
	
	@GetMapping("/showCompleteReservation")
	public String showCompleteReservation(@RequestParam("flightId") Long flightId, ModelMap modelMap) {
		
		Flight flight = flightRepository.findById(flightId).get();
		modelMap.addAttribute("flight", flight);
		return "completeReservation";
	}
	
	@PostMapping("/completeReservation")
	public String completeReservation(ReservationRequest request, ModelMap modelMap) {
		System.out.println("request id: " + request);
		Reservation reservation = reservationService.bookFlight(request);
		
		modelMap.addAttribute("msg", "Reservation created Successfully and the reservation id is: " + reservation.getId());
		return "reservationConfirmation";
	}
}
