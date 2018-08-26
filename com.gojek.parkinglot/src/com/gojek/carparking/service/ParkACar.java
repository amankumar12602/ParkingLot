package com.gojek.carparking.service;
/**
 * 
 * author:amanss
 */
import java.text.MessageFormat;

import com.gojek.carparking.common.CommonConstant;
import com.gojek.carparking.config.ParkingParameter;
import com.gojek.carparking.dto.Car;
import com.gojek.carparking.storage.ParkingSpace;
import com.gojek.carparking.util.SearchMapUpdateUtil;

public class ParkACar implements IParkingService {

	@Override
	public void doParking(ParkingParameter param) {
		Integer firstAvaiableSlot = getFirstEmptySlot();

		if (firstAvaiableSlot == null) {
			System.out.println(CommonConstant.PARKING_FULL);
			return;
		}

		Car car = new Car(param.getValue()[1], param.getValue()[2]);
		SearchMapUpdateUtil.addCarToParkingLot(car, firstAvaiableSlot);

		ParkingSpace.getAvailableSlotList().set(firstAvaiableSlot, car);
		System.out.println(MessageFormat.format(CommonConstant.PARKING_SPACE_BLOCKED, firstAvaiableSlot + 1,
				car.getRegistrationNo()));
	}

	private Integer getFirstEmptySlot() {
		for (int slot = 0; slot < ParkingSpace.getAvailableSlotList().size(); slot++) {
			if (ParkingSpace.getAvailableSlotList().get(slot) == null) {
				return slot;
			}
		}
		return null;
	}
}
