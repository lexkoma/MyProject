package airlinecompany.enums.comandsenum;

/**
 * for choosing what type of Aircraft to create
 */
public enum AddAircraftsEnum {
    ADD_NEW_PASSENGER_AIRCRAFT, ADD_NEW_CARGO_AIRCRAFT;

    // Returns a type of enum to create a new Aircraft object according
    public static AddAircraftsEnum stringToEnum(String commandString) {
        switch (commandString) {
            case "1": {
                return ADD_NEW_PASSENGER_AIRCRAFT;
            }
            case "2": {
                return ADD_NEW_CARGO_AIRCRAFT;
            }
            default: {
                throw new IllegalArgumentException();
            }
        }
    }

}
