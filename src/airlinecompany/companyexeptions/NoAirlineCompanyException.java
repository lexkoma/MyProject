package airlinecompany.companyexeptions;

/**
 * Class that indicates AirlineCompany object's haven't been created.
 */
public class NoAirlineCompanyException extends Exception {
    private static final long serialVersionUID = -6695279734371118798L;


    private String exceptionMessage;

    public NoAirlineCompanyException() {
        this.exceptionMessage = "Please at first create airline company!";
    }

    public String getExceptionMessage() {
        return exceptionMessage;
    }

    public void setExceptionMessage(String exceptionMessage) {
        this.exceptionMessage = exceptionMessage;
    }

    @Override
    public String toString() {
        return exceptionMessage;
    }

}
