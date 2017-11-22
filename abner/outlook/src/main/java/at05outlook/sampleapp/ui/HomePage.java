package at05outlook.sampleapp.ui;

import at05outlook.sampleapp.SampleAppAutomation;
import at05outlook.sampleapp.entities.EmailEntities;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.ArrayList;
import java.util.List;

public class HomePage extends BasedPageObject {

    List<EmailElement> listEmailElement;

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
        //waitPageIsLoaded();
        newBtn.click();
    }

    public void sendEmailTo(EmailEntities email) {
        emailTxt.clear();
        emailTxt.sendKeys(email.getSendTo());

        subjectTxt.clear();
        subjectTxt.sendKeys(email.getSubject());

        bodyText.clear();
        bodyText.sendKeys(email.getBody());

        sendBtb.findElement(By.xpath("(//button[@type='button'])[171]"));
        sendBtb.click();

        webDriver.navigate().refresh();

    }



    @Override
    public void waitPageIsLoaded() throws WebDriverException {
        wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.id("O365_Lync_ButtonID")));
    }

    public void logOut() {
        wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.id("O365_Lync_ButtonID")));
        idUserBtn.click();
        logOutBtn.click();
        webDriver.manage().deleteAllCookies();
    }

    public boolean verifyThatTheMailHasArrived(String subject) {
        waitPageIsLoaded();
        try {
            webDriver.findElement(By.xpath("//span[contains(text(),\""+subject+"\")]"));
            return true;
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    public void searchAnEmail(String subject) {
        waitPageIsLoaded();

        //Todo  in prossee.
        List<WebElement> list = webDriver.findElements(By.xpath("//div[starts-with(@class, \"_lvv_w\")  and starts-with(@role, \"option\" ) ]"));

        System.out.println("---------------------: "+list.size()+" :-------------------------------");

        listEmailElement=new ArrayList<>();

        for(WebElement we: list){
            listEmailElement.add(new EmailElement(we));
        }

        System.out.println("---: "+listEmailElement.get(1).getSubject()+" :-----");

//        for(EmailElement emailElement: listEmailElement){
//            System.out.println("---: "+emailElement.getSubject()+" :-----");
//        }


    }
}
