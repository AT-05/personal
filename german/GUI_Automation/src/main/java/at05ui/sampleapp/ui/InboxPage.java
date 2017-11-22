package at05ui.sampleapp.ui;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

import static org.openqa.selenium.Keys.CONTROL;
import static org.openqa.selenium.Keys.ENTER;

/**
 * Created by Administrator on 11/17/2017.
 */
public class InboxPage extends BasedPageObject {
  @FindBy(id = ":21")
  WebElement mainInbox;


  @FindBy(xpath = "//*[@class='T-I J-J5-Ji T-I-KE L3']")
  WebElement composeBtn;

  @FindBy(xpath = ".//*[@id=':5']/div[2]/div[1]/div/div[2]/div[3]/div/div")
  WebElement deleteBtn;
  @FindBy(xpath = "//*[@class='gb_bb gbii']")
  WebElement userBtn;
  @FindBy(id = "gb_71")
  WebElement signOutBtn;


  @FindBy(xpath = "//*[@id=\":8n\"]")
  WebElement sendBtn;


  @FindBy(name = "to") //name= to
    WebElement addressBox;
  @FindBy(name = "subjectbox")
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

  public void sendMail(String toAddress, String subject, String body) {
    //click on Compose button

    clickCompose();

    //enter TO address & Subject
    wait.until(ExpectedConditions.visibilityOf(addressBox));
    System.out.print("\nto address founded \n");
    addressBox.sendKeys(toAddress);
    subjectBox.sendKeys(subject);
    bobyTex.sendKeys(body);
    bobyTex.sendKeys(CONTROL, ENTER);


    //click Send button
    // clickSend();


  }

  public void clickCompose() {
    wait.until(ExpectedConditions.visibilityOf(composeBtn));
    composeBtn.click();
  }
 /* public void clickSend(){
    wait.until(ExpectedConditions.visibilityOf(sendBtn));
    sendBtn.click();
  }*/

  public WebElement searchMailBySubject(String subject) {
    WebElement result = null;
    List<WebElement> b = webDriver.findElements(By.xpath("//*[@class='y6']/span"));

    for (int i = 0; i < b.size(); i++) {
      System.out.println(b.get(i).getText());
      if (b.get(i).getText().equals(subject)) //to click on a specific mail.
      {
        result = b.get(i);
      }
    }
    return result;
  }

  public boolean containMailWithSubject(String subject) {
    return !(searchMailBySubject(subject) == null);
  }

  public void deleteMailBySubject(String subject) {
    WebElement mail = searchMailBySubject(subject);
    mail.click();
    clickOnDelete();
  }

  public void clickOnDelete() {
    wait.until(ExpectedConditions.visibilityOf(deleteBtn));
    deleteBtn.click();
  }

  public void showUser() {
    // webDriver.findElement(By.xpath( "//*[@class='gb_bb gbii']")).click();
    userBtn.click();

  }

  public void logout() {
    showUser();
    clickOnLogout();
    webDriver.manage().deleteAllCookies();
  }

  public void clickOnLogout() {
    wait.until(ExpectedConditions.visibilityOf(signOutBtn));
    signOutBtn.click();
  }
}
