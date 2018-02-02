package airlinecompany.enums.comandsenum;

/**
 * for choosing a type of parameter to range Aircraft objects by a speed or a fuel consumption.
 */
public enum SearchRangeParameterEnum {
    RANGE_BY_SPEED, RANGE_BY_FUEL_CONSUMPTION, RANGE_BY_DISTANCE;

    //Returns a type of enum to choose a type of parameter to range according to string argument.

    public static SearchRangeParameterEnum stringToEnum(String comandString) {
        switch (comandString) {
            case "1": {
                return RANGE_BY_DISTANCE;
            }
            case "2": {
                return RANGE_BY_SPEED;
            }
            case "3": {
                return RANGE_BY_FUEL_CONSUMPTION;
            }

            default: {
                throw new IllegalArgumentException();
            }
        }
    }
}
