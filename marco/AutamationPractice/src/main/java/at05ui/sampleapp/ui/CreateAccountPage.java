package at05ui.sampleapp.ui;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

/**
 * Created by Marco Mendez November 2017.
 */
public class CreateAccountPage extends BasedPageObject {


  public static final String TITLE_PAGE = "Login - My Store";
  @FindBy(id = "id_gender1")
  private WebElement radioButtonTitle;

  @FindBy(id = "customer_firstname")
  private WebElement firstName;

  @FindBy(id = "customer_lastname")
  private WebElement lastName;

  @FindBy(id = "email")
  private WebElement email;

  @FindBy(id = "passwd")
  private WebElement password;

  private Select dropdownDay;

  private Select dropdownMonth;

  private Select dropdownYear;


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

  @FindBy(id = "phone_mobile")
  private WebElement phone;

  @FindBy(id = "submitAccount")
  private WebElement btnRegister;


  /**
   * Constructor of the Class CreateAccountPage.
   */
  CreateAccountPage() {
    super();
  }

  /**
   * Set the Personal information for create a new Account.
   *
   * @param firstName string.
   * @param lastName string.
   * @param email string.
   * @param password string.
   * @param day int.
   * @param month int.
   * @param year string.
   */
  public void setYourPersonalInformation(String firstName, String lastName, String email,
      String password, int day, int month, String year) {
    setRadioButtonTitle();
    setFirstName(firstName);
    setLastName(lastName);
    setEmail(email);
    setPassword(password);
    setDropDownDay(day);
    setDropDownMonth(month);
    setDropDownYear(year);

  }

  /**
   * Event click BtnRegister for register new Account.
   */
  private void clickButtonRegister() {
    btnRegister.click();
  }

  /**
   * Set Address information for create new account.
   *
   * @param firsNameAddress string.
   * @param lastNameAddress string.
   * @param company string.
   * @param address string.
   * @param city string.
   * @param state string.
   * @param postalCode string.
   * @param country string.
   * @param phone string.
   */
  public void setYourAddress(String firsNameAddress, String lastNameAddress, String company,
      String address, String city, int state, String postalCode, String country, String phone) {
    setFirsNameAddress(firsNameAddress);
    setLastNameAddress(lastNameAddress);
    setCompany(company);
    setAddress(address);
    setCity(city);
    setState(state);
    setPostalCode(postalCode);
    setCountry(country);
    setPhone(phone);

  }

  /**
   * Set field phone.
   *
   * @param phone string.
   */
  private void setPhone(String phone) {
    this.phone.sendKeys(phone);
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
   * Set field dropDownYear.
   *
   * @param year string..
   */
  private void setDropDownYear(String year) {
    dropdownYear = new Select(webDriver.findElement(By.id("years")));
    dropdownYear.selectByValue(year);
  }

  /**
   * Set field dropDownMonth.
   *
   * @param month int.
   */
  private void setDropDownMonth(int month) {
    dropdownMonth = new Select(webDriver.findElement(By.id("months")));
    dropdownMonth.selectByIndex(month);
  }

  /**
   * Set field dropDownDay.
   *
   * @param day int.
   */
  private void setDropDownDay(int day) {
    dropdownDay = new Select(webDriver.findElement(By.id("days")));
    dropdownDay.selectByIndex(day);
  }

  /**
   * Set the fieldPassword.
   *
   * @param password string.
   */
  private void setPassword(String password) {

    this.password.sendKeys(password);
  }

  /**
   * Set the field Email.
   *
   * @param email string.
   */
  private void setEmail(String email) {
    this.email.clear();
    this.email.sendKeys(email);
  }

  /**
   * Set the field LastName.
   *
   * @param lastName string.
   */
  private void setLastName(String lastName) {
    this.lastName.sendKeys(lastName);
  }

  /**
   * Set the field FirstName.
   *
   * @param firstName string.
   */
  private void setFirstName(String firstName) {

    this.firstName.sendKeys(firstName);
  }

  /**
   * Set the radioButton Title.
   */
  private void setRadioButtonTitle() {
    radioButtonTitle.click();
  }


  @Override
  public void waitPageIsLoaded() throws WebDriverException {

  }

  /**
   * Check if I am int he this page.
   *
   * @return boolean.
   */
  public boolean IAmCreateAccountPage() {
    //this a small trap
    return webDriver.getTitle().equalsIgnoreCase(TITLE_PAGE);
  }

  /**
   * Event click of BtnRegister.
   *
   * @return MyAccountPage.
   */
  public MyAccountPage clickRegister() {
    clickButtonRegister();
    return new MyAccountPage();
  }
}
