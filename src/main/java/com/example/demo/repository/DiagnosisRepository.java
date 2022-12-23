package com.example.demo.repository;

import com.example.demo.entity.Diagnosis;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DiagnosisRepository extends JpaRepository<Diagnosis,Integer> {
    Diagnosis findByNameContainingIgnoreCase(String name);
}
