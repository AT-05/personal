package at05ui.sampleapp.ui;

import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasedPageObject {

  @FindBy(id = "identifierId")
  WebElement email;

  @FindBy(id = "Passwd")
  WebElement password;

  @FindBy(id = "passwordNext")
  WebElement btnSignIn;

  @FindBy(xpath = "//span[@class='RveJvd snByac']")
  WebElement btnNext;

  public LoginPage() {
    super();
  }

  private void setEmail(String email) {
    this.email.clear();
    this.email.sendKeys(email);
    // btnNext.click();
  }

  private void clickNextBtn() {
    btnNext.click();
  }

  public NextPage loginIdentifier(String email) {
    setEmail(email);
    clickNextBtn();
    return new NextPage();
  }


  @Override
  public void waitPageIsLoaded() throws WebDriverException {

  }
}
