package at05outlook.core.selenium.webdrivers;

import at05outlook.core.selenium.WebDriverConfig;

import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.WebDriver;

public final class DriverFactory {
    private static final String FIREFOX = "firefox";
    private static final String CHROME = "chrome";

    private DriverFactory() {
    }

    public static WebDriver getDriver(final WebDriverConfig webDriverConfig) {
        Map<String, IDriver> strategyBrowser = new HashMap<>();
        strategyBrowser.put(FIREFOX, new FireFox());
        strategyBrowser.put(CHROME, new Chrome());
        System.out.println(webDriverConfig.getBrowser());
        return strategyBrowser.get(webDriverConfig.getBrowser().toLowerCase()).initDriver();
    }
}
