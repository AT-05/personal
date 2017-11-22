package at05outlook.sampleapp.ui;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;

public class EmailElement extends BasedPageObject {

    private WebElement emailBody;
    private WebElement check;

    private String toSend;
    private String subject;
    private String body;


    public EmailElement(WebElement emailBody){
        this.emailBody=emailBody;
        obtainSubject();
    }

    private void obtainCheck(){
       check= emailBody.findElement(By.xpath(""));
    }

    private void obtainSubject(){
        emailBody.findElement(By.xpath("//span[contains(@class, \"lvHighlightSubjectClass\")]"));
        subject= emailBody.getText();
    }

    public String getSubject() {
        return subject;
    }

    @Override
    public void waitPageIsLoaded() throws WebDriverException {

    }
}
