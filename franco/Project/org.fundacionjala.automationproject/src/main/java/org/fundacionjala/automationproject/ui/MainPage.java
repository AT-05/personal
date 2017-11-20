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

  private String usernameInput;
  private String passwordInput;

  /**
   * <p>This constructor receives login field values.</p>
   */
  public MainPage() {
    super();
  }

  /**
   * <p>This method sets user name value.</p>
   *
   * @param userNameInput is the value of the user name.
   */
  public void setUserName(String userNameInput) {
    this.usernameInput = userNameInput;
  }

  /**
   * <p>This method sets password value.</p>
   *
   * @param passwordInput is the value of the user password.
   */
  public void setPassword(String passwordInput) {
    this.passwordInput = passwordInput;
  }

  /**
   * <p>This method fills user name field.</p>
   */
  public void fillUserName() {
    userName.sendKeys(usernameInput);
  }

  /**
   * <p>This method fills user name field.</p>
   */
  public void fillPassword() {
    password.sendKeys(passwordInput);
  }

  /**
   * <p>This method clears form fields.</p>
   */
  private void clearFields() {
    userName.clear();
    password.clear();
  }

  /**
   * <p>This method runs the automated test for login.</p>
   *
   * @return a HomePage object.
   */
  public HomePage login() {
    clearFields();
    fillUserName();
    fillPassword();
    logInButton.click();
    return new HomePage();
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
