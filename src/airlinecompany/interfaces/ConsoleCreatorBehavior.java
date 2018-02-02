package airlinecompany.interfaces;

import airlinecompany.tools.AirlineManageSystem;

import java.util.Scanner;

/**
 * creation of a new Aircraft objects by user console
 */
public interface ConsoleCreatorBehavior {
    void addAndCreateNewAircraft(Scanner consoleReader, AirlineManageSystem airlineCompanyManager,
                                 AircraftBuilderBehavior aircraftBuilder);
}
