package org.fundacionjala.automationproject.ui;

import java.util.List;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

/**
 * Created by Franco Aldunate on 11/15/2017.
 */
public class HomePage extends BasePage {
  @FindBy(linkText = "SIGN-OFF")
  private WebElement logOut;

  @FindBy(name = "tripType")
  private List<WebElement> tripTypeList;

  @FindBy(name = "passCount")
  private WebElement passCount;
  private Select passenger;

  @FindBy(name = "fromPort")
  private WebElement origin;
  private Select originLocation;

  @FindBy(name = "fromMonth")
  private WebElement departureMonth;
  private Select depMonth;

  @FindBy(name = "fromDay")
  private WebElement departureDay;
  private Select depDay;

  @FindBy(name = "toPort")
  private WebElement destination;
  private Select destinationLocation;

  @FindBy(name = "toMonth")
  private WebElement returningMonth;
  private Select retMonth;

  @FindBy(name = "toDay")
  private WebElement returningDay;
  private Select retDay;

  @FindBy(name = "servClass")
  private List<WebElement> serviceClassList;

  @FindBy(name = "airline")
  private WebElement airline;
  private Select airlineValue;

  @FindBy(name = "findFlights")
  private WebElement findFlight;

  /**
   * <p>This method checks if the user was redirected to the home page
   * after login.</p>
   *
   * @return whether the title is equal to the text given or not.
   */
  public boolean userIsLoggedIn() {
    final String title = driver.getTitle();
    final String titleMessage = "Find a Flight: Mercury Tours:";
    return title.equalsIgnoreCase(titleMessage);
  }

  /**
   * <p>This method logs out user from session.</p>
   *
   * @return is a MainPage object type.
   */
  public MainPage logOut() {
    logOut.click();
    return new MainPage();
  }

  /**
   * <p>This method sets flight type.</p>
   *
   * @param keyWord is the value to set as flight type.
   */
  private void setFlightType(String keyWord) {
    selectElementInList(tripTypeList, keyWord);
  }

  /**
   * <p>This method sets number of passengers.</p>
   *
   * @param value is the number of passengers to set.
   */
  private void setPassengers(String value) {
    passenger = new Select(passCount);
    passenger.selectByValue(value);
  }

  /**
   * <p>This method sets origin location.</p>
   *
   * @param location is the origin location.
   */
  private void setOriginLocation(String location) {
    originLocation = new Select(origin);
    originLocation.selectByValue(location);
  }

  /**
   * <p>This method sets departure date.</p>
   *
   * @param monthInput is the departure month.
   * @param dayInput   is the departure day.
   */
  private void setDepartureDate(String monthInput, String dayInput) {
    depMonth = new Select(departureMonth);
    depMonth.selectByVisibleText(monthInput);
    depDay = new Select(departureDay);
    depDay.selectByVisibleText(dayInput);
  }

  /**
   * <p>This method sets destination location.</p>
   *
   * @param location is the destination location.
   */
  private void setDestinationLocation(String location) {
    destinationLocation = new Select(destination);
    destinationLocation.selectByValue(location);
  }

  /**
   * <p>This method sets returning date.</p>
   *
   * @param monthInput is the returning month.
   * @param dayInput   is the returning day.
   */
  private void setReturningDate(String monthInput, String dayInput) {
    retMonth = new Select(returningMonth);
    retMonth.selectByVisibleText(monthInput);
    retDay = new Select(returningDay);
    retDay.selectByVisibleText(dayInput);
  }

  /**
   * <p>This method sets flight service class.</p>
   *
   * @param keyWord is the value to set as service class.
   */
  private void setServiceClass(String keyWord) {
    selectElementInList(serviceClassList, keyWord);
  }

  /**
   * <p>This method sets airline.</p>
   *
   * @param airlineInput is the airline.
   */
  private void setAirline(String airlineInput) {
    airlineValue = new Select(airline);
    airlineValue.selectByVisibleText(airlineInput);
  }

  /**
   * <p>This method performs the searching of flight.</p>
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
   * @return a ReservationPage object type.
   */
  public ReservationPage searchFlight(String flight, String pNumber,
                                      String oLocation, String dMonth,
                                      String dDay, String dLocation,
                                      String rMonth, String rDay,
                                      String sClass, String airline) {
    setFlightType(flight);
    setPassengers(pNumber);
    setOriginLocation(oLocation);
    setDepartureDate(dMonth, dDay);
    setDestinationLocation(dLocation);
    setReturningDate(rMonth, rDay);
    setServiceClass(sClass);
    setAirline(airline);
    findFlight.click();
    return new ReservationPage();
  }

  /**
   * <p>This method checks for correct loading of pages.</p>
   *
   * @throws WebDriverException when pages doesn't load correctly.
   */
  @Override
  public void waitUntilPageObjectIsLoaded() throws WebDriverException {

  }
}
