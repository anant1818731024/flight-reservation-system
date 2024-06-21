package com.anant.flightReservation.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.anant.flightReservation.dtos.ReservationRequest;
import com.anant.flightReservation.entities.Flight;
import com.anant.flightReservation.entities.Passenger;
import com.anant.flightReservation.entities.Reservation;
import com.anant.flightReservation.repos.FlightRepository;
import com.anant.flightReservation.repos.PassangerRepository;
import com.anant.flightReservation.repos.ReservationRepository;
import com.anant.flightReservation.services.ReservationService;


@Service
public class ReservationServiceImpl implements ReservationService {

	@Autowired
	private FlightRepository flightRepository;
	
	@Autowired
	private PassangerRepository passangerRepository;
	
	@Autowired
	private ReservationRepository reservationRepository;
	
	@Override
	public Reservation bookFlight(ReservationRequest request) {
		
		//credit card details can be used to make payment
		
		Flight flight = flightRepository.findById(request.getFlightId()).get();
		
		Passenger passenger = new Passenger();
		passenger.setFirstName(request.getPassengerFirstName());
		passenger.setLastName(request.getPassengerLastName());
		passenger.setEmail(request.getPassengerEmail());
		passenger.setPhone(request.getPassengerPhone());
		
		Passenger savedPassanger = passangerRepository.save(passenger);
		
		Reservation reservation = new Reservation();
		reservation.setFlight(flight);
		reservation.setPassanger(savedPassanger);
		reservation.setCheckedIn(false);
		
		return reservationRepository.save(reservation);
	}

}
