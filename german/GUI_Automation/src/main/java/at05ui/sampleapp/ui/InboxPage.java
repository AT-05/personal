package at05ui.sampleapp.ui;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import static org.openqa.selenium.Keys.*;

/**
 * Created by Administrator on 11/17/2017.
 */
public class InboxPage extends BasedPageObject{
  @FindBy(id=":21")
  WebElement mainInbox;
  @FindBy(xpath = "//*[@class='T-I J-J5-Ji T-I-KE L3']")
  WebElement composeBtn;

  @FindBy(xpath = "//*[@id=\":8n\"]")
  WebElement sendBtn;


  @FindBy(name = "to") //name= to
  WebElement addressBox;
  @FindBy(name="subjectbox")
  WebElement subjectBox;
  @FindBy(xpath = "//*[@class='Am Al editable LW-avf']")
  WebElement bobyTex;

  public boolean isInboxPage() {

    waitPageIsLoaded();
    return this.webDriver.getCurrentUrl().contains("inbox");
  }

  @Override
  public void waitPageIsLoaded() throws WebDriverException {
    wait.until(ExpectedConditions.urlContains("inbox"));
  }
  public void sendMail(String toAddress,String subject,String body){
    //click on Compose button

   clickCompose();

    //enter TO address & Subject
    wait.until(ExpectedConditions.visibilityOf(addressBox));
    System.out.print("\nto address founded \n");
    addressBox.sendKeys(toAddress);
    subjectBox.sendKeys(subject);
    bobyTex.sendKeys(body);
    bobyTex.sendKeys(CONTROL,ENTER);



    //click Send button
    //clickSend();


  }
  public void clickCompose(){
    wait.until(ExpectedConditions.visibilityOf(composeBtn));
     composeBtn.click();
  }
  public void clickSend(){
    //wait.until(ExpectedConditions.visibilityOf(sendBtn));
    sendBtn.click();
  }
}
