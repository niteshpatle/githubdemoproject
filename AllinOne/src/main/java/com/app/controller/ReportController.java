package com.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.app.model.Report;
import com.app.service.ReportService;

@RestController
@RequestMapping("/api/report")
public class ReportController {
	
	@Autowired ReportService reportService;
	
	@PostMapping("/save")
	public ResponseEntity<Report> saveReport(@RequestBody Report report){
		return new ResponseEntity<Report>(reportService.saveReport(report),HttpStatus.CREATED);
	}
	
	@GetMapping("/get")
	public ResponseEntity<List<Report>> getReports(){
		return new  ResponseEntity<List<Report>>(reportService.getReports(),HttpStatus.OK);
	}
	
	@GetMapping("/bypatientId")
	public ResponseEntity<List<Report>> getReport(@RequestParam ("patientId") int patientId){
		List<Report> list=reportService.getReport(patientId);
		return new ResponseEntity<List<Report>>(list,HttpStatus.FOUND);
	}
	
	@DeleteMapping("/delete")
	public String deleteReport(@RequestParam ("patientId") int patientId,@RequestParam ("filename") String filename){
		String s=reportService.deleteReport(patientId,filename);
//		return new ResponseEntity<String>(s,HttpStatus.OK);
		return s;
	}

	@DeleteMapping("/deleteReportByReportId")
	public void deleteReportByReportId(@RequestParam ("reportId") int reportId){
		reportService.deleteReportByReportId(reportId);
//		return new ResponseEntity<String>(s,HttpStatus.OK);
	}
}
