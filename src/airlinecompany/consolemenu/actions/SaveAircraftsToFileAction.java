package airlinecompany.consolemenu.actions;


import airlinecompany.companyexeptions.AirlineEmptyParkException;
import airlinecompany.companyexeptions.NoAirlineCompanyException;
import airlinecompany.tools.AirlineManageSystem;

import java.io.IOException;

import static airlinecompany.enums.comandsenum.MessagesForUserEnum.WARNING_MESSAGE_EMPTY_PARK;
import static airlinecompany.enums.comandsenum.MessagesForUserEnum.WARNING_MESSAGE_NEED_AIRLINE_COMPANY;
import static airlinecompany.enums.comandsenum.MessagesForUserEnum.WARNING_MESSAGE_PROBLEM_WRITE_OR_READ_FILE;

/**
 * Class represents an action to save aircrafts to data file in OS.
 */
public class SaveAircraftsToFileAction {

	//This method action save all aircrafts information to file

	public static void runAction(AirlineManageSystem airlineCompanyManager) {
		try {

			airlineCompanyManager.saveToFile();
			System.out.println("Saved information about aircrafts to file");

		} catch (NoAirlineCompanyException e) {
			System.out.println(WARNING_MESSAGE_NEED_AIRLINE_COMPANY);
		} catch (AirlineEmptyParkException e) {
			System.out.println(WARNING_MESSAGE_EMPTY_PARK);
		} catch (IOException e) {
			System.out.println(WARNING_MESSAGE_PROBLEM_WRITE_OR_READ_FILE);
		}

	}

}
