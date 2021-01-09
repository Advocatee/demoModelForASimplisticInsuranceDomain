package com.example.demo.repository;

import com.example.demo.model.BasePolicy;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface PolicyRepository extends JpaRepository <BasePolicy, UUID> {
}
