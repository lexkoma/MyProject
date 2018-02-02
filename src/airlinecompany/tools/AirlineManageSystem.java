package airlinecompany.tools;

import airlinecompany.companyexeptions.AirlineEmptyParkException;
import airlinecompany.companyexeptions.EmptyFileException;
import airlinecompany.companyexeptions.NoAirlineCompanyException;
import airlinecompany.helper.FileAicraftsSerializeWriter;
import airlinecompany.helper.FileAircraftsSerializeReader;
import airlinecompany.maininfrastructure.aircrafts.Aircraft;
import airlinecompany.maininfrastructure.company.AirlineCompany;
import airlinecompany.interfaces.ReadAircraftsFromFile;
import airlinecompany.interfaces.WriteAircraftsToFile;
import airlinecompany.technicalspecification.*;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;

/**
 * Class manages the AirlineCompany object.
 */
public class AirlineManageSystem {

    // This field is an airliner company to manage.
    private AirlineCompany airlineCompany;

    //This method checks if airline company object was created
    public boolean haveAirlinerCompany() {
        return (this.airlineCompany != null);
    }

    //This method adds a new aircraft object to park of AirlineCompany
    public boolean addAircraft(Aircraft newAircraft) throws NoAirlineCompanyException {

        if (this.airlineCompany == null) {
            throw new NoAirlineCompanyException();
        }

        return (this.airlineCompany.addAircraftToPark(newAircraft));
    }

    //This method removes existing aircraft from airline park
    public boolean removeAircraft(Aircraft removingAircraft) throws NoAirlineCompanyException {

        if (this.airlineCompany == null) {
            throw new NoAirlineCompanyException();
        }

        return (this.airlineCompany.removeAircraftFromPark(removingAircraft));
    }

    // This method returns a list of all available aircrafts
    public List<Aircraft> getListOfAicrafts() throws NoAirlineCompanyException, AirlineEmptyParkException {

        if (this.airlineCompany == null) {
            throw new NoAirlineCompanyException();
        }

        if (this.airlineCompany.getTotalAmountOfAircraft() == 0) {
            throw new AirlineEmptyParkException();
        }

        return (this.airlineCompany.getListOfAircrafts());
    }

    // This method searches a specified speed
    public List<Aircraft> searchBySpeed(FlightSpeed from,
                                        FlightSpeed to) throws NoAirlineCompanyException, AirlineEmptyParkException {

        if (this.airlineCompany == null) {
            throw new NoAirlineCompanyException();
        }

        return (this.airlineCompany.searchBySpeedRange(from, to));
    }


    // This method searches a specified distance
    public List<Aircraft> searchByDistance(FlightRange from,
                                        FlightRange to) throws NoAirlineCompanyException, AirlineEmptyParkException {

        if (this.airlineCompany == null) {
            throw new NoAirlineCompanyException();
        }

        return (this.airlineCompany.searchByDistanceRange(from, to));
    }


    //This method searches aircrafts in range of specified fuel consumptiobreturns a list of {@code Aircraft} objects from
    public List<Aircraft> searchByFuel(FuelConsumption from,
                                       FuelConsumption to) throws NoAirlineCompanyException, AirlineEmptyParkException {

        if (this.airlineCompany == null) {
            throw new NoAirlineCompanyException();
        }

        return (this.airlineCompany.searchByFuelConsumption(from, to));
    }

    //This method returns a list of sort aircrafts objects by their flight speeds
    public List<Aircraft> sortlistAircraftsBySpeed()
            throws NoAirlineCompanyException, AirlineEmptyParkException {

        if (this.airlineCompany == null) {
            throw new NoAirlineCompanyException();
        }

        return (this.airlineCompany.getListOfSortedAircraftsBySpeed());
    }

    //This method returns a list of sort aircraft objects by their passenger capacity
    public List<Aircraft> sortlistAircraftByPassengerCapacity()
            throws NoAirlineCompanyException, AirlineEmptyParkException {

        if (this.airlineCompany == null) {
            throw new NoAirlineCompanyException();
        }

        return (this.airlineCompany.getListOfSortedAircraftByPeopleCapacity());
    }

    //This method returns a list of sort objects by their fuel consumption
    public List<Aircraft> sortlistAicraftByFuelConsumption()
            throws NoAirlineCompanyException, AirlineEmptyParkException {

        if (this.airlineCompany == null) {
            throw new NoAirlineCompanyException();
        }

        return (this.airlineCompany.getListOfSortedAircraftByFuelConsumption());
    }

    // This method returns a list of sort objects by their carrying capacity
    public List<Aircraft> sortlistAicraftByCarryingtCapacity()
            throws NoAirlineCompanyException, AirlineEmptyParkException {

        if (this.airlineCompany == null) {
            throw new NoAirlineCompanyException();
        }

        return (this.airlineCompany.getListOfSortedAircraftByCarryingCapacity());
    }

