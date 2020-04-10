package com.metacube.parkingSystem.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

@Entity
@Table(name="Pass")
public class Pass {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="PassId")
	private	int passId;

	private double passValue;

	@OneToOne(fetch = FetchType.EAGER)
	private Vehicle vehicle;

	@NotBlank
	private String passType;

	public int getPassId() {
		return passId;
	}

	public void setPassId(int passId) {
		this.passId = passId;
	}

	public double getPassValue() {
		return passValue;
	}

	public void setPassValue(double passValue) {
		this.passValue = passValue;
	}



	public Vehicle getVehicle() {
		return vehicle;
	}

	public void setVehicle(Vehicle vehicle) {
		this.vehicle = vehicle;
	}

	public String getPassType() {
		return passType;
	}

	public void setPassType(String passType) {
		this.passType = passType;
	}






}
