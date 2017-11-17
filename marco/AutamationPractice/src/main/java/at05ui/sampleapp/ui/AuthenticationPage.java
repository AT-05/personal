package at05ui.sampleapp.ui;

import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AuthenticationPage extends BasedPageObject {


  @FindBy(id = "email_create")
  private WebElement email;

  @FindBy(id = "SubmitCreate")
  WebElement btnSubmit;

  private void setEmail(String email) {
    this.email.sendKeys(email);
  }

  private void clickBtnSubmit() {
    btnSubmit.click();
  }

  public CreateAccountPage setNewAccount(String email) {
    setEmail(email);
    clickBtnSubmit();
    return new CreateAccountPage();
  }


  @Override
  public void waitPageIsLoaded() throws WebDriverException {

  }
}
