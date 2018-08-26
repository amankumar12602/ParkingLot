package com.gojek.carparking.service;
/**
 * 
 * author:amanss
 */
import com.gojek.carparking.config.ParkingParameter;
import com.gojek.carparking.storage.ParkingSearchMap;

public class ParkingLotByColor implements IParkingService {

	@Override
	public void doParking(ParkingParameter param) {
		String color = param.getValue()[1];
		ParkingSearchMap.getColorLotMap().get(color).forEach(value -> {
			System.out.println(value + 1);
		});
	}

}
