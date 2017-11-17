package core.selenium.webdrivers;

import io.github.bonigarcia.wdm.FirefoxDriverManager;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.firefox.internal.ProfilesIni;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Created by Administrator on 11/13/2017.
 */
public class FirefoxWebDriver implements IWebDriver {

  private static WebDriver driver;
  private static FirefoxWebDriver instance = null;
  private static WebDriverWait wait;

  /**
   * Static method for instance a FirefoxWebDriver.
   *
   * @return the instance.
   */
  public static FirefoxWebDriver getInstance() {
    if (instance == null) {
      instance = new FirefoxWebDriver();
      FirefoxDriverManager.getInstance().version("").setup();
      //System.setProperty("webdriver.firefox.marionette","pathToGeckodriver");
      //System.setProperty("webdriver.gecko.driver","pathToGeckodriver");

      ProfilesIni allProfiles = new ProfilesIni();
      FirefoxProfile profile = allProfiles.getProfile("default");
      DesiredCapabilities capabilities = DesiredCapabilities.firefox();
      capabilities.setCapability("marionette", false);
      capabilities.setCapability(FirefoxDriver.PROFILE, profile);
      driver = new FirefoxDriver(capabilities);
      //driver = new FirefoxDriver();
      //wait = new WebDriverWait(driver, driverConfig.getExplicitWaitTime(), driverConfig.getWaitSleepTime());
      wait = new WebDriverWait(driver, 10);
    }
    return instance;
  }

  /**
   * Instance the driver for firefox using the plugin.
   *
   * @return the WebDriver.
   */
  @Override
  public WebDriver initDriver() {
    FirefoxDriverManager.getInstance().setup();
    driver = new FirefoxDriver();
    driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
    wait = new WebDriverWait(driver, 30, 500);
    return driver;
  }

  /**
   * Open a URL.
   *
   * @param url of the web.
   */
  @Override
  public void openUrl(String url) {
    driver.get(url);
    //driver.manage().window().maximize();
  }

  /**
   * Close the driver.
   */
  @Override
  public void quitBrowser() {
    if (driver != null) {
      driver.quit();
      instance = null;
    }
  }

  /**
   * Return the driver.
   *
   * @return WebDriver.
   */
  @Override
  public WebDriver getDriver() {
    return driver;
  }

  /**
   * Return the wait.
   *
   * @return WebDriverWait.
   */
  @Override
  public WebDriverWait getWait() {
    return wait;
  }
}
