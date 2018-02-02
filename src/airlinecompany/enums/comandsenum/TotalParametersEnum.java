package airlinecompany.enums.comandsenum;

/**
 * for choosing  to calculate a summary of Aircraft's parameters
 */
public enum TotalParametersEnum {
    TOTAL_PASSENGER_CAPACITY, TOTAL_CARRYING_CAPACITY;

    public static TotalParametersEnum stringToEnum(String comandString) {
        switch (comandString) {
            case "1": {
                return TOTAL_PASSENGER_CAPACITY;
            }
            case "2": {
                return TOTAL_CARRYING_CAPACITY;
            }
            default: {
                throw new IllegalArgumentException();
            }
        }
    }

}
