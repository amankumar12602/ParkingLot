package com.gojek.carparking.junit.service;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.gojek.carparking.config.ParkingParameter;
import com.gojek.carparking.service.ParkACar;
import com.gojek.carparking.service.ParkingLot;
import com.gojek.carparking.service.RegistrationNoByColor;

public class RegistrationNoByColorTest {

	private ParkACar parking;

	private RegistrationNoByColor regNoByColor;
	
	private ParkingLot lot;

	@Before
	public void setUp() throws Exception {
		parking = new ParkACar();
		regNoByColor = new RegistrationNoByColor();
		lot = new ParkingLot();
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testDoAction() {

		ParkingParameter param = new ParkingParameter();
		param.setValue(new String[] { "create_parking_lot", "6" });
		lot.doParking(param);

		param.setValue(new String[] { "park", "KA-01-HH-1234", "White" });
		parking.doParking(param);

		param.setValue(new String[] { "registration_numbers_for_cars_with_colour", "White" });
		regNoByColor.doParking(param);

		param.setValue(new String[] { "registration_numbers_for_cars_with_colour", "White" });
		regNoByColor.doParking(param);
	}

}
