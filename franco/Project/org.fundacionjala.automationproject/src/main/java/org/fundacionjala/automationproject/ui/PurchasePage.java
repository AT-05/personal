package org.fundacionjala.automationproject.ui;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

/**
 * Created by Franco Aldunate on 11/20/2017.
 */
public class PurchasePage extends BasePage {
  @FindBy(name = "passFirst0")
  private WebElement passengerName;

  @FindBy(name = "passLast0")
  private WebElement passengerLastName;

  @FindBy(name = "pass.0.meal")
  private WebElement passengerMeal;

  @FindBy(name = "creditCard")
  private WebElement creditCardType;

  @FindBy(name = "creditnumber")
  private WebElement creditCardNumber;

  @FindBy(name = "cc_frst_name")
  private WebElement ccFirstName;

  @FindBy(name = "cc_mid_name")
  private WebElement ccMiddletName;

  @FindBy(name = "cc_last_name")
  private WebElement ccLastName;

  @FindBy(name = "billAddress1")
  private WebElement billingAddress;

  @FindBy(name = "billCity")
  private WebElement billingCity;

  @FindBy(name = "billState")
  private WebElement billingState;

  @FindBy(name = "billZip")
  private WebElement billingPostalCode;

  @FindBy(name = "billCountry")
  private WebElement billingCountry;

  @FindBy(xpath = "/html/body/div/table/tbody/tr/td[2]"
    + "/table/tbody/tr[4]/td/table/tbody/tr/td[2]/table/tbody/tr[5]"
    + "/td/form/table/tbody/tr[13]/td[2]/input")
  private WebElement deliveryAddressOption;

  @FindBy(name = "buyFlights")
  private WebElement buyFlightOption;

  /**
   * <p>This method fills the passenger's information.</p>
   *
   * @param name is the passenger name.
   * @param lastName is the passenger last name.
   * @param mealInput is the passenger meal preference.
   */
  public void setPassengerInfo(String name, String lastName, String mealInput) {
    passengerName.sendKeys(name);
    passengerLastName.sendKeys(lastName);
    passengerMeal.click();
    Select meal = new Select(passengerMeal);
    meal.selectByVisibleText(mealInput);
  }

  /**
   * <p>This method fills the credit card information.</p>
   *
   * @param cardType is the credit card type.
   * @param cardNumber is the credit card number.
   * @param fName is the credit card owner name.
   * @param mName is the credit card owner middle name.
   * @param lName is the credit card owner last name.
   */
  public void setCreditCardInfo(String cardType, String cardNumber, String fName, String mName, String lName) {
    creditCardType.click();
    Select day = new Select(creditCardType);
    day.selectByVisibleText(cardType);
    creditCardNumber.sendKeys(cardNumber);
    ccFirstName.sendKeys(fName);
    ccMiddletName.sendKeys(mName);
    ccLastName.sendKeys(lName);
  }

  /**
   * <p>This method fills the billing address information.</p>
   *
   * @param bAddress is the billing address.
   * @param bCity is the billing address city.
   * @param bState is the billing address state.
   * @param bPostalCode is the billing address zip.
   * @param bCountry is the billing address country.
   */
  public void setBillingAddressInfo(String bAddress, String bCity, String bState, String bPostalCode, String bCountry) {
    billingAddress.sendKeys(bAddress);
    billingCity.sendKeys(bCity);
    billingState.sendKeys(bState);
    billingPostalCode.sendKeys(bPostalCode);
    billingCountry.click();
    Select country = new Select(billingCountry);
    country.selectByVisibleText(bCountry);
  }

  /**
   * <p>This method sets the delivery address information.</p>
   */
  public void setDeliveryAddressInfo() {
    deliveryAddressOption.sendKeys(Keys.SPACE);
  }

  /**
   * <p>This method sends to Flight Ticket page.</p>
   *
   * @return a FlightTicketPage object type.
   */
  public FlightTicketPage buyFlight() {
    buyFlightOption.click();
    return new FlightTicketPage();
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
