package airlinecompany.maininfrastructure.companypark;

import airlinecompany.companyexeptions.AirlineEmptyParkException;
import airlinecompany.maininfrastructure.aircrafts.Aircraft;
import airlinecompany.technicalspecification.BoarderCapacity;
import airlinecompany.technicalspecification.CarryingCapacity;

import java.util.HashSet;
import java.util.Set;

/**
 * Class  represents a container, which includes aircrafts object's. Also airline company has such container
 * to storage different aircrafts
 */
public class AirlinePark {

    private Set<Aircraft> airlinePark; // container to storage different aircrafts
    private int amount; // amount of aircrafts

    public AirlinePark() {
        this.airlinePark = new HashSet<>();
        this.amount = 0;
    }

    public Set<Aircraft> getAirlinePark() {
        return airlinePark;
    }

    public void setAirlinePark(Set<Aircraft> airlinePark) {
        this.airlinePark = airlinePark;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    @Override
    public String toString() {
        return "Airline park includes: " + amount + " aircrafts";
    }

    //add aircraft to park. after successful adding, also this method increments amount of aircrafts
    public boolean addAirCraft(Aircraft newAircraft) {
        if (airlinePark.add(newAircraft)) {
            amount++;
            return true;
        } else {
            return false;
        }
    }

    //remove aircraft from park
    public boolean removeAircraft(Aircraft removingAircraft) {
        if (airlinePark.remove(removingAircraft)) {
            amount--;
            return true;
        } else {
            return false;
        }
    }

    //a total amount of people capacity on board at this airline park
    public BoarderCapacity getTotalBorderCapacity() throws AirlineEmptyParkException {
            if (this.amount == 0) {
                throw new AirlineEmptyParkException();
            }

            int totalAmountPeopleCapacityInt = 0;

            for (Aircraft aircraft : airlinePark) {
                totalAmountPeopleCapacityInt = totalAmountPeopleCapacityInt
                        + (int) aircraft.getBasicTechAircraftData().getMaxPassengerCapacity().getMeasureValueInInt();
            }

            BoarderCapacity totalBorderCapacity = new BoarderCapacity(totalAmountPeopleCapacityInt);
            return totalBorderCapacity;
        }

    //a total amount of carrying capacity of all aircrafts at this airline park
    public CarryingCapacity getTotalWeigthCapacity() throws AirlineEmptyParkException {

        if (this.amount == 0) {
            throw new AirlineEmptyParkException();
        }

        int totalAmountWieghtCapacityInt = 0;

        for (Aircraft aircraft : airlinePark) {
            totalAmountWieghtCapacityInt = totalAmountWieghtCapacityInt
                    + (int) aircraft.getBasicTechAircraftData().getMaxCarryingCapacity().getMeasureValueInInt();
        }

        CarryingCapacity totalAmountMaxWeigthCapacity = new CarryingCapacity(totalAmountWieghtCapacityInt);
        return totalAmountMaxWeigthCapacity;
    }

    //a total amount of aircrafts at the airline park
    public int getTotalAircraftsAmount() {
        return this.amount;
    }

}
