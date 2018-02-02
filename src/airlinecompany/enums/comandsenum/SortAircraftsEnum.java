package airlinecompany.enums.comandsenum;

/**
 * for choosing a type of sorting Aircraft's objects.
 */
public enum SortAircraftsEnum {
    SORT_BY_DISTANCE, SORT_BY_SPEED, SORT_BY_FUEL_CONSUMPTION, SORT_BY_WEIGHT_CAPACITY, SORT_BY_PASSENGER_CAPACITY;

    // Returns a type of enum to sort  Aircraft objects according to string argument.

    public static SortAircraftsEnum stringToEnum(String commandString) {
        switch (commandString) {
            case "1": {
                return SORT_BY_DISTANCE;
            }
            case "2": {
                return SORT_BY_FUEL_CONSUMPTION;
            }
            case "3": {
                return SORT_BY_WEIGHT_CAPACITY;
            }
            case "4": {
                return SORT_BY_PASSENGER_CAPACITY;
            }
            case "5": {
                return SORT_BY_SPEED;
            }
            default: {
                throw new IllegalArgumentException();
            }
        }
    }
}
