package at05outlook.sampleapp.ui;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

/***
 * Is to maping the login page
 */
public class LoginPage extends BasedPageObject {

    @FindBy(id = "i0116")
    @CacheLookup
    private WebElement user;

    @FindBy(id = "i0118")
    @CacheLookup
    private WebElement pass;

    @FindBy(id = "idSIButton9")
    @CacheLookup
    private WebElement btnCommon;

    @FindBy(id = "idSIButton9")
    @CacheLookup
    private WebElement btnPass;

    @FindBy(id = "idSIButton9")
    @CacheLookup
    private WebElement btnKeepSession;


    public LoginPage() {
        super();
    }

    @Override
    public void waitPageIsLoaded() throws WebDriverException {

    }


    public HomePage login(String userName, String pass) throws InterruptedException {

        setUserName(userName);
        clicLoginButton();
        setUserPass(pass);
        clicPasswordButton();
        clicOpenButton();

        return new HomePage();
    }

    private void setUserName(String name) {
        user.clear();
        user.sendKeys(name);
    }

    private void setUserPass(String pas) {
        pass.clear();
        pass.sendKeys(pas);
    }

    private void clicPasswordButton() {
        btnCommon = webDriver.findElement(By.xpath("//div[4]/div/div/div[2]/input"));
        btnCommon.click();
    }


    private void clicOpenButton() {
        btnCommon = webDriver.findElement(By.xpath("//div[2]/input"));
        btnCommon.click();
    }

    private void clicLoginButton() {
        //TOdo find element
        btnCommon.click();
    }


    public boolean isLoadPage() {
        try {
            webDriver.findElement(By.id("idSIButton9"));
            return true;
        } catch (NoSuchElementException e) {
            return false;
        }

    }
}
