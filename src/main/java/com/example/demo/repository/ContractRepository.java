package com.example.demo.repository;

import com.example.demo.model.Policy;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface ContractRepository extends JpaRepository<Policy, UUID> {
}
