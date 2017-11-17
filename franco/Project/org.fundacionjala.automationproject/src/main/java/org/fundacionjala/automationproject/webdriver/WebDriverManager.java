package org.fundacionjala.automationproject.webdriver;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Created by Franco Aldunate on 11/13/2017.
 */
public class WebDriverManager {
  private WebDriverConfig webDriverConfig = WebDriverConfig.getInstance();
  private WebDriver webDriver;
  private WebDriverWait webDriverWait;
  private static WebDriverManager instance = null;

  /**
   * <p>This constructor verifies if the Singleton class
   * already exists.</p>
   */
  protected WebDriverManager() {

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
   */
  public void initWebDriver(final WebDriverConfig webDriverConfig) {
    webDriver = WebDriverFactory.getWebDriver(webDriverConfig);
    initConfiguration();
  }

  /**
   * <p>This method initializes implicit and explicit web driver opening timeout.</p>
   */
  public void configureTimeOuts() {
    webDriver.manage().timeouts().implicitlyWait(webDriverConfig.getImplicitWaitTime(), TimeUnit.SECONDS);
    webDriverWait = new WebDriverWait(webDriver, webDriverConfig.getExplicitWaitTime(), webDriverConfig.getWaitSleepTime());
  }

  /**
   * <p>This method initializes web driver configuration.</p>
   */
  public void initConfiguration() {
    webDriver.manage().window().maximize();
    configureTimeOuts();
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
  public WebDriverWait getWebDriverWait() {
    return webDriverWait;
  }

  /**
   * <p>This method closes the current web page.</p>
   */
  public void quitPage() {
    if (webDriver != null) {
      webDriver.quit();
    }
    webDriver = null;
  }

  /**
   * <p>This method closes the browser and all associated windows.</p>
   */
  public void closeBrowser() {
    if (webDriver != null) {
      webDriver.close();
    }
    webDriver = null;
  }
}
