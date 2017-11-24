package org.fundacionjala.automationproject.steps;

import cucumber.api.java.en.When;
import org.fundacionjala.automationproject.entities.Address;
import org.fundacionjala.automationproject.ui.PurchasePage;

/**
 * Created by Franco Aldunate on 11/22/2017.
 */
public class DeliveryAddressSteps {
  private final PurchasePage purchasePage;
  private final Address address;

  /**
   * <p>This constructor gets page transporter instance
   * and receives an entity and page type classes.</p>
   *
   * @param address      is an Address entity object type.
   * @param purchasePage is a page type class.
   */
  public DeliveryAddressSteps(Address address, PurchasePage purchasePage) {
    this.address = address;
    this.purchasePage = purchasePage;
  }

  /**
   * <p>This step performs filling of the delivery address information.</p>
   */
  @When("^I fill delivery address info$")
  public void iFillDeliveryAddressInfo() {
    purchasePage.clearDeliveryAddressFormFields();
    purchasePage.setDeliveryAddressInfo(address);
  }
}
