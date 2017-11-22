package at05ui.sampleapp.ui;

import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

/**
 * Created by Administrator on 11/17/2017.
 */
public class NextPage extends BasedPageObject {

  @FindBy(name = "password")
  WebElement password;

  @FindBy(id = "passwordNext")
  WebElement btnNext;
  @FindBy(id = "forgotPassword")
  WebElement forgotPassword;

  public NextPage() {
    super();
  }

  @Override
  public void waitPageIsLoaded() throws WebDriverException {

  }

  private void setPassword(String password) {
    this.password.clear();
    this.password.sendKeys(password);
    // this.password.sendKeys(Keys.ENTER);

    //btnNext.click();
  }

  private void clickNextBtn() {
    btnNext.click();
  }


  public InboxPage nextPassword(String textPassword) {
    // wait.until(ExpectedConditions.elementToBeClickable(forgotPassword));
    wait.until(ExpectedConditions.visibilityOf(btnNext));
    setPassword(textPassword);
    clickNextBtn();
    return new InboxPage();
  }

}
