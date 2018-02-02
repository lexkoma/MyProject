package airlinecompany.builderpatterns;

import airlinecompany.maininfrastructure.aircraftfeatures.CargoAircraftTechData;
import airlinecompany.interfaces.BuilderBehavior;
import airlinecompany.technicalspecification.CargoVolume;

/**
 * Class creates CargoAircraftTechData object and initializes it's fields
 */
public class CargoAircraftTechDataBuilder implements BuilderBehavior {

    public CargoAircraftTechDataBuilder() {
        cargoAircraftTechData = new CargoAircraftTechData();
    }

    // A value of CargoAircraftTechData object to create and initialize
    private CargoAircraftTechData cargoAircraftTechData;

    //Sets a cargoDepartmentSize for CargoAircraftTechData object
    public void setCompartmentSize(int size) {
        cargoAircraftTechData.setCargoVolume(new CargoVolume(size));
    }

    //Sets can transport passenger field for CargoAircraftTechData
    public void setAnimallsAvailability(boolean havePassengers) {
        cargoAircraftTechData.setCanTransportAnimals(havePassengers);
    }

    public CargoAircraftTechData getResult() {
        return cargoAircraftTechData;
    }

}
