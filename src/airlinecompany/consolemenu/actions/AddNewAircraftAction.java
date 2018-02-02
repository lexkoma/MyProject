package airlinecompany.consolemenu.actions;

import airlinecompany.builderpatterns.CargoAircraftBuilder;
import airlinecompany.builderpatterns.PassengerAircraftBuilder;
import airlinecompany.companyexeptions.NoAirlineCompanyException;
import airlinecompany.consolemenu.chooseandcreate.NewCargoAircraftConsoleCreator;
import airlinecompany.consolemenu.chooseandcreate.NewPassengerAircraftConsoleCreator;
import airlinecompany.enums.comandsenum.AddAircraftsEnum;
import airlinecompany.enums.comandsenum.MessagesForUserEnum;
import airlinecompany.interfaces.ConsoleCreatorBehavior;
import airlinecompany.tools.AirlineManageSystem;

import java.util.Scanner;

import static airlinecompany.enums.comandsenum.MessagesForUserEnum.WARNING_MESSAGE_NEED_AIRLINE_COMPANY;
import static airlinecompany.enums.comandsenum.MessagesForUserEnum.WARNING_MESSAGE_TRY_AGAIN;

/**
 * Class represents an action to create a new aircraft for airlines company park.
 */
public class AddNewAircraftAction {
    //create and add new aircraft
    public static void runAction(AirlineManageSystem airlineCompanyManager, Scanner consoleReader) {
        while (true) {
            try {

                if (!airlineCompanyManager.haveAirlinerCompany()) {
                    throw new NoAirlineCompanyException();
                }

                AddAircraftsEnum getAircraftTypeToCreate = choseAircraftTypeToAdd(consoleReader);

                switch (getAircraftTypeToCreate) {
                    case ADD_NEW_PASSENGER_AIRCRAFT: {
                        ConsoleCreatorBehavior newAircraftConsoleCreator = new NewPassengerAircraftConsoleCreator();
                        newAircraftConsoleCreator.addAndCreateNewAircraft(consoleReader, airlineCompanyManager,
                                new PassengerAircraftBuilder());
                        return;
                    }
                    case ADD_NEW_CARGO_AIRCRAFT: {
                        ConsoleCreatorBehavior newAircraftConsoleCreator = new NewCargoAircraftConsoleCreator();
                        newAircraftConsoleCreator.addAndCreateNewAircraft(consoleReader, airlineCompanyManager,
                                new CargoAircraftBuilder());
                        return;
                    }
                }
            } catch (NoAirlineCompanyException e) {
                System.out.println(WARNING_MESSAGE_NEED_AIRLINE_COMPANY);
                break;
            } catch (IllegalArgumentException e) {
                System.out.println(WARNING_MESSAGE_TRY_AGAIN);
                continue;
            }
        }

    }

    // This method get a type of aircraft to create

    private static AddAircraftsEnum choseAircraftTypeToAdd(Scanner consoleReader) {
        System.out.println(MessagesForUserEnum.getMenuActionAddNewAirecraft());

        String commandAction = consoleReader.nextLine();
        AddAircraftsEnum getAircraftTypeToCreate = AddAircraftsEnum.stringToEnum(commandAction);
        return getAircraftTypeToCreate;
    }
}
