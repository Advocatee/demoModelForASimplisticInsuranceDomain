package com.example.demo.repository;

import com.example.demo.model.Clients;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface ClientsRepository extends JpaRepository<Clients, UUID> {
}