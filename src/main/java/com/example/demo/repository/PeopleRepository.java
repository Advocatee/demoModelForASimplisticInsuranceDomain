package com.example.demo.repository;

import com.example.demo.model.People;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface PeopleRepository extends JpaRepository<People, UUID> {
}
