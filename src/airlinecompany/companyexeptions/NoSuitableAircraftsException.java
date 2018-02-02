package airlinecompany.companyexeptions;

/**
 * Class that indicates that a specified aircrafts weren't found.
 */
public class NoSuitableAircraftsException extends Exception {
    private static final long serialVersionUID = -5384012672632330861L;

    private String exceptionMessage;

    public NoSuitableAircraftsException() {
        this.exceptionMessage = "There is no suitable aircrafts at the airliner company park!";
    }

    public String getExceptionMessage() {
        return exceptionMessage;
    }

    public void setExceptionMessage(String exceptionMessage) {
        this.exceptionMessage = exceptionMessage;
    }

    @Override
    public String toString() {
        return super.toString();
    }

}
