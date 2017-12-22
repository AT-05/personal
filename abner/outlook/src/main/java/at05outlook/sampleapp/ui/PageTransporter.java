package at05outlook.sampleapp.ui;

import at05outlook.core.selenium.WebDriverManager;
import at05outlook.sampleapp.config.SampleAppEnvsConfig;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;

/**
 * It is the link between the pages and the steps
 */
public class PageTransporter {

  private Logger log = Logger.getLogger(getClass());
  private String baseURL = SampleAppEnvsConfig.getInstance().getUrl();
  private WebDriver webDriver = WebDriverManager.getInstance().getWebDriver();
  private static PageTransporter instance;

  /**
   * Constuct of the object.
   */
  protected PageTransporter() {
    initialize();
  }
  /**
   * Is return the object singleton.
   * @return singleton object.
   */
  public static PageTransporter getInstance() {
    if (instance == null) {
      instance = new PageTransporter();
    }
    return instance;
  }

  /**
   * Initialize the element to roun.
   */
  private void initialize() {
    log.info("Initialize the page transporter");
  }

  /**
   * t is to navigate of URL.
   * @param url is the path to navigation.
   */
  private void goToURL(String url) {
    webDriver.navigate().to(url);
  }

  /**
   * It si to return the URL
   * @return Url current.
   */
  public String getCurrentURL() {
    return webDriver.getCurrentUrl();
  }

  /**
   * verify if the page on off.
   * @return
   */
  public Boolean isOnWeb() {
    return (webDriver.getCurrentUrl().contains(baseURL));
  }

  /**
   * I is to go at home page.
   * @return
   */
  public HomePage navigateToMainPage() {
    goToURL(baseURL);
    return new HomePage();
  }
}
