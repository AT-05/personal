package courses.sampleapp.ui;

import courses.core.selenium.WebDriverManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import courses.sampleapp.config.SampleAppEnvsConfig;

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

  public PrincipalPage navigateToPrincipalPage() {
    goToURL(baseURL);
    return new PrincipalPage();
  }
}
