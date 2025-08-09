package com.universite.reservation.entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "reservation")
public class Reservation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(optional=false)
    @JoinColumn(name = "classroom_id")
    private Classroom classroom;

    @ManyToOne(optional=false)
    @JoinColumn(name = "user_id")
    private User user;

    @Column(nullable=false)
    private LocalDateTime startTime;

    @Column(nullable=false)
    private LocalDateTime endTime;

    // getters / setters
    public Long getId(){ return id; }
    public void setId(Long id){ this.id = id; }
    public Classroom getClassroom(){ return classroom; }
    public void setClassroom(Classroom classroom){ this.classroom = classroom; }
    public User getUser(){ return user; }
    public void setUser(User user){ this.user = user; }
    public LocalDateTime getStartTime(){ return startTime; }
    public void setStartTime(LocalDateTime startTime){ this.startTime = startTime; }
    public LocalDateTime getEndTime(){ return endTime; }
    public void setEndTime(LocalDateTime endTime){ this.endTime = endTime; }
}
