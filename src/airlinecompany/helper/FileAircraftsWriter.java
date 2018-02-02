package airlinecompany.helper;

import airlinecompany.maininfrastructure.aircrafts.Aircraft;
import airlinecompany.interfaces.WriteAircraftsToFile;

import java.io.IOException;
import java.util.List;

/**
 * writes objects to file in OS.
 */
public abstract class FileAircraftsWriter implements WriteAircraftsToFile {

    protected final String pathToFile = "src/datafiles/datalist.dat";

    // This method writes a collection of aircraft objects to data file
    public abstract void writeAircraftListToFile(List<Aircraft> aircraftsList) throws IOException;

}
