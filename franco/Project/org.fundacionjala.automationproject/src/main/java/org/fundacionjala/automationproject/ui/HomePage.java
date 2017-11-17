package org.fundacionjala.automationproject.ui;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

/**
 * Created by Administrator on 11/16/2017.
 */
public class HomePage extends BasePage {
  private Select profile;
  Select logOut;

  @FindBy(xpath = "//*[@id=\"body-section\"]/div/div[1]/div/div[1]/h3")
  private WebElement message;

  /**
   * <p>This method checks if the username appears on the my account section.</p>
   *
   * @param input is the text to compare with.
   * @return whether the message is equal to the text given or not.
   */
  public boolean isUserNameDisplayed(String input) {
    boolean result = false;
    if (driver.getTitle().toLowerCase().equals("my account")) {
      result = message.getText().toLowerCase().equals(input);
    }
    return result;
  }

  /**
   * <p>This method logs out user from session.</p>
   */
  public MainPage logOut() {
    WebElement profile = driver.findElement(By.xpath("(//a[contains(@href, 'javascript:void(0);')])[3]"));
    profile.click();
    WebElement logOut = driver.findElement(By.xpath("(//a[@href='http://www.phptravels.net/account/logout/'])[2]"));
    logOut.click();
    return new MainPage();
  }

  /**
   * <p>This method checks for correct loading of pages.</p>
   *
   * @throws WebDriverException when pages doesn't load correctly.
   */
  @Override
  public void waitUntilPageObjectIsLoaded() throws WebDriverException {

  }
}
