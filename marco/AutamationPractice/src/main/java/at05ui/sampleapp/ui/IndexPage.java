package at05ui.sampleapp.ui;

import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * Created by Marco Mendez November 2017.
 */
public class IndexPage extends BasedPageObject {

  @FindBy(className = "login")
  private WebElement singIn;

  /**
   * Event click Sing In.
   *
   * @return LoginPage.
   */
  public LoginPage clickSingIn() {
    singIn.click();
    return new LoginPage();
  }


  @Override
  public void waitPageIsLoaded() throws WebDriverException {

  }
}
