package at05outlook.sampleapp.ui;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;

/**
 * This class  model an email how a web element.
 */
public class EmailElement extends BasedPageObject {

    private WebElement emailBody;
    private WebElement check;
    private String toSend;
    private String subject;
    private String body;

    /**
     * Construct the object.
     * @param emailBody is the main web element of the email list.
     */
    public EmailElement(WebElement emailBody){
        this.emailBody=emailBody;
        obtainSubject();
    }

    /**
     * Obtain the check elemte of the email.
     */
    private void obtainCheck(){
       check= emailBody.findElement(By.xpath(""));
    }

    /**
     * Obtain the subject.
     */
    private void obtainSubject(){
        emailBody.findElement(By.xpath("//span[contains(@class, \"lvHighlightSubjectClass\")]"));
        subject= emailBody.getText();
    }

    /**
     * Return the subject as a String.
     * @return subject as a String.
     */
    public String getSubject() {
        return subject;
    }

    /**
     * Wait to componente is ready.
     *
     * @throws WebDriverException catch the Web Driver exceptions
     */
    @Override
    public void waitPageIsLoaded() throws WebDriverException {

    }
}
