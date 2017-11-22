package at05ui.sampleapp;


import at05ui.core.selenium.WebDriverConfig;
import at05ui.core.selenium.WebDriverManager;
import at05ui.sampleapp.config.SampleAppEnvsConfig;
import java.io.File;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;


public class AutomationPracticeApp {

  private Logger log = Logger.getLogger(getClass());
  private WebDriverConfig webDriverConfig;
  private SampleAppEnvsConfig sampleAppEnvsConfig;

  private static final String webDriverConfigFilename =
      System.getProperty("user.dir") + File.separator + "driverConfig.json";
  private static final String sampleAppEnvsConfigFileName =
      System.getProperty("user.dir") + File.separator + "environments.json";

  private static AutomationPracticeApp instance;

  private AutomationPracticeApp() {
    PropertyConfigurator.configure("log.properties");
    webDriverConfig.getInstance().initialize(webDriverConfigFilename);
    sampleAppEnvsConfig.getInstance().initialize(sampleAppEnvsConfigFileName);
  }

  public static AutomationPracticeApp getInstance() {
    if (instance == null) {
      instance = new AutomationPracticeApp();
    }
    return instance;
  }

  public void startUp() throws Exception {
    WebDriverManager.getInstance().initialize(webDriverConfig);
  }

  public void shutDown() throws Exception {
    WebDriverManager.getInstance().quitDriver();
  }
}
