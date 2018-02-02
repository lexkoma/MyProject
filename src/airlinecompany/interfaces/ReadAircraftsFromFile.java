package airlinecompany.interfaces;

import airlinecompany.maininfrastructure.aircrafts.Aircraft;

import java.io.IOException;
import java.util.List;

public interface ReadAircraftsFromFile {
    public List<Aircraft> readAircraftListFromFile() throws IOException, ClassNotFoundException;
}
