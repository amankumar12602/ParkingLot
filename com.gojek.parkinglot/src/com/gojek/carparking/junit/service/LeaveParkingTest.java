package com.gojek.carparking.junit.service;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.gojek.carparking.config.ParkingParameter;
import com.gojek.carparking.service.LeaveParking;
import com.gojek.carparking.service.ParkACar;
import com.gojek.carparking.service.ParkingLot;

public class LeaveParkingTest {

	LeaveParking leaveParking;

	private ParkACar parking;

	private ParkingLot service;

	@Before
	public void setUp() throws Exception {
		leaveParking = new LeaveParking();
		parking = new ParkACar();
		service = new ParkingLot();
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testDoAction() {

		ParkingParameter param = new ParkingParameter();
		param.setValue(new String[] { "create_parking_lot", "6" });
		service.doParking(param);

		param.setValue(new String[] { "park", "KA-01-HH-1234", "White" });
		parking.doParking(param);

		param.setValue(new String[] { "leave", "1" });
		leaveParking.doParking(param);

	}

}
