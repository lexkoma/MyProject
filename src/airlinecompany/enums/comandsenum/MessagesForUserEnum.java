package airlinecompany.enums.comandsenum;

public enum MessagesForUserEnum {
    // ----Warnings messages

    WARNING_MESSAGE_TRY_AGAIN("Try again!"),

    WARNING_MESSAGE_EMPTY_PARK("The airline park of company is empty!"),

    WARNING_MESSAGE_NEED_AIRLINE_COMPANY("At first create an airline company!"),

    WARNING_MESSAGE_NO_SUITABLE_AIRCRAFTS(
            "There aren't any aircrafts at the park, which are suitable for search query!"),

    WARNING_MESSAGE_PROBLEM_WRITE_OR_READ_FILE(
            "There are some problems with writing/reading data to/from a file, please wait for a new version of program with fix bugs"),

    WARNING_MESSAGE_PROBLEM_EMPTY_AIRCRAFT_FILE("There are no aircrafts at the file! File is empty!"),

    // ----Main menu actions messages
    MESSAGE_CREATE_AIRLINE_COMPANY("----Enter '1' to create new airline company: "),

    MESSAGE_ADD_NEW_AIRCRAFT("----Enter '2' to create and add a new aircraft to airliner company park: "),

    MESSAGE_GET_SORT_AIRCRAFT_LIST("----Enter '3' to show aircrafts, which will be sorted by selected parameter: "),

    MESSAGE_GET_AICRAFT_LIST_BY_PARAMETR_RANGE(
            "----Enter '4' to show all aircrafts with specified parameters, which are included in the range: "),

    MESSAGE_GET_FULL_AIRCRAFT_INFORMATION_FROM_BASE(
            "----Enter '5' to get full information about aircraft from the airliner company park: "),

    MESSAGE_CALCULATE_TOTAL_BY_PARAMETR(
            "----Enter '6' to calculate a total parameter of all aircrafts at the airline company park: "),

    MESSAGE_REMOVE_AIRCRAFT("----Enter '7' to remove a suitable aircraft from the airliner company park: "),

    MESSAGE_GET_FULL_INFORMATION_ABOUT_COMPANY("----Enter '8' to get full data information about airline company:"),

    MESSAGE_SAVE_AIRCRAFTS_TO_FILE("----Enter '9' to save aircrafts information to data file:"),

    MESSAGE_READ_AICRAFTS_FROM_FILE("----Enter '10' to load aircrafts information from data file:"),


    MESSAGE_EXIT_APPLICATION("----Enter '0' to exit the application:"),

    // ---Special messages for action CALCULATE_TOTAL_BY_PARAMETR
    MESSAGE_CHOSE_TOTAL_PASSENGER_CAPACITY(
            "---Enter '1' to calculate a total passengers capacity of all aircrafts at the airline company park:"),

    MESSAGE_CHOSE_TOTAL_CARRYING_CAPACITY(
            "---Enter '2' to calculate a total carrying capacity of all aircrafts at the airline company park:"),

    // ---Special messages for action GET_SORT_AIRCRAFT_LIST
    MESSAGE_CHOSE_GET_AIRCRAFTS_SORT_BY_DISTANCE(
            "---Enter '1' to show all aircrafts sorted by their fligth range:"),

    MESSAGE_CHOSE_GET_AIRCRAFTS_SORT_BY_FUEL(
            "---Enter '2' to show all aircrafts sorted by their fuel consumption: "),

    MESSAGE_CHOSE_GET_AIRCRAFTS_SORT_BY_CARRYING_CAPACITY(
            "---Enter '3' to show all aircrafts sorted by their maximum carrying capacity:"),

    MESSAGE_CHOSE_GET_AIRCRAFTS_SORT_BY_PASSENGER_CAPACITY(
            "---Enter '4' to show all aircrafts sorted by their maximum passenger capacity:"),

    MESSAGE_CHOSE_GET_AIRCRAFTS_SORT_BY_SPEED(
            "---Enter '5' to show all aircrafts sorted by their average speed:"),

    // ---Special messages for action GET_AIRCRAFT_LIST_BY_PARAMETER_RANGE
    MESSAGE_CHOSE_GET_AIRCRAFTS_RANGE_BY_DISTANCE(
            "---Enter '1' to show all aircrafts, which have a suitable flight distance:"),

    MESSAGE_CHOSE_GET_AIRCRAFTS_RANGE_BY_SPEED(
            "---Enter '2' to show all aircrafts, which have a suitable speed:"),

    MESSAGE_CHOSE_GET_AIRCRAFTS_RANGE_BY_FUEL(
            "---Enter '3' to show all aircrafts, which have a suitable fuel consumption:"),


    // ---Special messages for action EXIT_APPLICATION
    MESSAGE_CHOSE_SAVE_TO_FILE_BEFORE_EXIT(
            "---Enter '1' to save aircrafts from airline company park to data file before exit a program:"),

    MESSAGE_CHOSE_NO_SAVE_TO_FILE_BEFORE_EXIT(
            "---Enter '2' to exit program without saving aircrafts from airline company park to data file:"),

