package at05outlook.sampleapp.ui;

import at05outlook.sampleapp.SampleAppAutomation;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class HomePage extends BasedPageObject {

    @FindBy(id = "_ariaId_21")
    @CacheLookup
    private WebElement newBtn;

    @FindBy(xpath = "//input")
    @CacheLookup
    private WebElement emailTxt;

    @FindBy(xpath = "//div/input")
    @CacheLookup
    private WebElement subjectTxt;

    @FindBy(xpath = "//div[starts-with(@class, 'allowTextSelection')  and starts-with(@role, 'textbox' ) ]")
    @CacheLookup
    private WebElement bodyText;


    @FindBy(id = "O365_MeFlexPane_ButtonID")
    private WebElement idUserBtn;


    @FindBy(id = "O365_SubLink_ShellSignout")
    private WebElement logOutBtn;





    @FindBy(xpath = "//div[5]/div/div[2]/div/button")

    private WebElement sendBtb;


    public boolean isLoadPage() {
        try {
            webDriver.findElement(By.className("o365cs-topnavText"));
            return true;
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    public void goToSedEmail() {
        newBtn.click();
    }

    public void sendEmailTo(String enail, String suject, String body) {
        emailTxt.clear();
        emailTxt.sendKeys(enail);

        subjectTxt.clear();
        subjectTxt.sendKeys(suject);


        sendBtb.findElement(By.xpath("(//button[@type='button'])[171]"));
        sendBtb.click();

        webDriver.navigate().refresh();
//        receivedEmail.findElement(By.xpath("//div[5]/div[2]/div[4]/div[3]/span/span"));
//
//        System.out.println( "El texto es: "+receivedEmail.getText());

    }

    @Override
    public void waitPageIsLoaded() throws WebDriverException {

    }

    public void logOut() {
        wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.id("O365_Lync_ButtonID")));
        idUserBtn.click();
        logOutBtn.click();

    }


}
