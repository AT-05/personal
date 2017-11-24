package org.fundacionjala.gui.mailapp.ui;

import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

/**
 * Created by German on 11/17/2017.
 */
public class NextPage extends BasedPageObject {

  @FindBy(name = "password")
  private WebElement password;

  @FindBy(id = "passwordNext")
  private WebElement btnNext;
  @FindBy(id = "forgotPassword")
  private WebElement forgotPassword;

  /**
   * <p>Constructor of the class.</p>
   */
  public NextPage() {
    super();
  }

  /**
   * <p>This method wait for correct loading of pages.</p>
   *
   * @throws WebDriverException when pages doesn't load correctly.
   */
  @Override
  public void waitPageIsLoaded() throws WebDriverException {
    wait.until(ExpectedConditions.visibilityOf(btnNext));
  }

  /**
   * <p>This method sets email on the page.</p>
   *
   * @param password of the user account
   */
  private void setPassword(String password) {
    this.password.clear();
    this.password.sendKeys(password);
    // this.password.sendKeys(Keys.ENTER);
    //btnNext.click();
  }

  /**
   * <p>This method makes click on button next.</p>
   */
  private void clickNextBtn() {
    btnNext.click();
  }

  /**
   * <p>This method is for login.</p>
   *
   * @param textPassword of the user account.
   * @return InboxPage.
   */
  public InboxPage nextPassword(String textPassword) {
    // wait.until(ExpectedConditions.elementToBeClickable(forgotPassword));
    wait.until(ExpectedConditions.visibilityOf(btnNext));
    setPassword(textPassword);
    clickNextBtn();
    return new InboxPage();
  }

}
