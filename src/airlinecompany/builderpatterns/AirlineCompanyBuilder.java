package airlinecompany.builderpatterns;

import airlinecompany.maininfrastructure.company.AirlineCompany;
import airlinecompany.maininfrastructure.companypark.AirlinePark;
import airlinecompany.interfaces.CompanyBuilderBehavior;

import java.util.GregorianCalendar;

/**
 * Class creates AirlineCompany object and initializes it's fields.
 */
public class AirlineCompanyBuilder implements CompanyBuilderBehavior{

    // value of airlinecompany object to create and initialize
    private AirlineCompany airlineCompany;

    public AirlineCompanyBuilder() {
        airlineCompany = new AirlineCompany();
    }

    //This method fill all fields of a new airline company, just need only a
    public void buildAirlineCompanyByCompanyName(String companyName) {
        airlineCompany.setCompanyName(companyName);

        // Make all symbols at the company name to lower case and delete spaces
        // between words
        airlineCompany.setCompanyEmail(companyName.toLowerCase().replace(" ", "") + "@airlines.com");

		//Create a company founding date, get a date from operating system just
		//at at the time of creation new GregorianCalendar object
        GregorianCalendar companyFoundDate = new GregorianCalendar();
        airlineCompany.setCompanyFoundDate(companyFoundDate);

        // Generate a unique company id for a new airline company
        airlineCompany.setCompanyId((int) (Math.random() * 300));
    }

    //Sets an unique ID for AirlineCompany object
    @Override
    public void setCompanyId(int companyId) {
        airlineCompany.setCompanyId(companyId);
    }

    @Override
    public void setCompanyName(String companyName) {
        airlineCompany.setCompanyName(companyName);
    }

    @Override
    public void setCompanyEmail(String companyEmail) {
        airlineCompany.setCompanyEmail(companyEmail);
    }

    @Override
    public void setCompanyFoundationDate(GregorianCalendar companyFoundDate) {
        airlineCompany.setCompanyFoundDate(companyFoundDate);
    }

    // Sets an aircraftPark for company
    public void setAircraftPark(AirlinePark aircraftPark) {
        airlineCompany.setAirlinePark(aircraftPark);
    }

    //Return's a initialized {@code AirlineCompany} object
    public AirlineCompany getResult() {
        return airlineCompany;
    }


}
