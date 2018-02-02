package airlinecompany.consolemenu.chooseandcreate;

import airlinecompany.builderpatterns.PassengerAircraftTechDataBuilder;
import airlinecompany.interfaces.UniqueAircraftBehavior;
import airlinecompany.maininfrastructure.aircraftfeatures.PassengerLinerTechData;

import java.util.Scanner;

import static airlinecompany.enums.comandsenum.MessagesForUserEnum.WARNING_MESSAGE_TRY_AGAIN;

/**
 * Class is used to create a new airliner aircraft via user console menu
 */

public class NewPassengerAircraftConsoleCreator extends NewAircraftConsoleCreator{

    //This method returns an airliner tech data object for a new aircraft

    protected UniqueAircraftBehavior getUniqueAircraftTechDataBehavior(Scanner consoleReader) {

        PassengerLinerTechData airlinerTechData = getAirlinerTechData(consoleReader);
        return airlinerTechData;

    }

    //This method returns a airliner aicraft tech data object for a new airliner aircraft
    private PassengerLinerTechData getAirlinerTechData(Scanner consoleReader) {

        PassengerAircraftTechDataBuilder newAirlinerAircraftTechDataBuilder = new PassengerAircraftTechDataBuilder();

        newAirlinerAircraftTechDataBuilder.setLuggageAvailability(getLuggageOpportunity(consoleReader));

        return newAirlinerAircraftTechDataBuilder.getResult();
    }



    //This method returns a boolean value of airline aircraft opportunity to have bussiness class
    private boolean getLuggageOpportunity(Scanner consoleReader) {
        while (true) {

            System.out.println("Has a new airline aircraft luggage compartment:");
            System.out.println("--Enter '1' have luggage compartment");
            System.out.println("--Enter '2' don't luggage compartment ");

            String answer = consoleReader.nextLine();

            switch (answer) {

                case "1": {
                    return true;
                }

                case "2": {
                    return false;
                }

                default: {
                    System.out.println(WARNING_MESSAGE_TRY_AGAIN);
                    continue;
                }
            }
        }
    }

}
