package airlinecompany.builderpatterns;

import airlinecompany.maininfrastructure.aircraftfeatures.PassengerLinerTechData;
import airlinecompany.interfaces.BuilderBehavior;

/**
 * Class creates PassengerLinerTechData object and initializes it's fields
 */
public class PassengerAircraftTechDataBuilder implements BuilderBehavior {

    // A value of  PassengerLinerTechData object to create and initialize
    private PassengerLinerTechData passengerLinerTechData;

    public PassengerAircraftTechDataBuilder() {
        passengerLinerTechData = new PassengerLinerTechData();
    }

    public void setPassengerLinerType(String airlinerType) {
        passengerLinerTechData.setPassengerLinerType(airlinerType);
    }

    // Sets bussiness class field for passengerliner object
    public void setLuggageAvailability(boolean haveLuggage) {
        passengerLinerTechData.setHaveLuggageCompartment(haveLuggage);
    }

    // Returns a initialized  object
    public PassengerLinerTechData getResult() {
        return passengerLinerTechData;
    }
}
