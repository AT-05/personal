package at05ui.core.selenium;

import at05ui.core.utils.JsonReader;
import org.apache.log4j.Logger;

import java.io.File;

public class WebDriverConfig {
    private Logger log = Logger.getLogger(getClass());

    private static final String BROWSER = "browser";
    private static final String BROWSER_NAME = System.getProperty("browserName");
    private static final String DRIVER = "web driver";
    private static final String IMPLICIT_WAIT_TIME = "implicit wait time";
    private static final String EXPLICIT_WAIT_TIME = "explicit wait time";
    private static final String WAIT_SLEEP_TIME = "wait sleep time";

    private JsonReader configReader;

    private String browser;
    private int implicitWaitTime;
    private int explicitWaitTime;
    private int waitSleepTime;

    private static WebDriverConfig instance=null;
    private static final String webDriverConfigFilename = System.getProperty("user.dir") + File.separator  + "driverConfig.json";
    protected WebDriverConfig() {
initialize(webDriverConfigFilename);
    }

    public static WebDriverConfig getInstance() {
        if(instance == null) {
            instance = new WebDriverConfig();
        }
        return instance;
    }

    public void initialize(String webDriverConfigFilename) {
        log.info("Read the driver configuration settings");
        configReader = new JsonReader(webDriverConfigFilename);
//        browser = configReader.getKeyValue(DRIVER, BROWSER);
        browser = System.getProperty("browserName");
        implicitWaitTime = Integer.valueOf(configReader.getKeyValue(DRIVER, IMPLICIT_WAIT_TIME));
        explicitWaitTime = Integer.valueOf(configReader.getKeyValue(DRIVER, EXPLICIT_WAIT_TIME));
        waitSleepTime = Integer.valueOf(configReader.getKeyValue(DRIVER, WAIT_SLEEP_TIME));
    }

    public String getBrowser() {
        return browser;
    }

    public int getImplicitWaitTime() {
        return  implicitWaitTime;
    }

    public int getExplicitWaitTime() {
        return  explicitWaitTime;
    }

    public int getWaitSleepTime() {
        return  waitSleepTime;
    }
}
