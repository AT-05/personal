package org.fundacionjala.automationproject.webdriver;

import io.github.bonigarcia.wdm.FirefoxDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

/**
 * Created by Franco Aldunate on 11/15/2017.
 */
public class Firefox implements IWebDriver {
  /**
   * <p>This method instances a WebDriver Browser.</p>
   *
   * @return an implementation of WebDriver.
   */
  @Override
  public WebDriver getInstance() {
    FirefoxDriverManager.getInstance().setup();
    return new FirefoxDriver();
  }
}
