package airlinecompany.companyexeptions;

/**
 * indicates that airline park doesn't have objects
 */
public class AirlineEmptyParkException extends Exception {
    private static final long serialVersionUID = 2901547997734926650L;

    private String exceptionMessage;

    public AirlineEmptyParkException() {
        this.exceptionMessage = "Airline park object has no aircraft objects";
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
