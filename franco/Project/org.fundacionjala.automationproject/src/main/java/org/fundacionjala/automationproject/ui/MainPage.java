package org.fundacionjala.automationproject.ui;

import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * Created by Franco Aldunate on 11/14/2017.
 */
public class MainPage extends BasePage {
  @FindBy(xpath = "//*[@id=\"li_myaccount\"]/a")
  private WebElement myAccountOption;

  @FindBy (xpath = "//*[@id=\"li_myaccount\"]/ul/li[2]/a")
  private WebElement loginOption;

  /**
   * <p>This constructor initializes driver and wait and web elements.</p>
   */
  public MainPage() {
    super();
  }

  /**
   * <p>This method runs the automated test of the web pages section.</p>
   *
   * @return a LoginPage object.
   */
  public LoginPage goToLogin() {
    myAccountOption.click();
    try {
      Thread.sleep(3000);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
    loginOption.click();
    return new LoginPage();
  }

  @Override
  public void waitUntilPageObjectIsLoaded() throws WebDriverException {

  }
}
