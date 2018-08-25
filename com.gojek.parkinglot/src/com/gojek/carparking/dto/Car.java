package com.gojek.carparking.dto;

public class Car implements IVehicle {

	private String registrationNo;

	private String color;

	public Car(String registrationNo, String color) {
		this.registrationNo = registrationNo;
		this.color = color;
	}

	@Override
	public String getRegistrationNo() {
		return registrationNo;
	}

	@Override
	public String getColor() {
		return color;
	}

}
