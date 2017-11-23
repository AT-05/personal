package at05outlook.core.selenium.webdrivers;

import io.github.bonigarcia.wdm.ChromeDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

class Chrome implements IDriver {
    private static Chrome instance = null;
    private WebDriver driver;
    private WebDriverWait wait;

    public static Chrome getInstance() {
        if (instance == null || instance.driver == null) {
            instance = new Chrome();
        }
        return instance;
    }

    @Override
    public WebDriver initDriver() {
        ChromeDriverManager.getInstance().setup();
        return new ChromeDriver();
    }
}
