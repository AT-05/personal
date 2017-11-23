package at05outlook.sampleapp.ui;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

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

    /**
     * Wait to page is loaded.
     *
     * @throws WebDriverException catch the Web Driver exceptions
     */
    @Override
    public void waitPageIsLoaded() throws WebDriverException {
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.id("idSIButton9")));
    }

    /**
     * This function is to login in page.
     *
     * @param userName As a Strng email to user.
     * @param pass     is a password to email.
     * @return Home page.
     * @throws InterruptedException atch the exceptions.
     */
    public HomePage login(String userName, String pass) throws InterruptedException {

        setUserName(userName);
        clicLoginButton();
        setUserPass(pass);
        clicPasswordButton();
        clicOpenButton();

        return new HomePage();
    }

    /**
     * Sed the user name.
     *
     * @param name user email.
     */
    private void setUserName(String name) {
        user.clear();
        user.sendKeys(name);
    }

    /**
     * Sed the email password.
     *
     * @param pas password as the email.
     */
    private void setUserPass(String pas) {
        pass.clear();
        pass.sendKeys(pas);
    }

    /**
     * Look for the button and click on the.
     */
    private void clicPasswordButton() {
        btnCommon = webDriver.findElement(By.xpath("//div[4]/div/div/div[2]/input"));
        btnCommon.click();
    }

    /**
     * Look for the button and click on the.
     */
    private void clicOpenButton() {
        btnCommon = webDriver.findElement(By.xpath("//div[2]/input"));
        btnCommon.click();
    }

    /**
     * Look for the button and click on the.
     */
    private void clicLoginButton() {
        btnCommon.click();
    }

    /**
     * Check if the page is loaded.
     *
     * @return (true or false)
     */
    public boolean isLoadPage() {
        try {
            webDriver.findElement(By.id("idSIButton9"));
            return true;
        } catch (NoSuchElementException e) {
            return false;
        }

    }
}
