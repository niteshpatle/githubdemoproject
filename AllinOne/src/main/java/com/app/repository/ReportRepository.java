package com.app.repository;

import java.util.List;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.app.model.Report;

@Repository
public interface ReportRepository extends JpaRepository<Report, Integer>{

	@Query(value = "SELECT * from report WHERE patient_id_id=:patientId",nativeQuery = true)
	List<Report> findByPatientId(int patientId);
	
	@Query(value="DELETE FROM report WHERE patient_id_id=:patientId",nativeQuery = true)	
	void deleteByPatientId(int patientId);

}
