package airlinecompany.builderpatterns;

import airlinecompany.maininfrastructure.aircraftfeatures.BasicTechAircraftData;
import airlinecompany.maininfrastructure.aircrafts.Aircraft;
import airlinecompany.interfaces.AircraftBuilderBehavior;
import airlinecompany.interfaces.UniqueAircraftBehavior;

/**
 * Class creates Aircraft object and initializes it's fields
 */
public abstract class AircraftBuilder implements AircraftBuilderBehavior {
    protected Aircraft aircraft;

    //Set an unique ID for aircraft
    public void setId(final int idAircraft) {
        this.aircraft.setIdAircraft(idAircraft);
    }

    //Set a name for aircraft.
    public void setName(final String nameOfAircraft) {
        this.aircraft.setNameOfAircraft(nameOfAircraft);
    }

    //Set a basic technical characteristic for aircraft
    public void setBasicTechSpecification(final BasicTechAircraftData basicTechAircraftData) {
        this.aircraft.setBasicTechAircraftData(basicTechAircraftData);
    }

    //Set a unique technical characteristic for aircraft
    public abstract void setUniqueAircraftTechData(final UniqueAircraftBehavior uniqueAircraftTechDataBehavior);

    //Returns a initialized aircraft object
    public abstract Aircraft getResult();
}
