package com.gojek.carparking.junit.service;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.gojek.carparking.config.ParkingParameter;
import com.gojek.carparking.service.ParkACar;
import com.gojek.carparking.service.ParkingLot;
import com.gojek.carparking.service.ParkingStatus;

public class ParkingStatusTest {

	private ParkingStatus parkingStatus;

	private ParkACar parking;
	
	private ParkingLot lot;

	@Before
	public void setUp() throws Exception {

		parking = new ParkACar();

		parkingStatus = new ParkingStatus();
		
		lot = new ParkingLot();
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testDoAction() {
		
		ParkingParameter param = new ParkingParameter();
		param.setValue(new String[] { "create_parking_lot", "6" });
		lot.doAction(param);

		param.setValue(new String[] { "status" });
		parkingStatus.doAction(param);

		param.setValue(new String[] { "park", "KA-01-HH-1234", "White" });
		parking.doAction(param);

		param.setValue(new String[] { "status" });
		parkingStatus.doAction(param);

	}

}
