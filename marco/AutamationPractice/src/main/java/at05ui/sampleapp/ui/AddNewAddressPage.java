package at05ui.sampleapp.ui;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

/**
 * Created by Marco Mendez November 2017.
 */
public class AddNewAddressPage extends BasedPageObject {


  @FindBy(id = "firstname")
  private WebElement firsNameAddress;

  @FindBy(id = "lastname")
  private WebElement lastNameAddress;

  @FindBy(id = "company")
  private WebElement company;

  @FindBy(id = "address1")
  private WebElement address;

  @FindBy(id = "city")
  private WebElement city;

  private Select state;

  @FindBy(id = "postcode")
  private WebElement postalCode;

  private Select country;

  @FindBy(id = "phone")
  private WebElement phoneHome;

  @FindBy(id = "phone_mobile")
  private WebElement phoneMobile;

  @FindBy(id = "alias")
  private WebElement alias;

  @FindBy(id = "submitAddress")
  private WebElement btnSave;

  /**
   * Event click for Save date.
   *
   * @return new MyAddressPage.
   */
  public MyAddressPage clickBtnSave() {
    btnSave.click();
    return new MyAddressPage();
  }

  /**
   * Set the field Alias.
   *
   * @param alias string.
   */
  private void setAlias(String alias) {
    this.alias.clear();
    this.alias.sendKeys(alias);
  }

  /**
   * Set field phone.
   *
   * @param phoneHome string.
   */
  private void setPhoneHome(String phoneHome) {
    this.phoneHome.clear();
    this.phoneHome.sendKeys(phoneHome);
  }

  /**
   * Set field phone.
   *
   * @param phoneMobile string.
   */
  private void setPhoneMobile(String phoneMobile) {
    this.phoneMobile.clear();
    this.phoneMobile.sendKeys(phoneMobile);
  }


  /**
   * Set the field country.
   *
   * @param country string.
   */
  private void setCountry(String country) {
    this.country = new Select(webDriver.findElement(By.id("id_country")));
    this.country.selectByValue(country);
  }

  /**
   * Set field PostalCode.
   *
   * @param postalCode string.
   */
  private void setPostalCode(String postalCode) {
    this.postalCode.clear();
    this.postalCode.sendKeys(postalCode);
  }

  /**
   * Set field State.
   *
   * @param state string.
   */
  private void setState(int state) {
    this.state = new Select(webDriver.findElement(By.id("id_state")));
    this.state.selectByIndex(state);
  }

  /**
   * Set field City.
   *
   * @param city string.
   */
  private void setCity(String city) {
    this.city.sendKeys(city);
  }

  /**
   * Set field Address.
   *
   * @param address string.
   */
  private void setAddress(String address) {
    this.address.clear();
    this.address.sendKeys(address);
  }

  /**
   * Set field Company
   */
  private void setCompany(String company) {
    this.company.sendKeys(company);
  }

  /**
   * Set field lastNameAddress.
   *
   * @param lastNameAddress string.
   */
  private void setLastNameAddress(String lastNameAddress) {
    this.lastNameAddress.clear();
    this.lastNameAddress.sendKeys(lastNameAddress);
  }

  /**
   * Set field firstNameAddress.
   *
   * @param firsNameAddress string.
   */
  private void setFirsNameAddress(String firsNameAddress) {
    this.firsNameAddress.clear();
    this.firsNameAddress.sendKeys(firsNameAddress);
  }

  /**
   * Set the info for new Address.
   *
   * @param firstName firsName.
   * @param lastName lastName.
   * @param company company.
   * @param address address.
   * @param city city.
   * @param state state.
   * @param postal postal code.
   * @param country country.
   * @param phoneHome string phone home.
   * @param phoneMobile string phone mobile.
   * @param alias string alias.
   */
  public void setNewAddress(String firstName, String lastName, String company, String address,
      String city, int state, String postal, String country, String phoneHome, String phoneMobile,
      String alias) {
    setFirsNameAddress(firstName);
    setLastNameAddress(lastName);
    setCompany(company);
    setAddress(address);
    setCity(city);
    setState(state);
    setPostalCode(postal);
    setCountry(country);
    setPhoneHome(phoneHome);
    setPhoneMobile(phoneMobile);
    setAlias(alias);

  }


  @Override
  public void waitPageIsLoaded() throws WebDriverException {

  }


}
