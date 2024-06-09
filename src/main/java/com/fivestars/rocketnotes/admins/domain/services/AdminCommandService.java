package com.fivestars.rocketnotes.admins.domain.services;

public interface AdminCommandService {
    Long handle(CreateAdminCommand command);
    // Otros métodos de comando
}

