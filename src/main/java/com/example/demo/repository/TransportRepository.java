package com.example.demo.repository;

import com.example.demo.model.Transport;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface TransportRepository extends JpaRepository<Transport, UUID> {
}
