package org.fundacionjala.automationproject.webdriver;

import org.openqa.selenium.WebDriver;

/**
 * Created by Administrator on 11/15/2017.
 */
public interface IWebDriver {
  /**
   * <p>This method instances a WebDriver Browser.</p>
   *
   * @return an implementation of WebDriver.
   */
  WebDriver getInstance();
}
