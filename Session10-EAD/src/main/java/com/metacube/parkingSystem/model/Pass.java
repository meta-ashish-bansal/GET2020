package com.metacube.parkingSystem.model;

import javax.validation.constraints.NotBlank;

public class Pass {

	private	int passId;

	private double passValue;

	private int vehicleId;

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

	public int getVehicleId() {
		return vehicleId;
	}

	public void setVehicleId(int vehicleId) {
		this.vehicleId = vehicleId;
	}

	public String getPassType() {
		return passType;
	}

	public void setPassType(String passType) {
		this.passType = passType;
	}






}
