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
 * Class represents an action to remove an aircraft
 * from airlines company park
 */
public class RemoveAircraftAction {

    //This method remove aircraft from airline company park

    public static void runAction(AirlineManageSystem airlineCompanyManager, Scanner consoleReader) {
        try {

            Aircraft removedAircraft = getAircraftByIdFromAirlinePark(airlineCompanyManager, consoleReader);
            removeAircraftFromAirlineCompanyPark(airlineCompanyManager, removedAircraft);

        } catch (NoAirlineCompanyException e) {
            System.out.println(WARNING_MESSAGE_NEED_AIRLINE_COMPANY);
            return;
        } catch (AirlineEmptyParkException e) {
            System.out.println(WARNING_MESSAGE_EMPTY_PARK);
            return;
        }
    }

    //This method remove aircraft from airline company park
    private static void removeAircraftFromAirlineCompanyPark(AirlineManageSystem airlineCompanyManager,
                                                             Aircraft removedAircraft) throws NoAirlineCompanyException {

        if (airlineCompanyManager.removeAircraft(removedAircraft)) {

            System.out.println("AIRCRAFT ID: " + removedAircraft.getIdAircraft() + "\n" + "AIRCRAFT NAME: "
                    + removedAircraft.getNameOfAircraft() + "\n"
                    + "WAS REMOVED FROM AIRLINE COMPANY PARK !!! SUCCESSFULLY !!!");

        } else {
            System.out.println(" !!! FAIL TO REMOVE !!!");
        }
    }

    //This method return an aircraft by id from airline company park
    private static Aircraft getAircraftByIdFromAirlinePark(AirlineManageSystem airlineCompanyManager,
                                                           Scanner consoleReader) throws NoAirlineCompanyException,
            AirlineEmptyParkException {

        while (true) {
            try {

                showToUserConsoleAircraftsFromAirlineCompanyPark(airlineCompanyManager);

                String idString = consoleReader.nextLine();
                int idAircraft = Integer.parseInt(idString);

                if (idAircraft <= 0) {
                    throw new NumberFormatException();
                }

                Aircraft foundAircraft = airlineCompanyManager.getAircraftById(idAircraft);

                if (foundAircraft == null) {
                    System.out.println(WARNING_MESSAGE_TRY_AGAIN);
                    continue;
                } else {
                    return foundAircraft;
                }

            } catch (NumberFormatException e) {
                System.out.println(WARNING_MESSAGE_TRY_AGAIN);
                continue;
            }
        }
    }

    // This method show all aircrafts to console
    private static void showToUserConsoleAircraftsFromAirlineCompanyPark(AirlineManageSystem airlineCompanyManager)
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
