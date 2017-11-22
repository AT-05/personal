package org.fundacionjala.automationproject.ui;

import org.apache.log4j.Logger;
import org.fundacionjala.automationproject.config.EnvironmentConfig;
import org.fundacionjala.automationproject.webdriver.WebDriverManager;
import org.openqa.selenium.WebDriver;

/**
 * Created by Franco Aldunate on 11/14/2017.
 */
public class PageTransporter {
  private Logger log = Logger.getLogger(getClass());
  private String baseURL = EnvironmentConfig.getInstance().getBaseUrl();
  private WebDriver webDriver = WebDriverManager.getInstance().getWebDriver();

  private static PageTransporter instance;

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
    System.out.println(url);
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
   * @return is the specific url.
   */
  public Boolean isOnWeb() {
    return (webDriver.getCurrentUrl().contains(baseURL));
  }

  /**
   * <p>This method sends to Main Page.</p>
   *
   * @return a MainPage object type.
   */
  public MainPage navigateToMainPage() {
    goToURL(baseURL);
    return new MainPage();
  }

  /**
   * <p>This method sends to Main Page.</p>
   *
   * @return a MainPage object type.
   */
  public MainPage getMainPage() {
    goToURL(getCurrentURL());
    return new MainPage();
  }

  /**
   * <p>This method sends to Home Page.</p>
   *
   * @return a HomePage object type.
   */
  public HomePage getHomePage() {
    goToURL(getCurrentURL());
    return new HomePage();
  }

  /**
   * <p>This method sends to Reservation Page.</p>
   *
   * @return a ReservationPage object type.
   */
  public ReservationPage getReservationPage() {
    goToURL(getCurrentURL());
    return new ReservationPage();
  }

  /**
   * <p>This method sends to Purchase Page.</p>
   *
   * @return a PurchasePage object type.
   */
  public PurchasePage getPurchasePage() {
    goToURL(getCurrentURL());
    return new PurchasePage();
  }
}
