package com.example.demo.repository;

import com.example.demo.model.Contracts;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface ContractsRepository extends JpaRepository<Contracts, UUID> {
}
