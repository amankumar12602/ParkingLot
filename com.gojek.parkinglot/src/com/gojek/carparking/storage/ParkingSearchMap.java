package com.gojek.carparking.storage;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ParkingSearchMap {

	private static Map<String, Integer> slotRegistrationNoMap;
	private static Map<String, List<Integer>> colorLotMap;

	public static void initializeSearchMap() {

		if (slotRegistrationNoMap == null) {
			synchronized (ParkingSpace.class) {
				if (slotRegistrationNoMap == null) {
					slotRegistrationNoMap = new HashMap<String, Integer>();
					colorLotMap = new HashMap<>();
				}
			}
		}
	}

	public static Map<String, Integer> getSlotRegistrationNoMap() {
		if (slotRegistrationNoMap == null) {
			initializeSearchMap();
		}
		return slotRegistrationNoMap;
	}

	public static Map<String, List<Integer>> getColorLotMap() {
		if (colorLotMap == null) {
			initializeSearchMap();
		}
		return colorLotMap;
	}

}
