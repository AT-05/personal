package org.fundacionjala.gui.core.selenium.webdrivers;

import org.fundacionjala.gui.core.selenium.WebDriverConfig;
import org.openqa.selenium.WebDriver;

import java.util.HashMap;
import java.util.Map;

/**
 * Edited by German on 11/23/2017.
 */
public final class DriverFactory {

  private static final String FIREFOX = "firefox";
  private static final String CHROME = "chrome";

  /**
   * <p>Constructor of the class.</p>
   */
  private DriverFactory() {
  }

  /**
   * <p>This method returns a WebDriver browser.</p>
   *
   * @param webDriverConfig is a WebDriverConfig object type.
   * @return a WebDriver object type.
   */
  public static WebDriver getDriver(final WebDriverConfig webDriverConfig) {
    Map<String, IDriver> strategyBrowser = new HashMap<>();
    strategyBrowser.put(FIREFOX, new FireFox());
    strategyBrowser.put(CHROME, new Chrome());

    System.out.println(webDriverConfig.getBrowser());
    return strategyBrowser.get(webDriverConfig.getBrowser().toLowerCase()).initDriver();
  }
}
