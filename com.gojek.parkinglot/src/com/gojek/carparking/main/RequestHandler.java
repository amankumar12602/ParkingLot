package com.gojek.carparking.main;

import java.util.HashMap;
import java.util.Map;

import com.gojek.carparking.service.ParkingLotByColor;
import com.gojek.carparking.service.RegistrationNoByColor;
import com.gojek.carparking.service.ParkACar;
import com.gojek.carparking.service.LeaveParking;
import com.gojek.carparking.service.ParkingLotByRegistrationNo;
import com.gojek.carparking.service.ParkingLot;
import com.gojek.carparking.config.ParkingParameter;
import com.gojek.carparking.service.IParkingService;
import com.gojek.carparking.service.ParkingStatus;

public class RequestHandler {

	private static Map<String, IParkingService> commandMap;

	public static void handleRequest(String action, String[] values) {
		if (commandMap == null) {
			prepareCommandMap();
		}
		
		IParkingService service = commandMap.get(action);
		ParkingParameter param = new ParkingParameter();
		param.setValue(values);
		service.doAction(param);
	}

	public static void prepareCommandMap() {
		commandMap = new HashMap<>();

		commandMap.put("create_parking_lot", new ParkingLot());
		commandMap.put("park", new ParkACar());
		commandMap.put("leave", new LeaveParking());
		commandMap.put("status", new ParkingStatus());
		commandMap.put("registration_numbers_for_cars_with_colour", new RegistrationNoByColor());
		commandMap.put("slot_numbers_for_cars_with_colour", new ParkingLotByColor());
		commandMap.put("slot_number_for_registration_number", new ParkingLotByRegistrationNo());
	}

}
