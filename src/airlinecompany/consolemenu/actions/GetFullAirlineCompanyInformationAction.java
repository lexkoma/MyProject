
package airlinecompany.consolemenu.actions;


import airlinecompany.companyexeptions.NoAirlineCompanyException;
import airlinecompany.tools.AirlineManageSystem;

import static airlinecompany.enums.comandsenum.MessagesForUserEnum.WARNING_MESSAGE_NEED_AIRLINE_COMPANY;

/**
 * Class represents an action to get a full information about the airline company
 */
public class GetFullAirlineCompanyInformationAction {

	// This method show a full information about airline company
	public static void runAction(AirlineManageSystem airlineCompanyManager) {
		try {

			if (!(airlineCompanyManager.haveAirlinerCompany())) {
				throw new NoAirlineCompanyException();
			}

			System.out.println(airlineCompanyManager.getFullAirlineCompanyInformation());
		} catch (NoAirlineCompanyException e) {
			System.out.println(WARNING_MESSAGE_NEED_AIRLINE_COMPANY);
		}
	}

}
