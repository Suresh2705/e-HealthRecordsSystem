package org.gov.Hospital_SpringBoot.repo;

import org.gov.Hospital_SpringBoot.dto.Hospital;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HospitalRepo extends JpaRepository<Hospital, Integer>{
	
	public Hospital findByHospitalPincode(long hospitalPincode);

}
