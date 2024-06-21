package com.anant.flightReservation.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.anant.flightReservation.entities.Passenger;

public interface PassangerRepository extends JpaRepository<Passenger, Long> {

}
