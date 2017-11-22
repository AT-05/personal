package org.fundacionjala.automationproject.steps;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.fundacionjala.automationproject.config.EnvironmentConfig;
import org.fundacionjala.automationproject.ui.HomePage;
import org.fundacionjala.automationproject.ui.MainPage;
import org.fundacionjala.automationproject.ui.PageTransporter;
import org.fundacionjala.automationproject.ui.ReservationPage;
import static org.junit.Assert.assertTrue;

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
   * <p>This method logs in to a setup user account.</p>
   */
  @And("^I log in to the application$")
  public void iLogInToTheApplication() {
    mainPage = pageTransporter.navigateToMainPage();

    final String userName = EnvironmentConfig.getInstance().getUserName();
    mainPage.setUserName(userName);

    final String password = EnvironmentConfig.getInstance().getUserPassword();
    mainPage.setPassword(password);
    homePage = mainPage.login();
  }

  /**
   * <p>This method selects type of flight.</p>
   *
   * @param flight is the given type of flight.
   */
  @When("^I select the type of flight as \"([^\"]*)\"$")
  public void iSelectTheTypeOfFlightAs(String flight) {
    homePage.setFlightType(flight);
  }

  /**
   * <p>This method selects number of passengers.</p>
   *
   * @param pNumber is the given number of passengers.
   */
  @And("^I choose flight for \"([^\"]*)\" passengers$")
  public void iChooseFlightForPassengers(String pNumber) {
    homePage.setPassengers(pNumber);
  }

  /**
   * <p>This method selects origin location.</p>
   *
   * @param oLocation is the given origin location.
   */
  @And("^I choose as origin location \"([^\"]*)\"$")
  public void iChooseAsOriginLocation(String oLocation) {
    homePage.setOriginLocation(oLocation);
  }

  /**
   * <p>This method selects departure date.</p>
   *
   * @param dMonth is the given departure month.
   * @param dDay   is the given departure day.
   */
  @And("^I select as departure date \"([^\"]*)\", \"([^\"]*)\"$")
  public void iSelectAsDepartureDate(String dMonth, String dDay) {
    homePage.setDepartureDate(dMonth, dDay);
  }

  /**
   * <p>This method selects destination location.</p>
   *
   * @param dLocation is the given destination location.
   */
  @And("^I select destination as \"([^\"]*)\"$")
  public void iSelectDestinationAs(String dLocation) {
    homePage.setDestinationLocation(dLocation);
  }

  /**
   * <p>This method selects return date.</p>
   *
   * @param rMonth is the given return month.
   * @param rDay   is the given return day.
   */
  @And("^I select as return date \"([^\"]*)\", \"([^\"]*)\"$")
  public void iSelectAsReturnDate(String rMonth, String rDay) {
    homePage.setReturningDate(rMonth, rDay);
  }

  /**
   * <p>This method selects flight service class.</p>
   *
   * @param sClass is the given flight service class.
   */
  @And("^I choose \"([^\"]*)\" as service class$")
  public void iChooseAsServiceClass(String sClass) {
    homePage.setServiceClass(sClass);
  }

  /**
   * <p>This method selects airline.</p>
   *
   * @param airline is the given airline.
   */
  @And("^I select airline \"([^\"]*)\"$")
  public void iSelectAirline(String airline) {
    homePage.setAirline(airline);
    reservationPage = homePage.searchFlight();
  }

  /**
   * <p>This method checks flight search results correctness.</p>
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
