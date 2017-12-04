package org.fundacionjala.gui.mailapp.ui;

import org.fundacionjala.gui.core.selenium.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Created by German on 11/14/2017.
 */
public abstract class BasedPageObject {

  protected WebDriver webDriver;

  protected WebDriverWait wait;

  /**
   * <p>This constructor initializes driver and wait and web elements.</p>
   */
  public BasedPageObject() {
    webDriver = WebDriverManager.getInstance().getWebDriver();
    wait = WebDriverManager.getInstance().getWait();
    PageFactory.initElements(webDriver, this);
  }

  /**
   * <p>This method wait for correct loading of pages.</p>
   *
   * @throws WebDriverException when pages doesn't load correctly.
   */
  public abstract void waitPageIsLoaded() throws WebDriverException;
}
