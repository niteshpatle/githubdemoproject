package com.app.service;

import java.util.List;

import com.app.model.Patient;

public interface PatientService {

	Patient savePatient(Patient patient);

	List<Patient> getAllPatient();

}
