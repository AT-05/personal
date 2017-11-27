package courses.core.selenium;

import courses.core.selenium.webdrivers.DriverFactory;
import java.util.concurrent.TimeUnit;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WebDriverManager {

  private Logger log = Logger.getLogger(getClass());
  private courses.core.selenium.WebDriverConfig webDriverConfig = WebDriverConfig.getInstance();
  private WebDriver webDriver;
  private WebDriverWait webDriverWait;

  private static WebDriverManager instance = null;

  private static final String FIREFOX = "firefox";
  private static final String CHROME = "chrome";


  protected WebDriverManager() {
    initialize(webDriverConfig);
    log.info("WebDriverManager constructor");
  }

  public static WebDriverManager getInstance() {
    if (instance == null || instance.webDriver == null) {
      instance = new WebDriverManager();
    }
    return instance;
  }

  public void initialize(final WebDriverConfig webDriverConfig) {
    log.info("Initializing web driver");
    this.webDriver = DriverFactory.getDriver(webDriverConfig);

    this.webDriver.manage().window().maximize();
    this.webDriver.manage().timeouts()
        .implicitlyWait(webDriverConfig.getImplicitWaitTime(), TimeUnit.SECONDS);
    webDriverWait = new WebDriverWait(webDriver, webDriverConfig.getExplicitWaitTime(),
        webDriverConfig.getWaitSleepTime());
  }

  /**
   * Gets the WebDriver
   */
  public WebDriver getWebDriver() {
    return webDriver;
  }

  /**
   * Gets the WebDriver Wait
   */
  public WebDriverWait getWait() {
    return webDriverWait;
  }

  /**
   * Closes all the browser instances
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
