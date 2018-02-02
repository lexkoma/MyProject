package airlinecompany.companyexeptions;

/**
 * Class that indicates there are no Aircraft objects in a data file.
 */
public class EmptyFileException extends Exception {
    private static final long serialVersionUID = 6574800876190892190L;

    private String exceptionMessage;

    public EmptyFileException() {
        this.exceptionMessage = "There are no aircrafts in the file! File is empty!";
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
