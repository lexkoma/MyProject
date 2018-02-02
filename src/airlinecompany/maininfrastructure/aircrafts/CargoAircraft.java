package airlinecompany.maininfrastructure.aircrafts;

import airlinecompany.maininfrastructure.aircraftfeatures.BasicTechAircraftData;
import airlinecompany.maininfrastructure.aircraftfeatures.CargoAircraftTechData;

/**
 * Class represents an cargo aircraft, which is a child of Aircraft, add a new field
 * cargoAircraftTechData, which represents an unique technical characteristic of
 * every CargoAircraft object.
 */
public class CargoAircraft extends Aircraft {

    private static final long serialVersionUID = 1747339975179848000L;
    private CargoAircraftTechData cargoAircraftTechData;


    public CargoAircraft(int idAircraft, String nameOfAircraft, BasicTechAircraftData basicTechAircraftData,
                         CargoAircraftTechData cargoAircraftTechData) {
        super(idAircraft, nameOfAircraft, basicTechAircraftData);
        this.cargoAircraftTechData = cargoAircraftTechData;  //represents a cargo unique technical characteristic.
    }

    public CargoAircraft() {
        super();
        this.cargoAircraftTechData = new CargoAircraftTechData();
    }

    public CargoAircraftTechData getCargoAircraftTechdata() {
        return cargoAircraftTechData;
    }

    public void setCargoAircraftTechdata(CargoAircraftTechData cargoAircraftTechData) {
        this.cargoAircraftTechData = cargoAircraftTechData;
    }

    @Override
    public String toString() {
        return (super.toString() + "\n" + this.cargoAircraftTechData.toString());
    }

    @Override
    public boolean equals(Object obj) {

        if (obj == this) {
            return true;
        }

        if (obj == null) {
            return false;
        }

        if (!(obj instanceof Aircraft)) {
            return false;
        }

        if (!super.equals(obj)) {
            return false;
        }

        CargoAircraft other = (CargoAircraft) obj;
        return (this.cargoAircraftTechData.equals(other.cargoAircraftTechData));
    }

    @Override
    public String getFullDataInformation() {

        String aircraftTYpe = "CARGO";
        int idAircraft = this.idAircraft;
        String nameOfAircraft = this.nameOfAircraft;
        String fuelConsumption = this.getBasicTechAircraftData().getFuelConsumption().getMeasureValueInString();
        String flightSpeed = this.getBasicTechAircraftData().getAverageFlightSpeed().getMeasureValueInString();
        String flightDistance = this.getBasicTechAircraftData().getDistance().getMeasureValueInString();
        String maxBoardingCapacity = this.getBasicTechAircraftData().getMaxPassengerCapacity().getMeasureValueInString();
        String maxCarryingCapacity = this.getBasicTechAircraftData().getMaxCarryingCapacity().getMeasureValueInString();
        String cargoCompartmentSize = this.getCargoAircraftTechdata().getCargoVolume().getMeasureValueInString();
        boolean availability = this.getCargoAircraftTechdata().canTransportAnimals();


        String cargoAircraftInformation = ("AIRCRAFT TYPE: " + aircraftTYpe + "\n" + "ID Aircraft: " + idAircraft + "\n"
                + "NAME: " + nameOfAircraft + "\n" + "MAXIMUM FUEL CONSUMPTION: " + fuelConsumption + "\n" +
                "AVERAGE FLIGHT SPEED: " + flightSpeed + "\n" + "AVERAGE FLIGHT DISTANCE: " + flightDistance + "\n" +
                "MAX CARRYING CAPACITY: " + maxCarryingCapacity + "\n" + "CARGO COMPARTMENT SIZE: " + cargoCompartmentSize+ "\n" +
                "ANIMALS TRANSPORT AVAILABILITY: " + availability +"\n" + "MAX PASSENGER CAPACITY: " + maxBoardingCapacity);

        return cargoAircraftInformation;
    }

}
