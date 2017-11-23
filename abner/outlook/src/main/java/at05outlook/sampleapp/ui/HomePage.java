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

/**
 * Is to maping the home page
 */
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

    /**
     * Check if the page is loaded.
     *
     * @return (true or false)
     */
    public boolean isLoadPage() {
        try {
            webDriver.findElement(By.className("o365cs-topnavText"));
            return true;
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    /**
     * Click on the button to load the email form.
     */
    public void goToSedEmail() {
        newBtn.click();
    }

    /**
     * Send to the email with a entities object email
     *
     * @param email is a entities object email.
     */
    public void sendEmailTo(EmailEntities email) {
        emailTxt.clear();
        emailTxt.sendKeys(email.getSendTo());

        subjectTxt.clear();
        subjectTxt.sendKeys(email.getSubject());

        bodyText.clear();
        bodyText.sendKeys(email.getBody());

        sendBtb.click();

        waitPageIsLoaded();
    }


    /**
     * Wait to page is loaded.
     *
     * @throws WebDriverException catch the Web Driver exceptions
     */
    @Override
    public void waitPageIsLoaded() throws WebDriverException {
        wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.id("O365_Lync_ButtonID")));
    }

    /**
     * Performs the exit of the page.
     */
    public void logOut() {
        wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.id("O365_Lync_ButtonID")));
        idUserBtn.click();
        logOutBtn.click();
        webDriver.manage().deleteAllCookies();
    }

    /**
     * Verify That The Mail Has Arrived with email subject.
     *
     * @param subject Email subject.
     * @return (true/false).
     */
    public boolean verifyThatTheMailHasArrived(String subject) {

        try {
            webDriver.findElement(By.xpath("//span[contains(text()," + subject + ")]"));
            return true;
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    /**
     * Search an email with the subject.
     *
     * @param subject email subject.
     */
    public void searchAnEmail(String subject) {
        waitPageIsLoaded();

        //Todo  in prossee.
        List<WebElement> list = webDriver.findElements(By.xpath("//div[starts-with(@class, \"_lvv_w\")  and starts-with(@role, \"option\" ) ]"));
        System.out.println("-------------: " + list.size() + " :-------------------------------");
        listEmailElement = new ArrayList<>();
        for (WebElement we : list) {
            listEmailElement.add(new EmailElement(we));
        }
        System.out.println("---: " + listEmailElement.get(1).getSubject() + " :-----");
//        for(EmailElement emailElement: listEmailElement){
//            System.out.println("---: "+emailElement.getSubject()+" :-----");
//        }
    }
}
