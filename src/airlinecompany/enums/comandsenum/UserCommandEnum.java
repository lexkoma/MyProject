package airlinecompany.enums.comandsenum;

/**
 * commands for user console menu to manage objects.
 *
 */
public enum UserCommandEnum {

    CREATE_AIRLINE_COMPANY,

    GET_FULL_INFORMATION_ABOUT_COMPANY,

    CALCULATE_TOTAL_BY_PARAMETR,

    GET_SORT_AIRCRAFT_LIST,

    GET_AIRCRAFT_LIST_BY_PARAMETER_RANGE,

    GET_FULL_AIRCRAFT_INFORMATION_FROM_BASE,

    ADD_NEW_AIRCRAFT,

    REMOVE_AIRCRAFT,

    SAVE_AIRCRAFTS_TO_FILE,

    READ_AICRAFTS_FROM_FILE,

    EXIT_APPLICATION;

    public static UserCommandEnum stringToEnum(String comandString) {
        switch (comandString) {
            case "1": {
                return CREATE_AIRLINE_COMPANY;
            }
            case "2": {
                return ADD_NEW_AIRCRAFT;
            }
            case "3": {
                return GET_SORT_AIRCRAFT_LIST;
            }
            case "4": {
                return GET_AIRCRAFT_LIST_BY_PARAMETER_RANGE;
            }
            case "5": {
                return GET_FULL_AIRCRAFT_INFORMATION_FROM_BASE;
            }
            case "6": {
                return CALCULATE_TOTAL_BY_PARAMETR;
            }
            case "7": {
                return REMOVE_AIRCRAFT;
            }
            case "8": {
                return GET_FULL_INFORMATION_ABOUT_COMPANY;
            }
            case "9": {
                return SAVE_AIRCRAFTS_TO_FILE;
            }
            case "10": {
                return READ_AICRAFTS_FROM_FILE;
            }
            case "0": {
                return EXIT_APPLICATION;
            }
            default: {
                throw new IllegalArgumentException();
            }
        }
    }

}
