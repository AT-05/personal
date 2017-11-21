package at05outlook.core.selenium;


import at05outlook.core.selenium.webdrivers.DriverFactory;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class WebDriverManager {

    private Logger log = Logger.getLogger(getClass());
    private WebDriverConfig webDriverConfig = WebDriverConfig.getInstance();
    private WebDriver webDriver;
    private WebDriverWait webDriverWait;

    private static WebDriverManager instance = null;

    private static final String FIREFOX = "firefox";
    private static final String CHROME = "chrome";


    protected WebDriverManager() {
        initialize(webDriverConfig);
    }

    public static WebDriverManager getInstance() {
        if(instance == null || instance.webDriver == null) {
            instance = new WebDriverManager();
        }
        return instance;
    }

    public void initialize(final WebDriverConfig webDriverConfig) {
        log.info("Initializing web driver");
        this.webDriver = DriverFactory.getDriver(webDriverConfig);

        this.webDriver.manage().window().maximize();
        this.webDriver.manage().timeouts().implicitlyWait(webDriverConfig.getImplicitWaitTime(), TimeUnit.SECONDS);
        webDriverWait = new WebDriverWait(webDriver, webDriverConfig.getExplicitWaitTime(), webDriverConfig.getWaitSleepTime());
    }

    /**
     * Gets the WebDriver
     * @return
     */
    public WebDriver getWebDriver() {
        return webDriver;
    }

    /**
     * Gets the WebDriver Wait
     * @return
     */
    public WebDriverWait getWait() {
        return webDriverWait;
    }

    /**
     * Closes all the browser instances
     */
    public void quitDriver() {
        try {
            log.info("Quit driver");
            webDriver.quit();
        } catch (Exception e) {
            log.error("Unable to quit the WebDriver", e);
        }
        webDriver = null;
    }
}
