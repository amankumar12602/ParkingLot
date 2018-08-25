package com.gojek.carparking.service;

import java.text.MessageFormat;

import com.gojek.carparking.common.CommonConstant;
import com.gojek.carparking.config.ParkingParameter;
import com.gojek.carparking.dto.Car;
import com.gojek.carparking.storage.ParkingSpace;
import com.gojek.carparking.util.SearchMapUpdateUtil;

public class LeaveParking implements IParkingService {

	@Override
	public void doAction(ParkingParameter param) {

		try {
			Integer slot = Integer.parseInt(param.getValue()[1]);
			Car car = ParkingSpace.getAvailableSlotList().get(slot - 1);

			if (car == null) {
				System.out.println(CommonConstant.NOT_FOUND);
				return;
			}

			ParkingSpace.getAvailableSlotList().set(slot - 1, null);
			
			SearchMapUpdateUtil.leaveCarFromParkingLot(car, slot);

			System.out.println(MessageFormat.format(CommonConstant.SLOT_FREE, slot));

		} catch (NumberFormatException ex) {
			System.out.println(CommonConstant.ERROR_INVALID_SPACE_NO);
			return;
		}

	}

}
