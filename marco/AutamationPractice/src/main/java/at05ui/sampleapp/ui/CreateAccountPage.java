package at05ui.sampleapp.ui;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class CreateAccountPage extends BasedPageObject {


  @FindBy(id = "id_gender1")
  WebElement radioButtonTitle;

  //Your personal information
  @FindBy(id = "customer_firstname")
  WebElement firstName;

  @FindBy(id = "customer_lastname")
  WebElement lastName;

  @FindBy(id = "email")
  WebElement email;

  @FindBy(id = "passwd")
  WebElement password;


  Select dropdownDay;

  // @FindBy(id = "months")
  Select dropdownMonth;

  //  @FindBy(id = "years")
  Select dropdownYear;
  // Your Address

  @FindBy(id = "firstname")
  WebElement firsNameAddress;

  @FindBy(id = "lastname")
  WebElement lastNameAddress;

  @FindBy(id = "company")
  WebElement company;

  @FindBy(id = "address1")
  WebElement address;

  @FindBy(id = "city")
  WebElement city;

  //@FindBy(id = "id_state")
  Select state;

  @FindBy(id = "postcode")
  WebElement postalCode;

  //@FindBy(id = "id_country")
  Select country;

  @FindBy(id = "phone_mobile")
  WebElement phone;

  @FindBy(id = "submitAccount")
  WebElement btnRegister;


  public CreateAccountPage() {
    super();
  }


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

  private void clickButtonRegister() {
    btnRegister.click();
  }

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
  //  clickButtonRegister();

  }

  private void setPhone(String phone) {
    this.phone.sendKeys(phone);
  }

  private void setCountry(String country) {
    this.country = new Select(webDriver.findElement(By.id("id_country")));
    this.country.selectByValue(country);
  }

  private void setPostalCode(String postalCode) {
    this.postalCode.sendKeys(postalCode);
  }

  private void setState(int state) {
    this.state = new Select(webDriver.findElement(By.id("id_state")));
    this.state.selectByIndex(state);
  }

  private void setCity(String city) {
    this.city.sendKeys(city);
  }

  private void setAddress(String address) {
    this.address.sendKeys(address);
  }

  private void setCompany(String company) {
    this.company.sendKeys(company);
  }

  private void setLastNameAddress(String lastNameAddress) {
    this.lastNameAddress.clear();
    this.lastNameAddress.sendKeys(lastNameAddress);
  }

  private void setFirsNameAddress(String firsNameAddress) {
    this.firsNameAddress.clear();
    this.firsNameAddress.sendKeys(firsNameAddress);
  }


  private void setDropDownYear(String year) {
    dropdownYear = new Select(webDriver.findElement(By.id("years")));
    dropdownYear.selectByValue(year);
  }

  private void setDropDownMonth(int month) {
    dropdownMonth = new Select(webDriver.findElement(By.id("months")));
    dropdownMonth.selectByIndex(month);
  }


  private void setDropDownDay(int day) {
    dropdownDay = new Select(webDriver.findElement(By.id("days")));
    dropdownDay.selectByIndex(day);
  }


  private void setPassword(String password) {

    this.password.sendKeys(password);
  }

  private void setEmail(String email) {
    this.email.clear();
    this.email.sendKeys(email);
  }

  private void setLastName(String lastName) {
    this.lastName.sendKeys(lastName);
  }

  private void setFirstName(String firstName) {

    this.firstName.sendKeys(firstName);
  }

  private void setRadioButtonTitle() {
    radioButtonTitle.click();
  }


  @Override
  public void waitPageIsLoaded() throws WebDriverException {

  }



  public boolean IAmCreateAccountPage() {
    //this a small trap
    return webDriver.getTitle().equalsIgnoreCase("Login - My Store");
  }

  public MyAccountPage clickRegister() {
    clickButtonRegister();
    return  new MyAccountPage();
  }
}
