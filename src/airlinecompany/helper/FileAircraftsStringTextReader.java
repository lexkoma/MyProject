
package airlinecompany.helper;


import airlinecompany.builderpatterns.*;
import airlinecompany.maininfrastructure.aircrafts.Aircraft;
import airlinecompany.interfaces.AircraftBuilderBehavior;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

/**
 * Class has method to read Aircraft object's from data text file using parsing string
 */

public class FileAircraftsStringTextReader extends FileAircraftsReader {

	// This is a string constant to split aircraft's fields for parsing from text file
	private final static String WORD_SPLITTER = "\\|";

	// This is a string constant, referse to create a passenger aircraft object
	private final static String PASSENGER_AIRCRAFT = "PassengerAircraft";

	// This is a string constant, referse to create a cargo aircraft object
	private final static String CARGO_AIRCRAFT = "CargoAircraft";

	// This is a constant array index value for a passenger aircraft object to parse an aircraft type from text file
	private final static int AIRCRAFT_TYPE_ARRAY_INDEX = 0;

	// This is a constant array index value for a passenger aircraft object to parse an aircraft id field from text file
	private final static int AIRCRAFT_ID_ARRAY_INDEX = 1;

	//This is a constant array index value for a passenger aircraft object to parse an aircraft name field from text file
	private final static int AIRCRAFT_NAME_ARRAY_INDEX = 2;

	//This is a constant array index value for a passenger aircraft object to parse an aircraft max weight
	// capacity field from text file
	private final static int AIRCRAFT_MAX_WEIGHT_CAPACITY_ARRAY_INDEX = 3;

	//This is a constant array index value for a passenger aircraft object to
	// parse an aircraft fuel consumption field from text file
	private final static int AIRCRAFT_FUEL_CONSUMPTION_ARRAY_INDEX = 4;

	//This is a constant array index value for a passenger aircraft object to
	// parse an aircraft speed field from text file
	private final static int AIRCRAFT_SPEED_ARRAY_INDEX = 5;

	//This is a constant array index value for a passenger aircraft object to
	// parse an aircraft people capacity field from text file
	private final static int AIRCRAFT_PEOPLE_CAPACITY_ARRAY_INDEX = 6;

	//This is a constant array index value for a passenger aircraft object to
	// parse an airliner type field from text file
	private final static int AIRCRAFT_AIRLINER_TYPE_ARRAY_INDEX = 7;

	//This is a constant array index value for a passenger aircraft object to
	// parse can airliner airliner have bussienss class field from text file
	private final static int AIRCRAFT_HAVE_BUSSINES_CLASS_ARRAY_INDEX = 8;

	//This is a constant array index value for a cargo aircraft object to parse
	// a cargo department size field from text file
	private final static int AIRCRAFT_CARGO_DEPARTMENT_SIZE_ARRAY_INDEX = 7;

	//This is a constant array index value for a cargo aircraft object to parse
	//can transport passenger field from text file
	private final static int AIRCRAFT_CAN_TRANSPORT_PASSENGER_ARRAY_INDEX = 8;

	// This method get the list of aircrafts, which was parsed from text file
	public List<Aircraft> readAircraftListFromFile() throws IOException {

		try (BufferedReader in = new BufferedReader(new FileReader(new File(pathToFile)))) {
			List<Aircraft> listOfAircraft = new LinkedList<>();
			String aircraftString = null;

			while ((aircraftString = in.readLine()) != null) {
				String[] fieldsOfAircraft = aircraftString.split(WORD_SPLITTER);

				if (fieldsOfAircraft[AIRCRAFT_TYPE_ARRAY_INDEX].equalsIgnoreCase(PASSENGER_AIRCRAFT)) {
					listOfAircraft.add(FileAircraftsStringTextReader.createPassengerLinerAicraft(fieldsOfAircraft));

				} else if (fieldsOfAircraft[AIRCRAFT_TYPE_ARRAY_INDEX].equalsIgnoreCase(CARGO_AIRCRAFT)) {
					listOfAircraft.add(FileAircraftsStringTextReader.createCargoAircraft(fieldsOfAircraft));
				}
			}
			return listOfAircraft;
		}
	}

	//This method create passenger aircraft object with the fields, which were parsed from text file

