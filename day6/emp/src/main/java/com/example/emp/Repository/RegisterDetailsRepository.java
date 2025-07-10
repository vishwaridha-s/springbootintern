package com.example.emp.Repository;

import com.example.emp.model.RegisterDetails;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RegisterDetailsRepository extends JpaRepository<RegisterDetails, Integer> {
    RegisterDetails findByEmail(String email);
}
