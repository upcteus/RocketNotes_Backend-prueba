package com.fivestars.rocketnotes.admins.interfaces.rest;

import com.example.admins.application.internal.commandservices.StudentCommandService;
import com.example.admins.application.internal.queryservices.StudentQueryService;
import com.example.admins.domain.commands.CreateStudentCommand;
import com.example.admins.domain.model.aggregates.Student;
import com.example.admins.interfaces.rest.resources.CreateStudentResource;
import com.example.admins.interfaces.rest.resources.StudentResource;
import org.springframework.web.bind.annotation.*;
import lombok.RequiredArgsConstructor;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/students")
@RequiredArgsConstructor
public class StudentController {

    private final StudentCommandService studentCommandService;
    private final StudentQueryService studentQueryService;

    @PostMapping
    public Long createStudent(@RequestBody CreateStudentResource createStudentResource) {
        CreateStudentCommand command = CreateStudentCommand.builder()
                .firstName(createStudentResource.getFirstName())
                .paternalLastName(createStudentResource.getPaternalLastName())
                .maternalLastName(createStudentResource.getMaternalLastName())
                .dni(createStudentResource.getDni())
                .build();
        return studentCommandService.handle(command);
    }

    @GetMapping
    public List<StudentResource> getAllStudents() {
        return studentQueryService.getAllStudents().stream()
                .map(student -> StudentResource.builder()
                        .id(student.getId())
                        .firstName(student.getFirstName())
                        .paternalLastName(student.getPaternalLastName())
                        .maternalLastName(student.getMaternalLastName())
                        .dni(student.getDni())
                        .build())
                .collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    public StudentResource getStudentById