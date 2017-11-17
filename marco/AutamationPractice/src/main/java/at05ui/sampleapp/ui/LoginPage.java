package at05ui.sampleapp.ui;

import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasedPageObject {

  @FindBy(id = "email")
  WebElement email;

  @FindBy(id = "passwd")
  WebElement password;

  @FindBy(id = "SubmitLogin")
  WebElement btnLogin;

  public LoginPage() {
    super();
  }

  private void setEmail(String email) {
    this.email.clear();
    this.email.sendKeys(email);
  }

  private void setPassword(String password) {
    this.password.clear();
    this.password.sendKeys(password);
  }

  private void clickLoginBtn() {
    btnLogin.click();
  }

  public MyAccountPage insertUser(String email, String password) {
    setEmail(email);
    setPassword(password);
    clickLoginBtn();
    return new MyAccountPage();
  }


  @Override
  public void waitPageIsLoaded() throws WebDriverException {

  }

  public boolean IsAmInLoginPage() {
    return webDriver.getTitle().equalsIgnoreCase("Login - My Store");
  }
}
