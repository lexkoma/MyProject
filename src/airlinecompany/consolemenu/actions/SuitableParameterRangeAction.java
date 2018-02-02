package airlinecompany.consolemenu.actions;

import airlinecompany.companyexeptions.AirlineEmptyParkException;
import airlinecompany.companyexeptions.NoAirlineCompanyException;
import airlinecompany.companyexeptions.NoSuitableAircraftsException;
import airlinecompany.enums.comandsenum.SearchRangeParameterEnum;
import airlinecompany.enums.comandsenum.MessagesForUserEnum;
import airlinecompany.maininfrastructure.aircrafts.Aircraft;
import airlinecompany.technicalspecification.FlightSpeed;
import airlinecompany.technicalspecification.FuelConsumption;
import airlinecompany.tools.AirlineManageSystem;

import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

import static airlinecompany.enums.comandsenum.MessagesForUserEnum.*;

/**
 * Class represents an action to show all aircraft which parameters are suitable for search range
 */
public class SuitableParameterRangeAction {

    // This action show all aircrafts, which are suitable for paramert range
    public static void runAction(AirlineManageSystem airlineCompanyManager, Scanner consoleReader) {

        while (true) {
            try {
                SearchRangeParameterEnum getSortType = choseRangeParameter(airlineCompanyManager, consoleReader);

                switch (getSortType) {

                    case RANGE_BY_FUEL_CONSUMPTION: {
                        showAircraftsRangeByFuel(airlineCompanyManager, consoleReader);
                        return;
                    }

                    case RANGE_BY_SPEED: {
                        showAircraftsRangedBySpeed(airlineCompanyManager, consoleReader);
                        return;
                    }
                }
            } catch (NoAirlineCompanyException e) {
                System.out.println(WARNING_MESSAGE_NEED_AIRLINE_COMPANY);
                break;
            } catch (AirlineEmptyParkException e) {
                System.out.println(WARNING_MESSAGE_EMPTY_PARK);
                break;
            } catch (NoSuitableAircraftsException e) {
                System.out.println(WARNING_MESSAGE_NO_SUITABLE_AIRCRAFTS);
                break;
            } catch (IllegalArgumentException e) {
                System.out.println(WARNING_MESSAGE_TRY_AGAIN);
                // go to actionGetAircraftsByParametrRange menu
                continue;
            }
        }

    }

    // This method get a type of a ranged parameter to show all aircrafts from airline company park
    private static SearchRangeParameterEnum choseRangeParameter(AirlineManageSystem airlineCompanyManager,
                                                                Scanner consoleReader) throws NoAirlineCompanyException, AirlineEmptyParkException {

        // To check: did you create an airline company
        if (!airlineCompanyManager.haveAirlinerCompany()) {
            throw new NoAirlineCompanyException();
        }

        // To check: if there are any aircrafts at the airline company park
        if (airlineCompanyManager.getAircraftsTotalAmount() == 0) {
            throw new AirlineEmptyParkException();
        }

        System.out.println(MessagesForUserEnum.getMenuActionGetAircraftsByParametrRangeMessageInString());

        String commandAction = consoleReader.nextLine();
        SearchRangeParameterEnum getSortType = SearchRangeParameterEnum.stringToEnum(commandAction);
        return getSortType;
    }

    //This method show all aircrafts from airline company park ranged by minimum and maximum aircraft's fuel consumption
    private static void showAircraftsRangeByFuel(AirlineManageSystem airlineCompanyManager, Scanner consoleReader)
            throws NoAirlineCompanyException, AirlineEmptyParkException, NoSuitableAircraftsException {

        int valueFrom = getMinimumFuelConsumptionInInt(consoleReader);
        int valueTo = getMaximumFuelConsumptionInInt(consoleReader, valueFrom);

        showToConsoleRangedByFuelConsumption(airlineCompanyManager, valueFrom,
                valueTo);
    }

    //This method return a minimum value of aircraft's fuel consumption, which is entered from console by user
    private static int getMinimumFuelConsumptionInInt(Scanner consoleReader) {
        while (true) {
            try {
                System.out.println("Please enter a minimum fuel aircraft spending:");

                String numberString = consoleReader.nextLine();
                int valueFrom = Integer.parseInt(numberString);

                if (valueFrom <= 0) {
                    throw new NumberFormatException();
                }

                return valueFrom;

            } catch (NumberFormatException e) {
                System.out.println(WARNING_MESSAGE_TRY_AGAIN);
                continue;
            }
        }
    }

