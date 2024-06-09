package com.fivestars.rocketnotes.admins.application.internal.commandservices;

import com.example.admins.domain.model.aggregates.Student;
import com.example.admins.infrastructure.persistence.jpa.repositories.StudentRepository;
import com.example.admins.domain.commands.CreateStudentCommand;
import org.springframework.stereotype.Service;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class StudentCommandServiceImpl implements StudentCommandService {

    private final StudentRepository studentRepository;

    @Override
    public Long handle(CreateStudentCommand command) {
        Student student = Student.builder()
                .firstName(command.getFirstName())
                .paternalLastName(command.getPaternalLastName())
                .maternalLastName(command.getMaternalLastName())
                .dni(command.getDni())
                .build();
        return studentRepository.save(student).getId();
    }

}