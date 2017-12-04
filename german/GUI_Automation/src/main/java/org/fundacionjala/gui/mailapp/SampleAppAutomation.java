package org.fundacionjala.gui.mailapp;


import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.fundacionjala.gui.core.selenium.WebDriverConfig;
import org.fundacionjala.gui.core.selenium.WebDriverManager;
import org.fundacionjala.gui.mailapp.config.SampleAppEnvsConfig;

import java.io.File;


/**
 * Edited by German on 11/23/2017.
 */
public final class SampleAppAutomation {
  private static final String WEB_DRIVER_CONFIG_FILENAME
    = System.getProperty("user.dir") + File.separator + "driverConfig.json";
  private static final String MAIL_APP_ENVS_CONFIG_FILE_NAME
    = System.getProperty("user.dir") + File.separator + "environments.json";
  private static SampleAppAutomation instance;
  private Logger log = Logger.getLogger(getClass());
  private WebDriverConfig webDriverConfig;
  private SampleAppEnvsConfig sampleAppEnvsConfig;

  /**
   * <p>This constructor initializes properties of web driver configuration
   * and environment configuration.</p>
   */
  private SampleAppAutomation() {
    PropertyConfigurator.configure("log.properties");
    webDriverConfig.getInstance().initialize(WEB_DRIVER_CONFIG_FILENAME);
    sampleAppEnvsConfig.getInstance().initialize(MAIL_APP_ENVS_CONFIG_FILE_NAME);
  }

  /**
   * <p>This method returns the instance of the class.</p>
   *
   * @return a unique instance of this class.
   */
  public static SampleAppAutomation getInstance() {
    if (instance == null) {
      instance = new SampleAppAutomation();
    }
    return instance;
  }

  /**
   * <p>This method starts the Web Driver Manager.</p>
   *
   * @throws Exception if it can't start the driver.
   */
  public void startUp() throws Exception {
    WebDriverManager.getInstance().initialize(webDriverConfig);
//        PageTransporter.getInstance().navigateToLoginPage();
  }

  /**
   * <p>This method shuts down the Web Driver Manager.</p>
   *
   * @throws Exception if it can't shut down the driver.
   */
  public void shutDown() throws Exception {
    WebDriverManager.getInstance().quitDriver();
  }
}
