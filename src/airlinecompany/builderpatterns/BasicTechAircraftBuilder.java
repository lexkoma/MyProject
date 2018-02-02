package airlinecompany.builderpatterns;

import airlinecompany.maininfrastructure.aircraftfeatures.BasicTechAircraftData;
import airlinecompany.interfaces.BuilderBehavior;
import airlinecompany.technicalspecification.*;

/**
 * Class creates BasicTechAircraftData object and initializes it's fields
 */
public class BasicTechAircraftBuilder implements BuilderBehavior {
    // A value of BasicTechAircraftData object to create and initialize
    private BasicTechAircraftData specification;

    public BasicTechAircraftBuilder() {
        this.specification = new BasicTechAircraftData();
    }


    // Sets a distance for BasicTechAircraftData object
    public void setBasicDistance(int basicDistance) {
        specification.setDistance(new FlightRange(basicDistance));
    }
    // Sets a maxWeigthCapacity for BasicTechAircraftData object
    public void setCargoCapacity(int maxWeigthCapacity) {
        specification.setMaxCarryingCapacity(new CarryingCapacity(maxWeigthCapacity));
    }

    // Sets a fuelConsumption for BasicTechAircraftData object
    public void setConsumption(int fuel) {
        specification.setFuelConsumption(new FuelConsumption(fuel));
    }

    //Sets passengers for BasicTechAircraftData object
    public void setPassengers(int passengersCapacity) {
        specification.setMaxPassengerCapacity(new BoarderCapacity(passengersCapacity));
    }

    //Sets speed for BasicTechAircraftData object
    public void setSpeed(int fligthSpeed) {
        specification.setAverageFlightSpeed(new FlightSpeed(fligthSpeed));
    }



    //Returns a initialized BasicTechAircraftData object
    public BasicTechAircraftData getResult() {
        return specification;
    }


}
