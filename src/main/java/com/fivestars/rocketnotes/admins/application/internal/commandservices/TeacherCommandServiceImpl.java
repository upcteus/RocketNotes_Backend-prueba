package com.fivestars.rocketnotes.admins.application.internal.commandservices;

import com.example.admins.domain.model.aggregates.Teacher;
import com.example.admins.infrastructure.persistence.jpa.repositories.TeacherRepository;
import com.example.admins.domain.commands.CreateTeacherCommand;
import org.springframework.stereotype.Service;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class TeacherCommandServiceImpl implements TeacherCommandService {

    private final TeacherRepository teacherRepository;

    @Override
    public Long handle(CreateTeacherCommand command) {
        Teacher teacher = Teacher.builder()
                .firstName(command.getFirstName())
                .paternalLastName(command.getPaternalLastName())
                .maternalLastName(command.getMaternalLastName())
                .dni(command.getDni())
                .phone(command.getPhone())
                .email(command.getEmail())
                .build();
        return teacherRepository.save(teacher).getId();
    }

}
