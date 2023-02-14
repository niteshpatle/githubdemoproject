package com.app.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Report {
	private static final long serialVersionUID =1L;
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Id
	private int reportId;
	private String refferedby;
	private String filename;
	private boolean achieve;
	
	@OneToOne
	private Patient patientId;
}
