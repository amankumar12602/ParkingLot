package com.gojek.carparking.service;

import com.gojek.carparking.config.ParkingParameter;
import com.gojek.carparking.storage.ParkingSearchMap;
import com.gojek.carparking.storage.ParkingSpace;

public class RegistrationNoByColor implements IParkingService {

	@Override
	public void doParking(ParkingParameter param) {
		String color = param.getValue()[1];

		ParkingSearchMap.getColorLotMap().get(color).forEach(slot -> {
			System.out.println(ParkingSpace.getAvailableSlotList().get(slot).getRegistrationNo());
		});
	}

}
