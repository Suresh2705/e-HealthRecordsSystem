package org.gov.Hospital_SpringBoot.dao;

import java.util.List;
import java.util.Optional;

import org.gov.Hospital_SpringBoot.dto.Hospital;
import org.gov.Hospital_SpringBoot.repo.HospitalRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class HospitalDao {
	@Autowired
	private HospitalRepo repo;
	
	public Hospital saveHospital(Hospital hospital) {
		return repo.save(hospital);
	}
	
	public Hospital getHospitalById(int id) {
		Optional<Hospital> optional = repo.findById(id);
		if(optional.isPresent())
			return optional.get();
		return null;
	}
	
	public List<Hospital> getAllHospital(){
		return repo.findAll();
	}
	
	public Hospital updateHospital(Hospital hospital) {
		return repo.save(hospital);
	}
	
	public String deleteHospital(int hospitalId) {
		repo.deleteById(hospitalId);
		return "Data Deleted";
	}
}