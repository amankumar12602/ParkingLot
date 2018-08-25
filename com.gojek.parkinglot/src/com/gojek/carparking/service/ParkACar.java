package com.gojek.carparking.service;

import java.text.MessageFormat;

import com.gojek.carparking.common.CommonConstant;
import com.gojek.carparking.dto.Car;
import com.gojek.carparking.storage.ParkingSpace;
import com.gojek.carparking.util.SearchMapUpdateUtil;
import com.gojek.carparking.vo.ParkingParameter;

public class ParkACar implements IParkingService {

	@Override
	public void doAction(ParkingParameter param) {
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