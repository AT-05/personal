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

    @FindBy(className = "allowTextSelection _mcp_32")
    @CacheLookup
    private WebElement bodyText;


    @FindBy(id = "O365_MeFlexPane_ButtonID")
    private WebElement idUserBtn;


    @FindBy(id = "_ariaId_279")
    private WebElement logOutBtn;


    private WebElement receivedEmail;


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

    public void logOut() throws Exception {
        //SampleAppAutomation.getInstance().shutDown();
    }

    public void logOut2() {
        System.out.println("***************************Buscando el boton");
        //wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy( By.id("O365_MeFlexPane_ButtonID")));
        wait.until(ExpectedConditions.visibilityOfElementLocated( By.id("O365_MeFlexPane_ButtonID")));
        System.out.println("Boton encontrado ");
        idUserBtn.findElement(By.id("O365_MeFlexPane_ButtonID"));
        //idUserBtn.findElement(By.xpath("//div[13]/div/div/button"));
        idUserBtn.click();
        System.out.println("----------------------Cerrando "+idUserBtn.getText());

        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.id("toolbox-close")));
        logOutBtn.findElement(By.id("toolbox-close"));
        logOutBtn.click();

    }
}
