package org.fundacionjala.automationproject.steps;

import cucumber.api.java.en.And;
import java.util.List;
import org.fundacionjala.automationproject.entities.Address;
import org.fundacionjala.automationproject.ui.PurchasePage;

/**
 * Created by Franco Aldunate on 11/22/2017.
 */
public class BillingAddressSteps {
  private final PurchasePage purchasePage;
  private final Address address;

  /**
   * <p>This constructor gets page transporter instance
   * and receives an entity and page type classes.</p>
   *
   * @param address      is an Address entity object type.
   * @param purchasePage is a page type class.
   */
  public BillingAddressSteps(Address address, PurchasePage purchasePage) {
    this.address = address;
    this.purchasePage = purchasePage;
  }

  /**
   * <p>This step performs filling of the billing address information.</p>
   *
   * @param addressList is a list of Address entity object type.
   */
  @And("^I fill billing address with the following information$")
  public void iFillBillingAddressWithTheFollowingInformation(List<Address> addressList) {
    address.setData(addressList);
    purchasePage.clearBillingAddressFormFields();
    purchasePage.setBillingAddressInfo(address);
  }
}
