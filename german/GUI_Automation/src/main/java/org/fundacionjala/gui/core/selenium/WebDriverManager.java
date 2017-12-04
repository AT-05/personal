package org.fundacionjala.gui.core.selenium;


import org.apache.log4j.Logger;
import org.fundacionjala.gui.core.selenium.webdrivers.DriverFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

/**
 * Edited by German on 11/23/2017.
 */
public class WebDriverManager {

  private static WebDriverManager instance = null;
  private Logger log = Logger.getLogger(getClass());
  private WebDriverConfig webDriverConfig = WebDriverConfig.getInstance();
  private WebDriver webDriver;
  private WebDriverWait webDriverWait;

  /**
   * <p>Constructor of the class.</p>
   */
  protected WebDriverManager() {
    initialize(webDriverConfig);
  }

  /**
   * <p>This method returns an instance of WebDriverManager class.</p>
   *
   * @return a unique WebDriverManager object.
   */
  public static WebDriverManager getInstance() {
    if (instance == null || instance.webDriver == null) {
      instance = new WebDriverManager();
    }
    return instance;
  }

  /**
   * <p>This method initializes webDriver specific instance.</p>
   *
   * @param webDriverConfig is a WebDriverConfig object type.
   */
  public void initialize(final WebDriverConfig webDriverConfig) {
    log.info("Initializing web driver");
    this.webDriver = DriverFactory.getDriver(webDriverConfig);

    this.webDriver.manage().window().maximize();
    this.webDriver.manage().timeouts().implicitlyWait(
      webDriverConfig.getImplicitWaitTime(), TimeUnit.SECONDS);
    webDriverWait = new WebDriverWait(
      webDriver, webDriverConfig.getExplicitWaitTime(),
      webDriverConfig.getWaitSleepTime());
  }

  /**
   * <p>This method returns a WebDriver instance.</p>
   *
   * @return a WebDriver object type.
   */
  public WebDriver getWebDriver() {
    return webDriver;
  }

  /**
   * <p>This method returns explicit webDriverWait time.</p>
   *
   * @return a WebDriverWait object type.
   */
  public WebDriverWait getWait() {
    return webDriverWait;
  }

  /**
   * <p>This method closes the browser and all associated windows.</p>
   */
  public void quitDriver() {
    try {
      log.info("Quit driver");
      webDriver.quit();
    } catch (Exception e) {
      log.error("Unable to quit the WebDriver", e);
    }
    webDriver = null;
  }
}
