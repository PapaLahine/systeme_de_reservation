package com.universite.reservation.controller;

import com.universite.reservation.entity.Classroom;
import com.universite.reservation.repository.ClassroomRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/classrooms")
public class ClassroomController {

    private final ClassroomRepository classroomRepository;

    public ClassroomController(ClassroomRepository classroomRepository){
        this.classroomRepository = classroomRepository;
    }

    @GetMapping
    public List<Classroom> all(){
        return classroomRepository.findAll();
    }
}
