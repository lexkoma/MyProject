package airlinecompany.consolemenu.actions;

import airlinecompany.builderpatterns.AirlineCompanyBuilder;
import airlinecompany.enums.comandsenum.MessagesForUserEnum;
import airlinecompany.tools.AirlineManageSystem;

import java.util.Scanner;

import static airlinecompany.enums.comandsenum.MessagesForUserEnum.WARNING_MESSAGE_TRY_AGAIN;

/**
 * Class represents an action to create a new aircraft airline company.
 */
public class CreateAirlineCompanyAction {

	// This action create a new airline company

	public static void runAction(AirlineManageSystem airlineCompanyManager, Scanner consoleReader) {

		if (airlineCompanyManager.haveAirlinerCompany()) {
			System.out.println("You created an airliner company yet!");
			return;
		}

		AirlineCompanyBuilder airlineCompanyBuilder = new AirlineCompanyBuilder();

		String airlineCompanyName = choseNameForNewAirlineCompany(airlineCompanyManager, consoleReader,
				airlineCompanyBuilder);
		createAirlineCompany(airlineCompanyManager, airlineCompanyBuilder, airlineCompanyName);
		showToUserConsoleAirlineCompanyInformation(airlineCompanyManager);
	}

	//Choose a name from list for a new airline company
	private static String choseNameForNewAirlineCompany(AirlineManageSystem airlineCompanyManager,
			Scanner consoleReader, AirlineCompanyBuilder airlineCompanyBuilder) {

		System.out.println("Please chose a name to create a new airline company:");
		while (true) {

			System.out.println(MessagesForUserEnum.getMenuActionCreateAirlineCompanyInString());
			String companyName = consoleReader.nextLine();

			switch (companyName) {

			case "1": {
				return "MAU";
			}
			case "2": {
				return "Turkish Airlines";
			}
			case "3": {
				createAirlineCompany(airlineCompanyManager, airlineCompanyBuilder, "WizzAir");
				return "WizzAir";
			}
			case "4": {
				createAirlineCompany(airlineCompanyManager, airlineCompanyBuilder, "British Airlines");
				return "British Airlines";
			}
			default: {
				System.out.println(WARNING_MESSAGE_TRY_AGAIN);
				continue;
			}
			}
		}
	}

	// This method create airline company using only selected airline company
	private static void createAirlineCompany(AirlineManageSystem airlineCompanyManager,
			AirlineCompanyBuilder airlineCompanyBuilder, String airlineCompanyName) {

		airlineCompanyBuilder.buildAirlineCompanyByCompanyName(airlineCompanyName);
		airlineCompanyManager.setAirlineCompany(airlineCompanyBuilder.getResult());
	}

	// This method show full to console information about new created airline
	private static void showToUserConsoleAirlineCompanyInformation(AirlineManageSystem airlineCompanyManager) {
		System.out.println("You created a new airline company:");
		System.out.println(airlineCompanyManager.getFullAirlineCompanyInformation());
	}

}
