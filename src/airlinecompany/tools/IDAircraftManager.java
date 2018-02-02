package airlinecompany.tools;

/**
 * Class generates a unique int value for Aircraft object id field
 */
public class IDAircraftManager {
    static int randomCounter = 0;
    static final int VALUE_RANGE_LIMIT = 99999999;

    // This method generate unique Id for aircraft using hash and static field randomCounter

    public static int getUniqueIdAircraft(String aircraftName) {

        randomCounter++;
        int customHashValue = (HashManager.createHashValue((aircraftName + randomCounter)));

        if (customHashValue <= 0) {
            customHashValue = customHashValue * (-1);
        }

        int uniqueIdAircraft = customHashValue / VALUE_RANGE_LIMIT;
        return ((uniqueIdAircraft + 1) * 2);
    }

}
