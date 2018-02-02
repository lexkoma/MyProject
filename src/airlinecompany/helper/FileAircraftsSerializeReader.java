
package airlinecompany.helper;

import airlinecompany.maininfrastructure.aircrafts.Aircraft;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.LinkedList;
import java.util.List;

/**
 * for reading Aircraft objects from data file using serialization.
 */
public class FileAircraftsSerializeReader extends FileAircraftsReader {

    @SuppressWarnings("unchecked")
    public List<Aircraft> readAircraftListFromFile() throws IOException, ClassNotFoundException {
        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(new File(pathToFile)))) {

            List<Aircraft> aircraftsList = new LinkedList<>();
            aircraftsList = (List<Aircraft>) in.readObject();

            return aircraftsList;
        }

    }

}
