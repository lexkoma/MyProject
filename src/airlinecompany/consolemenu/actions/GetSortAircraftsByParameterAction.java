package airlinecompany.consolemenu.actions;


import airlinecompany.companyexeptions.AirlineEmptyParkException;
import airlinecompany.companyexeptions.NoAirlineCompanyException;
import airlinecompany.enums.comandsenum.SortAircraftsEnum;
import airlinecompany.enums.comandsenum.MessagesForUserEnum;
import airlinecompany.maininfrastructure.aircrafts.Aircraft;
import airlinecompany.tools.AirlineManageSystem;

import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

import static airlinecompany.enums.comandsenum.MessagesForUserEnum.WARNING_MESSAGE_EMPTY_PARK;
import static airlinecompany.enums.comandsenum.MessagesForUserEnum.WARNING_MESSAGE_NEED_AIRLINE_COMPANY;
import static airlinecompany.enums.comandsenum.MessagesForUserEnum.WARNING_MESSAGE_TRY_AGAIN;

/**
 * Class represents an action to show a sorting list of aicraft by parameter
 */
public class GetSortAircraftsByParameterAction {

    // This action show all aircrafts, sorted by parameter
    public static void runAction(AirlineManageSystem airlineCompanyManager, Scanner consoleReader) {
        while (true) {
            try {

                if (!airlineCompanyManager.haveAirlinerCompany()) {
                    throw new NoAirlineCompanyException();
                }

                if (airlineCompanyManager.getAircraftsTotalAmount() == 0) {
                    throw new AirlineEmptyParkException();
                }

                SortAircraftsEnum getSortType = choseParametrTypeToSortAircrafts(consoleReader);

                switch (getSortType) {

                    case SORT_BY_DISTANCE: {
                        showSortedAircraftsByDistance(airlineCompanyManager);
                        return;
                    }
                    case SORT_BY_FUEL_CONSUMPTION: {
                        showSortedAircraftsByFuelSpend(airlineCompanyManager);
                        return;
                    }

                    case SORT_BY_SPEED: {
                        showSortedAircraftsBySpeed(airlineCompanyManager);
                        return;
                    }

                    case SORT_BY_PASSENGER_CAPACITY: {
                        showSortedAircraftsByPeopleCapacity(airlineCompanyManager);
                        return;
                    }

                    case SORT_BY_WEIGHT_CAPACITY: {
                        showSortedAircraftsByWeightCapacity(airlineCompanyManager);
                        return;
                    }
                }
            } catch (NoAirlineCompanyException e) {
                System.out.println(WARNING_MESSAGE_NEED_AIRLINE_COMPANY);
                break;
            } catch (AirlineEmptyParkException e) {
                System.out.println(WARNING_MESSAGE_EMPTY_PARK);
                break;
            } catch (IllegalArgumentException e) {
                System.out.println(WARNING_MESSAGE_TRY_AGAIN);
                // go to actionGetSortAircraftsByParametr menu
                continue;
            }
        }
    }

    //This method get a type of a sort parametr to show all aircrafts from airline company park
    private static SortAircraftsEnum choseParametrTypeToSortAircrafts(Scanner consoleReader) {
        System.out.println(MessagesForUserEnum.getSortAircraftsByParameterMessage());

        String commandAction = consoleReader.nextLine();
        SortAircraftsEnum getSortType = SortAircraftsEnum.stringToEnum(commandAction);
        return getSortType;
    }


    // This method show all aircrafts to user console sorted by distance
    private static void showSortedAircraftsByDistance(AirlineManageSystem airlineCompanyManager)
            throws NoAirlineCompanyException, AirlineEmptyParkException {

        List<Aircraft> sortedAircraftsList = airlineCompanyManager.sortlistAicraftByDistance();

        for (Iterator<Aircraft> iterator = sortedAircraftsList.iterator(); iterator.hasNext(); ) {

            Aircraft aircraft = (Aircraft) iterator.next();

            System.out.println("Aircrafts ID: " + aircraft.getIdAircraft() + " Aircraft Name: "
                    + aircraft.getNameOfAircraft() + " flight distance: "
                    + aircraft.getBasicTechAircraftData().getDistance().getMeasureValueInString());
        }
    }

    // This method show all aircrafts to user console sorted by weight capacity
    private static void showSortedAircraftsByWeightCapacity(AirlineManageSystem airlineCompanyManager)
            throws NoAirlineCompanyException, AirlineEmptyParkException {

        List<Aircraft> sortedAircraftsList = airlineCompanyManager.sortlistAicraftByCarryingtCapacity();

        for (Iterator<Aircraft> iterator = sortedAircraftsList.iterator(); iterator.hasNext(); ) {

            Aircraft aircraft = (Aircraft) iterator.next();

            System.out.println("Aircrafts ID: " + aircraft.getIdAircraft() + " Aircraft Name: "
                    + aircraft.getNameOfAircraft() + " maximum carrying capacity: "
                    + aircraft.getBasicTechAircraftData().getMaxCarryingCapacity().getMeasureValueInString());
        }
    }

    // This method show all aircrafts to user console sorted by people capacity
    private static void showSortedAircraftsByPeopleCapacity(AirlineManageSystem airlineCompanyManager)
            throws NoAirlineCompanyException, AirlineEmptyParkException {

        List<Aircraft> sortedAircraftsList = airlineCompanyManager.sortlistAircraftByPassengerCapacity();

        for (Iterator<Aircraft> iterator = sortedAircraftsList.iterator(); iterator.hasNext(); ) {

            Aircraft aircraft = (Aircraft) iterator.next();

            System.out.println("Aircrafts ID: " + aircraft.getIdAircraft() + " Aircraft Name: "
                    + aircraft.getNameOfAircraft() + " maximum passengers capacity: "
                    + aircraft.getBasicTechAircraftData().getMaxPassengerCapacity().getMeasureValueInString());
        }
    }

    // This method show all aircrafts to user console sorted by middle velocity
    private static void showSortedAircraftsBySpeed(AirlineManageSystem airlineCompanyManager)
            throws NoAirlineCompanyException, AirlineEmptyParkException {
        List<Aircraft> sortedAircraftsList = airlineCompanyManager.sortlistAircraftsBySpeed();

        for (Iterator<Aircraft> iterator = sortedAircraftsList.iterator(); iterator.hasNext(); ) {

            Aircraft aircraft = (Aircraft) iterator.next();

            System.out.println("Aircrafts ID: " + aircraft.getIdAircraft() + " Aircraft Name: "
                    + aircraft.getNameOfAircraft() + " speed: "
                    + aircraft.getBasicTechAircraftData().getAverageFlightSpeed().getMeasureValueInString());
        }
    }

    //This method show all aircrafts to user console sorted by fuel consumption
    private static void showSortedAircraftsByFuelSpend(AirlineManageSystem airlineCompanyManager)
            throws NoAirlineCompanyException, AirlineEmptyParkException {

        List<Aircraft> sortedAircraftsList = airlineCompanyManager.sortlistAicraftByFuelConsumption();

        for (Iterator<Aircraft> iterator = sortedAircraftsList.iterator(); iterator.hasNext(); ) {
            Aircraft aircraft = (Aircraft) iterator.next();

            System.out.println("Aircraft ID: " + aircraft.getIdAircraft() + " Aircraft Name: "
                    + aircraft.getNameOfAircraft() + " fuel consumption: "
                    + aircraft.getBasicTechAircraftData().getFuelConsumption().getMeasureValueInString());
        }
    }

}