    // ---Special messages for action CREATE_AIRLINE_COMPANY
    MESSAGE_CHOSE_MAU("---Enter '1' to chose 'MAU'"),

    MESSAGE_CHOSE_TURKISH_AIRLINES("---Enter '2' to chose 'Turkish Airlines'"),

    MESSAGE_CHOSE_WIZZAIR("---Enter '3' to chose 'WIZZAIR'"),

    MESSAGE_CHOSE_BRITISH_AIRLINES("---Enter '4' to chose 'British Airlines'"),

    // ---Special messages for action ADD_NEW_AIRCRAFT
    MESSAGE_CHOSE_ADD_NEW_AIRLINER_AICRAFT("---Enter '1' to add a new airliner aircraft:"),

    MESSAGE_CHOSE_ADD_NEW_CARGO_AICRAFT("---Enter '2' to add a new cargo aircraft:");


    // Returns menu navigation and menu actions in string
    public static String getMainMenuActionsMessageInString() {

        String message = new String("----------------------------------------------------------" + "\n"
                + MESSAGE_CREATE_AIRLINE_COMPANY + "\n"

                + MESSAGE_ADD_NEW_AIRCRAFT + "\n"

                + MESSAGE_GET_SORT_AIRCRAFT_LIST + "\n"

                + MESSAGE_GET_AICRAFT_LIST_BY_PARAMETR_RANGE + "\n"

                + MESSAGE_GET_FULL_AIRCRAFT_INFORMATION_FROM_BASE + "\n"

                + MESSAGE_CALCULATE_TOTAL_BY_PARAMETR + "\n"

                + MESSAGE_REMOVE_AIRCRAFT + "\n"

                + MESSAGE_GET_FULL_INFORMATION_ABOUT_COMPANY + "\n"

                + MESSAGE_SAVE_AIRCRAFTS_TO_FILE + "\n"

                + MESSAGE_READ_AICRAFTS_FROM_FILE + "\n"

                + MESSAGE_EXIT_APPLICATION + "\n" + "----------------------------------------------------------");
        return message;
    }

    // Returns menu navigation for user in string
    public static String getSortAircraftsByParameterMessage() {
        String message = new String("----------------------------------------------------------" + "\n"
                + MESSAGE_CHOSE_GET_AIRCRAFTS_SORT_BY_DISTANCE + "\n"
                + MESSAGE_CHOSE_GET_AIRCRAFTS_SORT_BY_FUEL + "\n"
                + MESSAGE_CHOSE_GET_AIRCRAFTS_SORT_BY_CARRYING_CAPACITY + "\n"
                + MESSAGE_CHOSE_GET_AIRCRAFTS_SORT_BY_PASSENGER_CAPACITY + "\n"
                + MESSAGE_CHOSE_GET_AIRCRAFTS_SORT_BY_SPEED + "\n"
                + "----------------------------------------------------------");
        return message;
    }


    public static String getMenuActionCalculateTotalByParametrMessageInString() {
        String message = new String("----------------------------------------------------------" + "\n"
                + MESSAGE_CHOSE_TOTAL_PASSENGER_CAPACITY + "\n" + MESSAGE_CHOSE_TOTAL_CARRYING_CAPACITY + "\n"
                + "----------------------------------------------------------");
        return message;
    }


    public static String getMenuActionGetAircraftsByParametrRangeMessageInString() {
        String message = new String("----------------------------------------------------------" + "\n"
                + MESSAGE_CHOSE_GET_AIRCRAFTS_RANGE_BY_DISTANCE + "\n"
                + MESSAGE_CHOSE_GET_AIRCRAFTS_RANGE_BY_SPEED + "\n"
                + MESSAGE_CHOSE_GET_AIRCRAFTS_RANGE_BY_FUEL + "\n"
                + "----------------------------------------------------------");
        return message;
    }

    public static String getMenuActionExitProgramInString() {
        String message = new String("----------------------------------------------------------" + "\n"
                + MESSAGE_CHOSE_SAVE_TO_FILE_BEFORE_EXIT + "\n" + MESSAGE_CHOSE_NO_SAVE_TO_FILE_BEFORE_EXIT + "\n"
                + "----------------------------------------------------------");
        return message;
    }

    public static String getMenuActionCreateAirlineCompanyInString() {
        String message = new String("----------------------------------------------------------" + "\n"
                + MESSAGE_CHOSE_MAU + "\n" + MESSAGE_CHOSE_TURKISH_AIRLINES + "\n" + MESSAGE_CHOSE_WIZZAIR + "\n"
                + MESSAGE_CHOSE_BRITISH_AIRLINES + "\n" + "----------------------------------------------------------");
        return message;
    }


    public static String getMenuActionAddNewAirecraft() {
        String message = new String("----------------------------------------------------------" + "\n"
                + MESSAGE_CHOSE_ADD_NEW_AIRLINER_AICRAFT + "\n" + MESSAGE_CHOSE_ADD_NEW_CARGO_AICRAFT + "\n"
                + "----------------------------------------------------------");
        return message;
    }

    /**
     * This field is a String value of message for user console to navigate
     * menu.
     */
    private String message;

    private MessagesForUserEnum(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return (this.message);
    }

}
