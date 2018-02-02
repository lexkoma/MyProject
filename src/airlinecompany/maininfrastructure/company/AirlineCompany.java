package airlinecompany.maininfrastructure.company;

import airlinecompany.companyexeptions.AirlineEmptyParkException;
import airlinecompany.maininfrastructure.aircrafts.Aircraft;
import airlinecompany.maininfrastructure.aircrafts.aircrafrscomparator.DistanceComparator;
import airlinecompany.maininfrastructure.aircrafts.aircrafrscomparator.PassengerBoardingComparator;
import airlinecompany.maininfrastructure.aircrafts.aircrafrscomparator.CargoCarryingComparator;
import airlinecompany.maininfrastructure.aircrafts.aircrafrscomparator.FuelComparator;
import airlinecompany.maininfrastructure.companypark.AirlinePark;
import airlinecompany.technicalspecification.*;

import java.util.*;

/**
 * Class AirlineCompany represents a airline company, which includes id, companie's name, companie's email,
 * companies date of found and fields to storage Aircraft objects. AirlineCompany inherits Company and give's more
 * opportunities to manage airline company.
 */
public class AirlineCompany extends Company {

    private AirlinePark airlinePark;

    public AirlineCompany(int id, String name, String email, GregorianCalendar today, AirlinePark airlinePark) {
        super(id, name, email, today);
        this.airlinePark = airlinePark;
    }

    public AirlineCompany() {
        super();
        this.airlinePark = new AirlinePark();
    }


    public void setAirlinePark(AirlinePark airlinePark) {
        this.airlinePark = airlinePark;
    }

    public AirlinePark getAirlinePark() {
        return this.airlinePark;
    }

    @Override
    public String toString() {
        return (super.toString() + "\n" + (this.airlinePark.toString()));
    }

    // This method adds aircraft to airline park container
    public boolean addAircraftToPark(Aircraft newAircraft) {
        return (this.airlinePark.addAirCraft(newAircraft));
    }

    //// This method removes aircraft from airline park container
    public boolean removeAircraftFromPark(Aircraft removingAircraft) {
        return (this.airlinePark.removeAircraft(removingAircraft));
    }

    // This method returns total amount of passenger capacity
    public BoarderCapacity getTotalAircraftsPassengersCapacity() throws AirlineEmptyParkException {
        return (this.airlinePark.getTotalBorderCapacity());
    }


    // This method returns total amount of cargocarrying capacity
    public CarryingCapacity getTotalAircraftsCargoCapacity() throws AirlineEmptyParkException {
        return (this.airlinePark.getTotalWeigthCapacity());
    }

    // This method returns total amount of aircrafts in airline park

    public int getTotalAmountOfAircraft() {
        return (this.airlinePark.getTotalAircraftsAmount());
    }

    //This method sorts aircrafts by flight speed
    public List<Aircraft> getListOfSortedAircraftsBySpeed() throws AirlineEmptyParkException {

        if (this.airlinePark.getTotalAircraftsAmount() == 0) {
            throw new AirlineEmptyParkException();
        }

        List<Aircraft> listOfAircraft = new ArrayList<>(this.airlinePark.getAirlinePark());
        Collections.sort(listOfAircraft);
        return listOfAircraft;
    }

    //This method sorts aircrafts by passenger capacity and uses boardingcomparator
    public List<Aircraft> getListOfSortedAircraftByPeopleCapacity() throws AirlineEmptyParkException {

        if (this.airlinePark.getTotalAircraftsAmount() == 0) {
            throw new AirlineEmptyParkException();
        }

        List<Aircraft> listOfAircraft = new ArrayList<>(this.airlinePark.getAirlinePark());
        Collections.sort(listOfAircraft, new PassengerBoardingComparator());
//        listOfAircraft.sort(new PassengerBoardingComparator());
        return listOfAircraft;
    }

    // This method sorts aircrafts by fuel consumption and uses fuelcomapator call's a
    public List<Aircraft> getListOfSortedAircraftByFuelConsumption() throws AirlineEmptyParkException {

        if (this.airlinePark.getTotalAircraftsAmount() == 0) {
            throw new AirlineEmptyParkException();
        }

        List<Aircraft> listOfAircraft = new ArrayList<>(this.airlinePark.getAirlinePark());
        Collections.sort(listOfAircraft, new FuelComparator());
//        listOfAircraft.sort(new FuelComparator());
        return listOfAircraft;
    }

    // This method sorts by cargocarrying capacity and uses cargocarrying comparator
    public List<Aircraft> getListOfSortedAircraftByCarryingCapacity() throws AirlineEmptyParkException {

        if (this.airlinePark.getTotalAircraftsAmount() == 0) {
            throw new AirlineEmptyParkException();
        }

        List<Aircraft> listOfAircraft = new ArrayList<>(this.airlinePark.getAirlinePark());
        Collections.sort(listOfAircraft, new CargoCarryingComparator());
        return listOfAircraft;
    }


