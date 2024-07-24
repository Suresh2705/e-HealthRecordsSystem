package org.gov.Hospital_SpringBoot.service;

import java.util.List;

import org.gov.Hospital_SpringBoot.dao.HospitalDao;
import org.gov.Hospital_SpringBoot.dao.PatientDao;
import org.gov.Hospital_SpringBoot.dto.Hospital;
import org.gov.Hospital_SpringBoot.dto.Patient;
import org.gov.Hospital_SpringBoot.util.ResponseStructure;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class PatientService {

	@Autowired
	private PatientDao dao;

	@Autowired
	private HospitalDao hospitalDao;

	public ResponseEntity<ResponseStructure<Hospital>> savePatient(int hospitalId, Patient patient) {
		Hospital hospital = hospitalDao.getHospitalById(hospitalId);
//		ResponseStructure<Hospital> structure = new ResponseStructure<Hospital>();
		if (hospital != null) {
			List<Patient> list = hospital.getPatient();
			list.add(patient);
			ResponseStructure<Hospital> structure = new ResponseStructure<Hospital>();
			structure.setStatus(HttpStatus.CREATED.value());
			structure.setMessage("Data Updated");
			structure.setData(hospitalDao.updateHospital(hospital));
			
			ResponseEntity<ResponseStructure<Hospital>> entity = new ResponseEntity<ResponseStructure<Hospital>>(structure, HttpStatus.CREATED);
			
			return entity;
		}
//		structure.setStatus(HttpStatus.BAD_REQUEST.value());
//		structure.setMessage("Data Not Updated, Something went wrong");
////		structure.setData(hospitalDao.updateHospital(hospital));
//		ResponseEntity<ResponseStructure<Hospital>> entity = new ResponseEntity<ResponseStructure<Hospital>>(structure, HttpStatus.BAD_REQUEST);
//		return entity;
		return null;
	}

	public ResponseEntity<ResponseStructure<Patient>> getPatientById(int id) {
		ResponseStructure<Patient> structure = new ResponseStructure<Patient>();
		structure.setStatus(HttpStatus.OK.value());
		structure.setMessage("Details received successfully");
		structure.setData(dao.getPatientById(id));
		
		ResponseEntity<ResponseStructure<Patient>> entity = new ResponseEntity<ResponseStructure<Patient>>(structure, HttpStatus.OK);
		return entity;
	}

	public ResponseEntity<ResponseStructure<List<Patient>>> getPatientByName(String name) {
		ResponseStructure<List<Patient>> structure = new ResponseStructure<List<Patient>>();
		structure.setStatus(HttpStatus.OK.value());
		structure.setMessage("Details received Successfully by name");
		structure.setData(dao.getPatientByName(name));
		
		ResponseEntity<ResponseStructure<List<Patient>>> entity = new ResponseEntity<ResponseStructure<List<Patient>>>(structure, HttpStatus.OK);
		return entity;
	}

	public ResponseEntity<ResponseStructure<List<Patient>>> getAll() {
		ResponseStructure<List<Patient>> structure = new ResponseStructure<List<Patient>>();
		structure.setStatus(HttpStatus.OK.value());
		structure.setMessage("All details received successfully");
		structure.setData(dao.getAll());
		
		ResponseEntity<ResponseStructure<List<Patient>>> entity = new ResponseEntity<ResponseStructure<List<Patient>>>(structure, HttpStatus.OK);
		return entity;
	}

	public ResponseEntity<ResponseStructure<Hospital>> deleteById(int hospitalId, int patientId) {
		Hospital hospitalById = hospitalDao.getHospitalById(hospitalId);
		Patient patientById = dao.getPatientById(patientId);
		List<Patient> patientList = hospitalById.getPatient();
		patientList.remove(patientById);
		dao.deleteById(patientId);
		ResponseStructure<Hospital> structure = new ResponseStructure<Hospital>();
		structure.setStatus(HttpStatus.NO_CONTENT.value());
		structure.setMessage("Data Deleted");
		structure.setData(hospitalDao.saveHospital(hospitalById));
		
		ResponseEntity<ResponseStructure<Hospital>> entity = new ResponseEntity<ResponseStructure<Hospital>>(structure, HttpStatus.NO_CONTENT);
		return entity;
	}

	public ResponseEntity<ResponseStructure<Patient>> updatePatient(int id, Patient patient) {
		Patient existPatient = dao.getPatientById(id);
		if (existPatient != null) {
			patient.setPatientId(id);
			ResponseStructure<Patient> structure = new ResponseStructure<Patient>();
			structure.setStatus(HttpStatus.CREATED.value());
			structure.setMessage("Data updated Successfully");
			structure.setData(dao.updatePatient(patient));
			
			ResponseEntity<ResponseStructure<Patient>> entity = new ResponseEntity<ResponseStructure<Patient>>(structure, HttpStatus.CREATED);
			return entity;
		}
		return null;
	}
}