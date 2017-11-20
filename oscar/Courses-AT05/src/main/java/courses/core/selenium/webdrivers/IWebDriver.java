package courses.core.selenium.webdrivers;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Created by Administrator on 11/13/2017.
 */
public interface IWebDriver {

  WebDriver initDriver();

  void openUrl(String url);

  void quitBrowser();

  WebDriver getDriver();

  WebDriverWait getWait();
}
