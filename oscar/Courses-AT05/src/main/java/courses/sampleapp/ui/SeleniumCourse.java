package courses.sampleapp.ui;

import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * Created by Oz64 on 20/11/2017.
 */
public class SeleniumCourse extends BasePageObject {

  @FindBy(linkText = "Dashboard")
  WebElement btnDashboard;

  /**
   * Go to dashboard page.
   *
   * @return DashboardPage.
   */
  public DashboardPage goToDashboard() {
    btnDashboard.click();
    return new DashboardPage();
  }

  @Override
  public void waitUntilPageObjectIsLoaded() throws WebDriverException {

  }
}
