package airlinecompany.maininfrastructure.aircrafts;

import airlinecompany.maininfrastructure.aircraftfeatures.BasicTechAircraftData;
import airlinecompany.technicalspecification.FlightRange;
import airlinecompany.technicalspecification.FlightSpeed;
import airlinecompany.tools.HashManager;

import java.io.Serializable;
import java.util.Objects;

/**
 * Class Aircraft represents an aircraft, which includes id, name, technical information.
 */
public abstract class Aircraft implements Comparable <Object>, Serializable {

    private static final long serialVersionUID = -3041449499296736830L;
    private static int aircraftsCounter = 0;
    protected transient int idAircraft;
    protected String nameOfAircraft;
    protected BasicTechAircraftData basicTechAircraftData;

    public Aircraft() {
        idAircraft = 0;
        nameOfAircraft = null;
        basicTechAircraftData = new BasicTechAircraftData();

        Aircraft.aircraftsCounter++; // for static field
    }

    public Aircraft(int idAircraft, String nameOfAircraft, BasicTechAircraftData basicTechAircraftData) {
        this.idAircraft = idAircraft;
        this.nameOfAircraft = nameOfAircraft;
        this.basicTechAircraftData = basicTechAircraftData;

        aircraftsCounter++;
    }


    public int getIdAircraft() {
        return idAircraft;
    }

    public void setIdAircraft(int idAircraft) {
        this.idAircraft = idAircraft;
    }

    public String getNameOfAircraft() {
        return nameOfAircraft;
    }

    public void setNameOfAircraft(String nameOfAircraft) {
        this.nameOfAircraft = nameOfAircraft;
    }

    public BasicTechAircraftData getBasicTechAircraftData() {
        return basicTechAircraftData;
    }

    public void setBasicTechAircraftData(BasicTechAircraftData basicTechAircraftData) {
        this.basicTechAircraftData = basicTechAircraftData;
    }

    //full technical information of defined aircrafts
    public abstract String getFullDataInformation();

    @Override
    public String toString() {
        return ("id = " + (this.idAircraft) + "\n" + "name = " + (this.nameOfAircraft) + "\n"
                + (this.basicTechAircraftData.toString()));
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

        Aircraft other = (Aircraft) obj;
        return ((this.idAircraft == other.idAircraft) && (this.nameOfAircraft.equals(other.nameOfAircraft))
                && (this.basicTechAircraftData.equals(other.basicTechAircraftData)));
    }

    @Override
    public int hashCode() {
        return (HashManager.createHashValue(this.nameOfAircraft + this.idAircraft));
    }

    //compares objects by their !!!!!!!!!!
    @Override
    public int compareTo(Object o) {
        Aircraft other = (Aircraft) o;
        FlightRange otherAverageDistance = other.getBasicTechAircraftData().getDistance();

        return ((FlightRange) this.basicTechAircraftData.getDistance()).compareTo(otherAverageDistance);
    }
}
