package com.gojek.carparking.util;

import java.util.ArrayList;
import java.util.List;

import com.gojek.carparking.dto.Car;
import com.gojek.carparking.storage.ParkingSearchMap;

public class SearchMapUpdateUtil {

	public static void addCarToParkingLot(Car car, Integer firstAvaiableSlot){
		ParkingSearchMap.getSlotRegistrationNoMap().put(car.getRegistrationNo(), firstAvaiableSlot);

		List<Integer> parkingLots = ParkingSearchMap.getColorLotMap().get(car.getColor());
		if (parkingLots == null) {
			parkingLots = new ArrayList<>();
		}
		parkingLots.add(firstAvaiableSlot);
		ParkingSearchMap.getColorLotMap().put(car.getColor(), parkingLots);
	}
	
	public static void leaveCarFromParkingLot(Car car, Integer slot){
		
		ParkingSearchMap.getSlotRegistrationNoMap().remove(car.getRegistrationNo());
		ParkingSearchMap.getColorLotMap().get(car.getColor()).remove(slot);
	}
}
