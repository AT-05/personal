package at05ui.sampleapp.ui;

import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MyAccountPage extends BasedPageObject {

  @FindBy(className = "logout")
  WebElement singOut;

  @FindBy(linkText = "My personal info")
  WebElement editPersonalInfo;

  public void clickSingOut() {
    singOut.click();
  }

  public boolean IAmMyAccount() {
    //this a small trap
    return webDriver.getTitle().equalsIgnoreCase("My account - My Store");


  }

  @Override
  public void waitPageIsLoaded() throws WebDriverException {

  }

  public EditPersonalInfoPage clickEditPersonalInfo() {
    editPersonalInfo.click();
    return new EditPersonalInfoPage();
  }
}
