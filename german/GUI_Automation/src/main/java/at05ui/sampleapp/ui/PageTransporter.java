package at05ui.sampleapp.ui;


import at05ui.core.selenium.WebDriverManager;
import at05ui.sampleapp.config.SampleAppEnvsConfig;
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

  public LoginPage navigateToLoginPage() {
    goToURL(baseURL);
    return new LoginPage();
  }


  public InboxPage navigateToInboxPage() {
    goToURL(baseURL);
    return new InboxPage();
  }
}
