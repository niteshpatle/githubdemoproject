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

import com.app.model.DateFormate;
import com.app.service.DateService;

@RestController
@RequestMapping("/date")
public class DateController {
	@Autowired DateService dateService;
	
	@PostMapping("/save")
	public ResponseEntity<DateFormate> saveDate(@RequestBody DateFormate dateFormate){
	DateFormate  d=dateService.saveDate(dateFormate);
		return new ResponseEntity<DateFormate>(d,HttpStatus.CREATED);
	}

	@GetMapping("/get")
	public ResponseEntity<List<DateFormate>> getDate(){
		return new ResponseEntity<List<DateFormate>>(dateService.getDate(),HttpStatus.OK);
	}
}
