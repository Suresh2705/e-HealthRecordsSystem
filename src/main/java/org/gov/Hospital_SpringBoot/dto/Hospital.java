package org.gov.Hospital_SpringBoot.dto;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class Hospital {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int hospitalId;
	private String hospitalName;
	private String hospitalAddress;
	private long hospitalPincode;
	private long hospitalPhone;
	
	@OneToMany(cascade = CascadeType.ALL)
	private List<Patient> patient;

	public int getHospitalId() {
		return hospitalId;
	}

	public void setHospitalId(int hospitalId) {
		this.hospitalId = hospitalId;
	}

	public String getHospitalName() {
		return hospitalName;
	}

	public void setHospitalName(String hospitalName) {
		this.hospitalName = hospitalName;
	}

	public String getHospitalAddress() {
		return hospitalAddress;
	}

	public void setHospitalAddress(String hospitalAddress) {
		this.hospitalAddress = hospitalAddress;
	}

	public long getHospitalPincode() {
		return hospitalPincode;
	}

	public void setHospitalPincode(long hospitalPincode) {
		this.hospitalPincode = hospitalPincode;
	}

	public long getHospitalPhone() {
		return hospitalPhone;
	}

	public void setHospitalPhone(long hospitalPhone) {
		this.hospitalPhone = hospitalPhone;
	}

	public List<Patient> getPatient() {
		return patient;
	}

	public void setPatients(List<Patient> patient) {
		this.patient = patient;
	}
}