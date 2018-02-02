package airlinecompany.interfaces;

import airlinecompany.maininfrastructure.aircrafts.Aircraft;

import java.io.IOException;
import java.util.List;

public interface WriteAircraftsToFile {
    public void writeAircraftListToFile(List<Aircraft> aircraftsList) throws IOException;
}
