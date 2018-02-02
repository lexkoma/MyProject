package airlinecompany.consolemenu.chooseandcreate;

import airlinecompany.builderpatterns.CargoAircraftTechDataBuilder;
import airlinecompany.maininfrastructure.aircraftfeatures.CargoAircraftTechData;

import java.util.Scanner;

import static airlinecompany.enums.comandsenum.MessagesForUserEnum.WARNING_MESSAGE_TRY_AGAIN;

/**
 * Class is used to create a new cargo aircraft via user console menu.
 */
public class NewCargoAircraftConsoleCreator extends NewAircraftConsoleCreator {

    //This method return a cargo aircraft tech data object for a new aircraft
    protected CargoAircraftTechData getUniqueAircraftTechDataBehavior(Scanner consoleReader) {

        CargoAircraftTechDataBuilder newCargoAircraftTechDataBuilder = new CargoAircraftTechDataBuilder();
        newCargoAircraftTechDataBuilder.setCompartmentSize(getCargoCompartmentSize(consoleReader));
        newCargoAircraftTechDataBuilder.setAnimallsAvailability(canTransportAnimals(consoleReader));
        return newCargoAircraftTechDataBuilder.getResult();
    }

    // This method return an int value of department size for cargo aircraft tech data object
    private static int getCargoCompartmentSize(Scanner consoleReader) {
        while (true) {

            final int minimumSize = 5;
            final int maximumSize = 2000;

            System.out.println("Choose a cargo compartment size for a new cargo aircraft (from 5 m^3  to 2000 m^3):");
            String newAircraftCargoSize = consoleReader.nextLine();

            try {

                int newAircraftCargoSizeInInt = Integer.parseInt(newAircraftCargoSize);

                if ((newAircraftCargoSizeInInt < minimumSize)
                        || (newAircraftCargoSizeInInt > maximumSize)) {
                    throw new NumberFormatException();
                }
                return newAircraftCargoSizeInInt;

            } catch (NumberFormatException e) {
                System.out.println(WARNING_MESSAGE_TRY_AGAIN);
                continue;
            }
        }
    }

    // This method return a boolean value of cargo aircraft opportunity to transport passengers
    private static boolean canTransportAnimals(Scanner consoleReader) {
        while (true) {

            System.out.println("Can a new cargo aircraft transport animals:");
            System.out.println("--Enter '1' to allow for a new cargo aircraft transport animals");
            System.out.println("--Enter '2' no to allow for a new cargo aircraft transport animals");

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
