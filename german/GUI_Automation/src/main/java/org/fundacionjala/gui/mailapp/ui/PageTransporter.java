package org.fundacionjala.gui.mailapp.ui;


import org.apache.log4j.Logger;
import org.fundacionjala.gui.core.selenium.WebDriverManager;
import org.fundacionjala.gui.mailapp.config.SampleAppEnvsConfig;
import org.openqa.selenium.WebDriver;

/**
 * Created by German on 11/14/2017.
 */
public class PageTransporter {

  private static PageTransporter instance;
  private Logger log = Logger.getLogger(getClass());
  private String baseURL = SampleAppEnvsConfig.getInstance().getUrl();
  private WebDriver webDriver = WebDriverManager.getInstance().getWebDriver();

  /**
   * <p>This constructor shows transporter initialization.</p>
   */
  protected PageTransporter() {
    initialize();
  }

  /**
   * <p>This method returns the instance of the class.</p>
   *
   * @return a unique instance of this class.
   */
  public static PageTransporter getInstance() {
    if (instance == null) {
      instance = new PageTransporter();
    }
    return instance;
  }

  /**
   * <p>This constructor shows log of transporter initialization.</p>
   */
  private void initialize() {
    log.info("Initialize the page transporter");
  }

  /**
   * <p>This method sends the web driver to url.</p>
   *
   * @param url is the target url.
   */
  private void goToURL(String url) {
    webDriver.navigate().to(url);
  }

  /**
   * <p>This method returns the web driver current url.</p>
   *
   * @return is the url direction.
   */
  public String getCurrentURL() {
    return webDriver.getCurrentUrl();
  }

  /**
   * <p>This method returns if the web driver is on a certain url.</p>
   *
   * @return a  boolean.
   */
  public Boolean isOnWeb() {
    return (webDriver.getCurrentUrl().contains(baseURL));
  }

  /**
   * <p>This method returns if the web driver is on  Inbox.</p>
   *
   * @return a boolean.
   */
  public Boolean isOnInbox() {
    return (webDriver.getCurrentUrl().contains("inbox"));
  }

  /**
   * <p>This method navigate to Login Page.</p>
   *
   * @return a LoginPage object type.
   */
  public LoginPage navigateToLoginPage() {
    goToURL(baseURL);
    return new LoginPage();
  }

  /**
   * <p>This method navigate to Inbox Page.</p>
   *
   * @return a Inbox page object type.
   */
  public InboxPage navigateToInboxPage() {
    goToURL(baseURL);
    return new InboxPage();
  }
}
