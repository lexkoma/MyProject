package airlinecompany.consolemenu.actions;


import airlinecompany.companyexeptions.AirlineEmptyParkException;
import airlinecompany.companyexeptions.NoAirlineCompanyException;
import airlinecompany.maininfrastructure.aircrafts.Aircraft;
import airlinecompany.tools.AirlineManageSystem;

import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

import static airlinecompany.enums.comandsenum.MessagesForUserEnum.WARNING_MESSAGE_EMPTY_PARK;
import static airlinecompany.enums.comandsenum.MessagesForUserEnum.WARNING_MESSAGE_NEED_AIRLINE_COMPANY;
import static airlinecompany.enums.comandsenum.MessagesForUserEnum.WARNING_MESSAGE_TRY_AGAIN;

/**
 * Class represents an action to get a full information about aircraft from the airline company park
 */
public class GetFullAircraftDataInformationFromBaseAction {

    // This action show a full information about a certain aircraft from airliner company park
    public static void runAction(AirlineManageSystem airlineCompanyManager, Scanner consoleReader) {
        try {

            Aircraft specifiedAircraft = getAircraftByIdFromAirlinePark(airlineCompanyManager, consoleReader);
            showToConsoleFullAircraftInformationData(specifiedAircraft);

        } catch (NoAirlineCompanyException e) {
            System.out.println(WARNING_MESSAGE_NEED_AIRLINE_COMPANY);
            return;
        } catch (AirlineEmptyParkException e) {
            System.out.println(WARNING_MESSAGE_EMPTY_PARK);
            return;
        }
    }

    // This method return an aircraft by id from airline company park
    private static Aircraft getAircraftByIdFromAirlinePark(AirlineManageSystem airlineCompanyManager,
                                                           Scanner consoleReader)
            throws NoAirlineCompanyException, AirlineEmptyParkException {
        while (true) {
            try {

                showToConsoleAircraftsFromAirlineCompanyPark(airlineCompanyManager);

                String idString = consoleReader.nextLine();
                int idAircraft = Integer.parseInt(idString);

                if (idAircraft <= 0) {
                    throw new NumberFormatException();
                }

                Aircraft certainAircraft = airlineCompanyManager.getAircraftById(idAircraft);

                if (certainAircraft == null) {
                    System.out.println(WARNING_MESSAGE_TRY_AGAIN);
                    continue;
                } else {
                    return certainAircraft;
                }

            } catch (NumberFormatException e) {
                System.out.println(WARNING_MESSAGE_TRY_AGAIN);
                continue;
            }
        }
    }

    // This method show to console aircraft's full data information
    private static void showToConsoleFullAircraftInformationData(Aircraft certainAircraft) {
        System.out.println(certainAircraft.getFullDataInformation());
    }

    // This method show all aircrafts to console
    private static void showToConsoleAircraftsFromAirlineCompanyPark(AirlineManageSystem airlineCompanyManager)
            throws NoAirlineCompanyException, AirlineEmptyParkException {

        List<Aircraft> aircraftsList = airlineCompanyManager.getListOfAicrafts();

        System.out.println("Please enter aircraft id from a table below:");
        System.out.println("Aircrafts at the airline company park:");

        for (Iterator<Aircraft> iterator = aircraftsList.iterator(); iterator.hasNext(); ) {
            Aircraft aircraft = (Aircraft) iterator.next();
            System.out.println(
                    "Aircraft ID: " + aircraft.getIdAircraft() + " Aircraft Name: " + aircraft.getNameOfAircraft());
        }
    }
}
