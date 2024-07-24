package org.gov.Hospital_SpringBoot.repo;

import java.util.List;

import org.gov.Hospital_SpringBoot.dto.Patient;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PatientRepo extends JpaRepository<Patient, Integer>{
	
	public List<Patient> findByPatientName(String patientName);

}