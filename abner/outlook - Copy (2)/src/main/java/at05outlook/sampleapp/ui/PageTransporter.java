package at05outlook.sampleapp.ui;


import at05outlook.core.selenium.WebDriverManager;
import at05outlook.sampleapp.config.SampleAppEnvsConfig;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;

public class PageTransporter {

  private Logger log = Logger.getLogger(getClass());
  private String baseURL = SampleAppEnvsConfig.getInstance().getUrl();
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

  private void goToURL(String url) {
    webDriver.navigate().to(url);
  }

  public String getCurrentURL() {
    return webDriver.getCurrentUrl();
  }


  public Boolean isOnWeb() {
    return (webDriver.getCurrentUrl().contains(baseURL));
  }

  /*public LoginPage navigateToLoginPage() {
    goToURL(baseURL);
    return new LoginPage();
  }*/


  public HomePage navigateToMainPage() {
    goToURL(baseURL);
    return new HomePage();
  }
}
