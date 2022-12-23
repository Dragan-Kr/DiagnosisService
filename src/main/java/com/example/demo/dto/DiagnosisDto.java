package com.example.demo.dto;

import javax.persistence.Column;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.util.Date;

public class DiagnosisDto {

    private Integer id;


    private Date diagDate;

    private String name;

    private String observation;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getDiagDate() {
        return diagDate;
    }

    public void setDiagDate(Date diagDate) {
        this.diagDate = diagDate;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getObservation() {
        return observation;
    }

    public void setObservation(String observation) {
        this.observation = observation;
    }
}
