package at05ui.sampleapp.ui;

import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * Class LoginPage.
 */
public class LoginPage extends BasedPageObject {

  @FindBy(id = "email")
  private  WebElement email;

  @FindBy(id = "passwd")
  private WebElement password;

  @FindBy(id = "SubmitLogin")
  private WebElement btnLogin;

  /**
   * Construct.
   */
  public LoginPage() {
    super();
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
   * Set the field Password.
   *
   * @param password string.
   */
  private void setPassword(String password) {
    this.password.clear();
    this.password.sendKeys(password);
  }

  /**
   * Event click BtnLogin.
   */
  private void clickLoginBtn() {
    btnLogin.click();
  }

  /**
   * Set Sing In.
   *
   * @param email string.
   * @param password string.
   * @return MyAccount.
   */
  public MyAccountPage setLogin(String email, String password) {
    setEmail(email);
    setPassword(password);
    clickLoginBtn();
    return new MyAccountPage();
  }


  @Override
  public void waitPageIsLoaded() throws WebDriverException {

  }

  /**
   * Check if I am in LoginPage.
   */
  public boolean IsAmInLoginPage() {
    return webDriver.getTitle().equalsIgnoreCase("Login - My Store");
  }
}
