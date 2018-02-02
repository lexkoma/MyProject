package airlinecompany.consolemenu.actions;

import airlinecompany.enums.comandsenum.MessagesForUserEnum;
import airlinecompany.tools.AirlineManageSystem;

import java.util.Scanner;

import static airlinecompany.enums.comandsenum.MessagesForUserEnum.WARNING_MESSAGE_TRY_AGAIN;

/**
 * Class represents an action to exit an application
 */
public class ExitProgramAction {

	//This action save all aircrafts information to file and exit the program
	public static void runAction(AirlineManageSystem airlineCompanyManager, Scanner consoleReader) {

		while (true) {
			System.out.println(MessagesForUserEnum.getMenuActionExitProgramInString());
			String answer = consoleReader.nextLine();

			switch (answer) {
			case "1": {

				if (airlineCompanyManager.haveAirlinerCompany()) {
					// Save aircrafts data inforamation to file
					SaveAircraftsToFileAction.runAction(airlineCompanyManager);
				} else {
					System.out.println("You didn't create an airline company, exit program without saving to file!");
				}
				closeResoursesAndExitProgram(consoleReader);
				break;
			}
			case "2": {
				closeResoursesAndExitProgram(consoleReader);
				break;
			}
			default: {
				System.out.println(WARNING_MESSAGE_TRY_AGAIN);
				continue;
			}
			}
		}
	}

	//This method close necessary resourses and exit program

	private static void closeResoursesAndExitProgram(Scanner consoleReader) {
		System.out.println("Exit the program!");
		// Closed program resoures
		consoleReader.close();
		// Exit the program
		System.exit(0);
	}
}
