package org.fundacionjala.automationproject.ui;

import java.util.List;
import org.fundacionjala.automationproject.entities.User;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

/**
 * Created by Franco Aldunate on 11/22/2017.
 */
public class UserRegistrationPage extends BasePage {
  @FindBy(name = "firstName")
  private WebElement userName;

  @FindBy(name = "lastName")
  private WebElement userLastName;

  @FindBy(name = "phone")
  private WebElement userPhone;

  @FindBy(name = "userName")
  private WebElement userEmail;

  @FindBy(name = "address1")
  private WebElement userAddress;

  @FindBy(name = "city")
  private WebElement userCity;

  @FindBy(name = "state")
  private WebElement userState;

  @FindBy(name = "postalCode")
  private WebElement userPostalCode;

  @FindBy(name = "country")
  private WebElement userCountry;

  @FindBy(name = "email")
  private WebElement userNickName;

  @FindBy(name = "password")
  private WebElement userPassword;

  @FindBy(name = "confirmPassword")
  private WebElement userConfirmPassword;

  @FindBy(name = "register")
  private WebElement registerUser;

  /**
   * <p>This method clears user contact info form.</p>
   */
  private void clearUserContactInfoForm() {
    userName.clear();
    userLastName.clear();
    userPhone.clear();
    userEmail.clear();
  }

  /**
   * <p>This method fills user contact info form.</p>
   *
   * @param user is an entity class.
   */
  private void fillUserContactInfoForm(List<User> user) {
    for (User userItem : user) {
      userName.sendKeys(userItem.getFirstName());
      userLastName.sendKeys(userItem.getLastName());
      userPhone.sendKeys(userItem.getPhone());
      userEmail.sendKeys(userItem.getEmail());
    }
  }

  /**
   * <p>This method clears user mailing info form.</p>
   */
  private void clearUserMailingInfoForm() {
    userAddress.clear();
    userCity.clear();
    userState.clear();
    userPostalCode.clear();
  }

  /**
   * <p>This method fills user mailing info form.</p>
   *
   * @param userList is a list of User entity object type.
   */
  private void fillUserMailingInfoForm(List<User> userList) {
    userCountry.click();
    Select passenger = new Select(userCountry);
    for (User userItem : userList) {
      userAddress.sendKeys(userItem.getAddress());
      userCity.sendKeys(userItem.getCity());
      userState.sendKeys(userItem.getState());
      userPostalCode.sendKeys(userItem.getZip());
      passenger.selectByVisibleText(userItem.getCountry());
    }
  }

  /**
   * <p>This method clears user info form.</p>
   */
  private void clearUserInfoForm() {
    userNickName.clear();
    userPassword.clear();
    userConfirmPassword.clear();
  }

  /**
   * <p>This method fills user info form.</p>
   *
   * @param userList is a list of User entity object type.
   */
  private void fillUserInfoForm(List<User> userList) {
    for (User userItem : userList) {
      userNickName.sendKeys(userItem.getUserName());
      userPassword.sendKeys(userItem.getPassword());
      userConfirmPassword.sendKeys(userItem.getPassword());
    }
  }

  /**
   * <p>This method performs user registration.</p>
   *
   * @param userList is a list of User entity object type.
   * @return a UserConfirmationPage object type.
   */
  public UserConfirmationPage registerUser(List<User> userList) {
    clearUserContactInfoForm();
    clearUserMailingInfoForm();
    clearUserInfoForm();
    fillUserContactInfoForm(userList);
    fillUserMailingInfoForm(userList);
    fillUserInfoForm(userList);
    registerUser.click();
    return new UserConfirmationPage();
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
