package com.fivestars.rocketnotes.admins.application.internal.queryservices;

import com.example.admins.domain.model.aggregates.Admin;
import com.example.admins.infrastructure.persistence.jpa.repositories.AdminRepository;
import org.springframework.stereotype.Service;
import lombok.RequiredArgsConstructor;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AdminQueryServiceImpl implements AdminQueryService {

    private final AdminRepository adminRepository;

    @Override
    public List<Admin> getAllAdmins() {
        return adminRepository.findAll();
    }

    @Override
    public Admin getAdminById(Long id) {
        return adminRepository.findById(id).orElse(null);
    }

}