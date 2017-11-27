package courses.sampleapp;

import courses.core.selenium.WebDriverConfig;
import courses.core.selenium.WebDriverManager;
import java.io.File;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import courses.sampleapp.config.SampleAppEnvsConfig;


public class SampleAppAutomation {

  private Logger log = Logger.getLogger(getClass());
  private WebDriverConfig webDriverConfig;
  private SampleAppEnvsConfig sampleAppEnvsConfig;

  private static final String webDriverConfigFilename =
      System.getProperty("user.dir") + File.separator + "driverConfig.json";
  private static final String sampleAppEnvsConfigFileName =
      System.getProperty("user.dir") + File.separator + "environments.json";

  private static SampleAppAutomation instance;

  private SampleAppAutomation() {
    PropertyConfigurator.configure("log.properties");
    webDriverConfig.getInstance().initialize(webDriverConfigFilename);
    sampleAppEnvsConfig.getInstance().initialize(sampleAppEnvsConfigFileName);
  }

  public static SampleAppAutomation getInstance() {
    if (instance == null) {
      instance = new SampleAppAutomation();
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
