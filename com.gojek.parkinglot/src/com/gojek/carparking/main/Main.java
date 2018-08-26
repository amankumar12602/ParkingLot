package com.gojek.carparking.main;
/**
 * 
 * author:amanss
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) {

		switch (args.length) {
		case 0:
			System.out.println("Please enter 'exit' to quit");
			System.out.println("Please Input appropriate Command.....");

			for (;;) {
				try {
					BufferedReader bufferRead = new BufferedReader(new InputStreamReader(System.in));
					String inputString = bufferRead.readLine();
					if (inputString.equalsIgnoreCase("exit")) {
						break;
					} else if ((inputString == null) || (inputString.isEmpty())) {

					} else {
						FileParser.parseTextInput(inputString.trim());
					}
				} catch (IOException e) {
					System.out.println("Error in reading the input from console.");
					e.printStackTrace();
				}
			}
			break;
		case 1:
			FileParser.parseInputFile(args[0]);
			break;
		default:
			String filePath = "resources/input.txt";
			FileParser.parseInputFile(filePath);
		}

	}

}
