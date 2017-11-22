package org.fundacionjala.automationproject.steps;

import static org.fundacionjala.automationproject.entities.AddressInfo.ADDRESS;
import static org.fundacionjala.automationproject.entities.AddressInfo.CITY;
import static org.fundacionjala.automationproject.entities.AddressInfo.COUNTRY;
import static org.fundacionjala.automationproject.entities.AddressInfo.STATE;
import static org.fundacionjala.automationproject.entities.AddressInfo.ZIP;
import static org.junit.Assert.assertTrue;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.fundacionjala.automationproject.entities.AddressInfo;
import org.fundacionjala.automationproject.ui.PurchasePage;

/**
 * Created by Franco Aldunate on 11/22/2017.
 */
public class DeliveryAddressSteps {
  private final PurchasePage purchasePage;
  private final AddressInfo addressInfo;

  /**
   * <p>This constructor gets page transporter instance
   * and receives an entity and page type classes.</p>
   *
   * @param addressInfo is an entity class.
   * @param purchasePage is a page type class.
   */
  public DeliveryAddressSteps(AddressInfo addressInfo, PurchasePage purchasePage) {
    this.addressInfo = addressInfo;
    this.purchasePage = purchasePage;
  }

  /**
   * <p>This method fills the delivery address information.</p>
   */
  @When("^I fill delivery address info$")
  public void iFillDeliveryAddressInfo() {
    purchasePage.clearDeliveryAddressFormFields();
    purchasePage.setDeliveryAddressInfo(
      addressInfo.getAddressInfo().get(ADDRESS),
      addressInfo.getAddressInfo().get(CITY),
      addressInfo.getAddressInfo().get(STATE),
      addressInfo.getAddressInfo().get(ZIP),
      addressInfo.getAddressInfo().get(COUNTRY));
  }

  /**
   * <p>This method checks if the delivery address form is filled.</p>
   */
  @Then("^I should see the delivery address form filled$")
  public void iShouldSeeTheDeliveryAddressFormFilled() {
    assertTrue(purchasePage.deliveryAddressFormIsFilled());
  }
}
