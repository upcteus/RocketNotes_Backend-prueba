package com.fivestars.rocketnotes.admins.application.internal.commandservices;

import com.fivestars.rocketnotes.admins.domain.model.aggregates.Admin;
import com.fivestars.rocketnotes.admins.infrastructure.persistence.jpa.repositories.AdminRepository;
import com.fivestars.rocketnotes.admins.domain.commands.CreateAdminCommand;
import org.springframework.stereotype.Service;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AdminCommandServiceImpl implements AdminCommandService {

    private final AdminRepository adminRepository;

    @Override
    public Long handle(CreateAdminCommand command) {
        Admin admin = Admin.builder()
                .firstName(command.getFirstName())
                .lastName(command.getLastName())
                .email(command.getEmail())
                .password(command.getPassword())
                .build();
        return adminRepository.save(admin).getId();
    }

}