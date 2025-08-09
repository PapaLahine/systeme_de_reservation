package com.universite.reservation.service.impl;

import com.universite.reservation.entity.Reservation;
import com.universite.reservation.repository.ReservationRepository;
import com.universite.reservation.service.ReservationService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class ReservationServiceImpl implements ReservationService {

    private final ReservationRepository reservationRepository;

    public ReservationServiceImpl(ReservationRepository reservationRepository){
        this.reservationRepository = reservationRepository;
    }

    @Override
    public Reservation createReservation(Reservation reservation) {
        Long classroomId = reservation.getClassroom().getId();
        List<Reservation> conflicts = reservationRepository.findByClassroomIdAndEndTimeAfterAndStartTimeBefore(
                classroomId, reservation.getStartTime(), reservation.getEndTime()
        );
        if(conflicts != null && !conflicts.isEmpty()){
            throw new IllegalArgumentException("Conflit de réservation pour la salle et la plage horaire.");
        }
        return reservationRepository.save(reservation);
    }

    @Override
    public List<Reservation> getAllReservations(){
        return reservationRepository.findAll();
    }

    @Override
    public Optional<Reservation> getById(Long id){
        return reservationRepository.findById(id);
    }

    @Override
    public void deleteReservation(Long id){
        reservationRepository.deleteById(id);
    }
}