    // This method sorts by cargocarrying capacity and uses cargocarrying comparator
    public List<Aircraft> getListOfSortedAircraftByDistance() throws AirlineEmptyParkException {

        if (this.airlinePark.getTotalAircraftsAmount() == 0) {
            throw new AirlineEmptyParkException();
        }

        List<Aircraft> listOfAircraft = new ArrayList<>(this.airlinePark.getAirlinePark());
        Collections.sort(listOfAircraft, new DistanceComparator());
        return listOfAircraft;
    }

    // This method returns list of aircrafts of the company

    public List<Aircraft> getListOfAircrafts() {

        List<Aircraft> listOfAircraft = new ArrayList<>(this.airlinePark.getAirlinePark());
        return listOfAircraft;
    }

    // This method returns a list of aircrafts, whose fuel consumption is in specified range

    public List<Aircraft> searchByFuelConsumption(FuelConsumption from,
                                                  FuelConsumption to) throws AirlineEmptyParkException {

        if (this.airlinePark.getTotalAircraftsAmount() == 0) {
            throw new AirlineEmptyParkException();
        }

        List<Aircraft> listOfFoundAicrafts = new LinkedList<>();
        Set<Aircraft> aircraftSet = this.airlinePark.getAirlinePark();

        for (Iterator<Aircraft> iterAircraftSet = aircraftSet.iterator(); iterAircraftSet.hasNext();) {
            Aircraft aircraft = (Aircraft) iterAircraftSet.next();

            FuelConsumption aicraftFuelSpend = (FuelConsumption) aircraft.getBasicTechAircraftData()
                    .getFuelConsumption();
            if ((aicraftFuelSpend.compareTo(from) >= 0)
                    && (aicraftFuelSpend.compareTo(to) <= 0)) {
                listOfFoundAicrafts.add(aircraft);
            }
        }

//        for (Aircraft aircraft : aircraftSet) {
//            FuelConsumption aicraftFuelSpend = (FuelConsumption) aircraft.getBasicTechAircraftData()
//                    .getFuelConsumption();
//            if ((aicraftFuelSpend.compareTo(from) >= 0)
//                    && (aicraftFuelSpend.compareTo(to) <= 0)) {
//                listOfFoundAicrafts.add(aircraft);
//            }
//
//        }

        return listOfFoundAicrafts;
    }

    // This method returns a list of aircrafts, whose flight speed is in specified range

    public List<Aircraft> searchBySpeedRange(FlightSpeed from, FlightSpeed to) throws AirlineEmptyParkException {

        if (this.airlinePark.getTotalAircraftsAmount() == 0) {
            throw new AirlineEmptyParkException();
        }

        List<Aircraft> listOfFoundAicrafts = new LinkedList<>();
        Set<Aircraft> aircraftSet = this.airlinePark.getAirlinePark();

        for (Iterator<Aircraft> iterAircraftSet = aircraftSet.iterator(); iterAircraftSet.hasNext();) {
            Aircraft aircraft = (Aircraft) iterAircraftSet.next();

            FlightSpeed aicraftSpeed = (FlightSpeed) aircraft.getBasicTechAircraftData()
                    .getAverageFlightSpeed();

            if ((aicraftSpeed.compareTo(from) >= 0)
                    && (aicraftSpeed.compareTo(to) <= 0)) {
                listOfFoundAicrafts.add(aircraft);
            }
        }
        return listOfFoundAicrafts;
    }

    // This method returns a list of aircrafts, whose flight distance is in specified range
    public List<Aircraft> searchByDistanceRange(FlightRange from, FlightRange to) throws AirlineEmptyParkException {

        if (this.airlinePark.getTotalAircraftsAmount() == 0) {
            throw new AirlineEmptyParkException();
        }

        List<Aircraft> listOfFoundAicrafts = new LinkedList<>();
        Set<Aircraft> aircraftSet = this.airlinePark.getAirlinePark();

        for (Iterator<Aircraft> iterAircraftSet = aircraftSet.iterator(); iterAircraftSet.hasNext();) {
            Aircraft aircraft = (Aircraft) iterAircraftSet.next();

            FlightRange aicraftRange = (FlightRange) aircraft.getBasicTechAircraftData()
                    .getDistance();

            if ((aicraftRange.compareTo(from) >= 0)
                    && (aicraftRange.compareTo(to) <= 0)) {
                listOfFoundAicrafts.add(aircraft);
            }
        }
        return listOfFoundAicrafts;
    }

    //This method searches aircrafts by its ID

    public Aircraft searchByID(int idAircraft) {
        List<Aircraft> listOfAircraft = new ArrayList<>(this.airlinePark.getAirlinePark());

        for (Iterator<Aircraft> iterAicraftList = listOfAircraft.iterator(); iterAicraftList.hasNext();) {
            Aircraft aircraft = (Aircraft) iterAicraftList.next();

            if (aircraft.getIdAircraft() == idAircraft) {
                return aircraft;
            }
        }
        return null;
    }
}
