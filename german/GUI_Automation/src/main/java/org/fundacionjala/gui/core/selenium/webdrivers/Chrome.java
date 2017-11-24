package org.fundacionjala.gui.core.selenium.webdrivers;

import io.github.bonigarcia.wdm.ChromeDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

/**
 * Edited by German on 11/23/2017.
 */
class Chrome implements IDriver {

  /**
   * <p>This method instances a WebDriver Browser.</p>
   *
   * @return an implementation of WebDriver.
   */

  @Override
  public WebDriver initDriver() {
    ChromeDriverManager.getInstance().setup();

    //Todo Add more code here
    return new ChromeDriver();
  }
}
