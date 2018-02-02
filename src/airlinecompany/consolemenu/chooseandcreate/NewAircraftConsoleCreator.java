package airlinecompany.consolemenu.chooseandcreate;

import airlinecompany.builderpatterns.BasicTechAircraftBuilder;
import airlinecompany.companyexeptions.NoAirlineCompanyException;
import airlinecompany.interfaces.AircraftBuilderBehavior;
import airlinecompany.interfaces.ConsoleCreatorBehavior;
import airlinecompany.interfaces.UniqueAircraftBehavior;
import airlinecompany.maininfrastructure.aircraftfeatures.BasicTechAircraftData;
import airlinecompany.maininfrastructure.aircrafts.Aircraft;
import airlinecompany.tools.AirlineManageSystem;
import airlinecompany.tools.IDAircraftManager;

import java.util.Scanner;
import java.util.regex.Pattern;

import static airlinecompany.enums.comandsenum.MessagesForUserEnum.WARNING_MESSAGE_NEED_AIRLINE_COMPANY;
import static airlinecompany.enums.comandsenum.MessagesForUserEnum.WARNING_MESSAGE_TRY_AGAIN;

/**
 * Class is used to create a new aircraft via user console menu.
 */

public abstract class NewAircraftConsoleCreator implements ConsoleCreatorBehavior {


    // This method add new aircraft for airline company park
    public void addAndCreateNewAircraft(Scanner consoleReader, AirlineManageSystem airlineCompanyManager,
                                        AircraftBuilderBehavior aircraftBuilder) {

        Aircraft newAircraft = createNewAircraft(consoleReader, aircraftBuilder);

        try {
            if (!(airlineCompanyManager.addAircraft(newAircraft))) {
                System.out.println("Problems to add new aircraft to airline company park!");
                return;
            } else {
                System.out.println("You created an new aircraft with fields:");
                System.out.println(newAircraft.getFullDataInformation());
            }
        } catch (NoAirlineCompanyException e) {
            System.out.println(WARNING_MESSAGE_NEED_AIRLINE_COMPANY);
        }
    }

    // Returns an unique tech data object for a new aircraft
    protected abstract UniqueAircraftBehavior getUniqueAircraftTechDataBehavior(Scanner consoleReader);

    //This method creates a new aircraft for airline company park
    private Aircraft createNewAircraft(Scanner consoleReader, AircraftBuilderBehavior aircraftBuilder) {

        String newAircraftName = getNameForNewAircraft(consoleReader);
        aircraftBuilder.setName(newAircraftName);
        aircraftBuilder.setId(getIdForNewAicraft(newAircraftName));
        aircraftBuilder.setBasicTechSpecification(getBasicTechAircraftDataForNewAircraft(consoleReader));

        aircraftBuilder.setUniqueAircraftTechData(getUniqueAircraftTechDataBehavior(consoleReader));

        return aircraftBuilder.getResult();
    }

    // This method returns a name for a new aircraft
    private String getNameForNewAircraft(Scanner consoleReader) {
        while (true) {
            System.out.println("Choose a name for a new aircraft(FOR EXAMPLE: AN - 255):");
            String newAircraftName = consoleReader.nextLine();

            if (Pattern.matches("[A-Z][0-9A-Za-z- ]+", newAircraftName)) {
                return newAircraftName;
            } else {
                System.out.println(WARNING_MESSAGE_TRY_AGAIN);
                continue;
            }
        }
    }

    // This method returns an int unique id for a new aircraft
    private int getIdForNewAicraft(String aircraftName) {
        int uniqueAircraftId = IDAircraftManager.getUniqueIdAircraft(aircraftName);
        return uniqueAircraftId;
    }

    // This method returns a basic tech data object for a new aircraft
    private BasicTechAircraftData getBasicTechAircraftDataForNewAircraft(Scanner consoleReader) {

        BasicTechAircraftBuilder basicTechDataBuilder = new BasicTechAircraftBuilder();

        basicTechDataBuilder.setBasicDistance(getFlightDistance(consoleReader));
        basicTechDataBuilder.setPassengers(getPeopleCapacity(consoleReader));
        basicTechDataBuilder.setSpeed(getNewSpeed(consoleReader));
        basicTechDataBuilder.setConsumption(getNewFuelConsumption(consoleReader));
        basicTechDataBuilder.setCargoCapacity(getMaxWeightCapacity(consoleReader));

        return basicTechDataBuilder.getResult();
    }

