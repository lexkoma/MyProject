package airlinecompany.maininfrastructure.aircraftfeatures;

import airlinecompany.interfaces.UniqueAircraftBehavior;
import airlinecompany.technicalspecification.BoarderCapacity;

import java.io.Serializable;

public class PassengerLinerTechData implements UniqueAircraftBehavior, Serializable {
    private static final long serialVersionUID = -3359592238856724417L;

    private String airlinerType; // aircraft type depending on the flight distance
    private boolean luggageCompartment;


    public PassengerLinerTechData(String airlinerType, boolean luggageCompartment) {
        this.airlinerType = airlinerType;
        this.luggageCompartment = luggageCompartment;
    }


    public PassengerLinerTechData() {
        this.airlinerType = null;
    }

    public String getPassengerLinerType() {
        return airlinerType;
    }

    public void setPassengerLinerType(String airlinerType) {
        this.airlinerType = airlinerType;
    }

    public boolean haveLuggageCompartment() {
        return luggageCompartment;
    }

    public void setHaveLuggageCompartment(boolean luggageCompartment) {
        this.luggageCompartment = luggageCompartment;
    }

    @Override
    public String toString() {
        return "airlinerType = " + (this.airlinerType) + "\n" + "have luggage compartment = " + (this.luggageCompartment);
    }

    @Override
    public boolean equals(Object obj) {

        if (obj == this) {
            return true;
        }

        if (obj == null) {
            return false;
        }

        if (!(obj instanceof PassengerLinerTechData)) {
            return false;
        }

        PassengerLinerTechData other = (PassengerLinerTechData) obj;
        return ((this.luggageCompartment == other.luggageCompartment) && (this.airlinerType.equals(other.airlinerType)));
    }
}
