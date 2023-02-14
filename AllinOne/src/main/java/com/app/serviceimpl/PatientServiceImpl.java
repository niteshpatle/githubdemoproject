package com.app.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.model.Patient;
import com.app.repository.PatientRepo;
import com.app.service.PatientService;
@Service
public class PatientServiceImpl implements PatientService{

	@Autowired PatientRepo patientRepo;
	
	@Override
	public Patient savePatient(Patient patient) {
		
		return patientRepo.save(patient);
	}

	@Override
	public List<Patient> getAllPatient() {
		
		return patientRepo.findAll();
	}

}
