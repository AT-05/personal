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

  @FindBy(name = "fromPort")
  private WebElement origin;

  @FindBy(name = "fromMonth")
  private WebElement departureMonth;

  @FindBy(name = "fromDay")
  private WebElement departureDay;

  @FindBy(name = "toPort")
  private WebElement destination;

  @FindBy(name = "toMonth")
  private WebElement returningMonth;

  @FindBy(name = "toDay")
  private WebElement returningDay;

  @FindBy(name = "servClass")
  private List<WebElement> serviceClassList;

  @FindBy(name = "airline")
  private WebElement airline;

  @FindBy(name = "findFlights")
  private WebElement findFlight;

  /**
   * <p>This method checks if the user was redirected to the home page.</p>
   *
   * @return whether the title is equal to the text given or not.
   */
  public boolean isLogged() {
    String title = driver.getTitle();
    return title.equalsIgnoreCase("Find a Flight: Mercury Tours:");
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
  public void setFlightType(String keyWord) {
    selectElementInList(tripTypeList, keyWord);
  }

  /**
   * <p>This method sets number of passengers.</p>
   *
   * @param value is the number of passengers to set.
   */
  public void setPassengers(String value) {
    passCount.click();
    Select passenger = new Select(passCount);
    passenger.selectByValue(value);
  }

  /**
   * <p>This method sets origin location.</p>
   *
   * @param location is the origin location.
   */
  public void setOriginLocation(String location) {
    origin.click();
    Select originLocation = new Select(origin);
    originLocation.selectByValue(location);
  }

  /**
   * <p>This method sets departure date.</p>
   *
   * @param monthInput is the departure month.
   * @param dayInput   is the departure day.
   */
  public void setDepartureDate(String monthInput, String dayInput) {
    departureMonth.click();
    Select month = new Select(departureMonth);
    month.selectByVisibleText(monthInput);

    departureDay.click();
    Select day = new Select(departureDay);
    day.selectByVisibleText(dayInput);
  }

  /**
   * <p>This method sets destination location.</p>
   *
   * @param location is the destination location.
   */
  public void setDestinationLocation(String location) {
    destination.click();
    Select destinationLocation = new Select(destination);
    destinationLocation.selectByValue(location);
  }

  /**
   * <p>This method sets returning date.</p>
   *
   * @param monthInput is the returning month.
   * @param dayInput is the returning day.
   */
  public void setReturningDate(String monthInput, String dayInput) {
    returningMonth.click();
    Select month = new Select(returningMonth);
    month.selectByVisibleText(monthInput);

    returningDay.click();
    Select day = new Select(returningDay);
    day.selectByVisibleText(dayInput);
  }

  /**
   * <p>This method sets flight service class.</p>
   *
   * @param keyWord is the value to set as service class.
   */
  public void setServiceClass(String keyWord) {
    selectElementInList(serviceClassList, keyWord);
  }

  /**
   * <p>This method sets airline.</p>
   *
   * @param airlineInput is the airline.
   */
  public void setAirline(String airlineInput) {
    airline.click();
    Select airlineValue = new Select(airline);
    airlineValue.selectByVisibleText(airlineInput);
  }

  /**
   * <p>This method sends to the Reservation Page.</p>
   *
   * @return a ReservationPage object type.
   */
  public ReservationPage searchFlight() {
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
