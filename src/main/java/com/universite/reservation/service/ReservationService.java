package com.universite.reservation.service;

import com.universite.reservation.entity.Reservation;

import java.util.List;
import java.util.Optional;

public interface ReservationService {
    Reservation createReservation(Reservation reservation);
    List<Reservation> getAllReservations();
    Optional<Reservation> getById(Long id);
    void deleteReservation(Long id);
}