    //This method returns an int value of people capacity for a new aircraft

    protected int getPeopleCapacity(Scanner consoleReader) {

        while (true) {

            final int minimumPeopleCapacity = 1;
            final int maximumPeopleCapacity = 800;

            System.out.println("Choose a maximum passengers capacity for a new aircraft (from 1 people to 800 people):");
            String newAircraftPeopleCapacity = consoleReader.nextLine();

            try {

                int newAircraftPeopleCapacityInInt = Integer.parseInt(newAircraftPeopleCapacity);

                if ((newAircraftPeopleCapacityInInt < minimumPeopleCapacity)
                        || (newAircraftPeopleCapacityInInt > maximumPeopleCapacity)) {
                    throw new NumberFormatException();
                }
                return newAircraftPeopleCapacityInInt;

            } catch (NumberFormatException e) {
                System.out.println(WARNING_MESSAGE_TRY_AGAIN);
                continue;
            }
        }
    }

    private int getFlightDistance(Scanner consoleReader) {
        while (true) {

            final int minimumDistance = 100;
            final int maximumDistance = 8000;

            System.out.println("Choose a maximum flight distance for a new aircraft (from 100 km to 8000 km):");
            String newAircraftDistance = consoleReader.nextLine();

            try {

                int distance = Integer.parseInt(newAircraftDistance);

                if ((distance < minimumDistance)
                        || (distance > maximumDistance)) {
                    throw new NumberFormatException();
                }
                return distance;

            } catch (NumberFormatException e) {
                System.out.println(WARNING_MESSAGE_TRY_AGAIN);
                continue;
            }
        }
    }

    //This method returns an int value of speed for a new aircraft
    private int getNewSpeed(Scanner consoleReader) {
        while (true) {

            final int minSpeed = 100;
            final int maxSpeed = 700;

            System.out.println("Choose a average speed for a new aircraft (from 100 km/h to 700 km/h):");
            String newAircraftSpeed = consoleReader.nextLine();

            try {

                int newAircraftSpeedInInt = Integer.parseInt(newAircraftSpeed);

                if ((newAircraftSpeedInInt < minSpeed)
                        || (newAircraftSpeedInInt > maxSpeed)) {
                    throw new NumberFormatException();
                }
                return newAircraftSpeedInInt;

            } catch (NumberFormatException e) {
                System.out.println(WARNING_MESSAGE_TRY_AGAIN);
                continue;
            }
        }
    }

    // This method returns an int value of fuel for a new aircraft
    private int getNewFuelConsumption(Scanner consoleReader) {
        while (true) {

            final int minimumFuel = 30;
            final int maximumFuel = 3000;

            System.out.println("Choose a fuel consumption for a new aircraft (from 30 liters / hr to 3000 liters/ hr):");
            String newAircraftFuel = consoleReader.nextLine();

            try {

                int newAircraftFuelInInt = Integer.parseInt(newAircraftFuel);

                if ((newAircraftFuelInInt < minimumFuel)
                        || (newAircraftFuelInInt > maximumFuel)) {
                    throw new NumberFormatException();
                }
                return newAircraftFuelInInt;

            } catch (NumberFormatException e) {
                System.out.println(WARNING_MESSAGE_TRY_AGAIN);
                continue;
            }
        }
    }

    // This method returns an int value of weight capacity for a new aircraft

    private int getMaxWeightCapacity(Scanner consoleReader) {
        while (true) {

            final int minimumWeightCapacity = 12;
            final int maximumWeightCapacity = 4000;

            System.out.println("Choose a maximum weight capacity for a new aircraft (from 12 tons to 4000 tons):");
            String newAircraftWeightCapacity = consoleReader.nextLine();

            try {

                int newAircraftWeightCapacityInInt = Integer.parseInt(newAircraftWeightCapacity);

                if ((newAircraftWeightCapacityInInt < minimumWeightCapacity)
                        || (newAircraftWeightCapacityInInt > maximumWeightCapacity)) {
                    throw new NumberFormatException();
                }
                return newAircraftWeightCapacityInInt;

            } catch (NumberFormatException e) {
                System.out.println(WARNING_MESSAGE_TRY_AGAIN);
                continue;
            }
        }
    }

}