    //This method return a maximum value of aircraft's fuel spending, which is entered from console by user
    private static int getMaximumFuelConsumptionInInt(Scanner consoleReader, int valueFrom) {
        while (true) {
            try {
                System.out.println("Please enter a maximum fuel aircraft spending:");

                String numberString = consoleReader.nextLine();
                int valueTo = Integer.parseInt(numberString);

                if (valueTo < valueFrom | valueTo <= 0) {
                    throw new NumberFormatException();
                }

                return valueTo;

            } catch (NumberFormatException e) {
                System.out.println(WARNING_MESSAGE_TRY_AGAIN);
                continue;
            }
        }
    }

    //This method show aircrafts to user console ranged by minimum and maximum aircraft's fuel spending

    private static void showToConsoleRangedByFuelConsumption(AirlineManageSystem airlineCompanyManager,
                                                             int valueFrom, int valueTo)
            throws NoAirlineCompanyException, AirlineEmptyParkException, NoSuitableAircraftsException {

        FuelConsumption from = new FuelConsumption(valueFrom);
        FuelConsumption to = new FuelConsumption(valueTo);

        List<Aircraft> aircraftsList = airlineCompanyManager.searchByFuel(from, to);

        if (aircraftsList.size() == 0) {
            throw new NoSuitableAircraftsException();
        }

        for (Iterator<Aircraft> iterator = aircraftsList.iterator(); iterator.hasNext(); ) {
            Aircraft aircraft = (Aircraft) iterator.next();
            System.out.println("Aircraft ID: " + aircraft.getIdAircraft() + " Aircraft Name: "
                    + aircraft.getNameOfAircraft() + " fuel spending: "
                    + aircraft.getBasicTechAircraftData().getFuelConsumption().getMeasureValueInString());
        }
    }

    // This method show all aircrafts from airline company park ranged by minimum and maximum aircraft's speed
    private static void showAircraftsRangedBySpeed(AirlineManageSystem airlineCompanyManager,
                                                   Scanner consoleReader)
            throws NoAirlineCompanyException, NoSuitableAircraftsException, AirlineEmptyParkException {

        int fromSpeed = getMinimumAircraftSpeed(consoleReader);
        int toSpeed = getMaximumAircraftSpeed(consoleReader, fromSpeed);

        showToConsoleAircraftsRangedSpeed(airlineCompanyManager, fromSpeed,
                toSpeed);
    }

    // This method show aircrafts to user console ranged by minimum and maximum aircraft's speed
    private static void showToConsoleAircraftsRangedSpeed(AirlineManageSystem airlineCompanyManager,
                                                          int valueFromSpeed, int valueToSpeed)
            throws NoAirlineCompanyException, NoSuitableAircraftsException, AirlineEmptyParkException {

        FlightSpeed fromSpeed = new FlightSpeed(valueFromSpeed);
        FlightSpeed toSpeed = new FlightSpeed(valueToSpeed);
        List<Aircraft> aircraftsList = airlineCompanyManager.searchBySpeed(fromSpeed, toSpeed);

        if (aircraftsList.size() == 0) {
            throw new NoSuitableAircraftsException();
        }

        for (Iterator<Aircraft> iterator = aircraftsList.iterator(); iterator.hasNext(); ) {
            Aircraft aircraft = (Aircraft) iterator.next();
            System.out.println("Aircraft ID: " + aircraft.getIdAircraft() + "Aircraft Name: "
                    + aircraft.getNameOfAircraft() + " speed: "
                    + aircraft.getBasicTechAircraftData().getAverageFlightSpeed().getMeasureValueInString());
        }
    }

    // This method return a minimum value of aircraft's middle velocity, which is entered from console by user
    private static int getMinimumAircraftSpeed(Scanner consoleReader) {
        while (true) {
            try {
                System.out.println("Please enter a minimum aircraft speed:");

                String numberString = consoleReader.nextLine();
                int fromSpeed = Integer.parseInt(numberString);

                if (fromSpeed <= 0) {
                    throw new NumberFormatException();
                }

                return fromSpeed;

            } catch (NumberFormatException e) {
                System.out.println(WARNING_MESSAGE_TRY_AGAIN);
                continue;
            }
        }
    }

    //This method return a maximum value of aircraft's middle velocity, which is entered from console by user
    private static int getMaximumAircraftSpeed(Scanner consoleReader, int fromSpeed) {
        while (true) {
            try {
                System.out.println("Please enter a maximum aircraft velocity:");

                String numberString = consoleReader.nextLine();
                int toSpeed = Integer.parseInt(numberString);

                if (toSpeed < fromSpeed | toSpeed <= 0) {
                    throw new NumberFormatException();
                }

                return toSpeed;

            } catch (NumberFormatException e) {
                System.out.println(WARNING_MESSAGE_TRY_AGAIN);
                continue;
            }
        }
    }

}
