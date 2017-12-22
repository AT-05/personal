package at05outlook.core.selenium;

import at05outlook.core.utils.JsonReader;
import org.apache.log4j.Logger;

public class WebDriverConfig {
    private Logger log = Logger.getLogger(getClass());

    private static final String BROWSER = "browser";
    private static final String DRIVER = "web driver";
    private static final String IMPLICIT_WAIT_TIME = "implicit wait time";
    private static final String EXPLICIT_WAIT_TIME = "explicit wait time";
    private static final String WAIT_SLEEP_TIME = "wait sleep time";

    private JsonReader configReader;

    private String browser;
    private int implicitWaitTime;
    private int explicitWaitTime;
    private int waitSleepTime;

    private static WebDriverConfig instance;

    protected WebDriverConfig() {

    }

    public static WebDriverConfig getInstance() {
        if (instance == null) {
            instance = new WebDriverConfig();
        }
        return instance;
    }

    public void initialize(String webDriverConfigFilename) {
        log.info("Read the driver configuration settings");
        configReader = new JsonReader(webDriverConfigFilename);
        browser = configReader.getKeyValue(DRIVER, BROWSER);
        implicitWaitTime = Integer.valueOf(configReader.getKeyValue(DRIVER, IMPLICIT_WAIT_TIME));
        explicitWaitTime = Integer.valueOf(configReader.getKeyValue(DRIVER, EXPLICIT_WAIT_TIME));
        waitSleepTime = Integer.valueOf(configReader.getKeyValue(DRIVER, WAIT_SLEEP_TIME));
    }

    public String getBrowser() {
        return browser;
    }

    public int getImplicitWaitTime() {
        return implicitWaitTime;
    }

    public int getExplicitWaitTime() {
        return explicitWaitTime;
    }

    public int getWaitSleepTime() {
        return waitSleepTime;
    }
}
