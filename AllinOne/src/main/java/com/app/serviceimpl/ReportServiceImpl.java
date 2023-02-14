package com.app.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.model.Patient;
import com.app.model.Report;
import com.app.repository.ReportRepository;
import com.app.service.ReportService;
@Service
public class ReportServiceImpl implements ReportService{

	@Autowired ReportRepository reportRepository;
	
	@Override
	public Report saveReport(Report report) {
		
		return reportRepository.save(report);
	}

	@Override
	public List<Report> getReports() {
		
		return reportRepository.findAll();
	}

	@Override
	public List<Report> getReport(int patientId) {
		
		return reportRepository.findByPatientId(patientId);
	}

	@Override
	public String deleteReport(int patientId,String filename) {
		
//		 reportRepository.deleteByPatientId(patientId);	
		List<Report> reports=reportRepository.findByPatientId(patientId);
		System.out.println(reports);
		try {
			for(Report r:reports) {
				if(r.getPatientId().getId()==patientId) {
					if(r.getFilename().equals(filename)) {
						reportRepository.deleteById(r.getReportId());
						return "Midmark report deleted ssuccessfully ";
					}
					return "filename Required for delete Midmark report";
				}
				return "patientID Required for delete Midmark report";
			}
		} catch (Exception e) {
			e.getMessage();
		}
		return "filename & patientID Required for delete Midmark report";
	}

	@Override
	public void deleteReportByReportId(int reportId) {
		reportRepository.deleteById(reportId);
		
	}

}
