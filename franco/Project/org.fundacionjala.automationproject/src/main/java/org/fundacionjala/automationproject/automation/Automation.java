package org.fundacionjala.automationproject.automation;

import java.io.File;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.fundacionjala.automationproject.config.EnvironmentConfig;
import org.fundacionjala.automationproject.webdriver.WebDriverConfig;
import org.fundacionjala.automationproject.webdriver.WebDriverManager;


public class Automation {
  private Logger log = Logger.getLogger(getClass());
  private WebDriverConfig webDriverConfig;
  private EnvironmentConfig environmentConfig;

  private static final String webDriverConfigFilename = System.getProperty("user.dir") + File.separator + "driverConfig.json";
  private static final String environmentConfigFileName = System.getProperty("user.dir") + File.separator + "environments.json";

  private static Automation instance;

  private Automation() {
    PropertyConfigurator.configure("log.properties");
    webDriverConfig = WebDriverConfig.getInstance();
    webDriverConfig.initDriverConfiguration(webDriverConfigFilename);
    environmentConfig = EnvironmentConfig.getInstance();
    environmentConfig.initEnvironmentConfiguration(environmentConfigFileName);
  }

  public static Automation getInstance() {
    if (instance == null) {
      instance = new Automation();
    }
    return instance;
  }

  public void startUp() throws Exception {
    WebDriverManager.getInstance().initWebDriver(webDriverConfig);
  }

  public void shutDown() throws Exception {
    WebDriverManager.getInstance().quitPage();
  }
}
