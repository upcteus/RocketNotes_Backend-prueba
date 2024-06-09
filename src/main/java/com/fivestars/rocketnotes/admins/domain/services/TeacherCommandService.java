package com.fivestars.rocketnotes.admins.domain.services;

import com.example.admins.domain.commands.CreateTeacherCommand;

public interface TeacherCommandService {
    Long handle(CreateTeacherCommand command);
}