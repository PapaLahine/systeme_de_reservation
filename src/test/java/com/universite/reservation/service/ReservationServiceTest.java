package com.universite.reservation.service;

import com.universite.reservation.entity.Classroom;
import com.universite.reservation.entity.Reservation;
import com.universite.reservation.entity.User;
import com.universite.reservation.repository.ReservationRepository;
import com.universite.reservation.service.impl.ReservationServiceImpl;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.time.LocalDateTime;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class ReservationServiceTest {

    @Test
    void createReservation_noConflict_success() {
        ReservationRepository repo = Mockito.mock(ReservationRepository.class);
        ReservationServiceImpl service = new ReservationServiceImpl(repo);

        Classroom c = new Classroom(); c.setId(1L);
        User u = new User(); u.setId(1L);
        Reservation r = new Reservation();
        r.setClassroom(c);
        r.setUser(u);
        r.setStartTime(LocalDateTime.now().plusDays(1));
        r.setEndTime(LocalDateTime.now().plusDays(1).plusHours(2));

        when(repo.findByClassroomIdAndEndTimeAfterAndStartTimeBefore(anyLong(), any(), any())).thenReturn(List.of());
        when(repo.save(any())).thenAnswer(i -> {Reservation x = i.getArgument(0); x.setId(1L); return x;});

        Reservation created = service.createReservation(r);
        assertNotNull(created.getId());
        verify(repo, times(1)).save(any());
    }

    @Test
    void createReservation_conflict_throws() {
        ReservationRepository repo = Mockito.mock(ReservationRepository.class);
        ReservationServiceImpl service = new ReservationServiceImpl(repo);

        Classroom c = new Classroom(); c.setId(1L);
        User u = new User(); u.setId(1L);
        Reservation r = new Reservation();
        r.setClassroom(c);
        r.setUser(u);
        r.setStartTime(LocalDateTime.now().plusDays(1));
        r.setEndTime(LocalDateTime.now().plusDays(1).plusHours(2));

        when(repo.findByClassroomIdAndEndTimeAfterAndStartTimeBefore(anyLong(), any(), any())).thenReturn(List.of(new Reservation()));
        assertThrows(IllegalArgumentException.class, () -> service.createReservation(r));
    }
}
