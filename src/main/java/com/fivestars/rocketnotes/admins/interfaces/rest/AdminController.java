package com.fivestars.rocketnotes.admins.interfaces.rest;

import com.example.admins.application.internal.commandservices.AdminCommandService;
import com.example.admins.application.internal.queryservices.AdminQueryService;
import com.example.admins.domain.commands.CreateAdminCommand;
import com.example.admins.domain.model.aggregates.Admin;
import com.example.admins.interfaces.rest.resources.AdminResource;
import com.example.admins.interfaces.rest.resources.CreateAdminResource;
import org.springframework.web.bind.annotation.*;
import lombok.RequiredArgsConstructor;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/admins")
@RequiredArgsConstructor
public class AdminController {

    private final AdminCommandService adminCommandService;
    private final AdminQueryService adminQueryService;

    @PostMapping
    public Long createAdmin(@RequestBody CreateAdminResource createAdminResource) {
        CreateAdminCommand command = CreateAdminCommand.builder()
                .firstName(createAdminResource.getFirstName())
                .lastName(createAdminResource.getLastName())
                .email(createAdminResource.getEmail())
                .password(createAdminResource.getPassword())
                .build();
        return adminCommandService.handle(command);
    }

    @GetMapping
    public List<AdminResource> getAllAdmins() {
        return adminQueryService.getAllAdmins().stream()
                .map(admin -> AdminResource.builder()
                        .id(admin.getId())
                        .firstName(admin.getFirstName())
                        .lastName(admin.getLastName())
                        .email(admin.getEmail())
                        .build())
                .collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    public AdminResource getAdminById(@PathVariable Long id) {
        Admin admin = adminQueryService.getAdminById(id);
        return AdminResource.builder()
                .id(admin.getId())
                .firstName(admin.getFirstName())
                .lastName(admin.getLastName())
                .email(admin.getEmail())
                .build();
    }
}