	private static Aircraft createPassengerLinerAicraft(String[] fieldsOfAircraft) {

		// Create a new airliner aircraft object
		AircraftBuilderBehavior buildAircraft = new PassengerAircraftBuilder();
		buildAircraft.setId(Integer.parseInt(fieldsOfAircraft[AIRCRAFT_ID_ARRAY_INDEX]));
		buildAircraft.setName(fieldsOfAircraft[AIRCRAFT_NAME_ARRAY_INDEX]);

		// Create BasicTeachAircraftData for a new airliner aircraft object
		BasicTechAircraftBuilder techDataBuild = createBasicAircraftTechData(fieldsOfAircraft);
		buildAircraft.setBasicTechSpecification(techDataBuild.getResult());

		// Create AirlinerTechData for a new airliner aircraft object
		PassengerAircraftTechDataBuilder buildAirlinerTechData = createPassengeLinerAircraftTechData(fieldsOfAircraft);
		buildAircraft.setUniqueAircraftTechData(buildAirlinerTechData.getResult());

		return buildAircraft.getResult();
	}

	// This method create BasicTeachAircraftData for a new passenger aircraft
	private static BasicTechAircraftBuilder createBasicAircraftTechData(String[] fieldsOfAircraft)
			throws NumberFormatException {

		BasicTechAircraftBuilder techDataBuild = new BasicTechAircraftBuilder();
		techDataBuild
				.setCargoCapacity(Integer.parseInt(fieldsOfAircraft[AIRCRAFT_MAX_WEIGHT_CAPACITY_ARRAY_INDEX]));
		techDataBuild.setConsumption(Integer.parseInt(fieldsOfAircraft[AIRCRAFT_FUEL_CONSUMPTION_ARRAY_INDEX]));
		techDataBuild.setSpeed(Integer.parseInt(fieldsOfAircraft[AIRCRAFT_SPEED_ARRAY_INDEX]));
		techDataBuild.setPassengers(Integer.parseInt(fieldsOfAircraft[AIRCRAFT_PEOPLE_CAPACITY_ARRAY_INDEX]));

		return techDataBuild;
	}

	//This method create PassengerLinerTechData for a new airliner aircraft object
	private static PassengerAircraftTechDataBuilder createPassengeLinerAircraftTechData(String[] fieldsOfAircraft) {

		PassengerAircraftTechDataBuilder buildAirlinerTechData = new PassengerAircraftTechDataBuilder();
		buildAirlinerTechData.setPassengerLinerType(fieldsOfAircraft[AIRCRAFT_AIRLINER_TYPE_ARRAY_INDEX]);
		buildAirlinerTechData
				.setLuggageAvailability(Boolean.parseBoolean(fieldsOfAircraft[AIRCRAFT_HAVE_BUSSINES_CLASS_ARRAY_INDEX]));

		return buildAirlinerTechData;
	}

	// This method create a cargo aircraft object with the fields, which were
	private static Aircraft createCargoAircraft(String[] fieldsOfAircraft) {

		// Create a new cargo aircraft object
		AircraftBuilderBehavior buildAircraft = new CargoAircraftBuilder();
		buildAircraft.setId(Integer.parseInt(fieldsOfAircraft[AIRCRAFT_ID_ARRAY_INDEX]));
		buildAircraft.setName(fieldsOfAircraft[AIRCRAFT_NAME_ARRAY_INDEX]);

		// Create BasicTeachAircraftData for a new cargo aircraft object
		BasicTechAircraftBuilder techDataBuild = createBasicAircraftTechData(fieldsOfAircraft);
		buildAircraft.setBasicTechSpecification(techDataBuild.getResult());

		// Create CargoTechData for a new cargo aircraft
		CargoAircraftTechDataBuilder buildCargoTechData = createCargoAircraftTechData(fieldsOfAircraft);
		buildAircraft.setUniqueAircraftTechData(buildCargoTechData.getResult());

		return buildAircraft.getResult();
	}

	//This method create CargoTechData for a new airliner aircraft
	private static CargoAircraftTechDataBuilder createCargoAircraftTechData(String[] fieldsOfAircraft)
			throws NumberFormatException {

		CargoAircraftTechDataBuilder buildCargoTechData = new CargoAircraftTechDataBuilder();
		buildCargoTechData
				.setCompartmentSize(Integer.parseInt(fieldsOfAircraft[AIRCRAFT_CARGO_DEPARTMENT_SIZE_ARRAY_INDEX]));
		buildCargoTechData.setAnimallsAvailability(
				Boolean.parseBoolean(fieldsOfAircraft[AIRCRAFT_CAN_TRANSPORT_PASSENGER_ARRAY_INDEX]));

		return buildCargoTechData;
	}
}
