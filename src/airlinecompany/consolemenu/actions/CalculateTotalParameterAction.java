package airlinecompany.consolemenu.actions;

import airlinecompany.companyexeptions.AirlineEmptyParkException;
import airlinecompany.companyexeptions.NoAirlineCompanyException;
import airlinecompany.enums.comandsenum.TotalParametersEnum;
import airlinecompany.enums.comandsenum.MessagesForUserEnum;
import airlinecompany.tools.AirlineManageSystem;

import java.util.Scanner;

import static airlinecompany.enums.comandsenum.MessagesForUserEnum.WARNING_MESSAGE_EMPTY_PARK;
import static airlinecompany.enums.comandsenum.MessagesForUserEnum.WARNING_MESSAGE_NEED_AIRLINE_COMPANY;
import static airlinecompany.enums.comandsenum.MessagesForUserEnum.WARNING_MESSAGE_TRY_AGAIN;

/**
 * Class represents an action to calculate a summary of any parameter of each aircraft in airliner company park
 */
public class CalculateTotalParameterAction {

    //This action calculates a total amount of airacrafts parametr
    public static void runAction(AirlineManageSystem airlineCompanyManager, Scanner consoleReader) {

        while (true) {
            try {

                if (!airlineCompanyManager.haveAirlinerCompany()) {
                    throw new NoAirlineCompanyException();
                }

                if (airlineCompanyManager.getAircraftsTotalAmount() == 0) {
                    throw new AirlineEmptyParkException();
                }

                TotalParametersEnum getTotalParam = getTotalParameterTypeToCalculate(consoleReader);

                switch (getTotalParam) {
                    case TOTAL_PASSENGER_CAPACITY: {
                        showToUserConsoleTotalAircraftsPassengerCapacity(airlineCompanyManager);
                        return;
                    }

                    case TOTAL_CARRYING_CAPACITY: {
                        showToUserConsoleTotalAircraftsCarryingCapacity(airlineCompanyManager);
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
                // go to the actionCalculateTotalByParameter menu
                continue;
            }
        }

    }

    // This method ges a total parameter type to calculate
    private static TotalParametersEnum getTotalParameterTypeToCalculate(Scanner consoleReader) {
        System.out.println(MessagesForUserEnum.getMenuActionCalculateTotalByParametrMessageInString());

        String commandAction = consoleReader.nextLine();
        TotalParametersEnum getTotalParam = TotalParametersEnum.stringToEnum(commandAction);
        return getTotalParam;
    }

    //This method show to console a total value of aircrafts weight capacity
    private static void showToUserConsoleTotalAircraftsCarryingCapacity(AirlineManageSystem airlineCompanyManager)
            throws AirlineEmptyParkException, NoAirlineCompanyException {
        System.out.println("A total cargo carrying capacity of all aircrafts at the park is "
                + airlineCompanyManager.getTotalWeigthCapacity());
    }

    //This method show to console a total value of aircrafts passenger capacity
    private static void showToUserConsoleTotalAircraftsPassengerCapacity(AirlineManageSystem airlineCompanyManager)
            throws AirlineEmptyParkException, NoAirlineCompanyException {
        System.out.println("A total passengers capacity of all aircrafts at the park is "
                + airlineCompanyManager.getTotalAircraftsCapacity());
    }

}

