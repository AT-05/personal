package at05ui.sampleapp.ui;

import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class IndexPage extends BasedPageObject {

  @FindBy(className = "login")
  WebElement singIn;

  public LoginPage clickSingIn() {
    singIn.click();
    return new LoginPage();
  }


  @Override
  public void waitPageIsLoaded() throws WebDriverException {

  }
}
