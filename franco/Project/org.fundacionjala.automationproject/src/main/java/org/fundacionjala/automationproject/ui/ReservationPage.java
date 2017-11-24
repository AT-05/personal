package org.fundacionjala.automationproject.ui;

import java.util.List;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * Created by Franco Aldunate on 11/20/2017.
 */
public class ReservationPage extends BasePage {
  @FindBy(xpath = "/html/body/div/table/tbody/tr/td[2]"
    + "/table/tbody/tr[4]/td/table/tbody/tr/td[2]"
    + "/table/tbody/tr[5]/td/form/table[1]/tbody/tr[1]"
    + "/td/table/tbody/tr[2]/td[1]")
  private WebElement searchResult;

  @FindBy(name = "inFlight")
  private List<WebElement> departureFlightList;

  @FindBy(name = "outFlight")
  private List<WebElement> returnFlightList;

  @FindBy(name = "reserveFlights")
  private WebElement reserveFlight;

  /**
   * <p>This method checks if web driver is in this page.</p>
   *
   * @return whether the web driver is in this page or not.
   */
  public boolean isCurrentPage() {
    final String title = driver.getTitle();
    return title.equalsIgnoreCase("Select a Flight: Mercury Tours");
  }

  /**
   * <p>This method checks if the result of flight
   * search is correct.</p>
   *
   * @param origin      is the flight origin.
   * @param destination is the flight destination.
   * @return whether the result matches its origin and destination.
   */
  public boolean isResultDisplayed(String origin, String destination) {
    final String sentenceToCompare = searchResult.getText();
    return sentenceToCompare.equalsIgnoreCase(origin + " to " + destination);
  }

  /**
   * <p>This method sets the departure flight.</p>
   *
   * @param index is the position of the element.
   */
  private void setDepartureFlight(int index) {
    selectElementInList(departureFlightList, index);
  }

  /**
   * <p>This method sets the return flight.</p>
   *
   * @param index is the position of the element.
   */
  private void setReturnFlight(int index) {
    selectElementInList(returnFlightList, index);
  }

  /**
   * <p>This method performs reservation of flight.</p>
   *
   * @param departureFlight is the departure flight selection given.
   * @param returnFlight    is the return flight selection given.
   * @return a PurchasePage object type.
   */
  public PurchasePage reserveFlight(int departureFlight, int returnFlight) {
    setDepartureFlight(departureFlight);
    setReturnFlight(returnFlight);
    reserveFlight.click();
    return new PurchasePage();
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
