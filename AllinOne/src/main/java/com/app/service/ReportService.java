package com.app.service;

import java.util.List;

import com.app.model.Report;

public interface ReportService {

	Report saveReport(Report report);

	List<Report> getReports();

	List<Report> getReport(int patientId);

	String deleteReport(int patientId,String filename);

	void deleteReportByReportId(int reportId);

}
