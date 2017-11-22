package org.fundacionjala.automationproject.ui;

import static org.fundacionjala.automationproject.entities.UserInfo.USER_ADDRESS;
import static org.fundacionjala.automationproject.entities.UserInfo.USER_CITY;
import static org.fundacionjala.automationproject.entities.UserInfo.USER_COUNTRY;
import static org.fundacionjala.automationproject.entities.UserInfo.USER_EMAIL;
import static org.fundacionjala.automationproject.entities.UserInfo.USER_LAST_NAME;
import static org.fundacionjala.automationproject.entities.UserInfo.USER_NAME;
import static org.fundacionjala.automationproject.entities.UserInfo.USER_NICKNAME;
import static org.fundacionjala.automationproject.entities.UserInfo.USER_PASSWORD;
import static org.fundacionjala.automationproject.entities.UserInfo.USER_PHONE;
import static org.fundacionjala.automationproject.entities.UserInfo.USER_STATE;
import static org.fundacionjala.automationproject.entities.UserInfo.USER_ZIP;

import java.util.Map;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

/**
 * Created by Administrator on 11/22/2017.
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
   * @param userInfoMap is a map containing the user info.
   */
  private void fillUserContactInfoForm(Map<String, String> userInfoMap) {
    userName.sendKeys(userInfoMap.get(USER_NAME));
    userLastName.sendKeys(userInfoMap.get(USER_LAST_NAME));
    userPhone.sendKeys(userInfoMap.get(USER_PHONE));
    userEmail.sendKeys(userInfoMap.get(USER_EMAIL));
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
   * @param userInfoMap is a map containing the user info.
   */
  private void fillUserMailingInfoForm(Map<String, String> userInfoMap) {
    userAddress.sendKeys(userInfoMap.get(USER_ADDRESS));
    userCity.sendKeys(userInfoMap.get(USER_CITY));
    userState.sendKeys(userInfoMap.get(USER_STATE));
    userPostalCode.sendKeys(userInfoMap.get(USER_ZIP));
    userCountry.click();
    Select passenger = new Select(userCountry);
    passenger.selectByVisibleText(userInfoMap.get(USER_COUNTRY));
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
   * @param userInfoMap is a map containing the user info.
   */
  private void fillUserInfoForm(Map<String, String> userInfoMap) {
    userNickName.sendKeys(userInfoMap.get(USER_NICKNAME));
    userPassword.sendKeys(userInfoMap.get(USER_PASSWORD));
    userConfirmPassword.sendKeys(userInfoMap.get(USER_PASSWORD));
  }

  /**
   * <p>This method performs user registration.</p>
   *
   * @param userInfoMap is a map containing the user info.
   * @return a UserConfirmationPage object type.
   */
  public UserConfirmationPage registerUser(Map<String, String> userInfoMap) {
    clearUserContactInfoForm();
    clearUserMailingInfoForm();
    clearUserInfoForm();
    fillUserContactInfoForm(userInfoMap);
    fillUserMailingInfoForm(userInfoMap);
    fillUserInfoForm(userInfoMap);
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
