package org.fundacionjala.automationproject.steps;

import static org.junit.Assert.assertTrue;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.fundacionjala.automationproject.config.EnvironmentConfig;
import org.fundacionjala.automationproject.ui.HomePage;
import org.fundacionjala.automationproject.ui.MainPage;
import org.fundacionjala.automationproject.ui.PageTransporter;
import org.fundacionjala.automationproject.ui.ReservationPage;

/**
 * Created by Franco Aldunate on 11/15/2017.
 */
public class SearchFlightSteps {
  private final PageTransporter pageTransporter;
  private MainPage mainPage;
  private HomePage homePage;
  private ReservationPage reservationPage;

  /**
   * <p>This constructor gets page transporter instance.</p>
   */
  public SearchFlightSteps() {
    pageTransporter = PageTransporter.getInstance();
  }

  /**
   * <p>This step performs a setup user account login.</p>
   */
  @Given("^I am logged in the application$")
  public void iLogInToTheApplication() {
    mainPage = pageTransporter.navigateToMainPage();
    final String userName = EnvironmentConfig.getInstance().getUserName();
    final String password = EnvironmentConfig.getInstance().getUserPassword();
    homePage = mainPage.loginUser(userName, password);
  }

  /**
   * <p>This step performs searching of flight.</p>
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
  @When("^I search a flight with \"([^\"]*)\", \"([^\"]*)\" passenger, from \"([^\"]*)\", "
    + "on \"([^\"]*)\" \"([^\"]*)\", to \"([^\"]*)\" on \"([^\"]*)\", \"([^\"]*)\" in \"([^\"]*)\" "
    + "class and \"([^\"]*)\"$")
  public void iSearchAFlightWithPassengerFromOnToOnInClassAnd(String flight, String pNumber,
                                                              String oLocation, String dMonth,
                                                              String dDay, String dLocation,
                                                              String rMonth, String rDay,
                                                              String sClass, String airline) {
    reservationPage = homePage.searchFlight(flight, pNumber, oLocation,
      dMonth, dDay, dLocation, rMonth, rDay, sClass, airline);
  }

  /**
   * <p>This step performs checking of flight search result correctness.</p>
   *
   * @param origin      is the given flight origin searched.
   * @param destination is the given flight destination searched.
   */
  @Then("^I should have a result list of \"([^\"]*)\" to \"([^\"]*)\" flights$")
  public void iShouldHaveAResultListOfToFlights(String origin, String destination) {
    assertTrue(reservationPage.isCurrentPage());
    assertTrue(reservationPage.isResultDisplayed(origin, destination));
  }
}
