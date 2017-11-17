package org.fundacionjala.automationproject.webdriver;

import io.github.bonigarcia.wdm.ChromeDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

/**
 * Created by Administrator on 11/15/2017.
 */
public class Chrome implements IWebDriver {
  /**
   * <p>This method instances a WebDriver Browser.</p>
   *
   * @return an implementation of WebDriver.
   */
  @Override
  public WebDriver getInstance() {
    ChromeDriverManager.getInstance().setup();
    return new ChromeDriver();
  }
}
