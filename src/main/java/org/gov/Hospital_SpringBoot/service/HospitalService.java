package org.gov.Hospital_SpringBoot.service;

import java.util.List;

import org.gov.Hospital_SpringBoot.dao.HospitalDao;
import org.gov.Hospital_SpringBoot.dto.Hospital;
import org.gov.Hospital_SpringBoot.util.ResponseStructure;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class HospitalService {
	@Autowired
	private HospitalDao dao;

	public ResponseEntity<ResponseStructure<Hospital>> saveHospital(Hospital hospital) {
		ResponseStructure<Hospital> structure = new ResponseStructure<Hospital>();
		structure.setStatus(HttpStatus.CREATED.value());// 201
		structure.setMessage("Data Saved Successfully!");
		Hospital saveHospital = dao.saveHospital(hospital);
		structure.setData(saveHospital);

		ResponseEntity<ResponseStructure<Hospital>> entity = new ResponseEntity<ResponseStructure<Hospital>>(structure,
				HttpStatus.CREATED);
		return entity;
	}

	public ResponseEntity<ResponseStructure<List<Hospital>>> getAllHospital() {
		ResponseStructure<List<Hospital>> structure = new ResponseStructure<List<Hospital>>();
		structure.setStatus(HttpStatus.OK.value());// 200
		structure.setMessage("All the details are received successfully");
		structure.setData(dao.getAllHospital());

		ResponseEntity<ResponseStructure<List<Hospital>>> entity = new ResponseEntity<ResponseStructure<List<Hospital>>>(
				structure, HttpStatus.OK);
		return entity;
	}

	public ResponseEntity<ResponseStructure<Hospital>> getHospitalById(int id) {
		ResponseStructure<Hospital> structure = new ResponseStructure<Hospital>();
		structure.setStatus(HttpStatus.OK.value());
		structure.setMessage("Data received successfully");
		structure.setData(dao.getHospitalById(id));

		ResponseEntity<ResponseStructure<Hospital>> entity = new ResponseEntity<ResponseStructure<Hospital>>(structure,
				HttpStatus.CREATED);
		return entity;
	}

	public ResponseEntity<ResponseStructure<Hospital>> updateHospital(int hospitalId, Hospital newHospital) {
		Hospital existHospital = dao.getHospitalById(hospitalId);
		if (existHospital != null) {
			newHospital.setHospitalId(hospitalId);
			ResponseStructure<Hospital> structure = new ResponseStructure<Hospital>();
			structure.setStatus(HttpStatus.CREATED.value());
			structure.setMessage("Data updated successfully");
			structure.setData(dao.updateHospital(newHospital));

			ResponseEntity<ResponseStructure<Hospital>> entity = new ResponseEntity<ResponseStructure<Hospital>>(
					structure, HttpStatus.CREATED);
			return entity;
		}
		return null;
	}

	public ResponseEntity<ResponseStructure<String>> deleteHospital(int hospitalId) {
		ResponseStructure<String> structure = new ResponseStructure<String>();
		structure.setStatus(HttpStatus.NO_CONTENT.value());
		structure.setMessage("Data Deleted Successfully");
		structure.setData(dao.deleteHospital(hospitalId));
		
		ResponseEntity<ResponseStructure<String>> entity = new ResponseEntity<ResponseStructure<String>>(structure, HttpStatus.NO_CONTENT);
		return entity;
	}

}