package org.fundacionjala.automationproject.ui;

import org.fundacionjala.automationproject.entities.Address;
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
  private Select meal;

  @FindBy(name = "creditCard")
  private WebElement creditCardType;
  private Select ccType;

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
  private Select bCountry;

  @FindBy(name = "delAddress1")
  private WebElement deliveryAddress;

  @FindBy(name = "delCity")
  private WebElement deliveryCity;

  @FindBy(name = "delState")
  private WebElement deliveryState;

  @FindBy(name = "delZip")
  private WebElement deliveryPostalCode;

  @FindBy(name = "delCountry")
  private WebElement deliveryCountry;
  private Select dCountry;

  @FindBy(name = "buyFlights")
  private WebElement buyFlightOption;

  /**
   * <p>This method clears passengers form fields.</p>
   */
  public void clearPassengersFormFields() {
    passengerName.clear();
    passengerLastName.clear();
  }

  /**
   * <p>This method fills the passenger's information.</p>
   *
   * @param name      is the passenger name.
   * @param lastName  is the passenger last name.
   * @param mealInput is the passenger meal preference.
   */
  public void setPassengerInfo(String name, String lastName, String mealInput) {
    passengerName.sendKeys(name);
    passengerLastName.sendKeys(lastName);
    meal = new Select(passengerMeal);
    meal.selectByVisibleText(mealInput);
  }

  /**
   * <p>This method clears credit card form fields.</p>
   */
  public void clearCreditCardFormFields() {
    creditCardNumber.clear();
    ccFirstName.clear();
    ccMiddletName.clear();
    ccLastName.clear();
  }

  /**
   * <p>This method fills the credit card information.</p>
   *
   * @param cardType   is the credit card type.
   * @param cardNumber is the credit card number.
   * @param fName      is the credit card owner name.
   * @param mName      is the credit card owner middle name.
   * @param lName      is the credit card owner last name.
   */
  public void setCreditCardInfo(String cardType, String cardNumber, String fName, String mName, String lName) {
    ccType = new Select(creditCardType);
    ccType.selectByVisibleText(cardType);
    creditCardNumber.sendKeys(cardNumber);
    ccFirstName.sendKeys(fName);
    ccMiddletName.sendKeys(mName);
    ccLastName.sendKeys(lName);
  }

  /**
   * <p>This method clears billing address form fields.</p>
   */
  public void clearBillingAddressFormFields() {
    billingAddress.clear();
    billingCity.clear();
    billingState.clear();
    billingPostalCode.clear();
  }

  /**
   * <p>This method fills the billing address information.</p>
   *
   * @param address is an Address entity object type.
   */
  public void setBillingAddressInfo(Address address) {
    billingAddress.sendKeys(address.getAddress());
    billingCity.sendKeys(address.getCity());
    billingState.sendKeys(address.getState());
    billingPostalCode.sendKeys(address.getZip());
    bCountry = new Select(billingCountry);
    bCountry.selectByVisibleText(address.getCountry());
  }

  /**
   * <p>This method clears delivery address form fields.</p>
   */
  public void clearDeliveryAddressFormFields() {
    deliveryAddress.clear();
    deliveryCity.clear();
    deliveryState.clear();
    deliveryPostalCode.clear();
  }

  /**
   * <p>This method sets the delivery address information.</p>
   *
   * @param address is an Address entity object type.
   */
  public void setDeliveryAddressInfo(Address address) {
    deliveryAddress.sendKeys(address.getAddress());
    deliveryCity.sendKeys(address.getCity());
    deliveryState.sendKeys(address.getState());
    deliveryPostalCode.sendKeys(address.getZip());
    dCountry = new Select(deliveryCountry);
    dCountry.selectByVisibleText(address.getCountry());
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