    // This method returns a list of sort objects by their distance
    public List<Aircraft> sortlistAicraftByDistance()
            throws NoAirlineCompanyException, AirlineEmptyParkException {

        if (this.airlineCompany == null) {
            throw new NoAirlineCompanyException();
        }

        return (this.airlineCompany.getListOfSortedAircraftByDistance());
    }

    // This method returns aircraft from airline park by its ID
    public Aircraft getAircraftById(int idAircraft) throws NoAirlineCompanyException, AirlineEmptyParkException {

        if (this.airlineCompany == null) {
            throw new NoAirlineCompanyException();
        }

        if (this.getAircraftsTotalAmount() == 0) {
            throw new AirlineEmptyParkException();
        }

        return (this.airlineCompany.searchByID(idAircraft));
    }

    // This method reaturns a total amount of passenger capacity from airline park

    public BoarderCapacity getTotalAircraftsCapacity()
            throws AirlineEmptyParkException, NoAirlineCompanyException {

        if (this.airlineCompany == null) {
            throw new NoAirlineCompanyException();
        }

        return (this.airlineCompany.getTotalAircraftsPassengersCapacity());
    }

    // This method reaturns a total amount of maximum weight capacity of all aircrafts in park
    public CarryingCapacity getTotalWeigthCapacity() throws AirlineEmptyParkException, NoAirlineCompanyException {

        if (this.airlineCompany == null) {
            throw new NoAirlineCompanyException();
        }

        return (this.airlineCompany.getTotalAircraftsCargoCapacity());
    }

    // This method returns a full information about a airline company
    public String getFullAirlineCompanyInformation() {

        String fullCompanyInformation = ("Airline company name: " + this.airlineCompany.getCompanyName() + "\n"
                + "Airline company email: " + this.airlineCompany.getCompanyEmail() + "\n"
                + "Airline company founding date: " + this.airlineCompany.getFoundDataParsedToString() + "\n"
                + "A total amount of aircrafts at the airliner company park: "
                + this.airlineCompany.getTotalAmountOfAircraft() + " aircrafts");

        return fullCompanyInformation;
    }

    // This method returns an amount of aircrafts in park
    public int getAircraftsTotalAmount() {
        return (this.airlineCompany.getTotalAmountOfAircraft());
    }

    //This method saves all aircrafts from airline park to file
    public void saveToFile() throws NoAirlineCompanyException, IOException, AirlineEmptyParkException {

        if (this.airlineCompany == null) {
            throw new NoAirlineCompanyException();
        }

        if (this.airlineCompany.getTotalAmountOfAircraft() == 0) {
            throw new AirlineEmptyParkException();
        }

        List<Aircraft> aircraftsList = this.getListOfAicrafts();

        WriteAircraftsToFile fileWriter = new FileAicraftsSerializeWriter();
        fileWriter.writeAircraftListToFile(aircraftsList);
    }

    //This method reads all Aircraft objects to AirlinePark from file
    public void readAircraftsFromFile() throws NoAirlineCompanyException, FileNotFoundException, ClassNotFoundException,
            IOException, EmptyFileException {

        if (this.airlineCompany == null) {
            throw new NoAirlineCompanyException();
        }

        ReadAircraftsFromFile fileReader = new FileAircraftsSerializeReader();
        List<Aircraft> aircraftsList = fileReader.readAircraftListFromFile();

        if (aircraftsList.size() == 0) {
            throw new EmptyFileException();
        }

        addAircraftFromFileToAirlineCompanyPark(aircraftsList);

    }

    //This metod adds an Aircraftobject from data file to
    // AircraftPark container with a new generated unique Id
    private void addAircraftFromFileToAirlineCompanyPark(List<Aircraft> aircraftsList) {
        for (Iterator<Aircraft> iterator = aircraftsList.iterator(); iterator.hasNext();) {
            Aircraft newAircraft = (Aircraft) iterator.next();

            // Generate a unique Id for an aircraft from file and add this
            // aircraft to airliner company park
            int uniqueId = IDAircraftManager.getUniqueIdAircraft(newAircraft.getNameOfAircraft());

            newAircraft.setIdAircraft(uniqueId);
            if (!(this.airlineCompany.addAircraftToPark(newAircraft))) {
                System.out.println("Problems to add new aircraft to airline company park!");
                return;
            }

        }
    }

    public AirlineManageSystem() {
        this.airlineCompany = null;
    }

    public void setAirlineCompany(AirlineCompany airlineCompany) {
        this.airlineCompany = airlineCompany;
    }

    public AirlineCompany getAirlineCompany() {
        return airlineCompany;
    }
}
