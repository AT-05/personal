package org.fundacionjala.automationproject.webdriver;

import java.util.HashMap;
import java.util.Map;
import org.openqa.selenium.WebDriver;

/**
 * Created by Franco Aldunate on 11/15/2017.
 */
public final class WebDriverFactory {
  private static final String FIREFOX = "firefox";
  private static final String CHROME = "chrome";

  /**
   * <p>Constructor of the class.</p>
   */
  protected WebDriverFactory() {

  }

  /**
   * <p>This method returns a WebDriver browser.</p>
   *
   * @param webDriverConfig is a WebDriverConfig object type.
   * @return a WebDriver object type.
   */
  public static WebDriver getWebDriver(final WebDriverConfig webDriverConfig) {
    Map<String, IWebDriver> webDriverMap = new HashMap<>();
    webDriverMap.put(FIREFOX, new Firefox());
    webDriverMap.put(CHROME, new Chrome());
    System.out.println(webDriverConfig.getBrowser());
    return webDriverMap.get(webDriverConfig.getBrowser().toLowerCase()).getInstance();
  }
}
