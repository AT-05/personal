package at05ui.sampleapp.ui;

import at05ui.core.selenium.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Created by Marco Mendez November 2017.
 */
public abstract class BasedPageObject {

  public WebDriver webDriver;

  public WebDriverWait wait;

  /**
   * Constructor of the class BasePageObject.
   */
  public BasedPageObject() {
    webDriver = WebDriverManager.getInstance().getWebDriver();
    wait = WebDriverManager.getInstance().getWait();
    PageFactory.initElements(webDriver, this);
  }

  /**
   * Method abstract.
   *
   * @throws WebDriverException exception.
   */
  public abstract void waitPageIsLoaded() throws WebDriverException;

  /**
   * Quit WebDriver.
   */
  public void quit() {
    webDriver.quit();
  }

  /**
   * Method close WebDriver.
   */
  public void close() {
    webDriver.close();
  }
}
