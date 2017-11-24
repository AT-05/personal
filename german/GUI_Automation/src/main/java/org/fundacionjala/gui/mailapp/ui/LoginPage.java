package org.fundacionjala.gui.mailapp.ui;

import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * Created by German on 11/17/2017.
 */
public class LoginPage extends BasedPageObject {

  @FindBy(id = "identifierId")
  private WebElement email;

  @FindBy(id = "Passwd")
  private WebElement password;

  @FindBy(id = "passwordNext")
  private WebElement btnSignIn;

  @FindBy(xpath = "//span[@class='RveJvd snByac']")
  private WebElement btnNext;

  /**
   * <p>Constructor of the class.</p>
   */
  public LoginPage() {
    super();
  }

  /**
   * <p>This method sets email on the page.</p>
   *
   * @param email identifier
   */
  private void setEmail(String email) {
    this.email.clear();
    this.email.sendKeys(email);

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
   * @param email identifier
   * @return NextPage object.
   */
  public NextPage loginIdentifier(String email) {
    setEmail(email);
    clickNextBtn();
    return new NextPage();
  }

  /**
   * <p>This method wait for correct loading of pages.</p>
   *
   * @throws WebDriverException when pages doesn't load correctly.
   */
  @Override
  public void waitPageIsLoaded() throws WebDriverException {

  }
}
