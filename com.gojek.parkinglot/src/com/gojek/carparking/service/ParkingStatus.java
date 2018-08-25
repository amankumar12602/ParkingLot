package com.gojek.carparking.service;

import java.util.stream.IntStream;

import com.gojek.carparking.dto.Car;
import com.gojek.carparking.storage.ParkingSearchMap;
import com.gojek.carparking.storage.ParkingSpace;
import com.gojek.carparking.vo.ParkingParameter;

public class ParkingStatus implements IParkingService {

	@Override
	public void doAction(ParkingParameter param) {
		if (ParkingSearchMap.getSlotRegistrationNoMap().isEmpty()) {
			System.out.println("Parking lot is empty");
			return;
		}

		System.out.println("Lot No" + "    " + "Registration No" + "    " + "Color");

		IntStream.range(0, ParkingSpace.getAvailableSlotList().size()).forEach(i -> {
			Car car = ParkingSpace.getAvailableSlotList().get(i);
			if (car != null) {
				int j = i + 1;
				System.out.println("   " + j + "    " + car.getRegistrationNo() + "    " + car.getColor());
			}
		});
	}

}