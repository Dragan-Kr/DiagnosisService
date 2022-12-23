package com.example.demo.implem;

import com.example.demo.entity.Diagnosis;
import com.example.demo.repository.DiagnosisRepository;
import com.example.demo.service.DiagnosisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class DiagnosisServiceImplem implements DiagnosisService {

    @Autowired
    private DiagnosisRepository diagnosisRepository;

    @Override
    public Collection<Diagnosis> findAll() {
        return diagnosisRepository.findAll();
    }

    @Override
    public Diagnosis getOneObject(Integer id) {
        return diagnosisRepository.getById(id);
    }

    @Override
    public Diagnosis findByNameContainingIgnoreCase(String name) {
        return diagnosisRepository.findByNameContainingIgnoreCase(name);
    }

    @Override
    public void saveObject(Diagnosis diagnosis) {
        diagnosisRepository.save(diagnosis);
    }

    @Override
    public Diagnosis saveDiagnosis(Diagnosis diagnosis) {
        return  diagnosisRepository.save(diagnosis);
    }

    @Override
    public boolean existsObjectById(Integer id) {
        return diagnosisRepository.existsById(id);
    }

    @Override
    public void deleteObjectById(Integer id) {
        diagnosisRepository.deleteById(id);
    }
}
