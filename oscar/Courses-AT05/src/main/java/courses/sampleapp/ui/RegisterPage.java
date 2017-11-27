package courses.sampleapp.ui;

import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * Created by Administrator on 11/17/2017.
 */
public class RegisterPage extends BasePageObject {

    @FindBy(id = "user_first_name")
    WebElement firstName;

    @FindBy(id = "user_last_name")
    WebElement lastName;

    @FindBy(id = "user_email")
    WebElement email;

    @FindBy(id = "user_password")
    WebElement password;

    @FindBy(id = "btn-signup")
    WebElement btnSignUp;

    /**
     * Constructor
     */
    public RegisterPage() {
      super();
    }

  /**
   * This method set the values for register user.
   *
   * @param firstName as a String
   * @param lastName as a String
   * @param email as a string.
   * @param password as a string.
   * @return HomePage.
   */
  public HomePage registerUser(String firstName, String lastName, String email, String password) {
    setFirstName(firstName);
    setLastName(lastName);
    setEmailUser(email);
    setPasswordUser(password);
    return clickSingUpButton();
  }

  /**
   * Set first name of the user in the Fist Name field.
   *
   * @param firstName as a string.
   */
  private void setFirstName(String firstName) {
    this.firstName.clear();
    this.firstName.sendKeys(firstName);
  }

  /**
   * Set last name of the user in the Last Name field.
   *
   * @param lastName as a string.
   */
  private void setLastName(String lastName) {
    this.lastName.clear();
    this.lastName.sendKeys(lastName);
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
   * Made a click over the button sing up.
   *
   * @return HomePage.
   */
  private HomePage clickSingUpButton() {
    btnSignUp.click();
    return new HomePage();
  }

  @Override
  public void waitUntilPageObjectIsLoaded() throws WebDriverException {

  }
}
