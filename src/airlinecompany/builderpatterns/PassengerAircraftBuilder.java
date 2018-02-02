package airlinecompany.builderpatterns;

import airlinecompany.maininfrastructure.aircraftfeatures.PassengerLinerTechData;
import airlinecompany.maininfrastructure.aircrafts.PassengerAircraft;
import airlinecompany.interfaces.UniqueAircraftBehavior;

/**
 * Class creates PassengerLinerAircraft object
 * and initializes it's fields
 */
public class PassengerAircraftBuilder extends AircraftBuilder {

    public PassengerAircraftBuilder() {
        this.aircraft = new PassengerAircraft();
    }

    // Returns a initialized passenger aircraft
    public PassengerAircraft getResult() {
        return (PassengerAircraft) aircraft;
    }

    // Set a unique techinal characteristic for passenger aircraft
    @Override
    public void setUniqueAircraftTechData(UniqueAircraftBehavior uniqueAircraftTechDataBehavior) {
        ((PassengerAircraft) aircraft).setPassengerLinerTechData((PassengerLinerTechData) uniqueAircraftTechDataBehavior);
    }


}
