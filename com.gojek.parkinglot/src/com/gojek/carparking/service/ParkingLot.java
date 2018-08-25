package com.gojek.carparking.service;

import java.text.MessageFormat;

import com.gojek.carparking.common.CommonConstant;
import com.gojek.carparking.config.ParkingParameter;
import com.gojek.carparking.storage.ParkingSearchMap;
import com.gojek.carparking.storage.ParkingSpace;

public class ParkingLot implements IParkingService {

	@Override
	public void doAction(ParkingParameter param) throws NumberFormatException {
		try {

			Integer capacity = Integer.valueOf((String) param.getValue()[1]);
			ParkingSpace.createSlotList(capacity);
			ParkingSearchMap.initializeSearchMap();
			System.out.println(MessageFormat.format(CommonConstant.PARKING_LOT_CREATED, capacity));

		} catch (NumberFormatException e) {
			System.out.println(CommonConstant.ERROR_PARKING_LOT);
		}

	}

}
