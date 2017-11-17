package sampleapp.ui;

import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * Created by Administrator on 11/15/2017.
 */
public class HomePage extends BasePageObject {

  @FindBy(css = "p.message-text")
  WebElement welcomeMessage;

  @FindBy(css = "span.user-name")
  WebElement nameProfile;

  @FindBy(linkText = "My Dashboard")
  WebElement title;

  /**
   * Constructor.
   */
  public HomePage() {
    super();
  }

  public String getWelcomeMessage() {
    return welcomeMessage.getText();
  }

  /**
   * Check is in the main page.
   *
   * @return a boolean.
   */
  public boolean isInTheMainPage() {
    if (title.getText().equalsIgnoreCase("My Dashboard")) {
      return true;
    }
    return false;
  }

  @Override
  public void waitUntilPageObjectIsLoaded() throws WebDriverException {

  }
}
