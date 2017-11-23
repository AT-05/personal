package courses.sampleapp.ui;

import courses.sampleapp.entities.User;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * Created by Administrator on 11/15/2017.
 */
public class LoginPage extends BasePageObject {

  @FindBy(id = "user_email")
  WebElement email;

  @FindBy(id = "user_password")
  WebElement password;

  @FindBy(id = "btn-signin")
  WebElement btnSignIn;

  @FindBy(linkText = "Create a new account")
  WebElement createUser;

  /**
   * Constructor.
   */
  public LoginPage() {
    super();
  }

  /**
   * This method set the values for login user.
   * @param user as a object.
   * @return HomePage.
   */
  public HomePage enterCredentials(User user) {
    setEmailUser(user.getEmail());
    setPasswordUser(user.getPassword());
    return clickSingInButton();
  }

  /**
   * Set email value in the email field.
   *
   * @param email as a string.
   */
  private void setEmailUser(String email) {
    this.email.clear();
    this.email.sendKeys(email);
  }

  /**
   * Set password value in the password field.
   *
   * @param password as a string.
   */
  private void setPasswordUser(String password) {
    this.password.clear();
    this.password.sendKeys(password);
  }

  /**
   * Made a click over the button sing in.
   *
   * @return HomePage.
   */
  private HomePage clickSingInButton() {
    btnSignIn.click();
    return new HomePage();
  }

  @Override
  public void waitUntilPageObjectIsLoaded() throws WebDriverException {

  }

  /**
   * Enter to register page.
   *
   * @return RegisterPage.
   */
  public RegisterPage goToRegisterPage() {
    createUser.click();
    return new RegisterPage();
  }
}
