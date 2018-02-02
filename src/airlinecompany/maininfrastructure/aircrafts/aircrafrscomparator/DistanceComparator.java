package airlinecompany.maininfrastructure.aircrafts.aircrafrscomparator;

import airlinecompany.maininfrastructure.aircrafts.Aircraft;
import airlinecompany.technicalspecification.FlightRange;

import java.util.Comparator;

public class DistanceComparator implements Comparator <Object> {
    /**
     * Compares objects by their fuel consumption
     */
    @Override
    public int compare(Object o1, Object o2) {
        Aircraft firstObj = (Aircraft) o1;
        Aircraft secondObj = (Aircraft) o2;

        FlightRange firstObjDistance = (FlightRange) firstObj.getBasicTechAircraftData().getDistance();
        FlightRange secondObjDistance = (FlightRange) secondObj.getBasicTechAircraftData().getDistance();

        return (firstObjDistance.compareTo(secondObjDistance));
    }
}
