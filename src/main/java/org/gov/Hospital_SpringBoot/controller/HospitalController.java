package org.gov.Hospital_SpringBoot.controller;

import java.util.List;

import org.gov.Hospital_SpringBoot.dto.Hospital;
import org.gov.Hospital_SpringBoot.service.HospitalService;
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
public class HospitalController {
	@Autowired
	private HospitalService service;
	
	@PostMapping("saveHospital")
	public ResponseEntity<ResponseStructure<Hospital>> saveHospital(@RequestBody Hospital hospital) {
		return service.saveHospital(hospital);
	}
	
	@GetMapping("getHospitalById/{id}")
	public ResponseEntity<ResponseStructure<Hospital>> getHospitalById(@PathVariable int id) {
		return service.getHospitalById(id);
	}
	
	@GetMapping("getAllHospital")
	public ResponseEntity<ResponseStructure<List<Hospital>>> getAllHospital(){
		return service.getAllHospital();
	}
	
	@PutMapping("updateHospital/{hospitalId}")
	public ResponseEntity<ResponseStructure<Hospital>> updateHospital(@PathVariable int hospitalId, @RequestBody Hospital newHospital){
		return service.updateHospital(hospitalId, newHospital);
	}
	
	@DeleteMapping("deleteHospital/{hospitalId}")
	public ResponseEntity<ResponseStructure<String>> deleteHospital(@PathVariable int hospitalId){
		return service.deleteHospital(hospitalId);
	}
	
}