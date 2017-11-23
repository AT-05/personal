package org.fundacionjala.automationproject.ui;

import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * Created by Franco Aldunate on 11/14/2017.
 */
public class MainPage extends BasePage {
  @FindBy(name = "userName")
  private WebElement userName;

  @FindBy(name = "password")
  private WebElement password;

  @FindBy(name = "login")
  private WebElement logInButton;

  @FindBy(linkText = "REGISTER")
  private WebElement registerUserLink;

  /**
   * <p>This constructor inherits from BasePage class..</p>
   */
  public MainPage() {
    super();
  }

  /**
   * <p>This method fills user name field.</p>
   *
   * @param userNameInput is the user name value given.
   */
  public void fillUserName(String userNameInput) {
    userName.sendKeys(userNameInput);
  }

  /**
   * <p>This method fills user name field.</p>
   *
   * @param passwordInput is the user password value given.
   */
  public void fillPassword(String passwordInput) {
    password.sendKeys(passwordInput);
  }

  /**
   * <p>This method clears form fields.</p>
   */
  private void clearLoginFormFields() {
    userName.clear();
    password.clear();
  }

  /**
   * <p>This method performs the login of user.</p>
   *
   * @param userNameInput is the user name value given.
   * @param passwordInput is the user password value given.
   * @return a HomePage object.
   */
  public HomePage loginUser(String userNameInput, String passwordInput) {
    clearLoginFormFields();
    fillUserName(userNameInput);
    fillPassword(passwordInput);
    logInButton.click();
    return new HomePage();
  }

  /**
   * <p>This method sends to user registration page.</p>
   *
   * @return a UserRegistrationPage object type.
   */
  public UserRegistrationPage goToRegistrationPage() {
    registerUserLink.click();
    return new UserRegistrationPage();
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
