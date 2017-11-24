package org.fundacionjala.gui.mailapp.ui;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

import static org.openqa.selenium.Keys.CONTROL;
import static org.openqa.selenium.Keys.ENTER;

/**
 * Created by German on 11/17/2017.
 */
public class InboxPage extends BasedPageObject {
  @FindBy(id = ":21")
  private WebElement mainInbox;


  @FindBy(xpath = "//*[@class='T-I J-J5-Ji T-I-KE L3']")
  private WebElement composeBtn;

  @FindBy(xpath = ".//*[@id=':5']/div[2]/div[1]/div/div[2]/div[3]/div/div")
  private WebElement deleteBtn;
  @FindBy(xpath = "//*[@class='gb_bb gbii']")
  private WebElement userBtn;
  @FindBy(id = "gb_71")
  private WebElement signOutBtn;


  @FindBy(xpath = "//*[@id=\":8n\"]")
  private WebElement sendBtn;


  @FindBy(name = "to") //name= to
  private WebElement addressBox;
  @FindBy(name = "subjectbox")
  private WebElement subjectBox;
  @FindBy(xpath = "//*[@class='Am Al editable LW-avf']")
  private WebElement bobyTex;

  /**
   * <p>This method check for correct loading of pages.</p>
   *
   * @return boolean.
   */
  public boolean isInboxPage() {

    waitPageIsLoaded();
    return this.webDriver.getCurrentUrl().contains("inbox");
  }

  /**
   * <p>This method wait for correct loading of pages.</p>
   *
   * @throws WebDriverException when pages doesn't load correctly.
   */
  @Override
  public void waitPageIsLoaded() throws WebDriverException {
    wait.until(ExpectedConditions.urlContains("inbox"));
  }

  /**
   * <p>This method send a email.</p>
   *
   * @param toAddress is the address for to send the mail.
   * @param subject   is the subject of the mail.
   * @param body      is the body of the mail.
   */
  public void sendMail(String toAddress, String subject, String body) {
    //click on Compose button
    clickCompose();

    //enter TO address & Subject
    wait.until(ExpectedConditions.visibilityOf(addressBox));
    System.out.print("\nto address founded \n");
    addressBox.sendKeys(toAddress);
    subjectBox.sendKeys(subject);
    bobyTex.sendKeys(body);
    //Send keys
    bobyTex.sendKeys(CONTROL, ENTER);
  }

  /**
   * <p>This method wait for correct visibility of web element before to make click.</p>
   */
  public void clickCompose() {
    wait.until(ExpectedConditions.visibilityOf(composeBtn));
    composeBtn.click();
  }

  /**
   * <p>This method search mail by subject.</p>
   *
   * @param subject is the subject  of the mail.
   * @return WebElement.
   */
  public WebElement searchMailBySubject(String subject) {
    WebElement result = null;
    List<WebElement> b = webDriver.findElements(By.xpath("//*[@class='y6']/span"));

    for (int i = 0; i < b.size(); i++) {
      System.out.println(b.get(i).getText());
      if (b.get(i).getText().equals(subject)){

        result = b.get(i);
      }
    }
    return result;
  }

  /**
   * <p>This method check if match a mail with subject.</p>
   *
   * @param subject is the subject of the mail.
   * @return boolean.
   */
  public boolean containMailWithSubject(String subject) {
    return !(searchMailBySubject(subject) == null);
  }

  /**
   * <p>This method delete if  match a mail with subject.</p>
   *
   * @param subject is the subject of the mail.
   */
  public void deleteMailBySubject(String subject) {
    WebElement mail = searchMailBySubject(subject);
    mail.click();
    clickOnDelete();
  }

  /**
   * <p>This method wait for correct visibility of web element before to make click.</p>
   */
  public void clickOnDelete() {
    wait.until(ExpectedConditions.visibilityOf(deleteBtn));
    deleteBtn.click();
  }

  /**
   * <p>This method wait for correct visibility of web element before to make click.</p>
   */
  public void showUser() {
    // webDriver.findElement(By.xpath( "//*[@class='gb_bb gbii']")).click();
    userBtn.click();

  }

  /**
   * <p>This method is for logout.</p>
   */
  public void logout() {
    showUser();
    clickOnLogout();
    webDriver.manage().deleteAllCookies();
  }

  /**
   * <p>This method wait for correct visibility of web element before to make click.</p>
   */
  public void clickOnLogout() {
    wait.until(ExpectedConditions.visibilityOf(signOutBtn));
    signOutBtn.click();
  }
}
