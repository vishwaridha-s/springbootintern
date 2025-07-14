package com.example.employeespringboot.repository;

import com.example.employeespringboot.models.RegisterDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RegisterDetailsRepository  extends JpaRepository<RegisterDetails,Integer> {

    RegisterDetails findByEmail(String email);
}
