package org.fundacionjala.automationproject.steps;

import static org.junit.Assert.assertTrue;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.fundacionjala.automationproject.ui.FlightTicketPage;
import org.fundacionjala.automationproject.ui.PurchasePage;
import org.fundacionjala.automationproject.ui.ReservationPage;

/**
 * Created by Franco Aldunate on 11/15/2017.
 */
public class FlightReservationSteps {
  private ReservationPage reservationPage;
  private PurchasePage purchasePage;
  private FlightTicketPage flightTicketPage;

  /**
   * <p>This step performs selection of departure and return flights.</p>
   *
   * @param depFlight is the departure flight selection given.
   * @param retFlight is the return flight selection given.
   */
  @When("^I select departure and return flight as \"([^\"]*)\", \"([^\"]*)\"$")
  public void iSelectDepartureAndReturnFlightAs(String depFlight, String retFlight) {
    reservationPage = new ReservationPage();
    final int departureFlight = Integer.parseInt(depFlight);
    final int returnFlight = Integer.parseInt(retFlight);
    purchasePage = reservationPage.reserveFlight(departureFlight, returnFlight);
  }

  /**
   * <p>This step performs filling of the passenger's information.</p>
   *
   * @param name  is the given passenger's name.
   * @param lName is the given passenger's last name.
   * @param meal  is the given passenger's meal preference.
   */
  @And("^I fill the passengers' information with name \"([^\"]*)\", last name \"([^\"]*)\", and meal \"([^\"]*)\"$")
  public void iFillThePassengersInformationWithNameLastNameAndMeal(String name, String lName, String meal) {
    purchasePage.clearPassengersFormFields();
    purchasePage.setPassengerInfo(name, lName, meal);
  }

  /**
   * <p>This step performs filling of the credit card information.</p>
   *
   * @param ccType   is the given credit card type.
   * @param ccNumber is the given credit card number.
   * @param ccOName  is the given credit card owner name.
   * @param ccOMName is the given credit card owner middle name.
   * @param ccOLName is the given credit card owner last name.
   */
  @And("^I fill the credit card info with type \"([^\"]*)\","
    + " number \"([^\"]*)\", first name \"([^\"]*)\", middle name \"([^\"]*)\" "
    + "and last name \"([^\"]*)\"$")
  public void iFillTheCreditCardInfoWithTypeNumberFirstNameMiddleNameAndLastName(String ccType,
                                                                                 String ccNumber,
                                                                                 String ccOName,
                                                                                 String ccOMName,
                                                                                 String ccOLName) {
    purchasePage.clearCreditCardFormFields();
    purchasePage.setCreditCardInfo(ccType, ccNumber, ccOName, ccOMName, ccOLName);
  }

  /**
   * <p>This step performs checking of billing information total price compliance.</p>
   *
   * @param totalPrice is the purchase total price.
   */
  @Then("^I should have a flight confirmation document with total price \"([^\"]*)\"$")
  public void iShouldHaveAFlightConfirmationDocumentWithTotalPrice(String totalPrice) {
    flightTicketPage = purchasePage.buyFlight();
    assertTrue(flightTicketPage.verifyBillInfo(totalPrice));
  }
}
