package com.example.demo.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the diagnosis database table.
 * 
 */
@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
@Entity
@Table(name="diagnosis")
@NamedQuery(name="Diagnosis.findAll", query="SELECT d FROM Diagnosis d")
public class Diagnosis implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="DIAGNOSIS_ID_GENERATOR", sequenceName="DIAGNOSIS_SEQ",allocationSize = 1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="DIAGNOSIS_ID_GENERATOR")
	private Integer id;

	@Temporal(TemporalType.DATE)
	@Column(name="diag_date")
	private Date diagDate;

	private String name;

	private String observation;

	public Diagnosis() {
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Date getDiagDate() {
		return this.diagDate;
	}

	public void setDiagDate(Date diagDate) {
		this.diagDate = diagDate;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getObservation() {
		return this.observation;
	}

	public void setObservation(String observation) {
		this.observation = observation;
	}

}
