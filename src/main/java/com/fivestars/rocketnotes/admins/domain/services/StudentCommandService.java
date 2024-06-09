package com.fivestars.rocketnotes.admins.domain.services;

import com.example.admins.domain.commands.CreateStudentCommand;

public interface StudentCommandService {
    Long handle(CreateStudentCommand command);
}
