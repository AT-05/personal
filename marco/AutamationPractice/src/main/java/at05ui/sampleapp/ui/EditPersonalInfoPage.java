package at05ui.sampleapp.ui;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

/**
 * Class EditPersonalInfoPage.
 */
public class EditPersonalInfoPage extends BasedPageObject {


  @FindBy(id = "id_gender2")
  private WebElement radioButtonTitle;

  @FindBy(id = "firstname")
  private WebElement firstName;

  @FindBy(id = "lastname")
  private WebElement lastName;

  @FindBy(id = "email")
  private WebElement email;

  @FindBy(id = "passwd")
  private WebElement password;


  private Select dropdownDay;


  private Select dropdownMonth;


  private Select dropdownYear;


  @FindBy(id = "old_passwd")
  private WebElement old_passwd;

  @FindBy(id = "passwd")
  private WebElement passwd;

  @FindBy(id = "confirmation")
  private WebElement confirmation;

  @FindBy(name = "submitIdentity")
  private WebElement submitIdentity;

  /**
   * Set RadioButton.
   */
  private void setRadioButtonTitle() {
    radioButtonTitle.click();
  }

  /**
   * Set the field FirstName.
   *
   * @param firstName string.
   */
  private void setFirstName(String firstName) {
    this.firstName.clear();
    ;
    this.firstName.sendKeys(firstName);
  }

  /**
   * Set the field LastName.
   *
   * @param lastName string.
   */
  private void setLastName(String lastName) {
    this.lastName.clear();
    this.lastName.sendKeys(lastName);
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
   * Set the field DropDown Year.
   *
   * @param year string.
   */
  private void setDropDownYear(String year) {
    dropdownYear = new Select(webDriver.findElement(By.id("years")));
    dropdownYear.selectByValue(year);
  }

  /**
   * Set the field DropDown month.
   *
   * @param month string.
   */
  private void setDropDownMonth(int month) {
    dropdownMonth = new Select(webDriver.findElement(By.id("months")));
    dropdownMonth.selectByIndex(month);
  }

  /**
   * Set the field DropDown day.
   *
   * @param day string.
   */
  private void setDropDownDay(int day) {
    dropdownDay = new Select(webDriver.findElement(By.id("days")));
    dropdownDay.selectByIndex(day);
  }


  /**
   * Set the field OldPassword.
   *
   * @param oldPass string.
   */
  private void setOldPassword(String oldPass) {
    this.old_passwd.clear();
    this.old_passwd.sendKeys(oldPass);
  }

  /**
   * Set the field Password.
   *
   * @param password string.
   */
  private void setPassword(String password) {
    this.passwd.clear();
    this.passwd.sendKeys(password);

  }

  /**
   * Set the field Confirmation.
   *
   * @param confirmation string.
   */
  private void setConfirmation(String confirmation) {
    this.confirmation.clear();
    this.confirmation.sendKeys(confirmation);
  }

  /**
   * Event click of the BtnSave.
   *
   * @return IdentifyPage.
   */
  public IdentifyPage clickSave() {
    submitIdentity.click();
    return new IdentifyPage();
  }

  /**
   * Set NewInfo.
   *
   * @param firstName string.
   * @param lastName string.
   * @param oldPass string.
   * @param pass string.
   * @param confirmation string.
   * @param dia int.
   * @param month int.
   * @param year string.
   */
  public void setNewInfo(String firstName, String lastName, String oldPass, String pass,
      String confirmation, int dia, int month, String year) {
    setRadioButtonTitle();
    setFirstName(firstName);
    setLastName(lastName);
    setDropDownDay(dia);
    setDropDownMonth(month);
    setDropDownYear(year);
    setOldPassword(oldPass);
    setPassword(pass);
    setConfirmation(confirmation);

  }

  @Override
  public void waitPageIsLoaded() throws WebDriverException {

  }


}
