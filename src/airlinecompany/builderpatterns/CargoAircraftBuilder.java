package airlinecompany.builderpatterns;

import airlinecompany.maininfrastructure.aircraftfeatures.CargoAircraftTechData;
import airlinecompany.maininfrastructure.aircrafts.CargoAircraft;
import airlinecompany.interfaces.UniqueAircraftBehavior;

/**
 * Class creates cargoaircraft object and initializes it's fields.
 */
public class CargoAircraftBuilder extends AircraftBuilder {

    public CargoAircraftBuilder() {
        this.aircraft = new CargoAircraft();
    }

    //Returns an initialized CargoAircraft object
    @Override
    public CargoAircraft getResult() {
        return (CargoAircraft) aircraft;
    }

    // Sets a unique technical characteristic for CargoAircraft object
    @Override
    public void setUniqueAircraftTechData(UniqueAircraftBehavior uniqueAircraftTechDataBehavior) {
        ((CargoAircraft) aircraft).setCargoAircraftTechdata((CargoAircraftTechData) uniqueAircraftTechDataBehavior);
    }



}
