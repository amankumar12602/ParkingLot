package com.gojek.carparking.junit.service;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.gojek.carparking.config.ParkingParameter;
import com.gojek.carparking.service.ParkingLot;
import com.gojek.carparking.storage.ParkingSpace;

public class ParkingLotTest {

	private ParkingLot service;

	@Before
	public void setUp() throws Exception {
		service = new ParkingLot();
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testDoAction() {
		int maxSize = 6;
		ParkingParameter param = new ParkingParameter();
		param.setValue(new String[] { "create_parking_lot", "6" });
		service.doAction(param);
		List<com.gojek.carparking.dto.Car> availablity = ParkingSpace.getAvailableSlotList();
		assertTrue(availablity.size() == maxSize);

	}

}
