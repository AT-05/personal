package org.fundacionjala.automationproject.ui;

import org.apache.log4j.Logger;
import org.fundacionjala.automationproject.config.EnvironmentConfig;
import org.fundacionjala.automationproject.webdriver.WebDriverManager;
import org.openqa.selenium.WebDriver;

public class PageTransporter {
  private Logger log = Logger.getLogger(getClass());
  private String baseURL = EnvironmentConfig.getInstance().getBaseUrl();
  private WebDriver webDriver = WebDriverManager.getInstance().getWebDriver();

  private static PageTransporter instance;

  protected PageTransporter() {
    initialize();
  }

  public static PageTransporter getInstance() {
    if (instance == null) {
      instance = new PageTransporter();
    }
    return instance;
  }

  private void initialize() {
    log.info("Initialize the page transporter");
  }

  public void goToURL(String url) {
    webDriver.navigate().to(url);
  }

  public String getCurrentURL() {
    return webDriver.getCurrentUrl();
  }

  public Boolean isOnWeb() {
    return (webDriver.getCurrentUrl().contains(baseURL));
  }

  public void navigateToMainPage() {
    goToURL(baseURL);
  }
}
