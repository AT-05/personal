package at05ui.sampleapp.ui;

import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * Created by Marco Mendez November 2017.
 */
public class IdentifyPage extends BasedPageObject {

  @FindBy(className = "logout")
  private WebElement logOut;

  /**
   * Check if I am in this page.
   *
   * @return boolean.
   */
  public boolean IAmInIdentifyPage() {
    return webDriver.getTitle().trim().equalsIgnoreCase("Identity - My Store");
  }

  @Override
  public void waitPageIsLoaded() throws WebDriverException {

  }

  /**
   * Event click logOut.
   */
  public void clickLogout() {
    logOut.click();
  }

  /**
   * Event Click SingOut.
   */
  public void clickSingOut() {
    clickLogout();
  }
}
