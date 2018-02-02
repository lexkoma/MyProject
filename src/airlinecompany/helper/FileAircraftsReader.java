package airlinecompany.helper;


import airlinecompany.maininfrastructure.aircrafts.Aircraft;
import airlinecompany.interfaces.ReadAircraftsFromFile;

import java.io.IOException;
import java.util.List;

/**
 * reads objects from file in OS.
 */
public abstract class FileAircraftsReader implements ReadAircraftsFromFile {

	// A path to file with Aircraft objects in OS.
	protected final String pathToFile = "src/datafiles/datalist.dat";

	//This method reads a collection of Aircraft objects from data file
	public abstract List<Aircraft> readAircraftListFromFile() throws IOException, ClassNotFoundException;

}
