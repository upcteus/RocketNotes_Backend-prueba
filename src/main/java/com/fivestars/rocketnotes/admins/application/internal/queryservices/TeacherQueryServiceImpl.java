package com.fivestars.rocketnotes.admins.application.internal.queryservices;

import com.example.admins.domain.model.aggregates.Teacher;
import com.example.admins.infrastructure.persistence.jpa.repositories.TeacherRepository;
import org.springframework.stereotype.Service;
import lombok.RequiredArgsConstructor;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TeacherQueryServiceImpl implements TeacherQueryService {

    private final TeacherRepository teacherRepository;

    @Override
    public List<Teacher> getAllTeachers() {
        return teacherRepository.findAll();
    }

    @Override
    public Teacher getTeacherById(Long id) {
        return teacherRepository.findById(id).orElse(null);
    }

}