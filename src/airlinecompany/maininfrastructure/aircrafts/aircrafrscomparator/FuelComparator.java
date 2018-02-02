package airlinecompany.maininfrastructure.aircrafts.aircrafrscomparator;

import airlinecompany.maininfrastructure.aircrafts.Aircraft;
import airlinecompany.technicalspecification.FuelConsumption;

import java.util.Comparator;

public class FuelComparator implements Comparator <Object> {
    /**
     * Compares objects by their fuel consumption
     */
    @Override
    public int compare(Object o1, Object o2) {
        Aircraft firstObj = (Aircraft) o1;
        Aircraft secondObj = (Aircraft) o2;

        FuelConsumption firstObjFuel = (FuelConsumption) firstObj.getBasicTechAircraftData().getFuelConsumption();
        FuelConsumption secondObjFuel = (FuelConsumption) secondObj.getBasicTechAircraftData().getFuelConsumption();

        return (firstObjFuel.compareTo(secondObjFuel));
    }

}
