package airlinecompany.maininfrastructure.aircrafts.aircrafrscomparator;

import airlinecompany.maininfrastructure.aircrafts.Aircraft;
import airlinecompany.technicalspecification.CarryingCapacity;

import java.util.Comparator;

public class CargoCarryingComparator implements Comparator <Object> {
    /**
     * Compares  max cargocarriyng capacity
     */
    @Override
    public int compare(Object o1, Object o2) {
        Aircraft firstObj = (Aircraft) o1;
        Aircraft secondObj = (Aircraft) o2;

        CarryingCapacity firstObjMaxCargoCapacity = (CarryingCapacity) firstObj.getBasicTechAircraftData().getMaxCarryingCapacity();
        CarryingCapacity secondObjMaxCargoCapacity = (CarryingCapacity) secondObj.getBasicTechAircraftData().getMaxCarryingCapacity();

        return (firstObjMaxCargoCapacity.compareTo(secondObjMaxCargoCapacity));
    }

}
