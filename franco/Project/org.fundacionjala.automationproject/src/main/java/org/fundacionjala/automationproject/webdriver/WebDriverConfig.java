package org.fundacionjala.automationproject.webdriver;

import org.fundacionjala.automationproject.utils.JsonReader;

/**
 * Created by Franco Aldunate on 11/16/2017.
 */
public class WebDriverConfig {
  private static final String BROWSER = "browser";
  private static final String DRIVER = "web driver";
  private static final String IMPLICIT_WAIT_TIME = "implicit wait time";
  private static final String EXPLICIT_WAIT_TIME = "explicit wait time";
  private static final String WAIT_SLEEP_TIME = "wait sleep time";

  private JsonReader configReader;

  private final String browser = System.getProperty("browserName");;
  private int implicitWaitTime;
  private int explicitWaitTime;
  private int waitSleepTime;

  private static WebDriverConfig instance;

  /**
   * <p>Constructor of the class.</p>
   */
  protected WebDriverConfig() {
  }

  /**
   * <p>This method returns an instance of WebDriverConfig class.</p>
   *
   * @return a unique WebDriverConfig object.
   */
  public static WebDriverConfig getInstance() {
    if (instance == null) {
      instance = new WebDriverConfig();
    }
    return instance;
  }

  /**
   * <p>This method initializes configuration of driver..</p>
   *
   * @param webDriverConfigFilename is a Json file type name.
   */
  public void initDriverConfiguration(String webDriverConfigFilename) {
    configReader = new JsonReader(webDriverConfigFilename);
    //browser = configReader.getKeyValue(DRIVER, BROWSER);
    implicitWaitTime = Integer.valueOf(configReader.getKeyValue(DRIVER, IMPLICIT_WAIT_TIME));
    explicitWaitTime = Integer.valueOf(configReader.getKeyValue(DRIVER, EXPLICIT_WAIT_TIME));
    waitSleepTime = Integer.valueOf(configReader.getKeyValue(DRIVER, WAIT_SLEEP_TIME));
  }

  /**
   * <p>This method returns a browser name.</p>
   *
   * @return the browser currently used.
   */
  public String getBrowser() {
    return browser;
  }

  /**
   * <p>This method returns an implicit wait time.</p>
   *
   * @return the value of the implicit wait time.
   */
  public int getImplicitWaitTime() {
    return implicitWaitTime;
  }

  /**
   * <p>This method returns an explicit wait time.</p>
   *
   * @return the value of the explicit wait time.
   */
  public int getExplicitWaitTime() {
    return explicitWaitTime;
  }

  /**
   * <p>This method returns a wait sleep time.</p>
   *
   * @return the value of the wait sleep time.
   */
  public int getWaitSleepTime() {
    return waitSleepTime;
  }
}
