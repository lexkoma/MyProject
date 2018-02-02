package airlinecompany.maininfrastructure.aircraftfeatures;

import airlinecompany.technicalspecification.*;

import java.io.Serializable;

/**
 * Class  represents a basic technical information for  Aircraft such as maximum carrying capacity, fuel consumption in
 * liters per hour, average speed  in kilometers per hour of aircraft
 */
public class BasicTechAircraftData implements Serializable {
    private static final long serialVersionUID = -3086247017962379621L;

    private CarryingCapacity maxCarryingCapacity; //maximum weight capacity

    private FuelConsumption fuelConsumption; // average fuel consumption in liter per kilometer

    private FlightSpeed averageFlightSpeed; // average speed km per hour

    private FlightRange distance; // average flight distance

    private BoarderCapacity maxPassengerCapacity; // maximum passenger capacity




    public BasicTechAircraftData(CarryingCapacity maxCarryingCapacity, FuelConsumption fuelConsuption,
                                 FlightSpeed averageFlightSpeed, FlightRange distance, BoarderCapacity maxPassengerCapacity) {

        this.maxCarryingCapacity = maxCarryingCapacity;
        this.fuelConsumption = fuelConsuption;
        this.averageFlightSpeed = averageFlightSpeed;
        this.distance = distance;
        this.maxPassengerCapacity = maxPassengerCapacity;
    }

    public BasicTechAircraftData() {
        this.maxCarryingCapacity = new CarryingCapacity();
        this.fuelConsumption = new FuelConsumption();
        this.averageFlightSpeed = new FlightSpeed();
        this.distance = new FlightRange();
        this.maxPassengerCapacity = new BoarderCapacity();
    }

    public CarryingCapacity getMaxCarryingCapacity() {
        return maxCarryingCapacity;
    }

    public void setMaxCarryingCapacity(CarryingCapacity maxCarryingCapacity) {
        this.maxCarryingCapacity = maxCarryingCapacity;
    }

    public FuelConsumption getFuelConsumption() {
        return fuelConsumption;
    }

    public void setFuelConsumption(FuelConsumption fuelConsumption) {
        this.fuelConsumption = fuelConsumption;
    }

    public FlightSpeed getAverageFlightSpeed() {
        return averageFlightSpeed;
    }

    public void setAverageFlightSpeed(FlightSpeed averageFlightSpeed) {
        this.averageFlightSpeed = averageFlightSpeed;
    }


    public FlightRange getDistance() {
        return distance;
    }

    public void setDistance(FlightRange distance) {
        this.distance = distance;
    }

    public BoarderCapacity getMaxPassengerCapacity() {
        return maxPassengerCapacity;
    }

    public void setMaxPassengerCapacity(BoarderCapacity maxPassengerCapacity) {
        this.maxPassengerCapacity = maxPassengerCapacity;
    }


    @Override
    public String toString() {
        return ((this.fuelConsumption) + "\n" + (this.maxCarryingCapacity) + "\n" + (this.averageFlightSpeed)
                + "\n" + (this.maxPassengerCapacity));
    }

    @Override
    public boolean equals(Object obj) {

        if (obj == this) {
            return true;
        }

        if (obj == null) {
            return false;
        }

        if (!(obj instanceof BasicTechAircraftData)) {
            return false;
        }

        BasicTechAircraftData other = (BasicTechAircraftData) obj;
        return ((this.fuelConsumption.equals(other.fuelConsumption))
                && (this.maxCarryingCapacity.equals(other.maxCarryingCapacity))
                && (this.averageFlightSpeed.equals(other.averageFlightSpeed))
                && (this.maxPassengerCapacity.equals(other.maxPassengerCapacity)));
    }
}

