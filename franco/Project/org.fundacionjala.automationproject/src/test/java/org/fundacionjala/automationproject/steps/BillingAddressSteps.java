package org.fundacionjala.automationproject.steps;

import static org.fundacionjala.automationproject.entities.AddressInfo.ADDRESS;
import static org.fundacionjala.automationproject.entities.AddressInfo.CITY;
import static org.fundacionjala.automationproject.entities.AddressInfo.COUNTRY;
import static org.fundacionjala.automationproject.entities.AddressInfo.STATE;
import static org.fundacionjala.automationproject.entities.AddressInfo.ZIP;

import cucumber.api.java.en.When;
import org.fundacionjala.automationproject.entities.AddressInfo;
import org.fundacionjala.automationproject.ui.PurchasePage;

/**
 * Created by Franco Aldunate on 11/22/2017.
 */
public class BillingAddressSteps {
  private final PurchasePage purchasePage;
  private final AddressInfo addressInfo;

  /**
   * <p>This constructor gets page transporter instance
   * and receives an entity and page type classes.</p>
   *
   * @param addressInfo is an entity class.
   * @param purchasePage is a page type class.
   */
  public BillingAddressSteps(AddressInfo addressInfo, PurchasePage purchasePage) {
    this.addressInfo = addressInfo;
    this.purchasePage = purchasePage;
  }

  /**
   * <p>This method fills the billing address information.</p>
   *
   * @param address  is the given billing address.
   * @param aCity    is the given billing address city.
   * @param aState   is the given billing address state.
   * @param aZip     is the given billing address postal code.
   * @param aCountry is the given billing address country.
   */
  @When("^I fill billing address info with address \"([^\"]*)\", "
    + "city \"([^\"]*)\", state \"([^\"]*)\", postal code \"([^\"]*)\""
    + " and country \"([^\"]*)\"$")
  public void iFillBillingAddressInfoWithAddressCityStatePostalCodeAndCountry(String address,
                                                                              String aCity,
                                                                              String aState,
                                                                              String aZip,
                                                                              String aCountry) {
    purchasePage.clearBillingAddressFormFields();
    addressInfo.addField(ADDRESS, address);
    addressInfo.addField(CITY, aCity);
    addressInfo.addField(STATE, aState);
    addressInfo.addField(ZIP, aZip);
    addressInfo.addField(COUNTRY, aCountry);
    purchasePage.setBillingAddressInfo(address, aCity, aState, aZip, aCountry);
  }
}
