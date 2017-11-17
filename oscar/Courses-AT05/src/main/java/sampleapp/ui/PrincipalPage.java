package sampleapp.ui;

import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * Created by Administrator on 11/17/2017.
 */
public class PrincipalPage extends BasePageObject {

  @FindBy(css = "a.my-account")
  WebElement btnSignIn;

  /**
   * Constructor
   */
  public PrincipalPage() {
    super();
  }

  /**
   * This method made a click in SignIn button.
   *
   * @return LoginPage.
   */
  public LoginPage goToLoginPage() {
    return clickSingInButton();
  }

  /**
   * Made a click over the button sing in.
   *
   * @return LoginPage.
   */
  private LoginPage clickSingInButton() {
    btnSignIn.click();
    return new LoginPage();
  }

  @Override
  public void waitUntilPageObjectIsLoaded() throws WebDriverException {

  }
}
