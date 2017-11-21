package at05outlook.sampleapp.ui;

import at05outlook.core.selenium.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public abstract class BasedPageObject {

  public WebDriver webDriver;

  public WebDriverWait wait;

  public BasedPageObject() {
    webDriver = WebDriverManager.getInstance().getWebDriver();
    wait = WebDriverManager.getInstance().getWait();
    PageFactory.initElements(webDriver,this);
  }

  public abstract void waitPageIsLoaded() throws WebDriverException;
}
