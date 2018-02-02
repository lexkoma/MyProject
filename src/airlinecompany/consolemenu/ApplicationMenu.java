package airlinecompany.consolemenu;

import airlinecompany.consolemenu.actions.*;
import airlinecompany.enums.comandsenum.MessagesForUserEnum;
import airlinecompany.enums.comandsenum.UserCommandEnum;
import airlinecompany.tools.AirlineManageSystem;

import java.util.Scanner;

import static airlinecompany.enums.comandsenum.MessagesForUserEnum.WARNING_MESSAGE_TRY_AGAIN;

/**
 * menu for user
 */
public class ApplicationMenu {
    //This field allows to manage  AirlineCompany
    private AirlineManageSystem airlineCompanyManager;

    //Runs main aplication menu for user via console.
    public void mainMenuRun() {

        // Create only one Scanner object for a whole menu
        Scanner inReader = new Scanner(System.in);

        while (true) {
            try {
                System.out.println(MessagesForUserEnum.getMainMenuActionsMessageInString());

                String commandAction = inReader.nextLine();
                UserCommandEnum action = UserCommandEnum.stringToEnum(commandAction);

                switch (action) {
                    case ADD_NEW_AIRCRAFT: {
                        AddNewAircraftAction.runAction(this.airlineCompanyManager, inReader);
                        break;
                    }
                    case CALCULATE_TOTAL_BY_PARAMETR: {
                        CalculateTotalParameterAction.runAction(this.airlineCompanyManager, inReader);
                        break;
                    }
                    case CREATE_AIRLINE_COMPANY: {
                        CreateAirlineCompanyAction.runAction(this.airlineCompanyManager, inReader);
                        break;
                    }
                    case EXIT_APPLICATION: {
                        ExitProgramAction.runAction(this.airlineCompanyManager, inReader);
                        break;
                    }
                    case GET_AIRCRAFT_LIST_BY_PARAMETER_RANGE: {
                        SuitableParameterRangeAction.runAction(this.airlineCompanyManager, inReader);
                        break;
                    }
                    case GET_FULL_AIRCRAFT_INFORMATION_FROM_BASE: {
                        GetFullAircraftDataInformationFromBaseAction.runAction(this.airlineCompanyManager, inReader);
                        break;
                    }
                    case GET_SORT_AIRCRAFT_LIST: {
                        GetSortAircraftsByParameterAction.runAction(this.airlineCompanyManager, inReader);
                        break;
                    }
                    case REMOVE_AIRCRAFT: {
                        RemoveAircraftAction.runAction(this.airlineCompanyManager, inReader);
                        break;
                    }
                    case SAVE_AIRCRAFTS_TO_FILE: {
                        SaveAircraftsToFileAction.runAction(this.airlineCompanyManager);
                        break;
                    }
                    case GET_FULL_INFORMATION_ABOUT_COMPANY: {
                        GetFullAirlineCompanyInformationAction.runAction(this.airlineCompanyManager);
                        break;
                    }
                    case READ_AICRAFTS_FROM_FILE: {
                        ReadAircraftsFromFileAction.runAction(this.airlineCompanyManager);
                        break;
                    }
                    default: {
                        System.out.println(WARNING_MESSAGE_TRY_AGAIN);
                        break;
                    }
                }
            } catch (IllegalArgumentException e) {
                System.out.println(WARNING_MESSAGE_TRY_AGAIN);
                continue;
            }
        }
    }

    public ApplicationMenu() {
        airlineCompanyManager = new AirlineManageSystem();
    }

}
