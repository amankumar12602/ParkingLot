package com.gojek.carparking.service;

import com.gojek.carparking.storage.ParkingSearchMap;
import com.gojek.carparking.vo.ParkingParameter;

public class ParkingLotByColor implements IParkingService {

	@Override
	public void doAction(ParkingParameter param) {
		String color = param.getValue()[1];
		ParkingSearchMap.getColorLotMap().get(color).forEach(value -> {
			System.out.println(value + 1);
		});
	}

}
