package org.gov.Hospital_SpringBoot.dao;

import java.util.List;
import java.util.Optional;

import org.gov.Hospital_SpringBoot.dto.Patient;
import org.gov.Hospital_SpringBoot.repo.PatientRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class PatientDao {
	@Autowired
	private PatientRepo repo;
	
	public Patient savePatient(Patient patient) {
		return repo.save(patient);
	}
	
	public Patient getPatientById(int id){
		Optional<Patient> optional = repo.findById(id);
		
		if(optional.isPresent())
			return optional.get();
		return null;
	}
	
	public List<Patient> getPatientByName(String name){
		return repo.findByPatientName(name);
	}
	
	public List<Patient> getAll(){
		return repo.findAll();
	}
	
	public String deleteById(int id) {
		repo.deleteById(id);
		return "Data Deleted";
	}
	
	public Patient updatePatient(Patient patient) {
		return repo.save(patient);
	}
}