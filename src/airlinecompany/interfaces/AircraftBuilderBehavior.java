package airlinecompany.interfaces;

import airlinecompany.maininfrastructure.aircraftfeatures.BasicTechAircraftData;
import airlinecompany.maininfrastructure.aircrafts.Aircraft;

/**
 * creates and initializes fields of Aircraft objects
 */
public interface AircraftBuilderBehavior extends BuilderBehavior {

    void setId(final int id);

    void setName(final String name);

    void setBasicTechSpecification(final BasicTechAircraftData specification);

    void setUniqueAircraftTechData(final UniqueAircraftBehavior uniqueAircraftTechDataBehavior);

    //Returns a created Aircraft object.
    Aircraft getResult();

}
