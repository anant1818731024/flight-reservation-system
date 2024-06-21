package com.anant.flightReservation.services;

import com.anant.flightReservation.dtos.ReservationRequest;
import com.anant.flightReservation.entities.Reservation;

public interface ReservationService {

	Reservation bookFlight(ReservationRequest request);
}
