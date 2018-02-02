
package airlinecompany.helper;


import airlinecompany.maininfrastructure.aircrafts.Aircraft;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.List;

/**
 * for writing Aircraft objects to data file using serialization.
 */
public class FileAicraftsSerializeWriter extends FileAircraftsWriter {

    // Wrie to data file a list of  Aircraft objects.

    public void writeAircraftListToFile(List<Aircraft> aircraftsList) throws IOException {
        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(new File(pathToFile)))) {

            out.writeObject(aircraftsList);
        }
    }
}
