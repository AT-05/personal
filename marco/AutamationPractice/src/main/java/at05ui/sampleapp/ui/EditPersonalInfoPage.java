package at05ui.sampleapp.ui;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class EditPersonalInfoPage extends BasedPageObject {


  @FindBy(id = "id_gender2")
  WebElement radioButtonTitle;


  @FindBy(id = "firstname")
  WebElement firstName;

  @FindBy(id = "lastname")
  WebElement lastName;

  @FindBy(id = "email")
  WebElement email;

  @FindBy(id = "passwd")
  WebElement password;


  Select dropdownDay;


  Select dropdownMonth;


  Select dropdownYear;


  @FindBy(id = "old_passwd")
  WebElement old_passwd;

  @FindBy(id = "passwd")
  WebElement passwd;

  @FindBy(id = "confirmation")
  WebElement confirmation;

  @FindBy(name = "submitIdentity")
  WebElement submitIdentity;


  private void setRadioButtonTitle() {
    radioButtonTitle.click();
  }

  private void setFirstName(String firstName) {
    this.firstName.clear();
    ;
    this.firstName.sendKeys(firstName);
  }

  private void setLastName(String lastName) {
    this.lastName.clear();
    this.lastName.sendKeys(lastName);
  }

  private void setEmail(String email) {
    this.email.clear();
    this.email.sendKeys(email);
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


  private void setOldPassword(String oldPass) {
    this.old_passwd.clear();
    this.old_passwd.sendKeys(oldPass);
  }

  private void setPassword(String password) {
    this.passwd.clear();
    this.passwd.sendKeys(password);

  }

  private void setConfirmation(String confirmation) {
    this.confirmation.clear();
    this.confirmation.sendKeys(confirmation);
  }

  public IdentifyPage clickSave() {
    submitIdentity.click();
    return new IdentifyPage();
  }

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
