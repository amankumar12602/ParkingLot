package com.gojek.carparking.storage;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import com.gojek.carparking.dto.Car;

public class ParkingSpace {


	private static List<Car> availableSlotList;

	public static List<Car> createSlotList(Integer maxSize) {

		if (availableSlotList == null) {
			synchronized (ParkingSpace.class) {
				if (availableSlotList == null) {
					availableSlotList = new ArrayList<Car>(Collections.nCopies(maxSize, null));
				}
			}
		}
		return availableSlotList;
	}

	public static List<Car> getAvailableSlotList() {
		return availableSlotList;
	}
}
