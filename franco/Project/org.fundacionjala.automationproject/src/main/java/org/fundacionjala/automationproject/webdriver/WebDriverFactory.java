package org.fundacionjala.automationproject.webdriver;

import java.util.HashMap;
import java.util.Map;
import org.openqa.selenium.WebDriver;

/**
 * Created by Administrator on 11/15/2017.
 */
public final class WebDriverFactory {
  private static final String FIREFOX = "firefox";
  private static final String CHROME = "chrome";

  private static Map<String, IWebDriver> webDriverMap;

  /**
   * <p>This method initializes web driver map.</p>
   */
  public static void initialize() {
    webDriverMap = new HashMap<>();
    webDriverMap.put(FIREFOX, new Firefox());
    webDriverMap.put(CHROME, new Chrome());
  }

  /**
   * <p>This method returns a WebDriver browser.</p>
   *
   * @return a IWebDriver object type.
   */
  public static WebDriver getWebDriver(final WebDriverConfig webDriverConfig) {
    initialize();
    return webDriverMap.get(webDriverConfig.getBrowser().toLowerCase()).getInstance();
  }
}
