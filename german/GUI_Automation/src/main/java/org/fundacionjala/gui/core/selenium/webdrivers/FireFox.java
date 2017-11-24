package org.fundacionjala.gui.core.selenium.webdrivers;

import io.github.bonigarcia.wdm.FirefoxDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

/**
 * Edited by German on 11/23/2017.
 */
class FireFox implements IDriver {
  /**
   * <p>This method instances a IDriver Browser.</p>
   *
   * @return an implementation of WebDriver.
   */
  @Override
  public WebDriver initDriver() {
    FirefoxDriverManager.getInstance().setup();

    //Todo Add more code here
    return new FirefoxDriver();
  }
}
