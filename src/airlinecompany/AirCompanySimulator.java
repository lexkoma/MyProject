package airlinecompany;

import airlinecompany.consolemenu.ApplicationMenu;

/**
 * "AirCompanySimulator" program is a console application, where
 * user can manage an airline company via computer console
 */
public class AirCompanySimulator {

    public static void main(String[] args) {

        ApplicationMenu mn = new ApplicationMenu();
        mn.mainMenuRun();
    }
}
