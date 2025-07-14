package com.example.employeespringboot.repository;

import com.example.employeespringboot.models.Roles;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RolesRepository extends JpaRepository<Roles,Integer> {
    Optional<Roles>findByName(String roleName);
}
