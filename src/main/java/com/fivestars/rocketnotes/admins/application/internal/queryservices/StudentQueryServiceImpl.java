package com.fivestars.rocketnotes.admins.application.internal.queryservices;

import com.example.admins.domain.model.aggregates.Student;
import com.example.admins.infrastructure.persistence.jpa.repositories.StudentRepository;
import org.springframework.stereotype.Service;
import lombok.RequiredArgsConstructor;

import java.util.List;

@Service
@RequiredArgsConstructor
public class StudentQueryServiceImpl implements StudentQueryService {

    private final StudentRepository studentRepository;

    @Override
    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    @Override
    public Student getStudentById(Long id) {
        return studentRepository.findById(id).orElse(null);
    }

    // Implementación de otros métodos de consulta
}
