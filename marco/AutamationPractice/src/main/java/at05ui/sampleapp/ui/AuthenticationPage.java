package at05ui.sampleapp.ui;

import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * Created by Marco Mendez November 2017.
 */
public class AuthenticationPage extends BasedPageObject {


  @FindBy(id = "email_create")
  private WebElement email;

  @FindBy(id = "SubmitCreate")
  WebElement btnSubmit;

  /**
   * Set the email.
   *
   * @param email string.
   */
  private void setEmail(String email) {
    this.email.sendKeys(email);
  }

  /**
   * Event Click for BtnSubmit
   */
  private void clickBtnSubmit() {
    btnSubmit.click();
  }

  /**
   * Set the email for new Account.
   *
   * @param email string.
   * @return CreateAccountPage.
   */
  public CreateAccountPage setNewAccount(String email) {
    setEmail(email);
    clickBtnSubmit();

    return new CreateAccountPage();
  }


  @Override
  public void waitPageIsLoaded() throws WebDriverException {

  }
}
