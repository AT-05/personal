package org.fundacionjala.automationproject.automation;

import java.io.File;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.fundacionjala.automationproject.config.EnvironmentConfig;
import org.fundacionjala.automationproject.webdriver.WebDriverConfig;
import org.fundacionjala.automationproject.webdriver.WebDriverManager;

/**
 * Created by Franco Aldunate on 11/14/2017.
 */
public final class Automation {
  private final Logger log = Logger.getLogger(getClass());
  private WebDriverConfig webDriverConfig;
  private EnvironmentConfig environmentConfig;

  private static final String WEB_DRIVER_CONFIG_FILENAME
    = System.getProperty("user.dir") + File.separator + "driverConfig.json";
  private static final String ENVIRONMENT_CONFIG_FILE_NAME
    = System.getProperty("user.dir") + File.separator + "environments.json";

  private static Automation instance;

  /**
   * <p>This constructor initializes properties of web driver configuration
   * and environment configuration.</p>
   */
  private Automation() {
    PropertyConfigurator.configure("log.properties");
    webDriverConfig = WebDriverConfig.getInstance();
    webDriverConfig.initDriverConfiguration(WEB_DRIVER_CONFIG_FILENAME);
    environmentConfig = EnvironmentConfig.getInstance();
    environmentConfig.initEnvironmentConfiguration(ENVIRONMENT_CONFIG_FILE_NAME);
  }

  /**
   * <p>This method returns the instance of the class.</p>
   *
   * @return a unique instance of this class.
   */
  public static Automation getInstance() {
    if (instance == null) {
      instance = new Automation();
    }
    return instance;
  }

  /**
   * <p>This method starts the Web Driver Manager.</p>
   *
   * @throws Exception if it can't start the driver.
   */
  public void startUp() throws Exception {
    WebDriverManager.getInstance().initWebDriver(webDriverConfig);
  }

  /**
   * <p>This method shuts down the Web Driver Manager.</p>
   *
   * @throws Exception if it can't shut down the driver.
   */
  public void shutDown() throws Exception {
    WebDriverManager.getInstance().quitPage();
  }
}
