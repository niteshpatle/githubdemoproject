package com.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.model.Patient;
import com.app.service.PatientService;

@RestController
@RequestMapping("/api/patient")
public class PatientController {
	@Autowired PatientService patientService;
	
	@PostMapping("/save")
	public ResponseEntity<Patient> savePatient(@RequestBody Patient patient){
	 Patient patient2=patientService.savePatient(patient);
	 return new ResponseEntity<Patient>(patient2,HttpStatus.CREATED);
	}
	
	@GetMapping("/get")
	public ResponseEntity<List<Patient>> getALLPatient(){
		return new ResponseEntity<List<Patient>>(patientService.getAllPatient(),HttpStatus.OK);
	}

}
