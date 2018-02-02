package airlinecompany.maininfrastructure.aircrafts.aircrafrscomparator;

import airlinecompany.maininfrastructure.aircrafts.Aircraft;
import airlinecompany.technicalspecification.BoarderCapacity;

import java.util.Comparator;

public class PassengerBoardingComparator implements Comparator <Object> {
    /**
     * Compares objects by their passenger capacity
     **/
    @Override
    public int compare(Object o1, Object o2) {
        Aircraft oneObj = (Aircraft) o1;
        Aircraft twoObj = (Aircraft) o2;

        BoarderCapacity firstCapacity = (BoarderCapacity) oneObj.getBasicTechAircraftData().getMaxPassengerCapacity();
        BoarderCapacity secondCapacity = (BoarderCapacity) twoObj.getBasicTechAircraftData().getMaxPassengerCapacity();

        return (firstCapacity.compareTo(secondCapacity));
    }

}
