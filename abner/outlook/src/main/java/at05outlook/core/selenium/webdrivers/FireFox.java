package at05outlook.core.selenium.webdrivers;

import io.github.bonigarcia.wdm.FirefoxDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

class FireFox implements IDriver {

    @Override
    public WebDriver initDriver() {
        FirefoxDriverManager.getInstance().setup();
        return new FirefoxDriver();
    }
}
