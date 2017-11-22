package org.fundacionjala.automationproject.steps;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.fundacionjala.automationproject.ui.FlightTicketPage;
import org.fundacionjala.automationproject.ui.HomePage;
import org.fundacionjala.automationproject.ui.PageTransporter;
import org.fundacionjala.automationproject.ui.PurchasePage;
import org.fundacionjala.automationproject.ui.ReservationPage;
import static org.junit.Assert.assertTrue;

/**
 * Created by Franco Aldunate on 11/15/2017.
 */
public class FlightReservationSteps {
  private PageTransporter pageTransporter;
  private HomePage homePage;
  private ReservationPage reservationPage;
  private PurchasePage purchasePage;
  private FlightTicketPage flightTicketPage;

  /**
   * <p>This constructor gets page transporter instance.</p>
   */
  public FlightReservationSteps() {
    pageTransporter = PageTransporter.getInstance();
  }

  /**
   * <p>This method performs searching of flight.</p>
   *
   * @param flight    is the given type of flight.
   * @param pNumber   is the given number of passengers.
   * @param oLocation is the given origin location.
   * @param dMonth    is the given departure Month.
   * @param dDay      is the given departure Day.
   * @param dLocation is the given destination location.
   * @param rMonth    is the given return Month.
   * @param rDay      is the given return Day.
   * @param sClass    is the given flight service class.
   * @param airline   is the given airline.
   */
  @And("^I search a flight as \"([^\"]*)\", \"([^\"]*)\" passenger, "
    + "from \"([^\"]*)\", on \"([^\"]*)\" \"([^\"]*)\", to \"([^\"]*)\" "
    + "on \"([^\"]*)\", \"([^\"]*)\" in \"([^\"]*)\" class and \"([^\"]*)\"$")
  public void iSearchAFlightAsPassengerFromOnToOnInClassAnd(String flight,
                                                            String pNumber,
                                                            String oLocation,
                                                            String dMonth,
                                                            String dDay,
                                                            String dLocation,
                                                            String rMonth,
                                                            String rDay,
                                                            String sClass,
                                                            String airline) {
    homePage = pageTransporter.getHomePage();
    homePage.setFlightType(flight);
    homePage.setPassengers(pNumber);
    homePage.setOriginLocation(oLocation);
    homePage.setDepartureDate(dMonth, dDay);
    homePage.setDestinationLocation(dLocation);
    homePage.setReturningDate(rMonth, rDay);
    homePage.setServiceClass(sClass);
    homePage.setAirline(airline);
    reservationPage = homePage.searchFlight();
  }

  /**
   * <p>This method selects departure flight.</p>
   *
   * @param dFlight is the given departure flight.
   */
  @When("^I select \"([^\"]*)\" as departure flight$")
  public void iSelectAsDepartureFlight(String dFlight) {
    final int departureFlight = Integer.parseInt(dFlight);
    reservationPage.setDepartureFlight(departureFlight);
  }

  /**
   * <p>This method selects return flight.</p>
   *
   * @param rFlight is the given return flight.
   */
  @And("^I select \"([^\"]*)\" as return flight$")
  public void iSelectAsReturnFlight(String rFlight) {
    final int returnFlight = Integer.parseInt(rFlight);
    reservationPage.setReturnFlight(returnFlight);
  }

  /**
   * <p>This method fills the passenger's information.</p>
   *
   * @param name  is the given passenger's name.
   * @param lName is the given passenger's last name.
   * @param meal  is the given passenger's meal preference.
   */
  @And("^I fill the passengers' information with name \"([^\"]*)\", last name \"([^\"]*)\", and meal \"([^\"]*)\"$")
  public void iFillThePassengersInformationWithNameLastNameAndMeal(String name, String lName, String meal) {
    purchasePage = reservationPage.reserveFlight();
    purchasePage.clearPassengersFormFields();
    purchasePage.setPassengerInfo(name, lName, meal);
  }

  /**
   * <p>This method fills the credit card information.</p>
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
    purchasePage.setCreditCardInfo(ccType, ccNumber, ccOName, ccOMName, ccOLName);
  }

  /**
   * <p>This method checks billing information total price.</p>
   *
   * @param totalPrice is the purchase total price.
   */
  @Then("^I should have a flight confirmation document with total price \"([^\"]*)\"$")
  public void iShouldHaveAFlightConfirmationDocumentWithTotalPrice(String totalPrice) {
    flightTicketPage = purchasePage.buyFlight();
    assertTrue(flightTicketPage.verifyBillInfo(totalPrice));
  }
}
