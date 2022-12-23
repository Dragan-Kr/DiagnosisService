package com.example.demo.controller;

import com.example.demo.dto.DiagnosisDto;
import com.example.demo.entity.Diagnosis;
import com.example.demo.service.DiagnosisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@CrossOrigin(origins = "http://localhost:8084")
@RestController
public class DiagnosisController {
    @Autowired
    private DiagnosisService diagnosisService;

    @GetMapping("diagnosis")
    public Collection<Diagnosis> findAll(){
        return diagnosisService.findAll();
    }


    @GetMapping("diagnosis/{id}")
    public Diagnosis getDiagnosisById(@PathVariable("id") Integer id){
        return diagnosisService.getOneObject(id);
    }

    @GetMapping("diagnosis/name/{name}")
    public Diagnosis getDiagnosisByName(@PathVariable("name") String name){
        return diagnosisService.findByNameContainingIgnoreCase(name);
    }

    @PostMapping("diagnosis")
    public ResponseEntity insertDiagnosis(@RequestBody DiagnosisDto diagnosisDto){
        Diagnosis diagnosis = new Diagnosis();
        diagnosis.setName(diagnosisDto.getName());
        diagnosis.setDiagDate(diagnosisDto.getDiagDate());
        diagnosis.setObservation(diagnosisDto.getObservation());
        diagnosisService.saveObject(diagnosis);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @PutMapping("diagnosis/{id}")
    public ResponseEntity updateDiagnosis(@PathVariable("id") Integer id,@RequestBody DiagnosisDto diagnosisDto){
        Diagnosis diagnosis = diagnosisService.getOneObject(id);
        diagnosis.setName(diagnosisDto.getName());
        diagnosis.setDiagDate(diagnosisDto.getDiagDate());
        diagnosis.setObservation(diagnosisDto.getObservation());
        Diagnosis updatedDiagnosis = diagnosisService.saveDiagnosis(diagnosis);
        return ResponseEntity.ok(updatedDiagnosis);
    }

    @DeleteMapping("diagnosis/{id}")
    public ResponseEntity<Diagnosis> deleteDiagnosis(@PathVariable("id") Integer id){
        if(!diagnosisService.existsObjectById(id))
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        diagnosisService.deleteObjectById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

//    @DeleteMapping("ward/{id}")
//    public  ResponseEntity<Ward> deleteWard(@PathVariable ("id") Integer id){
//        if(!wardService.existsObjectById(id))
//            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
//
//        wardService.deleteObjectById(id);
//        return new ResponseEntity<>(HttpStatus.OK);
//    }


}
