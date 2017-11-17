package org.fundacionjala.automationproject.ui;

import org.fundacionjala.automationproject.webdriver.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Created by Franco Aldunate on 11/14/2017.
 */
public abstract class BasePage {
  protected final WebDriver driver;
  protected final WebDriverWait wait;

  /**
   * <p>This constructor initializes driver and wait and web elements.</p>
   */
  public BasePage() {
    driver = WebDriverManager.getInstance().getWebDriver();
    wait = WebDriverManager.getInstance().getWebDriverWait();
    PageFactory.initElements(driver, this);
  }

  /**
   * <p>This pages returns the driver instance.</p>
   *
   * @return the instance of WebDriver.
   */
  public WebDriver getDriver() {
    return driver;
  }

  /**
   * <p>This method checks for correct loading of pages.</p>
   *
   * @throws WebDriverException when pages doesn't load correctly.
   */
  public abstract void waitUntilPageObjectIsLoaded() throws WebDriverException;
}
