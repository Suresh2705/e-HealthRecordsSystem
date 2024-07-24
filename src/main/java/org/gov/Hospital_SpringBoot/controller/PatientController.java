package org.gov.Hospital_SpringBoot.controller;

import java.util.List;

import org.gov.Hospital_SpringBoot.dto.Hospital;
import org.gov.Hospital_SpringBoot.dto.Patient;
import org.gov.Hospital_SpringBoot.service.PatientService;
import org.gov.Hospital_SpringBoot.util.ResponseStructure;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PatientController {
	@Autowired
	private PatientService service;
	
	@PostMapping("savePatient/{hospitalId}")
	public ResponseEntity<ResponseStructure<Hospital>> savePatient(@PathVariable int hospitalId, @RequestBody Patient patient) {
		return service.savePatient(hospitalId, patient);
	}
	
	@GetMapping("getPatientById/{id}")
	public ResponseEntity<ResponseStructure<Patient>> getPatientById(@PathVariable int id) {
		return service.getPatientById(id);
	}
	
	@GetMapping("getPatientByName/{patientName}")
	public ResponseEntity<ResponseStructure<List<Patient>>> getPatientByName(@PathVariable String patientName){
		return service.getPatientByName(patientName);
	}
	
	@GetMapping("getAllPatients")
	public ResponseEntity<ResponseStructure<List<Patient>>> getAll(){
		return service.getAll();
	}
	
	@DeleteMapping("deletePatientById/{hospitalId}/{patientId}")
	public ResponseEntity<ResponseStructure<Hospital>> deleteById(@PathVariable int hospitalId, @PathVariable int patientId) {
		return service.deleteById(hospitalId, patientId);
	}
	
	@PutMapping("updatePatient/{id}")
	public ResponseEntity<ResponseStructure<Patient>> updatePatient(@PathVariable int id, @RequestBody Patient patient) {
		return service.updatePatient(id, patient);
	}
}