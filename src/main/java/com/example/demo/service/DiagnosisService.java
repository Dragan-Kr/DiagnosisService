package com.example.demo.service;

import com.example.demo.entity.Diagnosis;

import java.util.Collection;

public interface DiagnosisService {
    Collection<Diagnosis> findAll();

    Diagnosis getOneObject(Integer id);

    Diagnosis findByNameContainingIgnoreCase(String name);

    void saveObject(Diagnosis diagnosis);

    Diagnosis saveDiagnosis(Diagnosis diagnosis);

    boolean existsObjectById(Integer id);

    void deleteObjectById(Integer id);
}
