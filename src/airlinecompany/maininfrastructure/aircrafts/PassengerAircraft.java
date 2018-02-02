package airlinecompany.maininfrastructure.aircrafts;

import airlinecompany.maininfrastructure.aircraftfeatures.BasicTechAircraftData;
import airlinecompany.maininfrastructure.aircraftfeatures.PassengerLinerTechData;

/**
 * Class represents a passenger airliner aircraft, which is a child of Aircraft, add a new field
 * passengerLinerTechData, which represents an unique technical characteristic of every CargoAircraft object
 */
public class PassengerAircraft extends Aircraft {

    private static final long serialVersionUID = -645024479929628273L;
    private PassengerLinerTechData passengerLinerTechData; // technical characteristic of every passenger aircraft

    public PassengerAircraft(int idAircraft, String nameOfAircraft, BasicTechAircraftData basicTechAircraftData,
                             PassengerLinerTechData passengerLinerTechData) {
        super(idAircraft, nameOfAircraft, basicTechAircraftData);
        this.passengerLinerTechData = passengerLinerTechData;
    }

    public PassengerAircraft() {
        super();
        this.passengerLinerTechData = new PassengerLinerTechData();
    }

    @Override
    public String getFullDataInformation() {
        String typeOfAircraft = "PASSENGER LINER";
        int idAircraft = this.idAircraft;
        String nameAircraft = this.nameOfAircraft;
        String fuelConsumption = this.getBasicTechAircraftData().getFuelConsumption().getMeasureValueInString();
        String flightSpeed = this.getBasicTechAircraftData().getAverageFlightSpeed().getMeasureValueInString();
        String flightDistance = this.getBasicTechAircraftData().getDistance().getMeasureValueInString();
        String maxBoardingCapacity = this.getBasicTechAircraftData().getMaxPassengerCapacity().getMeasureValueInString();
        String maxCarryingCapacity = this.getBasicTechAircraftData().getMaxCarryingCapacity().getMeasureValueInString();
        boolean availability = this.getPassengerLinerTechData().haveLuggageCompartment();


        String passengerAircraftInformation = ("AIRCRAFT TYPE: " + typeOfAircraft + "\n" + "ID Aircraft: " + idAircraft
                + "\n" + "NAME: " + nameAircraft + "\n" + "MAXIMUM FUEL CONSUMPTION: " + fuelConsumption + "\n"
                + "AVERAGE FlIGHT SPEED " + flightSpeed + "\n" + "AVERAGE FlIGHT DISTANCE " + flightDistance + "\n" +
                "MAX PASSENGERS CAPACITY: " + maxBoardingCapacity + "\n" +
                "MAX CARRYING CAPACITY: " + maxCarryingCapacity + "\n" + "LUGGAGE COMPARTMENT AVAILABILITY: " + availability);

        return passengerAircraftInformation;
    }

    public PassengerLinerTechData getPassengerLinerTechData() {
        return passengerLinerTechData;
    }

    public void setPassengerLinerTechData(PassengerLinerTechData passengerLinerTechData) {
        this.passengerLinerTechData = passengerLinerTechData;
    }

    @Override
    public String toString() {
        return (super.toString() + "\n" + this.passengerLinerTechData.toString());
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

        PassengerAircraft other = (PassengerAircraft) obj;
        return (this.passengerLinerTechData.equals(other.passengerLinerTechData));
    }
}
