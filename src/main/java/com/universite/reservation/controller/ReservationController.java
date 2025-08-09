package com.universite.reservation.controller;

import com.universite.reservation.entity.Reservation;
import com.universite.reservation.repository.ClassroomRepository;
import com.universite.reservation.repository.UserRepository;
import com.universite.reservation.service.ReservationService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api/reservations")
public class ReservationController {

    private final ReservationService reservationService;
    private final ClassroomRepository classroomRepository;
    private final UserRepository userRepository;

    public ReservationController(ReservationService reservationService,
                                 ClassroomRepository classroomRepository,
                                 UserRepository userRepository){
        this.reservationService = reservationService;
        this.classroomRepository = classroomRepository;
        this.userRepository = userRepository;
    }

    @GetMapping
    public List<Reservation> all() {
        return reservationService.getAllReservations();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Reservation> get(@PathVariable Long id){
        return reservationService.getById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<?> create(@RequestBody Reservation r){
        if(r.getClassroom() != null && r.getClassroom().getId() != null){
            r.setClassroom(classroomRepository.findById(r.getClassroom().getId()).orElse(null));
        }
        if(r.getUser() != null && r.getUser().getId() != null){
            r.setUser(userRepository.findById(r.getUser().getId()).orElse(null));
        }
        Reservation created = reservationService.createReservation(r);
        return ResponseEntity.created(URI.create("/api/reservations/" + created.getId())).body(created);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id){
        reservationService.deleteReservation(id);
        return ResponseEntity.noContent().build();
    }
}
