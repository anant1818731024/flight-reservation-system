package com.anant.flightReservation.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.anant.flightReservation.entities.Reservation;

public interface ReservationRepository extends JpaRepository<Reservation, Long> {

}
