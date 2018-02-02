
package airlinecompany.helper;

import airlinecompany.maininfrastructure.aircrafts.Aircraft;
import airlinecompany.maininfrastructure.aircrafts.CargoAircraft;
import airlinecompany.maininfrastructure.aircrafts.PassengerAircraft;
import airlinecompany.technicalspecification.*;

import java.io.*;
import java.util.Iterator;
import java.util.List;

/**
 * writing Aircraft objects to data text file using parsing string.
 */
public class FileAircraftsStringTextWriter extends FileAircraftsWriter {

	//This method write the list of aircrafts to text file
	public void writeAircraftListToFile(List<Aircraft> aircraftsList) throws IOException {

		try (PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter(new File(pathToFile))))) {

			for (Iterator<Aircraft> iterator = aircraftsList.iterator(); iterator.hasNext();) {
				Aircraft aircraft = (Aircraft) iterator.next();

				if (aircraft instanceof PassengerAircraft) {

					PassengerAircraft airlinerAircraft = (PassengerAircraft) aircraft;
					// Write all data of passenger aircraft to text file in string
					out.println(
							(String) FileAircraftsStringTextWriter.getParsedAirlinerAircraftFields(airlinerAircraft));

				} else if (aircraft instanceof CargoAircraft) {

					CargoAircraft cargoAircraft = (CargoAircraft) aircraft;
					// Write all data of cargoAircraft to text file in string
					out.println((String) FileAircraftsStringTextWriter.getParsedCargoAircraftFields(cargoAircraft));
				}
			}
		}
	}

	//This method parse fields of airliner aircraft to string with symbol -
	private static String getParsedAirlinerAircraftFields(PassengerAircraft passengerAircraft) {

		// Parse all fields from airlinerAircraft to string

		// ---BasicTechAircraftData
		int idAircraft = 0;
		String nameAircraft = passengerAircraft.getNameOfAircraft();
		CarryingCapacity maxWeigthCapacity = (CarryingCapacity) passengerAircraft.getBasicTechAircraftData()
				.getMaxCarryingCapacity();
		FuelConsumption fuelConsumption = (FuelConsumption) passengerAircraft.getBasicTechAircraftData()
				.getFuelConsumption();
		FlightSpeed speed = (FlightSpeed) passengerAircraft.getBasicTechAircraftData()
				.getAverageFlightSpeed();
		BoarderCapacity peopleCapacity = (BoarderCapacity) passengerAircraft.getBasicTechAircraftData()
				.getMaxPassengerCapacity();

		// ---AirlinerTechData
		String airlinerType = (String) passengerAircraft.getPassengerLinerTechData().getPassengerLinerType();
		boolean havBusinesClass = (boolean) passengerAircraft.getPassengerLinerTechData().haveLuggageCompartment();

		// Create a string type value, which consists of parsed to string
		// airlinerAircraft fields
		String parseAirlinerAircraftData = parseAirlinerAircraftTechDataToString(idAircraft, nameAircraft,
				maxWeigthCapacity, fuelConsumption, speed, peopleCapacity, airlinerType, havBusinesClass);

		return parseAirlinerAircraftData;
	}

	// This method method parse airliner tech data to string

	private static String parseAirlinerAircraftTechDataToString(int idAircraft, String nameAircraft,
			CarryingCapacity maxWeigthCapacity, FuelConsumption fuelConsumption, FlightSpeed speed,
			BoarderCapacity peopleCapacity, String airlinerType, boolean havBusinesClass) {

		String parseAirlinerAircraftData = ("AirlinerAircraft" + "|" + idAircraft + "|" + nameAircraft + "|"
				+ maxWeigthCapacity.getMeasureValueInInt() + "|" + fuelConsumption.getMeasureValueInInt() + "|"
				+ speed.getMeasureValueInInt() + "|" + peopleCapacity.getMeasureValueInInt() + "|" + airlinerType
				+ "|" + havBusinesClass);

		return parseAirlinerAircraftData;
	}

	//This method parse fields of cargo aircraft to string with spliter"|"
	private static String getParsedCargoAircraftFields(CargoAircraft cargoAircraft) {

		//// Parse all fields from cargoAircraft to string

		// ---BasicTechAircraftData
		int idAircraft = 0;
		String nameOfAircraft = cargoAircraft.getNameOfAircraft();
		CarryingCapacity maxWeigthCapacity = (CarryingCapacity) cargoAircraft.getBasicTechAircraftData()
				.getMaxCarryingCapacity();
		FuelConsumption fuelConsumption = (FuelConsumption) cargoAircraft.getBasicTechAircraftData().getFuelConsumption();
		FlightSpeed speed = (FlightSpeed) cargoAircraft.getBasicTechAircraftData().getAverageFlightSpeed();
		BoarderCapacity peopleCapacity = (BoarderCapacity) cargoAircraft.getBasicTechAircraftData()
				.getMaxPassengerCapacity();

		// ---CargoAircraftTechData
		CargoVolume cargoDepartmentSize = (CargoVolume) cargoAircraft.getCargoAircraftTechdata().getCargoVolume();
		;
		boolean canTransportPassengers = (boolean) cargoAircraft.getCargoAircraftTechdata().canTransportAnimals();

		// Create a string type value, which consists of parsed to string
		// cargoAircraft fields
		String parseCargoAircraftData = parseCargoAircraftTechDataToString(idAircraft, nameOfAircraft, maxWeigthCapacity,
				fuelConsumption,speed, peopleCapacity, cargoDepartmentSize, canTransportPassengers);

		return parseCargoAircraftData;
	}

	//This method method parse cargo aircraft tech data to string

	private static String parseCargoAircraftTechDataToString(int idAircraft, String nameOfAircraft,
			CarryingCapacity maxWeigthCapacity, FuelConsumption fuelConsumption, FlightSpeed speed,
			BoarderCapacity peopleCapacity, CargoVolume cargoDepartmentSize, boolean canTransportPassengers) {

		String parseCargoAircraftData = ("CargoAircraft" + "|" + idAircraft + "|" + nameOfAircraft + "|"
				+ maxWeigthCapacity.getMeasureValueInInt() + "|" + fuelConsumption.getMeasureValueInInt() + "|"
				+ speed.getMeasureValueInInt() + "|" + peopleCapacity.getMeasureValueInInt() + "|"
				+ cargoDepartmentSize.getMeasureValueInInt() + "|" + canTransportPassengers);

		return parseCargoAircraftData;
	}

}
