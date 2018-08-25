package com.gojek.carparking.service;

import com.gojek.carparking.common.CommonConstant;
import com.gojek.carparking.config.ParkingParameter;
import com.gojek.carparking.storage.ParkingSearchMap;

public class ParkingLotByRegistrationNo implements IParkingService {

	@Override
	public void doAction(ParkingParameter param) {

		String registrationNo = param.getValue()[1];
		Integer result = ParkingSearchMap.getSlotRegistrationNoMap().get(registrationNo);

		if (result == null) {
			System.out.println(CommonConstant.NOT_FOUND);
		} else {
			System.out.println(result+1);
		}

	}

}
