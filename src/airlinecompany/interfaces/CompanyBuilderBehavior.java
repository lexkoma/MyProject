package airlinecompany.interfaces;

import airlinecompany.maininfrastructure.company.Company;

import java.util.GregorianCalendar;

/**
 * create and initialize fields of Company object.
 */
public interface CompanyBuilderBehavior extends BuilderBehavior {
    void setCompanyId(int companyId);

    void setCompanyName(String companyName);

    void setCompanyEmail(String companyEmail);

    void setCompanyFoundationDate(GregorianCalendar companyFoundDate);

    // returns Company object
    Company getResult();
}
